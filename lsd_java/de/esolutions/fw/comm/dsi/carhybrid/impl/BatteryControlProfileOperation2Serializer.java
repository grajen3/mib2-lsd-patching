/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;

public class BatteryControlProfileOperation2Serializer {
    public static void putOptionalBatteryControlProfileOperation2(ISerializer iSerializer, BatteryControlProfileOperation2 batteryControlProfileOperation2) {
        boolean bl = batteryControlProfileOperation2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlProfileOperation2.isWindowHeaterFront();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlProfileOperation2.isWindowHeaterRear();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlProfileOperation2.isParkHeater();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlProfileOperation2.isParkHeaterAutomatic();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalBatteryControlProfileOperation2VarArray(ISerializer iSerializer, BatteryControlProfileOperation2[] batteryControlProfileOperation2Array) {
        boolean bl = batteryControlProfileOperation2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileOperation2Array.length);
            for (int i2 = 0; i2 < batteryControlProfileOperation2Array.length; ++i2) {
                BatteryControlProfileOperation2Serializer.putOptionalBatteryControlProfileOperation2(iSerializer, batteryControlProfileOperation2Array[i2]);
            }
        }
    }

    public static BatteryControlProfileOperation2 getOptionalBatteryControlProfileOperation2(IDeserializer iDeserializer) {
        BatteryControlProfileOperation2 batteryControlProfileOperation2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            batteryControlProfileOperation2 = new BatteryControlProfileOperation2();
            batteryControlProfileOperation2.windowHeaterFront = bl5 = iDeserializer.getBool();
            batteryControlProfileOperation2.windowHeaterRear = bl4 = iDeserializer.getBool();
            batteryControlProfileOperation2.parkHeater = bl3 = iDeserializer.getBool();
            batteryControlProfileOperation2.parkHeaterAutomatic = bl2 = iDeserializer.getBool();
        }
        return batteryControlProfileOperation2;
    }

    public static BatteryControlProfileOperation2[] getOptionalBatteryControlProfileOperation2VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileOperation2[] batteryControlProfileOperation2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileOperation2Array = new BatteryControlProfileOperation2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileOperation2Array[i2] = BatteryControlProfileOperation2Serializer.getOptionalBatteryControlProfileOperation2(iDeserializer);
            }
        }
        return batteryControlProfileOperation2Array;
    }
}

