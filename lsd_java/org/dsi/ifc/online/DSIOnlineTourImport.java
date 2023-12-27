/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineTourImport
extends DSIBase {
    public static final String VERSION;
    public static final int RT_STARTTOURDOWNLOAD;
    public static final int RT_DISMISSTOURDOWNLOAD;
    public static final int RT_ACKNOWLEDGETOURIMPORT;
    public static final int RP_RESPONSETOURDOWNLOAD;
    public static final int IN_INDICATETOURSAVAILABLE;
    public static final int IN_INDICATETOURDOWNLOADFINISHED;
    public static final int DOWNLOADSTATUS_SUCCESS;
    public static final int DOWNLOADSTATUS_STARTED;
    public static final int DOWNLOADSTATUS_DISMISSED;
    public static final int DOWNLOADSTATUS_ERROR;
    public static final int DOWNLOADSTATUS_ERROR_CONNECTIVITY;
    public static final int IMPORTSTATUS_SUCCESS;
    public static final int IMPORTSTATUS_FAILURE;
    public static final int IMPORTSTATUS_ABORTED;
    public static final int IMPORTSTATUS_ABORTED_POWERDOWN;

    default public void startTourDownload(int n) {
    }

    default public void dismissTourDownload() {
    }

    default public void acknowledgeTourImport(int n) {
    }
}

