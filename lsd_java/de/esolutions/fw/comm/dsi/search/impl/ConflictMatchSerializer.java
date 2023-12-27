/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.CountrySerializer;
import de.esolutions.fw.comm.dsi.search.impl.TokenSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.Token;

public class ConflictMatchSerializer {
    public static void putOptionalConflictMatch(ISerializer iSerializer, ConflictMatch conflictMatch) {
        boolean bl = conflictMatch == null;
        iSerializer.putBool(bl);
        if (!bl) {
            Token token = conflictMatch.getToken();
            TokenSerializer.putOptionalToken(iSerializer, token);
            Country country = conflictMatch.getCountry();
            CountrySerializer.putOptionalCountry(iSerializer, country);
            int n = conflictMatch.getType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalConflictMatchVarArray(ISerializer iSerializer, ConflictMatch[] conflictMatchArray) {
        boolean bl = conflictMatchArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(conflictMatchArray.length);
            for (int i2 = 0; i2 < conflictMatchArray.length; ++i2) {
                ConflictMatchSerializer.putOptionalConflictMatch(iSerializer, conflictMatchArray[i2]);
            }
        }
    }

    public static ConflictMatch getOptionalConflictMatch(IDeserializer iDeserializer) {
        ConflictMatch conflictMatch = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            Country country;
            Token token;
            conflictMatch = new ConflictMatch();
            conflictMatch.token = token = TokenSerializer.getOptionalToken(iDeserializer);
            conflictMatch.country = country = CountrySerializer.getOptionalCountry(iDeserializer);
            conflictMatch.type = n = iDeserializer.getInt32();
        }
        return conflictMatch;
    }

    public static ConflictMatch[] getOptionalConflictMatchVarArray(IDeserializer iDeserializer) {
        ConflictMatch[] conflictMatchArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            conflictMatchArray = new ConflictMatch[n];
            for (int i2 = 0; i2 < n; ++i2) {
                conflictMatchArray[i2] = ConflictMatchSerializer.getOptionalConflictMatch(iDeserializer);
            }
        }
        return conflictMatchArray;
    }
}

