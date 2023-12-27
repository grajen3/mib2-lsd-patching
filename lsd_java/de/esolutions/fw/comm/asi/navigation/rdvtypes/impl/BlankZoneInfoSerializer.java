/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes.impl;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.BlankZoneInfo;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvPointList;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.RdvPointListSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class BlankZoneInfoSerializer {
    public static void putOptionalBlankZoneInfo(ISerializer iSerializer, BlankZoneInfo blankZoneInfo) {
        boolean bl = blankZoneInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            RdvPointList rdvPointList = blankZoneInfo.getBlankZone();
            RdvPointListSerializer.putOptionalRdvPointList(iSerializer, rdvPointList);
        }
    }

    public static void putOptionalBlankZoneInfoVarArray(ISerializer iSerializer, BlankZoneInfo[] blankZoneInfoArray) {
        boolean bl = blankZoneInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(blankZoneInfoArray.length);
            for (int i2 = 0; i2 < blankZoneInfoArray.length; ++i2) {
                BlankZoneInfoSerializer.putOptionalBlankZoneInfo(iSerializer, blankZoneInfoArray[i2]);
            }
        }
    }

    public static BlankZoneInfo getOptionalBlankZoneInfo(IDeserializer iDeserializer) {
        BlankZoneInfo blankZoneInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            RdvPointList rdvPointList;
            blankZoneInfo = new BlankZoneInfo();
            blankZoneInfo.blankZone = rdvPointList = RdvPointListSerializer.getOptionalRdvPointList(iDeserializer);
        }
        return blankZoneInfo;
    }

    public static BlankZoneInfo[] getOptionalBlankZoneInfoVarArray(IDeserializer iDeserializer) {
        BlankZoneInfo[] blankZoneInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            blankZoneInfoArray = new BlankZoneInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                blankZoneInfoArray[i2] = BlankZoneInfoSerializer.getOptionalBlankZoneInfo(iDeserializer);
            }
        }
        return blankZoneInfoArray;
    }
}

