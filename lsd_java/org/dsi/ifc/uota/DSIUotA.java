/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.uota;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocationWgs84;

public interface DSIUotA
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DOWNLOADSTATE;
    public static final int ATTR_DOWNLOADPROGRESS;
    public static final int ATTR_PACKAGESAVAILABLE;
    public static final int ATTR_SERVCIEREADY;
    public static final int STATE_DOWNLOAD_NOT_ACTIVE;
    public static final int STATE_DOWNLOAD_ACTIVE;
    public static final int STATE_DOWNLOAD_FINISHED;
    public static final int STATE_DOWNLOAD_ERROR_CANCELED_BY_USER;
    public static final int STATE_DOWNLOAD_WAIT_FOR_PDD;
    public static final int STATE_ERROR;
    public static final int STATE_DOWNLOAD_ERROR;
    public static final int STATE_DOWNLOAD_ERROR_RETRY_POSSIBLE;
    public static final int STATE_ERROR_CONNECTION_FAILURE;
    public static final int STATE_DOWNLOAD_PREPARE_APP;
    public static final int STATE_APP_SIGNAL;
    public static final int STATE_DOWNLOAD_ACTIVE_APP;
    public static final int STATE_WAIT_APP;
    public static final int STATE_AUTH_ABORTED;
    public static final int STATE_AUTH_ERROR;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_ERROR_INVALID_SESSION;
    public static final int RESULT_ERROR_UNSUPPORTED;
    public static final int RESULT_ERROR_INVALID_SYNTAX;
    public static final int RESULT_ERROR_SERVICE_NOT_READY;
    public static final int RESULT_CANCELLED;
    public static final int ACTION_FACTORY_RESET;
    public static final int ACTION_RESTART_DOWNLOAD;
    public static final int ACTION_TRIGGER_SYSTEM_PROPOSAL;
    public static final int ACTION_TRIGGER_FINAL_POPUP;
    public static final int ACTION_FINAL_POPUP_CONFIRMED;
    public static final int ACTION_CUSTOMER_DETAILS;
    public static final int KIND_UNSPECIFIED_LOCALIZED_INFO;
    public static final int KIND_DOWNLOADING;
    public static final int KIND_VERIFYING;
    public static final int KIND_INSTALLING;
    public static final int KIND_PREPARING;
    public static final int KIND_POSTPROCESSING;
    public static final int TYPE_UNKNOWN;
    public static final int TYPE_BUSINESS;
    public static final int TYPE_TECHNICAL;
    public static final int ATTRIBUTE_SOURCE_PATH_FOR_SWDL;
    public static final String FEATURE_MULTIPLE_SESSIONS;
    public static final String FEATURE_FINAL_POPUP_CONFIRMATION;
    public static final String FEATURE_TRIGGER_CUSTOMER_DOWNLOAD_DETAILS;
    public static final int ADDINFO_SELECTED;
    public static final int ADDINFO_UPTODATE;
    public static final int ADDINFO_AUTOSELECT;
    public static final int ADDINFO_HIDDEN;
    public static final int RT_GETSERVERLIST;
    public static final int RT_GETUPDATEPACKAGES;
    public static final int RT_TOGGLESELECTION;
    public static final int RT_STARTDOWNLOAD;
    public static final int RT_ABORTDOWNLOAD;
    public static final int RT_TRIGGERACTION;
    public static final int RT_GETATTRIBUTE;
    public static final int RT_SETFEATURE;
    public static final int RT_GETFEATURE;
    public static final int RT_SETLANGUAGE;
    public static final int RT_CUSTOMERDOWNLOADFINISHED;
    public static final int RT_SETSELECTION;
    public static final int RT_GETUPDATEPACKAGESFORDESTINATIONS;
    public static final int RT_APPAVAILABLE;
    public static final int RT_STARTDOWNLOADVIAAPP;
    public static final int RT_TRANSFERDATAFROMAPP;
    public static final int RP_GETSERVERLIST;
    public static final int RP_TOGGLESELECTION;
    public static final int RP_STARTDOWNLOAD;
    public static final int RP_FEATURERESULT;
    public static final int RP_GETUPDATEPACKAGESFORDESTINATIONS;
    public static final int RP_ABORTDOWNLOAD;
    public static final int RP_CUSTOMERDOWNLOADFINISHED;
    public static final int IN_TRIGGERACTION;
    public static final int IN_GETUPDATEPACKAGES;
    public static final int IN_ATTRIBUTERESULT;
    public static final int IN_GETUPDATEPACKAGESVIAAPP;

    default public void getServerList() {
    }

    default public void getUpdatePackages(int n, String string, String string2) {
    }

    default public void toggleSelection(int n, int n2) {
    }

    default public void startDownload(int n) {
    }

    default public void abortDownload(int n) {
    }

    default public void triggerAction(int n, int n2, String string) {
    }

    default public void getAttribute(int n, int n2) {
    }

    default public void setFeature(String string, boolean bl) {
    }

    default public void getFeature(String string) {
    }

    default public void setLanguage(String string) {
    }

    default public void customerDownloadFinished(int n, int n2, boolean bl) {
    }

    default public void setSelection(int n, int[] nArray) {
    }

    default public void getUpdatePackagesForDestinations(int n, NavLocationWgs84[] navLocationWgs84Array, int n2) {
    }

    default public void appAvailable(int n, String string, int n2, int n3, long l) {
    }

    default public void startDownloadViaApp(int n) {
    }

    default public void transferDataFromApp(int n) {
    }
}

