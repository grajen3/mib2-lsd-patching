/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status
implements StatusProperty {
    public int op_State;
    public static final int OP_STATE_DEFECTIVE;
    public static final int OP_STATE_INITIALISING;
    public static final int OP_STATE_OFF_STAND_BY;
    public static final int OP_STATE_NORMAL_OPERATION;
    public int hmi_State;
    public static final int HMI_STATE_WELCOME_ANIMATION_RUNNING_ON_FSG;
    public static final int HMI_STATE_NO_ANIMATION_RUNNING_ON_FSG_HMI_STATE_UNKNOWN;

    public FSG_OperationState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_OperationState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.op_State = 0;
        this.hmi_State = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        return this.op_State == fSG_OperationState_Status.op_State && this.hmi_State == fSG_OperationState_Status.hmi_State;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_OperationState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.op_State);
        bitStream.pushByte((byte)this.hmi_State);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.op_State = bitStream.popFrontByte();
        this.hmi_State = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 15;
    }

    @Override
    public int getFunctionId() {
        return FSG_OperationState_Status.functionId();
    }
}

