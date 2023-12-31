/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdllogging;

public interface DSISwdlLogging$Consts {
    public static final String VERSION;
    public static final int UNUSUALEVENT_NOT_INITIALIZED;
    public static final int UNUSUALEVENT_USER_ABORTED_THIS_DEVICE;
    public static final int UNUSUALEVENT_USER_ABORTED_COMPLETLY;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_DEVICEERROR;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_DEVICEERROR;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_SWITCH_MEDIUM;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_SWITCH_MEDIUM;
    public static final int UNUSUALEVENT_USERABORTED_AFTER_EXPORT_DATA;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_EXPORT_DATA;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_IMPORT_DATA;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_IMPORT_DATA;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_READ_METAINFO;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_READ_METAINFO;
    public static final int UNUSUALEVENT_BEM_HIGHLY_CRITICAL;
    public static final int UNUSUALEVENT_BEM_MEDIUM_CRITICAL;
    public static final int UNUSUALEVENT_BEM_BACK_TO_UNCRITICAL;
    public static final int UNUSUALEVENT_DEVICE_NOT_IN_DLMODE;
    public static final int UNUSUALEVENT_DEVICE_DEAD;
    public static final int UNUSUALEVENT_DEVICE_NOTFIES_TOO_LATE;
    public static final int UNUSUALEVENT_DEVICE_IS_ALIVE;
    public static final int UNUSUALEVENT_DEVICE_ABORT_MAX_TIME;
    public static final int UNUSUALEVENT_CD_ERROR_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_MISSING_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_INTERNAL_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_FAILED_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_DATA_CD_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_CD_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNLOAD_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DRIVE_ERROR_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOT_READABLE_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_INFO_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INTERNAL_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOT_FOUND_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DIR_NOT_FOUND_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNKNOWN_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_MISSING_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_INTERNAL_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_FAILED_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_DATA_CD_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_CD_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNLOAD_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DRIVE_ERROR_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOT_READABLE_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_INFO_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INTERNAL_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOT_FOUND_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DIR_NOT_FOUND_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNKNOWN_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_CD_AUTO_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOT_FOUND_AUTORETRY;
    public static final int UNUSUALEVENT_ERROR_INIT_INFLATE_RETRY;
    public static final int UNUSUALEVENT_ERROR_INIT_INFLATE_ABORT;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_READING_RETRY;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_OPENIN_GRETRY;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_READING_ABORT;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_OPENING_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOTOPENRETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOTOPENABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_NOINFORETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_NOINFOABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_GENERALRETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_GENERALABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_ABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNRETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNABORT;
    public static final int UNUSUALEVENT_CD_ERROR_FS_SEEK_RETRY;
    public static final int UNUSUALEVENT_CD_ERROR_FS_SEEK_ABORT;
    public static final int UNUSUALEVENT_SERVER_NOTAVAILABLERETRY;
    public static final int UNUSUALEVENT_SERVER_NOTAVAILABLEABORT;
    public static final int UNUSUALEVENT_ERROR_EXPORT_DATA;
    public static final int UNUSUALEVENT_ERROR_IMPORT_DATA;
    public static final int UNUSUALEVENT_ERROR_READ_METAINFO;
    public static final int UNUSUALEVENT_SWITCH_MEDIUM;
    public static final int UNUSUALEVENT_ERROR_FINISH_VERSION_UPDATE;
    public static final int UNUSUALEVENT_VERSION_UPDATE_ABORTED;
    public static final int UNUSUALEVENT_DEVICEERROR;
    public static final int UNUSUALEVENT_UNKNOWN;
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;
}

