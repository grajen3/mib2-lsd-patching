/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean reserved_bit_2;
    public boolean reserved_bit_1;
    public boolean newMessage;

    public TpMemoList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_2 = false;
        this.reserved_bit_1 = false;
        this.newMessage = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoList_Attributes tpMemoList_Attributes = (TpMemoList_Attributes)bAPEntity;
        return this.reserved_bit_2 == tpMemoList_Attributes.reserved_bit_2 && this.reserved_bit_1 == tpMemoList_Attributes.reserved_bit_1 && this.newMessage == tpMemoList_Attributes.newMessage;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TpMemoList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.newMessage);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.reserved_bit_2 = bitStream.popFrontBoolean();
        this.reserved_bit_1 = bitStream.popFrontBoolean();
        this.newMessage = bitStream.popFrontBoolean();
    }
}

