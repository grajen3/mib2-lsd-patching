/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.climatebar;

public interface ASLClimateBarPropertyManager {
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_ENABLE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_ENABLE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_ENABLE__C0_DISABLED;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_ENABLE__C1_ENABLED;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_VALUE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_VALUE__MIN_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_VALUE__MAX_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_VALUE__STEP_SIZE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C0_STEPS;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C1_CELSIUS;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C2_FAHRENHEIT;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C3_LOW;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C4_HIGH;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C5_ECO;
    public static final int CLIMATE_BAR_TEMPERATURE_MODES__CLIMATE_BAR_TEMPERATURE_MODE_UNIT__C6_OFF;
    public static final int CLIMATE_BAR_TEMPERATURE__CLIMATE_BAR_TEMPERATURE_ENABLE_VECTOR;
    public static final int CLIMATE_BAR_TEMPERATURE__CLIMATE_BAR_TEMPERATURE_ENABLE_VECTOR__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE__CLIMATE_BAR_TEMPERATURE_VALUE_VECTOR;
    public static final int CLIMATE_BAR_TEMPERATURE__CLIMATE_BAR_TEMPERATURE_VALUE_VECTOR__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE__CLIMATE_BAR_TEMPERATURE_UNIT_VECTOR;
    public static final int CLIMATE_BAR_TEMPERATURE__CLIMATE_BAR_TEMPERATURE_UNIT_VECTOR__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_ASL_AVAILABLE;
    public static final boolean CLIMATE_BAR_ASL_AVAILABLE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_CLAMP15ON;
    public static final boolean CLIMATE_BAR_CLAMP15ON__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SYSTEM_ON;
    public static final boolean CLIMATE_BAR_SYSTEM_ON__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SYSTEM_OPERATIONAL;
    public static final boolean CLIMATE_BAR_SYSTEM_OPERATIONAL__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_ZONE;
    public static final int CLIMATE_BAR_ZONE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_ZONE__C0_FRONTLEFT;
    public static final int CLIMATE_BAR_ZONE__C1_FRONTRIGHT;
    public static final int CLIMATE_BAR_ZONE__C2_REARLEFT;
    public static final int CLIMATE_BAR_ZONE__C3_REARRIGHT;
    public static final int CLIMATE_BAR_AUTO_EXISTENCE;
    public static final boolean[] CLIMATE_BAR_AUTO_EXISTENCE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_AUTO_ACTIVE;
    public static final boolean[] CLIMATE_BAR_AUTO_ACTIVE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PROFILE_EXISTENCE;
    public static final boolean[] CLIMATE_BAR_PROFILE_EXISTENCE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PROFILE_MODE;
    public static final int CLIMATE_BAR_PROFILE_MODE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PROFILE_MODE__C0_SOFT;
    public static final int CLIMATE_BAR_PROFILE_MODE__C1_MEDIUM;
    public static final int CLIMATE_BAR_PROFILE_MODE__C2_INTENSIVE;
    public static final int CLIMATE_BAR_PROFILE_MODE_VECTOR;
    public static final int CLIMATE_BAR_PROFILE_MODE_VECTOR__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_BUTTON_EXISTENCE;
    public static final boolean[] CLIMATE_BAR_TEMPERATURE_BUTTON_EXISTENCE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MINIMUM;
    public static final int CLIMATE_BAR_TEMPERATURE_MINIMUM__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MINIMUM__MIN_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MINIMUM__MAX_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MINIMUM__STEP_SIZE;
    public static final int CLIMATE_BAR_TEMPERATURE_MAXIMUM;
    public static final int CLIMATE_BAR_TEMPERATURE_MAXIMUM__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MAXIMUM__MIN_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MAXIMUM__MAX_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_MAXIMUM__STEP_SIZE;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE_UNIT_CELSIUS;
    public static final boolean CLIMATE_BAR_TEMPERATURE_RANGE_UNIT_CELSIUS__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE_CELSIUS;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE_CELSIUS__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE_FAHRENHEIT;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE_FAHRENHEIT__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE;
    public static final int CLIMATE_BAR_TEMPERATURE_RANGE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_TEMPERATURE_ECO;
    public static final boolean CLIMATE_BAR_TEMPERATURE_ECO__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SEAT_VENTILATION_EXISTENCE;
    public static final boolean[] CLIMATE_BAR_SEAT_VENTILATION_EXISTENCE__DEFAULT_VALUE;
    public static final int CLIMATE_SEAT_VENTILATION_VALUE_VECTOR;
    public static final int CLIMATE_SEAT_VENTILATION_VALUE_VECTOR__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SEAT_HEATER_EXISTENCE;
    public static final boolean[] CLIMATE_BAR_SEAT_HEATER_EXISTENCE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SEAT_HEATER_VALUE_VECTOR;
    public static final int CLIMATE_BAR_SEAT_HEATER_VALUE_VECTOR__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SEAT_MENU_EXISTENCE;
    public static final boolean[] CLIMATE_BAR_SEAT_MENU_EXISTENCE__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SEAT_MENU_OPERATIONAL;
    public static final boolean[] CLIMATE_BAR_SEAT_MENU_OPERATIONAL__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SYNCHRONISATION_EXISTENT;
    public static final boolean CLIMATE_BAR_SYNCHRONISATION_EXISTENT__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SYNCHRONISATION_OPERATIONAL;
    public static final boolean CLIMATE_BAR_SYNCHRONISATION_OPERATIONAL__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_SYNCHRONISATION_SELECTED;
    public static final boolean CLIMATE_BAR_SYNCHRONISATION_SELECTED__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PARKHEATER_IMMEDIATE_HEATING_EXISTENT;
    public static final boolean CLIMATE_BAR_PARKHEATER_IMMEDIATE_HEATING_EXISTENT__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PARKHEATER_IMMEDIATE_HEATING_OPERATIONAL;
    public static final boolean CLIMATE_BAR_PARKHEATER_IMMEDIATE_HEATING_OPERATIONAL__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PARKHEATER_IMMEDIATE_HEATING_SELECTED;
    public static final boolean CLIMATE_BAR_PARKHEATER_IMMEDIATE_HEATING_SELECTED__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PARKHEATER_RESIDUAL_HEAT_EXISTENT;
    public static final boolean CLIMATE_BAR_PARKHEATER_RESIDUAL_HEAT_EXISTENT__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PARKHEATER_RESIDUAL_HEAT_OPERATIONAL;
    public static final boolean CLIMATE_BAR_PARKHEATER_RESIDUAL_HEAT_OPERATIONAL__DEFAULT_VALUE;
    public static final int CLIMATE_BAR_PARKHEATER_RESIDUAL_HEAT_SELECTED;
    public static final boolean CLIMATE_BAR_PARKHEATER_RESIDUAL_HEAT_SELECTED__DEFAULT_VALUE;

    static {
        CLIMATE_BAR_AUTO_EXISTENCE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_AUTO_ACTIVE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_PROFILE_EXISTENCE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_TEMPERATURE_BUTTON_EXISTENCE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_SEAT_VENTILATION_EXISTENCE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_SEAT_HEATER_EXISTENCE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_SEAT_MENU_EXISTENCE__DEFAULT_VALUE = new boolean[]{true, true};
        CLIMATE_BAR_SEAT_MENU_OPERATIONAL__DEFAULT_VALUE = new boolean[]{true, true};
    }
}

