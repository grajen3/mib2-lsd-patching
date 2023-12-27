/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.logmanager;

import java.util.HashMap;
import java.util.Map;

final class LogClassifierNames {
    private final int[] classifierIds = new int[]{128, 1, 2, 3, 4, 5, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512, 1024, 2048, 4096, 8192, 16384, 0xA004000, 32768, 0x1008000, 335577088, 503349248, 0x28008000, 687898624, 838893568, 1006665728, 1174437888, 0x50008000, 1509982208, 1, 2, 4, 8, 16, 32, 64};
    private String[] classifierNames;
    private Map subClassifierNames;
    private Map subClassifierIds;

    LogClassifierNames() {
    }

    private String[] createClassifierNames() {
        return new String[]{"APPS", "ASL", "BAP", "CIO", "CONFIGURATION", "ASI", "DATAPOOL", "DSI", "ERROR_HANDLER", "EVENTS", "GENERIC_EVENTS", "GRAPHICS", "LOGGING", "LSC", "RESOURCES", "SPEECH", "SPI", "STARTUP", "STATEMACHINE", "THREADMANAGER", "TIMER", "VIEWS", "WIDGETS", "TOOLS", "ASLMOCKUPS", "COMMON", "CAR", "ASL2", "ASL_FRAMEWORK", "ASL_MEDIA", "NAV", "ASL_RADIO", "RADIO", "ASL_ONLINE", "ASL_PHONE", "ASL_SMARTPHONE", "ASL_SYSTEM", "ASL_WEBRADIO", "ANIMATION", "KOMBI_PICTURE_SERVER", "PERFORMANCE", "VE", "MOST_KOMBI", "SKIN", "DEBUG"};
    }

