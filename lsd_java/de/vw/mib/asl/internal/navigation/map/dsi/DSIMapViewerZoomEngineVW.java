/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi;

import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerZoomEngineVW {
    default public void autoZoomEnable(boolean bl) {
    }

    default public void setCarPosition(Point point) {
    }

    default public void setMapOrientation(int n) {
    }

    default public void setMapRotation(short s) {
    }

    default public void setViewType(int n) {
    }

    default public void setZoomArea(Rect rect) {
    }
}

