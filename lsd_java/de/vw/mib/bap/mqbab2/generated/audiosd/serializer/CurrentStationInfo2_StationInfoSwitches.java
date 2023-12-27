/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo2_StationInfoSwitches
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean reserved_bit_5;
    public boolean reserved_bit_4;
    public boolean ibocHdRadioAvailable;
    public boolean vicsAvailableJapanMarketOnly;
    public boolean tmcAvailable;
    public boolean taTpAvailable;
    public boolean reserved_bit_15;
    public boolean reserved_bit_14;
    public boolean reserved_bit_13;
    public boolean reserved_bit_12;
    public boolean reserved_bit_11;
    public boolean reserved_bit_10;
    public boolean reserved_bit_9;
    public boolean reserved_bit_8;

    public CurrentStationInfo2_StationInfoSwitches() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo2_StationInfoSwitches(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_4 = false;
        this.ibocHdRadioAvailable = false;
        this.vicsAvailableJapanMarketOnly = false;
        this.tmcAvailable = false;
        this.taTpAvailable = false;
        this.reserved_bit_15 = false;
        this.reserved_bit_14 = false;
        this.reserved_bit_13 = false;
        this.reserved_bit_12 = false;
        this.reserved_bit_11 = false;
        this.reserved_bit_10 = false;
        this.reserved_bit_9 = false;
        this.reserved_bit_8 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo2_StationInfoSwitches currentStationInfo2_StationInfoSwitches = (CurrentStationInfo2_StationInfoSwitches)bAPEntity;
        return this.reserved_bit_7 == currentStationInfo2_StationInfoSwitches.reserved_bit_7 && this.reserved_bit_6 == currentStationInfo2_StationInfoSwitches.reserved_bit_6 && this.reserved_bit_5 == currentStationInfo2_StationInfoSwitches.reserved_bit_5 && this.reserved_bit_4 == currentStationInfo2_StationInfoSwitches.reserved_bit_4 && this.ibocHdRadioAvailable == currentStationInfo2_StationInfoSwitches.ibocHdRadioAvailable && this.vicsAvailableJapanMarketOnly == currentStationInfo2_StationInfoSwitches.vicsAvailableJapanMarketOnly && this.tmcAvailable == currentStationInfo2_StationInfoSwitches.tmcAvailable && this.taTpAvailable == currentStationInfo2_StationInfoSwitches.taTpAvailable && this.reserved_bit_15 == currentStationInfo2_StationInfoSwitches.reserved_bit_15 && this.reserved_bit_14 == currentStationInfo2_StationInfoSwitches.reserved_bit_14 && this.reserved_bit_13 == currentStationInfo2_StationInfoSwitches.reserved_bit_13 && this.reserved_bit_12 == currentStationInfo2_StationInfoSwitches.reserved_bit_12 && this.reserved_bit_11 == currentStationInfo2_StationInfoSwitches.reserved_bit_11 && this.reserved_bit_10 == currentStationInfo2_StationInfoSwitches.reserved_bit_10 && this.reserved_bit_9 == currentStationInfo2_StationInfoSwitches.reserved_bit_9 && this.reserved_bit_8 == currentStationInfo2_StationInfoSwitches.reserved_bit_8;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentStationInfo2_Empty:";
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
        bitStream.pushBoolean(this.ibocHdRadioAvailable);
        bitStream.pushBoolean(this.vicsAvailableJapanMarketOnly);
        bitStream.pushBoolean(this.tmcAvailable);
        bitStream.pushBoolean(this.taTpAvailable);
        bitStream.pushBoolean(this.reserved_bit_15);
        bitStream.pushBoolean(this.reserved_bit_14);
        bitStream.pushBoolean(this.reserved_bit_13);
        bitStream.pushBoolean(this.reserved_bit_12);
        bitStream.pushBoolean(this.reserved_bit_11);
        bitStream.pushBoolean(this.reserved_bit_10);
        bitStream.pushBoolean(this.reserved_bit_9);
        bitStream.pushBoolean(this.reserved_bit_8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.reserved_bit_6 = bitStream.popFrontBoolean();
        this.reserved_bit_5 = bitStream.popFrontBoolean();
        this.reserved_bit_4 = bitStream.popFrontBoolean();
        this.ibocHdRadioAvailable = bitStream.popFrontBoolean();
        this.vicsAvailableJapanMarketOnly = bitStream.popFrontBoolean();
        this.tmcAvailable = bitStream.popFrontBoolean();
        this.taTpAvailable = bitStream.popFrontBoolean();
        this.reserved_bit_15 = bitStream.popFrontBoolean();
        this.reserved_bit_14 = bitStream.popFrontBoolean();
        this.reserved_bit_13 = bitStream.popFrontBoolean();
        this.reserved_bit_12 = bitStream.popFrontBoolean();
        this.reserved_bit_11 = bitStream.popFrontBoolean();
        this.reserved_bit_10 = bitStream.popFrontBoolean();
        this.reserved_bit_9 = bitStream.popFrontBoolean();
        this.reserved_bit_8 = bitStream.popFrontBoolean();
    }
}

