/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.RawDataSet;

public class RawDataSetSerializer {
    public static void putOptionalRawDataSet(ISerializer iSerializer, RawDataSet rawDataSet) {
        boolean bl = rawDataSet == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = rawDataSet.getId();
            iSerializer.putInt64(l);
            int n = rawDataSet.getEntryType();
            iSerializer.putInt32(n);
            int n2 = rawDataSet.getEntryFlags();
            iSerializer.putInt32(n2);
            byte[] byArray = rawDataSet.getData();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalRawDataSetVarArray(ISerializer iSerializer, RawDataSet[] rawDataSetArray) {
        boolean bl = rawDataSetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rawDataSetArray.length);
            for (int i2 = 0; i2 < rawDataSetArray.length; ++i2) {
                RawDataSetSerializer.putOptionalRawDataSet(iSerializer, rawDataSetArray[i2]);
            }
        }
    }

    public static RawDataSet getOptionalRawDataSet(IDeserializer iDeserializer) {
        RawDataSet rawDataSet = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            rawDataSet = new RawDataSet();
            rawDataSet.id = l = iDeserializer.getInt64();
            rawDataSet.entryType = n2 = iDeserializer.getInt32();
            rawDataSet.entryFlags = n = iDeserializer.getInt32();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            rawDataSet.data = byArray;
        }
        return rawDataSet;
    }

    public static RawDataSet[] getOptionalRawDataSetVarArray(IDeserializer iDeserializer) {
        RawDataSet[] rawDataSetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rawDataSetArray = new RawDataSet[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rawDataSetArray[i2] = RawDataSetSerializer.getOptionalRawDataSet(iDeserializer);
            }
        }
        return rawDataSetArray;
    }
}

