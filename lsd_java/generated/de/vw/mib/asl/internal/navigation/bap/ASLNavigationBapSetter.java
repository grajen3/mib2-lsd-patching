/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap;

public interface ASLNavigationBapSetter {
    public static final int SET_DAY_NIGHT_MODE;
    public static final int SET_DAY_NIGHT_MODE__P0_VALUE__INT;
    public static final int SET_DAY_NIGHT_MODE__VALUE__C0_DAY;
    public static final int SET_DAY_NIGHT_MODE__VALUE__C1_NIGHT;
    public static final int SET_DAY_NIGHT_MODE__VALUE__C2_AUTOMATIC;
    public static final int SET_ACTIVE_MAP_TYPE;
    public static final int SET_ACTIVE_MAP_TYPE__P0_MAPTYPE__INT;
    public static final int SET_ACTIVE_MAP_TYPE__MAPTYPE__C0_DESTINATION;
    public static final int SET_ACTIVE_MAP_TYPE__MAPTYPE__C1_DESTINATION_2D;
    public static final int SET_ACTIVE_MAP_TYPE__MAPTYPE__C2_DESTINATION_3D;
    public static final int SET_ACTIVE_MAP_TYPE__MAPTYPE__C3_OVERVIEW;
    public static final int SET_ACTIVE_MAP_VIEW;
    public static final int SET_ACTIVE_MAP_VIEW__P0_VIEW__INT;
    public static final int SET_ACTIVE_MAP_VIEW__VIEW__C0_STANDARD;
    public static final int SET_ACTIVE_MAP_VIEW__VIEW__C1_GOOGLE_EARTH;
    public static final int SET_ACTIVE_MAP_VIEW__VIEW__C2_TRAFFIC;
    public static final int SET_ACTIVE_MAP_ORIENTATION;
    public static final int SET_ACTIVE_MAP_ORIENTATION__P0_ORIENTATION__INT;
    public static final int SET_ACTIVE_MAP_ORIENTATION__ORIENTATION__C0_AUTOMATIC;
    public static final int SET_ACTIVE_MAP_ORIENTATION__ORIENTATION__C1_NORTH;
    public static final int SET_ACTIVE_MAP_ORIENTATION__ORIENTATION__C2_DIRECTION_OF_TRAVEL;
    public static final int SET_MAP_SCALE_STEPS;
    public static final int SET_MAP_SCALE_STEPS__P0_STEPS__INT;
    public static final int SET_MAP_SCALE_STEPS__P1_AUTOZOOM__INT;
    public static final int SET_MAP_SCALE_STEPS__AUTOZOOM__C0_DISABLED;
    public static final int SET_MAP_SCALE_STEPS__AUTOZOOM__C1_ACTIVE;
    public static final int SET_ALTERNATIVE_ROUTE_CALC_SETTING;
    public static final int SET_ALTERNATIVE_ROUTE_CALC_SETTING__P0_USEALTERNATIVEROUTECALCULATION__BOOLEAN;
    public static final boolean SET_ALTERNATIVE_ROUTE_CALC_SETTING__USEALTERNATIVEROUTECALCULATION__C0_FALSE;
    public static final boolean SET_ALTERNATIVE_ROUTE_CALC_SETTING__USEALTERNATIVEROUTECALCULATION__C1_TRUE;
    public static final int REPEAT_LAST_NAV_ANNOUNCEMENT;
    public static final int STOP_CURRENT_ANNOUNCEMENT;
    public static final int CONFIRM_X_URGENT_MESSAGE;
    public static final int CONFIRM_X_URGENT_MESSAGE__P0_MESSAGEID__INT;
    public static final int SET_VOICE_GUIDANCE_STATUS;
    public static final int SET_VOICE_GUIDANCE_STATUS__P0_TYPE__INT;
    public static final int SET_VOICE_GUIDANCE_STATUS__TYPE__C0_ON_COMPLETE_ANNOUNCEMENTS;
    public static final int SET_VOICE_GUIDANCE_STATUS__TYPE__C1_OFF_NO_ANNOUNCEMENTS;
    public static final int SET_VOICE_GUIDANCE_STATUS__TYPE__C2_ON_REDUCED_ANNOUNCEMENTS;
    public static final int SET_VOICE_GUIDANCE_STATUS__TYPE__C3_TRAFFIC;
    public static final int GET_ADDRESS_LIST_DATA;
    public static final int GET_ADDRESS_LIST_DATA__P0_ENTRYIDS__LONG;
    public static final int GET_ADDRESS_LIST_DATA__P1_LISTTYPE__INT;
    public static final int GET_ADDRESS_LIST_DATA__LISTTYPE__C0_LAST_DESTINATIONS_LIST;
    public static final int GET_ADDRESS_LIST_DATA__LISTTYPE__C1_FAVORITE_DESTINATIONS_LIST;
    public static final int GET_ADDRESS_LIST_DATA__LISTTYPE__C2_NAV_BOOK_LIST;
    public static final int GET_ADDRESS_LIST_DATA__LISTTYPE__C3_PHONE_BOOK_LIST;
    public static final int GET_FAVORITE_DEST_VIEW_WINDOW;
    public static final int GET_FAVORITE_DEST_VIEW_WINDOW__P0_STARTENTRYPOS__INT;
    public static final int GET_FAVORITE_DEST_VIEW_WINDOW__P1_WINDOWSIZE__INT;
    public static final int GET_NAV_BOOK_VIEW_WINDOW;
    public static final int GET_NAV_BOOK_VIEW_WINDOW__P0_STARTENTRYPOS__INT;
    public static final int GET_NAV_BOOK_VIEW_WINDOW__P1_WINDOWSIZE__INT;
    public static final int NAV_BOOK_MATCH_STRING;
    public static final int NAV_BOOK_MATCH_STRING__P0_CHARACTERS__STRING;
    public static final int NAV_BOOK_START_SPELLER;
    public static final int NAV_BOOK_STOP_SPELLER;
    public static final int START_BAP_ROUTE_GUIDANCE;
    public static final int START_BAP_ROUTE_GUIDANCE__P0_TYPEOFROUTEGUIDANCEDATA__INT;
    public static final int START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C0_HOME_ADDRESS;
    public static final int START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C1_ORGANIZER_ENTRY_ID;
    public static final int START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C2_LAST_DESTINATIONS_LIST_INDEX;
    public static final int START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C3_FAVORITE_DEST_LIST_INDEX;
    public static final int START_BAP_ROUTE_GUIDANCE__P1_IDENTIFIERDATA__LONG;
    public static final int STOP_BAP_ROUTE_GUIDANCE;
}

