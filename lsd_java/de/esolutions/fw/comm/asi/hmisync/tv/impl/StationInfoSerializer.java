/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class StationInfoSerializer {
    public static void putOptionalStationInfo(ISerializer iSerializer, StationInfo stationInfo) {
        boolean bl = stationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = stationInfo.getId();
            iSerializer.putInt64(l);
            String string = stationInfo.getName();
            iSerializer.putOptionalString(string);
            int n = stationInfo.getServiceType();
            iSerializer.putInt32(n);
            int n2 = stationInfo.getContentGroup();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalStationInfoVarArray(ISerializer iSerializer, StationInfo[] stationInfoArray) {
        boolean bl = stationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stationInfoArray.length);
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                StationInfoSerializer.putOptionalStationInfo(iSerializer, stationInfoArray[i2]);
            }
        }
    }

    public static StationInfo getOptionalStationInfo(IDeserializer iDeserializer) {
        StationInfo stationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            long l;
            stationInfo = new StationInfo();
            stationInfo.id = l = iDeserializer.getInt64();
            stationInfo.name = string = iDeserializer.getOptionalString();
            stationInfo.serviceType = n2 = iDeserializer.getInt32();
            stationInfo.contentGroup = n = iDeserializer.getInt32();
        }
        return stationInfo;
    }

    public static StationInfo[] getOptionalStationInfoVarArray(IDeserializer iDeserializer) {
        StationInfo[] stationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stationInfoArray = new StationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stationInfoArray[i2] = StationInfoSerializer.getOptionalStationInfo(iDeserializer);
            }
        }
        return stationInfoArray;
    }
}

