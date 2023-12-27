/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.seek.DsiSeekProxy;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekAlerts;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekApi;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekEntries;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekPossibilities;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekTarget;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import java.util.Vector;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

final class SatSeekModel
implements DSISDARSSeekListener {
    private static final String ARTIST;
    private static final String SONG;
    private static final String TEAM_A;
    private static final String TEAM_B;
    private final SatDb mDb;
    private final IAslPool mPool;
    private final SatSeekTarget mController;
    private DsiSeekProxy mSeekProxy;
    private final SatSeekAlerts mSeekAlerts;
    private final SatSeekEntries mSeekEntries;
    private final SatSeekPossibilities mSeekPossibilities;
    public static String mLastSetSeekData;
    public static boolean isRetryTimerRunning;
    private static final int MAXIMUMSEEKENTRY;
    private TeamEntry[] mTeamList;
    private LeagueEntry[] mLeagueList;

    SatSeekModel(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mController = new SatSeekTarget(this.mDb, this);
        this.mSeekAlerts = new SatSeekAlerts(this.mDb, this);
        this.mSeekEntries = new SatSeekEntries(this.mDb, this);
        this.mSeekPossibilities = new SatSeekPossibilities(this.mDb);
        this.mLeagueList = new LeagueEntry[0];
        this.mTeamList = new TeamEntry[0];
        this.sendNotifications();
    }

    void resetSettings() {
    }

    private void store(String string, int n, int n2, int n3) {
        if (SatSeekApi.getRetrySeekCount() == 0) {
            int n4 = this.mPool.getChannel(23).getSID();
            SatSeekApi.setTrafficSelected(false);
            SeekEntry[] seekEntryArray = (SeekEntry[])this.mPool.getObjectArray(102);
            if (seekEntryArray.length <= 29) {
                this.mSeekProxy.setSeekCommand(n4, n3, 1);
                SatSeekApi.setSeekStarted(true);
                SatSeekApi.setStoredSeekSid(n4);
                SatSeekApi.setStoredSeekType(n3);
                mLastSetSeekData = this.mSeekPossibilities.getPossible(n, n2);
                LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("Store seek type ").append(string).append("=>").append(mLastSetSeekData).append("< for SID=").append(n4).log();
                }
            } else {
                this.mPool.setInt(209, n4);
                this.mPool.setInt(210, n3);
                mLastSetSeekData = this.mSeekPossibilities.getPossible(n, n2);
                this.mDb.sendHmiEvent(210);
            }
        }
    }

    void storeArtist() {
        this.store("Artist", 2, 1, 2);
    }

    void storeSong() {
        this.store("Song", 4, 3, 1);
    }

    void storeTeamA() {
        this.store("TeamA", 6, 10, 4);
    }

    void storeTeamB() {
        this.store("TeamB", 8, 13, 5);
    }

    DsiSeekProxy getSeekProxy() {
        return this.mSeekProxy;
    }

    SatSeekPossibilities getMseekPossibilities() {
        return this.mSeekPossibilities;
    }

    void sendNotifications() {
        if (this.mSeekProxy == null) {
            this.mSeekProxy = new DsiSeekProxy(this, this.mController);
            TrafficApi.start(this.mDb, this.mSeekProxy, this.mController);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility, int n) {
        if (n == 1) {
            EventGeneric eventGeneric = this.mDb.newEvent();
            eventGeneric.setObject(0, seekPossibility);
            this.mController.triggerMe(eventGeneric, 898105600);
        }
    }

    void updateSeekPossibilityInternal(SeekPossibility seekPossibility) {
        this.mSeekPossibilities.updateSeekPossibility(seekPossibility);
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray, int n) {
        if (n == 1) {
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("SeekList has ").append(seekEntryArray.length).append(" entries").log();
            }
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                if (seekEntryArray[i2].typeOfContent != 4) continue;
                this.mPool.setInt(191, seekEntryArray[i2].seekID);
            }
            if ((null == seekEntryArray || seekEntryArray.length == 0) && this.mPool.getInt(191) != -1) {
                this.mPool.setInt(191, -1);
            }
            if (this.mPool.getInt(164) == -1 && !SatSeekApi.isTrafficMarketClearedCompletely()) {
                TrafficWxEntry[] trafficWxEntryArray = (TrafficWxEntry[])this.mPool.getObjectArray(105);
                if (null != trafficWxEntryArray && !TrafficApi.isTMSet()) {
                    for (int i3 = 0; i3 < trafficWxEntryArray.length; ++i3) {
                        if (this.mPool.getInt(191) != trafficWxEntryArray[i3].getSeekID()) continue;
                        this.mPool.setInt(164, i3);
                        this.mPool.setString(159, trafficWxEntryArray[i3].getMarketName());
                        this.mPool.setString(160, trafficWxEntryArray[i3].getMarketNameAbbrevation());
                        TrafficApi.setTMSet(true);
                    }
                } else {
                    TrafficApi.setTMSet(false);
                }
            }
            EventGeneric eventGeneric = this.mDb.newEvent();
            eventGeneric.setObject(0, seekEntryArray);
            this.mController.triggerMe(eventGeneric, 914882816);
        }
    }

    void updateSeekListInternal(SeekEntry[] seekEntryArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
            if (seekEntryArray[i2].getTypeOfContent() == 4) continue;
            String string = seekEntryArray[i2].getTitle1();
            String string2 = seekEntryArray[i2].getTitle2();
            if (string2.length() > 0 && seekEntryArray[i2].getTypeOfContent() != 3) {
                seekEntryArray[i2].title1 = seekEntryArray[i2].getTitle2();
                seekEntryArray[i2].title2 = string;
            }
            arrayList.add(seekEntryArray[i2]);
        }
        SeekEntry[] seekEntryArray2 = (SeekEntry[])arrayList.toArray(new SeekEntry[arrayList.size()]);
        this.mSeekEntries.updateSeekList(seekEntryArray2);
    }

    @Override
    public void updateLeagueList(LeagueEntry[] leagueEntryArray, int n) {
        if (n == 1) {
            EventGeneric eventGeneric = this.mDb.newEvent();
            eventGeneric.setObject(0, leagueEntryArray);
            this.mController.triggerMe(eventGeneric, 814219520);
        }
    }

    void updateLeagueListInternal(LeagueEntry[] leagueEntryArray) {
        this.mLeagueList = leagueEntryArray == null ? new LeagueEntry[0] : leagueEntryArray;
    }

    public void updateTeamList(TeamEntry[] teamEntryArray, int n) {
        if (n == 1) {
            EventGeneric eventGeneric = this.mDb.newEvent();
            eventGeneric.setObject(0, teamEntryArray);
            this.mController.triggerMe(eventGeneric, 830996736);
        }
    }

    void updateTeamListInternal(TeamEntry[] teamEntryArray) {
        this.mTeamList = teamEntryArray == null ? new TeamEntry[0] : teamEntryArray;
    }

    @Override
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray, int n) {
        if (n == 1) {
            EventGeneric eventGeneric = this.mDb.newEvent();
            eventGeneric.setObject(0, trafficWxEntryArray);
            this.mController.triggerMe(eventGeneric, 847773952);
        }
    }

    void updateTrafficWeatherListInternal(TrafficWxEntry[] trafficWxEntryArray) {
        this.mDb.getTrafficApi().updateTrafficWeatherList(trafficWxEntryArray);
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert, int n) {
        if (n == 1 && seekAlert != null) {
            EventGeneric eventGeneric = this.mDb.newEvent();
            eventGeneric.setObject(0, seekAlert);
            this.mController.triggerMe(eventGeneric, 864551168);
        }
    }

    void updateSeekAlertInternal(SeekAlert seekAlert) {
        this.mDb.getLogHandler().logSeekAlert(seekAlert);
        if (seekAlert.alertType == 1) {
            this.mSeekAlerts.appendAlert(seekAlert);
        } else if (seekAlert.alertType == 2) {
            this.mSeekAlerts.removeAlert(seekAlert);
        }
    }

    @Override
    public void setSeekCommandResult(int n) {
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setInt(0, n);
        this.mController.triggerMe(eventGeneric, 881328384);
    }

    public void setSeekCommandResultInternal(int n) {
        SatLogHandler satLogHandler = this.mDb.getLogHandler();
        LogMessage logMessage = satLogHandler.getLogMsg();
        if (SatSeekApi.isSeekStarted()) {
            this.mPool.setString(163, mLastSetSeekData);
            if (n == 1 && !SatSeekApi.isTrafficSelected()) {
                if (isRetryTimerRunning) {
                    this.mController.stopTimer(931660032);
                    isRetryTimerRunning = false;
                }
                int n2 = 211;
                this.mDb.sendHmiEvent(n2);
                SatSeekApi.setRetrySeekCount(0);
                this.mPool.setBoolean(203, false);
                this.mPool.setBoolean(205, false);
            } else if (SatSeekApi.getRetrySeekCount() <= 2) {
                if (logMessage != null) {
                    logMessage.append("Seek Retry Starts. RetryCountTraffic: ").append(SatSeekApi.getRetrySeekCount()).log();
                }
                SatSeekApi.setRetrySeekCount(SatSeekApi.getRetrySeekCount() + 1);
                this.mSeekProxy.setSeekCommand(SatSeekApi.getStoredSeekSid(), SatSeekApi.getStoredSeekType(), 1);
                this.mPool.setBoolean(203, true);
                this.mPool.setBoolean(205, true);
                if (!isRetryTimerRunning) {
                    this.mController.startTimer(931660032, (long)SatSeekApi.retrySeekCountResetTimer, false);
                    isRetryTimerRunning = true;
                }
            } else if (SatSeekApi.getRetrySeekCount() >= 3) {
                if (logMessage != null) {
                    logMessage.append("Seek Retry ends. RetryCountTraffic: ").append(SatSeekApi.getRetrySeekCount()).log();
                }
                if (isRetryTimerRunning) {
                    this.mController.stopTimer(931660032);
                    isRetryTimerRunning = false;
                }
                int n3 = 365306880;
                this.mDb.sendHmiEvent(n3);
                SatSeekApi.setRetrySeekCount(0);
                this.mPool.setBoolean(203, false);
                this.mPool.setBoolean(205, false);
                SatSeekApi.setSeekStarted(false);
            }
        }
    }

    @Override
    public void manageSeekResult(int n) {
        LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("manageSeekResult=").append(n).log();
        }
        if (!SatSeekApi.getIsSeekDeletePressed() && SatSeekApi.isSeekStarted()) {
            if (SatSeekApi.getIsTrafficSeekRemoved()) {
                if (n == 1) {
                    SatSeekApi.setTrafficMarketRemovedSuccessfully(true);
                    if (logMessage != null) {
                        logMessage.append("setTrafficMarketRemovedSuccessfully=").append(true).log();
                    }
                } else {
                    SatSeekApi.setTrafficMarketRemovedSuccessfully(false);
                    if (logMessage != null) {
                        logMessage.append("setTrafficMarketRemovedSuccessfully= ").append(false).log();
                    }
                    int n2 = 365306880;
                    this.mDb.sendHmiEvent(365306880);
                    SatSeekApi.setTrafficSeekFailed(true);
                    this.mDb.getTrafficApi().restoreLastActiveTrafficEntry();
                    return;
                }
                int n3 = SatSeekApi.getNewTrafficSeekID();
                SatSeekApi.setTrafficMarketClearedCompletely(false);
                this.mSeekProxy.manageSeek(n3, 1);
                if (logMessage != null) {
                    logMessage.append("newTrafficSeekID= ").append(n3).append("Activation send").log();
                }
                SatSeekApi.setRestoreTrafficInitiated(false);
                SatSeekApi.setTrafficRemoved(false);
                SatSeekApi.setTrafficSelected(true);
                this.mPool.setInt(191, n3);
            } else if (SatSeekApi.isTrafficSelected() && n == 1) {
                if (logMessage != null) {
                    logMessage.append("aResult= ").append(n).log();
                }
                if (SatSeekApi.getIsTrafficRetryTimerRunning()) {
                    this.mController.stopTimer(948437248);
                    SatSeekApi.setTrafficRetryTimerRunning(false);
                }
                SatSeekApi.setRetryCountTraffic(0);
                SatSeekApi.setTrafficSeekFailed(false);
                this.mDb.getTrafficApi().storeCurrentTrafficEntry();
                this.mPool.setBoolean(204, false);
            } else if (SatSeekApi.getRetryCountTraffic() <= 2) {
                if (logMessage != null) {
                    logMessage.append("Seek Retry starts. RetryCountTraffic: ").append(SatSeekApi.getRetryCountTraffic()).log();
                }
                SatSeekApi.setRetryCountTraffic(SatSeekApi.getRetryCountTraffic() + 1);
                int n4 = SatSeekApi.getNewTrafficSeekID();
                this.mSeekProxy.manageSeek(n4, 1);
                this.mPool.setBoolean(204, true);
                if (!SatSeekApi.getIsTrafficRetryTimerRunning()) {
                    this.mController.startTimer(948437248, (long)SatSeekApi.retrySeekCountResetTimer, false);
                    SatSeekApi.setTrafficRetryTimerRunning(true);
                }
            } else if (SatSeekApi.getRetryCountTraffic() >= 3) {
                if (logMessage != null) {
                    logMessage.append("Seek Retry ends. RetryCountTraffic: ").append(SatSeekApi.getRetryCountTraffic()).log();
                }
                if (SatSeekApi.getIsTrafficRetryTimerRunning()) {
                    this.mController.stopTimer(948437248);
                    SatSeekApi.setTrafficRetryTimerRunning(false);
                }
                int n5 = 365306880;
                this.mDb.sendHmiEvent(365306880);
                SatSeekApi.setRetryCountTraffic(0);
                SatSeekApi.setTrafficSeekFailed(true);
                this.mPool.setBoolean(204, false);
                SatSeekApi.setSeekStarted(false);
                this.mDb.getTrafficApi().restoreLastActiveTrafficEntry();
            }
        }
    }

    int getChannelNoInAlertPopup() {
        return this.mSeekAlerts.getChannelNoInAlertPopup();
    }

    void tuneAlertByIndex(int n) {
        this.mSeekAlerts.tuneAlertByIndex(n);
    }

    SatSeekEntries getSeekEntries() {
        return this.mSeekEntries;
    }

    TeamEntry[] getTeamList() {
        return this.mTeamList;
    }

    LeagueEntry[] getLeagueList() {
        return this.mLeagueList;
    }

    @Override
    public void leagues(LeagueEntry[] leagueEntryArray) {
    }

    @Override
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
    }

    @Override
    public void updateRegisteredTeams(TeamEntry[] teamEntryArray, int n) {
    }

    public Vector getSeekAlerts() {
        return this.mSeekAlerts.getSeekAlerts();
    }

    public void refreshAlertList() {
        this.mSeekAlerts.updateAlertList();
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    static {
        isRetryTimerRunning = false;
    }
}

