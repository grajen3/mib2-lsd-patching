/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmProxyHelper;
import de.vw.mib.asl.internal.radio.amfm.dsi.HsmAmFmDsi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public final class StateTop
extends AbstractHsmState {
    private final HsmAmFmDsi mTarget;

    StateTop(HsmAmFmDsi hsmAmFmDsi, String string, HsmState hsmState) {
        super(hsmAmFmDsi.getHsm(), string, hsmState);
        this.mTarget = hsmAmFmDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.trans(this.mTarget.stateInactive);
                break;
            }
            case 8: {
                this.mTarget.registerDSI();
                break;
            }
            case 9: {
                break;
            }
        }
        return hsmState;
    }

    public void dsiAMFMTunerForceAMUpdateStatus(int n) {
        AmFmProxyHelper.forceAMUpdateStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerForceFMUpdateStatus(int n) {
        AmFmProxyHelper.forceFMUpdateStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerPrepareTuningStatus(int n) {
        AmFmProxyHelper.prepareTuningStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerSeekStationStatus(int n) {
        AmFmProxyHelper.seekStationStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerSelectFrequencyStatus(int n) {
        AmFmProxyHelper.selectFrequencyStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerSelectStationStatus(int n) {
        AmFmProxyHelper.selectStationStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerSetAMBandRangeStatus(int n) {
        AmFmProxyHelper.setAMBandRangeStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerTuneFrequencyStepsStatus(int n) {
        AmFmProxyHelper.tuneFrequencyStepsStatus(this.mTarget.getTargetId(), n);
    }

    public void dsiAMFMTunerUpdateAFSwitchStatus(boolean bl, int n) {
        AmFmProxyHelper.updateAFSwitchStatus(this.mTarget.getTargetId(), bl, n);
    }

    public void dsiAMFMTunerUpdateDetectedDevice(int n, int n2) {
        AmFmProxyHelper.updateDetectedDevice(this.mTarget.getTargetId(), n, n2);
    }

    public void dsiAMFMTunerUpdateHdMode(int n, int n2) {
        AmFmProxyHelper.updateHdMode(this.mTarget.getTargetId(), n, n2);
    }

    public void dsiAMFMTunerUpdateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        AmFmProxyHelper.updateHdStationInfo(this.mTarget.getTargetId(), hdStationInfo, n);
    }

    public void dsiAMFMTunerUpdateHdStatus(int n, int n2) {
        AmFmProxyHelper.updateHdStatus(this.mTarget.getTargetId(), n, n2);
    }

    public void dsiAMFMTunerUpdateLinkingUsageStatus(int n, int n2) {
        AmFmProxyHelper.updateLinkingUsageStatus(this.mTarget.getTargetId(), n, n2);
    }

    public void dsiAMFMTunerUpdateMESwitchStatus(boolean bl, int n) {
        AmFmProxyHelper.updateMESwitchStatus(this.mTarget.getTargetId(), bl, n);
    }

    public void dsiAMFMTunerUpdatePiIgnoreSwitchStatus(boolean bl, int n) {
        AmFmProxyHelper.updatePiIgnoreSwitchStatus(this.mTarget.getTargetId(), bl, n);
    }

    public void dsiAMFMTunerUpdateRDSIgnoreSwitchStatus(boolean bl, int n) {
        AmFmProxyHelper.updateRDSIgnoreSwitchStatus(this.mTarget.getTargetId(), bl, n);
    }

    public void dsiAMFMTunerUpdateREGSwitchStatus(int n, int n2) {
        AmFmProxyHelper.updateREGSwitchStatus(this.mTarget.getTargetId(), n, n2);
    }

    public void dsiAMFMTunerUpdateRadioText(AMFMRadioText aMFMRadioText, int n) {
        AmFmProxyHelper.updateRadioText(this.mTarget.getTargetId(), aMFMRadioText, n);
    }

    public void dsiAMFMTunerUpdateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        AmFmProxyHelper.updateRadioTextPlus(this.mTarget.getTargetId(), nArray, stringArray, n);
    }

    public void dsiAMFMTunerUpdateSelectedStation(Station station, int n) {
        AmFmProxyHelper.updateSelectedStation(this.mTarget.getTargetId(), station, n);
    }

    public void dsiAMFMTunerUpdateStationListLW(Station[] stationArray, int n) {
        AmFmProxyHelper.updateStationListLW(this.mTarget.getTargetId(), stationArray, n);
    }

    public void dsiAMFMTunerUpdateStationListMW(Station[] stationArray, int n) {
        AmFmProxyHelper.updateStationListMW(this.mTarget.getTargetId(), stationArray, n);
    }

    public void dsiAMFMTunerUpdateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        AmFmProxyHelper.updateWavebandInfoList(this.mTarget.getTargetId(), wavebandInfoArray, n);
    }

    public void dsiAMFMTunerAsyncException(int n, String string, int n2) {
        AmFmProxyHelper.asyncException(this.mTarget.getTargetId(), n, string, n2);
    }
}

