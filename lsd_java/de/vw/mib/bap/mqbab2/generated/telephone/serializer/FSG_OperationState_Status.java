/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status$PrivacyMode;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status
implements StatusProperty {
    public int op_State;
    public static final int OP_STATE_NORMAL_OPRATION;
    public static final int OP_STATE_OFF_STAND_BY;
    public static final int OP_STATE_INITIALIZING;
    public static final int OP_STATE_DEFECT;
    public int tel_State;
    public static final int TEL_STATE_PHONE_INITILISATION_DEFAULT_AFTER_POWER_ON_REBOOT;
    public static final int TEL_STATE_PHONE_DEFECT;
    public static final int TEL_STATE_PHONE_CONNECTING;
    public static final int TEL_STATE_PHONE_DISCONNECTING;
    public static final int TEL_STATE_PHONE_AUTOMATIC_RECONNECT;
    public static final int TEL_STATE_PHONE_MODULE_OFF;
    public static final int TEL_STATE_PHONE_MODULE_SWITCHING_ON;
    public static final int TEL_STATE_PHONE_MODULE_ON;
    public static final int TEL_STATE_PHONE_MODULE_SWITCHING_OFF;
    public static final int TEL_STATE_PHONE_MODULE_OFF_HIGH_TEMP;
    public static final int TEL_STATE_MOBILE_CONNECTING;
    public static final int TEL_STATE_MOBILE_DISCONNECTING;
    public static final int TEL_STATE_MOBILE_AUTOMATIC_RECONNECT;
    public static final int TEL_STATE_MOBILE_OFF;
    public static final int TEL_STATE_MOBILE_SWITCHING_ON;
    public static final int TEL_STATE_MOBILE_ON;
    public static final int TEL_STATE_MOBILE_SWITCHING_OFF;
    public static final int TEL_STATE_MOBILE_OFF_NO_SWITCH_ON;
    public static final int TEL_STATE_MOBILE_NOT_ATTACHED;
    public static final int TEL_STATE_MOBILE_ATTACHED_NOT_READY;
    public static final int TEL_STATE_MOBILE_ATTACHED_NOT_FUNCTIONAL;
    public final FSG_OperationState_Status$PrivacyMode privacyMode = new FSG_OperationState_Status$PrivacyMode();

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
        this.tel_State = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.privacyMode.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        return this.op_State == fSG_OperationState_Status.op_State && this.tel_State == fSG_OperationState_Status.tel_State && this.privacyMode.equalTo(fSG_OperationState_Status.privacyMode);
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
        bitStream.pushByte((byte)this.tel_State);
        this.privacyMode.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 15;
    }

    @Override
    public int getFunctionId() {
        return FSG_OperationState_Status.functionId();
    }
}

