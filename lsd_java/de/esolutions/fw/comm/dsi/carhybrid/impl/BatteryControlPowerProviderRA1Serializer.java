/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWeekdaysSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class BatteryControlPowerProviderRA1Serializer {
    public static void putOptionalBatteryControlPowerProviderRA1(ISerializer iSerializer, BatteryControlPowerProviderRA1 batteryControlPowerProviderRA1) {
        boolean bl = batteryControlPowerProviderRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlPowerProviderRA1.getPos();
            iSerializer.putInt32(n);
            BatteryControlWeekdays batteryControlWeekdays = batteryControlPowerProviderRA1.getNrWeekday();
            BatteryControlWeekdaysSerializer.putOptionalBatteryControlWeekdays(iSerializer, batteryControlWeekdays);
            int n2 = batteryControlPowerProviderRA1.getNrStartHour();
            iSerializer.putInt32(n2);
            int n3 = batteryControlPowerProviderRA1.getNrStartMinute();
            iSerializer.putInt32(n3);
            int n4 = batteryControlPowerProviderRA1.getNrEndHour();
            iSerializer.putInt32(n4);
            int n5 = batteryControlPowerProviderRA1.getNrEndMinute();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalBatteryControlPowerProviderRA1VarArray(ISerializer iSerializer, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        boolean bl = batteryControlPowerProviderRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlPowerProviderRA1Array.length);
            for (int i2 = 0; i2 < batteryControlPowerProviderRA1Array.length; ++i2) {
                BatteryControlPowerProviderRA1Serializer.putOptionalBatteryControlPowerProviderRA1(iSerializer, batteryControlPowerProviderRA1Array[i2]);
            }
        }
    }

    public static BatteryControlPowerProviderRA1 getOptionalBatteryControlPowerProviderRA1(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRA1 batteryControlPowerProviderRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            BatteryControlWeekdays batteryControlWeekdays;
            int n5;
            batteryControlPowerProviderRA1 = new BatteryControlPowerProviderRA1();
            batteryControlPowerProviderRA1.pos = n5 = iDeserializer.getInt32();
            batteryControlPowerProviderRA1.nrWeekday = batteryControlWeekdays = BatteryControlWeekdaysSerializer.getOptionalBatteryControlWeekdays(iDeserializer);
            batteryControlPowerProviderRA1.nrStartHour = n4 = iDeserializer.getInt32();
            batteryControlPowerProviderRA1.nrStartMinute = n3 = iDeserializer.getInt32();
            batteryControlPowerProviderRA1.nrEndHour = n2 = iDeserializer.getInt32();
            batteryControlPowerProviderRA1.nrEndMinute = n = iDeserializer.getInt32();
        }
        return batteryControlPowerProviderRA1;
    }

    public static BatteryControlPowerProviderRA1[] getOptionalBatteryControlPowerProviderRA1VarArray(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlPowerProviderRA1Array = new BatteryControlPowerProviderRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlPowerProviderRA1Array[i2] = BatteryControlPowerProviderRA1Serializer.getOptionalBatteryControlPowerProviderRA1(iDeserializer);
            }
        }
        return batteryControlPowerProviderRA1Array;
    }
}

