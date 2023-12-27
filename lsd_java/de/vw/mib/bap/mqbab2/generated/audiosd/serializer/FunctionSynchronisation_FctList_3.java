/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_FctList_3
implements BAPEntity {
    public boolean reserved_bit_0;
    private static final int RESERVED_BIT_1__7_BITSIZE;

    public FunctionSynchronisation_FctList_3() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_FctList_3(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_FctList_3 functionSynchronisation_FctList_3 = (FunctionSynchronisation_FctList_3)bAPEntity;
        return this.reserved_bit_0 == functionSynchronisation_FctList_3.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionSynchronisation_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.resetBits(7);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        bitStream.discardBits(7);
    }
}

