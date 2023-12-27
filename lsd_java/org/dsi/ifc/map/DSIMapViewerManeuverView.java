/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;

public interface DSIMapViewerManeuverView
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_MANOEUVREVIEWACTIVE;
    public static final int ATTR_MANOEUVREVIEWSAVAILABLE;
    public static final int ATTR_BAPEXITVIEWID;
    public static final int MANOEUVRETYPE_MAP;
    public static final int MANOEUVRETYPE_RGS;
    public static final int MANOEUVRETYPE_INTERSECTION;
    public static final int MANOEUVRETYPE_INTERSECTION_3D;
    public static final int MANOEUVRETYPE_JUNCTION;
    public static final int MANOEUVRETYPE_REALISTIC_PICTURE;
    public static final int MANOEUVRETYPE_CANBAN;
    public static final int MANOEUVRETYPE_FOLLOW;
    public static final int MANOEUVRETYPE_PREPARE;
    public static final int MANOEUVRETYPE_UTURN;
    public static final int MANOEUVRETYPE_OFFROAD;
    public static final int MANOEUVRETYPE_DESTINATION;
    public static final int MANOEUVRETYPE_MISCELLANEOUS;
    public static final int MANOEUVRETYPE_INVALID_MANOEUVRE;
    public static final int RT_HIDEMANOEUVREVIEW;
    public static final int RT_SELECTMANOEUVREVIEW;
    public static final int RT_SETDISTANCESTRING;
    public static final int RT_DISABLEMANEUVERVIEWGENERATION;

    default public void hideManoeuvreView() {
    }

    default public void selectManoeuvreView(int n, boolean bl) {
    }

    default public void setDistanceString(String string) {
    }

    default public void disableManeuverViewGeneration(boolean bl) {
    }
}

