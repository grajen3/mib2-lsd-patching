/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swap.SFscHistory;

public class SFscHistorySerializer {
    public static void putOptionalSFscHistory(ISerializer iSerializer, SFscHistory sFscHistory) {
        boolean bl = sFscHistory == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sFscHistory.getSwid();
            iSerializer.putInt32(n);
            String string = sFscHistory.getTimestamp();
            iSerializer.putOptionalString(string);
            String string2 = sFscHistory.getLoginfo();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalSFscHistoryVarArray(ISerializer iSerializer, SFscHistory[] sFscHistoryArray) {
        boolean bl = sFscHistoryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFscHistoryArray.length);
            for (int i2 = 0; i2 < sFscHistoryArray.length; ++i2) {
                SFscHistorySerializer.putOptionalSFscHistory(iSerializer, sFscHistoryArray[i2]);
            }
        }
    }

    public static SFscHistory getOptionalSFscHistory(IDeserializer iDeserializer) {
        SFscHistory sFscHistory = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            sFscHistory = new SFscHistory();
            sFscHistory.swid = n = iDeserializer.getInt32();
            sFscHistory.timestamp = string2 = iDeserializer.getOptionalString();
            sFscHistory.loginfo = string = iDeserializer.getOptionalString();
        }
        return sFscHistory;
    }

    public static SFscHistory[] getOptionalSFscHistoryVarArray(IDeserializer iDeserializer) {
        SFscHistory[] sFscHistoryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFscHistoryArray = new SFscHistory[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFscHistoryArray[i2] = SFscHistorySerializer.getOptionalSFscHistory(iDeserializer);
            }
        }
        return sFscHistoryArray;
    }
}

