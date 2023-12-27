/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SMSState_Status
implements StatusProperty {
    public int simready;
    public static final int SIM_READY_SIM_DATA_NOT_YET_AVAILABLE;
    public static final int SIM_READY_SIM_DATA_AVAILABLE;
    public int storageState;
    public static final int STORAGE_STATE_SMS_STORAGE_AVAILABLE;
    public static final int STORAGE_STATE_SMS_STORAGE_FULL;
    public static final int STORAGE_STATE_SMS_STORAGE_FULL_SMS_PENDING_1;
    public static final int STORAGE_STATE_SMS_STORAGE_FULL_SMS_PENDING_2;
    public int numberOfNewSms;

    public SMSState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SMSState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.simready = 0;
        this.storageState = 0;
        this.numberOfNewSms = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SMSState_Status sMSState_Status = (SMSState_Status)bAPEntity;
        return this.simready == sMSState_Status.simready && this.storageState == sMSState_Status.storageState && this.numberOfNewSms == sMSState_Status.numberOfNewSms;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SMSState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.simready);
        bitStream.pushByte((byte)this.storageState);
        bitStream.pushShort((short)this.numberOfNewSms);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 55;
    }

    @Override
    public int getFunctionId() {
        return SMSState_Status.functionId();
    }
}

