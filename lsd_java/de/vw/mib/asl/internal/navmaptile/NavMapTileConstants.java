/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class NavMapTileConstants {
    public static final int EV_NAV_SERVICE_READY;
    public static final int EV_ZOOM_LEVEL_UPDATE;
    public static final int EV_ZOOM_LEVEL_VALUE;
    public static final int EV_REINIT_MAPVIEW;
    public static final int EV_MAPVIEW_USED_BY;
    public static final int EV_UPDATE_MAP_MODE;
    public static final int EV_UPDATE_MAP_MODE_MODE;
    public static final int EV_GUIDANCE_STATE_CHANGED;
    public static final int EV_GUIDANCE_STATE_CHANGED_STATE;
    static final boolean IS_PREMIUM;
    static final int MAP_MODE_POSITIONMAP;
    static final int ORIENTATION_HEADINGUP;
    static final int ORIENTATION_NORTHUP;
    static final int PERSPECTIVE_DEFAULT;
    static final int PERSPECTIVE_OVERVIEW;
    static final int MAP_VIEW_TYPE_3D;
    static final int MAP_VIEW_TYPE_2D;
    public static final int PERSPECTIVE_OTHER;
    static final int ZOOM_LEVEL_DEFAULT;
    public static final int DESTINATION_OVERVIEW_ZOOM;
    public static final int MANEUVERVIEWSTYLE_1;
    public static final int MANEUVERVIEWSTYLE_2;
    public static final int MANEUVERVIEWSTYLE_3;
    public static final int MANEUVERVIEWSTYLE_4;
    public static final int STATE_GUIDING;
    public static final int STATE_NO_GUIDANCE;

    private NavMapTileConstants() {
    }

    static {
        IS_PREMIUM = ServiceManager.configManagerDiag.getPureVariant().startsWith("PREMIUM");
    }
}

