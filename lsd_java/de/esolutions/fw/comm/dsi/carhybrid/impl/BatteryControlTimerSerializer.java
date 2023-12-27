/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWeekdaysSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class BatteryControlTimerSerializer {
    public static void putOptionalBatteryControlTimer(ISerializer iSerializer, BatteryControlTimer batteryControlTimer) {
        boolean bl = batteryControlTimer == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlTimer.getYear();
            iSerializer.putInt32(n);
            int n2 = batteryControlTimer.getMonth();
            iSerializer.putInt32(n2);
            int n3 = batteryControlTimer.getDay();
            iSerializer.putInt32(n3);
            int n4 = batteryControlTimer.getHour();
            iSerializer.putInt32(n4);
            int n5 = batteryControlTimer.getMinute();
            iSerializer.putInt32(n5);
            BatteryControlWeekdays batteryControlWeekdays = batteryControlTimer.getWeekdays();
            BatteryControlWeekdaysSerializer.putOptionalBatteryControlWeekdays(iSerializer, batteryControlWeekdays);
            int n6 = batteryControlTimer.getChargeSchedule();
            iSerializer.putInt32(n6);
            int n7 = batteryControlTimer.getClimateSchedule();
            iSerializer.putInt32(n7);
            int n8 = batteryControlTimer.getRefID();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalBatteryControlTimerVarArray(ISerializer iSerializer, BatteryControlTimer[] batteryControlTimerArray) {
        boolean bl = batteryControlTimerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlTimerArray.length);
            for (int i2 = 0; i2 < batteryControlTimerArray.length; ++i2) {
                BatteryControlTimerSerializer.putOptionalBatteryControlTimer(iSerializer, batteryControlTimerArray[i2]);
            }
        }
    }

    public static BatteryControlTimer getOptionalBatteryControlTimer(IDeserializer iDeserializer) {
        BatteryControlTimer batteryControlTimer = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            BatteryControlWeekdays batteryControlWeekdays;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            batteryControlTimer = new BatteryControlTimer();
            batteryControlTimer.year = n8 = iDeserializer.getInt32();
            batteryControlTimer.month = n7 = iDeserializer.getInt32();
            batteryControlTimer.day = n6 = iDeserializer.getInt32();
            batteryControlTimer.hour = n5 = iDeserializer.getInt32();
            batteryControlTimer.minute = n4 = iDeserializer.getInt32();
            batteryControlTimer.weekdays = batteryControlWeekdays = BatteryControlWeekdaysSerializer.getOptionalBatteryControlWeekdays(iDeserializer);
            batteryControlTimer.chargeSchedule = n3 = iDeserializer.getInt32();
            batteryControlTimer.climateSchedule = n2 = iDeserializer.getInt32();
            batteryControlTimer.refID = n = iDeserializer.getInt32();
        }
        return batteryControlTimer;
    }

    public static BatteryControlTimer[] getOptionalBatteryControlTimerVarArray(IDeserializer iDeserializer) {
        BatteryControlTimer[] batteryControlTimerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlTimerArray = new BatteryControlTimer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlTimerArray[i2] = BatteryControlTimerSerializer.getOptionalBatteryControlTimer(iDeserializer);
            }
        }
        return batteryControlTimerArray;
    }
}

