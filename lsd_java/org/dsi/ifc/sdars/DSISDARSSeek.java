/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIBase;

public interface DSISDARSSeek
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SEEKPOSSIBILITY;
    public static final int ATTR_SEEKLIST;
    public static final int ATTR_SEEKALERT;
    public static final int ATTR_LEAGUELIST;
    public static final int ATTR_TRAFFICWEATHERLIST;
    public static final int ATTR_REGISTEREDTEAMS;
    public static final int ATTR_PROFILESTATE;
    public static final int RT_SETSEEKCOMMAND;
    public static final int RT_MANAGESEEK;
    public static final int RT_RESET;
    public static final int RT_MANAGESEEK2;
    public static final int RT_GETTEAMSOFLEAGUE;
    public static final int RT_GETLEAGUES;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int RP_SETSEEKCOMMANDRESULT;
    public static final int RP_MANAGESEEKRESULT;
    public static final int RP_TEAMSOFLEAGUE;
    public static final int RP_LEAGUES;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;
    public static final int RESETTYPE_TO_DEFAULT;
    public static final int TYPEOFCONTENT_UNKNOWN;
    public static final int TYPEOFCONTENT_SONGARTIST;
    public static final int TYPEOFCONTENT_LEAGUE;
    public static final int TYPEOFCONTENT_TEAM;
    public static final int TYPEOFCONTENT_TRAFFICWX;
    public static final int SEEKCONTENTID_UNLINKED;
    public static final int SEEKTYPE_UNKNOWN;
    public static final int SEEKTYPE_SONG;
    public static final int SEEKTYPE_ARTIST;
    public static final int SEEKTYPE_LEAGUE;
    public static final int SEEKTYPE_TEAMA;
    public static final int SEEKTYPE_TEAMB;
    public static final int SEEKTYPE_TRAFFICWX;
    public static final int SEEKINFO_UNDEFINED;
    public static final int SEEKINFO_SHORTARTISTNAME;
    public static final int SEEKINFO_LONGARTISTNAME;
    public static final int SEEKINFO_SHORTPROGRAMTITLE;
    public static final int SEEKINFO_LONGPROGRAMTITLE;
    public static final int SEEKINFO_SHORTTEAMA;
    public static final int SEEKINFO_LONGTEAMA;
    public static final int SEEKINFO_SHORTTEAMB;
    public static final int SEEKINFO_LONGTEAMB;
    public static final int SEEKINFO_NAMETEAMA;
    public static final int SEEKINFO_NICKNAMETEAMA;
    public static final int SEEKINFO_ABBREVIATIONTEAMA;
    public static final int SEEKINFO_NAMETEAMB;
    public static final int SEEKINFO_NICKNAMETEAMB;
    public static final int SEEKINFO_ABBREVIATIONTEAMB;
    public static final int SEEKINFO_LEAGUE_NAME;
    public static final int SEEKINFO_LEAGUE_ABBREVIATION;
    public static final int STATE_ACTIVATED;
    public static final int STATE_INACTIVATED;
    public static final int SEEKCOMMAND_ADD;
    public static final int SEEKCOMMAND_REMOVE;
    public static final int SEEKCOMMANDRESULT_OK;
    public static final int SEEKCOMMANDRESULT_NOK;
    public static final int SEEKMANAGEACTION_ACTIVATE;
    public static final int SEEKMANAGEACTION_DEACTIVATE;
    public static final int SEEKMANAGEACTION_DELETE;
    public static final int SEEKMANAGEMENTRESULT_OK;
    public static final int SEEKMANAGEMENTRESULT_NOK;
    public static final int ALERTTYPE_START;
    public static final int ALERTTYPE_END;
    public static final int RESETSEEKTYPE_UNDEFINED;
    public static final int RESETSEEKTYPE_TO_DEFAULT;
    public static final int RESETSEEKTYPE_ANONYMIZE;

    default public void setSeekCommand(int n, int n2, int n3) {
    }

    default public void manageSeek(int n, int n2) {
    }

    default public void manageSeek2(int n, int n2, int n3, int n4) {
    }

    default public void getTeamsOfLeague(int n) {
    }

    default public void getLeagues() {
    }

    default public void reset(int n) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }
}

