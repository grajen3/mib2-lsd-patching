/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
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
            String string2 = stationInfo.getFullName();
            iSerializer.putOptionalString(string2);
            int n = stationInfo.getAudioStatus();
            iSerializer.putInt32(n);
            int n2 = stationInfo.getLayer();
            iSerializer.putInt32(n2);
            String string3 = stationInfo.getStationLogo();
            iSerializer.putOptionalString(string3);
            int n3 = stationInfo.getFrequency();
            iSerializer.putInt32(n3);
            String string4 = stationInfo.getExtension();
            iSerializer.putOptionalString(string4);
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
            String string;
            int n;
            String string2;
            int n2;
            int n3;
            String string3;
            String string4;
            long l;
            stationInfo = new StationInfo();
            stationInfo.id = l = iDeserializer.getInt64();
            stationInfo.name = string4 = iDeserializer.getOptionalString();
            stationInfo.fullName = string3 = iDeserializer.getOptionalString();
            stationInfo.audioStatus = n3 = iDeserializer.getInt32();
            stationInfo.layer = n2 = iDeserializer.getInt32();
            stationInfo.stationLogo = string2 = iDeserializer.getOptionalString();
            stationInfo.frequency = n = iDeserializer.getInt32();
            stationInfo.extension = string = iDeserializer.getOptionalString();
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

