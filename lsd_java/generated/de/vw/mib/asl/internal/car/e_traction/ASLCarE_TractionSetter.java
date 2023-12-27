/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.e_traction;

public interface ASLCarE_TractionSetter {
    public static final int DELETE_PROFILE;
    public static final int DELETE_PROFILE__P0_ID__INT;
    public static final int DECREASE_DEPARTURE_TIME;
    public static final int DECREASE_DEPARTURE_TIME__P0_TIMERID__INT;
    public static final int DECREASE_DEPARTURE_TIME__P1_VALUE__INT;
    public static final int DECREASE_DEPARTURE_TIME__VALUE__C0_HOURS;
    public static final int DECREASE_DEPARTURE_TIME__VALUE__C1_MINUTES;
    public static final int DECREASE_DEPARTURE_TIME__VALUE__C2_AM_PM;
    public static final int DECREASE_PROFILE_NIGHT_RATE;
    public static final int DECREASE_PROFILE_NIGHT_RATE__P0_ID__INT;
    public static final int DECREASE_PROFILE_NIGHT_RATE__P1_TIME__BOOLEAN;
    public static final boolean DECREASE_PROFILE_NIGHT_RATE__TIME__C0_START;
    public static final boolean DECREASE_PROFILE_NIGHT_RATE__TIME__C1_END;
    public static final int DECREASE_PROFILE_NIGHT_RATE__P2_VALUE__INT;
    public static final int DECREASE_PROFILE_NIGHT_RATE__VALUE__C0_HOURS;
    public static final int DECREASE_PROFILE_NIGHT_RATE__VALUE__C1_MINUTES;
    public static final int DECREASE_PROFILE_NIGHT_RATE__VALUE__C2_AM_PM;
    public static final int INCREASE_DEPARTURE_TIME;
    public static final int INCREASE_DEPARTURE_TIME__P0_TIMERID__INT;
    public static final int INCREASE_DEPARTURE_TIME__P1_VALUE__INT;
    public static final int INCREASE_DEPARTURE_TIME__VALUE__C0_HOURS;
    public static final int INCREASE_DEPARTURE_TIME__VALUE__C1_MINUTES;
    public static final int INCREASE_DEPARTURE_TIME__VALUE__C2_AM_PM;
    public static final int INCREASE_PROFILE_NIGHT_RATE;
    public static final int INCREASE_PROFILE_NIGHT_RATE__P0_ID__INT;
    public static final int INCREASE_PROFILE_NIGHT_RATE__P1_TIME__BOOLEAN;
    public static final boolean INCREASE_PROFILE_NIGHT_RATE__TIME__C0_START;
    public static final boolean INCREASE_PROFILE_NIGHT_RATE__TIME__C1_END;
    public static final int INCREASE_PROFILE_NIGHT_RATE__P2_VALUE__INT;
    public static final int INCREASE_PROFILE_NIGHT_RATE__VALUE__C0_HOURS;
    public static final int INCREASE_PROFILE_NIGHT_RATE__VALUE__C1_MINUTES;
    public static final int INCREASE_PROFILE_NIGHT_RATE__VALUE__C2_AM_PM;
    public static final int SET_PROFILE_NAME;
    public static final int SET_PROFILE_NAME__P0_ID__INT;
    public static final int SET_PROFILE_NAME__P1_NAME__STRING;
    public static final int SET_PROFILE_MAX_CURRENT;
    public static final int SET_PROFILE_MAX_CURRENT__P0_ID__INT;
    public static final int SET_PROFILE_MAX_CURRENT__P1_VALUE__INT;
    public static final int SET_PROFILE_MAX_CURRENT__VALUE__C0_5;
    public static final int SET_PROFILE_MAX_CURRENT__VALUE__C1_10;
    public static final int SET_PROFILE_MAX_CURRENT__VALUE__C2_13;
    public static final int SET_PROFILE_MAX_CURRENT__VALUE__C3_16;
    public static final int SET_PROFILE_MAX_CURRENT__VALUE__C4_32;
    public static final int DECREASE_PROFILE_SOC;
    public static final int DECREASE_PROFILE_SOC__P0_ID__INT;
    public static final int INCREASE_PROFILE_SOC;
    public static final int INCREASE_PROFILE_SOC__P0_ID__INT;
    public static final int SET_PROFILE_SOC;
    public static final int SET_PROFILE_SOC__P0_ID__INT;
    public static final int SET_PROFILE_SOC__P1_VALUE__INT;
    public static final int SET_TIMER_PROFILE;
    public static final int SET_TIMER_PROFILE__P0_TIMERID__INT;
    public static final int SET_TIMER_PROFILE__P1_PROFILEID__INT;
    public static final int TOGGLE_PROFILE_AIR_CONDITIONING_STATE;
    public static final int TOGGLE_PROFILE_AIR_CONDITIONING_STATE__P0_ID__INT;
    public static final int TOGGLE_PROFILE_CHARGING_STATE;
    public static final int TOGGLE_PROFILE_CHARGING_STATE__P0_ID__INT;
    public static final int OPEN_RENAME_PROFILE_SPELLER;
    public static final int OPEN_RENAME_PROFILE_SPELLER__P0_ID__INT;
    public static final int TOGGLE_PROFILE_NIGHT_RATE_STATE;
    public static final int TOGGLE_PROFILE_NIGHT_RATE_STATE__P0_ID__INT;
    public static final int TOGGLE_TIMER_ACTIVATION;
    public static final int TOGGLE_TIMER_ACTIVATION__P0_TIMERID__INT;
    public static final int SET_TIMER_MODE;
    public static final int SET_TIMER_MODE__P0_TIMERID__INT;
    public static final int SET_TIMER_MODE__P1_MODE__INT;
    public static final int SET_TIMER_MODE__MODE__C0_REPEAT;
    public static final int SET_TIMER_MODE__MODE__C1_SINGLE;
    public static final int TOGGLE_TIMER_WEEKDAYS;
    public static final int TOGGLE_TIMER_WEEKDAYS__P0_TIMERID__INT;
    public static final int TOGGLE_TIMER_WEEKDAYS__P1_WEEKDAYID__INT;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C0_MO;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C1_TU;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C2_WE;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C3_TH;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C4_FR;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C5_SA;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C6_SU;
    public static final int TOGGLE_TIMER_WEEKDAYS__WEEKDAYID__C7_ALL;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__P0_TIMERID__INT;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__P1_WEEKDAYID__INT;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C0_MO;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C1_TU;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C2_WE;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C3_TH;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C4_FR;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C5_SA;
    public static final int CHOOSE_WEEKDAY_TIMER_SINGLE__WEEKDAYID__C6_SU;
    public static final int DECREASE_TIMER_WEEKDAY;
    public static final int DECREASE_TIMER_WEEKDAY__P0_TIMERID__INT;
    public static final int INCREASE_TIMER_WEEKDAY;
    public static final int INCREASE_TIMER_WEEKDAY__P0_TIMERID__INT;
    public static final int DECREASE_AIR_CONDITIONING_TEMPERATURE;
    public static final int INCREASE_AIR_CONDITIONING_TEMPERATURE;
    public static final int SET_AIR_CONDITIONING_TEMPERATURE;
    public static final int SET_AIR_CONDITIONING_TEMPERATURE__P0_VALUE__INT;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT__P0_VALUE__INT;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT__VALUE__C0_5;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT__VALUE__C1_10;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT__VALUE__C2_13;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT__VALUE__C3_16;
    public static final int SET_DIRECT_CHARGING__MAX_CURRENT__VALUE__C4_32;
    public static final int SET_DIRECT_CHARGING__CHARGING_CURRENT;
    public static final int SET_DIRECT_CHARGING__CHARGING_CURRENT__P0_VALUE__INT;
    public static final int SET_DIRECT_CHARGING__CHARGING_CURRENT__VALUE__C0_MAXIMUM;
    public static final int SET_DIRECT_CHARGING__CHARGING_CURRENT__VALUE__C1_REDUCED;
    public static final int DECREASE_MINIMUM_SOC;
    public static final int INCREASE_MINIMUM_SOC;
    public static final int SET_MINIMUM_SOC;
    public static final int SET_MINIMUM_SOC__P0_VALUE__INT;
    public static final int TOGGLE_PARKHEATER_ACTIVATION;
    public static final int TOGGLE_AIR_CONDITIONING_FROM_BATTERY;
    public static final int TOGGLE_ACTIVE_PEDAL;
    public static final int DELETE_ALL_PROFILES;
    public static final int SAVE_SETTINGS__PROFILE;
    public static final int SAVE_SETTINGS__PROFILE__P0_PROFILEID__INT;
    public static final int SAVE_SETTINGS__NIGHT_RATE;
    public static final int SAVE_SETTINGS__NIGHT_RATE__P0_PROFILEID__INT;
    public static final int SAVE_TIMER_SETTINGS;
    public static final int SPELLER_INIT;
    public static final int SPELLER_INIT__P0_INIT__STRING;
    public static final int SET_DISTANCE_BETWEEN_CHARGING;
    public static final int SET_DISTANCE_BETWEEN_CHARGING__P0_VALUE__INT;
    public static final int DECREASE_DISTANCE_BETWEEN_CHARGING;
    public static final int INCREASE_DISTANCE_BETWEEN_CHARGING;
    public static final int REFRESH_WEEK_DAYS_FOR_TIMER_SETUP;
    public static final int REFRESH_WEEK_DAYS_FOR_TIMER_SETUP__P0_TIMERID__INT;
    public static final int SET_HYBRID_MODE;
    public static final int SET_HYBRID_MODE__P0_VALUE__INT;
    public static final int SET_HYBRID_MODE__VALUE__C0_ELECTRICAL;
    public static final int SET_HYBRID_MODE__VALUE__C1_HOLD;
    public static final int SET_HYBRID_MODE__VALUE__C2_INCREASE;
    public static final int SET_HYBRID_MODE__VALUE__C3_DEPLETE;
    public static final int ENTERED_ETRAK_ENTRY_WAIT_POPUP;
    public static final int LEFT_ETRAK_ENTRY_WAIT_POPUP;
}
