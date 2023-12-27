/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.DestinationInfo_Status$Position;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationInfo_Status
implements StatusProperty {
    public final DestinationInfo_Status$Position position = new DestinationInfo_Status$Position();
    public int totalNumOfStopovers;
    public int stopover_Sn;
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
    public static final int POI_TYPE_DIESEL_SERVICE_STATION;
    public static final int POI_TYPE_CNG_SERVICE_STATION;
    public static final int POI_TYPE_REST_AREA_AUTOHOF;
    public static final int POI_TYPE_REST_AREA_WITH_WC;
    public static final int POI_TYPE_MOTORWAY_SERVICE_AREA_RASTSTATTE;
    public static final int POI_TYPE_UNKNOWN;
    public final BAPString poi_Description = new BAPString(61);
    private static final int MAX_POI_DESCRIPTION_LENGTH;
    public final BAPString street = new BAPString(128);
    private static final int MAX_STREET_LENGTH;
    public final BAPString town = new BAPString(61);
    private static final int MAX_TOWN_LENGTH;
    public final BAPString state = new BAPString(61);
    private static final int MAX_STATE_LENGTH;
    public final BAPString postalCode = new BAPString(22);
    private static final int MAX_POSTAL_CODE_LENGTH;
    public final BAPString country = new BAPString(61);
    private static final int MAX_COUNTRY_LENGTH;

    public DestinationInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DestinationInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.totalNumOfStopovers = 0;
        this.stopover_Sn = 0;
        this.poi_Type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.position.reset();
        this.poi_Description.reset();
        this.street.reset();
        this.town.reset();
        this.state.reset();
        this.postalCode.reset();
        this.country.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationInfo_Status destinationInfo_Status = (DestinationInfo_Status)bAPEntity;
        return this.position.equalTo(destinationInfo_Status.position) && this.totalNumOfStopovers == destinationInfo_Status.totalNumOfStopovers && this.stopover_Sn == destinationInfo_Status.stopover_Sn && this.poi_Type == destinationInfo_Status.poi_Type && this.poi_Description.equalTo(destinationInfo_Status.poi_Description) && this.street.equalTo(destinationInfo_Status.street) && this.town.equalTo(destinationInfo_Status.town) && this.state.equalTo(destinationInfo_Status.state) && this.postalCode.equalTo(destinationInfo_Status.postalCode) && this.country.equalTo(destinationInfo_Status.country);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DestinationInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.position.serialize(bitStream);
        bitStream.pushByte((byte)this.totalNumOfStopovers);
        bitStream.pushByte((byte)this.stopover_Sn);
        bitStream.pushByte((byte)this.poi_Type);
        this.poi_Description.serialize(bitStream);
        this.street.serialize(bitStream);
        this.town.serialize(bitStream);
        this.state.serialize(bitStream);
        this.postalCode.serialize(bitStream);
        this.country.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 46;
    }

    @Override
    public int getFunctionId() {
        return DestinationInfo_Status.functionId();
    }
}

