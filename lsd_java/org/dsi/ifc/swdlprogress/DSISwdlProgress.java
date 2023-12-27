/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlprogress;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlProgress
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_GENERALPROGRESS;
    public static final int ATTR_DEVICESOVERVIEWPROGRESS;
    public static final int ATTR_TRIGGERPANEL;
    public static final int ATTR_LOSTDEVICES;
    public static final int ATTR_OVERVIEWSTATUS;
    public static final int ATTR_ACTIVEDEVICES;
    public static final int PROGRESSSTATUS_NOT_INITIALIZED;
    public static final int PROGRESSSTATUS_NONE;
    public static final int PROGRESSSTATUS_READ_BLOCK;
    public static final int PROGRESSSTATUS_ERASE_FLASH;
    public static final int PROGRESSSTATUS_PROGRAM_FLASH;
    public static final int PROGRESSSTATUS_CALCULATE_CHECKSUM;
    public static final int PROGRESSSTATUS_OPEN_FILE;
    public static final int PROGRESSSTATUS_CLOSE_FILE;
    public static final int PROGRESSSTATUS_USERINFO_TEXT;
    public static final int PROGRESSSTATUS_COPY_FILES;
    public static final int PROGRESSSTATUS_WAIT_FOR_DEVICES_AFTER_UNLOCK;
    public static final int PROGRESSSTATUS_WAIT_FOR_DEVICES_AFTER_UNLOCK_DURING_FLASHTIMEOUT;
    public static final int PROGRESSSTATUS_REPORT_UNLOCK;
    public static final int PROGRESSSTATUS_OPEN_FILE_ANIMATED_DOTS;
    public static final int PROGRESSSTATUS_SWITCH_TO_DOWNLOAD_MODE;
    public static final int PROGRESSSTATUS_DEVICE_REBOOTS;
    public static final int PROGRESSSTATUS_CONTACTING_DEVICE;
    public static final int PROGRESSSTATUS_DELAY_CONTACTING_DEVICE;
    public static final int PROGRESSSTATUS_START_APPLICATIONS;
    public static final int PROGRESSSTATUS_SET_UPDATE_DEVICE;
    public static final int PROGRESSSTATUS_WAIT_FOR_LATE_RECONNECTING;
    public static final int PROGRESSSTATUS_WAIT_FOR_RECONNECTING;
    public static final int PROGRESSSTATUS_FLASHTIMEOUT;
    public static final int FILEACCESSERROR_NOT_INITIALIZED;
    public static final int FILEACCESSERROR_OPEN;
    public static final int FILEACCESSERROR_READ;
    public static final int FILEACCESSERROR_CRC;
    public static final int FILEACCESSERROR_INVALID_HANDLE;
    public static final int FILEACCESSERROR_DECOMPRESS;
    public static final int FILEACCESSERROR_SEEK;
    public static final int FILEACCESSERROR_ACCESS;
    public static final int FILEACCESSERROR_BAD_FILESYSTEM;
    public static final int FILEACCESSERROR_NAME_TOO_LONG;
    public static final int FILEACCESSERROR_NO_ENTRY;
    public static final int FILEACCESSERROR_NO_MEMORY;
    public static final int FILEACCESSERROR_NO_SYSTEM;
    public static final int FILEACCESSERROR_NO_DIRECTORY;
    public static final int FILEACCESSERROR_EJECT;
    public static final int FILEACCESSERROR_OTHER;
    public static final int FILEACCESSERROR_TIMEOUT_OPEN;
    public static final int FILEACCESSERROR_TIMEOUT_READ;
    public static final int USERSELECTION_SELECTED_NOT_INITIALIZED;
    public static final int USERSELECTION_SELECTED_ABORT_DEVICE;
    public static final int USERSELECTION_SELECTED_ABORT_COMPLETLY;
    public static final int USERSELECTION_SELECTED_RETRY;
    public static final int USERSELECTION_SELECTED_CANCEL;
    public static final int USERSELECTION_SELECTED_CONTINUE;
    public static final int USERSELECTION_SELECTED_OK;
    public static final int TRIGGER_TRIGGER_NOT_INITIALIZED;
    public static final int TRIGGER_TRIGGER_REBOOT;
    public static final int TRIGGER_TRIGGER_SUMMARY;
    public static final int TRIGGER_TRIGGER_READING_METAINFO;
    public static final int PROGRESSTYPE_UNKNOWN;
    public static final int PROGRESSTYPE_PROGRESS;
    public static final int PROGRESSTYPE_TIMEOUT;
    public static final int RT_GETPROGRESSDETAILS;
    public static final int RT_HANDLEUSERSELECTION;
    public static final int RT_HANDLEMEDIUMSELECTION;
    public static final int RP_GETSTATICPROGRESSDETAILS;
    public static final int RP_GETDYNAMICPROGRESSDETAILS;
    public static final int IN_INDICATEPOPUP;
    public static final int IN_INDICATEDISMISSPOPUP;

    default public void getProgressDetails(String string) {
    }

    default public void handleUserSelection(int n, String string, int n2) {
    }

    default public void handleMediumSelection(int n, String string, byte by, int n2) {
    }
}

