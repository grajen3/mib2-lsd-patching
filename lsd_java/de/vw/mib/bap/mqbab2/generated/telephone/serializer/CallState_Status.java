/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallIncomingDiverted;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions0;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions1;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions2;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions3;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions4;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions5;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions6;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOutgoingDiverted_eCallConfirmationPending;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status
implements StatusProperty {
    public int callState0;
    private static final int CALL_STATE0_BITSIZE;
    public static final int CALL_STATE0_IDLE;
    public static final int CALL_STATE0_RINGING_WAITING;
    public static final int CALL_STATE0_ACTIVE;
    public static final int CALL_STATE0_DIALING;
    public static final int CALL_STATE0_DISCONNECTING;
    public static final int CALL_STATE0_ON_HOLD;
    public static final int CALL_STATE0_CONNECTED_CIB;
    public static final int CALL_STATE0_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE0_INCOMING_ON_HOLD;
    public int callType0;
    private static final int CALL_TYPE0_BITSIZE;
    public static final int CALL_TYPE0_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE0_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE0_DATA_CALL;
    public static final int CALL_TYPE0_FAX_CALL;
    public static final int CALL_TYPE0_EMERGENCY_CALL;
    public static final int CALL_TYPE0_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE0_INFO_CALL;
    public static final int CALL_TYPE0_SERVICE_CALL;
    public static final int CALL_TYPE0_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions0 callOptions0 = new CallState_Status$CallOptions0();
    public int callState1;
    private static final int CALL_STATE1_BITSIZE;
    public static final int CALL_STATE1_IDLE;
    public static final int CALL_STATE1_RINGING_WAITING;
    public static final int CALL_STATE1_ACTIVE;
    public static final int CALL_STATE1_DIALING;
    public static final int CALL_STATE1_DISCONNECTING;
    public static final int CALL_STATE1_ON_HOLD;
    public static final int CALL_STATE1_CONNECTED_CIB;
    public static final int CALL_STATE1_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE1_INCOMING_ON_HOLD;
    public int callType1;
    private static final int CALL_TYPE1_BITSIZE;
    public static final int CALL_TYPE1_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE1_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE1_DATA_CALL;
    public static final int CALL_TYPE1_FAX_CALL;
    public static final int CALL_TYPE1_EMERGENCY_CALL;
    public static final int CALL_TYPE1_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE1_INFO_CALL;
    public static final int CALL_TYPE1_SERVICE_CALL;
    public static final int CALL_TYPE1_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions1 callOptions1 = new CallState_Status$CallOptions1();
    public int callState2;
    private static final int CALL_STATE2_BITSIZE;
    public static final int CALL_STATE2_IDLE;
    public static final int CALL_STATE2_RINGING_WAITING;
    public static final int CALL_STATE2_ACTIVE;
    public static final int CALL_STATE2_DIALING;
    public static final int CALL_STATE2_DISCONNECTING;
    public static final int CALL_STATE2_ON_HOLD;
    public static final int CALL_STATE2_CONNECTED_CIB;
    public static final int CALL_STATE2_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE2_INCOMING_ON_HOLD;
    public int callType2;
    private static final int CALL_TYPE2_BITSIZE;
    public static final int CALL_TYPE2_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE2_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE2_DATA_CALL;
    public static final int CALL_TYPE2_FAX_CALL;
    public static final int CALL_TYPE2_EMERGENCY_CALL;
    public static final int CALL_TYPE2_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE2_INFO_CALL;
    public static final int CALL_TYPE2_SERVICE_CALL;
    public static final int CALL_TYPE2_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions2 callOptions2 = new CallState_Status$CallOptions2();
    public int callState3;
    private static final int CALL_STATE3_BITSIZE;
    public static final int CALL_STATE3_IDLE;
    public static final int CALL_STATE3_RINGING_WAITING;
    public static final int CALL_STATE3_ACTIVE;
    public static final int CALL_STATE3_DIALING;
    public static final int CALL_STATE3_DISCONNECTING;
    public static final int CALL_STATE3_ON_HOLD;
    public static final int CALL_STATE3_CONNECTED_CIB;
    public static final int CALL_STATE3_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE3_INCOMING_ON_HOLD;
    public int callType3;
    private static final int CALL_TYPE3_BITSIZE;
    public static final int CALL_TYPE3_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE3_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE3_DATA_CALL;
    public static final int CALL_TYPE3_FAX_CALL;
    public static final int CALL_TYPE3_EMERGENCY_CALL;
    public static final int CALL_TYPE3_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE3_INFO_CALL;
    public static final int CALL_TYPE3_SERVICE_CALL;
    public static final int CALL_TYPE3_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions3 callOptions3 = new CallState_Status$CallOptions3();
    public int callState4;
    private static final int CALL_STATE4_BITSIZE;
    public static final int CALL_STATE4_IDLE;
    public static final int CALL_STATE4_RINGING_WAITING;
    public static final int CALL_STATE4_ACTIVE;
    public static final int CALL_STATE4_DIALING;
    public static final int CALL_STATE4_DISCONNECTING;
    public static final int CALL_STATE4_ON_HOLD;
    public static final int CALL_STATE4_CONNECTED_CIB;
    public static final int CALL_STATE4_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE4_INCOMING_ON_HOLD;
    public int callType4;
    private static final int CALL_TYPE4_BITSIZE;
    public static final int CALL_TYPE4_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE4_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE4_DATA_CALL;
    public static final int CALL_TYPE4_FAX_CALL;
    public static final int CALL_TYPE4_EMERGENCY_CALL;
    public static final int CALL_TYPE4_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE4_INFO_CALL;
    public static final int CALL_TYPE4_SERVICE_CALL;
    public static final int CALL_TYPE4_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions4 callOptions4 = new CallState_Status$CallOptions4();
    public int callState5;
    private static final int CALL_STATE5_BITSIZE;
    public static final int CALL_STATE5_IDLE;
    public static final int CALL_STATE5_RINGING_WAITING;
    public static final int CALL_STATE5_ACTIVE;
    public static final int CALL_STATE5_DIALING;
    public static final int CALL_STATE5_DISCONNECTING;
    public static final int CALL_STATE5_ON_HOLD;
    public static final int CALL_STATE5_CONNECTED_CIB;
    public static final int CALL_STATE5_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE5_INCOMING_ON_HOLD;
    public int callType5;
    private static final int CALL_TYPE5_BITSIZE;
    public static final int CALL_TYPE5_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE5_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE5_DATA_CALL;
    public static final int CALL_TYPE5_FAX_CALL;
    public static final int CALL_TYPE5_EMERGENCY_CALL;
    public static final int CALL_TYPE5_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE5_INFO_CALL;
    public static final int CALL_TYPE5_SERVICE_CALL;
    public static final int CALL_TYPE5_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions5 callOptions5 = new CallState_Status$CallOptions5();
    public int callState6;
    private static final int CALL_STATE6_BITSIZE;
    public static final int CALL_STATE6_IDLE;
    public static final int CALL_STATE6_RINGING_WAITING;
    public static final int CALL_STATE6_ACTIVE;
    public static final int CALL_STATE6_DIALING;
    public static final int CALL_STATE6_DISCONNECTING;
    public static final int CALL_STATE6_ON_HOLD;
    public static final int CALL_STATE6_CONNECTED_CIB;
    public static final int CALL_STATE6_REMOTE_SIDE_BUSY;
    public static final int CALL_STATE6_INCOMING_ON_HOLD;
    public int callType6;
    private static final int CALL_TYPE6_BITSIZE;
    public static final int CALL_TYPE6_UNKNOWN_CALL_TYPE;
    public static final int CALL_TYPE6_SINGLE_VOICE_CALL;
    public static final int CALL_TYPE6_DATA_CALL;
    public static final int CALL_TYPE6_FAX_CALL;
    public static final int CALL_TYPE6_EMERGENCY_CALL;
    public static final int CALL_TYPE6_CONFERENCE_VOICE_CALL;
    public static final int CALL_TYPE6_INFO_CALL;
    public static final int CALL_TYPE6_SERVICE_CALL;
    public static final int CALL_TYPE6_ACN_EMERGENCY_CALL;
    public final CallState_Status$CallOptions6 callOptions6 = new CallState_Status$CallOptions6();
    public final CallState_Status$CallIncomingDiverted callIncomingDiverted = new CallState_Status$CallIncomingDiverted();
    public final CallState_Status$CallOutgoingDiverted_eCallConfirmationPending callOutgoingDiverted_eCallConfirmationPending = new CallState_Status$CallOutgoingDiverted_eCallConfirmationPending();

    public CallState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status(BitStream bitStream) {
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
    }

    @Override
    public void reset() {
        this.internalReset();
        this.callOptions0.reset();
        this.callOptions1.reset();
        this.callOptions2.reset();
        this.callOptions3.reset();
        this.callOptions4.reset();
        this.callOptions5.reset();
        this.callOptions6.reset();
        this.callIncomingDiverted.reset();
        this.callOutgoingDiverted_eCallConfirmationPending.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_Status callState_Status = (CallState_Status)bAPEntity;
        return this.callState0 == callState_Status.callState0 && this.callType0 == callState_Status.callType0 && this.callOptions0.equalTo(callState_Status.callOptions0) && this.callState1 == callState_Status.callState1 && this.callType1 == callState_Status.callType1 && this.callOptions1.equalTo(callState_Status.callOptions1) && this.callState2 == callState_Status.callState2 && this.callType2 == callState_Status.callType2 && this.callOptions2.equalTo(callState_Status.callOptions2) && this.callState3 == callState_Status.callState3 && this.callType3 == callState_Status.callType3 && this.callOptions3.equalTo(callState_Status.callOptions3) && this.callState4 == callState_Status.callState4 && this.callType4 == callState_Status.callType4 && this.callOptions4.equalTo(callState_Status.callOptions4) && this.callState5 == callState_Status.callState5 && this.callType5 == callState_Status.callType5 && this.callOptions5.equalTo(callState_Status.callOptions5) && this.callState6 == callState_Status.callState6 && this.callType6 == callState_Status.callType6 && this.callOptions6.equalTo(callState_Status.callOptions6) && this.callIncomingDiverted.equalTo(callState_Status.callIncomingDiverted) && this.callOutgoingDiverted_eCallConfirmationPending.equalTo(callState_Status.callOutgoingDiverted_eCallConfirmationPending);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.callState0);
        bitStream.pushBits(4, this.callType0);
        this.callOptions0.serialize(bitStream);
        bitStream.pushBits(4, this.callState1);
        bitStream.pushBits(4, this.callType1);
        this.callOptions1.serialize(bitStream);
        bitStream.pushBits(4, this.callState2);
        bitStream.pushBits(4, this.callType2);
        this.callOptions2.serialize(bitStream);
        bitStream.pushBits(4, this.callState3);
        bitStream.pushBits(4, this.callType3);
        this.callOptions3.serialize(bitStream);
        bitStream.pushBits(4, this.callState4);
        bitStream.pushBits(4, this.callType4);
        this.callOptions4.serialize(bitStream);
        bitStream.pushBits(4, this.callState5);
        bitStream.pushBits(4, this.callType5);
        this.callOptions5.serialize(bitStream);
        bitStream.pushBits(4, this.callState6);
        bitStream.pushBits(4, this.callType6);
        this.callOptions6.serialize(bitStream);
        this.callIncomingDiverted.serialize(bitStream);
        this.callOutgoingDiverted_eCallConfirmationPending.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return CallState_Status.functionId();
    }
}

