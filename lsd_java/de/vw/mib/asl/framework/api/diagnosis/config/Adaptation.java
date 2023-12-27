/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.diagnosis.config;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;

public interface Adaptation
extends Access {
    public static final int ID_TESTMODE_VIDEO_SPEED_CUTOFF;
    public static final int ID_EXTERNAL_MEDIUM;
    public static final int ID_OPTICAL_MEDIUM;
    public static final int ID_BLUETOOTH_DEACTIVATION;
    public static final int ID_BLUETOOTH_SNIFF_MODE;
    public static final int ID_PARAMETER_SET_DVD_REGION_CODE;
    public static final int ID_PARAMETER_SET_BLUERAY_SYSTEM_REGION_CODE;
    public static final int ID_CD_EJECT_BUTTON_STATUS;
    public static final int ID_DEVELOPER_TESTMODE_ACTIVATED;
    public static final int ID_MIRRORLINK_COUNTRY_CODE;
    public static final int ID_ESTABLISH_LINK_ATTEMPTS;
    public static final int ID_SUMMER_TIME_SHIFT_METHOD;
    public static final int ID_NAVIGATION_GNSS_RECEIVER_SETTING_DEFAULT_HW_RECEPTION;
    public static final int ID_NAVIGATION_GNSS_RECEIVER_SETTING_GPS;
    public static final int ID_NAVIGATION_GNSS_RECEIVER_SETTING_GALILEO;
    public static final int ID_NAVIGATION_GNSS_RECEIVER_SETTING_GLONASS;
    public static final int ID_NAVIGATION_GNSS_RECEIVER_SETTING_COMPASS;
    public static final int ID_EXTERNAL_GPS_1;
    public static final int ID_EXTERNAL_GPS_2;
    public static final int ID_WLAN_MODUL_ACTIVATION;
    public static final int ID_SET_PAYTMC;
    public static final int ID_VZAPRO;
    public static final int ID_ONLINE_POI;
    public static final int ID_ONLINE_POI_VOICE;
    public static final int ID_ONLINE_PORTAL_BROWSER_SERVICES;
    public static final int ID_ONLINE_NAVIGATION;
    public static final int ID_ONLINE_STREET_VIEW;
    public static final int ID_WIFI_HOTSPOT;
    public static final int ID_MY_AUDI;
    public static final int ID_PICTURE_NAVI;
    public static final int ID_ONLINE_DICTATION;
    public static final int ID_REMOTE_HMI;
    public static final int ID_ADVANCED_RANGE_DISPLAY;
    public static final int ID_GRACENOTE_ONLINE_COVERARTS;
    public static final int ID_GRACENOTE_ONLINE_OTHER;
    public static final int ID_GRACENOTE_LOCAL_COVERARTS;
    public static final int ID_GRACENOTE_LOCAL_OTHER;
    public static final int ID_UPNP;
    public static final int ID_OPS_DISPLAY_IN_DASH_BOARD_DISPLAY_UNIT;
    public static final int ID_JOKER_BUTTON_1;
    public static final int ID_JOKER_BUTTON_2;
    public static final int ID_SUPPORT_SECOND_PHONE;
    public static final int ID_SUPPORT_OF_THREEWAY_CALLING;
    public static final int ID_DTMF_WITHOUT_ACTIVE_CALL;
    public static final int ID_SUPPORT_FOR_RESPONSE_AND_HOLD;
    public static final int ID_SIM_CARD_MODE_SWITCH;
    public static final int ID_PHONE_MODULE_OPERATION_MODE_VOICE;
    public static final int ID_PSD_PROTOCOL_VERSION;
    public static final int ID_ONLINE_SERVICES_HMI_AVAILABILITY;
    public static final int ID_RVC_VIDEO_INPUT;
    public static final int ID_STATION_LOGO_REGION;
    public static final int ID_MEDIA_COUNTRY_CODE;
    public static final int ID_ACTIVATION_FOR_EXTERNAL_USB_1;
    public static final int ID_ACTIVATION_FOR_EXTERNAL_USB_2;
    public static final int ID_ACTIVATION_FOR_EXTERNAL_USB_3;
    public static final int ID_ACTIVATION_FOR_EXTERNAL_USB_4;
    public static final int ID_MEDIA_COUNTRY_CODE_HMI;
    public static final int ID_MICROPHONE_SENSITIVITY;
    public static final int ID_GOOGLE_GAL;
    public static final int ID_APPLE_DIO;
    public static final int ID_STICKER_1;
    public static final int ID_STICKER_2;
    public static final int ID_STICKER_3;
    public static final int ID_STICKER_4;
    public static final int ID_STICKER_5;
    public static final int ID_STICKER_6;
    public static final int ID_STICKER_7;
    public static final int ID_STICKER_9;
    public static final int ID_STICKER_10;
    public static final int ID_STICKER_11;
    public static final int ID_STICKER_12;
    public static final int ID_STICKER_13;
    public static final int ID_STICKER_14;
    public static final int ID_STICKER_15;
    public static final int ID_STICKER_16;
    public static final int ID_MIRROR_LINK;
    public static final int ID_SD_SLOT_DEACTIVATION;
    public static final int ID_BAIDU_CAR_LIFE;
    public static final int ID_BAIDU_CAR_LIFE_IOS;
    public static final int ID_ACTIVATION_DEACTIVATION_OF_POPUPS_FOR_ACTIVE_TRACKING_SERVICES;
    public static final int ID_TRAFFIC_LIGHT_ONLINE_FUNCTIONS_STATE;
    public static final int ID_TELEPHONE_DEACTIVATION;
    public static final int ID_LTE_MODUL;
    public static final int ID_EMERGENCY_CALL_PRIVATE_MODE;
    public static final int ID_ACCESS_POINT_NAME_ENTRY;
    public static final int ID_CALL_CENTER_FUNCTION;
    public static final int ID_CALL_CENTER_FUNCTION_BREAKDOWN_CALL;
    public static final int ID_CALL_CENTER_FUNCTION_POI_CALL;
    public static final int ID_INTERNET_ACCESS_VIA_WIFI;
    public static final int ID_NAVIGATION_MAP_MOST_TRANSMISSION_MODE;
    public static final int ID_NAVIGATION_MAP_COMPRESSION_MODE;
    public static final int ID_NAVIGATION_MAP_RESOLUTION;
    public static final int ID_CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE;
    public static final int ID_CROSSROAD_DETAIL_MAP_COMPRESSION_MODE;
    public static final int ID_CROSSROAD_DETAIL_MAP_RESOLUTION;
    public static final int ID_COVERART;
    public static final int ID_STATIONART;
    public static final int ID_CALL_PICTURE;
    public static final int ID_MOST_FAST_LIST;
    public static final int ID_TPEG_AVAILABILITY;
    public static final int ID_VZO_AVAILABILITY;
    public static final int ID_LGI_AVAILABILITY;
    public static final int ID_PROBECAR_AVAILABILITY;
    public static final int ID_ONLINE_MEDIA_AVAILABLE;
    public static final int ID_PROBECAR_LGI_AVAILABILITY;
    public static final int ID_GATEWAY_COMPONENT_LIST_ZENTRALRECHNER;
    public static final int ID_GATEWAY_COMPONENT_LIST_RADIO;
    public static final int ID_GATEWAY_COMPONENT_LIST_SOUNDSYSTEM;
    public static final int ID_GATEWAY_COMPONENT_LIST_TVTUNER;
    public static final int ID_GATEWAY_COMPONENT_LIST_MEDIAPLAYER;
    public static final int ID_GATEWAY_COMPONENT_LIST_RSE;
    public static final int ID_GATEWAY_COMPONENT_LIST_MOSTKOMBI;
    public static final int ID_SMART_DISPLAY_CARRIER_2;
    public static final int ID_SMART_CONTROL_CARRIER_1;
    public static final int ID_SMART_CONTROL_CARRIER_2;
    public static final int ID_WIRELESS_CHARGER_1;
    public static final int ID_WIRELESS_CHARGER_2;
    public static final int ID_GATEWAY_COMPONENT_LIST_RESERVED_2;
    public static final int ID_MOBILE_PHONE_VOICE_CONTROL_APPLE_DEVICE;
    public static final int ID_MOBILE_PHONE_VOICE_CONTROL_OTHER_DEVICE;
    public static final int ID_INTERNAL_SIM_CARD_USAGE;
    public static final int ID_UPDATE_OVER_THE_AIR;
    public static final int ID_WIFI_CLIENT_HMI;
    public static final int ID_RSE_SOFTWARE_COMPONENT;
    public static final int ID_SMARTPHONE_INTERFACE_FOR_RHMI;
    public static final int ID_BLUETOOTH_AUDIO_CODEC;
    public static final int ID_MAP_SMS_SUPPORT;
    public static final int ID_MAP_EMAIL_SUPPORT;
    public static final int ID_MAP_INSTANT_MESSAGING_SUPPORT;
    public static final int ID_SIM_DATA_ONLY_SMS_SUPPORT;
    public static final int ID_ESIM_DATA_ONLY_SMS_SUPPORT;
    public static final int ID_ALLOW_MESSAGE_EDITING;
    public static final int ID_VEHICLE_READINESS_SOUND;
    public static final int ID_VEHICLE_LEAVING_SOUND;
    public static final int ID_MAP_STYLE;
    public static final int ID_TX_POWER;
    public static final int ID_SDS_REGION_FLAG;
    public static final int ID_ENGINE_TYPE_ADAPTION;
    public static final int ID_CROSSROAD_DETAIL_MAP_TRANSMISSION_MODE;
    public static final int ID_RESERVED_1;
    public static final int ID_PRIVACY_WITHPINREQUEST;
    public static final int ID_PHONE_HMI_PRIVACY;
    public static final int ID_HYBRID_RADIO_ADDITIONAL_ONLINE_DATA;
    public static final int ID_HYBRID_RADIO_RANGE_EXTENDER;
    public static final int ID_ONLINE_RADIO;
    public static final int ID_SCON_TELEPHONY;
    public static final int ID_VOICE_OVER_LTE;
    public static final int ID_SHOW_VOLTE_HMI_SWITCH;
    public static final int ID_UNBLOCK_FUNCTIONS_WHILE_PILOTED_DRIVING;
    public static final int ID_BLOCK_HMI_FUNCTION_P_EPB;
    public static final int ID_POPUP_IF_GPS_SERVICES_IN_USE;
    public static final int ID_RESERVED_FOR_VEHICLE_CONF;
    public static final byte RESET_FUNCTION_RADIO;
    public static final byte RESET_FUNCTION_NAVIGATION;
    public static final byte RESET_FUNCTION_AUDIO_MEDIA_OPTICAL;
    public static final byte RESET_FUNCTION_VIDEO_MEDIA_OPTICAL;
    public static final byte RESET_FUNCTION_DATA_MEDIA_OPTICAL;
    public static final byte RESET_FUNCTION_USB_MEDIA;
    public static final byte RESET_FUNCTION_SD_MEDIA;
    public static final byte RESET_FUNCTION_WIRELESS_MEDIA;
    public static final byte RESET_FUNCTION_HDD_MEDIA;
    public static final byte RESET_FUNCTION_TV_MEDIA;
    public static final byte RESET_FUNCTION_PHONE;
    public static final byte RESET_FUNCTION_SOUND;
    public static final byte RESET_FUNCTION_SETUP;
    public static final byte RESET_FUNCTION_CAR_MENU;
    public static final byte RESET_FUNCTION_ADDRESSBOOK;
    public static final byte RESET_FUNCTION_NAVINFO_TRAFFIC;
    public static final byte RESET_FUNCTION_BROWSER;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_FREE_TMC;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_TMC_PRO;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_TMC_PRO;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_TMC_PRO;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_WITHOUT_MEDIA_MOBILE;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE;
    public static final int PAY_TMC_SET_AUDI_ONLINE_TRAFFIC_INFO_BLUE;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE;
    public static final int PAY_TMC_SET_VW_ONLINE_TRAFFIC_INFO_BLUE;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_TMC_PRO_INFO_BLUE;
    public static final int PAY_TMC_SET_BENTLEY_ONLINE_TRAFFIC_INFO_BLUE;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_ITIS_INFO_BLUE_VIA_MICHELIN;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_RUSSIA_FREE_TMC;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_RUSSIA_TMC_PRO;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_TMC_PRO_TRAFFIC_MASTER_INFO_BLUE_VIA_MICHELIN_FREE_DAB_TPEG;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_GER;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_FRANCE;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_UK;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_PAY_TMC_PT;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_VW_PAY_TMC_ALL;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_INTELMATICS;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_ALTECH_NETSTAR;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_CHINA_CENNAVI;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_CHINA_AUTONAVI;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_SIRIUS_FREE_TMC;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_SIRIUS;
    public static final int PAY_TMC_SET_ONLINE_TRAFFIC_NAR_CLEARCHANNEL_HD;
    public static final int ACCESS_POINT_NAME_ENTRY_ACTIVATED;
    public static final int ACCESS_POINT_NAME_ENTRY_DEACTIVATED;
    public static final int ACTIVATION_DEACTIVATION_OF_POPUPS_FOR_ACTIVE_TRACKING_SERVICES_OFF;
    public static final int ACTIVATION_DEACTIVATION_OF_POPUPS_FOR_ACTIVE_TRACKING_SERVICES_ON;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_1_ACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_1_DEACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_2_ACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_2_DEACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_3_ACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_3_DEACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_4_ACTIVATE;
    public static final int ACTIVATION_FOR_EXTERNAL_USB_4_DEACTIVATE;
    public static final int ALLOW_MESSAGE_EDITING_OFF;
    public static final int ALLOW_MESSAGE_EDITING_ON;
    public static final int BAIDU_CAR_LIFE_IOS_OFF;
    public static final int BAIDU_CAR_LIFE_IOS_ON;
    public static final int BAIDU_CAR_LIFE_OFF;
    public static final int BAIDU_CAR_LIFE_ON;
    public static final int BLOCK_HMI_FUNCTION_P_EPB_BLOCKED;
    public static final int BLOCK_HMI_FUNCTION_P_EPB_NOT_BLOCKED;
    public static final int BLUETOOTH_DEACTIVATION_STATE_NOT_AVAILABLE;
    public static final int BLUETOOTH_DEACTIVATION_STATE_OFF;
    public static final int BLUETOOTH_DEACTIVATION_STATE_ON;
    public static final int CALL_CENTER_FUNCTION_BREAKDOWN_CALL_OFF;
    public static final int CALL_CENTER_FUNCTION_BREAKDOWN_CALL_ON;
    public static final int CALL_CENTER_FUNCTION_NOT_VISIBLE;
    public static final int CALL_CENTER_FUNCTION_POI_CALL_OFF;
    public static final int CALL_CENTER_FUNCTION_POI_CALL_ON;
    public static final int CALL_CENTER_FUNCTION_VISIBLE;
    public static final int CROSSROAD_DETAIL_MAP_COMPRESSION_MODE_H264;
    public static final int CROSSROAD_DETAIL_MAP_COMPRESSION_MODE_RLE;
    public static final int CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_MOST_HIGH;
    public static final int CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_MOST_STREAMING;
    public static final int CROSSROAD_DETAIL_MAP_MOST_TRANSMISSION_MODE_OFF;
    public static final int CROSSROAD_DETAIL_MAP_RESOLUTION_RESOLUTION_1;
    public static final int CROSSROAD_DETAIL_MAP_RESOLUTION_RESOLUTION_2;
    public static final int CROSSROAD_DETAIL_MAP_RESOLUTION_RESOLUTION_3;
    public static final int CROSSROAD_DETAIL_MAP_TRANSMISSION_MODE_MOST_HIGH;
    public static final int CROSSROAD_DETAIL_MAP_TRANSMISSION_MODE_NOT_DEFINED;
    public static final int CROSSROAD_DETAIL_MAP_TRANSMISSION_MODE_OFF;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_ACTIVATED;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_DEACTIVATED;
    public static final int EMERGENCY_CALL_PRIVATE_MODE_USER_DEFINED;
    public static final int ESIM_DATA_ONLY_SMS_SUPPORT_OFF;
    public static final int ESIM_DATA_ONLY_SMS_SUPPORT_ON;
    public static final int GATEWAY_COMPONENT_LIST_MEDIAPLAYER_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_MEDIAPLAYER_NOT_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_MOSTKOMBI_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_MOSTKOMBI_NOT_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_RADIO_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_RADIO_NOT_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_RSE_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_RSE_NOT_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_SOUNDSYSTEM_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_SOUNDSYSTEM_NOT_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_TVTUNER_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_TVTUNER_NOT_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_ZENTRALRECHNER_AVAILABLE;
    public static final int GATEWAY_COMPONENT_LIST_ZENTRALRECHNER_NOT_AVAILABLE;
    public static final int HYBRID_RADIO_ADDITIONAL_ONLINE_DATA_ACTIVATED;
    public static final int HYBRID_RADIO_ADDITIONAL_ONLINE_DATA_DEACTIVATED;
    public static final int HYBRID_RADIO_RANGE_EXTENDER_AUTOMATIC_WITHOUT_TIME_SCALING;
    public static final int HYBRID_RADIO_RANGE_EXTENDER_AUTOMATIC_WITH_TIME_SCALING;
    public static final int HYBRID_RADIO_RANGE_EXTENDER_DEACTIVATED;
    public static final int HYBRID_RADIO_RANGE_EXTENDER_MANUAL_ONLY;
    public static final int INTERNAL_SIM_CARD_USAGE_AUTOMATIC;
    public static final int INTERNAL_SIM_CARD_USAGE_NEVER;
    public static final int INTERNET_ACCESS_VIA_WIFI_AVAILABLE;
    public static final int INTERNET_ACCESS_VIA_WIFI_NOT_AVAILABLE;
    public static final int JOKER_BUTTON_1_LEFT;
    public static final int JOKER_BUTTON_1_NOT_DETECTED;
    public static final int JOKER_BUTTON_1_RIGHT;
    public static final int JOKER_BUTTON_2_LEFT;
    public static final int JOKER_BUTTON_2_NOT_DETECTED;
    public static final int JOKER_BUTTON_2_RIGHT;
    public static final int LGI_AVAILABILITY_OFF;
    public static final int LGI_AVAILABILITY_ON;
    public static final int LTE_MODUL_ACTIVATED;
    public static final int LTE_MODUL_DEACTIVATED;
    public static final int MAP_EMAIL_SUPPORT_OFF;
    public static final int MAP_EMAIL_SUPPORT_ON;
    public static final int MAP_INSTANT_MESSAGING_SUPPORT_OFF;
    public static final int MAP_INSTANT_MESSAGING_SUPPORT_ON;
    public static final int MAP_SMS_SUPPORT_OFF;
    public static final int MAP_SMS_SUPPORT_ON;
    public static final int MAP_STYLE_PO_GO_ONE;
    public static final int MAP_STYLE_PO_GO_TWO;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_CHN;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_HK;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_JP;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_KOR;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_MO;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_NAR;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_RD_ROW;
    public static final int MIRRORLINK_COUNTRY_CODE_MIB_TWN;
    public static final int MIRRORLINK_COUNTRY_CODE_MIN_EU;
    public static final int MIRRORLINK_COUNTRY_CODE_OTHER;
    public static final int MIRROR_LINK_FUNCTION_OFF_HMI_OFF;
    public static final int MIRROR_LINK_FUNCTION_ON_HMI_OFF;
    public static final int MIRROR_LINK_FUNCTION_ON_HMI_ON;
    public static final int MOBILE_PHONE_VOICE_CONTROL_APPLE_DEVICE_INSTALLED;
    public static final int MOBILE_PHONE_VOICE_CONTROL_APPLE_DEVICE_NOT_INSTALLED;
    public static final int MOBILE_PHONE_VOICE_CONTROL_OTHER_DEVICE_INSTALLED;
    public static final int MOBILE_PHONE_VOICE_CONTROL_OTHER_DEVICE_NOT_INSTALLED;
    public static final int MOST_FAST_LIST_OFF;
    public static final int MOST_FAST_LIST_ON;
    public static final int NAVIGATION_MAP_COMPRESSION_MODE_H264;
    public static final int NAVIGATION_MAP_COMPRESSION_MODE_RLE;
    public static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_MOST_HIGH;
    public static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_MOST_STREAMING;
    public static final int NAVIGATION_MAP_MOST_TRANSMISSION_MODE_OFF;
    public static final int NAVIGATION_MAP_RESOLUTION_RESOLUTION_1;
    public static final int NAVIGATION_MAP_RESOLUTION_RESOLUTION_2;
    public static final int NAVIGATION_MAP_RESOLUTION_RESOLUTION_3;
    public static final int ONLINE_MEDIA_AVAILABLE_OFF;
    public static final int ONLINE_MEDIA_AVAILABLE_ON;
    public static final int ONLINE_RADIO_DEACTIVATED;
    public static final int ONLINE_RADIO_NATIVE_HMI_AND_HMISDK;
    public static final int ONLINE_RADIO_NATIVE_HMI_ONLY;
    public static final int ONLINE_SERVICES_HMI_AVAILABILITY_ACTIVATED;
    public static final int ONLINE_SERVICES_HMI_AVAILABILITY_DEACTIVATED;
    public static final int PHONE_MODULE_OPERATION_MODE_VOICE_DATA_AND_VOICE;
    public static final int PHONE_MODULE_OPERATION_MODE_VOICE_DATA_ONLY;
    public static final int POPUP_IF_GPS_SERVICES_IN_USE_ACTIVATED;
    public static final int POPUP_IF_GPS_SERVICES_IN_USE_DEACTIVATED;
    public static final int PROBECAR_AVAILABILITY_OFF;
    public static final int PROBECAR_AVAILABILITY_ON;
    public static final int PROBECAR_LGI_AVAILABILITY_OFF;
    public static final int PROBECAR_LGI_AVAILABILITY_ON;
    public static final int PSD_PROTOCOL_VERSION_PSD1_4;
    public static final int PSD_PROTOCOL_VERSION_PSD1_5;
    public static final int RSE_SOFTWARE_COMPONENT_OFF;
    public static final int RSE_SOFTWARE_COMPONENT_ON;
    public static final int RVC_VIDEO_INPUT_FBAS;
    public static final int RVC_VIDEO_INPUT_LVDS;
    public static final int SCON_TELEPHONY_ACTIVATED;
    public static final int SCON_TELEPHONY_DEACTIVATED;
    public static final int SD_SLOT_DEACTIVATION_ALL_SD_SLOTS_ACTIV;
    public static final int SD_SLOT_DEACTIVATION_SD_SLOT_ONE_INACTIV;
    public static final int SD_SLOT_DEACTIVATION_SD_SLOT_TWO_INACTIV;
    public static final int SHOW_VOLTE_HMI_SWITCH_ACTIVATED;
    public static final int SHOW_VOLTE_HMI_SWITCH_DEACTIVATED;
    public static final int SIM_DATA_ONLY_SMS_SUPPORT_OFF;
    public static final int SIM_DATA_ONLY_SMS_SUPPORT_ON;
    public static final int SMART_CONTROL_CARRIER_2_AVAILABLE;
    public static final int SMART_CONTROL_CARRIER_2_NOT_AVAILABLE;
    public static final int STICKER_10_ACTIVE;
    public static final int STICKER_10_NOT_ACTIVE;
    public static final int STICKER_11_ACTIVE;
    public static final int STICKER_11_NOT_ACTIVE;
    public static final int STICKER_12_ACTIVE;
    public static final int STICKER_12_NOT_ACTIVE;
    public static final int STICKER_13_ACTIVE;
    public static final int STICKER_13_NOT_ACTIVE;
    public static final int STICKER_14_ACTIVE;
    public static final int STICKER_14_NOT_ACTIVE;
    public static final int STICKER_15_ACTIVE;
    public static final int STICKER_15_NOT_ACTIVE;
    public static final int STICKER_16_ACTIVE;
    public static final int STICKER_16_NOT_ACTIVE;
    public static final int STICKER_1_ACTIVE;
    public static final int STICKER_1_NOT_ACTIVE;
    public static final int STICKER_2_ACTIVE;
    public static final int STICKER_2_NOT_ACTIVE;
    public static final int STICKER_3_ACTIVE;
    public static final int STICKER_3_NOT_ACTIVE;
    public static final int STICKER_4_ACTIVE;
    public static final int STICKER_4_NOT_ACTIVE;
    public static final int STICKER_5_ACTIVE;
    public static final int STICKER_5_NOT_ACTIVE;
    public static final int STICKER_6_ACTIVE;
    public static final int STICKER_6_NOT_ACTIVE;
    public static final int STICKER_7_FAW_SCREEN;
    public static final int STICKER_7_NOT_VALID;
    public static final int STICKER_7_SVW_SCREEN;
    public static final int STICKER_7_VW_IMPORTED;
    public static final int STICKER_9_ACTIVE;
    public static final int STICKER_9_NOT_ACTIVE;
    public static final int SUMMER_TIME_SHIFT_METHOD_CET;
    public static final int SUMMER_TIME_SHIFT_METHOD_MANUAL;
    public static final int SUMMER_TIME_SHIFT_METHOD_NONE;
    public static final int SUMMER_TIME_SHIFT_METHOD_USA;
    public static final int SUPPORT_SECOND_PHONE_ACTIVATED;
    public static final int SUPPORT_SECOND_PHONE_DEACTIVATED;
    public static final int TELEPHONE_DEACTIVATION_ACTIVATED;
    public static final int TELEPHONE_DEACTIVATION_DATA_ONLY;
    public static final int TELEPHONE_DEACTIVATION_NOT_ACTIVATED;
    public static final int TELEPHONE_DEACTIVATION_NOT_AVAILABLE;
    public static final int TELEPHONE_DEACTIVATION_VOICE_ONLY;
    public static final int TPEG_AVAILABILITY_OFF;
    public static final int TPEG_AVAILABILITY_ON;
    public static final int TRAFFIC_LIGHT_ONLINE_FUNCTIONS_STATE_STATE_OFF;
    public static final int TRAFFIC_LIGHT_ONLINE_FUNCTIONS_STATE_STATE_ON;
    public static final int UNBLOCK_FUNCTIONS_WHILE_PILOTED_DRIVING_BLOCKED;
    public static final int UNBLOCK_FUNCTIONS_WHILE_PILOTED_DRIVING_NOT_BLOCKED;
    public static final int UPDATE_OVER_THE_AIR_OFF;
    public static final int UPDATE_OVER_THE_AIR_ON;
    public static final int VEHICLE_LEAVING_SOUND_ACTIVE;
    public static final int VEHICLE_LEAVING_SOUND_NOT_ACTIVE;
    public static final int VEHICLE_READINESS_SOUND_ACTIVE;
    public static final int VEHICLE_READINESS_SOUND_NOT_ACTIVE;
    public static final int VOICE_OVER_LTE_ACTIVATED;
    public static final int VOICE_OVER_LTE_NOT_ACTIVE;
    public static final int VZO_AVAILABILITY_OFF;
    public static final int VZO_AVAILABILITY_ON;
    public static final int WIRELESS_CHARGER_1_NO;
    public static final int WIRELESS_CHARGER_1_YES;
    public static final int WIRELESS_CHARGER_2_NO;
    public static final int WIRELESS_CHARGER_2_YES;
    public static final int WLAN_MODUL_ACTIVATION_ACTIVATED;
    public static final int WLAN_MODUL_ACTIVATION_NOT_ACTIVATED;

    default public boolean isPayTmcSetOnlineTrafficAvailable(int n) {
    }

    default public boolean isAccessPointNameEntryActivated(int n) {
    }

    default public boolean isAccessPointNameEntryDeactivated(int n) {
    }

    default public boolean isActivationForExternalUsb1Activate(int n) {
    }

    default public boolean isActivationForExternalUsb1Deactivate(int n) {
    }

    default public boolean isActivationForExternalUsb2Activate(int n) {
    }

    default public boolean isActivationForExternalUsb2Deactivate(int n) {
    }

    default public boolean isActivationForExternalUsb3Activate(int n) {
    }

    default public boolean isActivationForExternalUsb3Deactivate(int n) {
    }

    default public boolean isActivationForExternalUsb4Activate(int n) {
    }

    default public boolean isActivationForExternalUsb4Deactivate(int n) {
    }

    default public boolean isBluetoothDeactivationStateNotAvailable(int n) {
    }

    default public boolean isBluetoothDeactivationStateOff(int n) {
    }

    default public boolean isBluetoothDeactivationStateOn(int n) {
    }

    default public boolean isCallCenterFunctionNotVisible(int n) {
    }

    default public boolean isCallCenterFunctionVisible(int n) {
    }

    default public boolean isCrossroadDetailMapCompressionModeH264(int n) {
    }

    default public boolean isCrossroadDetailMapCompressionModeRle(int n) {
    }

    default public boolean isCrossroadDetailMapMostTransmissionModeMostHigh(int n) {
    }

    default public boolean isCrossroadDetailMapMostTransmissionModeMostStreaming(int n) {
    }

    default public boolean isCrossroadDetailMapMostTransmissionModeOff(int n) {
    }

    default public boolean isCrossroadDetailMapResolutionResolution1(int n) {
    }

    default public boolean isCrossroadDetailMapResolutionResolution2(int n) {
    }

    default public boolean isCrossroadDetailMapResolutionResolution3(int n) {
    }

    default public boolean isEmergencyCallPrivateModeActivated(int n) {
    }

    default public boolean isEmergencyCallPrivateModeDeactivated(int n) {
    }

    default public boolean isEmergencyCallPrivateModeUserDefined(int n) {
    }

    default public boolean isJokerButton1Left(int n) {
    }

    default public boolean isJokerButton1NotDetected(int n) {
    }

    default public boolean isJokerButton1Right(int n) {
    }

    default public boolean isJokerButton2Left(int n) {
    }

    default public boolean isJokerButton2NotDetected(int n) {
    }

    default public boolean isJokerButton2Right(int n) {
    }

    default public boolean isNavigationMapCompressionModeH264(int n) {
    }

    default public boolean isNavigationMapCompressionModeRle(int n) {
    }

    default public boolean isNavigationMapMostTransmissionModeMostHigh(int n) {
    }

    default public boolean isNavigationMapMostTransmissionModeMostStreaming(int n) {
    }

    default public boolean isNavigationMapMostTransmissionModeOff(int n) {
    }

    default public boolean isNavigationMapResolutionResolution1(int n) {
    }

    default public boolean isNavigationMapResolutionResolution2(int n) {
    }

    default public boolean isNavigationMapResolutionResolution3(int n) {
    }

    default public boolean isOnlineServicesHmiAvailabilityActivated(int n) {
    }

    default public boolean isOnlineServicesHmiAvailabilityDeactivated(int n) {
    }

    default public boolean isPsdProtocolVersionPsd14(int n) {
    }

    default public boolean isPsdProtocolVersionPsd15(int n) {
    }

    default public boolean isRvcVideoInputFbas(int n) {
    }

    default public boolean isRvcVideoInputLvds(int n) {
    }

    default public boolean isSummerTimeShiftMethodCet(int n) {
    }

    default public boolean isSummerTimeShiftMethodManual(int n) {
    }

    default public boolean isSummerTimeShiftMethodNone(int n) {
    }

    default public boolean isSummerTimeShiftMethodUsa(int n) {
    }

    default public boolean isTelephoneDeactivationActivated(int n) {
    }

    default public boolean isTelephoneDeactivationDataOnly(int n) {
    }

    default public boolean isTelephoneDeactivationNotActivated(int n) {
    }

    default public boolean isTelephoneDeactivationNotAvailable(int n) {
    }

    default public boolean isTelephoneDeactivationVoiceOnly(int n) {
    }

    default public boolean isTpegAvailabilityOff(int n) {
    }

    default public boolean isTpegAvailabilityOn(int n) {
    }

    default public boolean isWlanModulActivationActivated(int n) {
    }

    default public boolean isWlanModulActivationNotActivated(int n) {
    }
}

