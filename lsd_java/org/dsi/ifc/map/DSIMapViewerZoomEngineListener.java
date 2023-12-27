/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;

public interface DSIMapViewerZoomEngineListener
extends DSIListener {
    default public void updateAutoZoomEnabled(boolean bl, int n) {
    }

    default public void updateManoeuvreZoomEnabled(boolean bl, int n) {
    }

    default public void updateRecommendedZoom(float f2, int n) {
    }

    default public void updateZoomEngineState(int n, int n2) {
    }
}

