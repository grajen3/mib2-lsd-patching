/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_Status$ListAvailable
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean listAvailable;

    public ActiveSource_Status$ListAvailable() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_Status$ListAvailable(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.listAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_Status$ListAvailable activeSource_Status$ListAvailable = (ActiveSource_Status$ListAvailable)bAPEntity;
        return this.listAvailable == activeSource_Status$ListAvailable.listAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ListAvailable:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.listAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

