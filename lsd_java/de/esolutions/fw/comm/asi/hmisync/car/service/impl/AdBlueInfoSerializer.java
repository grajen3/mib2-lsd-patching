/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AdBlueInfoSerializer {
    public static void putOptionalAdBlueInfo(ISerializer iSerializer, AdBlueInfo adBlueInfo) {
        boolean bl = adBlueInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = adBlueInfo.getRange();
            iSerializer.putInt32(n);
            int n2 = adBlueInfo.getRangeUnit();
            iSerializer.putInt32(n2);
            int n3 = adBlueInfo.getLevel();
            iSerializer.putInt32(n3);
            int n4 = adBlueInfo.getTankVolume();
            iSerializer.putInt32(n4);
            int n5 = adBlueInfo.getState();
            iSerializer.putInt32(n5);
            int n6 = adBlueInfo.getVolumeUnit();
            iSerializer.putInt32(n6);
            int n7 = adBlueInfo.getMinRefill();
            iSerializer.putInt32(n7);
            int n8 = adBlueInfo.getMaxRefill();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalAdBlueInfoVarArray(ISerializer iSerializer, AdBlueInfo[] adBlueInfoArray) {
        boolean bl = adBlueInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(adBlueInfoArray.length);
            for (int i2 = 0; i2 < adBlueInfoArray.length; ++i2) {
                AdBlueInfoSerializer.putOptionalAdBlueInfo(iSerializer, adBlueInfoArray[i2]);
            }
        }
    }

    public static AdBlueInfo getOptionalAdBlueInfo(IDeserializer iDeserializer) {
        AdBlueInfo adBlueInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            adBlueInfo = new AdBlueInfo();
            adBlueInfo.range = n8 = iDeserializer.getInt32();
            adBlueInfo.rangeUnit = n7 = iDeserializer.getInt32();
            adBlueInfo.level = n6 = iDeserializer.getInt32();
            adBlueInfo.tankVolume = n5 = iDeserializer.getInt32();
            adBlueInfo.state = n4 = iDeserializer.getInt32();
            adBlueInfo.volumeUnit = n3 = iDeserializer.getInt32();
            adBlueInfo.minRefill = n2 = iDeserializer.getInt32();
            adBlueInfo.maxRefill = n = iDeserializer.getInt32();
        }
        return adBlueInfo;
    }

    public static AdBlueInfo[] getOptionalAdBlueInfoVarArray(IDeserializer iDeserializer) {
        AdBlueInfo[] adBlueInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            adBlueInfoArray = new AdBlueInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                adBlueInfoArray[i2] = AdBlueInfoSerializer.getOptionalAdBlueInfo(iDeserializer);
            }
        }
        return adBlueInfoArray;
    }
}

