/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.Grammar;

public class GrammarSerializer {
    public static void putOptionalGrammar(ISerializer iSerializer, Grammar grammar) {
        boolean bl = grammar == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = grammar.getGrammarType();
            iSerializer.putInt32(n);
            int n2 = grammar.getCommandHierarchy();
            iSerializer.putInt32(n2);
            boolean bl2 = grammar.isPublicGrammar();
            iSerializer.putBool(bl2);
            String[] stringArray = grammar.getListData();
            iSerializer.putOptionalStringVarArray(stringArray);
            long[] lArray = grammar.getListIdData();
            iSerializer.putOptionalInt64VarArray(lArray);
            int n3 = grammar.getListSourceId();
            iSerializer.putInt32(n3);
            int n4 = grammar.getGrammarId();
            iSerializer.putInt32(n4);
            String string = grammar.getGrammarText();
            iSerializer.putOptionalString(string);
            int n5 = grammar.getNBestGraphemicGroupIndex();
            iSerializer.putInt32(n5);
            int n6 = grammar.getNBestListID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalGrammarVarArray(ISerializer iSerializer, Grammar[] grammarArray) {
        boolean bl = grammarArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(grammarArray.length);
            for (int i2 = 0; i2 < grammarArray.length; ++i2) {
                GrammarSerializer.putOptionalGrammar(iSerializer, grammarArray[i2]);
            }
        }
    }

    public static Grammar getOptionalGrammar(IDeserializer iDeserializer) {
        Grammar grammar = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            int n3;
            int n4;
            boolean bl2;
            int n5;
            int n6;
            grammar = new Grammar();
            grammar.grammarType = n6 = iDeserializer.getInt32();
            grammar.commandHierarchy = n5 = iDeserializer.getInt32();
            grammar.publicGrammar = bl2 = iDeserializer.getBool();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            grammar.listData = stringArray;
            long[] lArray = iDeserializer.getOptionalInt64VarArray();
            grammar.listIdData = lArray;
            grammar.listSourceId = n4 = iDeserializer.getInt32();
            grammar.grammarId = n3 = iDeserializer.getInt32();
            grammar.grammarText = string = iDeserializer.getOptionalString();
            grammar.nBestGraphemicGroupIndex = n2 = iDeserializer.getInt32();
            grammar.nBestListID = n = iDeserializer.getInt32();
        }
        return grammar;
    }

    public static Grammar[] getOptionalGrammarVarArray(IDeserializer iDeserializer) {
        Grammar[] grammarArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            grammarArray = new Grammar[n];
            for (int i2 = 0; i2 < n; ++i2) {
                grammarArray[i2] = GrammarSerializer.getOptionalGrammar(iDeserializer);
            }
        }
        return grammarArray;
    }
}

