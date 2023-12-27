/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.Station;

public final class StateAmFmActiveTASeek
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private boolean tpAvailable = false;
    private AmFmStation mStartStation = new AmFmStation();
    private boolean mIsWrap = false;
    private int mWraps = 0;

    StateAmFmActiveTASeek(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveTASeek is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.startTimer(1804009728, (long)0, false);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                AmFmFactory.getAslAmfmModelController().updateTAEmergencyState(false);
                break;
            }
            case 100203: {
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 100002: {
                if (eventGeneric.getInt(1) == 1) break;
                if (this.mWraps >= 1) {
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                }
                if (this.tpAvailable) {
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                    break;
                }
                AmFmDsiApi.doAutoSeek(this.mTarget.getTargetId(), -1568276224, 1);
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
        this.mTarget.logDsiAMFMTunerUpdateSelectedStation(station, "StateAmFmActiveTASeek");
        if (!RadioCodingAdapter.isPiActivated()) {
            station.tp = false;
            station.ta = false;
        }
        AmFmProxyHelper.updateSelectedStation(this.mTarget.getTargetId(), station, n);
        AmFmStation amFmStation = new AmFmStation(station);
        this.tpAvailable = amFmStation.isTp();
        HsmTarget.selectedStationInfo = station;
        if (amFmStation.getFrequency() < this.mStartStation.getFrequency()) {
            this.mIsWrap = true;
        }
        if (this.mIsWrap && amFmStation.getFrequency() >= this.mStartStation.getFrequency()) {
            ++this.mWraps;
            this.mIsWrap = false;
        }
        if (amFmStation.getWaveband() != this.mStartStation.getWaveband()) {
            this.trans(this.mTarget.stateAmFmActiveIdle);
        }
    }

    public void dsiAMFMTunerUpdateSelectedStationHD(Station station, int n, int n2) {
        if (!HsmTarget.isUpdateSelectedStationValid(n2, station)) {
            return;
        }
        if (!station.isHd()) {
            station.serviceId = 0;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("StateAmFmActiveTASeek - dsiAMFMTunerUpdateSelectedStationHD - frequency: ").append(station.getFrequency()).append(" Name = ").append(station.name).append(" ShortName = ").append(station.shortNameHD).append(" HD = ").append(station.hd).append(" Service ID = ").append(station.serviceId).log();
        }
        if (AMFMUtil.isStationValidInBand(station)) {
            if (AmFmFactory.getAslAmfmPropertyManager().isStationTuneStarted()) {
                if (!AMFMUtil.isNARStationChanged(HsmTarget.selectedStationInfo, station)) {
                    return;
                }
                AmFmFactory.getAslAmfmPropertyManager().setStationTuneStarted(false);
            }
            AmFmProxyHelper.updateSelectedStation(this.mTarget.getTargetId(), station, n2);
            AmFmStation amFmStation = new AmFmStation(station);
            this.tpAvailable = amFmStation.isTp();
            RadioData.getAmfmDatabase().handleStationInfoChange(station, HsmTarget.selectedStationInfo);
            HsmTarget.selectedStationInfo = station;
            if (amFmStation.getFrequency() < this.mStartStation.getFrequency()) {
                this.mIsWrap = true;
            }
            if (this.mIsWrap && amFmStation.getFrequency() >= this.mStartStation.getFrequency()) {
                ++this.mWraps;
                this.mIsWrap = false;
            }
            if (amFmStation.getWaveband() != this.mStartStation.getWaveband()) {
                try {
                    this.trans(this.mTarget.stateAmFmActiveIdle);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }
}

