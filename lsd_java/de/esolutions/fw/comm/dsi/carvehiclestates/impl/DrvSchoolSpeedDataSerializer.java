/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.DrvSchoolSpeedData;

public class DrvSchoolSpeedDataSerializer {
    public static void putOptionalDrvSchoolSpeedData(ISerializer iSerializer, DrvSchoolSpeedData drvSchoolSpeedData) {
        boolean bl = drvSchoolSpeedData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = drvSchoolSpeedData.getSpeed();
            iSerializer.putInt32(n);
            int n2 = drvSchoolSpeedData.getUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDrvSchoolSpeedDataVarArray(ISerializer iSerializer, DrvSchoolSpeedData[] drvSchoolSpeedDataArray) {
        boolean bl = drvSchoolSpeedDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(drvSchoolSpeedDataArray.length);
            for (int i2 = 0; i2 < drvSchoolSpeedDataArray.length; ++i2) {
                DrvSchoolSpeedDataSerializer.putOptionalDrvSchoolSpeedData(iSerializer, drvSchoolSpeedDataArray[i2]);
            }
        }
    }

    public static DrvSchoolSpeedData getOptionalDrvSchoolSpeedData(IDeserializer iDeserializer) {
        DrvSchoolSpeedData drvSchoolSpeedData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            drvSchoolSpeedData = new DrvSchoolSpeedData();
            drvSchoolSpeedData.speed = n2 = iDeserializer.getInt32();
            drvSchoolSpeedData.unit = n = iDeserializer.getInt32();
        }
        return drvSchoolSpeedData;
    }

    public static DrvSchoolSpeedData[] getOptionalDrvSchoolSpeedDataVarArray(IDeserializer iDeserializer) {
        DrvSchoolSpeedData[] drvSchoolSpeedDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            drvSchoolSpeedDataArray = new DrvSchoolSpeedData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                drvSchoolSpeedDataArray[i2] = DrvSchoolSpeedDataSerializer.getOptionalDrvSchoolSpeedData(iDeserializer);
            }
        }
        return drvSchoolSpeedDataArray;
    }
}

