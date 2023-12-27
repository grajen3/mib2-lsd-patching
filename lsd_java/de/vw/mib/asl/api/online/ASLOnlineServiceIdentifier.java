/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online;

public interface ASLOnlineServiceIdentifier {
    public static final String ONLINE_SERVICE_CORE;
    public static final String ONLINE_SERVICE_ONLINE_TRAFFIC;
    public static final String ONLINE_SERVICE_PERSONALPOI;
    public static final String ONLINE_SERVICE_DYNAMICPOI;
    public static final String ONLINE_SERVICE_DYNAMICPOI_NATURAL_PETROL_STATIONS;
    public static final String ONLINE_SERVICE_DYNAMICPOI_PARKING;
    public static final String ONLINE_SERVICE_DYNAMICPOI_CHARGING_STATIONS;
    public static final String ONLINE_SERVICE_DYNAMICPOI_PETROL_STATIONS;
    public static final String ONLINE_SERVICE_DESTINATION_IMPORT;
    public static final String ONLINE_SERVICE_POI_SEARCH;
    public static final String ONLINE_SERVICE_BROWSER;
    public static final String ONLINE_SERVICE_POI_VOICE;
    public static final String ONLINE_SERVICE_GOOGLE_EARTH;
    public static final String ONLINE_SERVICE_GOOGLE_STREETVIEW;
    public static final String ONLINE_SERVICE_TRAFFIC_MINI_MAP;
    public static final String ONLINE_SERVICE_TOURIMPORT;
    public static final String ONLINE_SERVICE_VEHICLE_HEALTH;
    public static final String ONLINE_SERVICE_BREAKDOWN;
    public static final String ONLINE_SERVICE_CCPOI;
    public static final String ONLINE_SERVICE_NEWS;
    public static final String ONLINE_SERVICE_WEATHER;
    public static final String ONLINE_SERVICE_GRACENOTE;
    public static final String ONLINE_SERVICE_UOTA_SESSION;
    public static final String ONLINE_SERVICE_UOTA_PROMOTION;
    public static final String ONLINE_SERVICE_NAVDATA;
    public static final String ONLINE_SERVICE_UOTA_PPOI;
    public static final String ONLINE_SERVICE_MUSIC_STREAMING;
    public static final String ONLINE_SERVICE_DEALER_APPOINT;
    public static final String ONLINE_SERVICE_DWAP;
    public static final String ONLINE_SERVICE_GEOFENCE;
    public static final String ONLINE_SERVICE_INFO_CALL;
    public static final String ONLINE_SERVICE_LICENSE;
    public static final String ONLINE_SERVICE_RBATTERY_CHARGE;
    public static final String ONLINE_SERVICE_RCLIMA;
    public static final String ONLINE_SERVICE_RHEATING;
    public static final String ONLINE_SERVICE_RHONK;
    public static final String ONLINE_SERVICE_RLU;
    public static final String ONLINE_SERVICE_SPEED_ALERT;
    public static final String ONLINE_SERVICE_TIMER_PROGRAMMING;
    public static final String ONLINE_SERVICE_TRIP_STATISTIC;
    public static final String ONLINE_SERVICE_TRUST_STORE;
    public static final String ONLINE_SERVICE_VEHICLE_TELEMETRY;
    public static final String ONLINE_SERVICE_JOBS;
    public static final String ONLINE_SERVICE_SERVICES;
    public static final String ONLINE_SERVICE_DEVICE_RESET;
    public static final String ONLINE_SERVICE_PRIMARY_USER;
    public static final String ONLINE_SERVICE_VEHICLE_USERS;
    public static final String ONLINE_SERVICE_POWERMANAGEMENTCONF;
    public static final String ONLINE_SERVICE_COMMUNICATIONCONF;
    public static final String ONLINE_SERVICE_TRAVELGUIDE;
    public static final String ONLINE_SERVICE_CARFINDER;
    public static final String ONLINE_SERVICE_ECALL;
    public static final String ONLINE_SERVICE_DOWNLOAD;
    public static final String ONLINE_SERVICE_ONLINE_RADIO_DATA;
    public static final String ONLINE_SERVICE_HYBRID_RADIO_RANGE;
    public static final String ONLINE_SERVICE_HYBRID_RADIO_DATA;
    public static final String ONLINE_SERVICE_3D_CITY_MODEL;
    public static final String ONLINE_SERVICE_IN_CAR_ENROLLMENT;
    public static final String ONLINE_SERVICE_SPEECH_NEWS;
    public static final String ONLINE_SERVICE_ATTERY;
    public static final String ONLINE_SERVICE_ESIM;
    public static final String ONLINE_SERVICE_DRIVER_EFFICIENCY;
    public static final String ONLINE_SERVICE_MVSGEO;
    public static final String ONLINE_SERVICE_LOGBOOK;
    public static final String ONLINE_SERVICE_TIMEFENCE;
    public static final String ONLINE_SERVICE_VALET_ALERT;
    public static final String ONLINE_SERVICE_ROUTING;
    public static final String ONLINE_SERVICE_OCU_UOTA;
    public static final String ONLINE_SERVICE_DAL;
    public static final String ONLINE_SERVICE_CC_BREAKDOWNAUTOMATIC;
    public static final int PROVIDERLOGO_IMAGE;
    public static final int PROVIDERLOGO_IMAGE_VOICE;
    public static final int PROVIDERLOGO_IMAGE_MAP;
    public static final int BRAND_ICON;

    default public String getServiceidentifier() {
    }

    default public boolean isServiceValid() {
    }

    default public void setServiceID(String string) {
    }

    default public String getServiceID() {
    }

    default public void setApplicationID(String string) {
    }

    default public String getApplicationID() {
    }
}

