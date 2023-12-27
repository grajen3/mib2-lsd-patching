/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateUpdateLearnMemory
extends AbstractState {
    private static final long TIMEOUT;
    private int mTargetIdForAnswer;
    private int mEventIdForAnswer;
    private int mStatus;
    private int mResult = 0;
    private int mMode;
    private EnsembleInfo mNewEnsemble = null;
    private ComponentInfo mNewComponent = null;

    StateUpdateLearnMemory(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateUpdateLearnMemory is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
                RadioData.getDabDatabase().learnMemoryUpdateRunning = true;
                this.mStatus = 0;
                this.mTargetIdForAnswer = this.mTarget.mCurrentEvent.getInt(0);
                this.mEventIdForAnswer = this.mTarget.mCurrentEvent.getInt(1);
                this.mMode = this.mTarget.mCurrentEvent.getInt(2);
                this.mTarget.mDsiDabTuner.forceLMUpdate(this.mMode);
                break;
            }
            case 4: {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
                RadioData.getDabDatabase().learnMemoryUpdateRunning = false;
                if (this.mTargetIdForAnswer > 0 && this.mEventIdForAnswer > 0) {
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.mTarget.getTargetId(), this.mTargetIdForAnswer, this.mEventIdForAnswer);
                    eventGeneric2.setResult(this.mResult);
                    this.mTarget.send(eventGeneric2);
                }
                hsmState = super.handle(eventGeneric);
                break;
            }
            case 100019: {
                this.mTarget.mDsiDabTuner.forceLMUpdate(2);
                break;
            }
            case 100113: {
                this.mTarget.mDsiDabTuner.forceLMUpdate(2);
                hsmState = this.myParent;
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    @Override
    long getTimeout() {
        return 0;
    }

    public void dsiDABTunerForceLMUpdateStatus(int n) {
        this.mStatus = n;
        switch (this.mStatus) {
            case 1: {
                this.mTarget.currentTunedService = null;
                this.mNewEnsemble = null;
                this.mNewComponent = null;
                this.retriggerTimeout();
                break;
            }
            case 3: {
                if (this.mTarget.currentTunedService == null) {
                    this.mTarget.tuneLsm();
                } else {
                    DabMainApi.notifySelectServiceDone(this.mNewEnsemble, this.mTarget.currentTunedService, this.mNewComponent);
                }
                this.mResult = 11;
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 2: {
                this.mResult = 0;
                this.trans(this.mTarget.stateIdle);
                break;
            }
            default: {
                this.mResult = 16;
                this.logFailure();
                this.trans(this.mTarget.stateIdle);
            }
        }
    }

    public void dsiDABTunerUpdateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        if (null != serviceInfoArray) {
            RadioData.getDabDatabase().mTunerState.setServiceList(serviceInfoArray);
            DabMainApi.notifyUpdateServiceList(serviceInfoArray);
            if (ServiceManager.logger.isTraceEnabled(256)) {
                RadioDabTraceUtil.dumpServiceList(this.mTarget.getTargetId());
            }
        }
    }

    private void abortLmUpdate() {
        this.startAbortTimeout();
        this.mTarget.mDsiDabTuner.forceLMUpdate(2);
    }

    @Override
    protected boolean abort() {
        this.abortLmUpdate();
        return true;
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
        RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update selected service");
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo)) {
            return;
        }
        if (serviceInfo != null && serviceInfo.getSID() > 0L && serviceInfo.ensID > 0) {
            RadioDabTraceUtil.traceDab(this.mTarget.getTargetId(), "dsi update jump lm lsm tuned in");
            this.mTarget.currentTunedService = serviceInfo;
        }
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        if (ensembleInfo.ensID > 0) {
            this.mNewEnsemble = ensembleInfo;
            DabTunerState.correctEmptyLabels(this.mNewEnsemble);
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

    @Override
    protected String dsiRequestToString() {
        return new StringBuffer().append("forceLMUpdate(").append(RadioDabTraceUtil.forceLmModesToString(this.mMode)).append(")").toString();
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "forceLmUpdate(DSIDABTuner.UPDATEMODE_ABORT)";
    }

    public void dsiDABTunerAsyncException(int n, String string, int n2) {
        this.abortLmUpdate();
    }
}

