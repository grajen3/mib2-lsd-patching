/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallStackDeleteAll_StartResult$Storage
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean deleteDialedNumbers;
    public boolean deleteReceivedCalls;
    public boolean deleteMissedCalls;

    public CallStackDeleteAll_StartResult$Storage() {
        this.internalReset();
        this.customInitialization();
    }

    public CallStackDeleteAll_StartResult$Storage(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.deleteDialedNumbers = false;
        this.deleteReceivedCalls = false;
        this.deleteMissedCalls = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallStackDeleteAll_StartResult$Storage callStackDeleteAll_StartResult$Storage = (CallStackDeleteAll_StartResult$Storage)bAPEntity;
        return this.deleteDialedNumbers == callStackDeleteAll_StartResult$Storage.deleteDialedNumbers && this.deleteReceivedCalls == callStackDeleteAll_StartResult$Storage.deleteReceivedCalls && this.deleteMissedCalls == callStackDeleteAll_StartResult$Storage.deleteMissedCalls;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Storage:";
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
        bitStream.discardBits(5);
        this.deleteDialedNumbers = bitStream.popFrontBoolean();
        this.deleteReceivedCalls = bitStream.popFrontBoolean();
        this.deleteMissedCalls = bitStream.popFrontBoolean();
    }
}

