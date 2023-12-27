/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import org.dsi.ifc.navigation.PosPosition;

public interface ASLNavigationSplitscreenAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_SPLITSCREEN_MANEUVERVIEW_VISIBLE;
    public static final int EV_SPLITSCREEN_MANEUVERVIEW_VISIBLE__P0_VISIBLE_BOOLEAN;
    public static final int EV_SPLITSCREEN_COMPASS_DIRECTION_UPDATE;
    public static final int EV_SPLITSCREEN_COMPASS_DIRECTION__P0_INT;
    public static final int EV_SPLITSCREEN_COMPASS_STREETNAME_UPDATE;
    public static final int EV_SPLITSCREEN_COMPASS_STREETNAME__P0_STRING;
    public static final int EV_SPLITSCREEN_LOCATION_DATA_UPDATE;
    public static final int EV_SPLITSCREEN_LOCATION__P0_INT;
    public static final int EV_SPLITSCREEN_POSITION_DATA_UPDATE;
    public static final int EV_SPLITSCREEN_POSITION__P0_INT;
    public static final int EV_SPLITSCREEN_3PLUS1BOX;
    public static final int EV_SPLITSCREEN_3PLUS1BOX__P0_ASLMANEUVERVIEWELEMENT_ARRAY;
    public static final int EV_SPLITSCREEN_10PLUS0BOX;
    public static final int EV_SPLITSCREEN_10PLUS0BOX__P0_ASLMANEUVERVIEWELEMENT_ARRAY;
    public static final int EV_SPLITSCREEN_OVERLAY_DATA;
    public static final int EV_SPLITSCREEN_OVERLAY_DATA__P0_IOVERLAYDATA;
    public static final int EV_SPLITSCREEN_OVERLAY_CURRENT_CONTENT;
    public static final int EV_SPLITSCREEN_OVERLAY_CURRENT_CONTENT__P0_INT;
    public static final int EV_SPLITSCREEN_OVERLAY_COUNT;
    public static final int EV_SPLITSCREEN_OVERLAY_COUNT__P0_INT;
    public static final int EV_SPLITSCREEN_OVERLAY_INDEX;
    public static final int EV_SPLITSCREEN_OVERLAY_INDEX__P0_INT;
    public static final int OVERLAY_CONTENT_DEFAULT;
    public static final int OVERLAY_CONTENT_SPLITSCREEN;
    public static final int OVERLAY_CONTENT_INTERSECTION;
    public static final int OVERLAY_CONTENT_EXIT_VIEW;
    public static final int OVERLAY_CONTENT_CANBAN;
    public static final int OVERLAY_CONTENT_MOTORWAYINFO;
    public static final int MANEUVERVIEWELEMENT_TYPE_MANEUVER;
    public static final int MANEUVERVIEWELEMENT_TYPE_POI;
    public static final int MANEUVERVIEWELEMENT_TYPE_TMC;
    public static final int MANEUVERVIEWELEMENT_TYPE_NOT_SUPPORTED;

    default public void sendEvSplitScreenManeuverviewActive(boolean bl) {
    }

    default public PosPosition getCurrentPosition() {
    }

    default public void setSplitScreenContent(int n) {
    }
}

