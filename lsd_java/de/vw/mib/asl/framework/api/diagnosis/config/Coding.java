/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.diagnosis.config;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;

public interface Coding
extends Access {
    public static final int ID_CAR_BRAND;
    public static final int ID_CAR_CLASS;
    public static final int ID_CAR_GENERATION;
    public static final int ID_CAR_DERIVATE;
    public static final int ID_CAR_DERIVATE_SUPPLEMENT;
    public static final int ID_COUNTRY;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_1;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_1;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_2;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_2;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_3;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_3;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_4;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_4;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_5;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_5;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_6;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_6;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_7;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_7;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_8;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_8;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_9;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_9;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_10;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_10;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_11;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_11;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_12;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_12;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_13;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_13;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_14;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_14;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_15;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_15;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_HT_16;
    public static final int ID_SPEAKER_CHANNEL_INSTALLED_TT_16;
    public static final int ID_MICROPHONE_1;
    public static final int ID_MICROPHONE_2;
    public static final int ID_HEADPHONES_OUTPUT_1;
    public static final int ID_HEADPHONES_OUTPUT_2;
    public static final int ID_AUX_IN;
    public static final int ID_AMI;
    public static final int ID_TEL_IN;
    public static final int ID_BAND_SETTINGS_FM_TUNER;
    public static final int ID_BAND_SETTINGS_AM_TUNER;
    public static final int ID_BAND_SETTINGS_DAB_TUNER_BAND_1;
    public static final int ID_BAND_SETTINGS_DAB_TUNER_BAND_2;
    public static final int ID_SOUND_SYSTEM;
    public static final int ID_FM_ANTENNA;
    public static final int ID_HD_ANTENNA;
    public static final int ID_RDS;
    public static final int ID_AF;
    public static final int ID_HD_RADIO_ACTIVATION;
    public static final int ID_RADIO_TEXT_PLUS;
    public static final int ID_PI;
    public static final int ID_BWS;
    public static final int ID_DAB_ALARM_ANOUNCEMENT;
    public static final int ID_FM_PTY31_ALARM;
    public static final int ID_AM_DISABLE;
    public static final int ID_MULTICHANNEL_RECEIVE;
    public static final int ID_MULTIPLE_ENTRY_SWITCH;
    public static final int ID_RDS_DEACTIVATION;
    public static final int ID_AF_DEACTIVATION;
    public static final int ID_BASEPLATE;
    public static final int ID_ANTENNA_BASEPLATE;
    public static final int ID_CRADLE_FORCE;
    public static final int ID_HANDY_IN_CRADLE_FORCE;
    public static final int ID_PHONE_NAD;
    public static final int ID_WIRELESS_CHARGING;
    public static final int ID_BLUETOOTH_AVAILABILITY;
    public static final int ID_BLUETOOTH_MULTIMEDIA_FUNCTIONALITY;
    public static final int ID_BLUETOOTH_PHONE;
    public static final int ID_BLUETOOTH_AUDIO;
    public static final int ID_BLUETOOTH_VISIBILITY;
    public static final int ID_BLUETOOTH_HEADPHONES;
    public static final int ID_SKINNING;
    public static final int ID_SCREENINGS;
    public static final int ID_LOG_BOOK;
    public static final int ID_SUSPENSION_ARM_SIDE;
    public static final int ID_KOMBI_TRACK_STATION_INFO;
    public static final int ID_REAR_VIEW_LOW;
    public static final int ID_MOST;
    public static final int ID_USB;
    public static final int ID_DISPLAY_1;
    public static final int ID_DISPLAY_2;
    public static final int ID_DISPLAY_3;
    public static final int ID_DISPLAY_4;
    public static final int ID_DASHBOARD_AUDIO_SLIDE;
    public static final int ID_DASHBOARD_PHONE_SLIDE;
    public static final int ID_DASHBOARD_NAVIGATION_SLIDE;
    public static final int ID_DASHBOARD_COMMUNICATION;
    public static final int ID_SCROLLING;
    public static final int ID_MESSAGING_VIA_MAP;
    public static final int ID_PAGEWISE_SCROLLING;
    public static final int ID_GPS_ANTENNA_AVAILABILITY;
    public static final int ID_DASHBOARD_GRAPHIC_VARIANT;
    public static final int ID_DASHBOARD_TEXT_REPLACEMENT;
    public static final int ID_BYTE_22_BAP_SDS_SD;
    public static final int ID_BYTE_22_BAP_ONLINE_FUNCTION_SECONDARY_DISPLAY;
    public static final int ID_KEYPAD_REAR_KEYS;
    public static final int ID_WHEEL_DRIVE;
    public static final int ID_SPELLER;
    public static final int ID_INITIAL_DISCLAIMER;
    public static final int ID_LEGAL_DISCLAIMER;
    public static final int ID_EMERGENCY_CALL;
    public static final int ID_VOICE_CONTROL_SYSTEM;
    public static final int ID_NAVIGATION_SYSTEM;
    public static final int ID_WLAN_MODULE;
    public static final int ID_IMPORT_MEDIA_DATA;
    public static final int ID_RIPPING_MEDIA_DATA;
    public static final int ID_VZA;
    public static final int ID_PSD;
    public static final int AF_PERSISTENT;
    public static final int AF_TEMPORARY;
    public static final int BAND_SETTINGS_AM_TUNER_EU;
    public static final int BAND_SETTINGS_AM_TUNER_EU_RDW;
    public static final int BAND_SETTINGS_AM_TUNER_JP;
    public static final int BAND_SETTINGS_AM_TUNER_NAR;
    public static final int BAND_SETTINGS_AM_TUNER_NO_SETTING;
    public static final int BAND_SETTINGS_AM_TUNER_OFF;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_CANADA_L_BAND;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_CHINA_BAND_III;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_DOWNLOAD_TABLE_1;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_EU_BAND_III;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_EU_BAND_III_N;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_KOREA_BAND_III;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_NEW_ZEALAND_BAND_III;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_1_OFF;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_2_DOWNLOAD_TABLE_2;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_2_L_BAND;
    public static final int BAND_SETTINGS_DAB_TUNER_BAND_2_OFF;
    public static final int BAND_SETTINGS_FM_TUNER_BRA;
    public static final int BAND_SETTINGS_FM_TUNER_CHINA;
    public static final int BAND_SETTINGS_FM_TUNER_EU_RDW;
    public static final int BAND_SETTINGS_FM_TUNER_JP;
    public static final int BAND_SETTINGS_FM_TUNER_JP_2;
    public static final int BAND_SETTINGS_FM_TUNER_KOR;
    public static final int BAND_SETTINGS_FM_TUNER_KOR_2;
    public static final int BAND_SETTINGS_FM_TUNER_NAR;
    public static final int BAND_SETTINGS_FM_TUNER_NO_SETTING;
    public static final int BLUETOOTH_VISIBILITY_AUTO;
    public static final int BLUETOOTH_VISIBILITY_LIMITED;
    public static final int BLUETOOTH_VISIBILITY_OFF;
    public static final int BLUETOOTH_VISIBILITY_ON;
    public static final int BWS_NO;
    public static final int BWS_RESTRICTED;
    public static final int BWS_RESTRICTED_UNRESTRICTED;
    public static final int BWS_UNRESTRICTED;
    public static final int BYTE_22_BAP_ONLINE_FUNCTION_SECONDARY_DISPLAY_OFF;
    public static final int BYTE_22_BAP_ONLINE_FUNCTION_SECONDARY_DISPLAY_ON;
    public static final int BYTE_22_BAP_SDS_SD_STATE_OFF;
    public static final int BYTE_22_BAP_SDS_SD_STATE_ON;
    public static final int CAR_BRAND_AUDI;
    public static final int CAR_BRAND_BENTLEY;
    public static final int CAR_BRAND_MAN;
    public static final int CAR_BRAND_NO_BRAND;
    public static final int CAR_BRAND_PORSCHE;
    public static final int CAR_BRAND_SEAT;
    public static final int CAR_BRAND_SKODA;
    public static final int CAR_BRAND_VW;
    public static final int CAR_BRAND_VW_NFZ;
    public static final int CAR_CLASS_A;
    public static final int CAR_CLASS_A0;
    public static final int CAR_CLASS_A00;
    public static final int CAR_CLASS_A000;
    public static final int CAR_CLASS_B;
    public static final int CAR_CLASS_C;
    public static final int CAR_CLASS_D;
    public static final int CAR_CLASS_E_MINUS;
    public static final int CAR_CLASS_E_PLUS;
    public static final int CAR_CLASS_OTHERS;
    public static final int CAR_DERIVATE_CABRIO_ROADSTER_SPIDER_TARGA;
    public static final int CAR_DERIVATE_COUPE;
    public static final int CAR_DERIVATE_FLIESSHECK_SPORTSBACK;
    public static final int CAR_DERIVATE_KOMBI;
    public static final int CAR_DERIVATE_KURZHECK;
    public static final int CAR_DERIVATE_PICK_UP;
    public static final int CAR_DERIVATE_RAUMKONZEPT;
    public static final int CAR_DERIVATE_SONSTIGE;
    public static final int CAR_DERIVATE_STUFENHECK;
    public static final int CAR_DERIVATE_SUPPLEMENT_ALTERN_ANTRIEB;
    public static final int CAR_DERIVATE_SUPPLEMENT_AUFBAU_DACHVAR;
    public static final int CAR_DERIVATE_SUPPLEMENT_CROSS_ALLROAD;
    public static final int CAR_DERIVATE_SUPPLEMENT_GEAENDERT_FRONT_HECK;
    public static final int CAR_DERIVATE_SUPPLEMENT_KURZER_RADSTAND;
    public static final int CAR_DERIVATE_SUPPLEMENT_LANGER_RADSTAND;
    public static final int CAR_DERIVATE_SUPPLEMENT_LEISTUNGSVARI_2;
    public static final int CAR_DERIVATE_SUPPLEMENT_LEISTUNGVARI_1;
    public static final int CAR_DERIVATE_SUPPLEMENT_SONST;
    public static final int CAR_DERIVATE_SUPPLEMENT_SONSTIGE;
    public static final int CAR_DERIVATE_SUV;
    public static final int COUNTRY_ASIA_PACIFIC;
    public static final int COUNTRY_AUSTRALIA;
    public static final int COUNTRY_CENTRAL_ASIA;
    public static final int COUNTRY_CHINA;
    public static final int COUNTRY_CHINA2;
    public static final int COUNTRY_CHINA3;
    public static final int COUNTRY_EU;
    public static final int COUNTRY_INDIA;
    public static final int COUNTRY_ISRAEL;
    public static final int COUNTRY_JAPAN;
    public static final int COUNTRY_KOREA;
    public static final int COUNTRY_MEAST;
    public static final int COUNTRY_MSA;
    public static final int COUNTRY_MSA2;
    public static final int COUNTRY_NAR;
    public static final int COUNTRY_NEAST;
    public static final int COUNTRY_NM_AFRICA;
    public static final int COUNTRY_NO_COUNTRY;
    public static final int COUNTRY_SOUTH_AFRIKA;
    public static final int COUNTRY_TAIWAN;
    public static final int DASHBOARD_COMMUNICATION_BAP;
    public static final int DASHBOARD_COMMUNICATION_DDP2;
    public static final int DASHBOARD_GRAPHIC_VARIANT_CAN;
    public static final int DASHBOARD_GRAPHIC_VARIANT_MOST;
    public static final int HD_ANTENNA_AM_FM;
    public static final int HD_ANTENNA_FM;
    public static final int HD_ANTENNA_MRC;
    public static final int HD_ANTENNA_SWITCHING;
    public static final int HD_ANTENNA_TEST_MODE;
    public static final int HD_RADIO_ACTIVATION_ACTIVE;
    public static final int HD_RADIO_ACTIVATION_NOT_ACTIVE;
    public static final int KEYPAD_REAR_KEYS_AVAILABLE;
    public static final int KEYPAD_REAR_KEYS_NOT;
    public static final int KOMBI_TRACK_STATION_INFO_LONG_INFO;
    public static final int KOMBI_TRACK_STATION_INFO_NOT_AVAILABLE;
    public static final int KOMBI_TRACK_STATION_INFO_SHORT_INFO;
    public static final int PI_PI_IGNORE_OFF;
    public static final int PI_PI_IGNORE_ON;
    public static final int SCREENINGS_NO_SCREEN;
    public static final int SKINNING_NO_SKINNING;
    public static final int SOUND_SYSTEM_EXTERN;
    public static final int SOUND_SYSTEM_EXTERN_BAP;
    public static final int SOUND_SYSTEM_INTERN;
    public static final int SOUND_SYSTEM_INTERNAL_INDIVIDUAL;
    public static final int SOUND_SYSTEM_NO_ALLOC;
    public static final int SUSPENSION_ARM_SIDE_LEFT;
    public static final int SUSPENSION_ARM_SIDE_RIGHT;
    public static final int USB_CHARGE;
    public static final int USB_FULL;
    public static final int USB_OFF;
    public static final int USB_USB_IPOD;
    public static final int WHEEL_DRIVE_ALL;
    public static final int WHEEL_DRIVE_FRONT;
    public static final int WHEEL_DRIVE_REAR;
    public static final int WIRELESS_CHARGING_AVAILABLE;
    public static final int WIRELESS_CHARGING_NOT_AVAILABLE;

    default public boolean isAfPersistent(int n) {
    }

    default public boolean isAfTemporary(int n) {
    }

    default public boolean isBandSettingsAmTunerEu(int n) {
    }

    default public boolean isBandSettingsAmTunerEuRdw(int n) {
    }

    default public boolean isBandSettingsAmTunerJp(int n) {
    }

    default public boolean isBandSettingsAmTunerNar(int n) {
    }

    default public boolean isBandSettingsAmTunerNoSetting(int n) {
    }

    default public boolean isBandSettingsAmTunerOff(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1CanadaLBand(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1ChinaBandIii(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1DownloadTable1(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1EuBandIii(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1EuBandIiiN(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1KoreaBandIii(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1NewZealandBandIii(int n) {
    }

    default public boolean isBandSettingsDabTunerBand1Off(int n) {
    }

    default public boolean isBandSettingsDabTunerBand2DownloadTable2(int n) {
    }

    default public boolean isBandSettingsDabTunerBand2LBand(int n) {
    }

    default public boolean isBandSettingsDabTunerBand2Off(int n) {
    }

    default public boolean isBandSettingsFmTunerChina(int n) {
    }

    default public boolean isBandSettingsFmTunerEuRdw(int n) {
    }

    default public boolean isBandSettingsFmTunerJp(int n) {
    }

    default public boolean isBandSettingsFmTunerKor(int n) {
    }

    default public boolean isBandSettingsFmTunerNar(int n) {
    }

    default public boolean isBandSettingsFmTunerNoSetting(int n) {
    }

    default public boolean isBluetoothVisibilityAuto(int n) {
    }

    default public boolean isBluetoothVisibilityLimited(int n) {
    }

    default public boolean isBluetoothVisibilityOff(int n) {
    }

    default public boolean isBluetoothVisibilityOn(int n) {
    }

    default public boolean isBwsNo(int n) {
    }

    default public boolean isBwsRestricted(int n) {
    }

    default public boolean isBwsRestrictedUnrestricted(int n) {
    }

    default public boolean isBwsUnrestricted(int n) {
    }

    default public boolean isCarBrandAudi(int n) {
    }

    default public boolean isCarBrandBentley(int n) {
    }

    default public boolean isCarBrandNoBrand(int n) {
    }

    default public boolean isCarBrandSeat(int n) {
    }

    default public boolean isCarBrandSkoda(int n) {
    }

    default public boolean isCarBrandVw(int n) {
    }

    default public boolean isCarBrandVwNfz(int n) {
    }

    default public boolean isCarClassA(int n) {
    }

    default public boolean isCarClassA0(int n) {
    }

    default public boolean isCarClassA00(int n) {
    }

    default public boolean isCarClassA000(int n) {
    }

    default public boolean isCarClassB(int n) {
    }

    default public boolean isCarClassC(int n) {
    }

    default public boolean isCarClassD(int n) {
    }

    default public boolean isCarClassEMinus(int n) {
    }

    default public boolean isCarClassEPlus(int n) {
    }

    default public boolean isCarClassOthers(int n) {
    }

    default public boolean isCarDerivateCabrioRoadsterSpiderTarga(int n) {
    }

    default public boolean isCarDerivateCoupe(int n) {
    }

    default public boolean isCarDerivateFliessheckSportsback(int n) {
    }

    default public boolean isCarDerivateKombi(int n) {
    }

    default public boolean isCarDerivateKurzheck(int n) {
    }

    default public boolean isCarDerivatePickUp(int n) {
    }

    default public boolean isCarDerivateRaumkonzept(int n) {
    }

    default public boolean isCarDerivateSonstige(int n) {
    }

    default public boolean isCarDerivateStufenheck(int n) {
    }

    default public boolean isCarDerivateSupplementAlternAntrieb(int n) {
    }

    default public boolean isCarDerivateSupplementAufbauDachvar(int n) {
    }

    default public boolean isCarDerivateSupplementCrossAllroad(int n) {
    }

    default public boolean isCarDerivateSupplementGeaendertFrontHeck(int n) {
    }

    default public boolean isCarDerivateSupplementKurzerRadstand(int n) {
    }

    default public boolean isCarDerivateSupplementLangerRadstand(int n) {
    }

    default public boolean isCarDerivateSupplementLeistungsvari2(int n) {
    }

    default public boolean isCarDerivateSupplementLeistungvari1(int n) {
    }

    default public boolean isCarDerivateSupplementSonst(int n) {
    }

    default public boolean isCarDerivateSupplementSonstige(int n) {
    }

    default public boolean isCarDerivateSuv(int n) {
    }

    default public boolean isCountryAsiaPacific(int n) {
    }

    default public boolean isCountryAustralia(int n) {
    }

    default public boolean isCountryCentralAsia(int n) {
    }

    default public boolean isCountryChina(int n) {
    }

    default public boolean isCountryEu(int n) {
    }

    default public boolean isCountryIndia(int n) {
    }

    default public boolean isCountryIsrael(int n) {
    }

    default public boolean isCountryJapan(int n) {
    }

    default public boolean isCountryKorea(int n) {
    }

    default public boolean isCountryMeast(int n) {
    }

    default public boolean isCountryMsa(int n) {
    }

    default public boolean isCountryNar(int n) {
    }

    default public boolean isCountryNeast(int n) {
    }

    default public boolean isCountryNmAfrica(int n) {
    }

    default public boolean isCountryNoCountry(int n) {
    }

    default public boolean isCountrySouthAfrika(int n) {
    }

    default public boolean isDashboardCommunicationBap(int n) {
    }

    default public boolean isDashboardCommunicationDdp2(int n) {
    }

    default public boolean isDashboardGraphicVariantCan(int n) {
    }

    default public boolean isDashboardGraphicVariantMost(int n) {
    }

    default public boolean isHdAntennaAmFm(int n) {
    }

    default public boolean isHdAntennaFm(int n) {
    }

    default public boolean isHdAntennaMrc(int n) {
    }

    default public boolean isHdAntennaSwitching(int n) {
    }

    default public boolean isHdAntennaTestMode(int n) {
    }

    default public boolean isHdRadioActivationActive(int n) {
    }

    default public boolean isHdRadioActivationNotActive(int n) {
    }

    default public boolean isKombiTrackStationInfoLongInfo(int n) {
    }

    default public boolean isKombiTrackStationInfoNotAvailable(int n) {
    }

    default public boolean isKombiTrackStationInfoShortInfo(int n) {
    }

    default public boolean isScreeningsNoScreen(int n) {
    }

    default public boolean isSkinningNoSkinning(int n) {
    }

    default public boolean isSoundSystemExtern(int n) {
    }

    default public boolean isSoundSystemExternBap(int n) {
    }

    default public boolean isSoundSystemIntern(int n) {
    }

    default public boolean isSoundSystemInternalIndividual(int n) {
    }

    default public boolean isSoundSystemNoAlloc(int n) {
    }

    default public boolean isSuspensionArmSideLeft(int n) {
    }

    default public boolean isSuspensionArmSideRight(int n) {
    }

    default public boolean isUsbCharge(int n) {
    }

    default public boolean isUsbFull(int n) {
    }

    default public boolean isUsbOff(int n) {
    }

    default public boolean isUsbUsbIpod(int n) {
    }

    default public boolean isWheelDriveAll(int n) {
    }

    default public boolean isWheelDriveFront(int n) {
    }

    default public boolean isWheelDriveRear(int n) {
    }
}

