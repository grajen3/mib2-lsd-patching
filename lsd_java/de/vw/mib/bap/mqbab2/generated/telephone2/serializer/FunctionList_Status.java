/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllSupported;
    public boolean fctBapConfigSupported;
    public boolean fctFunctionListSupported;
    public boolean fctHeartbeatSupported;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fctFsg_SetupSupported;
    public boolean fctFsg_OperationStateSupported;
    public boolean fctMobileServiceSupportSupported;
    public boolean fctRegisterState2Supported;
    public boolean fctLockState2Supported;
    public boolean fctNetworkProvider2Supported;
    public boolean fctSignalQuality2Supported;
    public boolean fctDataConnectionIndication2Supported;
    public boolean fctEmailStateSupported;
    public boolean fctPhoneModuleStateSupported;
    public boolean fctConnectionStateSupported;
    public boolean fctAutomaticCallForwardingSupported;
    public boolean fctPhonebookDownloadProgressSupported;
    private static final int RESERVED_BIT_27__63_BITSIZE;

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
        this.fctGetAllSupported = false;
        this.fctBapConfigSupported = false;
        this.fctFunctionListSupported = false;
        this.fctHeartbeatSupported = false;
        this.fctFsg_SetupSupported = false;
        this.fctFsg_OperationStateSupported = false;
        this.fctMobileServiceSupportSupported = false;
        this.fctRegisterState2Supported = false;
        this.fctLockState2Supported = false;
        this.fctNetworkProvider2Supported = false;
        this.fctSignalQuality2Supported = false;
        this.fctDataConnectionIndication2Supported = false;
        this.fctEmailStateSupported = false;
        this.fctPhoneModuleStateSupported = false;
        this.fctConnectionStateSupported = false;
        this.fctAutomaticCallForwardingSupported = false;
        this.fctPhonebookDownloadProgressSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllSupported == functionList_Status.fctGetAllSupported && this.fctBapConfigSupported == functionList_Status.fctBapConfigSupported && this.fctFunctionListSupported == functionList_Status.fctFunctionListSupported && this.fctHeartbeatSupported == functionList_Status.fctHeartbeatSupported && this.fctFsg_SetupSupported == functionList_Status.fctFsg_SetupSupported && this.fctFsg_OperationStateSupported == functionList_Status.fctFsg_OperationStateSupported && this.fctMobileServiceSupportSupported == functionList_Status.fctMobileServiceSupportSupported && this.fctRegisterState2Supported == functionList_Status.fctRegisterState2Supported && this.fctLockState2Supported == functionList_Status.fctLockState2Supported && this.fctNetworkProvider2Supported == functionList_Status.fctNetworkProvider2Supported && this.fctSignalQuality2Supported == functionList_Status.fctSignalQuality2Supported && this.fctDataConnectionIndication2Supported == functionList_Status.fctDataConnectionIndication2Supported && this.fctEmailStateSupported == functionList_Status.fctEmailStateSupported && this.fctPhoneModuleStateSupported == functionList_Status.fctPhoneModuleStateSupported && this.fctConnectionStateSupported == functionList_Status.fctConnectionStateSupported && this.fctAutomaticCallForwardingSupported == functionList_Status.fctAutomaticCallForwardingSupported && this.fctPhonebookDownloadProgressSupported == functionList_Status.fctPhonebookDownloadProgressSupported;
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
        bitStream.pushBoolean(this.fctGetAllSupported);
        bitStream.pushBoolean(this.fctBapConfigSupported);
        bitStream.pushBoolean(this.fctFunctionListSupported);
        bitStream.pushBoolean(this.fctHeartbeatSupported);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsg_SetupSupported);
        bitStream.pushBoolean(this.fctFsg_OperationStateSupported);
        bitStream.pushBoolean(this.fctMobileServiceSupportSupported);
        bitStream.pushBoolean(this.fctRegisterState2Supported);
        bitStream.pushBoolean(this.fctLockState2Supported);
        bitStream.pushBoolean(this.fctNetworkProvider2Supported);
        bitStream.pushBoolean(this.fctSignalQuality2Supported);
        bitStream.pushBoolean(this.fctDataConnectionIndication2Supported);
        bitStream.pushBoolean(this.fctEmailStateSupported);
        bitStream.pushBoolean(this.fctPhoneModuleStateSupported);
        bitStream.pushBoolean(this.fctConnectionStateSupported);
        bitStream.pushBoolean(this.fctAutomaticCallForwardingSupported);
        bitStream.pushBoolean(this.fctPhonebookDownloadProgressSupported);
        bitStream.resetBits(37);
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

