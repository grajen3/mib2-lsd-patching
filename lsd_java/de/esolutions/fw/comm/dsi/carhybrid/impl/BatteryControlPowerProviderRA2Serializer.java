/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;

public class BatteryControlPowerProviderRA2Serializer {
    public static void putOptionalBatteryControlPowerProviderRA2(ISerializer iSerializer, BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2) {
        boolean bl = batteryControlPowerProviderRA2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlPowerProviderRA2.getPos();
            iSerializer.putInt32(n);
            int n2 = batteryControlPowerProviderRA2.getNrStartHour();
            iSerializer.putInt32(n2);
            int n3 = batteryControlPowerProviderRA2.getNrStartMinute();
            iSerializer.putInt32(n3);
            int n4 = batteryControlPowerProviderRA2.getNrEndHour();
            iSerializer.putInt32(n4);
            int n5 = batteryControlPowerProviderRA2.getNrEndMinute();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalBatteryControlPowerProviderRA2VarArray(ISerializer iSerializer, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        boolean bl = batteryControlPowerProviderRA2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlPowerProviderRA2Array.length);
            for (int i2 = 0; i2 < batteryControlPowerProviderRA2Array.length; ++i2) {
                BatteryControlPowerProviderRA2Serializer.putOptionalBatteryControlPowerProviderRA2(iSerializer, batteryControlPowerProviderRA2Array[i2]);
            }
        }
    }

    public static BatteryControlPowerProviderRA2 getOptionalBatteryControlPowerProviderRA2(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            batteryControlPowerProviderRA2 = new BatteryControlPowerProviderRA2();
            batteryControlPowerProviderRA2.pos = n5 = iDeserializer.getInt32();
            batteryControlPowerProviderRA2.nrStartHour = n4 = iDeserializer.getInt32();
            batteryControlPowerProviderRA2.nrStartMinute = n3 = iDeserializer.getInt32();
            batteryControlPowerProviderRA2.nrEndHour = n2 = iDeserializer.getInt32();
            batteryControlPowerProviderRA2.nrEndMinute = n = iDeserializer.getInt32();
        }
        return batteryControlPowerProviderRA2;
    }

    public static BatteryControlPowerProviderRA2[] getOptionalBatteryControlPowerProviderRA2VarArray(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlPowerProviderRA2Array = new BatteryControlPowerProviderRA2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlPowerProviderRA2Array[i2] = BatteryControlPowerProviderRA2Serializer.getOptionalBatteryControlPowerProviderRA2(iDeserializer);
            }
        }
        return batteryControlPowerProviderRA2Array;
    }
}

