/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.download;

public interface ASLDownloadSetter {
    public static final int START_SW_DOWNLOAD;
    public static final int RESTART_SYSTEM;
    public static final int SELECT_SOURCE;
    public static final int SELECT_SOURCE__P0_SELCTEDSOURCE__INT;
    public static final int SELECT_SOURCE__SELCTEDSOURCE__C0_SOURCE_CD;
    public static final int SELECT_SOURCE__SELCTEDSOURCE__C1_SOURCE_USB;
    public static final int SELECT_SOURCE__SELCTEDSOURCE__C2_SOURCE_SD;
    public static final int SELECT_SOURCE__SELCTEDSOURCE__C3_SOURCE_NW;
    public static final int SELECT_RELEASE;
    public static final int SELECT_RELEASE__P0_INDEX__INT;
    public static final int SELECT_DEVICE;
    public static final int SELECT_DEVICE__P0_INDEX__INT;
    public static final int SELECT_MODULE;
    public static final int SELECT_MODULE__P0_INDEX__INT;
    public static final int SELECT_FIRMWARE_PART;
    public static final int SELECT_FIRMWARE_PART__P0_INDEX__INT;
    public static final int SET_ONLINE_UPDATE_NAME;
    public static final int SET_ONLINE_UPDATE_NAME__P0_NAME__STRING;
    public static final int RETRY_READING_META_INFO;
    public static final int SET_DOWNLOAD_OPTION_SELECTED;
    public static final int SET_DOWNLOAD_OPTION_SELECTED__P0_SELECTEDOPTION__INT;
    public static final int SET_DOWNLOAD_OPTION_SELECTED__SELECTEDOPTION__C0_VERSION_NEWER;
    public static final int SET_DOWNLOAD_OPTION_SELECTED__SELECTEDOPTION__C1_VERSION_DIFFERENT;
    public static final int SET_DOWNLOAD_OPTION_SELECTED__SELECTEDOPTION__C2_VERSION_ANY;
    public static final int SELECT_LOG;
    public static final int SELECT_LOG__P0_INDEX__INT;
    public static final int SELECT_LOGGED_DEVICE;
    public static final int SELECT_LOGGED_DEVICE__P0_INDEX__INT;
    public static final int SELECT_LOGGED_MODULE;
    public static final int SELECT_LOGGED_MODULE__P0_INDEX__INT;
    public static final int USER_ABORT;
    public static final int USER_ABORT__P0_GRANULARITY__INT;
    public static final int USER_ABORT__GRANULARITY__C0_GRANULARITY_COMPLETE;
    public static final int USER_ABORT__GRANULARITY__C1_GRANULARITY_DEVICE;
    public static final int TOGGLE_DEFAULT_DOWNLOAD;
    public static final int TOGGLE_REGION_CHECK_ENABLED;
    public static final int POWER_STATE_SWDL_EXIT;
    public static final int PREPARE_INSTALLED_SW;
    public static final int EDIT_NW_ADDRESS;
    public static final int SET_NW_ADDRESS;
    public static final int SPELLER_DELETE_CHAR;
    public static final int SPELLER_SET_CHAR;
    public static final int SPELLER_SET_CHAR__P0_LETTER__STRING;
    public static final int SET_VERSION_BACK_DOCUMENTATION;
    public static final int SET_VERSION_BACK_DOCUMENTATION__P0_FLAG__BOOLEAN;
    public static final int TRIGGER_CUSTOMER_DOWNLOAD;
    public static final int ENTER_LOGGING;
    public static final int EXIT_LOGGING;
    public static final int SET_POPUP_TYPE;
    public static final int SET_POPUP_TYPE__P0_POPUPTYPE__INT;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C0_POPUPTYPES_NO_POPUP;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C1_POPUPTYPES_CLIENT_ERROR;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C2_POPUPTYPES_DEAD_DEVICE;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C3_POPUPTYPES_DEVICES_NOT_RECONNECTED;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C4_POPUPTYPES_DOWNLOAD_TERMINATED;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C5_POPUPTYPES_ERROR_IMPORT_DATA;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C6_POPUPTYPES_ERROR_MOST_NOT_AVAILABLE;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C7_POPUPTYPES_ERROR_READ_METAINFO;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C8_POPUPTYPES_FILE_ERROR;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C9_POPUPTYPES_SWITCH_MEDIUM;
    public static final int SET_POPUP_TYPE__POPUPTYPE__C10_POPUPTYPES_UNEXPECTED_RESTART;
    public static final int SET_POPUP_TYPE_BUTTON;
    public static final int SET_POPUP_TYPE_BUTTON__P0_POPUPTYPEBUTTON__INT;
    public static final int SET_POPUP_TYPE_BUTTON__POPUPTYPEBUTTON__C0_POPUPTYPES_BUTTTON_OK;
    public static final int SET_POPUP_TYPE_BUTTON__POPUPTYPEBUTTON__C1_POPUPTYPES_BUTTON_CANCEL;
    public static final int SET_POPUP_TYPE_BUTTON__POPUPTYPEBUTTON__C2_POPUPTYPES_BUTTON_RETRY;
    public static final int SET_POPUP_TYPE_BUTTON__POPUPTYPEBUTTON__C3_POPUPTYPES_BUTTON_ABORT;
    public static final int SELECT_ALL;
    public static final int DESELECT_ALL;
    public static final int REBOOT_AFTER_BACK_DOCUMENTATION;
    public static final int REBOOT_AFTER_BACK_DOCUMENTATION2;
    public static final int SET_SELECT_SOURCE_VIEW_STATE;
    public static final int SET_SELECT_SOURCE_VIEW_STATE__P0_FLAG__BOOLEAN;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE__P0_CUSTOMER_DOWNLOAD_STATE__INT;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE__CUSTOMER_DOWNLOAD_STATE__C0_NO_STATE;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE__CUSTOMER_DOWNLOAD_STATE__C1_MEDIA_REMOVED_PERFORMING;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE__CUSTOMER_DOWNLOAD_STATE__C2_MEDIA_REMOVED_NOT_PERFORMING;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE__CUSTOMER_DOWNLOAD_STATE__C3_MEDIA_AVAILABLE_NOT_PERFORMING;
    public static final int SET_CUSTOMER_DOWNLOAD_STATE__CUSTOMER_DOWNLOAD_STATE__C4_MEDIA_AVAILABLE_PERFORMING;
    public static final int ABORT_CUSTOMER_DOWNLOAD;
    public static final int CUSTOMER_DOWNLOAD_REBOOT;
    public static final int CUSTOMER_DOWNLOAD_FINISHED_OK_BUTTON_PRESSED;
    public static final int TOGGLE_ETHERNET_NFS;
    public static final int TOGGLE_ETHERNET_CIFS;
    public static final int POPUP_CUSTOMER_DOWNLOAD_AFTER_REBOOT_ACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_AFTER_REBOOT_DEACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_FINISHED_ACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_FINISHED_DEACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_FINISHED_ERROR_ACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_FINISHED_ERROR_DEACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_PROCESS_ERROR_ACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_PROCESS_ERROR_DEACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_RESTART_ACTIVATED;
    public static final int POPUP_CUSTOMER_DOWNLOAD_RESTART_DEACTIVATED;
    public static final int ABORT_SET_MEDIUM;
    public static final int LEAVE_STATE_WITH_ABORT;
    public static final int LEAVE_STATE_WITH_ABORT__P0_STATE__INT;
    public static final int LEAVE_STATE_WITH_ABORT__STATE__C0_RELEASE_INFO_ABORT;
    public static final int LEAVE_STATE_WITH_ABORT__STATE__C1_DEVICE_INFO_ABORT;
    public static final int LEAVE_STATE_WITH_ABORT__STATE__C2_MODUL_INFO_ABORT;
    public static final int LEAVE_STATE_WITH_ABORT__STATE__C3_MODUL_DATA_ABORT;
}

