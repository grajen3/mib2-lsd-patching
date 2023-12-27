/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes.impl;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.RangeZoneInfo;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvPointList;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.RdvPointListSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class RangeZoneInfoSerializer {
    public static void putOptionalRangeZoneInfo(ISerializer iSerializer, RangeZoneInfo rangeZoneInfo) {
        boolean bl = rangeZoneInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rangeZoneInfo.getZoneID();
            iSerializer.putInt32(n);
            RdvPointList[] rdvPointListArray = rangeZoneInfo.getSafetyZones();
            RdvPointListSerializer.putOptionalRdvPointListVarArray(iSerializer, rdvPointListArray);
        }
    }

    public static void putOptionalRangeZoneInfoVarArray(ISerializer iSerializer, RangeZoneInfo[] rangeZoneInfoArray) {
        boolean bl = rangeZoneInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rangeZoneInfoArray.length);
            for (int i2 = 0; i2 < rangeZoneInfoArray.length; ++i2) {
                RangeZoneInfoSerializer.putOptionalRangeZoneInfo(iSerializer, rangeZoneInfoArray[i2]);
            }
        }
    }

    public static RangeZoneInfo getOptionalRangeZoneInfo(IDeserializer iDeserializer) {
        RangeZoneInfo rangeZoneInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            rangeZoneInfo = new RangeZoneInfo();
            rangeZoneInfo.zoneID = n = iDeserializer.getInt32();
            RdvPointList[] rdvPointListArray = RdvPointListSerializer.getOptionalRdvPointListVarArray(iDeserializer);
            rangeZoneInfo.safetyZones = rdvPointListArray;
        }
        return rangeZoneInfo;
    }

    public static RangeZoneInfo[] getOptionalRangeZoneInfoVarArray(IDeserializer iDeserializer) {
        RangeZoneInfo[] rangeZoneInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rangeZoneInfoArray = new RangeZoneInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rangeZoneInfoArray[i2] = RangeZoneInfoSerializer.getOptionalRangeZoneInfo(iDeserializer);
            }
        }
        return rangeZoneInfoArray;
    }
}

