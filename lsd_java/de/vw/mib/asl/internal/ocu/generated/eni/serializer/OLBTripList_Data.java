/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class OLBTripList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_WAY_TYPE_BUSINESS_PARTNER_TRIP_REASON_ORIGIN_STATE_ORIGIN_TOWN_ORIGIN_STREET_ORIGIN_STREET_NUMBER_DESTINATION_STATE_DESTINATION_TOWN_DESTINATION_STREET_DESTINATION_STREET_NUMBER;
    public static final int RECORD_ADDRESS_WAY_TYPE_BUSINESS_PARTNER_TRIP_REASON_DESTINATION_STATE_DESTINATION_TOWN_DESTINATION_STREET_DESTINATION_STREET_NUMBER;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int WAY_TYPE_INITIAL;
    public static final int WAY_TYPE_BUSINESS;
    public static final int WAY_TYPE_PRIVATE;
    public static final int WAY_TYPE_WAY_TO_WORK;
    public int wayType;
    private static final int MAX_BUSINESSPARTNER_LENGTH;
    public final BAPString businessPartner;
    private static final int MAX_TRIPREASON_LENGTH;
    public final BAPString tripReason;
    private static final int MAX_ORIGINSTATE_LENGTH;
    public final BAPString originState;
    private static final int MAX_ORIGINTOWN_LENGTH;
    public final BAPString originTown;
    private static final int MAX_ORIGINSTREET_LENGTH;
    public final BAPString originStreet;
    private static final int MAX_ORIGINSTREETNUMBER_LENGTH;
    public final BAPString originStreetNumber;
    private static final int MAX_DESTINATIONSTATE_LENGTH;
    public final BAPString destinationState;
    private static final int MAX_DESTINATIONTOWN_LENGTH;
    public final BAPString destinationTown;
    private static final int MAX_DESTINATIONSTREET_LENGTH;
    public final BAPString destinationStreet;
    private static final int MAX_DESTINATIONSTREETNUMBER_LENGTH;
    public final BAPString destinationStreetNumber;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public OLBTripList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.businessPartner = new BAPString(242);
        this.tripReason = new BAPString(242);
        this.originState = new BAPString(61);
        this.originTown = new BAPString(61);
        this.originStreet = new BAPString(128);
        this.originStreetNumber = new BAPString(11);
        this.destinationState = new BAPString(61);
        this.destinationTown = new BAPString(61);
        this.destinationStreet = new BAPString(128);
        this.destinationStreetNumber = new BAPString(11);
        this.internalReset();
        this.customInitialization();
    }

    public OLBTripList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.wayType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.businessPartner.reset();
        this.tripReason.reset();
        this.originState.reset();
        this.originTown.reset();
        this.originStreet.reset();
        this.originStreetNumber.reset();
        this.destinationState.reset();
        this.destinationTown.reset();
        this.destinationStreet.reset();
        this.destinationStreetNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OLBTripList_Data oLBTripList_Data = (OLBTripList_Data)bAPEntity;
        return this.arrayHeader.equalTo(oLBTripList_Data.arrayHeader) && this.pos == oLBTripList_Data.pos && this.wayType == oLBTripList_Data.wayType && this.businessPartner.equalTo(oLBTripList_Data.businessPartner) && this.tripReason.equalTo(oLBTripList_Data.tripReason) && this.originState.equalTo(oLBTripList_Data.originState) && this.originTown.equalTo(oLBTripList_Data.originTown) && this.originStreet.equalTo(oLBTripList_Data.originStreet) && this.originStreetNumber.equalTo(oLBTripList_Data.originStreetNumber) && this.destinationState.equalTo(oLBTripList_Data.destinationState) && this.destinationTown.equalTo(oLBTripList_Data.destinationTown) && this.destinationStreet.equalTo(oLBTripList_Data.destinationStreet) && this.destinationStreetNumber.equalTo(oLBTripList_Data.destinationStreetNumber);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OLBTripList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.wayType);
                this.businessPartner.serialize(bitStream);
                this.tripReason.serialize(bitStream);
                this.destinationState.serialize(bitStream);
                this.destinationTown.serialize(bitStream);
                this.destinationStreet.serialize(bitStream);
                this.destinationStreetNumber.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.wayType);
                this.businessPartner.serialize(bitStream);
                this.tripReason.serialize(bitStream);
                this.originState.serialize(bitStream);
                this.originTown.serialize(bitStream);
                this.originStreet.serialize(bitStream);
                this.originStreetNumber.serialize(bitStream);
                this.destinationState.serialize(bitStream);
                this.destinationTown.serialize(bitStream);
                this.destinationStreet.serialize(bitStream);
                this.destinationStreetNumber.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.wayType = bitStream.popFrontByte();
                this.businessPartner.deserialize(bitStream);
                this.tripReason.deserialize(bitStream);
                this.destinationState.deserialize(bitStream);
                this.destinationTown.deserialize(bitStream);
                this.destinationStreet.deserialize(bitStream);
                this.destinationStreetNumber.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.wayType = bitStream.popFrontByte();
                this.businessPartner.deserialize(bitStream);
                this.tripReason.deserialize(bitStream);
                this.originState.deserialize(bitStream);
                this.originTown.deserialize(bitStream);
                this.originStreet.deserialize(bitStream);
                this.originStreetNumber.deserialize(bitStream);
                this.destinationState.deserialize(bitStream);
                this.destinationTown.deserialize(bitStream);
                this.destinationStreet.deserialize(bitStream);
                this.destinationStreetNumber.deserialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

