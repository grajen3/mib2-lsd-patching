/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CommonList_Data$Attributes
implements BAPEntity {
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean dabServiceLinkedToFm;
    public boolean dabPrimaryServiceCorrupted;
    public boolean dabPrimaryServiceContainsSecondaryService;
    public boolean dvbServiceCorrupted;
    public boolean available;
    private static final int RESERVED_BIT_10__15_BITSIZE;
    public boolean fmLinkedToOnlineRadio;
    public boolean dabServiceLinkedToOnlineRadio;

    public CommonList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public CommonList_Data$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sdarsStationSubscribedOrNotAnSdarsStation = false;
        this.tmcAvailableSupportedByStation = false;
        this.tpAvailableSupportedByStation = false;
        this.dabServiceLinkedToFm = false;
        this.dabPrimaryServiceCorrupted = false;
        this.dabPrimaryServiceContainsSecondaryService = false;
        this.dvbServiceCorrupted = false;
        this.available = false;
        this.fmLinkedToOnlineRadio = false;
        this.dabServiceLinkedToOnlineRadio = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CommonList_Data$Attributes commonList_Data$Attributes = (CommonList_Data$Attributes)bAPEntity;
        return this.sdarsStationSubscribedOrNotAnSdarsStation == commonList_Data$Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == commonList_Data$Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == commonList_Data$Attributes.tpAvailableSupportedByStation && this.dabServiceLinkedToFm == commonList_Data$Attributes.dabServiceLinkedToFm && this.dabPrimaryServiceCorrupted == commonList_Data$Attributes.dabPrimaryServiceCorrupted && this.dabPrimaryServiceContainsSecondaryService == commonList_Data$Attributes.dabPrimaryServiceContainsSecondaryService && this.dvbServiceCorrupted == commonList_Data$Attributes.dvbServiceCorrupted && this.available == commonList_Data$Attributes.available && this.fmLinkedToOnlineRadio == commonList_Data$Attributes.fmLinkedToOnlineRadio && this.dabServiceLinkedToOnlineRadio == commonList_Data$Attributes.dabServiceLinkedToOnlineRadio;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Attributes:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.sdarsStationSubscribedOrNotAnSdarsStation);
        bitStream.pushBoolean(this.tmcAvailableSupportedByStation);
        bitStream.pushBoolean(this.tpAvailableSupportedByStation);
        bitStream.pushBoolean(this.dabServiceLinkedToFm);
        bitStream.pushBoolean(this.dabPrimaryServiceCorrupted);
        bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryService);
        bitStream.pushBoolean(this.dvbServiceCorrupted);
        bitStream.pushBoolean(this.available);
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.fmLinkedToOnlineRadio);
        bitStream.pushBoolean(this.dabServiceLinkedToOnlineRadio);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

