/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl;

import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;

public interface NavInfoDelegate {
    public static final int NAV_INFO_CITY_NAME;
    public static final int NAV_INFO_CURRENT_STREET;
    public static final int NAV_INFO_DISTANCE_TO_DESTINATION;
    public static final int NAV_INFO_DISTANCE_TO_NEXT_MANEUVER;
    public static final int NAV_INFO_ESTIMATED_REMAINING_TRIP_TIME;
    public static final int NAV_INFO_ESTIMATED_TIME_OF_ARRIVAL;
    public static final int NAV_INFO_TURN_TO_STREET;
    public static final int NAV_INFO_ROUTE_GUIDANCE_MODE;

    default public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
    }
}

