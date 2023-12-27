/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterActivity;

public class BatteryControlWindowheaterActivitySerializer {
    public static void putOptionalBatteryControlWindowheaterActivity(ISerializer iSerializer, BatteryControlWindowheaterActivity batteryControlWindowheaterActivity) {
        boolean bl = batteryControlWindowheaterActivity == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlWindowheaterActivity.isFront();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlWindowheaterActivity.isRear();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBatteryControlWindowheaterActivityVarArray(ISerializer iSerializer, BatteryControlWindowheaterActivity[] batteryControlWindowheaterActivityArray) {
        boolean bl = batteryControlWindowheaterActivityArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlWindowheaterActivityArray.length);
            for (int i2 = 0; i2 < batteryControlWindowheaterActivityArray.length; ++i2) {
                BatteryControlWindowheaterActivitySerializer.putOptionalBatteryControlWindowheaterActivity(iSerializer, batteryControlWindowheaterActivityArray[i2]);
            }
        }
    }

    public static BatteryControlWindowheaterActivity getOptionalBatteryControlWindowheaterActivity(IDeserializer iDeserializer) {
        BatteryControlWindowheaterActivity batteryControlWindowheaterActivity = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            batteryControlWindowheaterActivity = new BatteryControlWindowheaterActivity();
            batteryControlWindowheaterActivity.front = bl3 = iDeserializer.getBool();
            batteryControlWindowheaterActivity.rear = bl2 = iDeserializer.getBool();
        }
        return batteryControlWindowheaterActivity;
    }

    public static BatteryControlWindowheaterActivity[] getOptionalBatteryControlWindowheaterActivityVarArray(IDeserializer iDeserializer) {
        BatteryControlWindowheaterActivity[] batteryControlWindowheaterActivityArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlWindowheaterActivityArray = new BatteryControlWindowheaterActivity[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlWindowheaterActivityArray[i2] = BatteryControlWindowheaterActivitySerializer.getOptionalBatteryControlWindowheaterActivity(iDeserializer);
            }
        }
        return batteryControlWindowheaterActivityArray;
    }
}

