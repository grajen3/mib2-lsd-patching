/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.states;

import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.mqbab2.common.states.AbstractControlUnitState;
import de.vw.mib.bap.mqbab2.navsd.states.NavSdHsmContext;
import de.vw.mib.genericevents.hsm.HsmState;
import java.nio.BufferUnderflowException;
import org.dsi.ifc.bap.util.BAPErrorCodes;

class RunningState
extends AbstractControlUnitState {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$navsd$states$RunningState;

    public RunningState(NavSdHsmContext navSdHsmContext, HsmState hsmState) {
        super(navSdHsmContext, (class$de$vw$mib$bap$mqbab2$navsd$states$RunningState == null ? (class$de$vw$mib$bap$mqbab2$navsd$states$RunningState = RunningState.class$("de.vw.mib.bap.mqbab2.navsd.states.RunningState")) : class$de$vw$mib$bap$mqbab2$navsd$states$RunningState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
        this.setSystemDependentHMIState();
    }

    @Override
    public void stateStart() {
        this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier(), "NavSDFunctionControlUnit successfully started");
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void variantChanged() {
        this.getContextDataPool().flushAllInitializerData();
    }

    private void setSystemDependentHMIState() {
        FSGOperationState fSGOperationState = (FSGOperationState)((Object)this.getContextDataPool().getFunction(15));
        if (fSGOperationState != null) {
            fSGOperationState.setHMISystemDependent(true);
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        this.getContextDelegate().getLogger().info(this.getContextDelegate().getSubClassifier()).append(new StringBuffer().append("BAP state status changed: ").append(n2).toString()).log();
        if (n2 == 0) {
            this.goToState(this.getParent());
        }
    }

    @Override
    public void hmiDatapoolValueChanged(int n, int n2) {
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

