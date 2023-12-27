/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrl
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_STREETVIEWLOADSTATUS;
    public static final int ATTR_STREETVIEWAVAILABLE;
    public static final int ATTR_STREETVIEWZOOMLISTINDEX;
    public static final int ATTR_STREETVIEWZOOMLIST;
    public static final int ATTR_STREETVIEWTHUMBNAILS;
    public static final int ATTR_POSITION;
    public static final int ATTR_ROTATION;
    public static final int ATTR_SCREENVIEWPORT;
    public static final int ATTR_STREETVIEWZOOMLEVEL;
    public static final int ATTR_STREETVIEWPOSITION;
    public static final int RT_STREETVIEWENABLED;
    public static final int RT_STREETVIEWVISIBLE;
    public static final int RT_STREETVIEWFREEZE;
    public static final int RT_SETSTREETVIEWZOOMINDEX;
    public static final int RT_STREETVIEWTHUMBNAILS;
    public static final int RT_LOADSTREETVIEW;
    public static final int RT_ROTATEVIEW;
    public static final int RT_ROTATEVIEWBYPOLARCOORDINATES;
    public static final int RT_GETINFOFORSCREENPOSITION;
    public static final int RT_SETPOSITION;
    public static final int RT_SETCROSSHAIRSVISIBILITY;
    public static final int RT_SETDAYNIGHTVIEW;
    public static final int RT_SETAZIMUTH;
    public static final int RT_SETINCLINATION;
    public static final int RT_SNAPSHOT;
    public static final int RT_SETVIEWROTATIONBYPOLARCOORDINATES;
    public static final int RT_STARTVIEWROTATIONBYPOLARCOORDINATES;
    public static final int RT_STOPVIEWROTATIONBYPOLARCOORDINATES;
    public static final int RT_GOTOVIEW;
    public static final int RT_SETSCREENVIEWPORT;
    public static final int RT_SETCROSSHAIRSPOSITION;
    public static final int RT_SETSTREETVIEWZOOMLEVEL;
    public static final int RP_STREETVIEWENABLED;
    public static final int RP_STREETVIEWVISIBLE;
    public static final int RP_STREETVIEWFREEZE;
    public static final int RP_GETINFOFORPOSITION;
    public static final int RP_SNAPSHOTRESULT;
    public static final int RESULTCODE_OK;
    public static final int RESULTCODE_FAIL;
    public static final int RESULTCODE_UNSUPPORTED;
    public static final int LOADSTATUS_STATUS_IDLE;
    public static final int LOADSTATUS_STATUS_LOADING;
    public static final int LOADSTATUS_STATUS_LOAD_COMPLETE;

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
}

