/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.radiotext2.DabRadioTextApi;
import de.vw.mib.asl.internal.radio.dab.slideshow.DabRadioSlsApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateStepService
extends AbstractState {
    private static final long TIMEOUT;
    private boolean mStepWaiting = false;
    private DabPreset mWaitingPreset = null;
    private ServiceInfo mWaitingService = null;
    private ComponentInfo mWaitingComponent = null;
    EnsembleInfo mEnsemble = null;
    ComponentInfo mComponent = null;
    private boolean mNext;
    private int mMode = 0;
    private boolean mJumpLmSupported = true;

    public StateStepService(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateStepService is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mJumpLmSupported = ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean();
                boolean bl = this.mTarget.mCurrentEvent.getBoolean(0);
                if (AmfmScopeOfArrowKeys.get() == 1) {
                    if (this.mTarget.mJumpLm) {
                        if (ServiceManager.configManagerDiag.getTUNERDABsupportsJumpLmBoolean()) {
                            this.jumpLM(bl);
                            break;
                        }
                        if (this.tuneNextEnsemble(bl)) break;
                        this.trans(this.mTarget.stateFakeSearchingForHigh);
                        break;
                    }
                    ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                    if (serviceInfo != null) {
                        ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
                        if (componentInfo != null) {
                            ComponentInfo componentInfo2 = this.getNextComponent(bl, serviceInfo, componentInfo);
                            if (componentInfo2 != null) {
                                this.mTarget.setCurrentComponent(serviceInfo, componentInfo2);
                                this.mMode = 3;
                                this.mTarget.tuneComponent(componentInfo2);
                                break;
                            }
                            this.mTarget.setCurrentService(serviceInfo, true);
                            this.mMode = 2;
                            this.mTarget.tuneService(serviceInfo);
                            break;
                        }
                        ServiceInfo serviceInfo2 = this.getNextService(bl, serviceInfo);
                        if (serviceInfo2 != null) {
                            this.mTarget.setCurrentService(serviceInfo2, true);
                            this.mMode = 2;
                            this.mTarget.tuneService(serviceInfo2);
                            break;
                        }
                        if (this.mJumpLmSupported) {
                            this.jumpLM(bl);
                            break;
                        }
                        this.trans(this.mTarget.stateFakeSearchingForHigh);
                        break;
                    }
                    if (this.mJumpLmSupported) {
                        this.jumpLM(bl);
                        break;
                    }
                    ServiceInfo serviceInfo3 = this.getNearestService(bl);
                    if (serviceInfo3 != null) {
                        this.mTarget.setCurrentService(serviceInfo3, true);
                        this.mMode = 2;
                        this.mTarget.tuneService(serviceInfo3);
                        break;
                    }
                    this.trans(this.mTarget.stateFakeSearchingForHigh);
                    break;
                }
                int n = this.getPresetIndex(bl);
                if (n > -1) {
                    this.mMode = this.mTarget.tuneStoredPreset(RadioData.getDabDatabase().dabPresetList.getPreset(n));
                    this.mTarget.setCurrentPreset(n);
                    break;
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100110: {
                this.mNext = eventGeneric.getBoolean(0);
                if (AmfmScopeOfArrowKeys.get() == 1) {
                    this.mWaitingPreset = null;
                    ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                    if (serviceInfo != null) {
                        ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
                        if (componentInfo != null) {
                            this.mWaitingComponent = this.getNextComponent(this.mNext, serviceInfo, componentInfo);
                            if (this.mWaitingComponent != null) {
                                this.mWaitingService = null;
                                this.mTarget.setCurrentComponent(serviceInfo, this.mWaitingComponent);
                            } else {
                                this.mTarget.setCurrentService(serviceInfo, true);
                                this.mWaitingComponent = null;
                                this.mWaitingService = serviceInfo;
                            }
                        } else {
                            this.mWaitingService = this.getNextService(this.mNext, serviceInfo);
                            this.mWaitingComponent = null;
                            if (this.mWaitingService != null) {
                                this.mTarget.setCurrentService(this.mWaitingService, true);
                            }
                        }
                    } else {
                        this.mWaitingService = null;
                        this.mWaitingComponent = null;
                    }
                } else {
                    int n = this.getPresetIndex(this.mNext);
                    if (n > -1) {
                        this.mTarget.setCurrentPreset(n);
                        this.mWaitingPreset = RadioData.getDabDatabase().dabPresetList.getPreset(n);
                        this.mWaitingService = null;
                        this.mWaitingComponent = null;
                    }
                }
                if (this.mWaitingService != null || this.mWaitingPreset != null || this.mWaitingComponent != null) {
                    this.mStepWaiting = true;
                    break;
                }
                if (this.mJumpLmSupported) {
                    this.mStepWaiting = true;
                }
                DabRadioTextApi.newProgram(0L);
                DabRadioSlsApi.notifyStationChanging();
                break;
            }
            case 100113: {
                this.mStepWaiting = false;
                this.mWaitingService = null;
                this.mWaitingPreset = null;
                this.mWaitingComponent = null;
                this.abortStepService();
                hsmState = this.myParent;
                break;
            }
            case 4: {
                this.mStepWaiting = false;
                this.mWaitingService = null;
                this.mWaitingPreset = null;
                this.mWaitingComponent = null;
                hsmState = super.handle(eventGeneric);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void abortStepService() {
        this.mTarget.mDsiDabTuner.selectService(5, 0L, 0, 0, 0, 0, 0L);
        this.startAbortTimeout();
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo)) {
            return;
        }
        if (serviceInfo.ensID > 0 && serviceInfo.sID > 0L) {
            this.mTarget.currentTunedService = serviceInfo;
        }
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        this.mEnsemble = ensembleInfo.ensID > 0 ? ensembleInfo : null;
    }

    public void dsiDABTunerUpdateSelectedComponent(ComponentInfo componentInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkComponentAndName(componentInfo)) {
            return;
        }
        if (componentInfo.ensID > 0 && componentInfo.sID > 0L && componentInfo.sCIDI > 0) {
            this.mComponent = componentInfo;
        }
    }

    public void dsiDABTunerSelectServiceStatus(int n) {
        switch (n) {
            case 2: {
                this.debugOut('|', "aborted");
                if (!this.hasFailed()) {
                    this.mTarget.tuneLastProgram();
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 3: {
                if (this.mTarget.mNextEvent == null) {
                    if (this.mStepWaiting) {
                        this.tuneNextService();
                        this.mStepWaiting = false;
                        break;
                    }
                    DabMainApi.notifySelectServiceDone(this.mEnsemble, this.mTarget.currentTunedService, this.mComponent);
                    RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                this.debugOut('|', "failure");
                DabMainApi.notifyServiceSelectedUnsuccessful();
                this.failed();
                if (this.mTarget.mNextEvent == null) {
                    if (this.mStepWaiting) {
                        this.tuneNextService();
                        this.mStepWaiting = false;
                        break;
                    }
                    DabMainApi.notifyServiceSelectedUnsuccessful();
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 1: {
                this.mEnsemble = null;
                this.mComponent = null;
                this.mTarget.currentTunedService = null;
                this.retriggerTimeout();
                break;
            }
            default: {
                this.debugOut('|', "unknown status");
                this.trans(this.mTarget.stateIdle);
            }
        }
    }

    ComponentInfo getNextComponent(boolean bl, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        ComponentInfo componentInfo2 = null;
        RadioDabTraceUtil.hsmTraceDAB(this.mTarget, this, "stepService", "component is tuned -> so the next will be also an component");
        componentInfo2 = bl ? RadioData.getDabDatabase().mTunerState.getNextComponentOfService(serviceInfo) : RadioData.getDabDatabase().mTunerState.getPreviousComponentOfService(serviceInfo);
        if (componentInfo2 != null && !DabTunerState.compare(componentInfo, componentInfo2)) {
            return componentInfo2;
        }
        return null;
    }

    ServiceInfo getNextService(boolean bl, ServiceInfo serviceInfo) {
        ServiceInfo serviceInfo2 = this.mJumpLmSupported ? (bl ? RadioData.getDabDatabase().mTunerState.getNextServiceOfCurrentEnsemble() : RadioData.getDabDatabase().mTunerState.getPreviousServiceOfCurrentEnsemble()) : (bl ? RadioData.getDabDatabase().mTunerState.getNextService() : RadioData.getDabDatabase().mTunerState.getPreviousService());
        if (serviceInfo2 != null && !DabTunerState.compare(serviceInfo2, serviceInfo)) {
            RadioDabTraceUtil.hsmTraceDAB(this.mTarget, this, "stepService", "service is tuned -> newService != null && newService != currentService -> tune service");
            return serviceInfo2;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    boolean tuneNextEnsemble(boolean bl) {
        ServiceInfo serviceInfo;
        block7: {
            long l = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo().frequency;
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            serviceInfo = null;
            if (bl) {
                EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mTunerState.getNextEnsemble(l);
                if (ensembleInfo2 == null || ensembleInfo != null && DabTunerState.compare(ensembleInfo, ensembleInfo2)) {
                    return false;
                }
                ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo2);
                if (serviceInfoArray != null && serviceInfoArray.length > 0) {
                    serviceInfo = serviceInfoArray[0];
                    break block7;
                } else {
                    RadioDabTraceUtil.errorLogDab("DAB - Ensemble without services in list! ");
                    return false;
                }
            }
            EnsembleInfo ensembleInfo3 = RadioData.getDabDatabase().mTunerState.getPreviousEnsemble(l);
            if (ensembleInfo3 == null || ensembleInfo != null && DabTunerState.compare(ensembleInfo, ensembleInfo3)) {
                return false;
            }
            ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo3);
            if (serviceInfoArray != null && serviceInfoArray.length > 0) {
                serviceInfo = serviceInfoArray[serviceInfoArray.length - 1];
            } else {
                RadioDabTraceUtil.errorLogDab("DAB - Ensemble without services in list! ");
                return false;
            }
        }
        this.mTarget.setCurrentService(serviceInfo, true);
        this.mMode = 2;
        this.mTarget.tuneService(serviceInfo);
        return true;
    }

    int getPresetIndex(boolean bl) {
        int n = RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex();
        int n2 = -1;
        n2 = bl ? RadioData.getDabDatabase().dabPresetList.getNextOccupiedPreset() : RadioData.getDabDatabase().dabPresetList.getPreviousOccupiedPreset();
        if (n2 >= 0 && n != n2) {
            RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(n2, false);
        }
        return n2;
    }

    void jumpLM(boolean bl) {
        DabRadioTextApi.newProgram(0L);
        DabRadioSlsApi.notifyStationChanging();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-1232731904);
        eventGeneric.setBoolean(0, bl);
        this.mTarget.mNextEvent = eventGeneric;
        this.trans(this.mTarget.stateIdle);
    }

    @Override
    long getTimeout() {
        return 0;
    }

    @Override
    protected String dsiRequestToString() {
        String string = new StringBuffer().append("selectService(").append(RadioDabTraceUtil.selectServiceModeToString(this.mMode)).append(")").toString();
        return string;
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "selectService( DSIDABTuner.SELECTSERVICEMODE_ABORT)";
    }

    @Override
    protected boolean abort() {
        this.abortStepService();
        return true;
    }

    ServiceInfo getNearestService(boolean bl) {
        ServiceInfo[] serviceInfoArray;
        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
        EnsembleInfo ensembleInfo = null;
        ensembleInfo = bl ? RadioData.getDabDatabase().mTunerState.getNextEnsemble(frequencyInfo.frequency) : RadioData.getDabDatabase().mTunerState.getPreviousEnsemble(frequencyInfo.frequency);
        if (ensembleInfo != null && (serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo)).length > 0) {
            if (bl) {
                return serviceInfoArray[0];
            }
            return serviceInfoArray[serviceInfoArray.length - 1];
        }
        return null;
    }

    void tuneNextService() {
        if (this.mWaitingPreset != null) {
            this.mTarget.tuneStoredPreset(this.mWaitingPreset);
            this.mWaitingPreset = null;
        } else if (this.mWaitingComponent != null) {
            this.mTarget.tuneComponent(this.mWaitingComponent);
            this.mWaitingComponent = null;
        } else if (this.mWaitingService != null) {
            this.mTarget.tuneService(this.mWaitingService);
            this.mWaitingService = null;
        } else {
            this.jumpLM(this.mNext);
        }
    }
}

