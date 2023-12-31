/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.light;

public interface ASLCarLightSetter {
    public static final int SET_COMING_LEAVING_HOME_DURATION;
    public static final int SET_COMING_LEAVING_HOME_DURATION__P0_DURATION__INT;
    public static final int SET_COMING_LEAVING_HOME_DURATION__P1_SOURCE__INT;
    public static final int SET_COMING_LEAVING_HOME_DURATION__SOURCE__C0_COMING_HOME;
    public static final int SET_COMING_LEAVING_HOME_DURATION__SOURCE__C1_LEAVING_HOME;
    public static final int DE_INCREASE_COMING_LEAVING_HOME_DURATION;
    public static final int DE_INCREASE_COMING_LEAVING_HOME_DURATION__P0_SOURCE__INT;
    public static final int DE_INCREASE_COMING_LEAVING_HOME_DURATION__SOURCE__C0_COMING_HOME;
    public static final int DE_INCREASE_COMING_LEAVING_HOME_DURATION__SOURCE__C1_LEAVING_HOME;
    public static final int DE_INCREASE_COMING_LEAVING_HOME_DURATION__P1_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_COMING_LEAVING_HOME_DURATION__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_COMING_LEAVING_HOME_DURATION__FUNCTION__C1_INCREASE;
    public static final int TOGGLE_COMFORT_BLINKING;
    public static final int SET_TOURIST_LIGHT;
    public static final int SET_TOURIST_LIGHT__P0_STATUS__INT;
    public static final int SET_TOURIST_LIGHT__STATUS__C0_RIGHT;
    public static final int SET_TOURIST_LIGHT__STATUS__C1_LEFT;
    public static final int SET_AMBIENCE_LIGHT_SETTINGS;
    public static final int SET_AMBIENCE_LIGHT_SETTINGS__P0_BRIGHTNESS__INT;
    public static final int SET_AMBIENCE_LIGHT_SETTINGS__P1_SOURCE__INT;
    public static final int SET_AMBIENCE_LIGHT_SETTINGS__SOURCE__C0_STANDARDLIGHT;
    public static final int SET_AMBIENCE_LIGHT_SETTINGS__SOURCE__C1_FOOTLIGHT;
    public static final int DE_INCREASE_AMBIENCE_LIGHT_SETTINGS;
    public static final int DE_INCREASE_AMBIENCE_LIGHT_SETTINGS__P0_SOURCE__INT;
    public static final int DE_INCREASE_AMBIENCE_LIGHT_SETTINGS__SOURCE__C0_STANDARDLIGHT;
    public static final int DE_INCREASE_AMBIENCE_LIGHT_SETTINGS__SOURCE__C1_FOOTLIGHT;
    public static final int DE_INCREASE_AMBIENCE_LIGHT_SETTINGS__P1_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_AMBIENCE_LIGHT_SETTINGS__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_AMBIENCE_LIGHT_SETTINGS__FUNCTION__C1_INCREASE;
    public static final int TOGGLE_DAY_DRIVING_LIGHT;
    public static final int TOGGLE_ASF;
    public static final int TOGGLE_AUTO_RAIN_LIGHT;
    public static final int DEC_INCREASE_HEADLAMP_LEVELING;
    public static final int DEC_INCREASE_HEADLAMP_LEVELING__P0_FUNCTION__BOOLEAN;
    public static final boolean DEC_INCREASE_HEADLAMP_LEVELING__FUNCTION__C0_DECREASE;
    public static final boolean DEC_INCREASE_HEADLAMP_LEVELING__FUNCTION__C1_INCREASE;
    public static final int SET_HEADLAMP_LEVELING;
    public static final int SET_HEADLAMP_LEVELING__P0_VALUE__INT;
    public static final int SET_AUTO_LIGHT_SENSITIVITY;
    public static final int SET_AUTO_LIGHT_SENSITIVITY__P0_LEVEL__INT;
    public static final int SET_AUTO_LIGHT_SENSITIVITY__LEVEL__C0_EARLY;
    public static final int SET_AUTO_LIGHT_SENSITIVITY__LEVEL__C1_MEDIUM;
    public static final int SET_AUTO_LIGHT_SENSITIVITY__LEVEL__C2_LATE;
    public static final int SET_INSTRUMENT_PANEL_LIGHTING;
    public static final int SET_INSTRUMENT_PANEL_LIGHTING__P0_VALUE__INT;
    public static final int SET_CENTER_CONSOLE_LIGHTING;
    public static final int SET_CENTER_CONSOLE_LIGHTING__P0_VALUE__INT;
    public static final int DE_INCREASE_INSTRUMENT_PANEL_LIGHTING;
    public static final int DE_INCREASE_INSTRUMENT_PANEL_LIGHTING__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_INSTRUMENT_PANEL_LIGHTING__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_INSTRUMENT_PANEL_LIGHTING__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_CENTER_CONSOLE_LIGHTING;
    public static final int DE_INCREASE_CENTER_CONSOLE_LIGHTING__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_CENTER_CONSOLE_LIGHTING__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_CENTER_CONSOLE_LIGHTING__FUNCTION__C1_INCREASE;
    public static final int TOGGLE_MDF;
    public static final int SET_COCKPIT_LIGHT;
    public static final int SET_COCKPIT_LIGHT__P0_BRIGHTNESS__INT;
    public static final int DE_INCREASE_COCKPIT_LIGHT;
    public static final int DE_INCREASE_COCKPIT_LIGHT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_COCKPIT_LIGHT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_COCKPIT_LIGHT__FUNCTION__C1_INCREASE;
    public static final int SET_DOORS_LIGHT;
    public static final int SET_DOORS_LIGHT__P0_BRIGHTNESS__INT;
    public static final int DE_INCREASE_DOORS_LIGHT;
    public static final int DE_INCREASE_DOORS_LIGHT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_DOORS_LIGHT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_DOORS_LIGHT__FUNCTION__C1_INCREASE;
    public static final int SET_FOOTSPACE_LIGHT;
    public static final int SET_FOOTSPACE_LIGHT__P0_BRIGHTNESS__INT;
    public static final int DE_INCREASE_FOOTSPACE_LIGHT;
    public static final int DE_INCREASE_FOOTSPACE_LIGHT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_FOOTSPACE_LIGHT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_FOOTSPACE_LIGHT__FUNCTION__C1_INCREASE;
    public static final int SET_ROOF_LIGHT;
    public static final int SET_ROOF_LIGHT__P0_BRIGHTNESS__INT;
    public static final int SET_FOOTWELL_FRONT_REAR;
    public static final int SET_FOOTWELL_FRONT_REAR__P0_BRIGHTNESS__INT;
    public static final int SET_FOOTWELL_REAR;
    public static final int SET_FOOTWELL_REAR__P0_BRIGHTNESS__INT;
    public static final int SET_DOORS_FRONT_REAR;
    public static final int SET_DOORS_FRONT_REAR__P0_BRIGHTNESS__INT;
    public static final int SET_NOT_DOORS_FOOTWELL_REAR;
    public static final int SET_NOT_DOORS_FOOTWELL_REAR__P0_BRIGHTNESS__INT;
    public static final int SET_ROOF_FRONT_REAR;
    public static final int SET_ROOF_FRONT_REAR__P0_BRIGHTNESS__INT;
    public static final int SET_ROOF_REAR;
    public static final int SET_ROOF_REAR__P0_BRIGHTNESS__INT;
    public static final int SET_FRONT;
    public static final int SET_FRONT__P0_BRIGHTNESS__INT;
    public static final int DE_INCREASE_ROOF_LIGHT;
    public static final int DE_INCREASE_ROOF_LIGHT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_ROOF_LIGHT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_ROOF_LIGHT__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_FOOTWEEL_FRONT_REAR_LIGHT;
    public static final int DE_INCREASE_FOOTWEEL_FRONT_REAR_LIGHT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_FOOTWEEL_FRONT_REAR_LIGHT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_FOOTWEEL_FRONT_REAR_LIGHT__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_FOOTWELL_REAR;
    public static final int DE_INCREASE_FOOTWELL_REAR__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_FOOTWELL_REAR__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_FOOTWELL_REAR__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_DOORS_FRONT_REAR;
    public static final int DE_INCREASE_DOORS_FRONT_REAR__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_DOORS_FRONT_REAR__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_DOORS_FRONT_REAR__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_NOT_DOORS_FOOTWELL_REAR;
    public static final int DE_INCREASE_NOT_DOORS_FOOTWELL_REAR__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_NOT_DOORS_FOOTWELL_REAR__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_NOT_DOORS_FOOTWELL_REAR__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_ROOF_FRONT_REAR;
    public static final int DE_INCREASE_ROOF_FRONT_REAR__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_ROOF_FRONT_REAR__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_ROOF_FRONT_REAR__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_ROOF_REAR;
    public static final int DE_INCREASE_ROOF_REAR__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_ROOF_REAR__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_ROOF_REAR__FUNCTION__C1_INCREASE;
    public static final int DE_INCREASE_FRONT;
    public static final int DE_INCREASE_FRONT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_FRONT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_FRONT__FUNCTION__C1_INCREASE;
    public static final int SET_ALL_LIGHT;
    public static final int SET_ALL_LIGHT__P0_BRIGHTNESS__INT;
    public static final int DE_INCREASE_ALL_LIGHT;
    public static final int DE_INCREASE_ALL_LIGHT__P0_FUNCTION__BOOLEAN;
    public static final boolean DE_INCREASE_ALL_LIGHT__FUNCTION__C0_DECREASE;
    public static final boolean DE_INCREASE_ALL_LIGHT__FUNCTION__C1_INCREASE;
    public static final int SET_LIGHT_COLOR;
    public static final int SET_LIGHT_COLOR__P0_FUNCTION__INT;
    public static final int SET_LIGHT_COLOR__FUNCTION__C0_OFF;
    public static final int SET_LIGHT_COLOR__FUNCTION__C1_WARM_WHITE;
    public static final int SET_LIGHT_COLOR__FUNCTION__C2_COOL_WHITE;
    public static final int SET_LIGHT_COLOR__FUNCTION__C3_RED;
    public static final int SET_LIGHT_COLOR__FUNCTION__C4_ORANGE;
    public static final int SET_LIGHT_COLOR__FUNCTION__C5_BLUE;
    public static final int SET_LIGHT_COLOR__FUNCTION__C6_CYAN;
    public static final int TOGGLE_HEAD_LIGHT_ASSIST;
    public static final int SET_AMBIANCE_LIGHT_COLOR;
    public static final int SET_AMBIANCE_LIGHT_COLOR__P0_COLOR__INT;
    public static final int SET_AMBIANCE_LIGHT_STATE;
    public static final int SET_AMBIANCE_LIGHT_STATE__P0_STATE__BOOLEAN;
    public static final boolean SET_AMBIANCE_LIGHT_STATE__STATE__C0_ON;
    public static final boolean SET_AMBIANCE_LIGHT_STATE__STATE__C1_OFF;
    public static final int SET_AMBIANCE_LIGHT_STATE__1;
    public static final int SET_AMBIANCE_LIGHT_STATE__1__P0_STATE__BOOLEAN;
    public static final boolean SET_AMBIANCE_LIGHT_STATE__1__STATE__C0_ON;
    public static final boolean SET_AMBIANCE_LIGHT_STATE__1__STATE__C1_OFF;
    public static final int SET_AMBIANCE_LIGHT_STATE__2;
    public static final int SET_AMBIANCE_LIGHT_STATE__2__P0_STATE__INT;
    public static final int SET_AMBIANCE_LIGHT_STATE__2__STATE__C0_OFF;
    public static final int SET_AMBIANCE_LIGHT_STATE__2__STATE__C1_AUTO;
    public static final int SET_AMBIANCE_LIGHT_STATE__2__STATE__C2_MANUAL;
    public static final int SET_TURN_INDICATOR_REPEAT_MLB;
    public static final int SET_TURN_INDICATOR_REPEAT_MLB__P0_STATE__BOOLEAN;
    public static final boolean SET_TURN_INDICATOR_REPEAT_MLB__STATE__C0_INACTIVE;
    public static final boolean SET_TURN_INDICATOR_REPEAT_MLB__STATE__C1_ACTIVE;
}

