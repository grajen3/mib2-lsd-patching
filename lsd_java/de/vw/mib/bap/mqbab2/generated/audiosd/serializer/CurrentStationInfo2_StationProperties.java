/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo2_StationProperties
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean onlineBufferingActive;
    public boolean ballGameModeActive;
    public boolean stationLinkedToOnlineRadio;
    public boolean dabServiceDoesNotContainAnyAudioSignal;
    public boolean ibocLiveTransmissionActiveHdLiveMode;
    public boolean dabServiceLinkedToFm;
    public boolean reserved_bit_15;
    public boolean reserved_bit_14;
    public boolean reserved_bit_13;
    public boolean reserved_bit_12;
    public boolean reserved_bit_11;
    public boolean reserved_bit_10;
    public boolean reserved_bit_9;
    public boolean reserved_bit_8;

    public CurrentStationInfo2_StationProperties() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo2_StationProperties(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.onlineBufferingActive = false;
        this.ballGameModeActive = false;
        this.stationLinkedToOnlineRadio = false;
        this.dabServiceDoesNotContainAnyAudioSignal = false;
        this.ibocLiveTransmissionActiveHdLiveMode = false;
        this.dabServiceLinkedToFm = false;
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
        CurrentStationInfo2_StationProperties currentStationInfo2_StationProperties = (CurrentStationInfo2_StationProperties)bAPEntity;
        return this.reserved_bit_7 == currentStationInfo2_StationProperties.reserved_bit_7 && this.reserved_bit_6 == currentStationInfo2_StationProperties.reserved_bit_6 && this.onlineBufferingActive == currentStationInfo2_StationProperties.onlineBufferingActive && this.ballGameModeActive == currentStationInfo2_StationProperties.ballGameModeActive && this.stationLinkedToOnlineRadio == currentStationInfo2_StationProperties.stationLinkedToOnlineRadio && this.dabServiceDoesNotContainAnyAudioSignal == currentStationInfo2_StationProperties.dabServiceDoesNotContainAnyAudioSignal && this.ibocLiveTransmissionActiveHdLiveMode == currentStationInfo2_StationProperties.ibocLiveTransmissionActiveHdLiveMode && this.dabServiceLinkedToFm == currentStationInfo2_StationProperties.dabServiceLinkedToFm && this.reserved_bit_15 == currentStationInfo2_StationProperties.reserved_bit_15 && this.reserved_bit_14 == currentStationInfo2_StationProperties.reserved_bit_14 && this.reserved_bit_13 == currentStationInfo2_StationProperties.reserved_bit_13 && this.reserved_bit_12 == currentStationInfo2_StationProperties.reserved_bit_12 && this.reserved_bit_11 == currentStationInfo2_StationProperties.reserved_bit_11 && this.reserved_bit_10 == currentStationInfo2_StationProperties.reserved_bit_10 && this.reserved_bit_9 == currentStationInfo2_StationProperties.reserved_bit_9 && this.reserved_bit_8 == currentStationInfo2_StationProperties.reserved_bit_8;
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
        bitStream.pushBoolean(this.onlineBufferingActive);
        bitStream.pushBoolean(this.ballGameModeActive);
        bitStream.pushBoolean(this.stationLinkedToOnlineRadio);
        bitStream.pushBoolean(this.dabServiceDoesNotContainAnyAudioSignal);
        bitStream.pushBoolean(this.ibocLiveTransmissionActiveHdLiveMode);
        bitStream.pushBoolean(this.dabServiceLinkedToFm);
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
        this.onlineBufferingActive = bitStream.popFrontBoolean();
        this.ballGameModeActive = bitStream.popFrontBoolean();
        this.stationLinkedToOnlineRadio = bitStream.popFrontBoolean();
        this.dabServiceDoesNotContainAnyAudioSignal = bitStream.popFrontBoolean();
        this.ibocLiveTransmissionActiveHdLiveMode = bitStream.popFrontBoolean();
        this.dabServiceLinkedToFm = bitStream.popFrontBoolean();
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

