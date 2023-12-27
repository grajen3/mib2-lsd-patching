/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.perf.service;

import de.vw.mib.perf.service.PerfServiceData;

public interface PerfService {
    public static final int PREFLOG_ACTION_REQUEST_BY_HMI;
    public static final int PREFLOG_ACTION_RESPONSE_BY_SYSTEM;
    public static final int PREFLOG_ACTION_TIMEOUT_BY_HMI;
    public static final int PERFLOG_FIRSTSCREEN;
    public static final int PERFLOG_RADIO_FMREADY;
    public static final int PERFLOG_RADIO_AMREADY;
    public static final int PERFLOG_RADIO_DABREADY;
    public static final int PERFLOG_NAVI_MAPREADY;
    public static final int PERFLOG_MEDIA_READY;
    public static final int PERFLOG_PHONE_READY;
    public static final int PERFLOG_SDS_READY;
    public static final int PERFLOG_ADDRBOOK_READY;
    public static final int PERFLOG_RADIO_HDREADY;
    public static final int PERFLOG_CAR_RVCREADY;
    public static final int PERFLOG_CAR_OTHERREADY;
    public static final int PERFLOG_NAVI_APPREADY;
    public static final int PERFLOG_RADIO_AUDIOREADY;
    public static final int PERFLOG_MEDIA_AUDIOREADY;
    public static final int PERFLOG_VIEW_COMPOSITOR_INIT;
    public static final int PERFLOG_ASL_1;
    public static final int PERFLOG_ASL_2;
    public static final int PERFLOG_ASL_3;
    public static final int PERFLOG_ASL_4;
    public static final int PERFLOG_SPLASHSCREEN_FINISHED;
    public static final int PERFLOG_REPAINT_FIRST_SCREEN_START;
    public static final int PERFLOG_REPAINT_FIRST_SCREEN_DONE;
    public static final int PERFLOG_GFX_INIT_START;
    public static final int PERFLOG_GFX_INIT_DONE;
    public static final int PERFLOG_CODING_READ;
    public static final int PERFLOG_LUM_READY;
    public static final int PERFLOG_SKIN_READY;
    public static final int PERFLOG_FIRST_CONTEXT_SWITCH_PERFORMED;
    public static final int PERFLOG_START_APPS;
    public static final int PERFLOG_DESKTOP_APP_READY;
    public static final int PERFLOG_EVENT_DISPATCHER_START;
    public static final int PL_MODE_NONE;
    public static final int PL_MODE_PRELOAD;
    public static final int PL_MODE_LOAD;
    public static final int PL_MODE_PRECREATION;
    public static final int PL_MODE_CREATION;
    public static final int PL_MODE_PREINITIALIZE;
    public static final int PL_MODE_INITIALIZE;
    public static final int PL_MODE_START;
    public static final int PL_MODE_ACTIVATE;
    public static final int PL_MODE_UPDATE;
    public static final int PL_MODE_READY;
    public static final int PL_MODE_STOP;
    public static final int PL_MODE_COUNT;
    public static final int PL_STATE_NONE;
    public static final int PL_STATE_READY;
    public static final int PL_STATE_START;
    public static final int PL_STATE_DONE;
    public static final int PL_STATE_FAILED;
    public static final int PL_STATE_COUNT;
    public static final int PL_STARTUP_TYPE_I18N;
    public static final int PL_STARTUP_TYPE_DATAPOOL;
    public static final int PL_STARTUP_TYPE_STATEMACHINE;
    public static final int PL_STARTUP_TYPE_SKIN_V2VANIMS;
    public static final int PL_STARTUP_TYPE_SKIN_SKINANIMS;
    public static final int PL_STARTUP_TYPE_SKIN_IMAGES;
    public static final int PL_STARTUP_TYPE_DATAPOOL_OBJECT;
    public static final int PL_STARTUP_TYPE_DATAPOOL_BOOLEAN;
    public static final int PL_STARTUP_TYPE_DATAPOOL_FLOAT;
    public static final int PL_STARTUP_TYPE_DATAPOOL_INTEGER;
    public static final int PL_STARTUP_TYPE_DATAPOOL_LONG;
    public static final int PL_STARTUP_TYPE_SKIN_DATAPOOL;
    public static final int PL_STARTUP_TYPE_NONE;
    public static final int PL_STARTUP_MODE_NONE;
    public static final int PL_STARTUP_MODE_INITIALIZE;
    public static final int PL_STARTUP_MODE_LOADING;
    public static final int PL_STARTUP_MODE_PRELOADING;
    public static final int PL_STARTUP_MODE_START;
    public static final int PL_STARTUP_MODE_CREATION;
    public static final int PL_STARTUP_MODE_UPDATE;
    public static final int PL_STARTUP_ACTION_NONE;
    public static final int PL_STARTUP_ACTION_START;
    public static final int PL_STARTUP_ACTION_READY;
    public static final int PL_STARTUP_ACTION_FAILED;
    public static final int PL_STARTUP_ACTION_FINISHED;
    public static final int PL_VIEWHANDLER_LOAD_START;
    public static final int PL_VIEWHANDLER_LOAD_DONE;
    public static final int PL_VIEWHANDLER_LOAD_FAILED;
    public static final int PL_VIEWHANDLER_INIT_START;
    public static final int PL_VIEWHANDLER_INIT_DONE;
    public static final int PL_BUNDLE_PRELOAD_START;
    public static final int PL_BUNDLE_PRELOAD_DONE;
    public static final int PL_BUNDLE_PRELOAD_FAILED;
    public static final int PL_BUNDLE_START_START;
    public static final int PL_BUNDLE_START_DONE;
    public static final int PL_BUNDLE_START_FAILE;
    public static final int PL_TARGET_CREATION_START;
    public static final int PL_TARGET_CREATION_DONE;
    public static final int PL_TARGET_START_START;
    public static final int PL_TARGET_START_DONE;
    public static final int PL_PROFILE_ACTION_INITIAL;
    public static final int PL_PROFILE_ACTION_STARTED;
    public static final int PL_PROFILE_ACTION_DONE;
    public static final int PL_WORKUNIT_START;
    public static final int PL_WORKUNIT_DONE;
    public static final int PL_WORKUNIT_FAILED;
    public static final int APPUI_CREATE_START;
    public static final int APPUI_CREATE_DONE;
    public static final int APPUI_START_START;
    public static final int APPUI_START_DONE;
    public static final int APPUI_STOP_START;
    public static final int APPUI_STOP_DONE;
    public static final int APPUI_READY_START;
    public static final int APPUI_READY_DONE;

