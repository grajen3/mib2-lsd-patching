/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpInfo_Status$MessageTime
implements BAPEntity {
    public int hour;
    public int minute;

    public TpInfo_Status$MessageTime() {
        this.internalReset();
        this.customInitialization();
    }

    public TpInfo_Status$MessageTime(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.hour = 0;
        this.minute = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpInfo_Status$MessageTime tpInfo_Status$MessageTime = (TpInfo_Status$MessageTime)bAPEntity;
        return this.hour == tpInfo_Status$MessageTime.hour && this.minute == tpInfo_Status$MessageTime.minute;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MessageTime:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.minute);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

