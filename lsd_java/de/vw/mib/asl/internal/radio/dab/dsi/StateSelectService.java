/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateSelectService
extends AbstractState {
    private static final long TIMEOUT;
    int mMode = 0;
    private EnsembleInfo mNewEnsemble = null;
    private ComponentInfo mNewComponent = null;

    StateSelectService(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateSelectService is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                int n = this.mTarget.mCurrentEvent.getReceiverEventId();
                if (n == -1249509120) {
                    Object object = this.mTarget.mCurrentEvent.getObject(0);
                    DabPreset dabPreset = (DabPreset)object;
                    this.mMode = this.mTarget.tuneStoredPreset(dabPreset);
                    break;
                }
                if (n == -1400504064) {
                    ServiceInfo serviceInfo = (ServiceInfo)this.mTarget.mCurrentEvent.getObject(0);
                    if (serviceInfo != null) {
                        this.mTarget.tuneService(serviceInfo);
                        this.mMode = 2;
                        break;
                    }
                    RadioDabTraceUtil.errorLogDab("State selectService: service is null ! -> going to idle");
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                if (n == 260505856) {
                    ServiceInfo serviceInfo = (ServiceInfo)this.mTarget.mCurrentEvent.getObject(0);
                    FrequencyInfo frequencyInfo = (FrequencyInfo)this.mTarget.mCurrentEvent.getObject(1);
                    if (serviceInfo != null) {
                        if (frequencyInfo != null) {
                            this.mTarget.tuneServiceByFrequency(serviceInfo, frequencyInfo);
                            this.mMode = 6;
                            break;
                        }
                        this.mTarget.tuneService(serviceInfo);
                        this.mMode = 2;
                        break;
                    }
                    RadioDabTraceUtil.errorLogDab("State selectService: service is null !  -> going to idle");
                    this.trans(this.mTarget.stateIdle);
                    break;
                }
                if (RadioUtil.isDabTraceEnabled()) {
                    RadioDabTraceUtil.errorLogDab(new StringBuffer().append("wrong current Event -> StateSelectService.HSM_START: ").append(n).toString());
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100018: {
                this.abortSelectService();
                this.trans(this.mTarget.stateIdle);
                return this.myParent;
            }
            case 100012: 
            case 100021: 
            case 100111: {
                this.abortSelectService();
                this.trans(this.mTarget.stateIdle);
                return this.myParent;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100009: 
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
        if (!this.isAbortTimeoutRunning()) {
            this.debugOut('>', "cancel");
            this.mTarget.mDsiDabTuner.selectService(5, 0L, 0, 0, 0, 0, 0L);
            this.startAbortTimeout();
        }
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        RadioData.getDabDatabase().mTunerState.setCurrentFrequency(frequencyInfo);
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected service");
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo)) {
            return;
        }
        if (serviceInfo != null && serviceInfo.getSID() > 0L && serviceInfo.ensID > 0) {
            this.mTarget.currentTunedService = serviceInfo;
            this.mTarget.presetNameChangeRequested = false;
            this.mTarget.retriggerOrStartTimer(-1937309440, (long)0, false);
        } else {
            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "Service is invalid.");
        }
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
                if (this.mTarget.currentTunedService != null && this.mTarget.currentTunedService.getSID() > 0L && this.mTarget.currentTunedService.ensID > 0) {
                    RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
                }
                if (this.mTarget.mNextEvent == null) {
                    DabMainApi.notifySelectServiceDone(this.mNewEnsemble, this.mTarget.currentTunedService, this.mNewComponent);
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                if (this.mTarget.mNextEvent == null) {
                    DabMainApi.notifySelectServiceDone(this.mNewEnsemble, this.mTarget.currentTunedService, this.mNewComponent);
                }
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
                DabMainApi.notifySelectServiceRunning();
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
        String string = new StringBuffer().append("selectService(").append(RadioDabTraceUtil.selectServiceModeToString(this.mMode)).append(")").toString();
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
}

