/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerZoomEngineC {
    default public void autoZoomEnable(boolean bl) {
    }

    default public void manoeuvreZoomEnable(boolean bl) {
    }

    default public void setViewType(int n) {
    }

    default public void setCarPosition(Point point) {
    }

    default public void setMapRotation(short s) {
    }

    default public void setMapOrientation(int n, Point point) {
    }

    default public void setZoomArea(Rect rect) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

