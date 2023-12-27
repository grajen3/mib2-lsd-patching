/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ZeroEmissionEntrySerializer {
    public static void putOptionalZeroEmissionEntry(ISerializer iSerializer, ZeroEmissionEntry zeroEmissionEntry) {
        boolean bl = zeroEmissionEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short[] sArray = zeroEmissionEntry.getValues();
            iSerializer.putOptionalInt16VarArray(sArray);
            byte by = zeroEmissionEntry.getState();
            iSerializer.putInt8(by);
        }
    }

    public static void putOptionalZeroEmissionEntryVarArray(ISerializer iSerializer, ZeroEmissionEntry[] zeroEmissionEntryArray) {
        boolean bl = zeroEmissionEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(zeroEmissionEntryArray.length);
            for (int i2 = 0; i2 < zeroEmissionEntryArray.length; ++i2) {
                ZeroEmissionEntrySerializer.putOptionalZeroEmissionEntry(iSerializer, zeroEmissionEntryArray[i2]);
            }
        }
    }

    public static ZeroEmissionEntry getOptionalZeroEmissionEntry(IDeserializer iDeserializer) {
        ZeroEmissionEntry zeroEmissionEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            zeroEmissionEntry = new ZeroEmissionEntry();
            short[] sArray = iDeserializer.getOptionalInt16VarArray();
            zeroEmissionEntry.values = sArray;
            zeroEmissionEntry.state = by = iDeserializer.getInt8();
        }
        return zeroEmissionEntry;
    }

    public static ZeroEmissionEntry[] getOptionalZeroEmissionEntryVarArray(IDeserializer iDeserializer) {
        ZeroEmissionEntry[] zeroEmissionEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            zeroEmissionEntryArray = new ZeroEmissionEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                zeroEmissionEntryArray[i2] = ZeroEmissionEntrySerializer.getOptionalZeroEmissionEntry(iDeserializer);
            }
        }
        return zeroEmissionEntryArray;
    }
}

