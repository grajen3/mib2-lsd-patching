/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi;

public interface LogChannel {
    public static final int CHANNEL_UNSPECIFIED;
    public static final int CHANNEL_ORGANIZER_GENERAL;
    public static final int CHANNEL_ORGANIZER_ADDRESSBOOK;
    public static final int CHANNEL_AUDIO_GENERAL;
    public static final int CHANNEL_AUDIO_CONNECTION_HANDLING;
    public static final int CHANNEL_AUDIO_WAVEPLAYER;
    public static final int CHANNEL_AUDIO_ENTERTAINMENT_MANAGER;
    public static final int CHANNEL_CONNECTIVITY_GENERAL;
    public static final int CHANNEL_CONNECTIVITY_BLUETOOTH;
    public static final int CHANNEL_CONNECTIVITY_WLAN;
    public static final int CHANNEL_CONNECTIVITY_NETWORKING;
    public static final int CHANNEL_CONNECTIVITY_TELEPHONE;
    public static final int CHANNEL_CONNECTIVITY_MIRRORLINK;
    public static final int CHANNEL_CAR_SERVICES_GENERAL;
    public static final int CHANNEL_CAR_SERVICES_PARKING;
    public static final int CHANNEL_CAR_SERVICES_TIRE_PRESSURE;
    public static final int CHANNEL_CAR_SERVICES_HUD;
    public static final int CHANNEL_CAR_SERVICES_ECO;
    public static final int CHANNEL_CAR_SERVICES_BATTERY_CONTROL;
    public static final int CHANNEL_CAR_SERVICES_HYBRID;
    public static final int CHANNEL_CAR_SERVICES_CLIMATE;
    public static final int CHANNEL_CAR_SERVICES_FAS;
    public static final int CHANNEL_CAR_SERVICES_COMFORT;
    public static final int CHANNEL_CAR_SERVICES_SERVICE;
    public static final int CHANNEL_CAR_SERVICES_CAN;
    public static final int CHANNEL_CLUSTER_INSTRUMENT_GENERAL;
    public static final int CHANNEL_CLUSTER_INSTRUMENT_BOARD_COMPUTER;
    public static final int CHANNEL_CLUSTER_INSTRUMENT_SD_NAV;
    public static final int CHANNEL_CLUSTER_INSTRUMENT_SD_MEDIA;
    public static final int CHANNEL_CLUSTER_INSTRUMENT_MOST;
    public static final int CHANNEL_HMI_GENERAL;
    public static final int CHANNEL_HMI_BUSINESS_LOGIC;
    public static final int CHANNEL_HMI_DSI;
    public static final int CHANNEL_HMI_FRAMEWORK;
    public static final int CHANNEL_HMI_GRAPHICS;
    public static final int CHANNEL_HMI_STATEMACHINE;
    public static final int CHANNEL_HMI_WIDGETS;
    public static final int CHANNEL_HMI_REMOTEHMI;
    public static final int CHANNEL_MEDIA_GENERAL;
    public static final int CHANNEL_MEDIA_FILE_BROWSER;
    public static final int CHANNEL_MEDIA_MEDIA_BROWSER;
    public static final int CHANNEL_MEDIA_SOURCE_HANDLING;
    public static final int CHANNEL_MEDIA_PLAYER;
    public static final int CHANNEL_MEDIA_PICTURE_VIEWER;
    public static final int CHANNEL_MEDIA_PICTURE_IMPORT;
    public static final int CHANNEL_MIRRORLINK_GENERAL;
    public static final int CHANNEL_NAVIGATION_GENERAL;
    public static final int CHANNEL_NAVIGATION_DESTINATION_ENTRY;
    public static final int CHANNEL_NAVIGATION_GPS;
    public static final int CHANNEL_NAVIGATION_GUIDANCE;
    public static final int CHANNEL_NAVIGATION_MAP;
    public static final int CHANNEL_NAVIGATION_POI_SEARCH;
    public static final int CHANNEL_NAVIGATION_TRAFFIC;
    public static final int CHANNEL_ONLINE_SERVICES_GENERAL;
    public static final int CHANNEL_ONLINE_SERVICES_CORE_SERVICES;
    public static final int CHANNEL_ONLINE_SERVICES_GOOGLE_EARTH;
    public static final int CHANNEL_ONLINE_SERVICES_INTERNET_BROWSER;
    public static final int CHANNEL_ONLINE_SERVICES_TRAVELLINK;
    public static final int CHANNEL_PHONE_GENERAL;
    public static final int CHANNEL_PHONE_CALL_MANAGEMENT;
    public static final int CHANNEL_PHONE_CALL_STACKS;
    public static final int CHANNEL_PROTOCOLS_GENERAL;
    public static final int CHANNEL_REAR_SEAT_ENTERTAINMENT_GENERAL;
    public static final int CHANNEL_REAR_SEAT_ENTERTAINMENT_VEHICLE_INFORMATION;
    public static final int CHANNEL_REAR_SEAT_ENTERTAINMENT_MEDIA;
    public static final int CHANNEL_REAR_SEAT_ENTERTAINMENT_NAVIGATION;
    public static final int CHANNEL_SYSTEM_GENERAL;
    public static final int CHANNEL_SYSTEM_DIAGNOSIS;
    public static final int CHANNEL_SYSTEM_IRC;
    public static final int CHANNEL_SYSTEM_KEY_PANEL;
    public static final int CHANNEL_SYSTEM_PERSISTENCE;
    public static final int CHANNEL_SYSTEM_POWER_MANAGEMENT;
    public static final int CHANNEL_SYSTEM_SPLASHSCREEN;
    public static final int CHANNEL_SYSTEM_STARTUP;
    public static final int CHANNEL_SYSTEM_SWDL;
    public static final int CHANNEL_SYSTEM_SWAP;
    public static final int CHANNEL_SYSTEM_WATCHDOG;
    public static final int CHANNEL_SDS_GENERAL;
    public static final int CHANNEL_SDS_SPEECH_RECOGNIZER;
    public static final int CHANNEL_SDS_TTS;
    public static final int CHANNEL_TUNER_GENERAL;
    public static final int CHANNEL_TUNER_AMFM;
    public static final int CHANNEL_TUNER_DAB;
    public static final int CHANNEL_TUNER_HDRADIO;
    public static final int CHANNEL_TUNER_SDARS;
    public static final int CHANNEL_TUNER_TMC;
    public static final int CHANNEL_TUNER_TV;
    public static final int CHANNEL_TESTMODE_GENERAL;
    public static final int CHANNEL_TESTMODE_GEM;
}

