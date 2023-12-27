/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.extern.datapool;

import de.vw.mib.asl.internal.car.parkassistence.extern.datapool.ParkingAdaptationService;

public interface ParkingAdaptationDelegate {
    public static final int ADAPTATION_DISPLAY_CONTENT__DISPLAY_CONTENT_SYSTEM;
    public static final int ADAPTATION_DISPLAY_CONTENT__DISPLAY_CONTENT_SCREEN;
    public static final int ADAPTATION_DISPLAY_CONTENT__DISPLAY_CONTENT_MODE;
    public static final int ADAPTATION_DISPLAY_CONTENT__DISPLAY_CONTENT_VIEW;
    public static final int ADAPTATION_PDC_AUTO_ACTIVATION_ON;
    public static final int ADAPTATION_PDC_ENTERTAINMENT_LOWERING;
    public static final int ADAPTATION_PDC_MUTE_ON;
    public static final int ADAPTATION_PDC_AUDIO_LOWERING_STATE;
    public static final int ADAPTATION_AUTO_EPB_ON;
    public static final int ADAPTATION_RTA_SYSTEM_ACTIVE_ON;
    public static final int ADAPTATION_PLE_SYSTEM_ACTIVE_ON;
    public static final int ADAPTATION_FIFTH_CAMERA_MODE;
    public static final int ADAPTATION_PDC_SYSTEM_ON;
    public static final int ADAPTATION_EXIT_ASSIST_ON;
    public static final int ADAPTATION_MANOEUVERING_ASSIST_SYSTEM_ACTIVE_ON;
    public static final int ADAPTATION_MANOEUVERING_ASSIST_ON;
    public static final int ADAPTATION_NEW_PARKING_IMPLEMENTATION;
    public static final int ADAPTATION_PARKING_ACTIVE;
    public static final int ADAPTATION_FUNCTION_INDEX;
    public static final int ADAPTATION_OPS_CONFIG;
    public static final int ADAPTATION_DISTANCES;
    public static final int ADAPTATION_OPS_REAR_ONLY;
    public static final int ADAPTATION_OPS_TRAILER_MODE_ON;
    public static final int ADAPTATION_OPS_AVAILABLE;
    public static final int ADAPTATION_OPS360;
    public static final int ADAPTATION_RTA_STATUS;
    public static final int ADAPTATION_SENSOR_STATUS;
    public static final int ADAPTATION_RVC_AVAILABLE;
    public static final int ADAPTATION_RVC_BRIGHTNESS;
    public static final int ADAPTATION_RVC_COLOR;
    public static final int ADAPTATION_RVC_CONTRAST;
    public static final int ADAPTATION_DARK_SCREEN_REQUEST;
    public static final int ADAPTATION_PARKBOX_MODE_SUPPORTED;
    public static final int ADAPTATION_PARALLEL_MODE_SUPPORTED;
    public static final int ADAPTATION_TRAILER_MODE_SUPPORTED;
    public static final int ADAPTATION_CROSSING_MODE_SUPPORTED;
    public static final int ADAPTATION_STEERING_INFO_TRACK_DISPLAY;
    public static final int ADAPTATION_STEERING_INFO_DIRECTION;
    public static final int ADAPTATION_STEERING_INFO_AXLE_DISTANCE;
    public static final int ADAPTATION_EXT_CAM_INTERIOR_STATE;
    public static final int ADAPTATION_PDC_DISCLAIMER_STATE;
    public static final int ADAPTATION_EARLY_RVC_ACTIVE;
    public static final int ADAPTATION_OFFROAD_KOG_ACTIVE;
    public static final int ADAPTATION_DISPLAY_CONTENT;
    public static final int ADAPTATION_FUNCTION_EXISTENCE;
    public static final int ADAPTATION_FUNCTION_AVAILABILITY;
    public static final int ADAPTATION_FUNCTION_AVAILABLE_REASON;
    public static final int ADAPTATION_PDC_ACOUSTIC_SETTINGS;
    public static final int ADAPTATION_STEERING_INFOR_WHEEL_RADIUS;
    public static final int ADAPTATION_OPS_DISPLAY_CONTENT;
    public static final int ADAPTATION_FRONT_SUPPORTED_MODES;
    public static final int ADAPTATION_REAR_SUPPORTED_MODES;
    public static final int ADAPTATION_SIDE_SUPPORTED_MODES;
    public static final int ADAPTATION_BV_SUPPORTED_MODES;
    public static final int ADAPTATION_VPS3D_BIRD_VIEW_POSITION;
    public static final int[] ADAPTATION_PROPERTIES;
    public static final int[] ADAPTATION_LISTS;

    default public void updateAdaptation(ParkingAdaptationService parkingAdaptationService, int n) {
    }

    static {
        ADAPTATION_PROPERTIES = new int[]{0, 1, 2, 3, 10161, 10163, 10163, 10164, 10167, 10168, 10169, 10170, 10172, 10172, 10794, 10526, 10527, 10559, 10795, 10741, 10180, 10175, 10179, 10177, 10176, 10173, 10196, 10174, 10174, 10178, 10178, 10181, 10181, 10182, 10182, 10183, 10183, 10184, 10185, 10185, 10186, 10187, 10188, 10189, 10190, 10193, 10461, 10465, 10611, 10450};
        ADAPTATION_LISTS = new int[]{10560, 10742, 10743, 10744, 10162, 10452, 10453, 10454, 10456, 10462, 10197, 10198};
    }
}

