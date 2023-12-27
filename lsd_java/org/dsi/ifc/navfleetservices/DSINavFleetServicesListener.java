/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navfleetservices;

import org.dsi.ifc.base.DSIListener;

public interface DSINavFleetServicesListener
extends DSIListener {
    default public void setVZOTrackerStateResult(int n) {
    }

    default public void setVZODownloadStateResult(int n) {
    }

    default public void setLGITrackerStateResult(int n) {
    }

    default public void setLGIDownloadStateResult(int n) {
    }
}

