/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class LastStationList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_12__15_BITSIZE;
    public boolean stationLinkedToFm;
    public boolean stationLinkedToOnlineRadio;
    public boolean mutingLowSignal;
    public boolean stationNotSelectable;
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean onlineRadioPrimaryServiceContainsSecondaryServiceS;
    public boolean onlineRadioSecondaryService;
    public boolean dabPrimaryServiceContainsSecondaryServiceS;
    public boolean dabSecondaryService;
    public boolean ibocService;

    public LastStationList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public LastStationList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stationLinkedToFm = false;
        this.stationLinkedToOnlineRadio = false;
        this.mutingLowSignal = false;
        this.stationNotSelectable = false;
        this.sdarsStationSubscribedOrNotAnSdarsStation = false;
        this.tmcAvailableSupportedByStation = false;
        this.tpAvailableSupportedByStation = false;
        this.onlineRadioPrimaryServiceContainsSecondaryServiceS = false;
        this.onlineRadioSecondaryService = false;
        this.dabPrimaryServiceContainsSecondaryServiceS = false;
        this.dabSecondaryService = false;
        this.ibocService = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LastStationList_Attributes lastStationList_Attributes = (LastStationList_Attributes)bAPEntity;
        return this.stationLinkedToFm == lastStationList_Attributes.stationLinkedToFm && this.stationLinkedToOnlineRadio == lastStationList_Attributes.stationLinkedToOnlineRadio && this.mutingLowSignal == lastStationList_Attributes.mutingLowSignal && this.stationNotSelectable == lastStationList_Attributes.stationNotSelectable && this.sdarsStationSubscribedOrNotAnSdarsStation == lastStationList_Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == lastStationList_Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == lastStationList_Attributes.tpAvailableSupportedByStation && this.onlineRadioPrimaryServiceContainsSecondaryServiceS == lastStationList_Attributes.onlineRadioPrimaryServiceContainsSecondaryServiceS && this.onlineRadioSecondaryService == lastStationList_Attributes.onlineRadioSecondaryService && this.dabPrimaryServiceContainsSecondaryServiceS == lastStationList_Attributes.dabPrimaryServiceContainsSecondaryServiceS && this.dabSecondaryService == lastStationList_Attributes.dabSecondaryService && this.ibocService == lastStationList_Attributes.ibocService;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "LastStationList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.stationLinkedToFm);
        bitStream.pushBoolean(this.stationLinkedToOnlineRadio);
        bitStream.pushBoolean(this.mutingLowSignal);
        bitStream.pushBoolean(this.stationNotSelectable);
        bitStream.pushBoolean(this.sdarsStationSubscribedOrNotAnSdarsStation);
        bitStream.pushBoolean(this.tmcAvailableSupportedByStation);
        bitStream.pushBoolean(this.tpAvailableSupportedByStation);
        bitStream.pushBoolean(this.onlineRadioPrimaryServiceContainsSecondaryServiceS);
        bitStream.pushBoolean(this.onlineRadioSecondaryService);
        bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryServiceS);
        bitStream.pushBoolean(this.dabSecondaryService);
        bitStream.pushBoolean(this.ibocService);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.stationLinkedToFm = bitStream.popFrontBoolean();
        this.stationLinkedToOnlineRadio = bitStream.popFrontBoolean();
        this.mutingLowSignal = bitStream.popFrontBoolean();
        this.stationNotSelectable = bitStream.popFrontBoolean();
        this.sdarsStationSubscribedOrNotAnSdarsStation = bitStream.popFrontBoolean();
        this.tmcAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.tpAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.onlineRadioPrimaryServiceContainsSecondaryServiceS = bitStream.popFrontBoolean();
        this.onlineRadioSecondaryService = bitStream.popFrontBoolean();
        this.dabPrimaryServiceContainsSecondaryServiceS = bitStream.popFrontBoolean();
        this.dabSecondaryService = bitStream.popFrontBoolean();
        this.ibocService = bitStream.popFrontBoolean();
    }
}

