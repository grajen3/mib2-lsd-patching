/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_13__15_BITSIZE;
    public boolean stationLinkedToOnlineRadioDf4_5;
    public boolean onlineRadioMutingLowSignalDf4_5;
    public boolean stationSelectableDf4_5;
    public boolean fmLinkedToOnlineRadioDf4_1;
    public boolean dabServiceLinkedToOnlineRadioDf4_1;
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean dabServiceLinkedToFm;
    public boolean dabPrimaryServiceCorrupted;
    public boolean dabPrimaryServiceContainsSecondaryServiceS;
    public boolean dvbServiceCorrupted;
    public boolean available;

    public ReceptionList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stationLinkedToOnlineRadioDf4_5 = false;
        this.onlineRadioMutingLowSignalDf4_5 = false;
        this.stationSelectableDf4_5 = false;
        this.fmLinkedToOnlineRadioDf4_1 = false;
        this.dabServiceLinkedToOnlineRadioDf4_1 = false;
        this.sdarsStationSubscribedOrNotAnSdarsStation = false;
        this.tmcAvailableSupportedByStation = false;
        this.tpAvailableSupportedByStation = false;
        this.dabServiceLinkedToFm = false;
        this.dabPrimaryServiceCorrupted = false;
        this.dabPrimaryServiceContainsSecondaryServiceS = false;
        this.dvbServiceCorrupted = false;
        this.available = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_Attributes receptionList_Attributes = (ReceptionList_Attributes)bAPEntity;
        return this.stationLinkedToOnlineRadioDf4_5 == receptionList_Attributes.stationLinkedToOnlineRadioDf4_5 && this.onlineRadioMutingLowSignalDf4_5 == receptionList_Attributes.onlineRadioMutingLowSignalDf4_5 && this.stationSelectableDf4_5 == receptionList_Attributes.stationSelectableDf4_5 && this.fmLinkedToOnlineRadioDf4_1 == receptionList_Attributes.fmLinkedToOnlineRadioDf4_1 && this.dabServiceLinkedToOnlineRadioDf4_1 == receptionList_Attributes.dabServiceLinkedToOnlineRadioDf4_1 && this.sdarsStationSubscribedOrNotAnSdarsStation == receptionList_Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == receptionList_Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == receptionList_Attributes.tpAvailableSupportedByStation && this.dabServiceLinkedToFm == receptionList_Attributes.dabServiceLinkedToFm && this.dabPrimaryServiceCorrupted == receptionList_Attributes.dabPrimaryServiceCorrupted && this.dabPrimaryServiceContainsSecondaryServiceS == receptionList_Attributes.dabPrimaryServiceContainsSecondaryServiceS && this.dvbServiceCorrupted == receptionList_Attributes.dvbServiceCorrupted && this.available == receptionList_Attributes.available;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ReceptionList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.stationLinkedToOnlineRadioDf4_5);
        bitStream.pushBoolean(this.onlineRadioMutingLowSignalDf4_5);
        bitStream.pushBoolean(this.stationSelectableDf4_5);
        bitStream.pushBoolean(this.fmLinkedToOnlineRadioDf4_1);
        bitStream.pushBoolean(this.dabServiceLinkedToOnlineRadioDf4_1);
        bitStream.pushBoolean(this.sdarsStationSubscribedOrNotAnSdarsStation);
        bitStream.pushBoolean(this.tmcAvailableSupportedByStation);
        bitStream.pushBoolean(this.tpAvailableSupportedByStation);
        bitStream.pushBoolean(this.dabServiceLinkedToFm);
        bitStream.pushBoolean(this.dabPrimaryServiceCorrupted);
        bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryServiceS);
        bitStream.pushBoolean(this.dvbServiceCorrupted);
        bitStream.pushBoolean(this.available);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.stationLinkedToOnlineRadioDf4_5 = bitStream.popFrontBoolean();
        this.onlineRadioMutingLowSignalDf4_5 = bitStream.popFrontBoolean();
        this.stationSelectableDf4_5 = bitStream.popFrontBoolean();
        this.fmLinkedToOnlineRadioDf4_1 = bitStream.popFrontBoolean();
        this.dabServiceLinkedToOnlineRadioDf4_1 = bitStream.popFrontBoolean();
        this.sdarsStationSubscribedOrNotAnSdarsStation = bitStream.popFrontBoolean();
        this.tmcAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.tpAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.dabServiceLinkedToFm = bitStream.popFrontBoolean();
        this.dabPrimaryServiceCorrupted = bitStream.popFrontBoolean();
        this.dabPrimaryServiceContainsSecondaryServiceS = bitStream.popFrontBoolean();
        this.dvbServiceCorrupted = bitStream.popFrontBoolean();
        this.available = bitStream.popFrontBoolean();
    }
}

