/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_FctList
implements BAPEntity {
    public boolean reserved_bit_0;
    public boolean fct_GetAllAvailable;
    public boolean fct_Bap_ConfigAvailable;
    public boolean fct_FunctionListAvailable;
    public boolean fct_HeartBeatAvailable;
    private static final int RESERVED_BIT_5__12_BITSIZE;
    public boolean fct_Fsg_ControlAvailable;
    public boolean fct_Fsg_SetupAvailable;
    public boolean fct_Fsg_OperationStateAvailable;
    public boolean fct_AudioStateAvailable;
    public boolean fct_CallStateAvailable;
    public boolean fct_HangupCallAvailable;
    public boolean fct_AcceptCallAvailable;
    public boolean fct_DisconnectReasonAvailable;
    public boolean fct_RegisterStateAvailable;
    public boolean fct_NetworkProviderAvailable;
    public boolean fct_SignalQualityAvailable;
    public boolean fct_ServiceRequestAvailable;
    public boolean fct_ServiceControlAvailable;
    public boolean fct_ServiceStateAvailable;
    public boolean fct_SupportedServicesAvailable;
    public boolean fct_FunctionalRestrictionsAvailable;
    private static final int RESERVED_BIT_29__63_BITSIZE;

    public FunctionList_FctList() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_FctList(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fct_GetAllAvailable = false;
        this.fct_Bap_ConfigAvailable = false;
        this.fct_FunctionListAvailable = false;
        this.fct_HeartBeatAvailable = false;
        this.fct_Fsg_ControlAvailable = false;
        this.fct_Fsg_SetupAvailable = false;
        this.fct_Fsg_OperationStateAvailable = false;
        this.fct_AudioStateAvailable = false;
        this.fct_CallStateAvailable = false;
        this.fct_HangupCallAvailable = false;
        this.fct_AcceptCallAvailable = false;
        this.fct_DisconnectReasonAvailable = false;
        this.fct_RegisterStateAvailable = false;
        this.fct_NetworkProviderAvailable = false;
        this.fct_SignalQualityAvailable = false;
        this.fct_ServiceRequestAvailable = false;
        this.fct_ServiceControlAvailable = false;
        this.fct_ServiceStateAvailable = false;
        this.fct_SupportedServicesAvailable = false;
        this.fct_FunctionalRestrictionsAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_FctList functionList_FctList = (FunctionList_FctList)bAPEntity;
        return this.reserved_bit_0 == functionList_FctList.reserved_bit_0 && this.fct_GetAllAvailable == functionList_FctList.fct_GetAllAvailable && this.fct_Bap_ConfigAvailable == functionList_FctList.fct_Bap_ConfigAvailable && this.fct_FunctionListAvailable == functionList_FctList.fct_FunctionListAvailable && this.fct_HeartBeatAvailable == functionList_FctList.fct_HeartBeatAvailable && this.fct_Fsg_ControlAvailable == functionList_FctList.fct_Fsg_ControlAvailable && this.fct_Fsg_SetupAvailable == functionList_FctList.fct_Fsg_SetupAvailable && this.fct_Fsg_OperationStateAvailable == functionList_FctList.fct_Fsg_OperationStateAvailable && this.fct_AudioStateAvailable == functionList_FctList.fct_AudioStateAvailable && this.fct_CallStateAvailable == functionList_FctList.fct_CallStateAvailable && this.fct_HangupCallAvailable == functionList_FctList.fct_HangupCallAvailable && this.fct_AcceptCallAvailable == functionList_FctList.fct_AcceptCallAvailable && this.fct_DisconnectReasonAvailable == functionList_FctList.fct_DisconnectReasonAvailable && this.fct_RegisterStateAvailable == functionList_FctList.fct_RegisterStateAvailable && this.fct_NetworkProviderAvailable == functionList_FctList.fct_NetworkProviderAvailable && this.fct_SignalQualityAvailable == functionList_FctList.fct_SignalQualityAvailable && this.fct_ServiceRequestAvailable == functionList_FctList.fct_ServiceRequestAvailable && this.fct_ServiceControlAvailable == functionList_FctList.fct_ServiceControlAvailable && this.fct_ServiceStateAvailable == functionList_FctList.fct_ServiceStateAvailable && this.fct_SupportedServicesAvailable == functionList_FctList.fct_SupportedServicesAvailable && this.fct_FunctionalRestrictionsAvailable == functionList_FctList.fct_FunctionalRestrictionsAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fct_GetAllAvailable);
        bitStream.pushBoolean(this.fct_Bap_ConfigAvailable);
        bitStream.pushBoolean(this.fct_FunctionListAvailable);
        bitStream.pushBoolean(this.fct_HeartBeatAvailable);
        bitStream.resetBits(8);
        bitStream.pushBoolean(this.fct_Fsg_ControlAvailable);
        bitStream.pushBoolean(this.fct_Fsg_SetupAvailable);
        bitStream.pushBoolean(this.fct_Fsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fct_AudioStateAvailable);
        bitStream.pushBoolean(this.fct_CallStateAvailable);
        bitStream.pushBoolean(this.fct_HangupCallAvailable);
        bitStream.pushBoolean(this.fct_AcceptCallAvailable);
        bitStream.pushBoolean(this.fct_DisconnectReasonAvailable);
        bitStream.pushBoolean(this.fct_RegisterStateAvailable);
        bitStream.pushBoolean(this.fct_NetworkProviderAvailable);
        bitStream.pushBoolean(this.fct_SignalQualityAvailable);
        bitStream.pushBoolean(this.fct_ServiceRequestAvailable);
        bitStream.pushBoolean(this.fct_ServiceControlAvailable);
        bitStream.pushBoolean(this.fct_ServiceStateAvailable);
        bitStream.pushBoolean(this.fct_SupportedServicesAvailable);
        bitStream.pushBoolean(this.fct_FunctionalRestrictionsAvailable);
        bitStream.resetBits(35);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fct_GetAllAvailable = bitStream.popFrontBoolean();
        this.fct_Bap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fct_FunctionListAvailable = bitStream.popFrontBoolean();
        this.fct_HeartBeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(8);
        this.fct_Fsg_ControlAvailable = bitStream.popFrontBoolean();
        this.fct_Fsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fct_Fsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fct_AudioStateAvailable = bitStream.popFrontBoolean();
        this.fct_CallStateAvailable = bitStream.popFrontBoolean();
        this.fct_HangupCallAvailable = bitStream.popFrontBoolean();
        this.fct_AcceptCallAvailable = bitStream.popFrontBoolean();
        this.fct_DisconnectReasonAvailable = bitStream.popFrontBoolean();
        this.fct_RegisterStateAvailable = bitStream.popFrontBoolean();
        this.fct_NetworkProviderAvailable = bitStream.popFrontBoolean();
        this.fct_SignalQualityAvailable = bitStream.popFrontBoolean();
        this.fct_ServiceRequestAvailable = bitStream.popFrontBoolean();
        this.fct_ServiceControlAvailable = bitStream.popFrontBoolean();
        this.fct_ServiceStateAvailable = bitStream.popFrontBoolean();
        this.fct_SupportedServicesAvailable = bitStream.popFrontBoolean();
        this.fct_FunctionalRestrictionsAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(35);
    }
}

