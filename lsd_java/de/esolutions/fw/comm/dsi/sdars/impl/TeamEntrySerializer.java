/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.TeamEntry;

public class TeamEntrySerializer {
    public static void putOptionalTeamEntry(ISerializer iSerializer, TeamEntry teamEntry) {
        boolean bl = teamEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = teamEntry.getSeekID();
            iSerializer.putInt32(n);
            int n2 = teamEntry.getContentLink();
            iSerializer.putInt32(n2);
            int n3 = teamEntry.getLeagueLink();
            iSerializer.putInt32(n3);
            String string = teamEntry.getTeamName();
            iSerializer.putOptionalString(string);
            String string2 = teamEntry.getTeamNameAbbrevation();
            iSerializer.putOptionalString(string2);
            String string3 = teamEntry.getTeamNameNick();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalTeamEntryVarArray(ISerializer iSerializer, TeamEntry[] teamEntryArray) {
        boolean bl = teamEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(teamEntryArray.length);
            for (int i2 = 0; i2 < teamEntryArray.length; ++i2) {
                TeamEntrySerializer.putOptionalTeamEntry(iSerializer, teamEntryArray[i2]);
            }
        }
    }

    public static TeamEntry getOptionalTeamEntry(IDeserializer iDeserializer) {
        TeamEntry teamEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            int n;
            int n2;
            int n3;
            teamEntry = new TeamEntry();
            teamEntry.seekID = n3 = iDeserializer.getInt32();
            teamEntry.contentLink = n2 = iDeserializer.getInt32();
            teamEntry.leagueLink = n = iDeserializer.getInt32();
            teamEntry.teamName = string3 = iDeserializer.getOptionalString();
            teamEntry.teamNameAbbrevation = string2 = iDeserializer.getOptionalString();
            teamEntry.teamNameNick = string = iDeserializer.getOptionalString();
        }
        return teamEntry;
    }

    public static TeamEntry[] getOptionalTeamEntryVarArray(IDeserializer iDeserializer) {
        TeamEntry[] teamEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            teamEntryArray = new TeamEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                teamEntryArray[i2] = TeamEntrySerializer.getOptionalTeamEntry(iDeserializer);
            }
        }
        return teamEntryArray;
    }
}

