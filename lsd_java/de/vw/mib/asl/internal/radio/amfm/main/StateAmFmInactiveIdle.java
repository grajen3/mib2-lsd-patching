/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextFactory;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.radio.Station;

public final class StateAmFmInactiveIdle
extends AbstractHsmState {
    private Logger logger = ServiceManager.logger;
    private final HsmTarget mTarget;
    private AmFmStation mCurrentStation;
    private int mLastModeBand;

    StateAmFmInactiveIdle(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmInactiveIdle is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmInactiveIdle[HSM_ENTRY]").log();
                break;
            }
            case 3: {
                AmFmFactory.getAslAmfmModelController().updateAmHdRadioState(3);
                AmFmFactory.getAslAmfmModelController().updateFmHdRadioState(3);
                if (HsmTarget.seekAbort) {
                    RadioData.getAmfmDatabase().setCurrentStation(RadioData.getAmfmDatabase().getStationBeforeSeekStarted());
                    HsmTarget.seekAbort = false;
                }
                if (RadioData.amFmTunerIsInitialized) {
                    AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                }
                RadiotextFactory.getRadioTextInstance().clearRtAndRtplus();
                if (!this.logger.isTraceEnabled(128)) break;
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("AMFM deactivated").log();
                break;
            }
            case 4: {
                break;
            }
            case 100240: {
                eventGeneric.setBoolean(0, false);
                eventGeneric.setResult(0);
                break;
            }
            case 100241: {
                this.trans(this.mTarget.stateAmFmBandSwitch);
                RadioData.getAmfmDatabase().updateStationListToBap();
                break;
            }
            case 4000025: {
                this.selectStationFMTA();
                break;
            }
            case 4000027: {
                this.selectStationFMTAabort();
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

    public void dsiAMFMTunerUpdateSelectedStation(Station station, int n) {
        if (!HsmTarget.isUpdateSelectedStationValid(n, station)) {
            return;
        }
        this.mTarget.logDsiAMFMTunerUpdateSelectedStation(station, "StateAmFmInactiveIdle");
        this.mTarget.checkDsiAMFMTunerUpdateSelectedStation(station);
    }

    public void dsiAMFMTunerUpdateSelectedStationHD(Station station, int n, int n2) {
        if (!HsmTarget.isUpdateSelectedStationValid(n2, station)) {
            return;
        }
        if (!station.isHd()) {
            station.serviceId = 0;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM).append("####-> dsiAMFMTunerUpdateSelectedStationHD in stateAmFmInActiveIdle").append("  Station: ").append(station.toString()).append("  hdStructure: ").append(n).append("  validflag: ").append(n2).log();
        }
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmInactiveIdle - dsiAMFMTunerUpdateSelectedStationHD - frequency: ").append(station.getFrequency()).append(" Name = ").append(station.name).append(" ShortName = ").append(station.shortNameHD).append(" HD = ").append(station.hd).append(" Service ID = ").append(station.serviceId).log();
        }
        if (AMFMUtil.isStationValidInBand(station)) {
            if (AmFmFactory.getAslAmfmPropertyManager().isStationTuneStarted()) {
                if (!AMFMUtil.isNARStationChanged(HsmTarget.selectedStationInfo, station) && !HsmTarget.stationTunedBySpeech) {
                    return;
                }
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
            }
            AmFmStation amFmStation = RadioData.getAmfmDatabase().handleStationInfoChange(station, HsmTarget.selectedStationInfo);
            HsmTarget.selectedStationInfo = station;
            RadioData.getAmfmDatabase().setCurrentStation(amFmStation);
            if (HsmTarget.stationTunedBySpeech) {
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().sendAmFmTuningResponse(new AmFmStation(station), 1);
                HsmTarget.stationTunedBySpeech = false;
            }
        }
    }

    private void selectStationFMTA() {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmInactiveIdle[ASL_SOUND_RADIO_SELECTSTATION_FMTA], Band=").append(RadioCurrentWaveband.get()).log();
            }
            this.mLastModeBand = RadioCurrentWaveband.get();
            if (!ManagerTarget.isRadioActive) {
                this.activateTunerAndSelectStation();
            } else if (this.mLastModeBand == 2) {
                DabMainApi.pauseTuner(this.mTarget.getTargetId());
                this.activateTunerAndSelectStation();
            } else {
                if (this.logger.isTraceEnabled(128)) {
                    this.logger.warn(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TA Slider in, unsupported radio band=").append(this.mLastModeBand).log();
                }
                HsmTarget.mIsTASliderActive = false;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void selectStationFMTAabort() {
        try {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmInactiveIdle[ASL_SOUND_RADIO_SELECTSTATION_FMTA] Band=").append(RadioCurrentWaveband.get()).log();
            }
            if (HsmTarget.mIsTASliderActive && !AnnouncementView.getTaActive()) {
                if (this.mLastModeBand == 1) {
                    AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                    HsmTarget.mIsTASliderActive = false;
                } else if (this.mLastModeBand == 0) {
                    RadioCurrentWaveband.set(0);
                    AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                    HsmTarget.mIsTASliderActive = false;
                } else if (this.mLastModeBand == 2) {
                    RadioCurrentWaveband.set(2);
                    AmFmDsiApi.setSwitchLinkingDeviceUsageMode(1);
                    HsmTarget.mIsTASliderActive = false;
                    if (ManagerTarget.isRadioActive) {
                        DabMainApi.restartTuner(this.mTarget.getTargetId());
                    }
                } else if (this.logger.isTraceEnabled(128)) {
                    this.logger.error(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TA Slider out, unsupported radio band=").append(this.mLastModeBand).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void activateTunerAndSelectStation() {
        AmFmDsiApi.setSwitchLinkingDeviceUsageMode(2);
        RadioCurrentWaveband.set(1);
        this.mCurrentStation = RadioData.getAmfmDatabase().getCurrentFMStation();
        if (null != this.mCurrentStation) {
            AmFmDsiApi.doSelectStation(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, -1786314496, this.mCurrentStation);
        }
        HsmTarget.mIsTASliderActive = true;
    }
}

