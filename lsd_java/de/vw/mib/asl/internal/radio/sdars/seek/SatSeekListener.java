/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekDsiException;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class SatSeekListener
implements DSISDARSSeekListener {
    private IAslPool mPool;

    public SatSeekListener(IAslPool iAslPool) {
        this.mPool = iAslPool;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.mPool.setString(46, "SEEK_ASYNC_EXCEPTION");
        this.mPool.setObject(109, new SatSeekDsiException(n, string, n2));
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_SEEKPOSSIBILITY");
            this.mPool.setObject(101, seekPossibility);
        }
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_SEEKLIST");
            this.mPool.setObjectArray(102, seekEntryArray);
        }
    }

    @Override
    public void updateLeagueList(LeagueEntry[] leagueEntryArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_LEAGUELIST");
            this.mPool.setObjectArray(103, leagueEntryArray);
        }
    }

    public void updateTeamList(TeamEntry[] teamEntryArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_TEAMLIST");
            this.mPool.setObjectArray(104, teamEntryArray);
        }
    }

    @Override
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_TRAFFICWEATHERLIST");
            this.mPool.setObjectArray(105, trafficWxEntryArray);
        }
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_SEEKALERT");
            this.mPool.setObject(106, seekAlert);
        }
    }

    @Override
    public void setSeekCommandResult(int n) {
        this.mPool.setString(46, "RESPONSE_SEEK_COMMAND");
        this.mPool.setInt(107, n);
    }

    @Override
    public void manageSeekResult(int n) {
        this.mPool.setString(46, "RESPONSE_MANAGE_SEEK");
        this.mPool.setInt(108, n);
    }

    @Override
    public void leagues(LeagueEntry[] leagueEntryArray) {
    }

    @Override
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
    }

    @Override
    public void updateRegisteredTeams(TeamEntry[] teamEntryArray, int n) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }
}

