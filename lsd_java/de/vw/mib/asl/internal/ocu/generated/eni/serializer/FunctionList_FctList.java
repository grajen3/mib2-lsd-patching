/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_FctList
implements BAPEntity {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBap_ConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartbeatAvailable;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fctFsg_SetupAvailable;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctDestinationsListAvailable;
    public boolean fctDestinationList_AsgcapacityAvailable;
    public boolean fctIdTriggerRemoteProcessAvailable;
    public boolean fctIdRemoteProcessCommandsAvailable;
    public boolean fctIdRemoteProcessStateAvailable;
    public boolean fctIdUserListAvailable;
    public boolean fctIdServiceListAvailable;
    public boolean fctIdActiveMonitoringsAvailable;
    public boolean fctIdPrivacySetupAvailable;
    public boolean fctIdAlertListAvailable;
    public boolean fctIdMobileDeviceKeyCountAvailable;
    public boolean fctIdVtandataEncryptedAvailable;
    public boolean fctIdOnlineUpdateStateAvailable;
    public boolean fctIdConnectionStateAvailable;
    public boolean fctIdChallengeDataAvailable;
    public boolean fctIdFoDlistAvailable;
    public boolean fctIdFoDstateAvailable;
    public boolean fctIdActiveTripAvailable;
    public boolean fctIdOlbsettingsAvailable;
    public boolean fctIdOlbtripListAvailable;
    public boolean currentOnlineUpdateStateAvailable;
    public boolean onlineUpdateListAvailable;
    private static final int RESERVED_BIT_38__63_BITSIZE;

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
        this.fctGetAllAvailable = false;
        this.fctBap_ConfigAvailable = false;
        this.fctFunctionListAvailable = false;
        this.fctHeartbeatAvailable = false;
        this.fctFsg_SetupAvailable = false;
        this.fctFsg_OperationStateAvailable = false;
        this.fctDestinationsListAvailable = false;
        this.fctDestinationList_AsgcapacityAvailable = false;
        this.fctIdTriggerRemoteProcessAvailable = false;
        this.fctIdRemoteProcessCommandsAvailable = false;
        this.fctIdRemoteProcessStateAvailable = false;
        this.fctIdUserListAvailable = false;
        this.fctIdServiceListAvailable = false;
        this.fctIdActiveMonitoringsAvailable = false;
        this.fctIdPrivacySetupAvailable = false;
        this.fctIdAlertListAvailable = false;
        this.fctIdMobileDeviceKeyCountAvailable = false;
        this.fctIdVtandataEncryptedAvailable = false;
        this.fctIdOnlineUpdateStateAvailable = false;
        this.fctIdConnectionStateAvailable = false;
        this.fctIdChallengeDataAvailable = false;
        this.fctIdFoDlistAvailable = false;
        this.fctIdFoDstateAvailable = false;
        this.fctIdActiveTripAvailable = false;
        this.fctIdOlbsettingsAvailable = false;
        this.fctIdOlbtripListAvailable = false;
        this.currentOnlineUpdateStateAvailable = false;
        this.onlineUpdateListAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_FctList functionList_FctList = (FunctionList_FctList)bAPEntity;
        return this.reserved_bit_0 == functionList_FctList.reserved_bit_0 && this.fctGetAllAvailable == functionList_FctList.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_FctList.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_FctList.fctFunctionListAvailable && this.fctHeartbeatAvailable == functionList_FctList.fctHeartbeatAvailable && this.fctFsg_SetupAvailable == functionList_FctList.fctFsg_SetupAvailable && this.fctFsg_OperationStateAvailable == functionList_FctList.fctFsg_OperationStateAvailable && this.fctDestinationsListAvailable == functionList_FctList.fctDestinationsListAvailable && this.fctDestinationList_AsgcapacityAvailable == functionList_FctList.fctDestinationList_AsgcapacityAvailable && this.fctIdTriggerRemoteProcessAvailable == functionList_FctList.fctIdTriggerRemoteProcessAvailable && this.fctIdRemoteProcessCommandsAvailable == functionList_FctList.fctIdRemoteProcessCommandsAvailable && this.fctIdRemoteProcessStateAvailable == functionList_FctList.fctIdRemoteProcessStateAvailable && this.fctIdUserListAvailable == functionList_FctList.fctIdUserListAvailable && this.fctIdServiceListAvailable == functionList_FctList.fctIdServiceListAvailable && this.fctIdActiveMonitoringsAvailable == functionList_FctList.fctIdActiveMonitoringsAvailable && this.fctIdPrivacySetupAvailable == functionList_FctList.fctIdPrivacySetupAvailable && this.fctIdAlertListAvailable == functionList_FctList.fctIdAlertListAvailable && this.fctIdMobileDeviceKeyCountAvailable == functionList_FctList.fctIdMobileDeviceKeyCountAvailable && this.fctIdVtandataEncryptedAvailable == functionList_FctList.fctIdVtandataEncryptedAvailable && this.fctIdOnlineUpdateStateAvailable == functionList_FctList.fctIdOnlineUpdateStateAvailable && this.fctIdConnectionStateAvailable == functionList_FctList.fctIdConnectionStateAvailable && this.fctIdChallengeDataAvailable == functionList_FctList.fctIdChallengeDataAvailable && this.fctIdFoDlistAvailable == functionList_FctList.fctIdFoDlistAvailable && this.fctIdFoDstateAvailable == functionList_FctList.fctIdFoDstateAvailable && this.fctIdActiveTripAvailable == functionList_FctList.fctIdActiveTripAvailable && this.fctIdOlbsettingsAvailable == functionList_FctList.fctIdOlbsettingsAvailable && this.fctIdOlbtripListAvailable == functionList_FctList.fctIdOlbtripListAvailable && this.currentOnlineUpdateStateAvailable == functionList_FctList.currentOnlineUpdateStateAvailable && this.onlineUpdateListAvailable == functionList_FctList.onlineUpdateListAvailable;
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
        bitStream.pushBoolean(this.fctGetAllAvailable);
        bitStream.pushBoolean(this.fctBap_ConfigAvailable);
        bitStream.pushBoolean(this.fctFunctionListAvailable);
        bitStream.pushBoolean(this.fctHeartbeatAvailable);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsg_SetupAvailable);
        bitStream.pushBoolean(this.fctFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fctDestinationsListAvailable);
        bitStream.pushBoolean(this.fctDestinationList_AsgcapacityAvailable);
        bitStream.pushBoolean(this.fctIdTriggerRemoteProcessAvailable);
        bitStream.pushBoolean(this.fctIdRemoteProcessCommandsAvailable);
        bitStream.pushBoolean(this.fctIdRemoteProcessStateAvailable);
        bitStream.pushBoolean(this.fctIdUserListAvailable);
        bitStream.pushBoolean(this.fctIdServiceListAvailable);
        bitStream.pushBoolean(this.fctIdActiveMonitoringsAvailable);
        bitStream.pushBoolean(this.fctIdPrivacySetupAvailable);
        bitStream.pushBoolean(this.fctIdAlertListAvailable);
        bitStream.pushBoolean(this.fctIdMobileDeviceKeyCountAvailable);
        bitStream.pushBoolean(this.fctIdVtandataEncryptedAvailable);
        bitStream.pushBoolean(this.fctIdOnlineUpdateStateAvailable);
        bitStream.pushBoolean(this.fctIdConnectionStateAvailable);
        bitStream.pushBoolean(this.fctIdChallengeDataAvailable);
        bitStream.pushBoolean(this.fctIdFoDlistAvailable);
        bitStream.pushBoolean(this.fctIdFoDstateAvailable);
        bitStream.pushBoolean(this.fctIdActiveTripAvailable);
        bitStream.pushBoolean(this.fctIdOlbsettingsAvailable);
        bitStream.pushBoolean(this.fctIdOlbtripListAvailable);
        bitStream.pushBoolean(this.currentOnlineUpdateStateAvailable);
        bitStream.pushBoolean(this.onlineUpdateListAvailable);
        bitStream.resetBits(26);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fctGetAllAvailable = bitStream.popFrontBoolean();
        this.fctBap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fctFunctionListAvailable = bitStream.popFrontBoolean();
        this.fctHeartbeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(9);
        this.fctFsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fctFsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fctDestinationsListAvailable = bitStream.popFrontBoolean();
        this.fctDestinationList_AsgcapacityAvailable = bitStream.popFrontBoolean();
        this.fctIdTriggerRemoteProcessAvailable = bitStream.popFrontBoolean();
        this.fctIdRemoteProcessCommandsAvailable = bitStream.popFrontBoolean();
        this.fctIdRemoteProcessStateAvailable = bitStream.popFrontBoolean();
        this.fctIdUserListAvailable = bitStream.popFrontBoolean();
        this.fctIdServiceListAvailable = bitStream.popFrontBoolean();
        this.fctIdActiveMonitoringsAvailable = bitStream.popFrontBoolean();
        this.fctIdPrivacySetupAvailable = bitStream.popFrontBoolean();
        this.fctIdAlertListAvailable = bitStream.popFrontBoolean();
        this.fctIdMobileDeviceKeyCountAvailable = bitStream.popFrontBoolean();
        this.fctIdVtandataEncryptedAvailable = bitStream.popFrontBoolean();
        this.fctIdOnlineUpdateStateAvailable = bitStream.popFrontBoolean();
        this.fctIdConnectionStateAvailable = bitStream.popFrontBoolean();
        this.fctIdChallengeDataAvailable = bitStream.popFrontBoolean();
        this.fctIdFoDlistAvailable = bitStream.popFrontBoolean();
        this.fctIdFoDstateAvailable = bitStream.popFrontBoolean();
        this.fctIdActiveTripAvailable = bitStream.popFrontBoolean();
        this.fctIdOlbsettingsAvailable = bitStream.popFrontBoolean();
        this.fctIdOlbtripListAvailable = bitStream.popFrontBoolean();
        this.currentOnlineUpdateStateAvailable = bitStream.popFrontBoolean();
        this.onlineUpdateListAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(26);
    }
}

