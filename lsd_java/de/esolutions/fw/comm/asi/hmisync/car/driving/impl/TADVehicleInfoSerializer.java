/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class TADVehicleInfoSerializer {
    public static void putOptionalTADVehicleInfo(ISerializer iSerializer, TADVehicleInfo tADVehicleInfo) {
        boolean bl = tADVehicleInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tADVehicleInfo.isRoofLoad();
            iSerializer.putBool(bl2);
            boolean bl3 = tADVehicleInfo.isTrailer();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalTADVehicleInfoVarArray(ISerializer iSerializer, TADVehicleInfo[] tADVehicleInfoArray) {
        boolean bl = tADVehicleInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tADVehicleInfoArray.length);
            for (int i2 = 0; i2 < tADVehicleInfoArray.length; ++i2) {
                TADVehicleInfoSerializer.putOptionalTADVehicleInfo(iSerializer, tADVehicleInfoArray[i2]);
            }
        }
    }

    public static TADVehicleInfo getOptionalTADVehicleInfo(IDeserializer iDeserializer) {
        TADVehicleInfo tADVehicleInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            tADVehicleInfo = new TADVehicleInfo();
            tADVehicleInfo.roofLoad = bl3 = iDeserializer.getBool();
            tADVehicleInfo.trailer = bl2 = iDeserializer.getBool();
        }
        return tADVehicleInfo;
    }

    public static TADVehicleInfo[] getOptionalTADVehicleInfoVarArray(IDeserializer iDeserializer) {
        TADVehicleInfo[] tADVehicleInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tADVehicleInfoArray = new TADVehicleInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tADVehicleInfoArray[i2] = TADVehicleInfoSerializer.getOptionalTADVehicleInfo(iDeserializer);
            }
        }
        return tADVehicleInfoArray;
    }
}

