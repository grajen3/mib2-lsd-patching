/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

public interface AbtFeatureService {
    public static final int PROXIMITY_UNAVAILABLE;
    public static final int PROXIMITY_BASIC;
    public static final int PROXIMITY_NEAR_AND_FAR;
    public static final int PROXIMITY_NEAR;
    public static final int PROXIMITY_FAR;
    public static final int ABT_TYPE_UNKNOWN;
    public static final int ABT_TYPE_ALPINE_6_5;
    public static final int ABT_TYPE_ALPINE_8;
    public static final int ABT_TYPE_CONTI_6_5;
    public static final int ABT_TYPE_CONTI_VW_621;
    public static final int ABT_TYPE_CONTI_8_GEN2_GP;
    public static final int ABT_TYPE_CONTI_9_2_GEN2_GP;
    public static final int DISPLAY_SHAPE_ACTIVE_AREA_VISIBLE;
    public static final int DISPLAY_SHAPE_TRAPEZOID;
    public static final int DISPLAY_SHAPE_ACTIVE_AREA_COVERED;
    public static final int ROTARY_ENCODER_UNAVAILABLE;
    public static final int ROTARY_ENCODER_VOLUME;
    public static final int ROTARY_ENCODER_VOLUME_MENU;
    public static final int BUTTON_TECHNOLOGY_UNKNOWN;
    public static final int BUTTON_TECHNOLOGY_PARALLEL_HUB;
    public static final int BUTTON_TECHNOLOGY_SENSOR;
    public static final int TOUCH_CONTROLLER_UNKNOWN;
    public static final int TOUCH_CONTROLLER_CYPRESS_GEN_1;
    public static final int TOUCH_CONTROLLER_ATMEL_GEN_1;
    public static final int TOUCH_CONTROLLER_ABT_2_GP_8;
    public static final int TOUCH_CONTROLLER_ABT_2_GP_9_2;
    public static final int TOUCH_CONTROLLER_SYNAPTICS_INCELL;

    default public int getProximitySensor() {
    }

    default public boolean hasHandWritingRecognition() {
    }

    default public boolean hasHapticFeedback() {
    }

    default public int getDisplayResolutionX() {
    }

    default public int getDisplayResolutionY() {
    }

    default public int getAbtType() {
    }

    default public int getDisplayShape() {
    }

    default public int getNumberOfHardKeys() {
    }

    default public int getButtonTechnology() {
    }

    default public int getRotaryEncoderType() {
    }

    default public int getTouchController() {
    }

    default public int getTouchMultiplicatorX() {
    }

    default public int getTouchMultiplicatorY() {
    }
}

