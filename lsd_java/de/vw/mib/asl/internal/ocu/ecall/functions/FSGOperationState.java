/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPOperationState;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class FSGOperationState
extends ECallFunction
implements PropertyListener,
BAPOperationState,
InternalServiceProvider {
    private int _operationState = 3;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener;

    private OperationStateServiceListener getOperationStateServiceListener() {
        return (OperationStateServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener = FSGOperationState.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener);
    }

    private void _informServices() {
        boolean bl = this.getState() == 0;
        this.getOperationStateServiceListener().updateECallOperationState(bl);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("ECallFSGOperationState: Update with new startedAndRunning=").append(bl).log();
        }
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        } else {
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener = FSGOperationState.class$("de.vw.mib.asl.internal.ocu.ecall.api.online.OperationStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$online$OperationStateServiceListener, OperationStateServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.setOperationState(3);
    }

    @Override
    public int getFunctionId() {
        return 15;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        if (this.setOperationState(fSG_OperationState_Status.op_State)) {
            this.didChangeValue(bAPEntity);
        }
        this._informServices();
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public int getState() {
        return this._operationState;
    }

    private boolean setOperationState(int n) {
        boolean bl = this._operationState != n;
        this._operationState = n;
        return bl;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (OperationStateServiceListener.SERVICE_CONSTANTS[0] == n) {
            this._informServices();
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

