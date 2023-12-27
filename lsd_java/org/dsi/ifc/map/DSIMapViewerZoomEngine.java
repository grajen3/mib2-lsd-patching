/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerZoomEngine
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AUTOZOOMENABLED;
    public static final int ATTR_MANOEUVREZOOMENABLED;
    public static final int ATTR_RECOMMENDEDZOOM;
    public static final int ATTR_ZOOMENGINESTATE;
    public static final int ZOOMENGINESTATE_OFF;
    public static final int ZOOMENGINESTATE_READY;
    public static final int ZOOMENGINESTATE_AUTOZOOM;
    public static final int ZOOMENGINESTATE_MANOEUVREZOOM;
    public static final int ZOOMENGINESTATE_INVALID_ZOOMSTATE;
    public static final int MAPVIEWTYPE_VIEW2D;
    public static final int MAPVIEWTYPE_BIRDVIEW;
    public static final int MAPVIEWTYPE_VIEW3D;
    public static final int RT_AUTOZOOMENABLE;
    public static final int RT_MANOEUVREZOOMENABLE;
    public static final int RT_SETVIEWTYPE;
    public static final int RT_SETZOOMAREA;
    public static final int RT_SETCARPOSITION;
    public static final int RT_SETMAPROTATION;
    public static final int RT_SETMAPORIENTATION;

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
}

