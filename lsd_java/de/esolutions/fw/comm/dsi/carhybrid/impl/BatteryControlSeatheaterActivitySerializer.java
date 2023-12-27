/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterActivity;

public class BatteryControlSeatheaterActivitySerializer {
    public static void putOptionalBatteryControlSeatheaterActivity(ISerializer iSerializer, BatteryControlSeatheaterActivity batteryControlSeatheaterActivity) {
        boolean bl = batteryControlSeatheaterActivity == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlSeatheaterActivity.isFrontLeft();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlSeatheaterActivity.isFrontRight();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlSeatheaterActivity.isRearLeft();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlSeatheaterActivity.isRearRight();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalBatteryControlSeatheaterActivityVarArray(ISerializer iSerializer, BatteryControlSeatheaterActivity[] batteryControlSeatheaterActivityArray) {
        boolean bl = batteryControlSeatheaterActivityArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlSeatheaterActivityArray.length);
            for (int i2 = 0; i2 < batteryControlSeatheaterActivityArray.length; ++i2) {
                BatteryControlSeatheaterActivitySerializer.putOptionalBatteryControlSeatheaterActivity(iSerializer, batteryControlSeatheaterActivityArray[i2]);
            }
        }
    }

    public static BatteryControlSeatheaterActivity getOptionalBatteryControlSeatheaterActivity(IDeserializer iDeserializer) {
        BatteryControlSeatheaterActivity batteryControlSeatheaterActivity = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            batteryControlSeatheaterActivity = new BatteryControlSeatheaterActivity();
            batteryControlSeatheaterActivity.frontLeft = bl5 = iDeserializer.getBool();
            batteryControlSeatheaterActivity.frontRight = bl4 = iDeserializer.getBool();
            batteryControlSeatheaterActivity.rearLeft = bl3 = iDeserializer.getBool();
            batteryControlSeatheaterActivity.rearRight = bl2 = iDeserializer.getBool();
        }
        return batteryControlSeatheaterActivity;
    }

    public static BatteryControlSeatheaterActivity[] getOptionalBatteryControlSeatheaterActivityVarArray(IDeserializer iDeserializer) {
        BatteryControlSeatheaterActivity[] batteryControlSeatheaterActivityArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlSeatheaterActivityArray = new BatteryControlSeatheaterActivity[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlSeatheaterActivityArray[i2] = BatteryControlSeatheaterActivitySerializer.getOptionalBatteryControlSeatheaterActivity(iDeserializer);
            }
        }
        return batteryControlSeatheaterActivityArray;
    }
}

