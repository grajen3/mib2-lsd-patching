/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.GrammarInfo;

public class GrammarInfoSerializer {
    public static void putOptionalGrammarInfo(ISerializer iSerializer, GrammarInfo grammarInfo) {
        boolean bl = grammarInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = grammarInfo.getId();
            iSerializer.putInt32(n);
            int n2 = grammarInfo.getCommandHieratchy();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalGrammarInfoVarArray(ISerializer iSerializer, GrammarInfo[] grammarInfoArray) {
        boolean bl = grammarInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(grammarInfoArray.length);
            for (int i2 = 0; i2 < grammarInfoArray.length; ++i2) {
                GrammarInfoSerializer.putOptionalGrammarInfo(iSerializer, grammarInfoArray[i2]);
            }
        }
    }

    public static GrammarInfo getOptionalGrammarInfo(IDeserializer iDeserializer) {
        GrammarInfo grammarInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            grammarInfo = new GrammarInfo();
            grammarInfo.id = n2 = iDeserializer.getInt32();
            grammarInfo.commandHieratchy = n = iDeserializer.getInt32();
        }
        return grammarInfo;
    }

    public static GrammarInfo[] getOptionalGrammarInfoVarArray(IDeserializer iDeserializer) {
        GrammarInfo[] grammarInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            grammarInfoArray = new GrammarInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                grammarInfoArray[i2] = GrammarInfoSerializer.getOptionalGrammarInfo(iDeserializer);
            }
        }
        return grammarInfoArray;
    }
}

