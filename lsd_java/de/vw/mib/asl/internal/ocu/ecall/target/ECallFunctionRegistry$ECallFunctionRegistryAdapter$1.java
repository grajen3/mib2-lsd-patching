/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.target;

import de.vw.mib.asl.internal.ocu.ecall.target.ECallFunctionRegistry$ECallFunctionRegistryAdapter;
import de.vw.mib.asl.internal.ocu.ecall.target.ECallFunctionRegistry$FunctionRegistryAdapter;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.PropertyListener;

class ECallFunctionRegistry$ECallFunctionRegistryAdapter$1
implements ECallFunctionRegistry$FunctionRegistryAdapter {
    private final /* synthetic */ ECallFunctionRegistry$ECallFunctionRegistryAdapter this$0;

    ECallFunctionRegistry$ECallFunctionRegistryAdapter$1(ECallFunctionRegistry$ECallFunctionRegistryAdapter eCallFunctionRegistry$ECallFunctionRegistryAdapter) {
        this.this$0 = eCallFunctionRegistry$ECallFunctionRegistryAdapter;
    }

    private void _error(String string) {
        this.this$0.getLogger().warn(256).append("Called function for requestType=").append(string).append(" which is not in function list fctID=").append(this.this$0.getFctID());
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this._error("setGetProperty");
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this._error("getProperty");
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this._error("ackProperty");
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this._error("startResult");
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this._error("abortResult");
    }

    @Override
    public void requestAcknowledge() {
        throw new UnsupportedOperationException("requestAcknowledge not supported in ASG");
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        throw new UnsupportedOperationException("indicationError not supported in ASG");
    }

    @Override
    public void errorAcknowledge() {
        throw new UnsupportedOperationException("errorAcknowledge not supported in ASG");
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        this._error("setGetArray");
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        this._error("getArray");
    }
}

