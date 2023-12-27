/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RadioTV_PresetList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_11__15_BITSIZE;
    public boolean stationLinkedToOnlineRadioDf4_5;
    public boolean onlineRadioMutingLowSignalDf4_5;
    public boolean stationSelectableDf4_5;
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean onlineRadioPrimaryServiceContainsSecondaryServiceSDf4_1;
    public boolean onlineRadioSecondaryServiceDf4_1;
    public boolean dabPrimaryServiceContainsSecondaryServiceS;
    public boolean dabSecondaryService;
    public boolean ibocService;

    public RadioTV_PresetList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public RadioTV_PresetList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stationLinkedToOnlineRadioDf4_5 = false;
        this.onlineRadioMutingLowSignalDf4_5 = false;
        this.stationSelectableDf4_5 = false;
        this.sdarsStationSubscribedOrNotAnSdarsStation = false;
        this.tmcAvailableSupportedByStation = false;
        this.tpAvailableSupportedByStation = false;
        this.onlineRadioPrimaryServiceContainsSecondaryServiceSDf4_1 = false;
        this.onlineRadioSecondaryServiceDf4_1 = false;
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
        RadioTV_PresetList_Attributes radioTV_PresetList_Attributes = (RadioTV_PresetList_Attributes)bAPEntity;
        return this.stationLinkedToOnlineRadioDf4_5 == radioTV_PresetList_Attributes.stationLinkedToOnlineRadioDf4_5 && this.onlineRadioMutingLowSignalDf4_5 == radioTV_PresetList_Attributes.onlineRadioMutingLowSignalDf4_5 && this.stationSelectableDf4_5 == radioTV_PresetList_Attributes.stationSelectableDf4_5 && this.sdarsStationSubscribedOrNotAnSdarsStation == radioTV_PresetList_Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == radioTV_PresetList_Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == radioTV_PresetList_Attributes.tpAvailableSupportedByStation && this.onlineRadioPrimaryServiceContainsSecondaryServiceSDf4_1 == radioTV_PresetList_Attributes.onlineRadioPrimaryServiceContainsSecondaryServiceSDf4_1 && this.onlineRadioSecondaryServiceDf4_1 == radioTV_PresetList_Attributes.onlineRadioSecondaryServiceDf4_1 && this.dabPrimaryServiceContainsSecondaryServiceS == radioTV_PresetList_Attributes.dabPrimaryServiceContainsSecondaryServiceS && this.dabSecondaryService == radioTV_PresetList_Attributes.dabSecondaryService && this.ibocService == radioTV_PresetList_Attributes.ibocService;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RadioTV_PresetList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.stationLinkedToOnlineRadioDf4_5);
        bitStream.pushBoolean(this.onlineRadioMutingLowSignalDf4_5);
        bitStream.pushBoolean(this.stationSelectableDf4_5);
        bitStream.pushBoolean(this.sdarsStationSubscribedOrNotAnSdarsStation);
        bitStream.pushBoolean(this.tmcAvailableSupportedByStation);
        bitStream.pushBoolean(this.tpAvailableSupportedByStation);
        bitStream.pushBoolean(this.onlineRadioPrimaryServiceContainsSecondaryServiceSDf4_1);
        bitStream.pushBoolean(this.onlineRadioSecondaryServiceDf4_1);
        bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryServiceS);
        bitStream.pushBoolean(this.dabSecondaryService);
        bitStream.pushBoolean(this.ibocService);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.stationLinkedToOnlineRadioDf4_5 = bitStream.popFrontBoolean();
        this.onlineRadioMutingLowSignalDf4_5 = bitStream.popFrontBoolean();
        this.stationSelectableDf4_5 = bitStream.popFrontBoolean();
        this.sdarsStationSubscribedOrNotAnSdarsStation = bitStream.popFrontBoolean();
        this.tmcAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.tpAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.onlineRadioPrimaryServiceContainsSecondaryServiceSDf4_1 = bitStream.popFrontBoolean();
        this.onlineRadioSecondaryServiceDf4_1 = bitStream.popFrontBoolean();
        this.dabPrimaryServiceContainsSecondaryServiceS = bitStream.popFrontBoolean();
        this.dabSecondaryService = bitStream.popFrontBoolean();
        this.ibocService = bitStream.popFrontBoolean();
    }
}

