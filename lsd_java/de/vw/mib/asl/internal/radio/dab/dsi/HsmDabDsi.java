/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.RefreshTimer;
import de.vw.mib.asl.internal.radio.dab.dsi.StateActivate;
import de.vw.mib.asl.internal.radio.dab.dsi.StateActive;
import de.vw.mib.asl.internal.radio.dab.dsi.StateChangingFrequency;
import de.vw.mib.asl.internal.radio.dab.dsi.StateDdsUsed;
import de.vw.mib.asl.internal.radio.dab.dsi.StateDeactivate;
import de.vw.mib.asl.internal.radio.dab.dsi.StateFakeSearchingForHigh;
import de.vw.mib.asl.internal.radio.dab.dsi.StateIdle;
import de.vw.mib.asl.internal.radio.dab.dsi.StateInactive;
import de.vw.mib.asl.internal.radio.dab.dsi.StateJumpLearnMemory;
import de.vw.mib.asl.internal.radio.dab.dsi.StateManualStep;
import de.vw.mib.asl.internal.radio.dab.dsi.StateScan;
import de.vw.mib.asl.internal.radio.dab.dsi.StateSelectComponent;
import de.vw.mib.asl.internal.radio.dab.dsi.StateSelectNextEnsemble;
import de.vw.mib.asl.internal.radio.dab.dsi.StateSelectService;
import de.vw.mib.asl.internal.radio.dab.dsi.StateStepService;
import de.vw.mib.asl.internal.radio.dab.dsi.StateTargetSeek;
import de.vw.mib.asl.internal.radio.dab.dsi.StateTop;
import de.vw.mib.asl.internal.radio.dab.dsi.StateTuneFrequency;
import de.vw.mib.asl.internal.radio.dab.dsi.StateUpdateLearnMemory;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class HsmDabDsi
extends TargetHsmImpl {
    EventGeneric mNextEvent = null;
    HsmState mNextState = null;
    EventGeneric mCurrentEvent = null;
    public int mSyncStatus = 0;
    public int linkingStatus = 0;
    public ServiceInfo currentTunedService = null;
    public EnsembleInfo currentUpdatedEnsemble = null;
    public FrequencyInfo currentUpdatedFrequency = null;
    public ComponentInfo currentUpdatedComponent = null;
    public boolean bufferedInTopstate = false;
    public boolean presetNameChangeRequested = false;
    DSIDABTuner mDsiDabTuner;
    RefreshTimer mMuteTimer;
    boolean switchLinkingDone = false;
    boolean mJumpLm = false;
    private boolean manualModeStepDirectionUp = false;
    public final HsmState stateTop = new StateTop(this, "stateTop", null);
    public final HsmState stateInactive = new StateInactive(this, "stateInactive", this.stateTop);
    public final HsmState stateActive = new StateActive(this, "stateActive", this.stateTop);
    public final HsmState stateDeactivate = new StateDeactivate(this, "stateDeactivate", this.stateTop);
    public final HsmState stateActivate = new StateActivate(this, "stateActivate", this.stateTop);
    public final HsmState stateIdle = new StateIdle(this, "stateIdle", this.stateActive);
    public final HsmState stateTargetSeek = new StateTargetSeek(this, "stateTargetSeek", this.stateActive);
    public final HsmState stateJumpLearnMemory = new StateJumpLearnMemory(this, "stateJumpLearnMemory", this.stateActive);
    public final HsmState stateFakeSearchingForHigh = new StateFakeSearchingForHigh(this, "stateForStupidIdeas", this.stateActive);
    public final HsmState stateSelectNextEnsemble = new StateSelectNextEnsemble(this, "stateSelectNextEnsemble", this.stateActive);
    public final HsmState stateScan = new StateScan(this, "stateScan", this.stateActive);
    public final HsmState stateSelectService = new StateSelectService(this, "stateSelectService", this.stateActive);
    public final HsmState stateSelectComponent = new StateSelectComponent(this, "stateSelectComponent", this.stateActive);
    public final HsmState stateStepService = new StateStepService(this, "stateStepService", this.stateActive);
    public final HsmState stateUpdateLearnMemory = new StateUpdateLearnMemory(this, "stateUpdateLearnMemory", this.stateActive);
    public final HsmState stateManualStep = new StateManualStep(this, "stateManualStep", this.stateActive);
    public final HsmState stateTuneFrequency = new StateTuneFrequency(this, "stateTuneFrequency", this.stateActive);
    public final HsmState stateDdsUsed = new StateDdsUsed(this, "stateDdsUsed", this.stateActive);
    public final HsmState stateChangingFrequency = new StateChangingFrequency(this, "stateChangingFrequency", this.stateActive);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;

    HsmDabDsi(GenericEvents genericEvents, int n, String string) {
        super(genericEvents);
        this.startHsmAndRegisterTarget(genericEvents, n, string, this.stateTop);
        this.hsm.verbose = false;
        RadioData.getDabDatabase().mAudioManager.mTarget = this;
    }

    void tuneLastProgram() {
        EnsembleInfo ensembleInfo;
        if (this.mNextEvent == null && (ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble()) != null) {
            FrequencyInfo frequencyInfo = new FrequencyInfo(ensembleInfo.frequencyValue, ensembleInfo.frequencyLabel);
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            if (componentInfo != null) {
                this.mNextEvent = ServiceManager.mGenericEventFactory.newEvent();
                this.mNextEvent.setReceiverEventId(-1333395200);
                this.mNextEvent.setObject(0, componentInfo);
                DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, null);
            } else if (serviceInfo != null) {
                this.mNextEvent = ServiceManager.mGenericEventFactory.newEvent();
                this.mNextEvent.setReceiverEventId(-1400504064);
                this.mNextEvent.setObject(0, serviceInfo);
                DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, componentInfo);
            }
        }
    }

    boolean tuneLsm() {
        if (this.mNextEvent == null) {
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mPersistable.getCurrentService();
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mPersistable.getCurrentEnsemble();
            DabPreset dabPreset = RadioData.getDabDatabase().dabPresetList.getLastTunedPreset();
            ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mPersistable.getLinkingService();
            EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mPersistable.getLinkingEnsemble();
            if (serviceInfo2 != null) {
                this.mNextEvent = ServiceManager.mGenericEventFactory.newEvent();
                this.mNextEvent.setReceiverEventId(-1400504064);
                this.mNextEvent.setObject(0, serviceInfo2);
                DabMainApi.notifyCurrentStationInfo(new FrequencyInfo(ensembleInfo2.getFrequencyValue(), ensembleInfo2.getFrequencyLabel()), ensembleInfo2, serviceInfo2, null);
                return true;
            }
            if (dabPreset != null && DabTunerState.compare(dabPreset.getService(), serviceInfo) && dabPreset.mFrequency.frequency == (long)ensembleInfo.frequencyValue) {
                this.mNextEvent = ServiceManager.mGenericEventFactory.newEvent();
                this.mNextEvent.setReceiverEventId(-1249509120);
                this.mNextEvent.setObject(0, dabPreset);
                DabMainApi.notifyCurrentStationInfo(dabPreset.mFrequency, dabPreset.getEnsemble(), dabPreset.getService(), null);
                return true;
            }
            if (serviceInfo != null) {
                this.mNextEvent = ServiceManager.mGenericEventFactory.newEvent();
                this.mNextEvent.setReceiverEventId(-1400504064);
                this.mNextEvent.setObject(0, serviceInfo);
                DabMainApi.notifyCurrentStationInfo(new FrequencyInfo(ensembleInfo.getFrequencyValue(), ensembleInfo.getFrequencyLabel()), ensembleInfo, serviceInfo, null);
                return true;
            }
        }
        return false;
    }

    void sendTuneService(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        if (this.mNextEvent == null) {
            if (null != ensembleInfo) {
                ensembleInfo.fullName = ensembleInfo.fullName.trim();
            }
            GuiApiDab.updateCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, null);
            this.mNextEvent = ServiceManager.mGenericEventFactory.newEvent();
            this.mNextEvent.setReceiverEventId(260505856);
            this.mNextEvent.setObject(0, serviceInfo);
            this.mNextEvent.setObject(1, frequencyInfo);
            DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, null);
        }
    }

    boolean tuneFirstService(EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo);
        if (serviceInfoArray.length > 0 && serviceInfoArray[0] != null) {
            this.sendTuneService(serviceInfoArray[0], ensembleInfo, frequencyInfo);
            return true;
        }
        return false;
    }

    boolean tuneLastService(EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo);
        if (serviceInfoArray.length > 0) {
            this.sendTuneService(serviceInfoArray[serviceInfoArray.length - 1], ensembleInfo, frequencyInfo);
            return true;
        }
        return false;
    }

    void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        RadioData.getDabDatabase().mTunerState.mDataServiceList = dataServiceInfoArray;
        DabMainApi.notifyUpdateDataServiceList();
    }

    void setCurrentService(ServiceInfo serviceInfo, boolean bl) {
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
        if (ensembleInfo == null) {
            RadioDabTraceUtil.errorLogDab("ENSEMBLELIST AND SERVICELIST NOT CONSISTENT -> missing ensemble in ensemblelist");
            ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            if (ensembleInfo == null || !DabTunerState.compare(serviceInfo, ensembleInfo)) {
                RadioDabTraceUtil.errorLogDab("ENSEMBLELIST AND SERVICELIST NOT CONSISTENT -> using current ensemble failed");
                return;
            }
        }
        if (bl) {
            RadioData.getDabDatabase().mTunerState.resetReceptionState(ensembleInfo);
        }
        DabMainApi.notifyCurrentStationInfo(new FrequencyInfo(ensembleInfo.getFrequencyValue(), ensembleInfo.getFrequencyLabel()), ensembleInfo, serviceInfo, null);
        DabRadioSlsApi.notifyStationSelected();
    }

    void setCurrentComponent(ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(componentInfo.ensID, componentInfo.ensECC);
        RadioData.getDabDatabase().mTunerState.resetReceptionState(ensembleInfo);
        DabMainApi.notifyCurrentStationInfo(new FrequencyInfo(ensembleInfo.getFrequencyValue(), ensembleInfo.getFrequencyLabel()), ensembleInfo, serviceInfo, componentInfo);
        DabRadioSlsApi.notifyStationSelected();
    }

    void setCurrentPreset(int n) {
        RadioData.getDabDatabase().mTunerState.setCurrentComponent(null);
        DabPreset dabPreset = RadioData.getDabDatabase().dabPresetList.getPreset(n);
        RadioData.getDabDatabase().mTunerState.resetReceptionState(dabPreset.getEnsemble());
        RadioData.getDabDatabase().dabPresetList.setCurrentSelectedPreset(dabPreset);
        DabMainApi.notifyCurrentPreset(n);
        DabRadioSlsApi.notifyStationChanging();
        DabRadioTextApi.newProgram(dabPreset.getService().sID);
    }

    void registerObservers() {
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        this.mDsiDabTuner = (DSIDABTuner)dSIServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = HsmDabDsi.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner);
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmDabDsi.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener);
        dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmDabDsi.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener, dSIListener);
        int[] nArray = new int[]{1, 4, 2, 3, 9, 5, 6, 7, 8, 10, 33, 12, 22, 11, 27, 19, 18};
        this.mDsiDabTuner.setNotification(nArray, dSIListener);
    }

    int tuneStoredPreset(DabPreset dabPreset) {
        if (null == dabPreset) {
            ServiceManager.logger.error(256).append("HsmDabDsi - tuneStoredPreset() - null == preset").log();
            return 6;
        }
        RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
        RadioData.getDabDatabase().mTunerState.resetLinkingStatus();
        ServiceInfo serviceInfo = dabPreset.getService();
        RadioDataApi.requestRadioDabStationLogos(new ServiceInfo[]{serviceInfo}, 6);
        if (dabPreset.mFrequency != null) {
            this.mDsiDabTuner.selectService(6, serviceInfo.sID, serviceInfo.ensID, serviceInfo.ensECC, 0, 0, dabPreset.mFrequency.getFrequency());
            return 6;
        }
        this.mDsiDabTuner.selectService(2, serviceInfo.sID, serviceInfo.ensID, serviceInfo.ensECC, 0, 0, 0L);
        return 2;
    }

    void tuneServiceByFrequency(ServiceInfo serviceInfo, FrequencyInfo frequencyInfo) {
        if (null == serviceInfo) {
            ServiceManager.logger.error(256).append("HsmDabDsi - tuneServiceByFrequency() - null == service").log();
            return;
        }
        if (null == frequencyInfo) {
            ServiceManager.logger.error(256).append("HsmDabDsi - tuneServiceByFrequency() - null == frequency").log();
            return;
        }
        RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
        RadioData.getDabDatabase().mTunerState.resetLinkingStatus();
        this.mDsiDabTuner.selectService(6, serviceInfo.sID, serviceInfo.ensID, serviceInfo.ensECC, 0, 0, frequencyInfo.getFrequency());
        RadioDataApi.requestRadioDabStationLogos(new ServiceInfo[]{serviceInfo}, 6);
    }

    void tuneComponent(ComponentInfo componentInfo) {
        RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
        RadioData.getDabDatabase().mTunerState.resetLinkingStatus();
        this.mDsiDabTuner.selectService(3, componentInfo.sID, componentInfo.ensID, componentInfo.ensECC, componentInfo.sCIDI, 0, 0L);
    }

    public void tuneService(ServiceInfo serviceInfo) {
        RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
        RadioData.getDabDatabase().mTunerState.resetLinkingStatus();
        this.mDsiDabTuner.selectService(2, serviceInfo.sID, serviceInfo.ensID, serviceInfo.ensECC, 0, 0, 0L);
        RadioDataApi.requestRadioDabStationLogos(new ServiceInfo[]{serviceInfo}, 6);
    }

    String seekModesToString(int n) {
        String string;
        switch (n) {
            case 10: {
                string = "DSIDABTuner.SEEKSERVICEMODE_ENSEMBLE_UP_NO_SERVICE_SELECT";
                break;
            }
            case 11: {
                string = "DSIDABTuner.SEEKSERVICEMODE_ENSEMBLE_DOWN_NO_SERVICE_SELECT";
                break;
            }
            case 6: {
                string = "DSIDABTuner.SEEKSERVICEMODE_ENSEMBLE_UP";
                break;
            }
            case 7: {
                string = "DSIDABTuner.SEEKSERVICEMODE_ENSEMBLE_DOWN";
                break;
            }
            case 8: {
                string = "DSIDABTuner.SEEKSERVICEMODE_ENSEMBLE_JUMP_LM_UP_NO_SERVICE_SELECT";
                break;
            }
            case 9: {
                string = "DSIDABTuner.SEEKSERVICEMODE_ENSEMBLE_JUMP_LM_DOWN_NO_SERVICE_SELECT";
                break;
            }
            case 1: {
                string = "DSIDABTuner.SEEKSERVICEMODE_AUTO_UP";
                break;
            }
            case 2: {
                string = "DSIDABTuner.SEEKSERVICEMODE_AUTO_DOWN";
                break;
            }
            case 3: {
                string = "DSIDABTuner.SEEKSERVICEMODE_SCAN_UP";
                break;
            }
            case 5: {
                string = "DSIDABTuner.SEEKSERVICEMODE_SCAN_UP_5_SECONDS";
                break;
            }
            default: {
                string = "DSIDABTuner.SEEKSERVICEMODE_UNDEFINED";
            }
        }
        return string;
    }

    String tuneEnsembleStatusToString(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_ABORTED";
                break;
            }
            case 6: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_FAILURE";
                break;
            }
            case 3: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_FINISHED";
                break;
            }
            case 1: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_RUNNING";
                break;
            }
            case 0: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_UNDEFINED";
                break;
            }
            case 4: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_WRONG_FREQUENCY";
                break;
            }
            case 5: {
                string = "DSIDABTuner.TUNEENSEMBLESTATUS_WRONG_FREQUENCYLABEL";
                break;
            }
            default: {
                string = new StringBuffer().append("unknown status: ").append(n).toString();
            }
        }
        return string;
    }

    void startMuteTimer() {
        if (this.mMuteTimer == null && !this.mJumpLm) {
            this.mMuteTimer = new RefreshTimer(this, -1199177472, 0);
            this.mMuteTimer.refresh();
        }
    }

    void stopMuteTimer() {
        if (this.mMuteTimer != null) {
            this.mMuteTimer.stopTimer();
        }
        this.mMuteTimer = null;
    }

    void notifyFriendsAboutSyncStatus(int n) {
        DabMainApi.notifySyncStatus(n);
        boolean bl = n != 4;
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1302528000, eventGeneric);
    }

    void sendResult(EventGeneric eventGeneric, int n) {
        if (eventGeneric != null && eventGeneric.isBlocked()) {
            eventGeneric.setResult(n);
            this.sendBack(eventGeneric);
        }
    }

    public boolean isManualModeStepDirectionUp() {
        return this.manualModeStepDirectionUp;
    }

    public void setManualModeStepDirectionUp(boolean bl) {
        this.manualModeStepDirectionUp = bl;
    }

    void notifySpeechAboutListUpdate() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

