/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.seek.DsiSeekProxy;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekApi;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateChoosed;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateJumpPending;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateJumped;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateJumpingBack;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateNormal;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateNotChoosed;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficStateTop;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import de.vw.mib.log4mib.LogMessage;
import java.util.Iterator;
import java.util.Vector;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.TrafficWxEntry;

final class SatTrafficWxTarget
extends TargetHsmImpl {
    static final int EV_START_BROADCAST;
    static final int EV_STOP_BROADCAST;
    static final int EV_TUNE_RESULT;
    static final int EV_MARKET_CHOOSED;
    static final int EV_MARKET_UNCHOOSED;
    static final int P_ALERT;
    private final SatDb mDb;
    private final IAslPool mPool;
    private final DsiSeekProxy mProxy;
    private TrafficWxEntry[] mTrafficWxList = new TrafficWxEntry[0];
    private TrafficWxEntry mCurrentEntry;
    private int mCurrentIndex = -1;
    private boolean mBroadcastActive;
    private SeekAlert mAlert = null;
    final AbstractHsmState mStateTop;
    final AbstractHsmState mStateNormal;
    final AbstractHsmState mStateNotChoosed;
    final AbstractHsmState mStateChoosed;
    final AbstractHsmState mStateJumpPending;
    final AbstractHsmState mStateJumped;
    final AbstractHsmState mStateJumppingBack;

    public SatTrafficWxTarget(SatDb satDb, DsiSeekProxy dsiSeekProxy, Target target) {
        super(target.getMainObject());
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mProxy = dsiSeekProxy;
        this.mStateTop = new SatTrafficStateTop(this, null);
        this.mStateNotChoosed = new SatTrafficStateNotChoosed(this, this.mStateTop);
        this.mStateChoosed = new SatTrafficStateChoosed(this, this.mStateTop);
        this.mStateNormal = new SatTrafficStateNormal(this, this.mStateChoosed);
        this.mStateJumpPending = new SatTrafficStateJumpPending(this, this.mStateChoosed);
        this.mStateJumped = new SatTrafficStateJumped(this, this.mStateChoosed);
        this.mStateJumppingBack = new SatTrafficStateJumpingBack(this, this.mStateChoosed);
        GenericEvents genericEvents = target.getMainObject();
        EventDispatcherHSM eventDispatcherHSM = genericEvents.getEventDispatcher();
        int n = eventDispatcherHSM.getNextTargetId();
        String string = eventDispatcherHSM.getRandomTaskId();
        try {
            this.startHsmAndRegisterTarget(genericEvents, n, string, this.mStateTop);
        }
        catch (Exception exception) {
            this.mDb.getLogHandler().logError().append(exception).log();
        }
        this.hsm.verbose = false;
    }

    void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
        if (trafficWxEntryArray == null) {
            this.mTrafficWxList = new TrafficWxEntry[0];
        } else {
            this.mTrafficWxList = trafficWxEntryArray;
            this.mPool.setObjectArray(105, trafficWxEntryArray);
            if (null != trafficWxEntryArray && !TrafficApi.isTMSet()) {
                for (int i2 = 0; i2 < trafficWxEntryArray.length; ++i2) {
                    if (this.mPool.getInt(191) != trafficWxEntryArray[i2].getSeekID()) continue;
                    this.mPool.setInt(164, i2);
                    this.mPool.setString(159, trafficWxEntryArray[i2].getMarketName());
                    this.mPool.setString(160, trafficWxEntryArray[i2].getMarketNameAbbrevation());
                    TrafficApi.setTMSet(true);
                }
            } else {
                TrafficApi.setTMSet(false);
            }
        }
        this.updateTrafficMarketsToHmi();
        try {
            this.checkCurrent();
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    private void checkCurrent() {
        int n = this.mPool.getInt(164);
        if (n == -1 && this.mCurrentEntry != null) {
            for (int i2 = 0; i2 < this.mTrafficWxList.length; ++i2) {
                if (this.mTrafficWxList[i2] == null || this.mTrafficWxList[i2].seekID != this.mCurrentEntry.seekID) continue;
                this.setCurrent(i2);
                return;
            }
            this.setCurrent(-1);
        }
    }

    void setCurrent(int n) {
        SatSeekApi.setSeekDeletePressed(false);
        TrafficWxEntry trafficWxEntry = SatSeekApi.getIsTrafficSeekFailed() ? SatSeekApi.getLastActivatedTrafficEntry() : this.mCurrentEntry;
        if (null == trafficWxEntry && !SatSeekApi.getIsTrafficSeekFailed()) {
            int n2 = this.mPool.getInt(191);
            for (int i2 = 0; i2 < this.mTrafficWxList.length; ++i2) {
                if (this.mTrafficWxList[i2] == null || this.mTrafficWxList[i2].seekID != n2) continue;
                trafficWxEntry = this.mTrafficWxList[i2];
                SatSeekApi.setLastActivatedTrafficEntry(trafficWxEntry);
            }
        }
        this.mCurrentIndex = n;
        this.mCurrentEntry = n >= 0 && n < this.mTrafficWxList.length ? this.mTrafficWxList[n] : null;
        if (trafficWxEntry != null) {
            if (this.mCurrentEntry != null && trafficWxEntry.seekID != this.mCurrentEntry.seekID && SatSeekApi.getRetryCountTraffic() == 0) {
                this.mProxy.manageSeek(trafficWxEntry.seekID, 3);
                SatSeekApi.setSeekStarted(true);
                SatSeekApi.setTrafficSelected(false);
                SatSeekApi.setNewTrafficSeekID(this.mCurrentEntry.getSeekID());
                SatSeekApi.setTrafficRemoved(true);
            }
        } else if (this.mCurrentEntry != null) {
            this.activateNewSearch();
            this.mPool.setString(163, this.mCurrentEntry.getMarketName());
        }
        if (this.mCurrentEntry == null) {
            this.triggerMe(-1517944576);
        } else {
            this.triggerMe(-1534721792);
            this.mPool.setString(163, this.mCurrentEntry.getMarketName());
        }
    }

    void removeCurrentTraffic() {
        int n = this.mPool.getInt(191);
        if (n != -1) {
            this.mProxy.manageSeek(n, 3);
        }
    }

    private void activateNewSearch() {
        if (this.mCurrentEntry != null && SatSeekApi.getRetryCountTraffic() == 0) {
            SatSeekApi.setTrafficMarketClearedCompletely(false);
            SatSeekApi.setNewTrafficSeekID(this.mCurrentEntry.getSeekID());
            this.mProxy.manageSeek(this.mCurrentEntry.seekID, 1);
            SatSeekApi.setSeekStarted(true);
            SatSeekApi.setTrafficRemoved(false);
            SatSeekApi.setTrafficSelected(true);
            this.mPool.setInt(191, this.mCurrentEntry.getSeekID());
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null) {
                logMessage.append("Activate TrafficXw seek ").append(this.mCurrentEntry.seekID).append(" = ").append(this.mCurrentEntry.marketName).log();
            }
        } else {
            this.mDb.getLogHandler().logError().append("Should store TrafficWx seek, but there is no current entry.").log();
        }
    }

    void updateCurrentMarketToHmi() {
        if (this.mCurrentIndex != -1 && null != this.mCurrentEntry) {
            this.mPool.setInt(164, this.mCurrentIndex);
            this.mPool.setObject(187, this.mCurrentEntry);
            this.mPool.setString(159, this.mCurrentEntry.marketName);
            this.mPool.setString(160, this.mCurrentEntry.marketNameAbbrevation);
        }
    }

    private void updateTrafficMarketsToHmi() {
        SatModelApi satModelApi = this.mDb.getModelApi();
        this.mPool.setBoolean(178, true);
        satModelApi.updateTrafficMarketList(this.mTrafficWxList);
        this.mPool.setBoolean(178, false);
    }

    SatDb getDb() {
        return this.mDb;
    }

    boolean isBroadcastActive() {
        return this.mBroadcastActive;
    }

    void setAlert(SeekAlert seekAlert) {
        if (seekAlert.getAlertType() == 2) {
            this.mBroadcastActive = false;
            this.mAlert = null;
        } else {
            this.mBroadcastActive = true;
            this.mAlert = seekAlert;
        }
    }

    SeekAlert getAlert() {
        return this.mAlert;
    }

    private int getById(int n) {
        for (int i2 = 0; i2 < this.mTrafficWxList.length; ++i2) {
            if (this.mTrafficWxList[i2] == null || this.mTrafficWxList[i2].seekID != n) continue;
            return i2;
        }
        return -1;
    }

    boolean notifyStartSeekAlert(SeekAlert seekAlert) {
        int n = this.getById(seekAlert.seekID);
        if (n != -1) {
            EventGeneric eventGeneric = this.getEventFactory().newEvent();
            eventGeneric.setObject(0, seekAlert);
            this.triggerMe(eventGeneric, -1585053440);
            return true;
        }
        return false;
    }

    boolean notifyStopSeekAlert(SeekAlert seekAlert) {
        int n = this.getById(seekAlert.seekID);
        if (n != -1) {
            EventGeneric eventGeneric = this.getEventFactory().newEvent();
            eventGeneric.setObject(0, seekAlert);
            this.triggerMe(eventGeneric, -1568276224);
            return true;
        }
        return false;
    }

    boolean jump() {
        return false;
    }

    public void resetTrafficSettings() {
        SatSeekApi.setTrafficMarketClearedCompletely(true);
        this.removeCurrentTraffic();
        this.mPool.setInt(164, -1);
        this.mPool.setString(159, "");
        this.mPool.setString(160, "");
        this.mPool.setInt(173, 0);
        this.mPool.setInt(191, -1);
        SatSeekApi.setLastActivatedTrafficEntry(null);
        this.mCurrentEntry = null;
        TrafficApi.setTMSet(false);
    }

    public void storeCurrentTrafficEntry() {
        int n = this.mPool.getInt(191);
        for (int i2 = 0; i2 < this.mTrafficWxList.length; ++i2) {
            TrafficWxEntry trafficWxEntry;
            if (this.mTrafficWxList[i2] == null || this.mTrafficWxList[i2].seekID != n || null == (trafficWxEntry = this.mTrafficWxList[i2])) continue;
            SatSeekApi.setLastActivatedTrafficEntry(trafficWxEntry);
        }
    }

    public void restoreLastActiveTrafficEntry() {
        TrafficWxEntry trafficWxEntry;
        LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("restoreLastActiveTrafficEntry()").log();
        }
        if (null != (trafficWxEntry = SatSeekApi.getLastActivatedTrafficEntry()) && !SatSeekApi.isRestoreTrafficInitiated()) {
            for (int i2 = 0; i2 < this.mTrafficWxList.length; ++i2) {
                if (this.mTrafficWxList[i2] == null || this.mTrafficWxList[i2].seekID != trafficWxEntry.seekID) continue;
                this.mPool.setInt(164, i2);
            }
            this.mPool.setString(159, trafficWxEntry.getMarketName());
            this.mPool.setString(160, trafficWxEntry.getMarketNameAbbrevation());
            this.mPool.setInt(191, trafficWxEntry.getSeekID());
            if (SatSeekApi.isTrafficMarketRemovedSuccessfully()) {
                SatSeekApi.setSeekStarted(true);
                SatSeekApi.setRestoreTrafficInitiated(true);
                this.mProxy.manageSeek(trafficWxEntry.getSeekID(), 1);
                if (logMessage != null) {
                    logMessage.append("seek activation called in restoreLastAcvtieTrafficEntry()").log();
                }
            } else {
                SatSeekApi.setSeekStarted(false);
            }
        } else {
            SatSeekApi.setTrafficMarketClearedCompletely(true);
            this.mPool.setInt(164, -1);
            this.mPool.setString(159, "");
            this.mPool.setString(160, "");
            this.mPool.setInt(191, -1);
            SatSeekApi.setSeekStarted(false);
            SatSeekApi.setLastActivatedTrafficEntry(null);
            SatSeekApi.setRestoreTrafficInitiated(false);
            if (logMessage != null) {
                logMessage.append("seek activation called in restoreLastAcvtieTrafficEntry(). setLastActivatedTrafficEntry is set to NULL ").log();
            }
        }
    }

    public void processTMAlert() {
        Object object;
        Vector vector = SatDb.getInstance().getSeekApi().getSeekAlerts();
        boolean bl = false;
        TrafficApi.jumpCancelled = false;
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            object = (SeekAlert)iterator.next();
            if (((SeekAlert)object).seekID != this.mPool.getInt(191)) continue;
            this.notifyStartSeekAlert((SeekAlert)object);
            bl = true;
        }
        if (!bl) {
            this.mPool.setInt(173, 1);
        }
        if ((object = this.mDb.getLogHandler().getLogMsg()) != null) {
            object.append("SatTrafficWxTarget: processTMAlert - SEEKID_CHOSEN_TRAFFIC_MARKET : ").append(this.mPool.getInt(191)).append(" isTMAlertFound : ").append(bl).log();
        }
    }
}

