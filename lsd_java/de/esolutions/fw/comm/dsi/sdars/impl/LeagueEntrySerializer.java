/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.LeagueEntry;

public class LeagueEntrySerializer {
    public static void putOptionalLeagueEntry(ISerializer iSerializer, LeagueEntry leagueEntry) {
        boolean bl = leagueEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = leagueEntry.getSeekID();
            iSerializer.putInt32(n);
            int n2 = leagueEntry.getContentLink();
            iSerializer.putInt32(n2);
            String string = leagueEntry.getLeagueName();
            iSerializer.putOptionalString(string);
            String string2 = leagueEntry.getLeagueNameAbbrevation();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalLeagueEntryVarArray(ISerializer iSerializer, LeagueEntry[] leagueEntryArray) {
        boolean bl = leagueEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(leagueEntryArray.length);
            for (int i2 = 0; i2 < leagueEntryArray.length; ++i2) {
                LeagueEntrySerializer.putOptionalLeagueEntry(iSerializer, leagueEntryArray[i2]);
            }
        }
    }

    public static LeagueEntry getOptionalLeagueEntry(IDeserializer iDeserializer) {
        LeagueEntry leagueEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            leagueEntry = new LeagueEntry();
            leagueEntry.seekID = n2 = iDeserializer.getInt32();
            leagueEntry.contentLink = n = iDeserializer.getInt32();
            leagueEntry.leagueName = string2 = iDeserializer.getOptionalString();
            leagueEntry.leagueNameAbbrevation = string = iDeserializer.getOptionalString();
        }
        return leagueEntry;
    }

    public static LeagueEntry[] getOptionalLeagueEntryVarArray(IDeserializer iDeserializer) {
        LeagueEntry[] leagueEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            leagueEntryArray = new LeagueEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                leagueEntryArray[i2] = LeagueEntrySerializer.getOptionalLeagueEntry(iDeserializer);
            }
        }
        return leagueEntryArray;
    }
}

