/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public interface DSISDARSSeekReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateSeekPossibility(SeekPossibility seekPossibility, int n) {
    }

    default public void updateSeekList(SeekEntry[] seekEntryArray, int n) {
    }

    default public void updateLeagueList(LeagueEntry[] leagueEntryArray, int n) {
    }

    default public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray, int n) {
    }

    default public void updateSeekAlert(SeekAlert seekAlert, int n) {
    }

    default public void setSeekCommandResult(int n) {
    }

    default public void manageSeekResult(int n) {
    }

    default public void teamsOfLeague(TeamEntry[] teamEntryArray) {
    }

    default public void leagues(LeagueEntry[] leagueEntryArray) {
    }

    default public void updateRegisteredTeams(TeamEntry[] teamEntryArray, int n) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

