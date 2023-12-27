/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBapConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartbeatAvailable;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fctFsgSetupAvailable;
    public boolean fctFsgOperationStateAvailable;
    public boolean fctActiveSourceAvailable;
    public boolean fctActiveSourceNameAvailable;
    public boolean fctCurrentVolumeAvailable;
    public boolean fctMuteAvailable;
    public boolean fctSourceStateAvailable;
    public boolean fctCurrentStationInfoAvailable;
    public boolean fctInfoListAvailable;
    public boolean fctDedicatedAudioControlAvailable;
    public boolean fctGeneralInfoSwitchesAvailable;
    public boolean fctTpInfoAvailable;
    public boolean fctTaInfoAvailable;
    public boolean fctTaEscapeAvailable;
    public boolean fctInfoStatesAvailable;
    public boolean fctInfoListTypeAvailable;
    public boolean reserved_bit_30;
    public boolean fctChangeInfoListTypeAvailable;
    public boolean fctSaveStationAvailable;
    public boolean fctChangeTunerVariantAvailable;
    private static final int RESERVED_BIT_34__63_BITSIZE;

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
        this.fctGetAllAvailable = false;
        this.fctBapConfigAvailable = false;
        this.fctFunctionListAvailable = false;
        this.fctHeartbeatAvailable = false;
        this.fctFsgSetupAvailable = false;
        this.fctFsgOperationStateAvailable = false;
        this.fctActiveSourceAvailable = false;
        this.fctActiveSourceNameAvailable = false;
        this.fctCurrentVolumeAvailable = false;
        this.fctMuteAvailable = false;
        this.fctSourceStateAvailable = false;
        this.fctCurrentStationInfoAvailable = false;
        this.fctInfoListAvailable = false;
        this.fctDedicatedAudioControlAvailable = false;
        this.fctGeneralInfoSwitchesAvailable = false;
        this.fctTpInfoAvailable = false;
        this.fctTaInfoAvailable = false;
        this.fctTaEscapeAvailable = false;
        this.fctInfoStatesAvailable = false;
        this.fctInfoListTypeAvailable = false;
        this.reserved_bit_30 = false;
        this.fctChangeInfoListTypeAvailable = false;
        this.fctSaveStationAvailable = false;
        this.fctChangeTunerVariantAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllAvailable == functionList_Status.fctGetAllAvailable && this.fctBapConfigAvailable == functionList_Status.fctBapConfigAvailable && this.fctFunctionListAvailable == functionList_Status.fctFunctionListAvailable && this.fctHeartbeatAvailable == functionList_Status.fctHeartbeatAvailable && this.fctFsgSetupAvailable == functionList_Status.fctFsgSetupAvailable && this.fctFsgOperationStateAvailable == functionList_Status.fctFsgOperationStateAvailable && this.fctActiveSourceAvailable == functionList_Status.fctActiveSourceAvailable && this.fctActiveSourceNameAvailable == functionList_Status.fctActiveSourceNameAvailable && this.fctCurrentVolumeAvailable == functionList_Status.fctCurrentVolumeAvailable && this.fctMuteAvailable == functionList_Status.fctMuteAvailable && this.fctSourceStateAvailable == functionList_Status.fctSourceStateAvailable && this.fctCurrentStationInfoAvailable == functionList_Status.fctCurrentStationInfoAvailable && this.fctInfoListAvailable == functionList_Status.fctInfoListAvailable && this.fctDedicatedAudioControlAvailable == functionList_Status.fctDedicatedAudioControlAvailable && this.fctGeneralInfoSwitchesAvailable == functionList_Status.fctGeneralInfoSwitchesAvailable && this.fctTpInfoAvailable == functionList_Status.fctTpInfoAvailable && this.fctTaInfoAvailable == functionList_Status.fctTaInfoAvailable && this.fctTaEscapeAvailable == functionList_Status.fctTaEscapeAvailable && this.fctInfoStatesAvailable == functionList_Status.fctInfoStatesAvailable && this.fctInfoListTypeAvailable == functionList_Status.fctInfoListTypeAvailable && this.reserved_bit_30 == functionList_Status.reserved_bit_30 && this.fctChangeInfoListTypeAvailable == functionList_Status.fctChangeInfoListTypeAvailable && this.fctSaveStationAvailable == functionList_Status.fctSaveStationAvailable && this.fctChangeTunerVariantAvailable == functionList_Status.fctChangeTunerVariantAvailable;
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
        bitStream.pushBoolean(this.fctGetAllAvailable);
        bitStream.pushBoolean(this.fctBapConfigAvailable);
        bitStream.pushBoolean(this.fctFunctionListAvailable);
        bitStream.pushBoolean(this.fctHeartbeatAvailable);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsgSetupAvailable);
        bitStream.pushBoolean(this.fctFsgOperationStateAvailable);
        bitStream.pushBoolean(this.fctActiveSourceAvailable);
        bitStream.pushBoolean(this.fctActiveSourceNameAvailable);
        bitStream.pushBoolean(this.fctCurrentVolumeAvailable);
        bitStream.pushBoolean(this.fctMuteAvailable);
        bitStream.pushBoolean(this.fctSourceStateAvailable);
        bitStream.pushBoolean(this.fctCurrentStationInfoAvailable);
        bitStream.pushBoolean(this.fctInfoListAvailable);
        bitStream.pushBoolean(this.fctDedicatedAudioControlAvailable);
        bitStream.pushBoolean(this.fctGeneralInfoSwitchesAvailable);
        bitStream.pushBoolean(this.fctTpInfoAvailable);
        bitStream.pushBoolean(this.fctTaInfoAvailable);
        bitStream.pushBoolean(this.fctTaEscapeAvailable);
        bitStream.pushBoolean(this.fctInfoStatesAvailable);
        bitStream.pushBoolean(this.fctInfoListTypeAvailable);
        bitStream.pushBoolean(this.reserved_bit_30);
        bitStream.pushBoolean(this.fctChangeInfoListTypeAvailable);
        bitStream.pushBoolean(this.fctSaveStationAvailable);
        bitStream.pushBoolean(this.fctChangeTunerVariantAvailable);
        bitStream.resetBits(30);
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

