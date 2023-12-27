/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class EmailState_Status
implements StatusProperty {
    public int storageState;
    public static final int STORAGE_STATE_EMAIL_STORAGE_AVAILABLE;
    public static final int STORAGE_STATE_EMAIL_STORAGE_FULL;
    public static final int STORAGE_STATE_EMAIL_STORAGE_FULL_EMAIL_PENDING_1;
    public static final int STORAGE_STATE_EMAIL_STORAGE_FULL_EMAIL_PENDING_2;
    public int numberOfNewEmail;

    public EmailState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public EmailState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.storageState = 0;
        this.numberOfNewEmail = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        EmailState_Status emailState_Status = (EmailState_Status)bAPEntity;
        return this.storageState == emailState_Status.storageState && this.numberOfNewEmail == emailState_Status.numberOfNewEmail;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "EmailState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.storageState);
        bitStream.pushShort((short)this.numberOfNewEmail);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return EmailState_Status.functionId();
    }
}

