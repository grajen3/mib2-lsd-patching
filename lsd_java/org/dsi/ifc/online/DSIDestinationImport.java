/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIDestinationImport
extends DSIBase {
    public static final String VERSION;
    public static final int STATUS_OK;
    public static final int ERROR_SERVER_NOT_AVAILABLE;
    public static final int ERROR_SERVER_DATA_FORMAT_INVALID;
    public static final int IMPORTSTATUS_OK_IN_PROGRESS;
    public static final int IMPORTSTATUS_OK_COMPLETED;
    public static final int IMPORTSTATUS_ERROR_OUT_OF_MEM;
    public static final int IMPORTSTATUS_ERROR_GENERIC;
    public static final int RT_DOWNLOADADDRESSLIST;
    public static final int RT_STOPACTION;
    public static final int RT_SETADBIMPORTSTATUS;
    public static final int RP_DOWNLOADADDRESSLISTRESULT;
    public static final int RP_STOPACTIONRESULT;
    public static final int ATTR_ENTRIES;

    default public void downloadAddressList(int n, boolean bl) {
    }

    default public void stopAction() {
    }

    default public void setADBImportStatus(long[] lArray, int n) {
    }
}

