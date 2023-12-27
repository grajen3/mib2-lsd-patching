/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_StationInfoSwitches
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean ibocHdRadioAvailable;
    public boolean vicsAvailableJapanMarketOnly;
    public boolean tmcAvailable;
    public boolean taTpAvailable;

    public CurrentStationInfo_StationInfoSwitches() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_StationInfoSwitches(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ibocHdRadioAvailable = false;
        this.vicsAvailableJapanMarketOnly = false;
        this.tmcAvailable = false;
        this.taTpAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_StationInfoSwitches currentStationInfo_StationInfoSwitches = (CurrentStationInfo_StationInfoSwitches)bAPEntity;
        return this.ibocHdRadioAvailable == currentStationInfo_StationInfoSwitches.ibocHdRadioAvailable && this.vicsAvailableJapanMarketOnly == currentStationInfo_StationInfoSwitches.vicsAvailableJapanMarketOnly && this.tmcAvailable == currentStationInfo_StationInfoSwitches.tmcAvailable && this.taTpAvailable == currentStationInfo_StationInfoSwitches.taTpAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentStationInfo_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.ibocHdRadioAvailable);
        bitStream.pushBoolean(this.vicsAvailableJapanMarketOnly);
        bitStream.pushBoolean(this.tmcAvailable);
        bitStream.pushBoolean(this.taTpAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.ibocHdRadioAvailable = bitStream.popFrontBoolean();
        this.vicsAvailableJapanMarketOnly = bitStream.popFrontBoolean();
        this.tmcAvailable = bitStream.popFrontBoolean();
        this.taTpAvailable = bitStream.popFrontBoolean();
    }
}

