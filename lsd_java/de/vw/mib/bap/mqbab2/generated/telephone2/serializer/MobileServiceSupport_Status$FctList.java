/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobileServiceSupport_Status$FctList
implements BAPEntity {
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
    public boolean fctPhonebookDownloadProcessSupported;
    private static final int RESERVED_BIT_27__63_BITSIZE;

    public MobileServiceSupport_Status$FctList() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileServiceSupport_Status$FctList(BitStream bitStream) {
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
        this.fctPhonebookDownloadProcessSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileServiceSupport_Status$FctList mobileServiceSupport_Status$FctList = (MobileServiceSupport_Status$FctList)bAPEntity;
        return this.reserved_bit_0 == mobileServiceSupport_Status$FctList.reserved_bit_0 && this.fctGetAllSupported == mobileServiceSupport_Status$FctList.fctGetAllSupported && this.fctBapConfigSupported == mobileServiceSupport_Status$FctList.fctBapConfigSupported && this.fctFunctionListSupported == mobileServiceSupport_Status$FctList.fctFunctionListSupported && this.fctHeartbeatSupported == mobileServiceSupport_Status$FctList.fctHeartbeatSupported && this.fctFsg_SetupSupported == mobileServiceSupport_Status$FctList.fctFsg_SetupSupported && this.fctFsg_OperationStateSupported == mobileServiceSupport_Status$FctList.fctFsg_OperationStateSupported && this.fctMobileServiceSupportSupported == mobileServiceSupport_Status$FctList.fctMobileServiceSupportSupported && this.fctRegisterState2Supported == mobileServiceSupport_Status$FctList.fctRegisterState2Supported && this.fctLockState2Supported == mobileServiceSupport_Status$FctList.fctLockState2Supported && this.fctNetworkProvider2Supported == mobileServiceSupport_Status$FctList.fctNetworkProvider2Supported && this.fctSignalQuality2Supported == mobileServiceSupport_Status$FctList.fctSignalQuality2Supported && this.fctDataConnectionIndication2Supported == mobileServiceSupport_Status$FctList.fctDataConnectionIndication2Supported && this.fctEmailStateSupported == mobileServiceSupport_Status$FctList.fctEmailStateSupported && this.fctPhoneModuleStateSupported == mobileServiceSupport_Status$FctList.fctPhoneModuleStateSupported && this.fctConnectionStateSupported == mobileServiceSupport_Status$FctList.fctConnectionStateSupported && this.fctAutomaticCallForwardingSupported == mobileServiceSupport_Status$FctList.fctAutomaticCallForwardingSupported && this.fctPhonebookDownloadProcessSupported == mobileServiceSupport_Status$FctList.fctPhonebookDownloadProcessSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FctList:";
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
        bitStream.pushBoolean(this.fctPhonebookDownloadProcessSupported);
        bitStream.resetBits(37);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

