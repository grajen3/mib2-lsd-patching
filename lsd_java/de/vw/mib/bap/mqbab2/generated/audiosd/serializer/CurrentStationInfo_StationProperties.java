/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_StationProperties
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean stationLinkedToOnlineRadioDf4_1;
    public boolean dabServiceDoesNotContainAnyAudioSignalDf4_1;
    public boolean ibocLiveTransmissionActiveHdLiveMode;
    public boolean dabServiceLinkedToFm;

    public CurrentStationInfo_StationProperties() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_StationProperties(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stationLinkedToOnlineRadioDf4_1 = false;
        this.dabServiceDoesNotContainAnyAudioSignalDf4_1 = false;
        this.ibocLiveTransmissionActiveHdLiveMode = false;
        this.dabServiceLinkedToFm = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_StationProperties currentStationInfo_StationProperties = (CurrentStationInfo_StationProperties)bAPEntity;
        return this.stationLinkedToOnlineRadioDf4_1 == currentStationInfo_StationProperties.stationLinkedToOnlineRadioDf4_1 && this.dabServiceDoesNotContainAnyAudioSignalDf4_1 == currentStationInfo_StationProperties.dabServiceDoesNotContainAnyAudioSignalDf4_1 && this.ibocLiveTransmissionActiveHdLiveMode == currentStationInfo_StationProperties.ibocLiveTransmissionActiveHdLiveMode && this.dabServiceLinkedToFm == currentStationInfo_StationProperties.dabServiceLinkedToFm;
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
        bitStream.pushBoolean(this.stationLinkedToOnlineRadioDf4_1);
        bitStream.pushBoolean(this.dabServiceDoesNotContainAnyAudioSignalDf4_1);
        bitStream.pushBoolean(this.ibocLiveTransmissionActiveHdLiveMode);
        bitStream.pushBoolean(this.dabServiceLinkedToFm);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.stationLinkedToOnlineRadioDf4_1 = bitStream.popFrontBoolean();
        this.dabServiceDoesNotContainAnyAudioSignalDf4_1 = bitStream.popFrontBoolean();
        this.ibocLiveTransmissionActiveHdLiveMode = bitStream.popFrontBoolean();
        this.dabServiceLinkedToFm = bitStream.popFrontBoolean();
    }
}

