/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdldeviceinfo;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlDeviceInfo
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SUMMARYCHANGED;
    public static final int UPDATEAMOUT_NOT_INITIALIZED;
    public static final int UPDATEAMOUT_YES;
    public static final int UPDATEAMOUT_NO;
    public static final int UPDATEAMOUT_NOT_EXISTING;
    public static final int UPDATEAMOUT_NOT_AVAILABLE;
    public static final int UPDATEAMOUT_PARTIAL;
    public static final int UPDATEAMOUT_INCOMPATIBLE;
    public static final int UPDATEAMOUT_ERROR;
    public static final int UPDATEAMOUT_CORRUPTED;
    public static final int UPDATEAMOUT_NOT_ACTIVATED;
    public static final int UPDATEAMOUT_CHECK_TIMEOUT;
    public static final int UPDATEAMOUT_COMPONENT_NOT_REGISTERED;
    public static final int UPDATEAMOUT_PACKET_ERROR;
    public static final int UPDATEAMOUT_RESULT_ERROR;
    public static final int UPDATEAMOUT_DOWNGRADE;
    public static final int UPDATEAMOUT_GROUP_ERROR;
    public static final int SUMMARYRESULT_NOT_INITIALIZED;
    public static final int SUMMARYRESULT_NO_UPDATE;
    public static final int SUMMARYRESULT_SUCCESS;
    public static final int SUMMARYRESULT_FAILED;
    public static final int SUMMARYRESULT_NEW_MODULE;
    public static final int SUMMARYRESULT_REMOVED_MODULE;
    public static final int DEVICEINFOACCESSTYPE_NOT_INITIALIZED;
    public static final int DEVICEINFOACCESSTYPE_SELECTION;
    public static final int DEVICEINFOACCESSTYPE_SUMMARY;
    public static final int DEVICEINFOACCESSTYPE_PRECONDITION;
    public static final int DEVICEINFOACCESSTYPE_POSTCONDITION;
    public static final int DETAILEDSUMMARYTYPES_NOT_INITIALIZED;
    public static final int DETAILEDSUMMARYTYPES_REMOVED_MODULE;
    public static final int DETAILEDSUMMARYTYPES_INTERNAL_ERROR_EXPECTED_VERSION_IS_SET;
    public static final int DETAILEDSUMMARYTYPES_NEW_MODULE_VERSION;
    public static final int DETAILEDSUMMARYTYPES_NO_UPDATE;
    public static final int DETAILEDSUMMARYTYPES_CDVERSION_0_UNEXPECTED_UPDATE;
    public static final int DETAILEDSUMMARYTYPES_CDVERSION_0;
    public static final int DETAILEDSUMMARYTYPES_NO_UPDATE_VERSION_UNCHANGED;
    public static final int DETAILEDSUMMARYTYPES_NO_UPDATE_VERSION_CHANGED;
    public static final int DETAILEDSUMMARYTYPES_NEW_MODULE_UPDATE_OK;
    public static final int DETAILEDSUMMARYTYPES_UPDATE_OK;
    public static final int DETAILEDSUMMARYTYPES_NEW_MODULE_UPDATE_FROM_0_OK;
    public static final int DETAILEDSUMMARYTYPES_UPDATE_FROM_0_OK;
    public static final int DETAILEDSUMMARYTYPES_MISSING;
    public static final int DETAILEDSUMMARYTYPES_UNEXPECTED_UPDATE;
    public static final int DETAILEDSUMMARYTYPES_INTERNAL_ERROR;
    public static final int DETAILEDSUMMARYTYPES_NONE;
    public static final int ERROR_NOT_INITIALIZED;
    public static final int ERROR_USER_ABORTED_THIS_DEVICE;
    public static final int ERROR_USER_ABORTED_COMPLETLY;
    public static final int ERROR_USER_ABORTED_AFTER_DEVICEERROR;
    public static final int ERROR_USER_RETRIED_AFTER_DEVICEERROR;
    public static final int ERROR_USER_ABORTED_AFTER_SWITCH_MEDIUM;
    public static final int ERROR_USER_RETRIED_AFTER_SWITCH_MEDIUM;
    public static final int ERROR_USERABORTED_AFTER_EXPORT_DATA;
    public static final int ERROR_USER_RETRIED_AFTER_EXPORT_DATA;
    public static final int ERROR_USER_ABORTED_AFTER_IMPORT_DATA;
    public static final int ERROR_USER_RETRIED_AFTER_IMPORT_DATA;
    public static final int ERROR_USER_ABORTED_AFTER_READ_METAINFO;
    public static final int ERROR_USER_RETRIED_AFTER_READ_METAINFO;
    public static final int ERROR_BEM_HIGHLY_CRITICAL;
    public static final int ERROR_BEM_MEDIUM_CRITICAL;
    public static final int ERROR_BEM_BACK_TO_UNCRITICAL;
    public static final int ERROR_DEVICE_NOT_IN_DLMODE;
    public static final int ERROR_DEVICE_DEAD;
    public static final int ERROR_DEVICE_NOTFIES_TOO_LATE;
    public static final int ERROR_DEVICE_IS_ALIVE;
    public static final int ERROR_DEVICE_ABORT_MAX_TIME;
    public static final int ERROR_CD_ERROR_RETRY;
    public static final int ERROR_CD_ERROR_CRC_MISSING_RETRY;
    public static final int ERROR_CD_ERROR_INTERNAL_RETRY;
    public static final int ERROR_CD_ERROR_CRC_FAILED_RETRY;
    public static final int ERROR_CD_ERROR_FS_NO_DATA_CD_RETRY;
    public static final int ERROR_CD_ERROR_FS_NO_CD_RETRY;
    public static final int ERROR_CD_ERROR_FS_UNLOAD_RETRY;
    public static final int ERROR_CD_ERROR_FS_DRIVE_ERROR_RETRY;
    public static final int ERROR_CD_ERROR_FS_NOT_READABLE_RETRY;
    public static final int ERROR_CD_ERROR_FS_NO_INFO_RETRY;
    public static final int ERROR_CD_ERROR_FS_INTERNAL_RETRY;
    public static final int ERROR_CD_ERROR_FS_FILE_NOT_FOUND_RETRY;
    public static final int ERROR_CD_ERROR_FS_DIR_NOT_FOUND_RETRY;
    public static final int ERROR_CD_ERROR_FS_UNKNOWN_RETRY;
    public static final int ERROR_CD_ERROR_ABORT;
    public static final int ERROR_CD_ERROR_CRC_MISSING_ABORT;
    public static final int ERROR_CD_ERROR_INTERNAL_ABORT;
    public static final int ERROR_CD_ERROR_CRC_FAILED_ABORT;
    public static final int ERROR_CD_ERROR_FS_NO_DATA_CD_ABORT;
    public static final int ERROR_CD_ERROR_FS_NO_CD_ABORT;
    public static final int ERROR_CD_ERROR_FS_UNLOAD_ABORT;
    public static final int ERROR_CD_ERROR_FS_DRIVE_ERROR_ABORT;
    public static final int ERROR_CD_ERROR_FS_NOT_READABLE_ABORT;
    public static final int ERROR_CD_ERROR_FS_NO_INFO_ABORT;
    public static final int ERROR_CD_ERROR_FS_INTERNAL_ABORT;
    public static final int ERROR_CD_ERROR_FS_FILE_NOT_FOUND_ABORT;
    public static final int ERROR_CD_ERROR_FS_DIR_NOT_FOUND_ABORT;
    public static final int ERROR_CD_ERROR_FS_UNKNOWN_ABORT;
    public static final int ERROR_CD_ERROR_FS_NO_CD_AUTO_RETRY;
    public static final int ERROR_CD_ERROR_FS_FILE_NOT_FOUND_AUTORETRY;
    public static final int ERROR_ERROR_INIT_INFLATE_RETRY;
    public static final int ERROR_ERROR_INIT_INFLATE_ABORT;
    public static final int ERROR_ERROR_CD_TIMEOUT_READING_RETRY;
    public static final int ERROR_ERROR_CD_TIMEOUT_OPENIN_GRETRY;
    public static final int ERROR_ERROR_CD_TIMEOUT_READING_ABORT;
    public static final int ERROR_ERROR_CD_TIMEOUT_OPENING_ABORT;
    public static final int ERROR_CD_ERROR_FS_FILE_NOTOPENRETRY;
    public static final int ERROR_CD_ERROR_FS_FILE_NOTOPENABORT;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_NOINFORETRY;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_NOINFOABORT;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_GENERALRETRY;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_GENERALABORT;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_RETRY;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_ABORT;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNRETRY;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNABORT;
    public static final int ERROR_CD_ERROR_FS_SEEK_RETRY;
    public static final int ERROR_CD_ERROR_FS_SEEK_ABORT;
    public static final int ERROR_SERVER_NOTAVAILABLERETRY;
    public static final int ERROR_SERVER_NOTAVAILABLEABORT;
    public static final int ERROR_ERROR_EXPORT_DATA;
    public static final int ERROR_ERROR_IMPORT_DATA;
    public static final int ERROR_ERROR_READ_METAINFO;
    public static final int ERROR_SWITCH_MEDIUM;
    public static final int ERROR_ERROR_FINISH_VERSION_UPDATE;
    public static final int ERROR_VERSION_UPDATE_ABORTED;
    public static final int ERROR_DEVICEERROR;
    public static final int ERROR_UNKNOWN;
    public static final int DEVICESELECTION_NONE;
    public static final int DEVICESELECTION_ALL;
    public static final int DEVICESELECTION_DEFAULT;
    public static final int RT_SETACCESSTYPE;
    public static final int RT_GETDEVICES;
    public static final int RT_GETMODULES;
    public static final int RT_GETLANGUAGES;
    public static final int RT_GETERRORS;
    public static final int RT_ISDATAMODULE;
    public static final int RT_ISNOEXCLUSIVEBOLOUPDATE;
    public static final int RT_GETVERSIONS;
    public static final int RT_GETTARGETVERSIONS;
    public static final int RT_GETADDITIONALINFO;
    public static final int RT_TOGGLESELECTION;
    public static final int RT_GETFILENAMES;
    public static final int RT_GETFILEDETAILS;
    public static final int RT_GETINFOFILEPATH;
    public static final int RT_SETDEVICESELECTION;
    public static final int RT_GETNUMBEROFPOPUPS;
    public static final int RT_GETPOPUP;
    public static final int RP_GETDEVICES;
    public static final int RP_GETMODULES;
    public static final int RP_GETLANGUAGES;
    public static final int RP_GETERRORS;
    public static final int RP_ISDATAMODULE;
    public static final int RP_ISNOEXCLUSIVEBOLOUPDATE;
    public static final int RP_GETVERSIONS;
    public static final int RP_GETTARGETVERSIONS;
    public static final int RP_GETADDITIONALINFO;
    public static final int RP_GETFILENAMES;
    public static final int RP_GETFILEDETAILS;
    public static final int RP_GETINFOFILEPATH;
    public static final int RP_GETNUMBEROFPOPUPS;
    public static final int RP_GETPOPUP;

    default public void setAccessType(int n) {
    }

    default public void getDevices() {
    }

    default public void getModules(int n) {
    }

    default public void getLanguages(int n) {
    }

    default public void getErrors(int n) {
    }

    default public void isDataModule(int n, int n2) {
    }

    default public void isNoExclusiveBoloUpdate(int n, int n2) {
    }

    default public void getVersions(int n, int n2) {
    }

    default public void getTargetVersions(int n, int n2) {
    }

    default public void getAdditionalInfo(int n, int n2) {
    }

    default public void toggleSelection(int n, int n2, short s) {
    }

    default public void getFileNames(int n, int n2) {
    }

    default public void getFileDetails(int n, int n2, short s) {
    }

    default public void getInfoFilePath(int n) {
    }

    default public void setDeviceSelection(int n, int n2) {
    }

    default public void getNumberOfPopups() {
    }

    default public void getPopup(int n) {
    }
}

