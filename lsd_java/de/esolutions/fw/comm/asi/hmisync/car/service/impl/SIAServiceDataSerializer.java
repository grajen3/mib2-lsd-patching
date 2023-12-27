/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SIAServiceDataSerializer {
    public static void putOptionalSIAServiceData(ISerializer iSerializer, SIAServiceData sIAServiceData) {
        boolean bl = sIAServiceData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sIAServiceData.getDistanceStatus();
            iSerializer.putInt32(n);
            int n2 = sIAServiceData.getDistance();
            iSerializer.putInt32(n2);
            int n3 = sIAServiceData.getDistanceUnit();
            iSerializer.putInt32(n3);
            int n4 = sIAServiceData.getTimeStatus();
            iSerializer.putInt32(n4);
            int n5 = sIAServiceData.getTime();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalSIAServiceDataVarArray(ISerializer iSerializer, SIAServiceData[] sIAServiceDataArray) {
        boolean bl = sIAServiceDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAServiceDataArray.length);
            for (int i2 = 0; i2 < sIAServiceDataArray.length; ++i2) {
                SIAServiceDataSerializer.putOptionalSIAServiceData(iSerializer, sIAServiceDataArray[i2]);
            }
        }
    }

    public static SIAServiceData getOptionalSIAServiceData(IDeserializer iDeserializer) {
        SIAServiceData sIAServiceData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            sIAServiceData = new SIAServiceData();
            sIAServiceData.distanceStatus = n5 = iDeserializer.getInt32();
            sIAServiceData.distance = n4 = iDeserializer.getInt32();
            sIAServiceData.distanceUnit = n3 = iDeserializer.getInt32();
            sIAServiceData.timeStatus = n2 = iDeserializer.getInt32();
            sIAServiceData.time = n = iDeserializer.getInt32();
        }
        return sIAServiceData;
    }

    public static SIAServiceData[] getOptionalSIAServiceDataVarArray(IDeserializer iDeserializer) {
        SIAServiceData[] sIAServiceDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAServiceDataArray = new SIAServiceData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAServiceDataArray[i2] = SIAServiceDataSerializer.getOptionalSIAServiceData(iDeserializer);
            }
        }
        return sIAServiceDataArray;
    }
}

