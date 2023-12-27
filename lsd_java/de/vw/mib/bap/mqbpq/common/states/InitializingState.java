/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.states;

import de.vw.mib.bap.mqbpq.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbpq.common.states.NotStartedFunctionControlUnitState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.nio.BufferUnderflowException;
import org.dsi.ifc.bap.util.BAPErrorCodes;

class InitializingState
extends NotStartedFunctionControlUnitState {
    private boolean sendBuffersInitialized = false;
    private boolean functionListInitialized = false;
    private int currentInitializationState = 0;
    private static final int INITIALIZATION_STATE_WAIT_FOR_INITIALISATION;
    private static final int INITIALIZATION_STATE_WAIT_FOR_FCT_LIST_INIT;
    private static final int INITIALIZATION_STATE_INITIALIZED_OR_INTIALIZE_SENDBUFFERS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$common$states$InitializingState;

    public InitializingState(FsgHsmContext fsgHsmContext, HsmState hsmState) {
        super(fsgHsmContext, (class$de$vw$mib$bap$mqbpq$common$states$InitializingState == null ? (class$de$vw$mib$bap$mqbpq$common$states$InitializingState = InitializingState.class$("de.vw.mib.bap.mqbpq.common.states.InitializingState")) : class$de$vw$mib$bap$mqbpq$common$states$InitializingState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
        this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier(), "entry stateInitializing");
    }

    @Override
    public void stateStart() {
        this.currentInitializationState = 0;
        this.reinitializeBAPFunctions();
        if (!this.functionListInitialized) {
            this.initializeFunctionList();
        } else {
            this.initializeSendbuffers();
        }
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void variantChanged() {
        if (this.currentInitializationState == 2) {
            this.getContextDataPool().flushAllInitializerData();
        }
    }

    private void reinitializeBAPFunctions() {
        if (this.sendBuffersInitialized) {
            this.getLogicalControlUnit().reinitialize();
        }
    }

    private void initializeFunctionList() {
        if (!this.getContextDataPool().initializeFunctionList()) {
            this.functionListInitialized();
        }
    }

    private void functionListInitialized() {
        this.functionListInitialized = true;
        this.currentInitializationState = 1;
        this.getContextDelegate().getLogicalControlUnit().getService().getBAPState(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID());
    }

    private void initializeSendbuffers() {
        this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier(), "Start initializing send buffers");
        this.getContextDataPool().initializeSendbuffers(this.sendBuffersInitialized);
        this.currentInitializationState = 2;
        this.setHMIState(2);
        this.getContextDataPool().flushAllBapValueObserverables();
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        if (n3 == 20 && this.currentInitializationState == 2) {
            if (!this.sendBuffersInitialized) {
                this.getContextDataPool().clearNativeInitializer();
            }
            this.sendBuffersInitialized = true;
            this.goToState(this.getHsmContext().getRunningState());
        } else if (n2 == 3 && n3 == 0) {
            this.getContextDataPool().clearFunctionListInitializerData();
            this.functionListInitialized();
        } else if (!this.getContextDelegate().getLogicalControlUnit().getBAPDemarshaller().acknowledge(n2, n3)) {
            this.getLogErrorMessage(n2, "acknowledge").append(" not processed, acknowledgeType = ").append(n3).log();
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        super.bapStateStatus(n, n2);
        if (n2 == 0) {
            this.goToState(this.getParent());
        } else if (n2 == 1 && this.currentInitializationState == 1) {
            this.initializeSendbuffers();
        }
    }

    @Override
    public final void sendBAPStageOutputValue(int n) {
        throw new UnsupportedOperationException("This function is depracated");
    }

    @Override
    public void transmitData(int n, int n2, Object object) {
        if (this.currentInitializationState == 2 && !this.getContextDataPool().transmitDataToMarshaller(this.getContextDelegate().getLogicalControlUnit().getBAPMarshaller(), n, n2, object)) {
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

