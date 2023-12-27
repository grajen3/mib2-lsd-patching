/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Suggestion;

public class SuggestionSerializer {
    public static void putOptionalSuggestion(ISerializer iSerializer, Suggestion suggestion) {
        boolean bl = suggestion == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = suggestion.getQuery();
            iSerializer.putOptionalString(string);
            String string2 = suggestion.getSuggestion();
            iSerializer.putOptionalString(string2);
            String string3 = suggestion.getFullSuggestion();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalSuggestionVarArray(ISerializer iSerializer, Suggestion[] suggestionArray) {
        boolean bl = suggestionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suggestionArray.length);
            for (int i2 = 0; i2 < suggestionArray.length; ++i2) {
                SuggestionSerializer.putOptionalSuggestion(iSerializer, suggestionArray[i2]);
            }
        }
    }

    public static Suggestion getOptionalSuggestion(IDeserializer iDeserializer) {
        Suggestion suggestion = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            suggestion = new Suggestion();
            suggestion.query = string3 = iDeserializer.getOptionalString();
            suggestion.suggestion = string2 = iDeserializer.getOptionalString();
            suggestion.fullSuggestion = string = iDeserializer.getOptionalString();
        }
        return suggestion;
    }

    public static Suggestion[] getOptionalSuggestionVarArray(IDeserializer iDeserializer) {
        Suggestion[] suggestionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suggestionArray = new Suggestion[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suggestionArray[i2] = SuggestionSerializer.getOptionalSuggestion(iDeserializer);
            }
        }
        return suggestionArray;
    }
}

