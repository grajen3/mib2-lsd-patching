/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.pureair;

public interface PureAirConstants {
    public static final short PUREAIR_CONFIG_VERSION;
    public static final short PUREAIR_MINIMAL_CONFIG_VERSION;
    public static final String[] FILE_NAME;
    public static final int DEFAULT_ENERGYFLOW_CONFIG_LENGTH;
    public static final int OFFSET_HEADER;
    public static final int OFFSET_FEATURE_DATA;
    public static final int NUMBER_OF_FEATURE_VALUES;
    public static final int OFFSET_ENERGY_FLOW_DATA;
    public static final int OFFSET_SHIFT_DATA;
    public static final int NUMBER_OF_BACKGROUND_VALUES;
    public static final int OFFSET_BACKGROUND_DATA;
    public static final String[] FEATURE_NAMES;
    public static final String BG_CAR;
    public static final String CLEAN_FG;
    public static final String CLEAN_THRESHOLD_MASK;
    public static final String IONISATION_IONISATION_FG_FOR_ALPHA;
    public static final String IONISATION_FG_FOR_FADING;
    public static final String IONISATION_OVERLAY;
    public static final String IONISATION_ALPHA;
    public static final String IMAGE_EXT;
    public static final int NO_SUCH_VALUE;
    public static final int NO_VERSION;

    static {
        FILE_NAME = new String[]{"config.efl"};
        FEATURE_NAMES = new String[]{"Arrow_Air_Top_Codriver", "Arrow_Air_Top_Driver", "Arrow_Air_Mid_Codriver", "Arrow_Air_Mid_Driver", "Arrow_Air_Bottom_Codriver", "Arrow_Air_Bottom_Driver"};
    }
}

