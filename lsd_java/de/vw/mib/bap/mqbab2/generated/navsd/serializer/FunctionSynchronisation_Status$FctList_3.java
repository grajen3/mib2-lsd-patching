/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status$FctList_3
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE;

    public FunctionSynchronisation_Status$FctList_3() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status$FctList_3(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return true;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FctList_3:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

