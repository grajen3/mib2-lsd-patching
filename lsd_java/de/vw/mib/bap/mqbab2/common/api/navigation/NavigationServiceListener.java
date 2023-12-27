/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.navigation;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;

public interface NavigationServiceListener
extends HMIEventListener {
    public static final int NAVIGATION_SERVICE__DESTINATION_INFO;
    public static final int NAVIGATION_SERVICE__CURRENT_ALTITUDE;
    public static final int NAVIGATION_SERVICE__NAVIGATION_STATUS;
    public static final int NAVIGATION_SERVICE__CURRENT_POSITION_INFO;
    public static final int NAVIGATION_SERVICE__ROUTE_GUIDANCE_STATE;
    public static final int NAVIGATION_SERVICE__NAVIGATION_OPERATION_STATE;
    public static final int NAVIGATION_SERVICE__FAVORITE_DESTINATIONS_NUMBER_OF_ENTRYS;
    public static final int NAVIGATION_SERVICE__GPS_SIGNAL_AVAILABLE;
    public static final int NAVIGATION_SERVICE__DEMO_MODE_ACTIVE;
    public static final int NAVIGATION_SERVICE__GAL_ROUTE_GUIDANCE_ACTIVE;
    public static final int NAVIGATION_SERVICE__ACTIVE_MAP_TYPE;
    public static final int NAVIGATION_SERVICE__TIME_TO_DESTINATION;
    public static final int NAVIGATION_SERVICE__DISTANCE_TO_DESTINATION;
    public static final int NAVIGATION_SERVICE__STOPOVER_INFO;
    public static final int NAVIGATION_SERVICE__DISTANCE_TO_NEXT_MANEUVER;
    public static final int NAVIGATION_SERVICE__SETUP_LANE_GUIDANCE_ACTIVE;
    public static final int NAVIGATION_SERVICE__VOICE_GUIDANCE_STATUS;
    public static final int NAVIGATION_SERVICE__GUIDANCE_ANNOUNCEMENT_ACTIVE;
    public static final int NAVIGATION_SERVICE__ACTIVE_MAP_VIEW;
    public static final int NAVIGATION_SERVICE__SUPPORTED_MAP_VIEWS;
    public static final int NAVIGATION_SERVICE__MAP_SCALE;
    public static final int NAVIGATION_SERVICE__SUPPORTED_MAP_TYPES;
    public static final int NAVIGATION_SERVICE__ACTIVE_MAP_ORIENTATION;
    public static final int NAVIGATION_SERVICE__SUPPORTED_MAP_ORIENTATIONS;
    public static final int NAVIGATION_SERVICE__ONLINE_NAVIGATION_SYSTEM;
    public static final int NAVIGATION_SERVICE__ONLINE_NAVIGATION_STATE;
    public static final int NAVIGATION_SERVICE__TIME_TO_DESTINATION_TIME_INFO;
    public static final int NAVIGATION_SERVICE__REMAINING_TRAVEL_TIME;
    public static final int NAVIGATION_SERVICE__TURN_TO_INFO;
    public static final int NAVIGATION_SERVICE__SUGGEST_ALTERNATIVE_ROUTE_CALCULATION;
    public static final int NAVIGATION_SERVICE__COMPASS_INFO;
    public static final int NAVIGATION_SERVICE__TMC_SYMBOL;
    public static final int NAVIGATION_SERVICE__LANE_GUIDANCE;
    public static final int NAVIGATION_SERVICE__FAVORITE_DESTINATIONS;
    public static final int NAVIGATION_SERVICE__LAST_DESTINATIONS;
    public static final int NAVIGATION_SERVICE__MANEUVER_DESCRIPTOR;
    public static final int NAVIGATION_SERVICE__TMC_INFOS;
    public static final int NAVIGATION_SERVICE__TMC_SIGNAL_AVAILABLE;
    public static final int NAVIGATION_SERVICE__VICS_SIGNAL_AVAILABLE;
    public static final int NAVIGATION_SERVICE__KOMBI_MAP_STATUS;
    public static final int NAVIGATION_SERVICE__KOMBI_MAP_VISIBILITY;
    public static final int NAVIGATION_SERVICE__NAVIGATION_SERVICE_STATE;
    public static final int NAVIGATION_SERVICE__SWITCH_MAP_TO_ABT;
    public static final int NAVIGATION_SERVICE__SWITCH_MAP_TO_INSTRUMENT_CLUSTER;
    public static final int NAVIGATION_SERVICE__MAP_SWITCH_STATE;
    public static final int NAVIGATION_SERVICE__MAP_VISIBILITY_IN_ABT;
    public static final int NAVIGATION_SERVICE__HMI_EVENT__ROUTE_GUIDANCE_NOT_SUCCESSFUL;
    public static final int NAVIGATION_SERVICE__HMI_EVENT__HOME_ADDRESS_NOT_SPECIFIED;
    public static final int NAVIGATION_SERVICE__HMI_EVENT__ROUTE_GUIDANCE_STARTING;
    public static final int NAVIGATION_SERVICE__HMI_EVENT__TMC_X_URGENT_MESSAGE_CONFIRMED;

    default public void updateNavigationData(NavigationService navigationService, int n) {
    }
}

