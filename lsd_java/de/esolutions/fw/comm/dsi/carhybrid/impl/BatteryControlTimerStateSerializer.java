/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlExpiredTimerSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProgrammedTimerSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;

public class BatteryControlTimerStateSerializer {
    public static void putOptionalBatteryControlTimerState(ISerializer iSerializer, BatteryControlTimerState batteryControlTimerState) {
        boolean bl = batteryControlTimerState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BatteryControlProgrammedTimer batteryControlProgrammedTimer = batteryControlTimerState.getProgrammedTimer();
            BatteryControlProgrammedTimerSerializer.putOptionalBatteryControlProgrammedTimer(iSerializer, batteryControlProgrammedTimer);
            BatteryControlExpiredTimer batteryControlExpiredTimer = batteryControlTimerState.getExpiredTimer();
            BatteryControlExpiredTimerSerializer.putOptionalBatteryControlExpiredTimer(iSerializer, batteryControlExpiredTimer);
        }
    }

    public static void putOptionalBatteryControlTimerStateVarArray(ISerializer iSerializer, BatteryControlTimerState[] batteryControlTimerStateArray) {
        boolean bl = batteryControlTimerStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlTimerStateArray.length);
            for (int i2 = 0; i2 < batteryControlTimerStateArray.length; ++i2) {
                BatteryControlTimerStateSerializer.putOptionalBatteryControlTimerState(iSerializer, batteryControlTimerStateArray[i2]);
            }
        }
    }

    public static BatteryControlTimerState getOptionalBatteryControlTimerState(IDeserializer iDeserializer) {
        BatteryControlTimerState batteryControlTimerState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BatteryControlExpiredTimer batteryControlExpiredTimer;
            BatteryControlProgrammedTimer batteryControlProgrammedTimer;
            batteryControlTimerState = new BatteryControlTimerState();
            batteryControlTimerState.programmedTimer = batteryControlProgrammedTimer = BatteryControlProgrammedTimerSerializer.getOptionalBatteryControlProgrammedTimer(iDeserializer);
            batteryControlTimerState.expiredTimer = batteryControlExpiredTimer = BatteryControlExpiredTimerSerializer.getOptionalBatteryControlExpiredTimer(iDeserializer);
        }
        return batteryControlTimerState;
    }

    public static BatteryControlTimerState[] getOptionalBatteryControlTimerStateVarArray(IDeserializer iDeserializer) {
        BatteryControlTimerState[] batteryControlTimerStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlTimerStateArray = new BatteryControlTimerState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlTimerStateArray[i2] = BatteryControlTimerStateSerializer.getOptionalBatteryControlTimerState(iDeserializer);
            }
        }
        return batteryControlTimerStateArray;
    }
}

