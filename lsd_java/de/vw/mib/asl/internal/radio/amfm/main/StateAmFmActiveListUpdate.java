/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateAmFmActiveListUpdate
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private boolean mReady = false;
    private static boolean listUpdateIsActive = false;
    private int currentWaveband = 0;

    StateAmFmActiveListUpdate(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveListUpdate is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_LIST_UPDATE).append("StateAmFmActiveListUpdate HSM_START").log();
                }
                this.currentWaveband = RadioCurrentWaveband.get();
                this.mReady = false;
                AmFmFactory.getAslAmfmModelController().updateListState(1);
                if (this.currentWaveband == 0) {
                    if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        AudioConnectionUtils.requestMuteAndVolumeLockForBand(true, this.mTarget, 0);
                    }
                    AmFmDsiApi.doForceAmUpdate(this.mTarget.getTargetId(), -1467612928);
                    listUpdateIsActive = true;
                    break;
                }
                if (this.currentWaveband == 1) {
                    AmFmDsiApi.doForceFmUpdate(this.mTarget.getTargetId(), -1467612928);
                    listUpdateIsActive = true;
                    break;
                }
                this.trans(this.mTarget.getHsm().getPreviousState());
                break;
            }
            case 4: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_LIST_UPDATE).append("StateAmFmActiveListUpdate HSM_EXIT").log();
                }
                if (!this.mReady) {
                    if (this.currentWaveband == 0) {
                        AmFmDsiApi.abortAmUpdate(this.mTarget.getTargetId());
                    } else if (this.currentWaveband == 1) {
                        AmFmDsiApi.abortFmUpdate(this.mTarget.getTargetId());
                    }
                }
                AmFmFactory.getAslAmfmModelController().updateListState(0);
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2) && this.currentWaveband == 0) {
                    AudioConnectionUtils.requestMuteAndVolumeLockForBand(false, this.mTarget, 0);
                }
                listUpdateIsActive = false;
                break;
            }
            case 100008: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_LIST_UPDATE).append("StateAmFmActiveListUpdate EV_AMFM_ANSWER_UPDATE_STATION_LIST").log();
                }
                this.mReady = true;
                this.trans(this.mTarget.getHsm().getPreviousState());
                break;
            }
            case 0x40000499: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_LIST_UPDATE).append("StateAmFmActiveListUpdate ASL_RADIO_CANCEL_UPDATE_STATION_LIST").log();
                }
                if (this.currentWaveband == 0) {
                    if (!ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                        AudioConnectionUtils.requestMuteAndVolumeLockForBand(false, this.mTarget, 0);
                    }
                    AmFmDsiApi.abortAmUpdate(this.mTarget.getTargetId());
                    break;
                }
                if (this.currentWaveband != 1) break;
                AmFmDsiApi.abortFmUpdate(this.mTarget.getTargetId());
                break;
            }
            case 1073743009: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_LIST_UPDATE).append("StateAmFmActiveListUpdate ASL_RADIO_EXIT_STATION_LIST").log();
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public static boolean isListUpdateActive() {
        return listUpdateIsActive;
    }
}

