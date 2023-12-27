/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl;

import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;

public interface NavigationMapDelegate {
    public static final int NAVIGATION_MAP_KOMBI_MAP_STATUS;
    public static final int NAVIGATION_MAP_KOMBI_MAP_VISIBILITY;
    public static final int NAVIGATION_MAP_NAVIGATION_SERVICE_STATE;
    public static final int NAVIGATION_MAP_IN_ABT_VISIBILITY;
    public static final int NAVIGATION_MAP_SWITCH_STATE;
    public static final int NAVIGATION_MAP_SWITCH_TO_ABT;
    public static final int NAVIGATION_MAP_SWITCH_TO_KOMBI;
    public static final int NAVIGATION_MAP_MAP_SERVICE_STATE;
    public static final int NAVIGATION_MAP_MAP_SWITCH_POSSIBLE;
    public static final int[] NAVIGATION_MAP_KOMBI_MAP_PROPERTIES;

    default public void updateNavigationMap(NavigationMapService navigationMapService, int n) {
    }

    static {
        NAVIGATION_MAP_KOMBI_MAP_PROPERTIES = new int[]{485494784, 502272000, -385679232, -368902016, -352124800, -335347584, -318570368, -301793152};
    }
}

