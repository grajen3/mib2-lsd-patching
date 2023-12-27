/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_ListAvailable2
implements BAPEntity {
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean reserved_bit_1;
    public boolean lastStationListAvailable;

    public ActiveSource_ListAvailable2() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_ListAvailable2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.reserved_bit_1 = false;
        this.lastStationListAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_ListAvailable2 activeSource_ListAvailable2 = (ActiveSource_ListAvailable2)bAPEntity;
        return this.reserved_bit_3 == activeSource_ListAvailable2.reserved_bit_3 && this.reserved_bit_2 == activeSource_ListAvailable2.reserved_bit_2 && this.reserved_bit_1 == activeSource_ListAvailable2.reserved_bit_1 && this.lastStationListAvailable == activeSource_ListAvailable2.lastStationListAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveSource_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.lastStationListAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_3 = bitStream.popFrontBoolean();
        this.reserved_bit_2 = bitStream.popFrontBoolean();
        this.reserved_bit_1 = bitStream.popFrontBoolean();
        this.lastStationListAvailable = bitStream.popFrontBoolean();
    }
}

