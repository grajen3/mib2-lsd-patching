/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car;

public interface ASLCarPropertyManager {
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_STATE;
    public static final boolean FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_STATE__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C0_NORMAL;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C1_ERROR;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C2_IGNITION;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C3_SPEED;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C4_ENGINE;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C5_TRAILER;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C6_UNDEFINED;
    public static final int FUNCTION_AVAILABLE__FUNCTION_AVAILABLE_REASON__C7_STANDSTILL;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__DEFAULT_VALUE;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C0_DIRECTION_N;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C1_DIRECTION_NNO;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C2_DIRECTION_NO;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C3_DIRECTION_ONO;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C4_DIRECTION_O;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C5_DIRECTION_OSO;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C6_DIRECTION_SO;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C7_DIRECTION_SSO;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C8_DIRECTION_S;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C9_DIRECTION_SSW;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C10_DIRECTION_SW;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C11_DIRECTION_WSW;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C12_DIRECTION_W;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C13_DIRECTION_WNW;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C14_DIRECTION_NW;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C15_DIRECTION_NNW;
    public static final int COMPASS_INFO__COMPASS_INFO_DIRECTION__C16_DIRECTION_NOT_SUPPORTED;
    public static final int COMPASS_INFO__COMPASS_INFO_ANGLE;
    public static final int COMPASS_INFO__COMPASS_INFO_ANGLE__DEFAULT_VALUE;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_STATE;
    public static final boolean HDC_AVAILABILITY__HDC_AVAILABILITY_STATE__DEFAULT_VALUE;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__DEFAULT_VALUE;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C0_NORMAL;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C1_ERROR;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C2_IGNITION;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C3_SPEED;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C4_ENGINE;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C5_TRAILER;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C6_SOC_1;
    public static final int HDC_AVAILABILITY__HDC_AVAILABILITY_REASON__C7_SOC_2;
    public static final int VW511;
    public static final boolean VW511__DEFAULT_VALUE;
    public static final int FUNCTION_EXISTENT_STATE;
    public static final boolean[] FUNCTION_EXISTENT_STATE__DEFAULT_VALUE;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_STATE;
    public static final boolean SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_STATE__DEFAULT_VALUE;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_REASON;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_REASON__DEFAULT_VALUE;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_REASON__C0_NORMAL;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_REASON__C1_ERROR;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_REASON__C2_IGNITION;
    public static final int SYSTEM_SETUP_TIME_DATE_FUNCTION_AVAILABLE_REASON__C3_UNDEFINED;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_STATE;
    public static final boolean SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_STATE__DEFAULT_VALUE;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_REASON;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_REASON__DEFAULT_VALUE;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_REASON__C0_NORMAL;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_REASON__C1_ERROR;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_REASON__C2_IGNITION;
    public static final int SYSTEM_SETUP_UNITS_FUNCTION_AVAILABLE_REASON__C3_UNDEFINED;
    public static final int MENU_CODING_STATE;
    public static final boolean[] MENU_CODING_STATE__DEFAULT_VALUE;
    public static final int ETRAK_EXISTENT;
    public static final boolean ETRAK_EXISTENT__DEFAULT_VALUE;
    public static final int TBT_EXISTENT;
    public static final boolean TBT_EXISTENT__DEFAULT_VALUE;
    public static final int OFFROAD_EXISTENT;
    public static final boolean OFFROAD_EXISTENT__DEFAULT_VALUE;
    public static final int SPORT_EXISTENT;
    public static final boolean SPORT_EXISTENT__DEFAULT_VALUE;
    public static final int BORD_COMPUTER_EXISTENT;
    public static final boolean BORD_COMPUTER_EXISTENT__DEFAULT_VALUE;
    public static final int EXISTENT__BORD_COMPUTER_TRIP;
    public static final boolean EXISTENT__BORD_COMPUTER_TRIP__DEFAULT_VALUE;
    public static final int EXISTENT__BORD_COMPUTER_LONGTERM;
    public static final boolean EXISTENT__BORD_COMPUTER_LONGTERM__DEFAULT_VALUE;
    public static final int EXISTENT__BORD_COMPUTER_FUELCYCLE;
    public static final boolean EXISTENT__BORD_COMPUTER_FUELCYCLE__DEFAULT_VALUE;
    public static final int EXISTENT__DRIVING_SCHOOL;
    public static final boolean EXISTENT__DRIVING_SCHOOL__DEFAULT_VALUE;
    public static final int EXISTENT__ECO;
    public static final boolean EXISTENT__ECO__DEFAULT_VALUE;
    public static final int EXISTENT__VEHICLE_STATUS;
    public static final boolean EXISTENT__VEHICLE_STATUS__DEFAULT_VALUE;
    public static final int EXISTENT__VEHICLE_STATUS_MAIN;
    public static final boolean EXISTENT__VEHICLE_STATUS_MAIN__DEFAULT_VALUE;
    public static final int EXISTENT__VEHICLE_STATUS_TIRES;
    public static final boolean EXISTENT__VEHICLE_STATUS_TIRES__DEFAULT_VALUE;
    public static final int EXISTENT__COCKPIT__FPK;
    public static final boolean EXISTENT__COCKPIT__FPK__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C0_NORMAL;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C1_ERROR;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C2_IGNITION;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C3_SPEED;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C4_ENGINE;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C5_TRAILER;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C6_UNDEFINED;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C7_STANDSTILL;
    public static final int FUNCTION_AVAILABLE_REASON__RKA__TEST__C8_INIT;
    public static final int HDC_STATE;
    public static final boolean HDC_STATE__DEFAULT_VALUE;
    public static final int HDC_EXISTENCE;
    public static final boolean HDC_EXISTENCE__DEFAULT_VALUE;
    public static final int VEHICLE_MOVING;
    public static final boolean VEHICLE_MOVING__DEFAULT_VALUE;
    public static final int AIR_SUSP_LIFT_AVAILABILITY_STATE;
    public static final boolean AIR_SUSP_LIFT_AVAILABILITY_STATE__DEFAULT_VALUE;
    public static final int AIR_SUSP_LIFT_STATE;
    public static final boolean AIR_SUSP_LIFT_STATE__DEFAULT_VALUE;
    public static final int AIR_SUSP_LIFT_EXISTENCE;
    public static final boolean AIR_SUSP_LIFT_EXISTENCE__DEFAULT_VALUE;
    public static final int MIRROR_WIPER_HEADING;
    public static final int MIRROR_WIPER_HEADING__DEFAULT_VALUE;
    public static final int MIRROR_WIPER_HEADING__C0_ALL;
    public static final int MIRROR_WIPER_HEADING__C1_MIRROR;
    public static final int MIRROR_WIPER_HEADING__C2_WIPER;
    public static final int AUXILIARY_HEATER_SELECTED;
    public static final boolean AUXILIARY_HEATER_SELECTED__DEFAULT_VALUE;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__DEFAULT_VALUE;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C0_NORMAL;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C1_ERROR;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C2_IGNITION;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C3_SPEED;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C4_ENGINE;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C5_TRAILER;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C6_UNDEFINED;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C7_STANDSTILL;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C8_INIT;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C9_SOC_1;
    public static final int GLOBAL_FUNCTION_AVAILABLE_REASON__C10_SOC_2;
    public static final int NEW_CLIMATE_SETUP_ENABLED;
    public static final boolean NEW_CLIMATE_SETUP_ENABLED__DEFAULT_VALUE;
    public static final int VEHICLE_STATUS_AVAILABLE;
    public static final boolean VEHICLE_STATUS_AVAILABLE__DEFAULT_VALUE;
    public static final int AVAILABLE__ECO;
    public static final boolean AVAILABLE__ECO__DEFAULT_VALUE;
    public static final int OFFROAD_PQ_ENABLED;
    public static final boolean OFFROAD_PQ_ENABLED__DEFAULT_VALUE;
    public static final int LAST_CAR_PQ_VIEW_PERSISTENCE;
    public static final int LAST_CAR_PQ_VIEW_PERSISTENCE__DEFAULT_VALUE;
    public static final int LAST_CAR_PQ_VIEW_PERSISTENCE__C0_UNDEFINED;
    public static final int LAST_CAR_PQ_VIEW_PERSISTENCE__C1_HYBRID;
    public static final int LAST_CAR_PQ_VIEW_PERSISTENCE__C2_OFFROAD;
    public static final int LAST_MAIN_VIEW_ID;
    public static final int LAST_MAIN_VIEW_ID__DEFAULT_VALUE;
    public static final int LAST_SUB_VIEW_ID;
    public static final int LAST_SUB_VIEW_ID__DEFAULT_VALUE;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__DEFAULT_VALUE;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C0_ALL_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C1_ELECTRIC_DRIVING_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C2_DRIVE_ASSIST_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C3_PARK_ASSIST_STIINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C4_LIGHT_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C5_AMBIENCE_LIGHT_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C6_SIGHT_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C7_OPEN_CLOSE_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C8_SEATS_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C9_MFA_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C10_HUD_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C11_CLIMATE_SPL_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C12_PERSONALISATION_SETTINGS;
    public static final int FUNCTION_INDEX__FACTORY_SETTINGS__C13_TBT_SETTINGS;
    public static final int FUNCTION_EXISTENCE__FACTORY_SETTINGS;
    public static final boolean FUNCTION_EXISTENCE__FACTORY_SETTINGS__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE_REASON__FACTORY_SETTINGS;
    public static final int FUNCTION_AVAILABLE_REASON__FACTORY_SETTINGS__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABILITY__FACTORY_SETTINGS;
    public static final boolean FUNCTION_AVAILABILITY__FACTORY_SETTINGS__DEFAULT_VALUE;
    public static final int FUNCTION_INDEX__CLIMATE_SPL_FUNC;
    public static final int FUNCTION_INDEX__CLIMATE_SPL_FUNC__DEFAULT_VALUE;
    public static final int FUNCTION_INDEX__CLIMATE_SPL_FUNC__C0_SEAT_HEATING;
    public static final int FUNCTION_INDEX__CLIMATE_SPL_FUNC__C1_STEERING_WHEEL_TEMP;
    public static final int FUNCTION_INDEX__CLIMATE_SPL_FUNC__C2_STEERING_WHEEL_AUTOHEAT;
    public static final int FUNCTION_INDEX__CLIMATE_SPL_FUNC__C3_AUXILIARY_HEATING;
    public static final int FUNCTION_EXISTENCE__CLIMATE_SPL_FUNC;
    public static final boolean FUNCTION_EXISTENCE__CLIMATE_SPL_FUNC__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE_REASON__CLIMATE_SPL_FUNC;
    public static final int FUNCTION_AVAILABLE_REASON__CLIMATE_SPL_FUNC__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABILITY__CLIMATE_SPL_FUNC;
    public static final boolean FUNCTION_AVAILABILITY__CLIMATE_SPL_FUNC__DEFAULT_VALUE;
    public static final int FUNCTION_INDEX;
    public static final int FUNCTION_INDEX__DEFAULT_VALUE;
    public static final int FUNCTION_INDEX__C0_SETUP_ELECTRICALDRIVINGLOADING;
    public static final int FUNCTION_INDEX__C1_SETUP_STABILITYPROGRAM;
    public static final int FUNCTION_INDEX__C2_SETUP_TIRES;
    public static final int FUNCTION_INDEX__C3_SETUP_DRIVINGASSISTANTS;
    public static final int FUNCTION_INDEX__C4_SETUP_PARKINGASSISTANCE;
    public static final int FUNCTION_INDEX__C5_SETUP_LIGHT;
    public static final int FUNCTION_INDEX__C6_SETUP_AMBIENCELIGHT;
    public static final int FUNCTION_INDEX__C7_SETUP_TBTSETTINGS;
    public static final int FUNCTION_INDEX__C8_SETUP_SIGHT;
    public static final int FUNCTION_INDEX__C9_SETUP_OPENCLOSE;
    public static final int FUNCTION_INDEX__C10_SETUP_SEATS;
    public static final int FUNCTION_INDEX__C11_SETUP_MFA;
    public static final int FUNCTION_INDEX__C12_SETUP_HUD;
    public static final int FUNCTION_INDEX__C13_SETUP_CLIMATE;
    public static final int FUNCTION_INDEX__C14_SETUP_PERSONALISATION;
    public static final int FUNCTION_INDEX__C15_SETUP_TIMEDATE;
    public static final int FUNCTION_INDEX__C16_SETUP_UNITS;
    public static final int FUNCTION_INDEX__C17_SETUP_SERVICE;
    public static final int FUNCTION_INDEX__C18_SETUP_FACTORYSETTINGS;
    public static final int FUNCTION_EXISTENCE__CAR_SETUP;
    public static final boolean FUNCTION_EXISTENCE__CAR_SETUP__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABILITY__CAR_SETUP;
    public static final boolean FUNCTION_AVAILABILITY__CAR_SETUP__DEFAULT_VALUE;
    public static final int FUNCTION_AVAILABLE_REASON__CAR_SETUP;
    public static final int FUNCTION_AVAILABLE_REASON__CAR_SETUP__DEFAULT_VALUE;

    static {
        FUNCTION_EXISTENT_STATE__DEFAULT_VALUE = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        MENU_CODING_STATE__DEFAULT_VALUE = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    }
}

