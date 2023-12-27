/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SyncMediaBrowsing_CursorMerge;
import de.vw.mib.bap.stream.BitStream;

public final class SyncMediaBrowsing_Status
implements BAPEntity {
    public final SyncMediaBrowsing_CursorMerge cursorMerge = new SyncMediaBrowsing_CursorMerge();

    public SyncMediaBrowsing_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SyncMediaBrowsing_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.cursorMerge.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SyncMediaBrowsing_Status syncMediaBrowsing_Status = (SyncMediaBrowsing_Status)bAPEntity;
        return this.cursorMerge.equalTo(syncMediaBrowsing_Status.cursorMerge);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SyncMediaBrowsing_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.cursorMerge.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

