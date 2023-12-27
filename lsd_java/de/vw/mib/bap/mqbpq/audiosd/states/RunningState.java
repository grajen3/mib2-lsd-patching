/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.states;

import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.mqbpq.AudioSdLogger;
import de.vw.mib.bap.mqbpq.PqServices;
import de.vw.mib.bap.mqbpq.PqServicesProvider;
import de.vw.mib.bap.mqbpq.audiosd.states.AudioSdHsmContext;
import de.vw.mib.bap.mqbpq.common.states.AbstractControlUnitState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.nio.BufferUnderflowException;
import org.dsi.ifc.bap.util.BAPErrorCodes;

class RunningState
extends AbstractControlUnitState {
    private final AudioSdLogger audioSdLogger;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$audiosd$states$RunningState;

    public RunningState(AudioSdHsmContext audioSdHsmContext, HsmState hsmState) {
        super(audioSdHsmContext, (class$de$vw$mib$bap$mqbpq$audiosd$states$RunningState == null ? (class$de$vw$mib$bap$mqbpq$audiosd$states$RunningState = RunningState.class$("de.vw.mib.bap.mqbpq.audiosd.states.RunningState")) : class$de$vw$mib$bap$mqbpq$audiosd$states$RunningState).getName(), hsmState);
        PqServices pqServices = PqServicesProvider.getPqServices();
        this.audioSdLogger = new AudioSdLogger(pqServices.getLogger(), super.getClass());
    }

    @Override
    public void stateEntry() {
        this.setSystemDependentHMIState();
    }

    @Override
    public void stateStart() {
        this.audioSdLogger.trace("AudioSDFunctionControlUnit successfully started.");
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void variantChanged() {
        this.getContextDataPool().flushAllInitializerData();
    }

    private void setSystemDependentHMIState() {
        this.audioSdLogger.trace("setSystemDependentHMIState called!");
        FSGOperationState fSGOperationState = (FSGOperationState)((Object)this.getContextDataPool().getFunction(15));
        if (fSGOperationState != null) {
            fSGOperationState.setHMISystemDependent(true);
        } else {
            this.audioSdLogger.trace("Instance of FSGOperationState is null!");
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        this.audioSdLogger.trace(new Object[]{"BAP state status changed: ", new Integer(n2)});
        if (n2 == 0) {
            this.goToState(this.getParent());
        }
    }

    @Override
    public void hmiDatapoolValueChanged(int n, int n2) {
        this.audioSdLogger.trace(new Object[]{"hmiDatapoolValueChanged called! fctId = ", new Integer(n), ", updateId = ", new Integer(n2)});
        this.getContextDataPool().getStage(n).process(n2);
    }

    @Override
    public void languageChange(int n) {
        this.getContextDataPool().getStage(n).process(-1);
    }

    @Override
    public void processHMIEvent(int n, int n2) {
        if (!this.getContextDataPool().getStage(n).hmiEvent(n2)) {
            this.getLogErrorMessage(n, "processHMIEvent").append("HMI Event not processed eventID=").append(n2).log();
        }
    }

    @Override
    public void notifyTimer(int n, TimerNotifier timerNotifier, int n2) {
        timerNotifier.timerFired(n2);
    }

    @Override
    public void sendBAPStageOutputValue(int n) {
        throw new UnsupportedOperationException("This function is depracated");
    }

    @Override
    public void persistenceBecomeAvailable(int n) {
        this.getContextDataPool().getStage(n).process(-1);
    }

    @Override
    public void transmitData(int n, int n2, Object object) {
        if (!this.getContextDataPool().transmitDataToMarshaller(this.getContextDelegate().getLogicalControlUnit().getBAPMarshaller(), n, n2, object)) {
            this.getLogErrorMessage(n, "transmitData").append("Failed to transmit data to marshaller");
        }
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indication(n2, n3, n4, n5)) {
            this.getLogErrorMessage(n2, "indication").append(" not processed, indicationType = ").append(n4).log();
        }
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        try {
            if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indication(n2, n3, byArray)) {
                this.getLogErrorMessage(n2, "indicationByteSequence").append(" not processed, indicationType = ").append(n3).log();
            }
        }
        catch (BufferUnderflowException bufferUnderflowException) {
            this.getLogErrorMessage(n2, "indicationByteSequence").append(" not processed, indicationType = ").append(n3).append(byArray).append(bufferUnderflowException).log();
        }
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indication(n2, n3)) {
            this.getLogErrorMessage(n2, "indicationVoid").append(" not processed, indicationType = ").append(n3).log();
        }
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().indicationError(n2, n3)) {
            this.getLogErrorMessage(n2, "indicationError").append(", errorCode = ").append(n3).append(", meaning = ").append(BAPErrorCodes.stringFromErrorCode(n3)).log();
        }
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().acknowledge(n2, n3)) {
            this.getLogErrorMessage(n2, "acknowledge").append(" not processed, acknowledgeType = ").append(n3).log();
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier()).append("asyncException errorMsg = ").append(string).log();
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

