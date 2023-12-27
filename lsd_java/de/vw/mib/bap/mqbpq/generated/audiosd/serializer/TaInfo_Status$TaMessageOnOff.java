/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TaInfo_Status$TaMessageOnOff
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean taMessageActive;

    public TaInfo_Status$TaMessageOnOff() {
        this.internalReset();
        this.customInitialization();
    }

    public TaInfo_Status$TaMessageOnOff(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.taMessageActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TaInfo_Status$TaMessageOnOff taInfo_Status$TaMessageOnOff = (TaInfo_Status$TaMessageOnOff)bAPEntity;
        return this.taMessageActive == taInfo_Status$TaMessageOnOff.taMessageActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TaMessageOnOff:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.taMessageActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

