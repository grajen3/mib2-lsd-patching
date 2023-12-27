/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationsList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_NAME_POSITION_LATITUDE_POSITION_LONGITUDE_TYPE_OF_DESTINATION_POI_TYPE_POI_EXTENSION_TOUR_ID_STOPOVER_SN_ADDR_STREET_ADDR_NUMBER_ADDR_TOWN_ADDR_STATE_ADDR_POSTAL_CODE_ADDR_COUNTRY_ADDR_TELEPHONE;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_POSITION_LATITUDE_POSITION_LONGITUDE_TYPE_OF_DESTINATION_POI_TYPE_STOPOVER_SN;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    private static final int MAX_NAME_LENGTH;
    public final BAPString name;
    public static final int POSITION_LATITUDE_MIN;
    public int position_Latitude;
    public static final int POSITION_LONGITUDE_MIN;
    public int position_Longitude;
    public static final int TYPE_OF_DESTINATION_UNKNOWN_ANY_TYPE_OF_DESTINATION;
    public static final int TYPE_OF_DESTINATION_POI_POINT_OF_INTERESST;
    public static final int TYPE_OF_DESTINATION_STOPOVER_DESTINATION_ZWISCHENZIEL;
    public static final int TYPE_OF_DESTINATION_FINAL_DESTINATION;
    public static final int TYPE_OF_DESTINATION_FINAL_DESTINATION_START_ROUT_GUIDANCE_IMMEDIATLY;
    public int typeOfDestination;
    public static final int POI_TYPE_NO_POI;
    public static final int POI_TYPE_ACCOMMODATION;
    public static final int POI_TYPE_AIRPORT;
    public static final int POI_TYPE_ALL_RESTAURANTS;
    public static final int POI_TYPE_AMUSEMENT_PARK;
    public static final int POI_TYPE_APPAREL;
    public static final int POI_TYPE_ATM_CASHPOINT;
    public static final int POI_TYPE_ATTRACTION;
    public static final int POI_TYPE_AUTOMOBILE_CLUB;
    public static final int POI_TYPE_BANKING_AND_SHOPPING;
    public static final int POI_TYPE_BANKING;
    public static final int POI_TYPE_BANQUET_HALLS;
    public static final int POI_TYPE_BARS_AND_LOUNGE;
    public static final int POI_TYPE_BOATING;
    public static final int POI_TYPE_BOOKSTORE;
    public static final int POI_TYPE_BORDER_CROSS;
    public static final int POI_TYPE_BOWLING;
    public static final int POI_TYPE_BROADCASTING;
    public static final int POI_TYPE_BUSINESS_AND_SERVICE;
    public static final int POI_TYPE_BUSINESS;
    public static final int POI_TYPE_BUSSTATION;
    public static final int POI_TYPE_CAMPING;
    public static final int POI_TYPE_CAR_AND_TRAVEL;
    public static final int POI_TYPE_CAR_TRACK;
    public static final int POI_TYPE_CAR_TRAIN;
    public static final int POI_TYPE_CAR_SERVICE;
    public static final int POI_TYPE_CAR_WASH;
    public static final int POI_TYPE_CASINO;
    public static final int POI_TYPE_CEMETRY;
    public static final int POI_TYPE_CITYHALL;
    public static final int POI_TYPE_COFFEE;
    public static final int POI_TYPE_COMMUTER_RAILSTAION;
    public static final int POI_TYPE_CLEANING_LAUNCH;
    public static final int POI_TYPE_CLOTHING_STORE;
    public static final int POI_TYPE_COMMUNICATION;
    public static final int POI_TYPE_COMMUNITY_CENTER;
    public static final int POI_TYPE_COMPUTER_HARDWARE_SOFTWARE;
    public static final int POI_TYPE_CONVENIENCE_STORE;
    public static final int POI_TYPE_CONVENTION_CENTER;
    public static final int POI_TYPE_CORPORATIONS;
    public static final int POI_TYPE_CORPORATIONS_PUBLIC_PLACES;
    public static final int POI_TYPE_CULTURE_FACILITY;
    public static final int POI_TYPE_COURT;
    public static final int POI_TYPE_DEPARTMENT_STORE;
    public static final int POI_TYPE_DINING_AND_ENTERTAINMENT;
    public static final int POI_TYPE_DINNING_SHOPPING;
    public static final int POI_TYPE_DISCOUNT_STORE;
    public static final int POI_TYPE_EDUCATION;
    public static final int POI_TYPE_ELECTRONICS;
    public static final int POI_TYPE_EMBASSY;
    public static final int POI_TYPE_EMERGENCY;
    public static final int POI_TYPE_EMERGENCY_AND_PUBLIC;
    public static final int POI_TYPE_ENTERTAINMENT;
    public static final int POI_TYPE_FAST_FOOD;
    public static final int POI_TYPE_FERRY;
    public static final int POI_TYPE_FIRE_DEPARTMENT;
    public static final int POI_TYPE_FLOORING_AND_CARPETING;
    public static final int POI_TYPE_FLOWER_AND_JEWELRY;
    public static final int POI_TYPE_FOOD_AND_BEVERAGE;
    public static final int POI_TYPE_FUNERAL_DIRECTOR;
    public static final int POI_TYPE_FURNITURE;
    public static final int POI_TYPE_GAMES_MUSIC_AND_VIDEO;
    public static final int POI_TYPE_GARDEN_AND_OTHER;
    public static final int POI_TYPE_GASSTATION;
    public static final int POI_TYPE_GASSTATION_DIESEL_GASSTATION_LPG;
    public static final int POI_TYPE_GENERAL;
    public static final int POI_TYPE_GIFTS_AND_LEISURE;
    public static final int POI_TYPE_GIFTS_ANTIQUES_AND_ARTS;
    public static final int POI_TYPE_GLASS_AND_WINDOW;
    public static final int POI_TYPE_GOLFING;
    public static final int POI_TYPE_GOVERMENT;
    public static final int POI_TYPE_GROCERY_STORES;
    public static final int POI_TYPE_GUESTHOUSE;
    public static final int POI_TYPE_HAIR_AND_BEAUTY;
    public static final int POI_TYPE_HARBOR;
    public static final int POI_TYPE_HARDWARE_AND_LUMBER;
    public static final int POI_TYPE_HEALTH_AND_FITNESS;
    public static final int POI_TYPE_HEALTH_CARE;
    public static final int POI_TYPE_HIGHRISE_BLDG;
    public static final int POI_TYPE_HOME_AND_IMPROVMENT;
    public static final int POI_TYPE_HOME_CENTER;
    public static final int POI_TYPE_HOME_SERVICE;
    public static final int POI_TYPE_HOSPITAL;
    public static final int POI_TYPE_HOTEL_MOTEL;
    public static final int POI_TYPE_ICESKATING;
    public static final int POI_TYPE_INSURANCE;
    public static final int POI_TYPE_KARAOKAY;
    public static final int POI_TYPE_LIBRARY;
    public static final int POI_TYPE_LIQ_GAS_STATION;
    public static final int POI_TYPE_MAJOR_APPLIANCE;
    public static final int POI_TYPE_MENS_APPAREL;
    public static final int POI_TYPE_MONUMENT;
    public static final int POI_TYPE_MOTORWAY_EXIT;
    public static final int POI_TYPE_MOTORWAY_CROSS;
    public static final int POI_TYPE_MOTORWAY_SERVICE;
    public static final int POI_TYPE_MOVIE_THEATER;
    public static final int POI_TYPE_MOVING_AND_STORAGE;
    public static final int POI_TYPE_MUSEUM;
    public static final int POI_TYPE_NIGHTCLUBS;
    public static final int POI_TYPE_OPTICAL;
    public static final int POI_TYPE_RESTAURANT;
    public static final int POI_TYPE_PARK_AND_FITNESS;
    public static final int POI_TYPE_PARK_AND_RIDE;
    public static final int POI_TYPE_PARKING;
    public static final int POI_TYPE_PARKING_GARAGE;
    public static final int POI_TYPE_PARKS;
    public static final int POI_TYPE_PERFORMING_ARTS;
    public static final int POI_TYPE_PERSONAL_SERVICE;
    public static final int POI_TYPE_PHARMACIES;
    public static final int POI_TYPE_PHOTOGRAPHER;
    public static final int POI_TYPE_PLACE_OR_WORKSHIP;
    public static final int POI_TYPE_POLICE_STATION;
    public static final int POI_TYPE_POST_OFFICE;
    public static final int POI_TYPE_PUBLIC_PLACES;
    public static final int POI_TYPE_PUBLISHER;
    public static final int POI_TYPE_RAILWAY_STATION;
    public static final int POI_TYPE_RECREATION;
    public static final int POI_TYPE_RENTEL_SERVICE;
    public static final int POI_TYPE_REPAIR;
    public static final int POI_TYPE_REST_AREA;
    public static final int POI_TYPE_RETIREMENT_NURSING;
    public static final int POI_TYPE_SEARCH;
    public static final int POI_TYPE_SERVICE;
    public static final int POI_TYPE_SHOE_STORES;
    public static final int POI_TYPE_SHOPPING_CENTER;
    public static final int POI_TYPE_SKIING;
    public static final int POI_TYPE_SOCIAL_SERVICE;
    public static final int POI_TYPE_SPECIALITY_CLOTHING;
    public static final int POI_TYPE_SPECIALITY_STORE;
    public static final int POI_TYPE_SPECIALITY_FOOD;
    public static final int POI_TYPE_SPORT_GOODS;
    public static final int POI_TYPE_SPORTS;
    public static final int POI_TYPE_SPORT_AIRPORT;
    public static final int POI_TYPE_SPORTS_COMPLEX;
    public static final int POI_TYPE_TAILOR;
    public static final int POI_TYPE_TAX_SERVICE;
    public static final int POI_TYPE_TOOL_BOOTH;
    public static final int POI_TYPE_TOURIST_ATTRACTION;
    public static final int POI_TYPE_TOURIST_INFORMATION;
    public static final int POI_TYPE_TRAIN_STATION;
    public static final int POI_TYPE_TRANSPORTATION;
    public static final int POI_TYPE_TRAVEL;
    public static final int POI_TYPE_TRAVEL_AGENT;
    public static final int POI_TYPE_UNIVERSITY;
    public static final int POI_TYPE_UTILITIES;
    public static final int POI_TYPE_VARIETY_STORE;
    public static final int POI_TYPE_WINE_AND_LIQUOR;
    public static final int POI_TYPE_WOMENS_APPAREL;
    public static final int POI_TYPE_WINERY;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_VW;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_AUDI;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SEAT;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SKODA;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_VW_NUTZFAHRZEUGE;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_BENTLEY;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_BUGATTI;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_LAMBORGHINI;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_SCANIA;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_MAN;
    public static final int POI_TYPE_CAR_REPAIR_SHOP_PORSCHE;
    public static final int POI_TYPE_VIP_CATEGORY_0;
    public static final int POI_TYPE_VIP_CATEGORY_1;
    public static final int POI_TYPE_VIP_CATEGORY_2;
    public static final int POI_TYPE_VIP_CATEGORY_3;
    public static final int POI_TYPE_VIP_CATEGORY_4;
    public static final int POI_TYPE_VIP_CATEGORY_5;
    public static final int POI_TYPE_VIP_CATEGORY_6;
    public static final int POI_TYPE_VIP_CATEGORY_7;
    public static final int POI_TYPE_VIP_CATEGORY_8;
    public static final int POI_TYPE_VIP_CATEGORY_9;
    public static final int POI_TYPE_UNKNOWN;
    public int poi_Type;
    private static final int MAX_POI_EXTENSION_LENGTH;
    public final BAPString poi_Extension;
    public static final int TOUR_ID_MIN;
    public int tour_Id;
    public static final int STOPOVER_SN_MIN;
    public int stopover_Sn;
    private static final int MAX_ADDR_STREET_LENGTH;
    public final BAPString addr_Street;
    private static final int MAX_ADDR_NUMBER_LENGTH;
    public final BAPString addr_Number;
    private static final int MAX_ADDR_TOWN_LENGTH;
    public final BAPString addr_Town;
    private static final int MAX_ADDR_STATE_LENGTH;
    public final BAPString addr_State;
    private static final int MAX_ADDR_POSTALCODE_LENGTH;
    public final BAPString addr_PostalCode;
    private static final int MAX_ADDR_COUNTRY_LENGTH;
    public final BAPString addr_Country;
    private static final int MAX_ADDR_TELEPHONE_LENGTH;
    public final BAPString addr_Telephone;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public DestinationsList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.name = new BAPString(128);
        this.poi_Extension = new BAPString(51);
        this.addr_Street = new BAPString(128);
        this.addr_Number = new BAPString(11);
        this.addr_Town = new BAPString(61);
        this.addr_State = new BAPString(61);
        this.addr_PostalCode = new BAPString(22);
        this.addr_Country = new BAPString(61);
        this.addr_Telephone = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public DestinationsList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.position_Latitude = -90;
        this.position_Longitude = -180;
        this.typeOfDestination = 0;
        this.poi_Type = 0;
        this.tour_Id = 0;
        this.stopover_Sn = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.name.reset();
        this.poi_Extension.reset();
        this.addr_Street.reset();
        this.addr_Number.reset();
        this.addr_Town.reset();
        this.addr_State.reset();
        this.addr_PostalCode.reset();
        this.addr_Country.reset();
        this.addr_Telephone.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationsList_Data destinationsList_Data = (DestinationsList_Data)bAPEntity;
        return this.arrayHeader.equalTo(destinationsList_Data.arrayHeader) && this.pos == destinationsList_Data.pos && this.name.equalTo(destinationsList_Data.name) && this.position_Latitude == destinationsList_Data.position_Latitude && this.position_Longitude == destinationsList_Data.position_Longitude && this.typeOfDestination == destinationsList_Data.typeOfDestination && this.poi_Type == destinationsList_Data.poi_Type && this.poi_Extension.equalTo(destinationsList_Data.poi_Extension) && this.tour_Id == destinationsList_Data.tour_Id && this.stopover_Sn == destinationsList_Data.stopover_Sn && this.addr_Street.equalTo(destinationsList_Data.addr_Street) && this.addr_Number.equalTo(destinationsList_Data.addr_Number) && this.addr_Town.equalTo(destinationsList_Data.addr_Town) && this.addr_State.equalTo(destinationsList_Data.addr_State) && this.addr_PostalCode.equalTo(destinationsList_Data.addr_PostalCode) && this.addr_Country.equalTo(destinationsList_Data.addr_Country) && this.addr_Telephone.equalTo(destinationsList_Data.addr_Telephone);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DestinationsList_Empty:";
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
                bitStream.pushInt(this.position_Latitude);
                bitStream.pushInt(this.position_Longitude);
                bitStream.pushByte((byte)this.typeOfDestination);
                bitStream.pushByte((byte)this.poi_Type);
                bitStream.pushByte((byte)this.stopover_Sn);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                bitStream.pushInt(this.position_Latitude);
                bitStream.pushInt(this.position_Longitude);
                bitStream.pushByte((byte)this.typeOfDestination);
                bitStream.pushByte((byte)this.poi_Type);
                this.poi_Extension.serialize(bitStream);
                bitStream.pushInt(this.tour_Id);
                bitStream.pushByte((byte)this.stopover_Sn);
                this.addr_Street.serialize(bitStream);
                this.addr_Number.serialize(bitStream);
                this.addr_Town.serialize(bitStream);
                this.addr_State.serialize(bitStream);
                this.addr_PostalCode.serialize(bitStream);
                this.addr_Country.serialize(bitStream);
                this.addr_Telephone.serialize(bitStream);
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
                this.position_Latitude = bitStream.popFrontInt();
                this.position_Longitude = bitStream.popFrontInt();
                this.typeOfDestination = bitStream.popFrontByte();
                this.poi_Type = bitStream.popFrontByte();
                this.stopover_Sn = bitStream.popFrontByte();
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.position_Latitude = bitStream.popFrontInt();
                this.position_Longitude = bitStream.popFrontInt();
                this.typeOfDestination = bitStream.popFrontByte();
                this.poi_Type = bitStream.popFrontByte();
                this.poi_Extension.deserialize(bitStream);
                this.tour_Id = bitStream.popFrontInt();
                this.stopover_Sn = bitStream.popFrontByte();
                this.addr_Street.deserialize(bitStream);
                this.addr_Number.deserialize(bitStream);
                this.addr_Town.deserialize(bitStream);
                this.addr_State.deserialize(bitStream);
                this.addr_PostalCode.deserialize(bitStream);
                this.addr_Country.deserialize(bitStream);
                this.addr_Telephone.deserialize(bitStream);
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

