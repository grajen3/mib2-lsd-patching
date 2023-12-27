/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status$StationInfoSwitches
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean reserved_bit_5;
    public boolean reserved_bit_4;
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean tmcAvailable;
    public boolean taTpAvailable;

    public CurrentStationInfo_Status$StationInfoSwitches() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_Status$StationInfoSwitches(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_4 = false;
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.tmcAvailable = false;
        this.taTpAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status$StationInfoSwitches currentStationInfo_Status$StationInfoSwitches = (CurrentStationInfo_Status$StationInfoSwitches)bAPEntity;
        return this.reserved_bit_7 == currentStationInfo_Status$StationInfoSwitches.reserved_bit_7 && this.reserved_bit_6 == currentStationInfo_Status$StationInfoSwitches.reserved_bit_6 && this.reserved_bit_5 == currentStationInfo_Status$StationInfoSwitches.reserved_bit_5 && this.reserved_bit_4 == currentStationInfo_Status$StationInfoSwitches.reserved_bit_4 && this.reserved_bit_3 == currentStationInfo_Status$StationInfoSwitches.reserved_bit_3 && this.reserved_bit_2 == currentStationInfo_Status$StationInfoSwitches.reserved_bit_2 && this.tmcAvailable == currentStationInfo_Status$StationInfoSwitches.tmcAvailable && this.taTpAvailable == currentStationInfo_Status$StationInfoSwitches.taTpAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "StationInfoSwitches:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.reserved_bit_5);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.tmcAvailable);
        bitStream.pushBoolean(this.taTpAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

