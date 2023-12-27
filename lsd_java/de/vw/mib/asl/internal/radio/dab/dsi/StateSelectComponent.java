/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
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
import org.dsi.ifc.radio.ServiceInfo;

public final class StateSelectComponent
extends AbstractState {
    private static final long TIMEOUT;
    EnsembleInfo mEnsemble;
    ComponentInfo mComponent;

    public StateSelectComponent(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateSelectComponent is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                ComponentInfo componentInfo = (ComponentInfo)this.mTarget.mCurrentEvent.getObject(0);
                this.debugOut('>', new StringBuffer().append("tune: ").append(componentInfo.toString()).toString());
                this.mTarget.tuneComponent(componentInfo);
                break;
            }
            case 100012: 
            case 100021: 
            case 100111: {
                this.mTarget.mDsiDabTuner.selectService(5, 0L, 0, 0, 0, 0, 0L);
                this.trans(this.mTarget.stateIdle);
                return this.myParent;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
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
                DabMainApi.notifySelectServiceDone(this.mEnsemble, this.mTarget.currentTunedService, this.mComponent);
                RadioData.getDabDatabase().mTunerState.getCurrentComponent();
                if (null != RadioData.getDabDatabase().mTunerState.getCurrentComponent() && null == this.mComponent) {
                    RadioData.getDabDatabase().mTunerState.setCurrentComponent(this.mComponent);
                    GuiApiDab.updateAdditionalServiceState(RadioData.getDabDatabase().mTunerState.getAdditionalServiceState());
                }
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
                this.mEnsemble = null;
                this.mTarget.currentTunedService = null;
                this.mComponent = null;
                this.retriggerTimeout();
                break;
            }
            default: {
                this.logFailure(new StringBuffer().append("Unknown status (").append(n).append(")").toString());
                this.trans(this.mTarget.stateIdle);
            }
        }
    }

    void abortSelectComponent() {
        this.mTarget.mDsiDabTuner.selectService(5, 0L, 0, 0, 0, 0, 0L);
        this.startAbortTimeout();
    }

    @Override
    long getTimeout() {
        return 0;
    }

    @Override
    protected String dsiRequestToString() {
        return "selectkService( DSIDABTuner.SELECTSERVICEMODE_SCIDI)";
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "selectService(DSIDABTuner.SELECTSERVICEMODE_ABORT)";
    }

    @Override
    protected boolean abort() {
        this.abortSelectComponent();
        return true;
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected service");
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
        if (ensembleInfo.ensID > 0) {
            this.mEnsemble = ensembleInfo;
        }
    }

    public void dsiDABTunerUpdateSelectedComponent(ComponentInfo componentInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkComponentAndName(componentInfo)) {
            return;
        }
        if (componentInfo.ensID > 0 && componentInfo.sID > 0L && componentInfo.sCIDI > 0) {
            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected component");
            RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
            this.mComponent = componentInfo;
        }
    }
}

