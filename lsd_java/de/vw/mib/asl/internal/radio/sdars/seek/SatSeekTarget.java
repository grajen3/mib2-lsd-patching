/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekApi;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekModel;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

final class SatSeekTarget
extends AbstractTarget {
    private final SatDb mDb;
    private final SatSeekModel mModel;

    SatSeekTarget(SatDb satDb, SatSeekModel satSeekModel) {
        super(satDb.getMainTarget().getMainObject());
        this.mDb = satDb;
        this.mModel = satSeekModel;
        String string = this.getEventDispatcher().getTaskId(satDb.getMainTarget().getTargetId());
        this.getEventDispatcher().registerTarget(this, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        SatDb.logEvent("Seek", eventGeneric);
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.addObserver(1963196480);
                this.addObserver(1979973696);
                this.addObserver(0x77040040);
                this.addObserver(2013528128);
                this.addObserver(1443102784);
                this.addObserver(1459880000);
                this.addObserver(2080636992);
                this.addObserver(2130968640);
                this.addObserver(0x64040040);
                this.addObserver(1594097728);
                this.addObserver(1560543296);
                break;
            }
            case 9: {
                this.removeObserver(1963196480);
                this.removeObserver(1979973696);
                this.removeObserver(0x77040040);
                this.removeObserver(2013528128);
                this.removeObserver(1443102784);
                this.removeObserver(1459880000);
                this.removeObserver(2080636992);
                this.removeObserver(2130968640);
                this.removeObserver(0x64040040);
                this.removeObserver(1594097728);
                this.removeObserver(1560543296);
                break;
            }
            case 1073742965: {
                this.mModel.storeArtist();
                break;
            }
            case 1073742966: {
                this.mModel.storeSong();
                break;
            }
            case 0x40000477: {
                this.mModel.storeTeamA();
                break;
            }
            case 1073742968: {
                this.mModel.storeTeamB();
                break;
            }
            case 1073742934: {
                int n = eventGeneric.getInt(0);
                this.mModel.getSeekEntries().deleteSeekEntryByUser(n);
                break;
            }
            case 1073742935: {
                this.mModel.getSeekEntries().deleteAllSeekEntries();
                break;
            }
            case 1073742972: {
                break;
            }
            case 1073742975: {
                StationInfo stationInfo;
                int n = this.mModel.getChannelNoInAlertPopup();
                if (n == 0 || (stationInfo = this.mDb.getChannels().getChannel(n)) == null) break;
                this.mDb.getTuneHandler().tuneChannel(15, stationInfo, false);
                break;
            }
            case 0x40000464: {
                boolean bl = eventGeneric.getBoolean(0);
                this.mDb.getPool().setBoolean(152, bl);
                break;
            }
            case 1073742943: {
                int n = eventGeneric.getInt(0);
                this.mModel.tuneAlertByIndex(n);
                break;
            }
            case 1073742941: {
                int n = eventGeneric.getInt(0);
                this.mModel.getSeekEntries().deleteSeekEntryByUser(n);
                int n2 = this.mDb.getPool().getInt(209);
                int n3 = this.mDb.getPool().getInt(210);
                if (n2 != -1 && n3 != -1) {
                    this.mModel.getSeekProxy().setSeekCommand(n2, n3, 1);
                    SatSeekApi.setSeekStarted(true);
                    SatSeekApi.setStoredSeekSid(n2);
                    SatSeekApi.setStoredSeekType(n3);
                    switch (n3) {
                        case 2: {
                            SatSeekModel.mLastSetSeekData = this.mModel.getMseekPossibilities().getPossible(2, 1);
                            break block0;
                        }
                        case 1: {
                            SatSeekModel.mLastSetSeekData = this.mModel.getMseekPossibilities().getPossible(4, 3);
                            break block0;
                        }
                        case 4: {
                            SatSeekModel.mLastSetSeekData = this.mModel.getMseekPossibilities().getPossible(6, 10);
                            break block0;
                        }
                        case 5: {
                            SatSeekModel.mLastSetSeekData = this.mModel.getMseekPossibilities().getPossible(8, 13);
                            break block0;
                        }
                    }
                    break;
                }
                this.mDb.sendHmiEvent(365306880);
                break;
            }
            case 100400: {
                LeagueEntry[] leagueEntryArray = (LeagueEntry[])eventGeneric.getObject(0);
                this.mModel.updateLeagueListInternal(leagueEntryArray);
                break;
            }
            case 100401: {
                TeamEntry[] teamEntryArray = (TeamEntry[])eventGeneric.getObject(0);
                this.mModel.updateTeamListInternal(teamEntryArray);
                break;
            }
            case 100402: {
                TrafficWxEntry[] trafficWxEntryArray = (TrafficWxEntry[])eventGeneric.getObject(0);
                this.mModel.updateTrafficWeatherListInternal(trafficWxEntryArray);
                break;
            }
            case 100403: {
                SeekAlert seekAlert = (SeekAlert)eventGeneric.getObject(0);
                this.mModel.updateSeekAlertInternal(seekAlert);
                break;
            }
            case 100404: {
                int n = eventGeneric.getInt(0);
                this.mModel.setSeekCommandResultInternal(n);
                break;
            }
            case 100405: {
                SeekPossibility seekPossibility = (SeekPossibility)eventGeneric.getObject(0);
                this.mModel.updateSeekPossibilityInternal(seekPossibility);
                break;
            }
            case 100406: {
                SeekEntry[] seekEntryArray = (SeekEntry[])eventGeneric.getObject(0);
                this.mModel.updateSeekListInternal(seekEntryArray);
                break;
            }
            case 100407: {
                if (!SatSeekModel.isRetryTimerRunning) break;
                this.stopTimer(931660032);
                SatSeekApi.setRetrySeekCount(0);
                SatSeekModel.isRetryTimerRunning = false;
                this.mDb.sendHmiEvent(365306880);
                this.mDb.getPool().setBoolean(203, false);
                this.mDb.getPool().setBoolean(205, false);
                SatSeekApi.setSeekStarted(false);
                break;
            }
            case 100408: {
                if (!SatSeekApi.getIsTrafficRetryTimerRunning()) break;
                this.stopTimer(948437248);
                SatSeekApi.setRetryCountTraffic(0);
                SatSeekApi.setTrafficRetryTimerRunning(false);
                this.mDb.sendHmiEvent(365306880);
                this.mDb.getTrafficApi().restoreLastActiveTrafficEntry();
                this.mDb.getPool().setBoolean(204, false);
                break;
            }
            default: {
                SatDb.logEvent("-Seek", eventGeneric);
            }
        }
    }
}

