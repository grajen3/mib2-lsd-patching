/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.CallState_AdditionalStates;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_StatusAck
implements StatusAckProperty {
    public int callState0;
    public static final int CALL_STATE0_INCOMING_ON_HOLD;
    public static final int CALL_STATE0_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE0_CONNECTED_CIB;
    public static final int CALL_STATE0_ON_HOLD;
    public static final int CALL_STATE0_DISCONNECTING;
    public static final int CALL_STATE0_DIALING;
    public static final int CALL_STATE0_ACTIVE;
    public static final int CALL_STATE0_RINGING_WAITING;
    public static final int CALL_STATE0_IDLE;
    private static final int CALL_STATE0_BITSIZE;
    public int callType0;
    public static final int CALL_TYPE0_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE0_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE0_MEC;
    public static final int CALL_TYPE0_ACN;
    public static final int CALL_TYPE0_SERVICE_CALL;
    public static final int CALL_TYPE0_INFO_CALL;
    public static final int CALL_TYPE0_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE0_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE0_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE0_BITSIZE;
    public int callState1;
    public static final int CALL_STATE1_INCOMING_ON_HOLD;
    public static final int CALL_STATE1_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE1_CONNECTED_CIB;
    public static final int CALL_STATE1_ON_HOLD;
    public static final int CALL_STATE1_DISCONNECTING;
    public static final int CALL_STATE1_DIALING;
    public static final int CALL_STATE1_ACTIVE;
    public static final int CALL_STATE1_RINGING_WAITING;
    public static final int CALL_STATE1_IDLE;
    private static final int CALL_STATE1_BITSIZE;
    public int callType1;
    public static final int CALL_TYPE1_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE1_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE1_MEC;
    public static final int CALL_TYPE1_ACN;
    public static final int CALL_TYPE1_SERVICE_CALL;
    public static final int CALL_TYPE1_INFO_CALL;
    public static final int CALL_TYPE1_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE1_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE1_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE1_BITSIZE;
    public int callState2;
    public static final int CALL_STATE2_INCOMING_ON_HOLD;
    public static final int CALL_STATE2_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE2_CONNECTED_CIB;
    public static final int CALL_STATE2_ON_HOLD;
    public static final int CALL_STATE2_DISCONNECTING;
    public static final int CALL_STATE2_DIALING;
    public static final int CALL_STATE2_ACTIVE;
    public static final int CALL_STATE2_RINGING_WAITING;
    public static final int CALL_STATE2_IDLE;
    private static final int CALL_STATE2_BITSIZE;
    public int callType2;
    public static final int CALL_TYPE2_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE2_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE2_MEC;
    public static final int CALL_TYPE2_ACN;
    public static final int CALL_TYPE2_SERVICE_CALL;
    public static final int CALL_TYPE2_INFO_CALL;
    public static final int CALL_TYPE2_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE2_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE2_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE2_BITSIZE;
    public int callState3;
    public static final int CALL_STATE3_INCOMING_ON_HOLD;
    public static final int CALL_STATE3_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE3_CONNECTED_CIB;
    public static final int CALL_STATE3_ON_HOLD;
    public static final int CALL_STATE3_DISCONNECTING;
    public static final int CALL_STATE3_DIALING;
    public static final int CALL_STATE3_ACTIVE;
    public static final int CALL_STATE3_RINGING_WAITING;
    public static final int CALL_STATE3_IDLE;
    private static final int CALL_STATE3_BITSIZE;
    public int callType3;
    public static final int CALL_TYPE3_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE3_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE3_MEC;
    public static final int CALL_TYPE3_ACN;
    public static final int CALL_TYPE3_SERVICE_CALL;
    public static final int CALL_TYPE3_INFO_CALL;
    public static final int CALL_TYPE3_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE3_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE3_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE3_BITSIZE;
    public int callState4;
    public static final int CALL_STATE4_INCOMING_ON_HOLD;
    public static final int CALL_STATE4_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE4_CONNECTED_CIB;
    public static final int CALL_STATE4_ON_HOLD;
    public static final int CALL_STATE4_DISCONNECTING;
    public static final int CALL_STATE4_DIALING;
    public static final int CALL_STATE4_ACTIVE;
    public static final int CALL_STATE4_RINGING_WAITING;
    public static final int CALL_STATE4_IDLE;
    private static final int CALL_STATE4_BITSIZE;
    public int callType4;
    public static final int CALL_TYPE4_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE4_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE4_MEC;
    public static final int CALL_TYPE4_ACN;
    public static final int CALL_TYPE4_SERVICE_CALL;
    public static final int CALL_TYPE4_INFO_CALL;
    public static final int CALL_TYPE4_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE4_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE4_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE4_BITSIZE;
    public int callState5;
    public static final int CALL_STATE5_INCOMING_ON_HOLD;
    public static final int CALL_STATE5_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE5_CONNECTED_CIB;
    public static final int CALL_STATE5_ON_HOLD;
    public static final int CALL_STATE5_DISCONNECTING;
    public static final int CALL_STATE5_DIALING;
    public static final int CALL_STATE5_ACTIVE;
    public static final int CALL_STATE5_RINGING_WAITING;
    public static final int CALL_STATE5_IDLE;
    private static final int CALL_STATE5_BITSIZE;
    public int callType5;
    public static final int CALL_TYPE5_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE5_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE5_MEC;
    public static final int CALL_TYPE5_ACN;
    public static final int CALL_TYPE5_SERVICE_CALL;
    public static final int CALL_TYPE5_INFO_CALL;
    public static final int CALL_TYPE5_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE5_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE5_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE5_BITSIZE;
    public int callState6;
    public static final int CALL_STATE6_INCOMING_ON_HOLD;
    public static final int CALL_STATE6_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE6_CONNECTED_CIB;
    public static final int CALL_STATE6_ON_HOLD;
    public static final int CALL_STATE6_DISCONNECTING;
    public static final int CALL_STATE6_DIALING;
    public static final int CALL_STATE6_ACTIVE;
    public static final int CALL_STATE6_RINGING_WAITING;
    public static final int CALL_STATE6_IDLE;
    private static final int CALL_STATE6_BITSIZE;
    public int callType6;
    public static final int CALL_TYPE6_ACN_LEGAL_DF3_7;
    public static final int CALL_TYPE6_MEC_LEGAL_DF3_2;
    public static final int CALL_TYPE6_MEC;
    public static final int CALL_TYPE6_ACN;
    public static final int CALL_TYPE6_SERVICE_CALL;
    public static final int CALL_TYPE6_INFO_CALL;
    public static final int CALL_TYPE6_EMERGENCY_CALL_MANUAL_E_G_112_W_O_DATA_TRANSMISSION;
    public static final int CALL_TYPE6_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE6_UNKNOWN_CALL_TYPE;
    private static final int CALL_TYPE6_BITSIZE;
    public int extension;
    public static final int EXTENSION_MIN;
    private static final int EXTENSION_BITSIZE;
    public CallState_AdditionalStates additionalStates = new CallState_AdditionalStates();

    public CallState_StatusAck() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_StatusAck(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callState0 = 0;
        this.callType0 = 0;
        this.callState1 = 0;
        this.callType1 = 0;
        this.callState2 = 0;
        this.callType2 = 0;
        this.callState3 = 0;
        this.callType3 = 0;
        this.callState4 = 0;
        this.callType4 = 0;
        this.callState5 = 0;
        this.callType5 = 0;
        this.callState6 = 0;
        this.callType6 = 0;
        this.extension = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.additionalStates.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_StatusAck callState_StatusAck = (CallState_StatusAck)bAPEntity;
        return this.callState0 == callState_StatusAck.callState0 && this.callType0 == callState_StatusAck.callType0 && this.callState1 == callState_StatusAck.callState1 && this.callType1 == callState_StatusAck.callType1 && this.callState2 == callState_StatusAck.callState2 && this.callType2 == callState_StatusAck.callType2 && this.callState3 == callState_StatusAck.callState3 && this.callType3 == callState_StatusAck.callType3 && this.callState4 == callState_StatusAck.callState4 && this.callType4 == callState_StatusAck.callType4 && this.callState5 == callState_StatusAck.callState5 && this.callType5 == callState_StatusAck.callType5 && this.callState6 == callState_StatusAck.callState6 && this.callType6 == callState_StatusAck.callType6 && this.extension == callState_StatusAck.extension && this.additionalStates.equalTo(callState_StatusAck.additionalStates);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallState_StatusAck:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.callState0);
        bitStream.pushBits(4, this.callType0);
        bitStream.pushBits(4, this.callState1);
        bitStream.pushBits(4, this.callType1);
        bitStream.pushBits(4, this.callState2);
        bitStream.pushBits(4, this.callType2);
        bitStream.pushBits(4, this.callState3);
        bitStream.pushBits(4, this.callType3);
        bitStream.pushBits(4, this.callState4);
        bitStream.pushBits(4, this.callType4);
        bitStream.pushBits(4, this.callState5);
        bitStream.pushBits(4, this.callType5);
        bitStream.pushBits(4, this.callState6);
        bitStream.pushBits(4, this.callType6);
        bitStream.pushBits(4, this.extension);
        this.additionalStates.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.callState0 = bitStream.popFrontBits(4);
        this.callType0 = bitStream.popFrontBits(4);
        this.callState1 = bitStream.popFrontBits(4);
        this.callType1 = bitStream.popFrontBits(4);
        this.callState2 = bitStream.popFrontBits(4);
        this.callType2 = bitStream.popFrontBits(4);
        this.callState3 = bitStream.popFrontBits(4);
        this.callType3 = bitStream.popFrontBits(4);
        this.callState4 = bitStream.popFrontBits(4);
        this.callType4 = bitStream.popFrontBits(4);
        this.callState5 = bitStream.popFrontBits(4);
        this.callType5 = bitStream.popFrontBits(4);
        this.callState6 = bitStream.popFrontBits(4);
        this.callType6 = bitStream.popFrontBits(4);
        this.extension = bitStream.popFrontBits(4);
        this.additionalStates.deserialize(bitStream);
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return CallState_StatusAck.functionId();
    }
}

