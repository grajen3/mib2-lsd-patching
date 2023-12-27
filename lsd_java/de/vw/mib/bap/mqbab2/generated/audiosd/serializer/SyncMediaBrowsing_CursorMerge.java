/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SyncMediaBrowsing_CursorMerge
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean doCursorMerge;

    public SyncMediaBrowsing_CursorMerge() {
        this.internalReset();
        this.customInitialization();
    }

    public SyncMediaBrowsing_CursorMerge(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.doCursorMerge = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SyncMediaBrowsing_CursorMerge syncMediaBrowsing_CursorMerge = (SyncMediaBrowsing_CursorMerge)bAPEntity;
        return this.doCursorMerge == syncMediaBrowsing_CursorMerge.doCursorMerge;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SyncMediaBrowsing_CursorMerge:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.doCursorMerge);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.doCursorMerge = bitStream.popFrontBoolean();
    }
}

