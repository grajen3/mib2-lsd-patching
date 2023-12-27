/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWeekdaysSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class BatteryControlPowerProviderRA0Serializer {
    public static void putOptionalBatteryControlPowerProviderRA0(ISerializer iSerializer, BatteryControlPowerProviderRA0 batteryControlPowerProviderRA0) {
        boolean bl = batteryControlPowerProviderRA0 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlPowerProviderRA0.getPos();
            iSerializer.putInt32(n);
            String string = batteryControlPowerProviderRA0.getClient();
            iSerializer.putOptionalString(string);
            String string2 = batteryControlPowerProviderRA0.getProvider();
            iSerializer.putOptionalString(string2);
            BatteryControlWeekdays batteryControlWeekdays = batteryControlPowerProviderRA0.getNrWeekday();
            BatteryControlWeekdaysSerializer.putOptionalBatteryControlWeekdays(iSerializer, batteryControlWeekdays);
            int n2 = batteryControlPowerProviderRA0.getNrStartHour();
            iSerializer.putInt32(n2);
            int n3 = batteryControlPowerProviderRA0.getNrStartMinute();
            iSerializer.putInt32(n3);
            int n4 = batteryControlPowerProviderRA0.getNrEndHour();
            iSerializer.putInt32(n4);
            int n5 = batteryControlPowerProviderRA0.getNrEndMinute();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalBatteryControlPowerProviderRA0VarArray(ISerializer iSerializer, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        boolean bl = batteryControlPowerProviderRA0Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlPowerProviderRA0Array.length);
            for (int i2 = 0; i2 < batteryControlPowerProviderRA0Array.length; ++i2) {
                BatteryControlPowerProviderRA0Serializer.putOptionalBatteryControlPowerProviderRA0(iSerializer, batteryControlPowerProviderRA0Array[i2]);
            }
        }
    }

    public static BatteryControlPowerProviderRA0 getOptionalBatteryControlPowerProviderRA0(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRA0 batteryControlPowerProviderRA0 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            BatteryControlWeekdays batteryControlWeekdays;
            String string;
            String string2;
            int n5;
            batteryControlPowerProviderRA0 = new BatteryControlPowerProviderRA0();
            batteryControlPowerProviderRA0.pos = n5 = iDeserializer.getInt32();
            batteryControlPowerProviderRA0.client = string2 = iDeserializer.getOptionalString();
            batteryControlPowerProviderRA0.provider = string = iDeserializer.getOptionalString();
            batteryControlPowerProviderRA0.nrWeekday = batteryControlWeekdays = BatteryControlWeekdaysSerializer.getOptionalBatteryControlWeekdays(iDeserializer);
            batteryControlPowerProviderRA0.nrStartHour = n4 = iDeserializer.getInt32();
            batteryControlPowerProviderRA0.nrStartMinute = n3 = iDeserializer.getInt32();
            batteryControlPowerProviderRA0.nrEndHour = n2 = iDeserializer.getInt32();
            batteryControlPowerProviderRA0.nrEndMinute = n = iDeserializer.getInt32();
        }
        return batteryControlPowerProviderRA0;
    }

    public static BatteryControlPowerProviderRA0[] getOptionalBatteryControlPowerProviderRA0VarArray(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlPowerProviderRA0Array = new BatteryControlPowerProviderRA0[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlPowerProviderRA0Array[i2] = BatteryControlPowerProviderRA0Serializer.getOptionalBatteryControlPowerProviderRA0(iDeserializer);
            }
        }
        return batteryControlPowerProviderRA0Array;
    }
}

