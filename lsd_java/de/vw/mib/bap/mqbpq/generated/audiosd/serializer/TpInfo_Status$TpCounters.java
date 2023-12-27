/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpInfo_Status$TpCounters
implements BAPEntity {
    public int currentMsgNumber;
    public int totalMsgNumber;

    public TpInfo_Status$TpCounters() {
        this.internalReset();
        this.customInitialization();
    }

    public TpInfo_Status$TpCounters(BitStream bitStream) {
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
        TpInfo_Status$TpCounters tpInfo_Status$TpCounters = (TpInfo_Status$TpCounters)bAPEntity;
        return this.currentMsgNumber == tpInfo_Status$TpCounters.currentMsgNumber && this.totalMsgNumber == tpInfo_Status$TpCounters.totalMsgNumber;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TpCounters:";
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
    }
}