    private String[] createSubClassifierNames(int n) {
        String[] stringArray;
        switch (n) {
            case -2147483648: {
                stringArray = new String[]{"ASSEMBLY", "LIFECYCLE", "FACTORY", "MANAGER", "DESKTOP", "CONTENT", "UI", "ADAPTER", "INTENTS", "ADAPTER_PROXY"};
                break;
            }
            case 1: {
                stringArray = new String[]{"STARTUP", "HSM", "PHONE", "ORGANIZER", "AM_SOUND", "PERSISTENCE", "TESTMODE", "RADIO_AMFM", "RADIO_DAB", "RADIO_SDARS", "MEDIA", "SYSTEM", "DISPLAY", "RADIO_ANNOUNCEMENT", "NAVI", "NAVI_BAP", "NAVI_MAP", "NAVI_POI", "SPEECH_INPUT", "SPEECH_OUTPUT", "SWDL", "DEBUG_DSI", "DIAGNOSTIC", "GENERAL", "CAR", "LIST", "DSI_PROXY", "MEDIACONTROL", "NAVI_TMC", "MEDIA_BROWSER", "MEDIA_PLAYER", "MEDIA_SOURCES"};
                break;
            }
            case 2: {
                stringArray = new String[]{"ACTIVATOR", "DISPATCHER", "DATAPOOL", "AUDIO_SD", "NAV_SD", "TELEPHONE", "MFL", "TELEPHONE2", "OCU_ENI", "OCU_ECALL", "SDS_SD"};
                break;
            }
            case 3: {
                stringArray = new String[]{"DICTIONARY", "DISPATCHER", "FACTORY", "VISUALIZATION"};
                break;
            }
            case 4: {
                stringArray = new String[]{"STARTUP", "PROPERTIES", "AMBIENCELIGHT"};
                break;
            }
            case 5: {
                stringArray = new String[]{"ADAPTER"};
                break;
            }
            case 8: {
                stringArray = new String[]{"STARTUP", "FIXFORMAT", "PROPERTIES", "ASL_DATAPOOL", "ASL_GETTER_MANAGER", "MODEL_DATAPOOL", "LIST_ITEM_CONTROL", "GET_PROPERTY", "SET_PROPERTY", "ALL", "PRIMITIVES", "OBJECTS", "BOOLEAN", "INTEGER"};
                break;
            }
            case 16: {
                stringArray = new String[]{"AUDIO", "BAP", "CAR", "GENERAL", "INFOTAINMENT", "MEDIA", "NAVI", "ONLINE", "ORGANIZER_PHONE", "SPEECH", "SWDL_SWAP", "SYSTEM", "TUNER", "CAR_TIME_UNITS_LANGUAGE", "GENERAL_VEHICLE_STATES", "EXBOXM", "SFA", "MIRRORLINK", "HAS", "CAR_PARKING", "CAR_BORDCOMPUTER", "CAR_FPA", "CAR_CLIMATE", "CAR_BATTERY"};
                break;
            }
            case 32: {
                stringArray = new String[]{"ERROR", "DSI_ERROR", "STARTUP_ERROR", "DUMP", "SCRIPT_ERROR", "STATEMACHINE_ERROR", "VIEW_ERROR", "HIGHLOAD_DETECTION"};
                break;
            }
            case 64: {
                stringArray = new String[]{"DISPATCHER", "DISPATCHING_THREAD", "FACTORY", "STARTUP_DISPATCHING_THREAD", "DISPATCHER_MANAGER", "FRAMEWORK_DISPATCHER", "PROPERTY_UPDATE_DISPATCHER", "STARTUP_DISPATCHER", "STATEMACHINE_DISPATCHER", "SYSTEM_DISPATCHER", "VIEW_DISPATCHER", "DATAPOOL_DISPATCHER", "EVENT_QUEUE", "PERFORMANCE_TESTING"};
                break;
            }
            case 128: {
                stringArray = new String[]{"GENERAL", "TIMER", "EVENTDISPATCHER", "SERVICEREGISTER", "TASK", "HSM", "POOL", "EVENT_QUEUE", "PERFORMANCE_TESTING"};
                break;
            }
            case 256: {
                stringArray = new String[]{"DISPLAY_MANAGER", "FONT_MANAGER", "FONT_KERNEDRASTERFONT", "FONT_GLYPH_CACHE", "FONT_TEXTLAYOUT", "FONT_TEXTLAYOUT_CACHE", "GRAPHICS_MANAGER", "GRAPHICS_SURFACE", "GRAPHICS_CONTEXT", "GRAPHICS_FRAMEBUFFER", "GRAPHICS_GEOMETRYBUFFER", "GRAPHICS_MESH", "GRAPHICS_MESHHEAP", "GRAPHICS_TEXTURE", "GRAPHICS_TEXTUREATLAS", "GRAPHICS_SHADER", "GRAPHICS_EFFECT", "GRAPHICS_RENDERER", "GRAPHICS_DRAWABLE", "GRAPHICS_MODEL", "GRAPHICS_LOADER", "IMAGE_MANAGER", "IMAGE_CACHE", "IMAGE_SKIN_LOADER", "IMAGE_SKIN_PRELOADER", "IMAGE_DYNAMIC_LOADER", null, null, null, null, "DEBUG", "PERFORMANCE"};
                break;
            }
            case 512: {
                stringArray = new String[]{"LOGMANAGER", "HEARTBEAT", "MAINLOGGER", "INVOCATION_CONTEXT"};
                break;
            }
            case 1024: {
                stringArray = new String[]{"ACTIVATOR", "CONTROLLER", "MEDIATOR", "COORDINATOR", null, null, null, null, null, null, "CHANGER", "LANGCHANGER", "SKINCHANGER", "MODECHANGER", "GUI_LISTENER", null, null, null, null, null, "CLASSLOADER", null, null, null, null, null, null, null, null, null, "BULLHORN"};
                break;
            }
            case 2048: {
                stringArray = new String[]{"FILE", "OBJECT_SWAPPER", "XIP_CONTAINER", "CONTENT_FILE", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "PERFORMANCE"};
                break;
            }
            case 4096: {
                stringArray = new String[]{"SD_FEATURE_COLLECTION", "SPEECH_SYNTAX", "SPEECH_MOCKUP", "SPEECH_ASL", "SPEECH_DIALOG_MANAGER", "SPEECH_DIAGNOSIS", "SPEECH_PLUGIN", "SPEECH_ASL_RULELOADING", "SPEECH_ASL_SLOTLISTS", "SPEECH_ASL_INPUT", "SPEECH_ASL_OUTPUT", "SPEECH_ASL_AUDIO", "SPEECH_GENERAL", "SPEECH_MEDIA", "SPEECH_NAVIGATION", "SPEECH_TUNER", "SPEECH_PHONE", "SPEECH_TELEPROMPTER"};
                break;
            }
            case 8192: {
                stringArray = new String[]{"DEBUG", "EXTENDED_STARTUP", "FILE", "FONT", "IMAGE", "TIMER"};
                break;
            }
            case 16384: {
                stringArray = new String[]{"LAUNCHER", "OSGI", "STARTUPMANAGER", "REMOTE_BUNDLE", "CONTEXT_STARTUP", "ASL_STARTUP_DELAYED", "CLASS_PRELOADER"};
                break;
            }
            case 32768: {
                stringArray = new String[]{"JOURNAL", "JOURNAL_DEBUG", "STARTUP", "WAITSTATE", "PROBLEM_REPORT"};
                break;
            }
            case 65536: {
                stringArray = new String[]{"RUNNABLE", "THREAD", "THREAD_MANAGER", "WATCHDOG", "THREAD_ERROR_HANDLER", "THREAD_CONFIGURATION"};
                break;
            }
            case 131072: {
                stringArray = new String[]{"TIMER", "TIMER_THREAD", "TIMER_MANAGER"};
                break;
            }
            case 262144: {
                stringArray = new String[]{"STARTUP", "VIEW", "POPUP", "VIEW2VIEW", "VIEWCOMPOSITOR", "LIST_ITEM_CONTROL", "SCRIPT", "SMARTVIEWHANDLER", "POPUPENTRY", "REPAINTMANAGER", "DESKTOP", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "DUMP", "PERFORMANCE"};
                break;
            }
            case 524288: {
                stringArray = new String[]{"GENERAL", "TEXT", "IMAGE", "BUTTON", "SLIDER", "LIST", "SPELLER", "CAR", "NAVIGATION", "SPECIAL", "VIEW", "REPAINT", "SWYS", "ANIMATION", "LAYOUT", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "DEBUG", "PERFORMANCE"};
                break;
            }
            case 0x100000: {
                stringArray = new String[]{"OTHER", "DSIDELTAWRAPPER", "DSISIMULATOR", "DSIREMOTE", "HMIMONITOR", "DEBUGINTERFACE", "DSIMOCKUPS", "DSITRACER", "DEBUGSPI", "DEBUGPROBES"};
                break;
            }
            case 0x200000: {
                stringArray = new String[]{"STARTUP", "HSM", "DIAGNOSE", "LSC"};
                break;
            }
            case 0x400000: {
                stringArray = new String[]{"SOUND", "ASIA_INPUT", "SPELLER_CONTROLLER"};
                break;
            }
            case 0x40000A: {
                stringArray = new String[]{"ASL_CAR", "ASL_CAR_BATTERY", "ASL_CAR_CLIMATE", "ASL_CAR_PARKING", "ASL_CAR_SERVICE", "ASL_CAR_VIEWOPTIONS", "CAR_APP_CLIMATE", "CAR_APP_CLIMATE_BAR", "CAR_APP_SEATMENU", "CAR_APP_CAR_BAR", "CAR_APP_CAR", "CAR_APP_PERSONALIZATION_SETUP_PAGE", "CAR_APP_CAR_AMBIENCELIGHT"};
                break;
            }
            case 0x800000: {
                stringArray = new String[]{"CONNECTIVITY", "TV_TUNER", "SOURCE_CHANGE", "EXBOXM", "ENTERTAINMENT_MANAGER", "NAVI_GUIDANCE", "ASIA_INPUT", "PICTUREVIEWER", "FILEBROWSER", "INTERNETBROWSER", "MIRRORLINK", "SFA", "KEYPANEL", "ITUNES", "ONLINE_SERVICES", "HAS", "RADIO_STATE", "CAR_PARKING", "CAR_SERVICE", "CAR_CLIMATE", "CAR_VIEWOPTIONS", "CAR_BATTERY", "MEDIA_RECORDER", "MEDIA_SOUND", "DEVICE_HANDLING", "TRAVELLINK_MAIN", "TRAVELLINK_FUEL", "TRAVELLINK_MOVIES", "TRAVELLINK_SKI", "TRAVELLINK_SPORTS", "TRAVELLINK_WEATHER", "TRAFFICMINIMAP"};
                break;
            }
            case 0x800001: {
                stringArray = new String[]{"CORE", "LIST", "HSM", "DSI_PROXY", "HAS"};
                break;
            }
            case 8388628: {
                stringArray = new String[]{"MEDIA", "AM_SOUND", "DEVICE_HANDLING", "ENTERTAINMENT_MANAGER", "ITUNES", "MEDIA_BROWSER", "MEDIA_PLAYER", "MEDIA_RECORDER", "MEDIA_SOUND", "MEDIA_SOURCES", "PICTUREVIEWER", "SOURCE_CHANGE", "TV_TUNER"};
                break;
            }
            case 8388638: {
                stringArray = new String[]{"ASL_NAVI", "ASL_NAVI_BAP", "ASL_NAVI_GUIDANCE", "ASL_NAVI_MAP", "ASL_NAVI_POI", "ASL_NAVI_TMC", "APP_NAV", "APP_NAV_SETUP_WIZARD", "APP_NAV_MAP_TILE", "APP_NAV_INFO_TILE"};
                break;
            }
            case 0x800028: {
                stringArray = new String[]{"RADIO_AMFM", "RADIO_ANNOUNCEMENT", "RADIO_DAB", "RADIO_SDARS", "RADIO_PERSISTENCE", "RADIO_STATE", "RADIO_TEXT", "TRAVELLINK_MAIN", "TRAVELLINK_FUEL", "TRAVELLINK_MOVIES", "TRAVELLINK_SKI", "TRAVELLINK_SPORTS", "TRAVELLINK_WEATHER", "SCAN", "STATION_LOGO", "CURRENT_STATION", "TUNE_STATION", "SETTINGS_PERSISTENCE", "AUDIO_CONNECTION", "DAB_VISIBLE_BANK_SETTING", "DAB_MANUAL_STEPS", "SELECTED_PRESET_INDEX", "SPEECH", "TUNE_SERVICE", "DAB_AUTO_COMPARE", "ENTERTAINMENTMANAGER", "STATION_LIST_FM", "DB_STATION_ID", "STATION_LIST_FM_COLLECTOR", "FILL_SPEECH_LIST_FOR_FM", "FILL_SPEECH_LIST_FOR_DAB"};
                break;
            }
            case 8388649: {
                stringArray = new String[]{"UNIFIED_RADIO_MAIN", "UNIFIED_RADIO_LIST", "UNIFIED_RADIO_PRESETS", "UNIFIED_RADIO_PERSISTENCE", "UNIFIED_RADIO_RADIOTEXT", "UNIFIED_RADIO_SCAN", "UNIFIED_RADIO_SETTINGS"};
                break;
            }
            case 8388658: {
                stringArray = new String[]{"ONLINE_SERVICES", "INTERNETBROWSER", "TRAFFICMINIMAP"};
                break;
            }
            case 8388668: {
                stringArray = new String[]{"PHONE", "CONNECTIVITY", null, "ORGANIZER"};
                break;
            }
            case 8388678: {
                stringArray = new String[]{"ANDROID_AUTO", "CAR_PLAY", "MIRRORLINK", "SMARTPHONE_INTEGRATION"};
                break;
            }
            case 0x800050: {
                stringArray = new String[]{"SYSTEM", "ASIA_INPUT", "DIAGNOSE", "DISPLAY", "EXBOXM", "FILEBROWSER", "KEYPANEL", "PERSISTENCE", "STARTUP", "SWDL", "TESTMODE"};
                break;
            }
            case 8388698: {
                stringArray = new String[]{"MAIN", "PRESETS", "LIST", "SEARCH", "DB_RADIO_DATA", "SLIDESHOW"};
                break;
            }
            case 0x1000000: {
                stringArray = new String[]{"ANIMATION_MANAGER", "ANIMATION_EASING", "ANIMATION_KEYFRAME"};
                break;
            }
            case 0x2000000: {
                stringArray = new String[]{"STARTUP", "TUNER", "PHONE", "MEDIA"};
                break;
            }
            case 0x4000000: {
                stringArray = new String[]{"LIFE_PERFORMANCE_TRACE", "COLLECTIONS"};
                break;
            }
            case 0x8000000: {
                stringArray = new String[]{"ML_PROTOTYPING", "EXLAP_SERVER", "VE718_HOMESCREEN"};
                break;
            }
            case 0x10000000: {
                stringArray = new String[]{"NAV_INFO", "NAV_VIEW", "STREAM_SINK"};
                break;
            }
            case 0x20000000: {
                stringArray = new String[]{};
                break;
            }
            case 0x40000000: {
                stringArray = new String[]{"INTERFACE", "MANAGER", "PROBES", "TRACE_MARKER"};
                break;
            }
            default: {
                stringArray = new String[]{};
            }
        }
        return stringArray;
    }

