/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ETC_Status_Status
implements StatusProperty {
    public int cardStatus;
    public static final int CARD_STATUS_INIT_UNKNOWN;
    public static final int CARD_STATUS_ETC_CARD_INSERTED;
    public static final int CARD_STATUS_ETC_CARD_NOT_INSERTED;
    public static final int CARD_STATUS_ETC_CARD_READER_IS_NOT_CONNECTED;
    public static final int EXTENSION1_MAX;
    public static final int EXTENSION1_MIN;
    public int extension1;

    public ETC_Status_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ETC_Status_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.cardStatus = 0;
        this.extension1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ETC_Status_Status eTC_Status_Status = (ETC_Status_Status)bAPEntity;
        return this.cardStatus == eTC_Status_Status.cardStatus && this.extension1 == eTC_Status_Status.extension1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ETC_Status_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.cardStatus);
        bitStream.pushByte((byte)this.extension1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 56;
    }

    @Override
    public int getFunctionId() {
        return ETC_Status_Status.functionId();
    }
}

