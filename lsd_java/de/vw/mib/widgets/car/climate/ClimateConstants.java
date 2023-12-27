/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.climate;

public interface ClimateConstants {
    public static final short CLIMATE_CONFIG_VERSION;
    public static final int NUMBER_OF_FEATURE_VALUES;
    public static final int FEATURE_ID;
    public static final int FEATURE_X;
    public static final int FEATURE_Y;
    public static final int NUMBER_OF_BACKGROUND_VALUES;
    public static final int BACKGROUND_X;
    public static final int BACKGROUND_Y;
    public static final int ASPECT_ALL;
    public static final int ASPECT_FRONT;
    public static final int ASPECT_MID;
    public static final int ASPECT_REAR;
    public static final String[] FEATURE_NAMES;
    public static final int FEAT_BOTTOM_CODRIVER;
    public static final int FEAT_BOTTOM_DRIVER;
    public static final int FEAT_MID_CODRIVER;
    public static final int FEAT_MID_DRIVER;
    public static final int FEAT_TOP_CODRIVER;
    public static final int FEAT_TOP_DRIVER;
    public static final int[] FEATURE_DRAWING_ORDER;
    public static final int OFFSET_HEADER;
    public static final int OFFSET_BACKGROUND_DATA;
    public static final int OFFSET_FEATURE_DATA;
    public static final int CLIMATE_CONFIG_LENGTH;
    public static final String FILE_NAME;
    public static final String CLIMATE_IMAGE_NAME;
    public static final String CLIMATE_IMAGE_RHD_NAME;
    public static final String IMAGE_EXT;
    public static final int NO_SUCH_FEATURE;
    public static final int NO_VERSION;

    static {
        FEATURE_NAMES = new String[]{"Arrow_Air_Top_Codriver", "Arrow_Air_Top_Driver", "Arrow_Air_Mid_Codriver", "Arrow_Air_Mid_Driver", "Arrow_Air_Bottom_Codriver", "Arrow_Air_Bottom_Driver"};
        FEATURE_DRAWING_ORDER = new int[]{1, 0, 3, 2, 5, 4};
        CLIMATE_CONFIG_LENGTH = 256 + FEATURE_NAMES.length * 3 * 2;
    }
}

