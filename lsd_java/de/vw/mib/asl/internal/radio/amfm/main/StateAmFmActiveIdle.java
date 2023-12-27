/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateAmFmActiveIdle
extends AbstractHsmState {
    private boolean mIsBandChanged = false;
    private final HsmTarget mTarget;

    StateAmFmActiveIdle(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveIdle is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!ServiceManager.logger.isTraceEnabled(128)) break;
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActiveIdle[HSM_ENTRY]").log();
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 4000025: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActiveIdle[ASL_SOUND_RADIO_SELECTSTATION_FMTA], Band=").append(RadioCurrentWaveband.get()).log();
                }
                if (RadioCurrentWaveband.isAm()) {
                    RadioCurrentWaveband.set(1);
                    this.mIsBandChanged = true;
                    AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentFMStation();
                    AmFmDsiApi.doSelectStation(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, -1786314496, amFmStation);
                    if (ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.warn(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TA Slider - AM, currFMStation=").append(amFmStation.getFrequency()).log();
                    }
                    HsmTarget.mIsTASliderActive = true;
                    break;
                }
                this.mTarget.triggerObserver(436813056, null);
                break;
            }
            case 4000027: {
                if (ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActiveIdle[ASL_SOUND_RADIO_SELECTSTATION_FMTA_ABORT] Band=").append(RadioCurrentWaveband.get()).log();
                }
                if (!HsmTarget.mIsTASliderActive || AnnouncementView.getTaActive()) break;
                if (this.mIsBandChanged) {
                    RadioCurrentWaveband.set(0);
                    AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentAMStation();
                    if (amFmStation != null) {
                        AmFmDsiApi.selectStation(amFmStation);
                    }
                }
                this.mIsBandChanged = false;
                HsmTarget.mIsTASliderActive = false;
                break;
            }
            case 100245: {
                this.mTarget.triggerObserver(436813056, null);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

