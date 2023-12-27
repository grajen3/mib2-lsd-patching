/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateTop
extends AbstractHsmState {
    private final HsmDabDsi mTarget;

    StateTop(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi.getHsm(), string, hsmState);
        this.mTarget = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateTop is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 100237: {
                GuiApiDab.setUpdateStationInfoBlocked(false);
                GuiApiDab.updateCurrentStationInfo();
                break;
            }
            case 3: {
                this.trans(this.mTarget.stateInactive);
                break;
            }
            case 8: {
                this.mTarget.registerObservers();
                break;
            }
            case 9: {
                break;
            }
            case 100236: {
                this.mTarget.presetNameChangeRequested = true;
                DabMainApi.notifyTimeoutForServiceName(this.mTarget.currentTunedService);
                break;
            }
            case 100025: {
                HmiDabListViewApi.notifyJumpLmAborted();
                break;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerUpdateRadioText(DABRadioText dABRadioText, int n) {
        DabRadioTextApi.update(dABRadioText);
    }

    public void dsiDABTunerUpdateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
        DabRadioTextApi.update(dABRadioTextPlusInfo);
    }

    public void dsiDABTunerUpdateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
        if (null != frequencyInfoArray) {
            FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
            RadioData.getDabDatabase().mTunerState.setFrequencyList(frequencyInfoArray);
            if (frequencyInfo != null) {
                RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
            }
            this.mTarget.error(new StringBuffer().append("Now have these Frequencies: ").append(RadioData.getDabDatabase().mTunerState.getFrequencyList().length).toString());
            GuiApiDab.updateFrequencyMaxValue(frequencyInfoArray.length);
            RadioDabTraceUtil.dumpFrequencyList(this.mTarget.getTargetId());
            DabMainApi.notifyUpdateFrequencyList();
        } else {
            ServiceManager.logger.error(256, "Freq list is Empty");
        }
    }

    public void dsiDABTunerUpdateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        if (null != serviceInfoArray) {
            RadioData.getDabDatabase().mTunerState.setServiceList(serviceInfoArray);
            DabMainApi.notifyUpdateServiceList(serviceInfoArray);
            if (ServiceManager.logger.isTraceEnabled(256)) {
                RadioDabTraceUtil.dumpServiceList(this.mTarget.getTargetId());
            }
            RadioHASUpdater.updateDABServiceList(serviceInfoArray);
        }
    }

    public void dsiDABTunerUpdateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
        if (null != ensembleInfoArray) {
            RadioData.getDabDatabase().mTunerState.setEnsembleList(ensembleInfoArray);
            if (ServiceManager.logger.isTraceEnabled(256)) {
                RadioDabTraceUtil.dumpEnsembleList(this.mTarget.getTargetId());
            }
            RadioHASUpdater.updateDABEnsembleList(ensembleInfoArray);
        }
    }

    public void dsiDABTunerUpdateLinkingStatus(int n, int n2) {
        this.mTarget.linkingStatus = n;
    }

    public void dsiDABTunerUpdateSyncStatus(int n, int n2) {
        this.mTarget.mSyncStatus = n;
        if (SelectedStationHighlighting.getSelectedStationHighlightingIsActive()) {
            SelectedStationHighlighting.setNewMuteStatusAvailable(true);
        }
        if (n == 4) {
            if (!this.mTarget.presetNameChangeRequested && !this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -1937309440)) {
                this.mTarget.startTimer(-1937309440, (long)0, false);
            }
        } else if (this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -1937309440)) {
            this.mTarget.stopTimer(-1937309440);
        }
    }

    public void dsiDABTunerUpdateComponentList(ComponentInfo[] componentInfoArray, int n) {
        if (null != componentInfoArray) {
            RadioData.getDabDatabase().mTunerState.setComponentList(componentInfoArray);
            DabMainApi.notifyUpdateComponentList(componentInfoArray);
            RadioHASUpdater.updateDABComponentList(componentInfoArray);
        }
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        if (frequencyInfo != null && frequencyInfo.getFrequency() > 0L) {
            this.mTarget.currentUpdatedFrequency = frequencyInfo;
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
            this.mTarget.bufferedInTopstate = true;
        } else {
            this.mTarget.currentUpdatedFrequency = null;
        }
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo)) {
            return;
        }
        if (serviceInfo.ensID > 0 && serviceInfo.sID > 0L) {
            this.mTarget.currentTunedService = serviceInfo;
            this.mTarget.bufferedInTopstate = true;
        } else {
            this.mTarget.currentTunedService = null;
        }
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        if (ensembleInfo != null && ensembleInfo.getEnsID() > 0) {
            this.mTarget.currentUpdatedEnsemble = ensembleInfo;
            this.mTarget.bufferedInTopstate = true;
        } else {
            this.mTarget.currentUpdatedEnsemble = null;
        }
    }

    public void dsiDABTunerUpdateSelectedComponent(ComponentInfo componentInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkComponentAndName(componentInfo)) {
            return;
        }
        if (this.mTarget.currentTunedService != null) {
            if (componentInfo.ensID > 0 && componentInfo.sID > 0L && componentInfo.sCIDI > 0) {
                this.mTarget.currentUpdatedComponent = componentInfo;
                this.mTarget.bufferedInTopstate = true;
            } else {
                this.mTarget.currentUpdatedComponent = null;
            }
        }
    }

    public void dsiDABTunerUpdateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
        if (null != dataServiceInfoArray) {
            this.mTarget.updateDataServiceList(dataServiceInfoArray);
        }
    }
}

