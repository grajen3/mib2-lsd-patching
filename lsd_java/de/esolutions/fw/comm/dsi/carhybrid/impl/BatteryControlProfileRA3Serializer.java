/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;

public class BatteryControlProfileRA3Serializer {
    public static void putOptionalBatteryControlProfileRA3(ISerializer iSerializer, BatteryControlProfileRA3 batteryControlProfileRA3) {
        boolean bl = batteryControlProfileRA3 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA3.getPos();
            iSerializer.putInt32(n);
            String string = batteryControlProfileRA3.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBatteryControlProfileRA3VarArray(ISerializer iSerializer, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        boolean bl = batteryControlProfileRA3Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA3Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA3Array.length; ++i2) {
                BatteryControlProfileRA3Serializer.putOptionalBatteryControlProfileRA3(iSerializer, batteryControlProfileRA3Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA3 getOptionalBatteryControlProfileRA3(IDeserializer iDeserializer) {
        BatteryControlProfileRA3 batteryControlProfileRA3 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            batteryControlProfileRA3 = new BatteryControlProfileRA3();
            batteryControlProfileRA3.pos = n = iDeserializer.getInt32();
            batteryControlProfileRA3.name = string = iDeserializer.getOptionalString();
        }
        return batteryControlProfileRA3;
    }

    public static BatteryControlProfileRA3[] getOptionalBatteryControlProfileRA3VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA3[] batteryControlProfileRA3Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA3Array = new BatteryControlProfileRA3[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA3Array[i2] = BatteryControlProfileRA3Serializer.getOptionalBatteryControlProfileRA3(iDeserializer);
            }
        }
        return batteryControlProfileRA3Array;
    }
}

