/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;

public class BatteryControlChargeStateSerializer {
    public static void putOptionalBatteryControlChargeState(ISerializer iSerializer, BatteryControlChargeState batteryControlChargeState) {
        boolean bl = batteryControlChargeState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlChargeState.getChargeMode();
            iSerializer.putInt32(n);
            int n2 = batteryControlChargeState.getChargeState();
            iSerializer.putInt32(n2);
            int n3 = batteryControlChargeState.getCurrentChargeLevel();
            iSerializer.putInt32(n3);
            int n4 = batteryControlChargeState.getRemainingChargeTime();
            iSerializer.putInt32(n4);
            int n5 = batteryControlChargeState.getCurrentChargeRange();
            iSerializer.putInt32(n5);
            int n6 = batteryControlChargeState.getUnitRange();
            iSerializer.putInt32(n6);
            int n7 = batteryControlChargeState.getCurrent();
            iSerializer.putInt32(n7);
            int n8 = batteryControlChargeState.getStartReason();
            iSerializer.putInt32(n8);
            int n9 = batteryControlChargeState.getBatteryClimateState();
            iSerializer.putInt32(n9);
            int n10 = batteryControlChargeState.getTargetSOC();
            iSerializer.putInt32(n10);
        }
    }

    public static void putOptionalBatteryControlChargeStateVarArray(ISerializer iSerializer, BatteryControlChargeState[] batteryControlChargeStateArray) {
        boolean bl = batteryControlChargeStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlChargeStateArray.length);
            for (int i2 = 0; i2 < batteryControlChargeStateArray.length; ++i2) {
                BatteryControlChargeStateSerializer.putOptionalBatteryControlChargeState(iSerializer, batteryControlChargeStateArray[i2]);
            }
        }
    }

    public static BatteryControlChargeState getOptionalBatteryControlChargeState(IDeserializer iDeserializer) {
        BatteryControlChargeState batteryControlChargeState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            batteryControlChargeState = new BatteryControlChargeState();
            batteryControlChargeState.chargeMode = n10 = iDeserializer.getInt32();
            batteryControlChargeState.chargeState = n9 = iDeserializer.getInt32();
            batteryControlChargeState.currentChargeLevel = n8 = iDeserializer.getInt32();
            batteryControlChargeState.remainingChargeTime = n7 = iDeserializer.getInt32();
            batteryControlChargeState.currentChargeRange = n6 = iDeserializer.getInt32();
            batteryControlChargeState.unitRange = n5 = iDeserializer.getInt32();
            batteryControlChargeState.current = n4 = iDeserializer.getInt32();
            batteryControlChargeState.startReason = n3 = iDeserializer.getInt32();
            batteryControlChargeState.batteryClimateState = n2 = iDeserializer.getInt32();
            batteryControlChargeState.targetSOC = n = iDeserializer.getInt32();
        }
        return batteryControlChargeState;
    }

    public static BatteryControlChargeState[] getOptionalBatteryControlChargeStateVarArray(IDeserializer iDeserializer) {
        BatteryControlChargeState[] batteryControlChargeStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlChargeStateArray = new BatteryControlChargeState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlChargeStateArray[i2] = BatteryControlChargeStateSerializer.getOptionalBatteryControlChargeState(iDeserializer);
            }
        }
        return batteryControlChargeStateArray;
    }
}

