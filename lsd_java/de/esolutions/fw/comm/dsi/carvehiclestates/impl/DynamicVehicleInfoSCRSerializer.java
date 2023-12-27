/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;

public class DynamicVehicleInfoSCRSerializer {
    public static void putOptionalDynamicVehicleInfoSCR(ISerializer iSerializer, DynamicVehicleInfoSCR dynamicVehicleInfoSCR) {
        boolean bl = dynamicVehicleInfoSCR == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dynamicVehicleInfoSCR.getRange();
            iSerializer.putInt32(n);
            int n2 = dynamicVehicleInfoSCR.getRangeUnit();
            iSerializer.putInt32(n2);
            byte by = dynamicVehicleInfoSCR.getLevel();
            iSerializer.putInt8(by);
            float f2 = dynamicVehicleInfoSCR.getRefillLevelMin();
            iSerializer.putFloat(f2);
            float f3 = dynamicVehicleInfoSCR.getRefillLevelMax();
            iSerializer.putFloat(f3);
            float f4 = dynamicVehicleInfoSCR.getTankVolume();
            iSerializer.putFloat(f4);
            int n3 = dynamicVehicleInfoSCR.getVolumeUnit();
            iSerializer.putInt32(n3);
            int n4 = dynamicVehicleInfoSCR.getStatus();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalDynamicVehicleInfoSCRVarArray(ISerializer iSerializer, DynamicVehicleInfoSCR[] dynamicVehicleInfoSCRArray) {
        boolean bl = dynamicVehicleInfoSCRArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dynamicVehicleInfoSCRArray.length);
            for (int i2 = 0; i2 < dynamicVehicleInfoSCRArray.length; ++i2) {
                DynamicVehicleInfoSCRSerializer.putOptionalDynamicVehicleInfoSCR(iSerializer, dynamicVehicleInfoSCRArray[i2]);
            }
        }
    }

    public static DynamicVehicleInfoSCR getOptionalDynamicVehicleInfoSCR(IDeserializer iDeserializer) {
        DynamicVehicleInfoSCR dynamicVehicleInfoSCR = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            float f2;
            float f3;
            float f4;
            byte by;
            int n3;
            int n4;
            dynamicVehicleInfoSCR = new DynamicVehicleInfoSCR();
            dynamicVehicleInfoSCR.range = n4 = iDeserializer.getInt32();
            dynamicVehicleInfoSCR.rangeUnit = n3 = iDeserializer.getInt32();
            dynamicVehicleInfoSCR.level = by = iDeserializer.getInt8();
            dynamicVehicleInfoSCR.refillLevelMin = f4 = iDeserializer.getFloat();
            dynamicVehicleInfoSCR.refillLevelMax = f3 = iDeserializer.getFloat();
            dynamicVehicleInfoSCR.tankVolume = f2 = iDeserializer.getFloat();
            dynamicVehicleInfoSCR.volumeUnit = n2 = iDeserializer.getInt32();
            dynamicVehicleInfoSCR.status = n = iDeserializer.getInt32();
        }
        return dynamicVehicleInfoSCR;
    }

    public static DynamicVehicleInfoSCR[] getOptionalDynamicVehicleInfoSCRVarArray(IDeserializer iDeserializer) {
        DynamicVehicleInfoSCR[] dynamicVehicleInfoSCRArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dynamicVehicleInfoSCRArray = new DynamicVehicleInfoSCR[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dynamicVehicleInfoSCRArray[i2] = DynamicVehicleInfoSCRSerializer.getOptionalDynamicVehicleInfoSCR(iDeserializer);
            }
        }
        return dynamicVehicleInfoSCRArray;
    }
}

