/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrlC {
    default public void streetViewEnabled(boolean bl) {
    }

    default public void streetViewVisible(boolean bl) {
    }

    default public void streetViewFreeze(boolean bl) {
    }

    default public void goToView() {
    }

    default public void setStreetViewZoomIndex(int n) {
    }

    default public void streetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray) {
    }

    default public void loadStreetView(boolean bl) {
    }

    default public void rotateView(short s, short s2) {
    }

    default public void rotateViewByPolarCoordinates(int n, int n2) {
    }

    default public void setAzimuth(int n) {
    }

    default public void setInclination(int n) {
    }

    default public void getInfoForScreenPosition(short s, short s2) {
    }

    default public void setPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void setCrossHairsVisibility(boolean bl) {
    }

    default public void setDayNightView(boolean bl) {
    }

    default public void snapshot() {
    }

    default public void setViewRotationByPolarCoordinates(float f2, float f3) {
    }

    default public void startViewRotationByPolarCoordinates(float f2, float f3) {
    }

    default public void stopViewRotationByPolarCoordinates() {
    }

    default public void setScreenViewport(Rect rect) {
    }

    default public void setCrossHairsPosition(Point point) {
    }

    default public void setStreetViewZoomLevel(float f2) {
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

