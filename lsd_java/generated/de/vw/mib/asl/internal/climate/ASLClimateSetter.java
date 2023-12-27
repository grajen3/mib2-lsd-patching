/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climate;

public interface ASLClimateSetter {
    public static final int SET_STEERING_WHEEL_HEATER_VALUE;
    public static final int SET_STEERING_WHEEL_HEATER_VALUE__P0_VALUE__INT;
    public static final int SET_STEERING_WHEEL_HEATER_VALUE__VALUE__C0_LOW;
    public static final int SET_STEERING_WHEEL_HEATER_VALUE__VALUE__C1_MID;
    public static final int SET_STEERING_WHEEL_HEATER_VALUE__VALUE__C2_HIGH;
    public static final int DECREASE_TEMPERATURE_REAR;
    public static final int INCREASE_TEMPERATURE_REAR;
    public static final int MODIFY_TEMPERATURE;
    public static final int MODIFY_TEMPERATURE__P0_MODE__INT;
    public static final int MODIFY_TEMPERATURE__MODE__C0_INCREASE;
    public static final int MODIFY_TEMPERATURE__MODE__C1_DECREASE;
    public static final int MODIFY_TEMPERATURE__P1_CLIMATEZONE__INT;
    public static final int MODIFY_TEMPERATURE__CLIMATEZONE__C0_FRONTLEFT;
    public static final int MODIFY_TEMPERATURE__CLIMATEZONE__C1_FRONTRIGHT;
    public static final int MODIFY_TEMPERATURE__CLIMATEZONE__C2_FOND;
    public static final int DECREASE_AIRFLOW_RATE_REAR;
    public static final int INCREASE_AIRFLOW_RATE_REAR;
    public static final int TOGGLE_BODY_REAR;
    public static final int TOGGLE_FOOTWELL_REAR;
    public static final int SET_SELECTED_PARK_HEATING_TIMER_SLOT;
    public static final int SET_SELECTED_PARK_HEATING_TIMER_SLOT__P0_TIMERSLOT__INT;
    public static final int SET_SELECTED_PARK_HEATING_TIMER_SLOT__TIMERSLOT__C0_NONE;
    public static final int SET_SELECTED_PARK_HEATING_TIMER_SLOT__TIMERSLOT__C1_SLOT_0;
    public static final int SET_SELECTED_PARK_HEATING_TIMER_SLOT__TIMERSLOT__C2_SLOT_1;
    public static final int SET_SELECTED_PARK_HEATING_TIMER_SLOT__TIMERSLOT__C3_SLOT_2;
    public static final int CHANGE_PARK_HEATING_MANUAL_RUNNING_TIME;
    public static final int CHANGE_PARK_HEATING_MANUAL_RUNNING_TIME__P0_PARKHEATINGRUNNINGTIME__INT;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__P0_TIMERSLOT__INT;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__TIMERSLOT__C0_SLOT_0;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__TIMERSLOT__C1_SLOT_1;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__TIMERSLOT__C2_SLOT_2;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__P1_GRANULARITY__INT;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C0_HOUR;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C1_MINUTE;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C2_DAY;
    public static final int DECREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C3_AMPM;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__P0_TIMERSLOT__INT;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__TIMERSLOT__C0_SLOT_0;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__TIMERSLOT__C1_SLOT_1;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__TIMERSLOT__C2_SLOT_2;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__P1_GRANULARITY__INT;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C0_HOUR;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C1_MINUTE;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C2_DAY;
    public static final int INCREASE_PARK_HEATING_NEXT_START_TIME__GRANULARITY__C3_AMPM;
    public static final int TOGGLE_AUTO_AIR_CIRCULATION;
    public static final int TOGGLE_AUTO_WINDOW_HEATER;
    public static final int TOGGLE_COUPLING_SEAT_HEATER_WITH_STEERING_WHEEL_HEATER;
    public static final int TOGGLE_SYNCHRONISATION;
    public static final int TOGGLE_PURE_AIR;
    public static final int TOGGLE_FRAGRANCE;
    public static final int TOGGLE_IONISATOR;
    public static final int SET_AUTO_AIR_VALUE;
    public static final int SET_AUTO_AIR_VALUE__P0_VALUE__INT;
    public static final int SET_AUTO_AIR_VALUE__VALUE__C0_LOW;
    public static final int SET_AUTO_AIR_VALUE__VALUE__C1_MEDIUM;
    public static final int SET_AUTO_AIR_VALUE__VALUE__C2_HIGH;
    public static final int SET_HEAT_COOL_TEMP_BORDER;
    public static final int SET_HEAT_COOL_TEMP_BORDER__P0_VALUE__INT;
    public static final int TOGGLE_AUTO_AUXILIARY_HEATER;
    public static final int TOGGLE_REST;
    public static final int TOGGLE_STEERING_WHEEL_HEATER;
    public static final int TOGGLE_WINDOW_HEATER;
    public static final int SWITCH_CLIMATE_SYSTEM_OFF;
    public static final int SWITCH_CLIMATE_SYSTEM_ON;
    public static final int SET_SEAT_HEATER_VALUE_LEFT;
    public static final int SET_SEAT_HEATER_VALUE_LEFT__P0_VALUE__INT;
    public static final int SET_SEAT_HEATER_VALUE_RIGHT;
    public static final int SET_SEAT_HEATER_VALUE_RIGHT__P0_VALUE__INT;
    public static final int SET_SEAT_VENTILATION_VALUE_LEFT;
    public static final int SET_SEAT_VENTILATION_VALUE_LEFT__P0_VALUE__INT;
    public static final int SET_SEAT_VENTILATION_VALUE_RIGHT;
    public static final int SET_SEAT_VENTILATION_VALUE_RIGHT__P0_VALUE__INT;
    public static final int SWITCH_PARKHEATING_ACTIVITY_OFF;
    public static final int TOGGLE_PARKHEATING_MODUS;
    public static final int EXIT_CLIMATE_CONTEXT;
    public static final int ENTER_CLIMATE_CONTEXT;
    public static final int ENTER_CLIMATE_DESKTOP;
    public static final int EXIT_CLIMATE_DESKTOP;
    public static final int EXIT_PARKHEATING;
    public static final int START_CLIMATE_TIMER;
    public static final int START_CLIMATE_TIMER__P0_VALUE__INT;
    public static final int STOP_CLIMATE_TIMER;
    public static final int START_SEAT_HEATER_POPUP_LEFT_TIMER;
    public static final int START_SEAT_HEATER_POPUP_LEFT_TIMER__P0_VALUE__INT;
    public static final int STOP_SEAT_HEATER_POPUP_LEFT_TIMER;
    public static final int START_SEAT_HEATER_POPUP_RIGHT_TIMER;
    public static final int START_SEAT_HEATER_POPUP_RIGHT_TIMER__P0_VALUE__INT;
    public static final int STOP_SEAT_HEATER_POPUP_RIGHT_TIMER;
    public static final int APPLY_PARKHEATING_START_TIMES_WITH_PARAM;
    public static final int APPLY_PARKHEATING_START_TIMES_WITH_PARAM__P0_TIMERSLOT__INT;
    public static final int APPLY_PARKHEATING_START_TIMES_WITH_PARAM__TIMERSLOT__C0_NONE;
    public static final int APPLY_PARKHEATING_START_TIMES_WITH_PARAM__TIMERSLOT__C1_SLOT_0;
    public static final int APPLY_PARKHEATING_START_TIMES_WITH_PARAM__TIMERSLOT__C2_SLOT_1;
    public static final int APPLY_PARKHEATING_START_TIMES_WITH_PARAM__TIMERSLOT__C3_SLOT_2;
    public static final int START_CLIMATE_TEMP_EDIT_TIMER;
    public static final int START_CLIMATE_TEMP_EDIT_TIMER__P0_VALUE__INT;
    public static final int STOP_CLIMATE_TEMP_EDIT_TIMER;
    public static final int CANCEL_CLIMATE;
    public static final int SEATHEATING_LEFT_POPUP_CLOSED;
    public static final int SEATHEATING_RIGHT_POPUP_CLOSED;
    public static final int TOGGLE_REAR_LOCK;
    public static final int TOGGLE_AUTO_ACTIVATION_STEERING_WHEEL_HEATER;
    public static final int SET_CLIMATE_PRESET;
    public static final int SET_CLIMATE_PRESET__P0_CLIMATEPRESETPOSITION__INT;
    public static final int SET_CLIMATE_PRESET__CLIMATEPRESETPOSITION__C0_FRONT;
    public static final int SET_CLIMATE_PRESET__CLIMATEPRESETPOSITION__C1_REAR;
    public static final int SET_CLIMATE_PRESET__P1_CLIMATEPRESETSELECTION__INT;
    public static final int SET_CLIMATE_PRESET__CLIMATEPRESETSELECTION__C0_AUTO;
    public static final int SET_CLIMATE_PRESET__CLIMATEPRESETSELECTION__C1_MAXAC;
    public static final int SET_CLIMATE_PRESET__CLIMATEPRESETSELECTION__C2_DEFROST;
    public static final int SET_CLIMATE_PRESET__CLIMATEPRESETSELECTION__C3_MANUAL;
    public static final int SET_CLIMATE_PROFILE2;
    public static final int SET_CLIMATE_PROFILE2__P0_CLIMATEPROFILEPOSITION__INT;
    public static final int SET_CLIMATE_PROFILE2__CLIMATEPROFILEPOSITION__C0_FRONT;
    public static final int SET_CLIMATE_PROFILE2__CLIMATEPROFILEPOSITION__C1_REAR;
    public static final int SET_CLIMATE_PROFILE2__P1_CLIMATEPROFILESELECTION__INT;
    public static final int SET_CLIMATE_PROFILE2__CLIMATEPROFILESELECTION__C0_SOFT;
    public static final int SET_CLIMATE_PROFILE2__CLIMATEPROFILESELECTION__C1_MEDIUM;
    public static final int SET_CLIMATE_PROFILE2__CLIMATEPROFILESELECTION__C2_INTENSIVE;
    public static final int SET_CLIMATE_TEMPERATURE;
    public static final int SET_CLIMATE_TEMPERATURE__P0_CLIMATETEMPERATUREBUTTONPOSITION__INT;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREBUTTONPOSITION__C0_FRONT_LEFT;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREBUTTONPOSITION__C1_FRONT_RIGHT;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREBUTTONPOSITION__C2_REAR_LEFT;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREBUTTONPOSITION__C3_REAR_CENTRAL;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREBUTTONPOSITION__C4_REAR_RIGHT;
    public static final int SET_CLIMATE_TEMPERATURE__P1_CLIMATETEMPERATUREINCREASE__INT;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREINCREASE__C0_DECREASE;
    public static final int SET_CLIMATE_TEMPERATURE__CLIMATETEMPERATUREINCREASE__C1_INCREASE;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_BODY;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_BODY__P0_FLYINGWINDOWPOSITION__INT;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_BODY__FLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_BODY__FLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_FOOTWELL;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_FOOTWELL__P0_FLYINGWINDOWPOSITION__INT;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_FOOTWELL__FLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_FOOTWELL__FLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_UP;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_UP__P0_FLYINGWINDOWPOSITION__INT;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_UP__FLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIRCON_AIR_DISTRIBUTION_UP__FLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIRCON_AIR_CIRCULATION_MAN;
    public static final int SET_AIRCON_AIR_CIRCULATION_MAN2;
    public static final int SET_AIRCON_AIR_CIRCULATION_MAN2__P0_FLYINGWINDOWPOSITION__INT;
    public static final int SET_AIRCON_AIR_CIRCULATION_MAN2__FLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIRCON_AIR_CIRCULATION_MAN2__FLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIRCON_AC;
    public static final int SET_AIRCON_AC2;
    public static final int SET_AIRCON_AC2__P0_FLYINGWINDOWPOSITION__INT;
    public static final int SET_AIRCON_AC2__FLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIRCON_AC2__FLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIRCON_SYSTEM_ON_OFF_REAR;
    public static final int SET_AIRCON_SYSTEM_ON_OFF_REAR2;
    public static final int SET_AIRCON_SYSTEM_ON_OFF_REAR2__P0_FLYINGWINDOWPOSITION__INT;
    public static final int SET_AIRCON_SYSTEM_ON_OFF_REAR2__FLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIRCON_SYSTEM_ON_OFF_REAR2__FLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__P0_SETFLYINGWINDOWPOSITION__INT;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__SETFLYINGWINDOWPOSITION__C0_FRONT;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__SETFLYINGWINDOWPOSITION__C1_REAR;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__P1_SETAIRDISTRIBUTIONSLIDERCHANGEMODE__INT;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__SETAIRDISTRIBUTIONSLIDERCHANGEMODE__C0_VALUE;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__SETAIRDISTRIBUTIONSLIDERCHANGEMODE__C1_DECREASE;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__SETAIRDISTRIBUTIONSLIDERCHANGEMODE__C2_INCREASE;
    public static final int SET_AIR_DISTRIBUTION_SLIDER2__P2_SETAIRDISTRIBUTIONSLIDERVALUE__INT;
    public static final int TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE;
    public static final int TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE__P0_VALUE__INT;
    public static final int TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE__VALUE__C0_LOW;
    public static final int TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE__VALUE__C1_MID;
    public static final int TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE__VALUE__C2_HIGH;
    public static final int AIR_DISTRIBUTION_POPUP_CLOSED;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_WINDOW;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_WINDOW__P0_VALUE__INT;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_WINDOW_FEET;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_WINDOW_FEET__P0_VALUE__INT;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_FEET;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_FEET__P0_VALUE__INT;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_BODY;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_BODY__P0_VALUE__INT;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_BODY_FEET;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_BODY_FEET__P0_VALUE__INT;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_WINDOW_BODY_FEET;
    public static final int SET_AIR_DISTRIBUTION_COMBINED_WINDOW_BODY_FEET__P0_VALUE__INT;
    public static final int TOGGLE_MAX_AC;
    public static final int TOGGLE_AIR_CIRCULATION_MAN;
    public static final int TOGGLE_AIRCON_SYSTEM_ON_OFF_REAR;
    public static final int TOGGLE_AIRCON_AC;
    public static final int TOGGLE_IMMEDIATE_HEATING;
    public static final int CLOSE_TEMPERATURE_POPUP;
}

