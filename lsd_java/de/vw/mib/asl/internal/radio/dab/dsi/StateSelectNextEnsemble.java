/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateSelectNextEnsemble
extends AbstractState {
    private static final long TIMEOUT;
    private EnsembleInfo mNewEnsemble = null;
    private ComponentInfo mNewComponent = null;

    StateSelectNextEnsemble(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateSelectNextEnsemble is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                int n = this.mTarget.mCurrentEvent.getReceiverEventId();
                if (n == -1232731904) {
                    boolean bl = this.mTarget.mCurrentEvent.getBoolean(0);
                    EnsembleInfo ensembleInfo = null;
                    if (bl) {
                        ensembleInfo = RadioData.getDabDatabase().mTunerState.getNextEnsemble(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo().frequency);
                        if (ensembleInfo != null) {
                            FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getFrequencyByValue(ensembleInfo.frequencyValue);
                            if (this.tuneFirstService(ensembleInfo, frequencyInfo)) break;
                            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "State selectNextEnsemble: ensemble found but no service available");
                            this.trans(this.mTarget.stateIdle);
                            break;
                        }
                        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "State selectNextEnsemble: no ensemble found");
                        this.trans(this.mTarget.stateIdle);
                        break;
                    }
                    ensembleInfo = RadioData.getDabDatabase().mTunerState.getPreviousEnsemble(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo().frequency);
                    if (ensembleInfo != null) {
                        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getFrequencyByValue(ensembleInfo.frequencyValue);
                        if (this.tuneLastService(ensembleInfo, frequencyInfo)) break;
                        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "State selectNextEnsemble: ensemble found but no service available");
                        this.trans(this.mTarget.stateIdle);
                        break;
                    }
                    RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "State selectNextEnsemble: no ensemble found");
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                RadioDabTraceUtil.errorLogDab("State selectSelectNextEnsemble: Unknown Event -> going to idle");
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100009: 
            case 100010: 
            case 100104: 
            case 100106: 
            case 100110: 
            case 100113: {
                this.abortSelectService();
                return this.myParent;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void abortSelectService() {
        this.debugOut('>', "cancel");
        this.mTarget.mDsiDabTuner.selectService(5, 0L, 0, 0, 0, 0, 0L);
        this.startAbortTimeout();
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected service");
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo)) {
            return;
        }
        if (serviceInfo != null && serviceInfo.getSID() > 0L && serviceInfo.ensID > 0) {
            RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected service finished");
        } else {
            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "Service is invalid.");
        }
        this.mTarget.currentTunedService = serviceInfo;
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        if (ensembleInfo.ensID > 0) {
            this.mNewEnsemble = ensembleInfo;
        }
    }

    public void dsiDABTunerUpdateSelectedComponent(ComponentInfo componentInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkComponentAndName(componentInfo)) {
            return;
        }
        if (componentInfo.ensID > 0 && componentInfo.sID > 0L && componentInfo.sCIDI > 0) {
            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected component");
            this.mNewComponent = componentInfo;
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
                DabMainApi.notifySelectServiceDone(this.mNewEnsemble, this.mTarget.currentTunedService, this.mNewComponent);
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                this.logFailure(RadioDabTraceUtil.selectServiceStatusToString(n));
                DabMainApi.notifyServiceSelectedUnsuccessful();
                this.failed();
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 1: {
                this.mTarget.currentTunedService = null;
                this.mNewEnsemble = null;
                this.mNewComponent = null;
                this.retriggerTimeout();
                break;
            }
            default: {
                this.logFailure(new StringBuffer().append("Unknown Status (").append(n).append(")").toString());
                this.trans(this.mTarget.stateIdle);
            }
        }
    }

    @Override
    long getTimeout() {
        return 0;
    }

    @Override
    protected String dsiRequestToString() {
        String string = "selectService( DSIDABTuner.SELECTSERVICEMODE_SID_AND_FREQUENCY ) ";
        return string;
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "selectService( DSIDABTuner.SELECTSERVICEMODE_ABORT)";
    }

    @Override
    protected boolean abort() {
        this.abortSelectService();
        return true;
    }

    boolean tuneFirstService(EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo);
        if (serviceInfoArray.length > 0 && serviceInfoArray[0] != null) {
            this.mTarget.tuneService(serviceInfoArray[0]);
            DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfoArray[0], null);
            return true;
        }
        return false;
    }

    boolean tuneLastService(EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo);
        if (serviceInfoArray.length > 0 && serviceInfoArray[0] != null) {
            this.mTarget.tuneService(serviceInfoArray[serviceInfoArray.length - 1]);
            DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfoArray[serviceInfoArray.length - 1], null);
            return true;
        }
        return false;
    }
}

