/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.AbstractSatTrafficState;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficWxTarget;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.StationInfo;

final class SatTrafficStateJumped
extends AbstractSatTrafficState {
    private StationInfo mLSM;
    private int mTrafficChannelSID;
    private boolean mTuned;
    int timerToNormalState = 1000;

    SatTrafficStateJumped(SatTrafficWxTarget satTrafficWxTarget, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget, "Jumped", abstractHsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("SatTrafficStateJumped is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(42, this.getName());
                this.mTuned = false;
                break;
            }
            case 3: {
                SeekAlert seekAlert = this.mTarget.getAlert();
                int n = this.mPool.getInt(191);
                if (seekAlert == null || TrafficApi.jumpCancelled || seekAlert.getSeekID() != n) break;
                this.mTrafficChannelSID = seekAlert.sID;
                StationInfo stationInfo = this.getChannels().getChannelBySID(this.mTrafficChannelSID);
                StationInfo stationInfo2 = this.mPool.getChannel(15);
                if (stationInfo == null) {
                    LogMessage logMessage = this.getLogHandler().getLogMsg();
                    if (logMessage != null) {
                        logMessage.append("Could not jump to channel SID=").append(this.mTrafficChannelSID).append(". Transition back to mormal state.").log();
                    }
                    return null;
                }
                if (stationInfo.getStationNumber() == stationInfo2.getStationNumber()) break;
                this.mLSM = this.getCurrentChannel();
                this.getTuneHandler().tuneChannel(14, stationInfo, false, this.mTarget.getTargetId(), -1551499008);
                this.mPool.setInt(173, 2);
                TrafficApi.jump = this.mTrafficChannelSID;
                TrafficApi.isJumped = true;
                break;
            }
            case 4: {
                this.mTarget.stopTimer(-1249509120);
                if (!this.mTuned || this.mLSM == null) break;
                this.getTuneHandler().tuneChannel(14, this.mLSM, false);
                break;
            }
            case 100003: {
                int n = eventGeneric.getResult();
                if (n != 0) {
                    LogMessage logMessage = this.getLogHandler().getLogMsg();
                    if (logMessage != null) {
                        logMessage.append("Error tuning to traffic channel SID=").append(this.mTrafficChannelSID).append(". Transition back to mormal state.").log();
                    }
                    this.trans(this.mTarget.mStateNormal);
                    break;
                }
                this.mTuned = true;
                break;
            }
            case 1073742936: {
                if (this.mLSM == null) break;
                this.getTuneHandler().tuneChannel(14, this.mLSM, false);
                this.mPool.setInt(173, 3);
                TrafficApi.jumpCancelled = true;
                this.mTarget.startTimer(-1249509120, (long)this.timerToNormalState, false);
                break;
            }
            case 1076141827: {
                TrafficApi.jumpCancelled = true;
                this.mPool.setInt(173, 4);
                this.mTarget.startTimer(-1249509120, (long)this.timerToNormalState, false);
                break;
            }
            case 1073742937: {
                this.mTarget.processTMAlert();
                break;
            }
            case 100021: {
                this.mPool.setInt(173, 0);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

