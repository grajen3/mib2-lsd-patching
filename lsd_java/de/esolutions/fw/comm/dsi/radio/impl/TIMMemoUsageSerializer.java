/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.TIMMemoUsage;

public class TIMMemoUsageSerializer {
    public static void putOptionalTIMMemoUsage(ISerializer iSerializer, TIMMemoUsage tIMMemoUsage) {
        boolean bl = tIMMemoUsage == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tIMMemoUsage.getMemoUsage();
            iSerializer.putInt32(n);
            int n2 = tIMMemoUsage.getFreeListRows();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalTIMMemoUsageVarArray(ISerializer iSerializer, TIMMemoUsage[] tIMMemoUsageArray) {
        boolean bl = tIMMemoUsageArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tIMMemoUsageArray.length);
            for (int i2 = 0; i2 < tIMMemoUsageArray.length; ++i2) {
                TIMMemoUsageSerializer.putOptionalTIMMemoUsage(iSerializer, tIMMemoUsageArray[i2]);
            }
        }
    }

    public static TIMMemoUsage getOptionalTIMMemoUsage(IDeserializer iDeserializer) {
        TIMMemoUsage tIMMemoUsage = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            tIMMemoUsage = new TIMMemoUsage();
            tIMMemoUsage.memoUsage = n2 = iDeserializer.getInt32();
            tIMMemoUsage.freeListRows = n = iDeserializer.getInt32();
        }
        return tIMMemoUsage;
    }

    public static TIMMemoUsage[] getOptionalTIMMemoUsageVarArray(IDeserializer iDeserializer) {
        TIMMemoUsage[] tIMMemoUsageArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tIMMemoUsageArray = new TIMMemoUsage[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tIMMemoUsageArray[i2] = TIMMemoUsageSerializer.getOptionalTIMMemoUsage(iDeserializer);
            }
        }
        return tIMMemoUsageArray;
    }
}

