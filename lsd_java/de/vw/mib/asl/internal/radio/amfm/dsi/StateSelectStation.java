/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.amfm.dsi.HsmAmFmDsi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.util.AbstractState;
import de.vw.mib.asl.internal.radio.util.StateMachineOwner;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public final class StateSelectStation
extends AbstractState {
    private Logger logger = ServiceManager.logger;
    private static final long TIMEOUT;
    private HsmAmFmDsi targetDsi = null;

    StateSelectStation(StateMachineOwner stateMachineOwner, String string, HsmState hsmState) {
        super(stateMachineOwner, string, hsmState);
        this.targetDsi = (HsmAmFmDsi)stateMachineOwner;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                EventGeneric eventGeneric2 = this.getRequest();
                int n = eventGeneric2.getInt(0);
                int n2 = eventGeneric2.getInt(1);
                int n3 = 0;
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                    n3 = eventGeneric2.getInt(2);
                }
                if (RadioData.amFmTunerIsInitialized) {
                    if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        if (HsmTarget.hdFeedBack) {
                            HsmTarget.waitingForStatusRunning = true;
                            HsmTarget.waitingForUpdateSelectedStation = true;
                            HsmTarget.mHdstruct = -1;
                            SelectedStationHighlighting.setTunedStationByApplication(null);
                            this.mOwner.getAmfmTuner().selectStation(n, n2, n3);
                            if (ServiceManager.logger.isTraceEnabled(128)) {
                                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> selectStation() in StateSelectStation ").append(" freq: ").append(n).append("  pi: ").append(n2).append("  subChannel: ").append(n3).log();
                            }
                        }
                    } else {
                        HsmTarget.mHdstruct = -1;
                        HsmTarget.waitingForStatusRunning = true;
                        HsmTarget.waitingForUpdateSelectedStation = true;
                        HsmTarget.seekAbort = false;
                        SelectedStationHighlighting.setTunedStationByApplication(null);
                        this.mOwner.getAmfmTuner().selectStation(n, n2, n3);
                    }
                }
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(true);
                break;
            }
            case 4: {
                this.sendAnswer();
                this.stopTimeout();
                HsmTarget.waitingForStatusRunning = false;
                break;
            }
            case 1073742979: {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> ACTIVATE_BAND event in StateSelectStation ").append("so transferring to state stateIdle").log();
                this.sendRequestAndGotoIdle(0);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void dsiAMFMTunerSelectStationStatus(int n) {
        AmFmProxyHelper.selectStationStatus(this.mOwner.getTargetId(), n);
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_TUNER).append("select station status: ").append(n).log();
        }
        switch (n) {
            case 1: {
                HsmTarget.waitingForStatusRunning = false;
                break;
            }
            case 4: {
                AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
                this.sendRequestAndGotoIdle(n);
                break;
            }
            case 2: {
                this.sendRequestAndGotoIdle(n);
                break;
            }
            default: {
                this.sendRequestAndGotoIdle(n);
            }
        }
    }

    private void sendRequestAndGotoIdle(int n) {
        this.getRequest().setResult(0);
        this.getRequest().setInt(3, n);
        this.transitionToIdle();
    }
}

