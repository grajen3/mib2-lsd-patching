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
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateIdle
extends AbstractHsmState {
    private final HsmDabDsi mTarget;

    StateIdle(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi.getHsm(), string, hsmState);
        this.mTarget = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateIdle is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.mTarget.mNextEvent != null) {
                    EventGeneric eventGeneric2 = this.mTarget.mNextEvent;
                    this.mTarget.mNextEvent = null;
                    this.processEvent(eventGeneric2);
                    break;
                }
                this.handleSyncStatus(this.mTarget.mSyncStatus);
                this.handleLinkingStatus(this.mTarget.linkingStatus);
                break;
            }
            case 4: {
                this.mTarget.stopMuteTimer();
                this.mTarget.currentUpdatedEnsemble = null;
                this.mTarget.currentTunedService = null;
                this.mTarget.currentUpdatedFrequency = null;
                this.mTarget.currentUpdatedComponent = null;
                break;
            }
            default: {
                hsmState = this.processEvent(eventGeneric);
            }
        }
        return hsmState;
    }

    private HsmState processEvent(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 100002: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.setManualModeStepDirectionUp(true);
                this.trans(this.mTarget.stateManualStep);
                break;
            }
            case 100003: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.mTarget.setManualModeStepDirectionUp(false);
                this.trans(this.mTarget.stateManualStep);
                break;
            }
            case 100004: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateChangingFrequency);
                break;
            }
            case 100006: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateTargetSeek);
                break;
            }
            case 100009: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateTuneFrequency);
                break;
            }
            case 100010: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateScan);
                break;
            }
            case 100012: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateSelectService);
                break;
            }
            case 100021: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateSelectService);
                break;
            }
            case 100111: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateSelectService);
                break;
            }
            case 100110: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateStepService);
                break;
            }
            case 100016: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateSelectComponent);
                break;
            }
            case 100018: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateUpdateLearnMemory);
                break;
            }
            case 100106: {
                this.mTarget.mCurrentEvent = eventGeneric;
                this.trans(this.mTarget.stateDdsUsed);
                break;
            }
            case 100022: {
                this.mTarget.mCurrentEvent = eventGeneric;
                if (ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean()) {
                    this.trans(this.mTarget.stateJumpLearnMemory);
                    break;
                }
                this.trans(this.mTarget.stateSelectNextEnsemble);
                break;
            }
            case 100113: {
                this.trans(this.mTarget.stateDeactivate);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerUpdateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
        this.mTarget.updateDataServiceList(dataServiceInfoArray);
    }

    public void dsiDABTunerUpdateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        RadioData.getDabDatabase().mTunerState.setServiceList(serviceInfoArray);
        DabMainApi.notifyUpdateServiceList(serviceInfoArray);
        if (RadioData.getDabDatabase().mTunerState.getCurrentService() == null && this.mTarget.currentUpdatedEnsemble != null) {
            this.tuneFirstService(this.mTarget.currentUpdatedEnsemble);
        }
        if (ServiceManager.logger.isTraceEnabled(256)) {
            RadioDabTraceUtil.dumpServiceList(this.mTarget.getTargetId());
        }
    }

    public void dsiDABTunerUpdateLinkingStatus(int n, int n2) {
        this.mTarget.linkingStatus = n;
        this.handleLinkingStatus(this.mTarget.linkingStatus);
    }

    void handleLinkingStatus(int n) {
        RadioData.getDabDatabase().mTunerState.SetLinkingMode(n);
        HmiDabListViewApi.notifyLinkingState();
        GuiApiDab.updateServiceState(RadioData.getDabDatabase().mTunerState.getCurrentServiceState());
        if (RadioData.getDabDatabase().mTunerState.isServiceMuted() && n == 1) {
            DabRadioTextApi.signalLost();
        } else {
            DabRadioTextApi.signalAvailable();
        }
        RadioHASUpdater.updateCurrentDABFMLinking(n == 2);
    }

    public HsmState dsiDABTunerUpdateSyncStatus(int n, int n2) {
        this.handleSyncStatus(n);
        return this.getParent();
    }

    void handleSyncStatus(int n) {
        this.mTarget.notifyFriendsAboutSyncStatus(n);
        if (n == 1 || n == 2) {
            this.mTarget.startMuteTimer();
        } else {
            this.mTarget.stopMuteTimer();
            this.mTarget.mJumpLm = false;
        }
    }

    private void tuneFirstService(EnsembleInfo ensembleInfo) {
        if (this.mTarget.tuneFirstService(ensembleInfo, this.mTarget.currentUpdatedFrequency)) {
            this.mTarget.mCurrentEvent = this.mTarget.mNextEvent;
            this.mTarget.mNextEvent = null;
            this.trans(this.mTarget.stateSelectService);
        }
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        if (frequencyInfo != null && frequencyInfo.getFrequency() > 0L) {
            this.mTarget.currentUpdatedFrequency = frequencyInfo;
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
        } else {
            this.mTarget.currentUpdatedFrequency = null;
        }
        this.updateToGui();
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        if (ensembleInfo != null && ensembleInfo.getEnsID() > 0) {
            this.mTarget.currentUpdatedEnsemble = ensembleInfo;
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            if (serviceInfo == null) {
                this.tuneFirstService(this.mTarget.currentUpdatedEnsemble);
            }
        } else {
            this.mTarget.currentUpdatedEnsemble = null;
        }
        this.updateToGui();
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo)) {
            return;
        }
        this.mTarget.currentTunedService = serviceInfo.ensID > 0 && serviceInfo.sID > 0L ? serviceInfo : null;
        this.updateToGui();
    }

    public void dsiDABTunerUpdateSelectedComponent(ComponentInfo componentInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkComponentAndName(componentInfo)) {
            return;
        }
        if (this.mTarget.currentTunedService != null) {
            this.mTarget.currentUpdatedComponent = componentInfo.ensID > 0 && componentInfo.sID > 0L && componentInfo.sCIDI > 0 ? componentInfo : null;
            this.updateToGui();
        }
    }

    private void updateToGui() {
        DabMainApi.notifyNewStationSelected(this.mTarget.currentUpdatedFrequency, this.mTarget.currentUpdatedEnsemble, this.mTarget.currentTunedService, this.mTarget.currentUpdatedComponent);
    }
}

