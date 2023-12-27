/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import org.dsi.ifc.map.Point;

public interface DSIMapViewerRouteBlockC {
    default public void rBMarkNextSegment() {
    }

    default public void rBMarkPreviousSegment() {
    }

    default public void rBSetSegmentScales(long l, long l2) {
    }

    default public void rBStartOfSelection() {
    }

    default public void pickSegmentUidsInScreenSpace(Point point, int n) {
    }

    default public void highLightSegmentUidsInMap(long[] lArray, boolean bl) {
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

