/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_MessageTime
implements BAPEntity {
    public static final int HOUR_MIN;
    public int hour;
    public static final int MINUTE_MIN;
    public int minute;

    public TpMemoInfo_MessageTime() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_MessageTime(BitStream bitStream) {
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
        TpMemoInfo_MessageTime tpMemoInfo_MessageTime = (TpMemoInfo_MessageTime)bAPEntity;
        return this.hour == tpMemoInfo_MessageTime.hour && this.minute == tpMemoInfo_MessageTime.minute;
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
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.minute);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.hour = bitStream.popFrontByte();
        this.minute = bitStream.popFrontByte();
    }
}

