/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean functionGetAllAvailable;
    public boolean functionBap_ConfigAvailable;
    public boolean functionFunctionListAvailable;
    public boolean functionHeartbeatAvailable;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean functionFsg_SetupAvailable;
    public boolean functionFsg_OperationStateAvailable;
    public boolean functionAsg_CapabilitiesAvailable;
    public boolean functionSds_ContextStateAvailable;
    public boolean functionCommandListAvailable;
    public boolean functionResultListAvailable;
    public boolean functionInfoStatesAvailable;
    private static final int RESERVED_BIT_21__63_BITSIZE;

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.functionGetAllAvailable = false;
        this.functionBap_ConfigAvailable = false;
        this.functionFunctionListAvailable = false;
        this.functionHeartbeatAvailable = false;
        this.functionFsg_SetupAvailable = false;
        this.functionFsg_OperationStateAvailable = false;
        this.functionAsg_CapabilitiesAvailable = false;
        this.functionSds_ContextStateAvailable = false;
        this.functionCommandListAvailable = false;
        this.functionResultListAvailable = false;
        this.functionInfoStatesAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.functionGetAllAvailable == functionList_Status.functionGetAllAvailable && this.functionBap_ConfigAvailable == functionList_Status.functionBap_ConfigAvailable && this.functionFunctionListAvailable == functionList_Status.functionFunctionListAvailable && this.functionHeartbeatAvailable == functionList_Status.functionHeartbeatAvailable && this.functionFsg_SetupAvailable == functionList_Status.functionFsg_SetupAvailable && this.functionFsg_OperationStateAvailable == functionList_Status.functionFsg_OperationStateAvailable && this.functionAsg_CapabilitiesAvailable == functionList_Status.functionAsg_CapabilitiesAvailable && this.functionSds_ContextStateAvailable == functionList_Status.functionSds_ContextStateAvailable && this.functionCommandListAvailable == functionList_Status.functionCommandListAvailable && this.functionResultListAvailable == functionList_Status.functionResultListAvailable && this.functionInfoStatesAvailable == functionList_Status.functionInfoStatesAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionList_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.functionGetAllAvailable);
        bitStream.pushBoolean(this.functionBap_ConfigAvailable);
        bitStream.pushBoolean(this.functionFunctionListAvailable);
        bitStream.pushBoolean(this.functionHeartbeatAvailable);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.functionFsg_SetupAvailable);
        bitStream.pushBoolean(this.functionFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.functionAsg_CapabilitiesAvailable);
        bitStream.pushBoolean(this.functionSds_ContextStateAvailable);
        bitStream.pushBoolean(this.functionCommandListAvailable);
        bitStream.pushBoolean(this.functionResultListAvailable);
        bitStream.pushBoolean(this.functionInfoStatesAvailable);
        bitStream.resetBits(43);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

