/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.GrammarStateInfo;

public class GrammarStateInfoSerializer {
    public static void putOptionalGrammarStateInfo(ISerializer iSerializer, GrammarStateInfo grammarStateInfo) {
        boolean bl = grammarStateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = grammarStateInfo.getGrammarStatus();
            iSerializer.putInt32(n);
            int[] nArray = grammarStateInfo.getSlotIds();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalGrammarStateInfoVarArray(ISerializer iSerializer, GrammarStateInfo[] grammarStateInfoArray) {
        boolean bl = grammarStateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(grammarStateInfoArray.length);
            for (int i2 = 0; i2 < grammarStateInfoArray.length; ++i2) {
                GrammarStateInfoSerializer.putOptionalGrammarStateInfo(iSerializer, grammarStateInfoArray[i2]);
            }
        }
    }

    public static GrammarStateInfo getOptionalGrammarStateInfo(IDeserializer iDeserializer) {
        GrammarStateInfo grammarStateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            grammarStateInfo = new GrammarStateInfo();
            grammarStateInfo.grammarStatus = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            grammarStateInfo.slotIds = nArray;
        }
        return grammarStateInfo;
    }

    public static GrammarStateInfo[] getOptionalGrammarStateInfoVarArray(IDeserializer iDeserializer) {
        GrammarStateInfo[] grammarStateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            grammarStateInfoArray = new GrammarStateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                grammarStateInfoArray[i2] = GrammarStateInfoSerializer.getOptionalGrammarStateInfo(iDeserializer);
            }
        }
        return grammarStateInfoArray;
    }
}

