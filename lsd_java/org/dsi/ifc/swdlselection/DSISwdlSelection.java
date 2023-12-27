/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlselection;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlSelection
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_LAMECLIENTS;
    public static final int ATTR_ENGINEERING;
    public static final int ATTR_USERSWDL;
    public static final int ATTR_RINGNOTOK;
    public static final int ATTR_ENDDOWNLOAD;
    public static final int ATTR_AVAILABLEMEDIA;
    public static final int ATTR_UNITTYPE;
    public static final int RELEASERESULT_NOT_INITIALIZED;
    public static final int RELEASERESULT_OK;
    public static final int RELEASERESULT_ERROR_OPEN;
    public static final int RELEASERESULT_ERROR_READ;
    public static final int RELEASERESULT_ERROR_PARSE;
    public static final int RELEASERESULT_ERROR_SIGNATURE;
    public static final int RELEASERESULT_ERROR_CRC;
    public static final int RELEASERESULT_ERROR_NO_RELEASES;
    public static final int RELEASERESULT_ERROR_MEDIUM_UNAVAILABLE;
    public static final int RELEASERESULT_ERROR_VARIANT;
    public static final int RELEASERESULT_ERROR_REGION;
    public static final int RELEASERESULT_ERROR_MEMORY;
    public static final int RELEASERESULT_ERROR_DOWNLOAD_ACTIVE;
    public static final int RELEASERESULT_ERROR_NO_RSE_SWDL;
    public static final int RELEASERESULT_ERROR_MOUNT_ERROR_CIFS_DOMAIN_USER;
    public static final int RELEASERESULT_ERROR_PARSING_MU_FILE;
    public static final int RELEASERESULT_ERROR_AUTORUN_ACTIVE;
    public static final int RELEASERESULT_ERROR_TEST_ACTIVE;
    public static final int RELEASERESULT_ERROR_BLOCKED_TRAIN;
    public static final int METAINFORESULT_NOT_INITIALIZED;
    public static final int METAINFORESULT_OK;
    public static final int METAINFORESULT_ERROR_OPEN_METAINFO;
    public static final int METAINFORESULT_ERROR_READ;
    public static final int METAINFORESULT_ERROR_PARSE;
    public static final int METAINFORESULT_ERROR_SIGNATURE;
    public static final int METAINFORESULT_ERROR_CRC;
    public static final int METAINFORESULT_ERROR_REGION;
    public static final int METAINFORESULT_ERROR_MEDIUM_UNAVAILABLE;
    public static final int METAINFORESULT_ERROR_VARIANT;
    public static final int METAINFORESULT_ERROR_CRC_CHANGED;
    public static final int METAINFORESULT_ERROR_DOWNLOAD_ACTIVE;
    public static final int METAINFORESULT_ERROR_WAIT_FOR_RSU_VERSIONS_EXPIRED;
    public static final int METAINFORESULT_ERRORR_WRONG_MU_RING_TYPE;
    public static final int METAINFORESULT_ERROR_BLOCKED_TRAIN;
    public static final int MEDIUM_NOT_INITIALIZED;
    public static final int MEDIUM_NFS;
    public static final int MEDIUM_INTERNAL_DRIVE;
    public static final int MEDIUM_USB_FS;
    public static final int MEDIUM_SD_1;
    public static final int MEDIUM_SD_2;
    public static final int MEDIUM_CIFS;
    public static final int MEDIUM_OTA;
    public static final int MEDIUM_FS;
    public static final int CONSISTENCY_NOT_INITIALIZED;
    public static final int CONSISTENCY_OK;
    public static final int CONSISTENCY_IMAGE_LAYOUT;
    public static final int CONSISTENCY_APP_DEAD;
    public static final int CONSISTENCY_EMERGENCY_DEAD;
    public static final int CONSISTENCY_IOC_BOLO;
    public static final int CONSISTENCY_USER_SWDL_RUNNING;
    public static final int CONSISTENCY_WINZIP_CORRUPTED;
    public static final int CONSISTENCY_NOT_AUTHENTICATED;
    public static final int CONSISTENCY_INSUFFICIENT_SPACE;
    public static final int CONSISTENCY_RSU_UPDATE_RUNNING;
    public static final int CONSISTENCY_RSU_IMAGE_LAYOUT;
    public static final int CONSISTENCY_RSU_APP_DEAD;
    public static final int CONSISTENCY_RSU_EMERGENCY_DEAD;
    public static final int CONSISTENCY_METAINFO;
    public static final int FINALIZETARGETRESULT_TARGET_INITIALIZED;
    public static final int FINALIZETARGETRESULT_TARGET_OK;
    public static final int FINALIZETARGETRESULT_TARGET_ERROR_SIZE;
    public static final int FINALIZETARGETRESULT_TARGET_ERROR_MOUNT_PATH;
    public static final int FINALIZETARGETRESULT_TARGET_ERROR_GENERAL;
    public static final int UNITTYPES_NOT_INITIALIZED;
    public static final int UNITTYPES_MAINUNIT;
    public static final int UNITTYPES_REARSEATUNIT;
    public static final int RT_SETUSERSWDL;
    public static final int RT_SETGOTFOCUS;
    public static final int RT_GETMEDIA;
    public static final int RT_STORENFSIPADDRESS;
    public static final int RT_STORENFSPATH;
    public static final int RT_SETMEDIUM;
    public static final int RT_SETRELEASE;
    public static final int RT_GETUSERDEFINEDALLOWED;
    public static final int RT_SETINSTALLATIONTYPE;
    public static final int RT_SETTARGETLANGUAGE;
    public static final int RT_GETINCOMPATIBLEDEVICES;
    public static final int RT_STARTDOWNLOAD;
    public static final int RT_CREATECRITICALUNLOCK;
    public static final int RT_ABORTVERSIONUPLOAD;
    public static final int RT_ENDVERSIONUPLOAD;
    public static final int RT_STORECIFSSERVER;
    public static final int RT_STORECIFSPATH;
    public static final int RT_STORECIFSUSER;
    public static final int RT_STORECIFSPASSWORD;
    public static final int RT_STOREFSPATH;
    public static final int RT_CHECKCONSISTENCY;
    public static final int RT_ABORTSETMEDIUM;
    public static final int RT_ABORTSETRELEASE;
    public static final int RT_GETFINALIZETARGETS;
    public static final int RT_SETFINALIZETARGET;
    public static final int RT_STARTVERSIONUPLOAD;
    public static final int RT_ENTERCOMPONENTUPDATECONFIRMATION;
    public static final int RP_GETMEDIA;
    public static final int RP_STORENFSIPADDRESS;
    public static final int RP_SETMEDIUM;
    public static final int RP_SETRELEASE;
    public static final int RP_GETUSERDEFINEDALLOWED;
    public static final int RP_SETTARGETLANGUAGE;
    public static final int RP_GETINCOMPATIBLEDEVICES;
    public static final int RP_STARTVERSIONUPLOAD;
    public static final int RP_CHECKCONSISTENCY;
    public static final int RP_ABORTSETMEDIUM;
    public static final int RP_ABORTSETRELEASE;
    public static final int RP_GETFINALIZETARGETS;
    public static final int RP_SETFINALIZETARGET;
    public static final int RP_STOREFSPATH;
    public static final int RP_STORENFSPATH;
    public static final int RP_ENTERCOMPONENTUPDATECONFIRMATION;

    default public void setUserSwdl(boolean bl) {
    }

    default public void setGotFocus(boolean bl) {
    }

    default public void getMedia() {
    }

    default public void storeNfsIpAddress(String string) {
    }

    default public void storeNfsPath(String string) {
    }

    default public void setMedium(int n) {
    }

    default public void setRelease(long l) {
    }

    default public void getUserDefinedAllowed() {
    }

    default public void setInstallationType(boolean bl) {
    }

    default public void setTargetLanguage(short s) {
    }

    default public void getIncompatibleDevices() {
    }

    default public void startDownload() {
    }

    default public void createCriticalUnlock() {
    }

    default public void startVersionUpload() {
    }

    default public void abortVersionUpload() {
    }

    default public void endVersionUpload() {
    }

    default public void storeCifsServer(String string) {
    }

    default public void storeCifsPath(String string) {
    }

    default public void storeCifsUser(String string) {
    }

    default public void storeCifsPassword(String string) {
    }

    default public void storeFsPath(String string) {
    }

    default public void checkConsistency() {
    }

    default public void abortSetMedium() {
    }

    default public void abortSetRelease() {
    }

    default public void getFinalizeTargets() {
    }

    default public void setFinalizeTarget(int n) {
    }

    default public void enterComponentUpdateConfirmation(boolean bl) {
    }
}

