/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.models.AbstractCarSpecificModel;
import de.vw.mib.widgets.models.ButtonModel;

public interface OPSModel
extends AbstractCarSpecificModel {
    public static final int PID_BASE;
    public static final int PID_SENSORS_SEGMENT_VALUES;
    public static final int PID_SENSOR_STATE_VALUES;
    public static final int PID_SENSOR_STATE_COLORS;
    public static final int PID_TRACK_DISPLAY;
    public static final int PID_DIRECTION;
    public static final int PID_RADIUS_REAR;
    public static final int PID_RADIUS_FRONT;
    public static final int PID_SHOW_REAR_ONLY;
    public static final int PID_SHOW_TRAILER;
    public static final int PID_SHOW_OPSMINI;
    public static final int PID_WHEEL_BASE;
    public static final int PID_SHOW360;
    public static final int PID_SHOW_TEST_MODE;
    public static final int PID_SHOW_AREA_VIEW;
    public static final int PID_AREA_VIEW_STATES;
    public static final int PID_AREA_VIEW_BUTTON_REFS;
    public static final int PID_SHOW_RTA;
    public static final int PID_RTA_STATES;
    public static final int PID_RTA_STATE_COLORS;
    public static final int PID_SHOW_CAMERA_BASED_SEGMENTS;
    public static final int PID_SHOW_FTA;
    public static final int PID_FTA_STATES;
    public static final int PID_FTA_STATE_COLORS;
    public static final int PID_SHOW_MANEUVER_ASSIST;
    public static final int PID_MANEUVER_ASSIST_STATES;
    public static final int PID_SHOW_RIM_PROTECTION;
    public static final int PID_RIM_PROTECTION_STATES;
    public static final int PID_RIM_PROTECTION_STATE_COLORS;
    public static final int PID_SHOW_COLORED_SENSOR_FAILURE;
    public static final int PID_COLORED_SENSOR_FAILURE_ALPHAS;
    public static final int PID_COUNT_OPS;
    public static final int SID_BASE;
    public static final int SID_SHOW_REAR_ONLY;
    public static final int SID_SHOW_TRAILER;
    public static final int SID_SHOW_OPS_MINI;
    public static final int SID_DIRECTION;
    public static final int SID_SHOW360;
    public static final int SID_SHOW_TEST_MODE;
    public static final int SID_SHOW_AREA_VIEW;
    public static final int SID_SHOW_RTA;
    public static final int SID_SHOW_CAMERA_BASED_SEGMENTS;
    public static final int SID_SHOW_FTA;
    public static final int SID_SHOW_MANEUVER_ASSIST;
    public static final int SID_SHOW_RIM_PROTECTION;
    public static final int SID_SHOW_COLORED_SENSOR_FAILURE;
    public static final int SID_COUNT_OPS;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_OPS;
    public static final int VLM;
    public static final int VLA;
    public static final int LSV;
    public static final int LSVM;
    public static final int LSHM;
    public static final int LSH;
    public static final int HLA;
    public static final int HLM;
    public static final int VRM;
    public static final int VRA;
    public static final int RSV;
    public static final int RSVM;
    public static final int RSHM;
    public static final int RSH;
    public static final int HRA;
    public static final int HRM;
    public static final int SENSOR_COUNT;
    public static final int HLARO;
    public static final int HLMRO;
    public static final int HRARO;
    public static final int HRMRO;
    public static final int VLAX;
    public static final int HLAX;
    public static final int VRAX;
    public static final int HRAX;
    public static final int FTAL;
    public static final int FTAR;
    public static final int RTAL;
    public static final int RTAR;
    public static final int FTALX;
    public static final int FTARX;
    public static final int RTALX;
    public static final int RTARX;
    public static final int RTALRO;
    public static final int RTARRO;
    public static final int RPFL;
    public static final int RPFR;
    public static final int RPRL;
    public static final int RPRR;
    public static final int VLM_;
    public static final int VLA_;
    public static final int LSV_;
    public static final int LSVM_;
    public static final int LSHM_;
    public static final int LSH_;
    public static final int HLA_;
    public static final int HLM_;
    public static final int VRM_;
    public static final int VRA_;
    public static final int RSV_;
    public static final int RSVM_;
    public static final int RSHM_;
    public static final int RSH_;
    public static final int HRA_;
    public static final int HRM_;
    public static final int VLAX_;
    public static final int HLAX_;
    public static final int VRAX_;
    public static final int HRAX_;
    public static final int[] SENSEG_GROUP_4K;
    public static final int[] SENSEG_GROUP_8K;
    public static final int[] SENSEG_GROUP_8K_TRAILER;
    public static final int[] SENSEG_GROUP_8K_CB;
    public static final int[] SENSEG_GROUP_8K_CB_TRAILER;
    public static final int[] SENSEG_GROUP_360;
    public static final int[] SENSEG_GROUP_360_TRAILER;
    public static final int[] SENSEG_GROUP_360_CB;
    public static final int[] SENSEG_GROUP_360_CB_TRAILER;
    public static final int[] RTASEG_GROUP_4K;
    public static final int[] FTASEG_GROUP_8K;
    public static final int[] RTASEG_GROUP_8K;
    public static final int[] FTASEG_GROUP_360;
    public static final int[] RTASEG_GROUP_360;
    public static final int ADD_GRAPH_BASE;
    public static final int ERROR_V;
    public static final int ERROR_L;
    public static final int ERROR_R;
    public static final int ERROR_H;
    public static final int ERROR_RO;
    public static final int BACKGROUND_VLM;
    public static final int BACKGROUND_VLA;
    public static final int BACKGROUND_LSV;
    public static final int BACKGROUND_LSVM;
    public static final int BACKGROUND_LSHM;
    public static final int BACKGROUND_LSH;
    public static final int BACKGROUND_HLA;
    public static final int BACKGROUND_HLM;
    public static final int BACKGROUND_HLMRO;
    public static final int BACKGROUND_HLARO;
    public static final int BACKGROUND_VLAX;
    public static final int BACKGROUND_HLAX;
    public static final int BACKGROUND_RTAL;
    public static final int BACKGROUND_RTALX;
    public static final int ERROR_RTA_L;
    public static final int ERROR_RTA_R;
    public static final int DIRTY_V;
    public static final int DIRTY_L;
    public static final int DIRTY_R;
    public static final int DIRTY_H;
    public static final int DIRTY_RO;
    public static final int BACKGROUND_VLMX;
    public static final int BACKGROUND_HLMX;
    public static final int BACKGROUND_RTALRO;
    public static final int ERROR_RTARO_L;
    public static final int ERROR_RTARO_R;
    public static final int OVERLAY_RTAL;
    public static final int OVERLAY_RTALX;
    public static final int BACKGROUND_FTAL;
    public static final int BACKGROUND_FTALX;
    public static final int OVERLAY_FTAL;
    public static final int OVERLAY_FTALX;
    public static final int ERROR_FTA_L;
    public static final int ERROR_FTA_R;
    public static final int RIM_VL;
    public static final int RIM_VR;
    public static final int RIM_HL;
    public static final int RIM_HR;
    public static final int ADD_GRAPH_COUNT;
    public static final int BG_RIGHT_OFFSET;
    public static final int BACKGROUND_VRM;
    public static final int BACKGROUND_VRA;
    public static final int BACKGROUND_RSV;
    public static final int BACKGROUND_RSVM;
    public static final int BACKGROUND_RSHM;
    public static final int BACKGROUND_RSH;
    public static final int BACKGROUND_HRA;
    public static final int BACKGROUND_HRM;
    public static final int BACKGROUND_HRMRO;
    public static final int BACKGROUND_HRARO;
    public static final int BACKGROUND_VRAX;
    public static final int BACKGROUND_HRAX;
    public static final int BACKGROUND_RTAR;
    public static final int BACKGROUND_RTARX;
    public static final int BACKGROUND_VRMX;
    public static final int BACKGROUND_HRMX;
    public static final int BACKGROUND_RTARRO;
    public static final int BACKGROUND_FTAR;
    public static final int BACKGROUND_FTARX;
    public static final int OL_RIGHT_OFFSET;
    public static final int OVERLAY_FTAR;
    public static final int OVERLAY_FTARX;
    public static final int OVERLAY_RTAR;
    public static final int OVERLAY_RTARX;
    public static final int[] BG_GROUP_4K;
    public static final int[] BG_GROUP_4K_RTA;
    public static final int[] BG_GROUP_8K;
    public static final int[] BG_GROUP_8K_TRAILER;
    public static final int[] BG_GROUP_8K_RTA;
    public static final int[] BG_GROUP_8K_FTA;
    public static final int[] BG_GROUP_360;
    public static final int[] BG_GROUP_360_TRAILER;
    public static final int[] BG_GROUP_360_RTA;
    public static final int[] BG_GROUP_360_FTA;
    public static final int[] BG_GROUP_360_AV;
    public static final int[] BG_GROUP_360_AV_TRAILER;
    public static final int[] OL_GROUP_8K_FTA;
    public static final int[] OL_GROUP_8K_RTA;
    public static final int[] OL_GROUP_360_FTA;
    public static final int[] OL_GROUP_360_RTA;
    public static final int[] RP_GROUP_360;
    public static final int CAR_SPEC_IMG_BASE;
    public static final int CAR;
    public static final int CAR_RO;
    public static final int TRAILER;
    public static final int TRAILER_RO;
    public static final int CAR_SPEC_IMG_COUNT;
    public static final int SENSOR_GROUP_FRONT;
    public static final int SENSOR_GROUP_LEFT;
    public static final int SENSOR_GROUP_RIGHT;
    public static final int SENSOR_GROUP_REAR;
    public static final int TRACK_DISPLAY_NONE;
    public static final int TRACK_DISPLAY_FRONT;
    public static final int TRACK_DISPLAY_REAR;
    public static final int AREA_VIEW_BTN_FRONT;
    public static final int AREA_VIEW_BTN_RIGHT;
    public static final int AREA_VIEW_BTN_REAR;
    public static final int AREA_VIEW_BTN_LEFT;
    public static final int AREA_VIEW_BTN_CENTER;
    public static final int AREA_VIEW_BTN_COUNT;
    public static final int MANEUVER_ASSIST_STATE_FRONT_LEFT_INDEX;
    public static final int MANEUVER_ASSIST_STATE_FRONT_RIGHT_INDEX;
    public static final int MANEUVER_ASSIST_STATE_REAR_LEFT_INDEX;
    public static final int MANEUVER_ASSIST_STATE_REAR_RIGHT_INDEX;
    public static final int MANEUVER_ASSIST_STATE_COUNT;

    default public int[] get_sensorsSegmentValues() {
    }

    default public void set_sensorsSegmentValues(int[] nArray) {
    }

    default public int[] get_sensorStateValues() {
    }

    default public void set_sensorStateValues(int[] nArray) {
    }

    default public Color[] get_sensorStateColors() {
    }

    default public void set_sensorStateColors(Color[] colorArray) {
    }

    default public int get_trackDisplay() {
    }

    default public void set_trackDisplay(int n) {
    }

    default public int get_wheelBase() {
    }

    default public void set_wheelBase(int n) {
    }

    default public boolean is_direction() {
    }

    default public void set_direction(boolean bl) {
    }

    default public int get_radiusRear() {
    }

    default public void set_radiusRear(int n) {
    }

    default public int get_radiusFront() {
    }

    default public void set_radiusFront(int n) {
    }

    default public boolean is_showRearOnly() {
    }

    default public void set_showRearOnly(boolean bl) {
    }

    default public boolean is_show360() {
    }

    default public void set_show360(boolean bl) {
    }

    default public boolean is_showTrailer() {
    }

    default public void set_showTrailer(boolean bl) {
    }

    default public boolean is_showOPSMini() {
    }

    default public void set_showOPSMini(boolean bl) {
    }

    default public boolean is_showTestMode() {
    }

    default public void set_showTestMode(boolean bl) {
    }

    default public boolean is_showAreaView() {
    }

    default public void set_showAreaView(boolean bl) {
    }

    default public int[] get_areaViewStates() {
    }

    default public void set_areaViewStates(int[] nArray) {
    }

    default public ButtonModel[] get_areaViewButtonRefs() {
    }

    default public void set_areaViewButtonRefs(ButtonModel[] buttonModelArray) {
    }

    default public boolean is_showRTA() {
    }

    default public void set_showRTA(boolean bl) {
    }

    default public int[] get_rtaStates() {
    }

    default public void set_rtaStates(int[] nArray) {
    }

    default public Color[] get_rtaStateColors() {
    }

    default public void set_rtaStateColors(Color[] colorArray) {
    }

    default public boolean is_showCameraBasedSegments() {
    }

    default public void set_showCameraBasedSegments(boolean bl) {
    }

    default public boolean is_showFTA() {
    }

    default public void set_showFTA(boolean bl) {
    }

    default public int[] get_ftaStates() {
    }

    default public void set_ftaStates(int[] nArray) {
    }

    default public Color[] get_ftaStateColors() {
    }

    default public void set_ftaStateColors(Color[] colorArray) {
    }

    default public boolean is_showManeuverAssist() {
    }

    default public void set_showManeuverAssist(boolean bl) {
    }

    default public int[] get_maneuverAssistStates() {
    }

    default public void set_maneuverAssistStates(int[] nArray) {
    }

    default public boolean is_showRimProtection() {
    }

    default public void set_showRimProtection(boolean bl) {
    }

    default public int[] get_rimProtectionStates() {
    }

    default public void set_rimProtectionStates(int[] nArray) {
    }

    default public Color[] get_rimProtectionStateColors() {
    }

    default public void set_rimProtectionStateColors(Color[] colorArray) {
    }

    default public boolean is_showColoredSensorFailure() {
    }

    default public void set_showColoredSensorFailure(boolean bl) {
    }

    default public int[] get_coloredSensorFailureAlphas() {
    }

    default public void set_coloredSensorFailureAlphas(int[] nArray) {
    }

    static {
        SENSEG_GROUP_4K = new int[]{106, 107, 115, 114};
        SENSEG_GROUP_8K = new int[]{0, 1, 6, 7, 15, 14, 9, 8};
        SENSEG_GROUP_8K_TRAILER = new int[]{0, 1, 9, 8};
        SENSEG_GROUP_8K_CB = new int[]{0, 1, 301, 6, 306, 7, 15, 14, 314, 9, 309, 8};
        SENSEG_GROUP_8K_CB_TRAILER = new int[]{0, 1, 301, 9, 309, 8};
        SENSEG_GROUP_360 = new int[]{0, 201, 1, 2, 3, 4, 5, 206, 6, 7, 15, 214, 14, 13, 12, 11, 10, 209, 9, 8};
        SENSEG_GROUP_360_TRAILER = new int[]{0, 201, 1, 2, 3, 4, 5, 13, 12, 11, 10, 209, 9, 8};
        SENSEG_GROUP_360_CB = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 15, 14, 13, 12, 11, 10, 9, 8};
        SENSEG_GROUP_360_CB_TRAILER = new int[]{0, 1, 2, 3, 4, 5, 13, 12, 11, 10, 9, 8};
        RTASEG_GROUP_4K = new int[]{400, 401};
        FTASEG_GROUP_8K = new int[]{0, 1};
        RTASEG_GROUP_8K = new int[]{0, 1};
        FTASEG_GROUP_360 = new int[]{500, 501};
        RTASEG_GROUP_360 = new int[]{600, 601};
        BG_GROUP_4K = new int[]{14, 13, 113, 114};
        BG_GROUP_4K_RTA = new int[]{28, 128};
        BG_GROUP_8K = new int[]{5, 6, 11, 12, 112, 111, 106, 105};
        BG_GROUP_8K_TRAILER = new int[]{5, 6, 106, 105};
        BG_GROUP_8K_RTA = new int[]{17, 117};
        BG_GROUP_8K_FTA = new int[]{33, 133};
        BG_GROUP_360 = new int[]{5, 15, 7, 8, 9, 10, 16, 12, 112, 116, 110, 109, 108, 107, 115, 105};
        BG_GROUP_360_TRAILER = new int[]{5, 15, 7, 8, 9, 10, 110, 109, 108, 107, 115, 105};
        BG_GROUP_360_RTA = new int[]{18, 118};
        BG_GROUP_360_FTA = new int[]{34, 134};
        BG_GROUP_360_AV = new int[]{26, 15, 7, 8, 9, 10, 16, 27, 127, 116, 110, 109, 108, 107, 115, 126};
        BG_GROUP_360_AV_TRAILER = new int[]{26, 15, 7, 8, 9, 10, 110, 109, 108, 107, 115, 126};
        OL_GROUP_8K_FTA = new int[]{35, 235};
        OL_GROUP_8K_RTA = new int[]{31, 231};
        OL_GROUP_360_FTA = new int[]{36, 236};
        OL_GROUP_360_RTA = new int[]{32, 232};
        RP_GROUP_360 = new int[]{39, 41, 40, 42};
    }
}

