/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.dsi.AbstractDsiState;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.sdars.StationInfo;

final class SatDsiStateSelectStation
extends AbstractDsiState {
    private int mTimeout = SatConfig.TIMEOUT_DSI_RESPONSE_SELECT_STATION;

    SatDsiStateSelectStation(SatDb satDb, SatDsiTarget satDsiTarget, HsmState hsmState) {
        super(satDb, satDsiTarget, satDsiTarget.getHsm(), "SelectStation", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(41, this.getName());
                int n = this.mPool.getInt(78);
                if (n == 0) {
                    this.mTimeout = SatConfig.TIMEOUT_SELECT_STATION_BEFORE_FIRST_AUDIO;
                    this.mPool.addListener(79, this.mTarget.getTargetId(), 210174208, false);
                    break;
                }
                this.mTimeout = this.mPool.getInt(57);
                break;
            }
            case 3: {
                EventGeneric eventGeneric2 = this.mTarget.getCurrentEvent();
                int n = eventGeneric2.getInt(0);
                short s = eventGeneric2.getShort(1);
                this.mTarget.setLastSID(s);
                this.mPool.setInt(16, 0);
                this.mPool.setInt(17, 0);
                this.mPool.setInt(18, s);
                StationInfo stationInfo = this.getChannels().getChannelBySID(s);
                if (stationInfo != null) {
                    this.mPool.setChannel(19, stationInfo);
                }
                eventGeneric2.setBlocked(true);
                this.mTarget.getSdarsTuner().selectStation(n, s);
                this.mTarget.startTimeout(this.mTimeout);
                this.mTarget.startTimer(126288128, (long)0, false);
                RadioServiceManager.getServiceManager().setSdarsDefaultOrLsmFreqYetTobeTuned(false);
                break;
            }
            case 4: {
                this.mTarget.sendAnswer();
                this.mTarget.stopTimeout();
                this.mTarget.stopTimer(126288128);
                this.mPool.removeListener(79, this.mTarget.getTargetId(), 210174208);
                break;
            }
            case 100103: {
                this.mPool.incInt(16);
                this.mTarget.startTimer(126288128, (long)0, false);
                break;
            }
            case 100104: {
                this.mTarget.error().append("DSI Timeout: after ").append(this.mTimeout).append(" ms for state ").append(this.getName()).log();
                this.mPool.setInt(17, 2000);
                this.mTarget.setResult(2000);
                this.mTarget.getCurrentEvent().setInt(2, 3);
                this.mTarget.transStateIdle();
                break;
            }
            case 100106: {
                int n = eventGeneric.getInt(0);
                if (n == 1) break;
                this.mPool.setInt(17, n);
                this.mTarget.setResult(0);
                this.mTarget.getCurrentEvent().setInt(2, n);
                this.mTarget.notifySelectionStatus(n);
                this.mTarget.transStateIdle();
                break;
            }
            case 100107: {
                int n = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                int n2 = eventGeneric.getInt(2);
                this.asyncException(n, string, n2);
                break;
            }
            case 100108: {
                IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)eventGeneric.getObject(0);
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                if (stationInfo == null || this.mTarget.getLastSID() != stationInfo.getSID()) break;
                this.mPool.setInt(17, 3);
                this.mTarget.setResult(0);
                this.mTarget.getCurrentEvent().setInt(2, 3);
                this.mTarget.transStateIdle();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void asyncException(int n, String string, int n2) {
        LogMessage logMessage = this.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("DSI ASYNC EXCEPTION").log();
        }
        this.mTarget.setResult(3);
        this.mTarget.transStateIdle();
        this.mPool.setInt(17, 2);
    }
}

