/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FunctionList_Status;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import java.util.BitSet;

public final class FunctionList
extends ECallFunction
implements PropertyListener,
BAPFunctionList {
    private BitSet _functionListBitSet;
    private boolean _functionListReceived;

    private BitSet getFunctionListBitSet() {
        if (this._functionListBitSet == null) {
            this._functionListBitSet = new BitSet();
        }
        return this._functionListBitSet;
    }

    private boolean isFunctionListReceived() {
        return this._functionListReceived;
    }

    private void setFunctionListReceived(boolean bl) {
        this._functionListReceived = bl;
    }

    private boolean existsFunction(int n) {
        return n >= this.getFunctionListBitSet().size() ? false : this.getFunctionListBitSet().get(n);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
        }
    }

    @Override
    public void uninitialize() {
        this.setFunctionListReceived(false);
        this.getFunctionListBitSet().clear();
    }

    @Override
    public int getFunctionId() {
        return 3;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        BitSet bitSet = this.getFunctionListBitSet();
        bitSet.set(1, functionList_Status.fctList.fct_GetAllAvailable);
        bitSet.set(2, functionList_Status.fctList.fct_Bap_ConfigAvailable);
        bitSet.set(3, functionList_Status.fctList.fct_FunctionListAvailable);
        bitSet.set(4, functionList_Status.fctList.fct_HeartBeatAvailable);
        bitSet.set(14, functionList_Status.fctList.fct_Fsg_SetupAvailable);
        bitSet.set(15, functionList_Status.fctList.fct_Fsg_OperationStateAvailable);
        bitSet.set(16, functionList_Status.fctList.fct_AudioStateAvailable);
        bitSet.set(17, functionList_Status.fctList.fct_CallStateAvailable);
        bitSet.set(18, functionList_Status.fctList.fct_HangupCallAvailable);
        bitSet.set(19, functionList_Status.fctList.fct_AcceptCallAvailable);
        bitSet.set(20, functionList_Status.fctList.fct_DisconnectReasonAvailable);
        bitSet.set(21, functionList_Status.fctList.fct_RegisterStateAvailable);
        bitSet.set(22, functionList_Status.fctList.fct_NetworkProviderAvailable);
        bitSet.set(23, functionList_Status.fctList.fct_SignalQualityAvailable);
        bitSet.set(24, functionList_Status.fctList.fct_ServiceRequestAvailable);
        bitSet.set(25, functionList_Status.fctList.fct_ServiceControlAvailable);
        bitSet.set(26, functionList_Status.fctList.fct_ServiceStateAvailable);
        bitSet.set(27, functionList_Status.fctList.fct_SupportedServicesAvailable);
        bitSet.set(28, functionList_Status.fctList.fct_FunctionalRestrictionsAvailable);
        this.setFunctionListReceived(true);
        this.didChangeValue(bAPEntity);
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public boolean containsFunction(int n) {
        return this.isFunctionListReceived() ? this.existsFunction(n) : true;
    }
}

