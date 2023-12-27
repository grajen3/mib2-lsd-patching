/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.HighlightSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.Token;

public class TokenSerializer {
    public static void putOptionalToken(ISerializer iSerializer, Token token) {
        boolean bl = token == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = token.getWordType();
            iSerializer.putInt32(n);
            String string = token.getToken();
            iSerializer.putOptionalString(string);
            Highlight[] highlightArray = token.getHighlights();
            HighlightSerializer.putOptionalHighlightVarArray(iSerializer, highlightArray);
        }
    }

    public static void putOptionalTokenVarArray(ISerializer iSerializer, Token[] tokenArray) {
        boolean bl = tokenArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tokenArray.length);
            for (int i2 = 0; i2 < tokenArray.length; ++i2) {
                TokenSerializer.putOptionalToken(iSerializer, tokenArray[i2]);
            }
        }
    }

    public static Token getOptionalToken(IDeserializer iDeserializer) {
        Token token = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            token = new Token();
            token.wordType = n = iDeserializer.getInt32();
            token.token = string = iDeserializer.getOptionalString();
            Highlight[] highlightArray = HighlightSerializer.getOptionalHighlightVarArray(iDeserializer);
            token.highlights = highlightArray;
        }
        return token;
    }

    public static Token[] getOptionalTokenVarArray(IDeserializer iDeserializer) {
        Token[] tokenArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tokenArray = new Token[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tokenArray[i2] = TokenSerializer.getOptionalToken(iDeserializer);
            }
        }
        return tokenArray;
    }
}

