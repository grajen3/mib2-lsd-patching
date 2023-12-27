/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.energyflow;

public interface EnergyFlowConstants {
    public static final short ENERGYFLOW_CONFIG_VERSION;
    public static final short ENERGYFLOW_MINIMAL_CONFIG_VERSION;
    public static final int NUMBER_OF_FEATURE_POSITIONS;
    public static final int NUMBER_OF_FEATURE_POS_VALUES;
    public static final int NUMBER_OF_ENERGY_FLOW_POSITIONS;
    public static final int NUMBER_OF_ENERGY_FLOW_POS_VALUES;
    public static final int NUMBER_OF_SHIFT_VALUES;
    public static final int NUMBER_OF_CAR_POS;
    public static final int NUMBER_OF_CAR_POS_VALUES;
    public static final String[] FILE_NAME;
    public static final int DEFAULT_ENERGYFLOW_CONFIG_LENGTH;
    public static final int OFFSET_HEADER;
    public static final int OFFSET_FEATURE_DATA;
    public static final int OFFSET_ENERGY_FLOW_DATA;
    public static final int OFFSET_SHIFT_DATA;
    public static final int OFFSET_CAR_POSITION_DATA;
    public static final int COUNT_WHEEL_SEQ;
    public static final int E_FLOW_IDX_FL;
    public static final int E_FLOW_IDX_FR;
    public static final int E_FLOW_IMG_IDX_BAT;
    public static final int E_FLOW_IMG_IDX_BAT_NEG;
    public static final int E_FLOW_MASK_IDX_BAT;
    public static final int E_FLOW_MASK_IDX_BAT_NEG;
    public static final String AIR_CONDITION_IMAGE;
    public static final String BATTERY_IMAGE;
    public static final String CAR_BACKGROUND;
    public static final String CAR_FOREGROUND;
    public static final String ELECTRIC_MOTOR;
    public static final String ENGINE_IMAGE;
    public static final String[] E_FLOW_UNDER_WHEEL_IMAGES;
    public static final String[] E_FLOW_BATTERY_IMAGES;
    public static final String[] E_FLOW_MASK_IMAGES;
    public static final String[] CAR_TYPE_DIR;
    public static final String ACTIVE_SUFFIX;
    public static final String INACTIVE_SUFFIX;
    public static final String IMAGE_EXT;
    public static final String WHEEL_SEQ_IMAGE;
    public static final String[] WHEEL_SUFFIXES;
    public static final int SHIFT_BAT_IDX;
    public static final int SHIFT_BAT_NEG_IDX;
    public static final int X_IDX;
    public static final int Y_IDX;
    public static final int EF_BAT_IDX;
    public static final int EF_BAT_MASK_IDX;
    public static final int EF_BAT_NEG_IDX;
    public static final int EF_BAT_NEG_MASK_IDX;
    public static final int[] EF_INDICES_POS;
    public static final int[] EF_INDICES_MASK_POS;
    public static final int[] EF_INDICES_NEG;
    public static final int[] EF_INDICES_MASK_NEG;
    public static final int[] EF_IMG_INDICES_POS;
    public static final int[] EF_IMG_INDICES_NEG;
    public static final int[] EF_SHIFT_INDICES_POS;
    public static final int[] EF_SHIFT_INDICES_NEG;
    public static final int[] EF_WHEEL_INDICES;
    public static final int NO_SUCH_VALUE;
    public static final int NO_VERSION;

    static {
        FILE_NAME = new String[]{"config_BEV.efl", "config_PHEV.efl", "config.efl"};
        E_FLOW_UNDER_WHEEL_IMAGES = new String[]{"Hy_Track_Front_Left", "Hy_Track_Front_Right"};
        E_FLOW_BATTERY_IMAGES = new String[]{"Hy_Track_Battery", "Hy_Track_Battery_Negative"};
        E_FLOW_MASK_IMAGES = new String[]{"Hy_Track_Front_Left_Alpha", "Hy_Track_Front_Right_Alpha", "Hy_Track_Battery_Alpha", "Hy_Track_Battery_Negative_Alpha", "Hy_Track_Front_Left_Negative_Alpha", "Hy_Track_Front_Right_Negative_Alpha"};
        CAR_TYPE_DIR = new String[]{"BEV", "PHEV", ""};
        WHEEL_SUFFIXES = new String[]{"_Front_Left", "_Front_Right", "_Rear_Left", "_Rear_Right"};
        EF_INDICES_POS = new int[]{6, 8};
        EF_INDICES_MASK_POS = new int[]{7, 9};
        EF_INDICES_NEG = new int[]{14, 16};
        EF_INDICES_MASK_NEG = new int[]{15, 17};
        EF_IMG_INDICES_POS = new int[]{0, 1};
        EF_IMG_INDICES_NEG = new int[]{4, 5};
        EF_SHIFT_INDICES_POS = new int[]{0, 1};
        EF_SHIFT_INDICES_NEG = new int[]{4, 5};
        EF_WHEEL_INDICES = new int[]{2, 3, 4, 5};
    }
}

