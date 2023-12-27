/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;

public class BatteryControlExpiredTimerSerializer {
    public static void putOptionalBatteryControlExpiredTimer(ISerializer iSerializer, BatteryControlExpiredTimer batteryControlExpiredTimer) {
        boolean bl = batteryControlExpiredTimer == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlExpiredTimer.isTimer1();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlExpiredTimer.isTimer2();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlExpiredTimer.isTimer3();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlExpiredTimer.isTimer4();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalBatteryControlExpiredTimerVarArray(ISerializer iSerializer, BatteryControlExpiredTimer[] batteryControlExpiredTimerArray) {
        boolean bl = batteryControlExpiredTimerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlExpiredTimerArray.length);
            for (int i2 = 0; i2 < batteryControlExpiredTimerArray.length; ++i2) {
                BatteryControlExpiredTimerSerializer.putOptionalBatteryControlExpiredTimer(iSerializer, batteryControlExpiredTimerArray[i2]);
            }
        }
    }

    public static BatteryControlExpiredTimer getOptionalBatteryControlExpiredTimer(IDeserializer iDeserializer) {
        BatteryControlExpiredTimer batteryControlExpiredTimer = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            batteryControlExpiredTimer = new BatteryControlExpiredTimer();
            batteryControlExpiredTimer.timer1 = bl5 = iDeserializer.getBool();
            batteryControlExpiredTimer.timer2 = bl4 = iDeserializer.getBool();
            batteryControlExpiredTimer.timer3 = bl3 = iDeserializer.getBool();
            batteryControlExpiredTimer.timer4 = bl2 = iDeserializer.getBool();
        }
        return batteryControlExpiredTimer;
    }

    public static BatteryControlExpiredTimer[] getOptionalBatteryControlExpiredTimerVarArray(IDeserializer iDeserializer) {
        BatteryControlExpiredTimer[] batteryControlExpiredTimerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlExpiredTimerArray = new BatteryControlExpiredTimer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlExpiredTimerArray[i2] = BatteryControlExpiredTimerSerializer.getOptionalBatteryControlExpiredTimer(iDeserializer);
            }
        }
        return batteryControlExpiredTimerArray;
    }
}

