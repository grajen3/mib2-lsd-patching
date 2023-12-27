/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SyncMediaBrowsing_CursorMerge;
import de.vw.mib.bap.stream.BitStream;

public final class SyncMediaBrowsing_SetGet
implements BAPEntity {
    public final SyncMediaBrowsing_CursorMerge cursorMerge = new SyncMediaBrowsing_CursorMerge();

    public SyncMediaBrowsing_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public SyncMediaBrowsing_SetGet(BitStream bitStream) {
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
        SyncMediaBrowsing_SetGet syncMediaBrowsing_SetGet = (SyncMediaBrowsing_SetGet)bAPEntity;
        return this.cursorMerge.equalTo(syncMediaBrowsing_SetGet.cursorMerge);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SyncMediaBrowsing_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.cursorMerge.deserialize(bitStream);
    }
}

