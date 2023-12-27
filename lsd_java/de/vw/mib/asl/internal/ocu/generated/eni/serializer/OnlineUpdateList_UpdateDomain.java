/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateList_UpdateDomain
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean ccuNad;

    public OnlineUpdateList_UpdateDomain() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateList_UpdateDomain(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccuNad = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateList_UpdateDomain onlineUpdateList_UpdateDomain = (OnlineUpdateList_UpdateDomain)bAPEntity;
        return this.ccuNad == onlineUpdateList_UpdateDomain.ccuNad;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.ccuNad);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.ccuNad = bitStream.popFrontBoolean();
    }
}

