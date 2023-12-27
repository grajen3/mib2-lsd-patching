/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlinePicNav
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SYNCSTATUS;
    public static final int RT_SYNCHRONIZE;
    public static final int RT_ABORTSYNC;
    public static final int RT_GETPENDINGTRANSACTIONS;
    public static final int RT_SETACTIVEPROFILE;
    public static final int RP_SYNCHRONIZERESULT;
    public static final int RP_GETPENDINGTRANSACTIONSRESULT;
    public static final int RP_SETACTIVEPROFILERESULT;
    public static final int RESULT_ERROR;
    public static final int RESULT_OK;
    public static final int RESULT_ABORT;

    default public void synchronize() {
    }

    default public void abortSync() {
    }

    default public void getPendingTransactions() {
    }

    default public void setActiveProfile(int n) {
    }
}

