/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;

public class BatteryControlProgrammedTimerSerializer {
    public static void putOptionalBatteryControlProgrammedTimer(ISerializer iSerializer, BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        boolean bl = batteryControlProgrammedTimer == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlProgrammedTimer.isTimer1();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlProgrammedTimer.isTimer2();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlProgrammedTimer.isTimer3();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlProgrammedTimer.isTimer4();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalBatteryControlProgrammedTimerVarArray(ISerializer iSerializer, BatteryControlProgrammedTimer[] batteryControlProgrammedTimerArray) {
        boolean bl = batteryControlProgrammedTimerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProgrammedTimerArray.length);
            for (int i2 = 0; i2 < batteryControlProgrammedTimerArray.length; ++i2) {
                BatteryControlProgrammedTimerSerializer.putOptionalBatteryControlProgrammedTimer(iSerializer, batteryControlProgrammedTimerArray[i2]);
            }
        }
    }

    public static BatteryControlProgrammedTimer getOptionalBatteryControlProgrammedTimer(IDeserializer iDeserializer) {
        BatteryControlProgrammedTimer batteryControlProgrammedTimer = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            batteryControlProgrammedTimer = new BatteryControlProgrammedTimer();
            batteryControlProgrammedTimer.timer1 = bl5 = iDeserializer.getBool();
            batteryControlProgrammedTimer.timer2 = bl4 = iDeserializer.getBool();
            batteryControlProgrammedTimer.timer3 = bl3 = iDeserializer.getBool();
            batteryControlProgrammedTimer.timer4 = bl2 = iDeserializer.getBool();
        }
        return batteryControlProgrammedTimer;
    }

    public static BatteryControlProgrammedTimer[] getOptionalBatteryControlProgrammedTimerVarArray(IDeserializer iDeserializer) {
        BatteryControlProgrammedTimer[] batteryControlProgrammedTimerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProgrammedTimerArray = new BatteryControlProgrammedTimer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProgrammedTimerArray[i2] = BatteryControlProgrammedTimerSerializer.getOptionalBatteryControlProgrammedTimer(iDeserializer);
            }
        }
        return batteryControlProgrammedTimerArray;
    }
}