    private int[] createSubClassifierIds(int n) {
        int[] nArray;
        switch (n) {
            case -2147483648: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
                break;
            }
            case 1: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 1, 2, 4, 8, 16, 32, 64, 128};
                break;
            }
            case 2: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
                break;
            }
            case 3: {
                nArray = new int[]{1, 2, 4, 8};
                break;
            }
            case 4: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 5: {
                nArray = new int[]{1};
                break;
            }
            case 8: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
                break;
            }
            case 16: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};
                break;
            }
            case 32: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
                break;
            }
            case 64: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
                break;
            }
            case 128: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
                break;
            }
            case 256: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 1, 2, -1, -1, -1, -1, 64, 128};
                break;
            }
            case 512: {
                nArray = new int[]{1, 2, 4, 8};
                break;
            }
            case 1024: {
                nArray = new int[]{1, 2, 4, 8, -1, -1, -1, -1, -1, -1, 1024, 2048, 4096, 8192, 16384, -1, -1, -1, -1, -1, 4096, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64};
                break;
            }
            case 2048: {
                nArray = new int[]{1, 2, 4, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 128};
                break;
            }
            case 4096: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512};
                break;
            }
            case 8192: {
                nArray = new int[]{1, 2, 4, 8, 16, 32};
                break;
            }
            case 16384: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64};
                break;
            }
            case 32768: {
                nArray = new int[]{1, 2, 4, 8, 16};
                break;
            }
            case 65536: {
                nArray = new int[]{1, 2, 4, 8, 16, 32};
                break;
            }
            case 131072: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 262144: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, 128};
                break;
            }
            case 524288: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, 128};
                break;
            }
            case 0x100000: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
                break;
            }
            case 0x200000: {
                nArray = new int[]{1, 2, 4, 8};
                break;
            }
            case 0x400000: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 0x40000A: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
                break;
            }
            case 0x800000: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 1, 2, 4, 8, 16, 32, 64, 128};
                break;
            }
            case 0x800001: {
                nArray = new int[]{1, 2, 4, 8, 16};
                break;
            }
            case 8388628: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
                break;
            }
            case 8388638: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
                break;
            }
            case 0x800028: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0x800000, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 1, 2, 4, 8, 16, 32, 64};
                break;
            }
            case 8388649: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64};
                break;
            }
            case 8388658: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 8388668: {
                nArray = new int[]{1, 2, -1, 8};
                break;
            }
            case 8388678: {
                nArray = new int[]{1, 2, 4, 8};
                break;
            }
            case 0x800050: {
                nArray = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
                break;
            }
            case 8388698: {
                nArray = new int[]{1, 2, 4, 8, 16, 32};
                break;
            }
            case 0x1000000: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 0x2000000: {
                nArray = new int[]{1, 2, 4, 8};
                break;
            }
            case 0x4000000: {
                nArray = new int[]{1, 2};
                break;
            }
            case 0x8000000: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 0x10000000: {
                nArray = new int[]{1, 2, 4};
                break;
            }
            case 0x20000000: {
                nArray = new int[]{};
                break;
            }
            case 0x40000000: {
                nArray = new int[]{1, 2, 4, 8};
                break;
            }
            default: {
                nArray = new int[]{};
            }
        }
        return nArray;
    }

    int[] getClassifierIds() {
        return this.classifierIds;
    }

    String[] getClassifierNames() {
        if (this.classifierNames == null) {
            this.classifierNames = this.createClassifierNames();
        }
        return this.classifierNames;
    }

    String[] getSubClassifierNames(int n) {
        String[] stringArray;
        Integer n2 = new Integer(n);
        if (this.subClassifierNames == null) {
            this.subClassifierNames = new HashMap();
        }
        if ((stringArray = (String[])this.subClassifierNames.get(n2)) == null) {
            stringArray = this.createSubClassifierNames(n);
            this.subClassifierNames.put(n2, stringArray);
        }
        return stringArray;
    }

    int[] getSubClassifierIds(int n) {
        int[] nArray;
        Integer n2 = new Integer(n);
        if (this.subClassifierIds == null) {
            this.subClassifierIds = new HashMap();
        }
        if ((nArray = (int[])this.subClassifierIds.get(n2)) == null) {
            nArray = this.createSubClassifierIds(n);
            this.subClassifierIds.put(n2, nArray);
        }
        return nArray;
    }
}

