/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SiriusAlertList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_7__15_BITSIZE;
    public boolean stationLinkedToOnlineRadio;
    public boolean onlineRadioMutingLowSignal;
    public boolean stationNotSelectable;
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean available;

    public SiriusAlertList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public SiriusAlertList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stationLinkedToOnlineRadio = false;
        this.onlineRadioMutingLowSignal = false;
        this.stationNotSelectable = false;
        this.sdarsStationSubscribedOrNotAnSdarsStation = false;
        this.tmcAvailableSupportedByStation = false;
        this.tpAvailableSupportedByStation = false;
        this.available = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SiriusAlertList_Attributes siriusAlertList_Attributes = (SiriusAlertList_Attributes)bAPEntity;
        return this.stationLinkedToOnlineRadio == siriusAlertList_Attributes.stationLinkedToOnlineRadio && this.onlineRadioMutingLowSignal == siriusAlertList_Attributes.onlineRadioMutingLowSignal && this.stationNotSelectable == siriusAlertList_Attributes.stationNotSelectable && this.sdarsStationSubscribedOrNotAnSdarsStation == siriusAlertList_Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == siriusAlertList_Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == siriusAlertList_Attributes.tpAvailableSupportedByStation && this.available == siriusAlertList_Attributes.available;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SiriusAlertList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.stationLinkedToOnlineRadio);
        bitStream.pushBoolean(this.onlineRadioMutingLowSignal);
        bitStream.pushBoolean(this.stationNotSelectable);
        bitStream.pushBoolean(this.sdarsStationSubscribedOrNotAnSdarsStation);
        bitStream.pushBoolean(this.tmcAvailableSupportedByStation);
        bitStream.pushBoolean(this.tpAvailableSupportedByStation);
        bitStream.pushBoolean(this.available);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(9);
        this.stationLinkedToOnlineRadio = bitStream.popFrontBoolean();
        this.onlineRadioMutingLowSignal = bitStream.popFrontBoolean();
        this.stationNotSelectable = bitStream.popFrontBoolean();
        this.sdarsStationSubscribedOrNotAnSdarsStation = bitStream.popFrontBoolean();
        this.tmcAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.tpAvailableSupportedByStation = bitStream.popFrontBoolean();
        this.available = bitStream.popFrontBoolean();
    }
}

