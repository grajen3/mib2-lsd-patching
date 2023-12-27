/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.util.AudioConnectionUtils;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public final class StateAmFmActiveSeek
extends AbstractHsmState {
    private Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;
    public static final int SEEK_INVALID;
    public static final int SEEK_ACTIVE;
    public static final int SEEK_FINISHED;
    private static int seekStatus;

    StateAmFmActiveSeek(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveSeek is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("start state seek - direction: ").append(this.mTarget.mSeekMode).log();
                }
                GuiApiTunerCommon.updateSeekActive(true);
                AmFmDsiApi.doAutoSeek(this.mTarget.getTargetId(), -1568276224, this.mTarget.mSeekMode);
                AmFmFactory.getAslAmfmModelController().updateLogoInStationView(null);
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInFmHdStationLogosForKombi(null);
                break;
            }
            case 4: {
                GuiApiTunerCommon.updateSeekActive(false);
                this.mTarget.mSeekMode = 0;
                seekStatus = 2;
                AmFmPresetApi.autoCompare();
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("stop state seek").log();
                }
                AudioConnectionUtils.requestVolumeLock(RadioCurrentWaveband.get(), false, this.mTarget);
                break;
            }
            case 100002: {
                HsmTarget.seekAbort = false;
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 1073743002: 
            case 1073743014: 
            case 1073743037: 
            case 0x400004CC: 
            case 1073743053: {
                this.abort();
                return this.myParent;
            }
            case 1073743057: 
            case 1073743059: {
                this.abort();
                break;
            }
            case 1073743065: {
                if (this.mTarget.mManualMode) {
                    this.stop();
                    break;
                }
                this.abort();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void abort() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("seek abort").log();
        }
        AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
    }

    private void stop() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("seek stop").log();
        }
        AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), false);
    }

    public static void setSeekStatus(int n) {
        seekStatus = n;
    }

    public static boolean isSeekActive() {
        return seekStatus == 1;
    }

    static {
        seekStatus = 0;
    }
}

