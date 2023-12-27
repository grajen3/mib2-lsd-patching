/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.diagnose;

import org.dsi.ifc.base.DSIBase;

public interface DSIDiagnoseSystem
extends DSIBase {
    public static final String VERSION;
    public static final int IN_REQUESTROUTINE;
    public static final int IN_REQUESTACTUATORTEST;
    public static final int RT_ACKNOWLEDGEROUTINE;
    public static final int RT_RESULTROUTINE;
    public static final int RT_ACKNOWLEDGEACTUATORTEST;
    public static final int ATTR_DIAGNOSTICVALUECHANGED;
    public static final int ROUTINE_DELETE_MEMORY;
    public static final int ROUTINE_RESET_PML_PASSWORD;
    public static final int ROUTINEACTION_START;
    public static final int ROUTINEACTION_STOP;
    public static final int ROUTINEACTION_RESULTS;
    public static final int ROUTINESTATE_ACTIVE;
    public static final int ROUTINESTATE_NOT_ACTIVE;
    public static final int ROUTINESTATE_ABORTED;
    public static final int ROUTINERESULT_CORRECT;
    public static final int ROUTINERESULT_INCORRECT;
    public static final int ROUTINERESULT_NOT_AVAILABLE;
    public static final int HMIRESPONSE_OK;
    public static final int HMIRESPONSE_GENERAL_REJECT;
    public static final int HMIRESPONSE_REQUEST_SEQUENCE_ERROR;
    public static final int HMIRESPONSE_REQUEST_OUT_OF_RANGE;
    public static final int DELETE_MEMORY_FACTORY_SETTINGS;
    public static final int DELETE_MEMORY_RESET_INTERNAL_VALUES;
    public static final int ACTUATOR_REMOTE_CONTROL_MODE;
    public static final int ACTUATOR_TEST_PICTURE_DISPLAY_1;
    public static final int ACTUATOR_TEST_PICTURE_DISPLAY_2;
    public static final int ACTUATOR_SOURCE_SWITCH;
    public static final int ACTUATOR_NAVIGATION_DEMOROUTE;
    public static final int ACTUATORACTION_START;
    public static final int ACTUATORACTION_STOP;
    public static final int ACTUATOR_INFINITE_TIMING;
    public static final int TEST_PICTURE_DISPLAY_NO_CONTROL;
    public static final int TEST_PICTURE_DISPLAY_STANDARD;
    public static final int TEST_PICTURE_DISPLAY_RED;
    public static final int TEST_PICTURE_DISPLAY_GREEN;
    public static final int TEST_PICTURE_DISPLAY_BLUE;
    public static final int TEST_PICTURE_DISPLAY_WHITE;
    public static final int TEST_PICTURE_DISPLAY_BLACK;
    public static final int TEST_PICTURE_DISPLAY_CHESSBOARD;
    public static final int TEST_PICTURE_DISPLAY_CHESSBOARD_INVERTED;
    public static final int TEST_PICTURE_DISPLAY_64_GRAYSCALES;
    public static final int SOURCESWITCH_RADIO_FM;
    public static final int SOURCESWITCH_RADIO_AM;
    public static final int SOURCESWITCH_RADIO_DAB;
    public static final int SOURCESWITCH_RADIO_SDARS;
    public static final int SOURCESWITCH_CD_CHANGER;
    public static final int SOURCESWITCH_AUX_IN_FRONT;
    public static final int SOURCESWITCH_AUX_IN_EXTRA;
    public static final int SOURCESWITCH_SD1;
    public static final int SOURCESWITCH_DVD_CHANGER;
    public static final int SOURCESWITCH_BLUETOOTH;
    public static final int SOURCESWITCH_RADIO_DRM;
    public static final int SOURCESWITCH_WLAN;
    public static final int SOURCESWITCH_WIMAX;
    public static final int SOURCESWITCH_JUKEBOX;
    public static final int SOURCESWITCH_INTERNAL_OPTICAL_DRIVE;
    public static final int SOURCESWITCH_TV;
    public static final int SOURCESWITCH_USB;
    public static final int SOURCESWITCH_MEDIA_AV_IN;
    public static final int SOURCESWITCH_TP_MEMO;
    public static final int SOURCESWITCH_SD2;
    public static final int SOURCESWITCH_USB2;
    public static final int SOURCESWITCH_USB3;
    public static final int SOURCESWITCH_USB4;
    public static final int NAVIGATION_ANNOUNCEMENT_OFF;
    public static final int NAVIGATION_ANNOUNCEMENT_TRAFFIC;
    public static final int NAVIGATION_ANNOUNCEMENT_COMPACT;
    public static final int NAVIGATION_ANNOUNCEMENT_COMPLETE;

    default public void acknowledgeRoutine(int n, int n2, int n3, int n4) {
    }

    default public void resultRoutine(int n, int n2, int n3, int n4, int n5) {
    }

    default public void acknowledgeActuatorTest(int n, int n2, int n3, int n4, int[] nArray, int n5) {
    }
}

