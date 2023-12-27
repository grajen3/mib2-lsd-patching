/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl;

public interface NavigationMap {
    public static final int KOMBI_MAP_STATUS_ERROR;
    public static final int KOMBI_MAP_STATUS_NOT_STARTED;
    public static final int KOMBI_MAP_STATUS_READY;
    public static final int KOMBI_MAP_STATUS_RESTARTING;
    public static final int KOMBI_MAP_STATUS_STARTING;
    public static final int KOMBI_MAP_VISIBILITY_INVISIBLE;
    public static final int KOMBI_MAP_VISIBILITY_VISIBLE;
    public static final int KOMBI_MAP_SWITCH_STATE_NOT_AVAILABLE;
    public static final int KOMBI_MAP_SWITCH_STATE_SWITCHING_TO_ABT_REQUEST;
    public static final int KOMBI_MAP_SWITCH_STATE_SWITCHING_TO_ABT_SHOW_MAP;
    public static final int KOMBI_MAP_SWITCH_STATE_SWITCHING_TO_KOMBI;
    public static final int KOMBI_MAP_SWITCH_STATE_VISIBLE_IN_ABT;
    public static final int KOMBI_MAP_SWITCH_STATE_VISIBLE_IN_KOMBI;
    public static final int KOMBI_MAP_IN_ABT_INVISIBLE;
    public static final int KOMBI_MAP_IN_ABT_VISIBLE;
    public static final int KOMBI_MAP_MAP_SERVICE_STATE_NOT_READY;
    public static final int KOMBI_MAP_MAP_SERVICE_STATE_READY;

    default public void setMapVisible() {
    }

    default public void setMapInvisible() {
    }

    default public void setMapSwitchState(int n) {
    }

    default public void setMapSwitchPossible(boolean bl) {
    }
}

