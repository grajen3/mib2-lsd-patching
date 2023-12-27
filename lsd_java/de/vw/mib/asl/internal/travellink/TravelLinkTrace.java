/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

public final class TravelLinkTrace {
    private String[] requestTypes = new String[60];

    public TravelLinkTrace() {
        this.requestTypes[0] = "REQUESTTYPE_TL_MAIN_STOP_UPDATES";
        this.requestTypes[1] = "REQUESTTYPE_TL_MAIN_SUBSCRIPTION_STATE";
        this.requestTypes[2] = "REQUESTTYPE_TL_SPORTS_HEAD_TO_HEAD_GAMES";
        this.requestTypes[3] = "REQUESTTYPE_TL_SPORTS_HEAD_TO_HEAD_GAME_DETAILS";
        this.requestTypes[4] = "REQUESTTYPE_TL_SPORTS_GAMES_FAVORITES";
        this.requestTypes[5] = "REQUESTTYPE_TL_SPORTS_RANKED_LIST_EVENTS";
        this.requestTypes[6] = "REQUESTTYPE_TL_SPORTS_RANKED_LIST_EVENT_RANKINGS";
        this.requestTypes[7] = "REQUESTTYPE_TL_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL";
        this.requestTypes[8] = "REQUESTTYPE_TL_SPORTS_RANKED_LIST_EVENT_INFO";
        this.requestTypes[9] = "REQUESTTYPE_TL_SPORTS_EVENT_RANKINGS";
        this.requestTypes[10] = "REQUESTTYPE_TL_SPORTS_EVENT_INFO";
        this.requestTypes[11] = "REQUESTTYPE_TL_SPORTS_LEAGUE_NEWS";
        this.requestTypes[12] = "REQUESTTYPE_TL_SPORTS_LEAGES";
        this.requestTypes[13] = "REQUESTTYPE_TL_SPORTS_GAME_TUNE_CHANNEL";
        this.requestTypes[14] = "REQUESTTYPE_TL_SPORTS_DELETE_FAVORITE_TEAM";
        this.requestTypes[15] = "REQUESTTYPE_TL_SPORTS_ADD_FAVORITE_TEAM";
        this.requestTypes[16] = "REQUESTTYPE_TL_SPORTS_LEAGUE_LIVE_BROADCAST";
        this.requestTypes[17] = "REQUESTTYPE_TL_WEATHER_FORECAST";
        this.requestTypes[18] = "REQUESTTYPE_TL_WEATHER_FAVORITE_CITY_LIST";
        this.requestTypes[19] = "REQUESTTYPE_TL_WEATHER_STATE_LIST";
        this.requestTypes[20] = "REQUESTTYPE_TL_WEATHER_STATIONS_FOR_ONE_STATE";
        this.requestTypes[21] = "REQUESTTYPE_TL_WEATHER_DELETE_FAVORITE_WEATHER_STATION";
        this.requestTypes[22] = "REQUESTTYPE_TL_WEATHER_ADD_FAVORITE_WEATHER_STATION";
        this.requestTypes[23] = "REQUESTTYPE_TL_SKI_CONDITIONS_FOR_SKI_RESORT";
        this.requestTypes[24] = "REQUESTTYPE_TL_SKI_STATE_LIST";
        this.requestTypes[25] = "REQUESTTYPE_TL_SKI_ADD_FAVORITE_SKI_RESORT";
        this.requestTypes[26] = "REQUESTTYPE_TL_SKI_DELETE_FAVORITE_SKI_RESORT";
        this.requestTypes[27] = "REQUESTTYPE_TL_SKI_FAVORITE_SKI_RESORTS";
        this.requestTypes[28] = "REQUESTTYPE_TL_SKI_RESORTS_FOR_ONE_STATE";
        this.requestTypes[29] = "REQUESTTYPE_TL_FUEL_GAS_STATIONS";
        this.requestTypes[30] = "REQUESTTYPE_TL_FUEL_GAS_STATION_DETAILS";
        this.requestTypes[31] = "REQUESTTYPE_TL_MOVIES_SEARCH_THEATERS_FOR_ONE_MOVIE";
        this.requestTypes[32] = "REQUESTTYPE_TL_MOVIE_MOVIE_DETAILS";
        this.requestTypes[33] = "REQUESTTYPE_TL_MOVIETHEATERS_ALL_THEATER_SHOW_TIMES";
        this.requestTypes[34] = "REQUESTTYPE_TL_SPORTS_TEAMS";
        this.requestTypes[35] = "REQUESTTYPE_TL_MOVIETHEATERS_SEARCH_THEATERS";
        this.requestTypes[36] = "REQUESTTYPE_TL_MOVIES_SEARCH_ALL_MOVIES";
        this.requestTypes[37] = "REQUESTTYPE_TL_SPORTS_SELECTTEAM_LEAGUES";
        this.requestTypes[38] = "REQUESTTYPE_TL_SPORTS_SELECTTEAM_TEAMS";
        this.requestTypes[39] = "REQUESTTYPE_TL_GRAPHICAL_WEATHER_STORM_INFO";
        this.requestTypes[40] = "REQUESTTYPE_TL_WEATHER_SPECIFIC_WEATHER_STATION";
        this.requestTypes[41] = "REQUESTTYPE_TL_SKI_CONDITIONS_FOR_SKI_RESORT_ID";
        this.requestTypes[42] = "REQUESTTYPE_TL_SPORTS_FAVORITES_HEAD_TO_HEAD_GAMES";
        this.requestTypes[43] = "REQUESTTYPE_TL_SUB_WEATHER_FORECAST_NEAR_BY";
        this.requestTypes[44] = "REQUESTTYPE_TL_SUB_WEATHER_FORECAST_STATION_ID";
        this.requestTypes[45] = "REQUESTTYPE_TL_SUB_SPORTS_HEAD_TO_HEAD_GAMES";
        this.requestTypes[46] = "REQUESTTYPE_TL_SUB_SPORTS_HEAD_TO_HEAD_FAVORITES_GAMES";
        this.requestTypes[47] = "REQUESTTYPE_TL_SUB_SKI_CONDITIONS_FOR_SKI_RESORT";
        this.requestTypes[48] = "REQUESTTYPE_TL_SUB_SKI_CONDITIONS_FOR_NEARBY_SKI_RESORT";
        this.requestTypes[49] = "REQUESTTYPE_TL_SUB_FUEL_CLOSEST_GAS_STATION";
        this.requestTypes[50] = "REQUESTTYPE_TL_SUB_MOVIETHEATERS_CLOSEST_THEATER";
        this.requestTypes[51] = "REQUESTTYPE_TL_FUEL_FUEL_TYPES";
        this.requestTypes[52] = "REQUESTTYPE_TL_SPORTS_FAVORITE_TEAMS";
    }

    public String getRequestTypeAsString(int n) {
        if (n >= 0 && n < this.requestTypes.length) {
            return this.requestTypes[n];
        }
        return String.valueOf(n);
    }
}

