/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sConfigSerializer {
    public static void putOptionalsConfig(ISerializer iSerializer, sConfig sConfig2) {
        boolean bl = sConfig2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sConfig2.getUpdatePeriod();
            iSerializer.putInt32(n);
            byte by = sConfig2.getPredLength();
            iSerializer.putInt8(by);
            int n2 = sConfig2.getPredDuration();
            iSerializer.putInt32(n2);
            int n3 = sConfig2.getCoordinateSystem();
            iSerializer.putEnum(n3);
            int n4 = sConfig2.getDeadrecEnabled();
            iSerializer.putEnum(n4);
            int n5 = sConfig2.getMapMatchingEnabled();
            iSerializer.putEnum(n5);
            int n6 = sConfig2.getNmeaPosEnabled();
            iSerializer.putEnum(n6);
            int n7 = sConfig2.getStructPosEnabled();
            iSerializer.putEnum(n7);
        }
    }

    public static void putOptionalsConfigVarArray(ISerializer iSerializer, sConfig[] sConfigArray) {
        boolean bl = sConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sConfigArray.length);
            for (int i2 = 0; i2 < sConfigArray.length; ++i2) {
                sConfigSerializer.putOptionalsConfig(iSerializer, sConfigArray[i2]);
            }
        }
    }

    public static sConfig getOptionalsConfig(IDeserializer iDeserializer) {
        sConfig sConfig2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            byte by;
            int n7;
            sConfig2 = new sConfig();
            sConfig2.updatePeriod = n7 = iDeserializer.getInt32();
            sConfig2.predLength = by = iDeserializer.getInt8();
            sConfig2.predDuration = n6 = iDeserializer.getInt32();
            sConfig2.coordinateSystem = n5 = iDeserializer.getEnum();
            sConfig2.deadrecEnabled = n4 = iDeserializer.getEnum();
            sConfig2.mapMatchingEnabled = n3 = iDeserializer.getEnum();
            sConfig2.nmeaPosEnabled = n2 = iDeserializer.getEnum();
            sConfig2.structPosEnabled = n = iDeserializer.getEnum();
        }
        return sConfig2;
    }

    public static sConfig[] getOptionalsConfigVarArray(IDeserializer iDeserializer) {
        sConfig[] sConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sConfigArray = new sConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sConfigArray[i2] = sConfigSerializer.getOptionalsConfig(iDeserializer);
            }
        }
        return sConfigArray;
    }
}

