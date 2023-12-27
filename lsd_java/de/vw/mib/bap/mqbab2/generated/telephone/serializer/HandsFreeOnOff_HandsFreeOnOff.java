/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class HandsFreeOnOff_HandsFreeOnOff
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean on;

    public HandsFreeOnOff_HandsFreeOnOff() {
        this.internalReset();
        this.customInitialization();
    }

    public HandsFreeOnOff_HandsFreeOnOff(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.on = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HandsFreeOnOff_HandsFreeOnOff handsFreeOnOff_HandsFreeOnOff = (HandsFreeOnOff_HandsFreeOnOff)bAPEntity;
        return this.on == handsFreeOnOff_HandsFreeOnOff.on;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "HandsFreeOnOff_HandsFreeOnOff:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.on);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.on = bitStream.popFrontBoolean();
    }
}

