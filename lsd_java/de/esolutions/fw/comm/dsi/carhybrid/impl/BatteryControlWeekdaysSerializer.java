/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class BatteryControlWeekdaysSerializer {
    public static void putOptionalBatteryControlWeekdays(ISerializer iSerializer, BatteryControlWeekdays batteryControlWeekdays) {
        boolean bl = batteryControlWeekdays == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlWeekdays.isMonday();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlWeekdays.isTuesday();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlWeekdays.isWednesday();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlWeekdays.isThursday();
            iSerializer.putBool(bl5);
            boolean bl6 = batteryControlWeekdays.isFriday();
            iSerializer.putBool(bl6);
            boolean bl7 = batteryControlWeekdays.isSaturday();
            iSerializer.putBool(bl7);
            boolean bl8 = batteryControlWeekdays.isSunday();
            iSerializer.putBool(bl8);
            boolean bl9 = batteryControlWeekdays.isCyclic();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalBatteryControlWeekdaysVarArray(ISerializer iSerializer, BatteryControlWeekdays[] batteryControlWeekdaysArray) {
        boolean bl = batteryControlWeekdaysArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlWeekdaysArray.length);
            for (int i2 = 0; i2 < batteryControlWeekdaysArray.length; ++i2) {
                BatteryControlWeekdaysSerializer.putOptionalBatteryControlWeekdays(iSerializer, batteryControlWeekdaysArray[i2]);
            }
        }
    }

    public static BatteryControlWeekdays getOptionalBatteryControlWeekdays(IDeserializer iDeserializer) {
        BatteryControlWeekdays batteryControlWeekdays = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            batteryControlWeekdays = new BatteryControlWeekdays();
            batteryControlWeekdays.monday = bl9 = iDeserializer.getBool();
            batteryControlWeekdays.tuesday = bl8 = iDeserializer.getBool();
            batteryControlWeekdays.wednesday = bl7 = iDeserializer.getBool();
            batteryControlWeekdays.thursday = bl6 = iDeserializer.getBool();
            batteryControlWeekdays.friday = bl5 = iDeserializer.getBool();
            batteryControlWeekdays.saturday = bl4 = iDeserializer.getBool();
            batteryControlWeekdays.sunday = bl3 = iDeserializer.getBool();
            batteryControlWeekdays.cyclic = bl2 = iDeserializer.getBool();
        }
        return batteryControlWeekdays;
    }

    public static BatteryControlWeekdays[] getOptionalBatteryControlWeekdaysVarArray(IDeserializer iDeserializer) {
        BatteryControlWeekdays[] batteryControlWeekdaysArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlWeekdaysArray = new BatteryControlWeekdays[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlWeekdaysArray[i2] = BatteryControlWeekdaysSerializer.getOptionalBatteryControlWeekdays(iDeserializer);
            }
        }
        return batteryControlWeekdaysArray;
    }
}

