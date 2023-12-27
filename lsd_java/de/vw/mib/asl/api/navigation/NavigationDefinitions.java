/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.Logger;

public final class NavigationDefinitions {
    public static final Logger NAVI_LOGGER = ServiceManager.eventMain.getLoggerFactory().getLogger(1);
    public static final double HEADING_OUTPUT_RANGE;
    public static final double HEADING_INPUT_RANGE;
    public static final double HEADING_OUTPUT_UNIT;
    public static final double HEADING_OUTPUT_UNIT_32;
    public static final int ROCKET_ZOOM_STEPS;
    public static final int ZOOMLEVEL_DRIVING_DIRECTION;
    public static final int VZA_SPEEDWARNING_THRESHOLD;
    public static final int MAP_SWITCH_TO_CENTER_ZOOMLEVEL;
    public static final int USER_RESTRICTION_SPEED_LIMIT_KMH;
    public static final int VZA_VZE_MAX_LIST_SIZE;
    public static final int ROUTE_OPTIONS_NUMBER_OF_ALTERNATIVE_ROUTES_EU;
    public static final int ROUTE_OPTIONS_NUMBER_OF_ALTERNATIVE_ROUTES_CHN;
    public static final double BEV_RANGE_CHECK_HOME_MULTIPLIER;
    public static final double BEV_RANGE_CHECK_DISTANCE_TO_DESTINATION_MULTIPLIER;
    public static final double BEV_RANGE_CHECK_DISTANCE_TO_HOME_MULTIPLIER;
    public static final int BEV_RANGE_CHECK_INTERVAL_MS;

    private NavigationDefinitions() {
    }
}

