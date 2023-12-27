/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class Address_List_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_LAST_NAME_FIRST_NAME_STREET_CITY_REGION_POSTAL_CODE_COUNTRY_COORDINATES_POI_DESCRIPTION_POI_TYPE_ADDRESS_TYPE;
    public static final int RECORD_ADDRESS_STREET_CITY_POSTAL_CODE_COUNTRY_COORDINATES_ADDRESS_TYPE;
    public static final int RECORD_ADDRESS_STREET_CITY_REGION_POSTAL_CODE_COUNTRY_COORDINATES_POI_DESCRIPTION_POI_TYPE_ADDRESS_TYPE;
    public static final int RECORD_ADDRESS_STREET_CITY_POSTAL_CODE_COORDINATES_ADDRESS_TYPE;
    public static final int RECORD_ADDRESS_POI_DESCRIPTION_POI_TYPE;
    public static final int RECORD_ADDRESS_STREET_CITY;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString lastName;
    private static final int MAX_LAST_NAME_LENGTH;
    public final BAPString firstName;
    private static final int MAX_FIRST_NAME_LENGTH;
    public final BAPString street;
    private static final int MAX_STREET_LENGTH;
    public final BAPString city;
    private static final int MAX_CITY_LENGTH;
    public final BAPString region;
    private static final int MAX_REGION_LENGTH;
    public final BAPString postalCode;
    private static final int MAX_POSTAL_CODE_LENGTH;
    public final BAPString country;
    private static final int MAX_COUNTRY_LENGTH;
    public final BAPString coordinates;
    private static final int MAX_COORDINATES_LENGTH;
    public final BAPString poi_Description;
    private static final int MAX_POI_DESCRIPTION_LENGTH;
    public int poi_Type;
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
    public static final int POI_TYPE_ELECTRICAL_SERVICE_STATION;
    public static final int POI_TYPE_DIESEL_FUEL_STATION_DF4_1;
    public static final int POI_TYPE_CNG_FUEL_STATION_DF4_1;
    public static final int POI_TYPE_REST_AREA_AUTOHOF_DF4_1;
    public static final int POI_TYPE_REST_AREA_WITH_WC_DF4_1;
    public static final int POI_TYPE_MOTORWAY_SERVICE_AREA_RASTSTATTE_DF4_1;
    public static final int POI_TYPE_UNKNOWN;
    public int address_Type;
    public static final int ADDRESS_TYPE_PRIVATE;
    public static final int ADDRESS_TYPE_BUSINESS;
    public static final int ADDRESS_TYPE_BUSINESS_PARCEL_ADDRESS;
    public static final int ADDRESS_TYPE_UNKNOWN;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public Address_List_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.lastName = new BAPString(61);
        this.firstName = new BAPString(61);
        this.street = new BAPString(61);
        this.city = new BAPString(61);
        this.region = new BAPString(61);
        this.postalCode = new BAPString(22);
        this.country = new BAPString(61);
        this.coordinates = new BAPString(61);
        this.poi_Description = new BAPString(61);
        this.internalReset();
        this.customInitialization();
    }

    public Address_List_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.poi_Type = 0;
        this.address_Type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.lastName.reset();
        this.firstName.reset();
        this.street.reset();
        this.city.reset();
        this.region.reset();
        this.postalCode.reset();
        this.country.reset();
        this.coordinates.reset();
        this.poi_Description.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Address_List_Data address_List_Data = (Address_List_Data)bAPEntity;
        return this.arrayHeader.equalTo(address_List_Data.arrayHeader) && this.pos == address_List_Data.pos && this.lastName.equalTo(address_List_Data.lastName) && this.firstName.equalTo(address_List_Data.firstName) && this.street.equalTo(address_List_Data.street) && this.city.equalTo(address_List_Data.city) && this.region.equalTo(address_List_Data.region) && this.postalCode.equalTo(address_List_Data.postalCode) && this.country.equalTo(address_List_Data.country) && this.coordinates.equalTo(address_List_Data.coordinates) && this.poi_Description.equalTo(address_List_Data.poi_Description) && this.poi_Type == address_List_Data.poi_Type && this.address_Type == address_List_Data.address_Type;
    }

    private void customInitialization() {
        this.lastName.setLimitingLengthByCharacters();
        this.firstName.setLimitingLengthByCharacters();
        this.region.setLimitingLengthByCharacters();
        this.postalCode.setLimitingLengthByCharacters();
        this.country.setLimitingLengthByCharacters();
        this.coordinates.setLimitingLengthByCharacters();
        this.poi_Description.setLimitingLengthByCharacters();
    }

    @Override
    public String toString() {
        return "Address_List_Data:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.lastName.serialize(bitStream);
                this.firstName.serialize(bitStream);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.region.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                this.country.serialize(bitStream);
                this.coordinates.serialize(bitStream);
                this.poi_Description.serialize(bitStream);
                bitStream.pushByte((byte)this.poi_Type);
                bitStream.pushByte((byte)this.address_Type);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                this.country.serialize(bitStream);
                this.coordinates.serialize(bitStream);
                bitStream.pushByte((byte)this.address_Type);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.region.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                this.country.serialize(bitStream);
                this.coordinates.serialize(bitStream);
                this.poi_Description.serialize(bitStream);
                bitStream.pushByte((byte)this.poi_Type);
                bitStream.pushByte((byte)this.address_Type);
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                this.postalCode.serialize(bitStream);
                this.coordinates.serialize(bitStream);
                bitStream.pushByte((byte)this.address_Type);
                break;
            }
            case 5: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.poi_Description.serialize(bitStream);
                bitStream.pushByte((byte)this.poi_Type);
                break;
            }
            case 6: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.street.serialize(bitStream);
                this.city.serialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

