/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SFecHistorySerializer {
    public static void putOptionalSFecHistory(ISerializer iSerializer, SFecHistory sFecHistory) {
        boolean bl = sFecHistory == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sFecHistory.getFsid();
            iSerializer.putUInt32(l);
            String string = sFecHistory.getTimestamp();
            iSerializer.putOptionalString(string);
            String string2 = sFecHistory.getActivity();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalSFecHistoryVarArray(ISerializer iSerializer, SFecHistory[] sFecHistoryArray) {
        boolean bl = sFecHistoryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFecHistoryArray.length);
            for (int i2 = 0; i2 < sFecHistoryArray.length; ++i2) {
                SFecHistorySerializer.putOptionalSFecHistory(iSerializer, sFecHistoryArray[i2]);
            }
        }
    }

    public static SFecHistory getOptionalSFecHistory(IDeserializer iDeserializer) {
        SFecHistory sFecHistory = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            long l;
            sFecHistory = new SFecHistory();
            sFecHistory.fsid = l = iDeserializer.getUInt32();
            sFecHistory.timestamp = string2 = iDeserializer.getOptionalString();
            sFecHistory.activity = string = iDeserializer.getOptionalString();
        }
        return sFecHistory;
    }

    public static SFecHistory[] getOptionalSFecHistoryVarArray(IDeserializer iDeserializer) {
        SFecHistory[] sFecHistoryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFecHistoryArray = new SFecHistory[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFecHistoryArray[i2] = SFecHistorySerializer.getOptionalSFecHistory(iDeserializer);
            }
        }
        return sFecHistoryArray;
    }
}

