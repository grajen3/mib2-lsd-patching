/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashSet;
import org.dsi.ifc.radio.Station;

public final class StateAmFmActiveEmergencyScan
extends AbstractHsmState {
    private static final int SCAN_EXIT_DELAY_TIMER_DURATION;
    private final HsmTarget mTarget;
    private boolean foundSameFrequency = false;
    private boolean scanStopped = false;
    private HashSet tunedFrequencies;
    private Long oldFrequency = new Long(-1L);
    private AmFmStation lastStation = null;
    private Long selectedFrequency = new Long(-1L);

    StateAmFmActiveEmergencyScan(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveEmergencyScan is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
                if (null != amFmStation) {
                    this.foundSameFrequency = false;
                    this.scanStopped = false;
                    GuiApiTunerCommon.updateScanActive(true);
                    this.mTarget.broadcastScanModeToFriends(true);
                    this.mTarget.avoidRTandTPFlickering(true);
                    this.tunedFrequencies = new HashSet();
                    this.oldFrequency = new Long(-1L);
                    this.lastStation = new AmFmStation(amFmStation);
                    this.tunedFrequencies.add(new Long(this.lastStation.getFrequency()));
                    AmFmPresetApi.enablePresetHighlighting(false);
                    AmFmPresetApi.dehighlightPresets();
                    AmFmDsiApi.doAutoSeek(this.mTarget.getTargetId(), -1568276224, 1);
                    break;
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 100002: {
                if (eventGeneric.getInt(1) == 1 || this.foundSameFrequency) break;
                AmFmPresetApi.enablePresetHighlighting(true);
                AmFmPresetApi.autoCompare();
                AmFmPresetApi.enablePresetHighlighting(false);
                this.mTarget.startTimer(1770455296, (long)0, false);
                break;
            }
            case 100201: {
                AmFmDsiApi.doAutoSeek(this.mTarget.getTargetId(), -1568276224, 1);
                break;
            }
            case 100208: {
                if (null != this.lastStation && this.foundSameFrequency) {
                    AmFmDsiApi.selectStation(this.lastStation);
                }
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 1073743064: {
                AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
                this.scanStopped = true;
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 4: {
                if (!this.foundSameFrequency && !this.scanStopped) {
                    AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), false);
                }
                this.updateScanFalsetoGui();
                AmFmPresetApi.enablePresetHighlighting(true);
                AmFmPresetApi.autoCompare();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public HsmState dsiAMFMTunerUpdateSelectedStation(Station station, int n) {
        if (!HsmTarget.isUpdateSelectedStationValid(n, station)) {
            return null;
        }
        this.mTarget.logDsiAMFMTunerUpdateSelectedStation(station, "StateAmFmActiveEmergencyScan");
        if (null != station) {
            this.mTarget.checkDsiAMFMTunerUpdateSelectedStation(station);
            this.selectedFrequency = new Long(station.frequency);
            if (!this.foundSameFrequency && this.oldFrequency.longValue() != this.selectedFrequency.longValue()) {
                if (null != this.tunedFrequencies) {
                    if (this.tunedFrequencies.contains(this.selectedFrequency) && this.tunedFrequencies.size() > 5) {
                        this.foundSameFrequency = true;
                        AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), false);
                        this.updateScanFalsetoGui();
                        this.mTarget.startTimer(1887895808, (long)0, false);
                    } else {
                        this.tunedFrequencies.add(this.selectedFrequency);
                    }
                }
                this.oldFrequency = this.selectedFrequency;
            }
            if (this.foundSameFrequency && (long)this.lastStation.getFrequency() != station.frequency) {
                return null;
            }
            return this.myParent;
        }
        this.trans(this.mTarget.stateAmFmActiveIdle);
        return null;
    }

    public HsmState dsiAMFMTunerUpdateSelectedStationHD(Station station, int n, int n2) {
        if (!HsmTarget.isUpdateSelectedStationValid(n2, station)) {
            return null;
        }
        if (!station.isHd()) {
            station.serviceId = 0;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActiveEmergencyScan - dsiAMFMTunerUpdateSelectedStationHD - frequency: ").append(station.getFrequency()).append(" Name = ").append(station.name).append(" ShortName = ").append(station.shortNameHD).append(" HD = ").append(station.hd).append(" Service ID = ").append(station.serviceId).log();
        }
        if (AMFMUtil.isStationValidInBand(station)) {
            if (AmFmFactory.getAslAmfmPropertyManager().isStationTuneStarted()) {
                if (!AMFMUtil.isNARStationChanged(HsmTarget.selectedStationInfo, station) || RadioCurrentWaveband.get() != AMFMUtil.convertDSIBandConstantToHMIBandConstant(station.waveband)) {
                    return null;
                }
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
            }
            RadioData.getAmfmDatabase().handleStationInfoChange(station, HsmTarget.selectedStationInfo);
            HsmTarget.selectedStationInfo = station;
            this.selectedFrequency = new Long(station.frequency);
            if (!this.foundSameFrequency && this.oldFrequency.longValue() != this.selectedFrequency.longValue()) {
                if (null != this.tunedFrequencies) {
                    if (this.tunedFrequencies.contains(this.selectedFrequency) && this.tunedFrequencies.size() > 5) {
                        this.foundSameFrequency = true;
                        AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), false);
                        this.updateScanFalsetoGui();
                        this.mTarget.startTimer(1887895808, (long)0, false);
                    } else {
                        this.tunedFrequencies.add(this.selectedFrequency);
                    }
                }
                this.oldFrequency = this.selectedFrequency;
            }
            if (this.foundSameFrequency && (long)this.lastStation.getFrequency() != station.frequency) {
                return null;
            }
            return this.myParent;
        }
        return null;
    }

    private void updateScanFalsetoGui() {
        GuiApiTunerCommon.updateScanActive(false);
        this.mTarget.broadcastScanModeToFriends(false);
        this.mTarget.avoidRTandTPFlickering(false);
        this.mTarget.stopTimer(1770455296);
        this.mTarget.stopTimer(1887895808);
        if (null != this.tunedFrequencies) {
            this.tunedFrequencies.clear();
            this.tunedFrequencies = null;
        }
    }
}

