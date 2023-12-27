/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;

public interface DSINavAsiaMapControlListener
extends DSIListener {
    default public void updateMapStatus(int n, int n2) {
    }

    default public void updateViewType(int n, int n2) {
    }

    default public void updateDataRate(int n, int n2) {
    }

    default public void updateZoomLevel(float f2, int n) {
    }

    default public void updateRecommendedZoom(float f2, int n) {
    }
}

