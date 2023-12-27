/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.ambiencelight;

public interface AmbienceColorAreaSettings {
    public static final int LIGHT_AREA_AVAILABILITY_VISIBLE;
    public static final int LIGHT_AREA_AVAILABILITY_INVISIBLE;
    public static final int NUMBER_OF_COLOR_AREAS;
    public static final int AMBIENCE_LIGHT_FEATURE_CUPHOLDER_STRIP;
    public static final int AMBIENCE_LIGHT_FEATURE_COCKPIT;
    public static final int AMBIENCE_LIGHT_FEATURE_DOORS;
    public static final int AMBIENCE_LIGHT_FEATURE_HANDLE;
    public static final int AMBIENCE_LIGHT_FEATURE_RECTANGLE;
    public static final int AMBIENCE_LIGHT_FEATURE_FOOTWELL;
    public static final int AMBIENCE_LIGHT_FEATURE_ROOF;
    public static final int AMBIENCE_LIGHT_FEATURE_FRONT_SLIDER;
    public static final int AMBIENCE_LIGHT_FEATURE_FRONT_DOOR_POCKET;
    public static final int AMBIENCE_LIGHT_FEATURE_FRONT_DOORS_ENTRANCE;
    public static final int AMBIENCE_LIGHT_FEATURE_FRONT_CLIMATE_CONTROL_STRIP;
    public static final int AMBIENCE_LIGHT_FEATURE_GEAR_SHIFT;
    public static final int AMBIENCE_LIGHT_FEATURE_CENTER_CONTROL_LIGHTING_FRONT;
    public static final int AMBIENCE_LIGHT_FEATURE_NAVI_DEVICE_STRIP;
    public static final int AMBIENCE_LIGHT_FEATURE_PREMIUMSOUND;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_DOORS;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET;
    public static final int AMBIENCE_LIGHT_FEATURE_REAR_ROOF;
    public static final int AMBIENCE_LIGHT_FEATURE_SUNROOF_STRIP;

    default public int[] getColorAreaAvailabilities() {
    }

    default public boolean[] getColorAreaMultiColorAvailabilities() {
    }

    default public int[] getColorAreaFeatureButtonMappings() {
    }
}

