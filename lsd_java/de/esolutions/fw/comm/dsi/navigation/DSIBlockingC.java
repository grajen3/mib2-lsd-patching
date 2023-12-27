/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public interface DSIBlockingC {
    default public void blockArea(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    default public void blockRouteSegments(long l, long l2) {
    }

    default public void blockRoadSegments(NavLocation navLocation) {
    }

    default public void blockRouteBasedOnLength(int n, int n2) {
    }

    default public void persistBlock(long[] lArray) {
    }

    default public void deleteBlock(long[] lArray) {
    }

    default public void setBlockDescription(long[] lArray, String string) {
    }

    default public void getBoundingRectangleOfBlocks(long[] lArray) {
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