    default public void performanceLogMsg(String string) {
    }

    default public void performanceLogMsgByID(int n) {
    }

    default public boolean isPerformanceLogMsgSupported() {
    }

    default public PerfServiceData getPerfServiceData(PerfServiceData perfServiceData) {
    }

    default public boolean isPerfServiceDataSupported() {
    }

    default public void performanceLogDSI(String string, int n) {
    }

    default public void performanceLogDomain(int n, int n2, int n3) {
    }

    default public void performanceLogASLTarget(int n, int n2) {
    }

    default public void performanceLogContextSwitch(int[] nArray) {
    }

    default public void performanceLogRvcStateUpdate(boolean bl) {
    }

    default public void performanceLogViewHandler(String string, int n) {
    }

    default public void performanceLogViewHandler(String string, int n, int n2) {
    }

    default public void performanceLogStartup(int n, int n2, int n3) {
    }

    default public void performanceLogProfileChange(int n, byte by) {
    }

    default public void performanceLogProfileComponentChange(int n, String string, boolean bl) {
    }

    default public void performanceLogPersistence(int n, int n2) {
    }

    default public void performanceLogDiagnosis(int n, int n2) {
    }

    default public void performanceLogWorkunit(String string, int n) {
    }

    default public void performanceLogEvents(int n, int n2, String string) {
    }

    default public void performanceLogAppUiLife(int n, String string, String string2, int n2) {
    }
}

