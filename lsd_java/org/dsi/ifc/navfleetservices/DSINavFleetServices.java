/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navfleetservices;

import org.dsi.ifc.base.DSIBase;

public interface DSINavFleetServices
extends DSIBase {
    public static final String VERSION;
    public static final int RP_SETVZOTRACKERSTATERESULT;
    public static final int RP_SETVZODOWNLOADSTATERESULT;
    public static final int RP_SETLGITRACKERSTATERESULT;
    public static final int RP_SETLGIDOWNLOADSTATERESULT;
    public static final int RT_SETVZOTRACKERSTATE;
    public static final int RT_SETVZODOWNLOADSTATE;
    public static final int RT_SETLGITRACKERSTATE;
    public static final int RT_SETLGIDOWNLOADSTATE;
    public static final int APPSTATE_ACTIVE;
    public static final int APPSTATE_FORBIDDENROAMING;
    public static final int APPSTATE_DEACTIVATE;
    public static final int NCFSRESULTCODE_OK;
    public static final int NCFSRESULTCODE_ERROR;

    default public void setVZOTrackerState(int n) {
    }

    default public void setVZODownloadState(int n) {
    }

    default public void setLGITrackerState(int n) {
    }

    default public void setLGIDownloadState(int n) {
    }
}

