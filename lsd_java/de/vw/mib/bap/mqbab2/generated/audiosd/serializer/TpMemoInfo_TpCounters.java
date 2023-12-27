/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_TpCounters
implements BAPEntity {
    public static final int CURRENT_MSG_NUMBER_MIN;
    public int currentMsgNumber;
    public static final int TOTAL_MSG_NUMBER_MIN;
    public int totalMsgNumber;

    public TpMemoInfo_TpCounters() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_TpCounters(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentMsgNumber = 0;
        this.totalMsgNumber = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoInfo_TpCounters tpMemoInfo_TpCounters = (TpMemoInfo_TpCounters)bAPEntity;
        return this.currentMsgNumber == tpMemoInfo_TpCounters.currentMsgNumber && this.totalMsgNumber == tpMemoInfo_TpCounters.totalMsgNumber;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TpMemoInfo_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.currentMsgNumber);
        bitStream.pushByte((byte)this.totalMsgNumber);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.currentMsgNumber = bitStream.popFrontByte();
        this.totalMsgNumber = bitStream.popFrontByte();
    }
}

