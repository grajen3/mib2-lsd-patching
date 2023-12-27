/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;

public class BatteryControlRemainingChargeTimeSerializer {
    public static void putOptionalBatteryControlRemainingChargeTime(ISerializer iSerializer, BatteryControlRemainingChargeTime batteryControlRemainingChargeTime) {
        boolean bl = batteryControlRemainingChargeTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = batteryControlRemainingChargeTime.getMode();
            iSerializer.putInt8(by);
            short s = batteryControlRemainingChargeTime.getTargetSOC();
            iSerializer.putInt16(s);
            int n = batteryControlRemainingChargeTime.getChargeTime();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalBatteryControlRemainingChargeTimeVarArray(ISerializer iSerializer, BatteryControlRemainingChargeTime[] batteryControlRemainingChargeTimeArray) {
        boolean bl = batteryControlRemainingChargeTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlRemainingChargeTimeArray.length);
            for (int i2 = 0; i2 < batteryControlRemainingChargeTimeArray.length; ++i2) {
                BatteryControlRemainingChargeTimeSerializer.putOptionalBatteryControlRemainingChargeTime(iSerializer, batteryControlRemainingChargeTimeArray[i2]);
            }
        }
    }

    public static BatteryControlRemainingChargeTime getOptionalBatteryControlRemainingChargeTime(IDeserializer iDeserializer) {
        BatteryControlRemainingChargeTime batteryControlRemainingChargeTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            byte by;
            batteryControlRemainingChargeTime = new BatteryControlRemainingChargeTime();
            batteryControlRemainingChargeTime.mode = by = iDeserializer.getInt8();
            batteryControlRemainingChargeTime.targetSOC = s = iDeserializer.getInt16();
            batteryControlRemainingChargeTime.chargeTime = n = iDeserializer.getInt32();
        }
        return batteryControlRemainingChargeTime;
    }

    public static BatteryControlRemainingChargeTime[] getOptionalBatteryControlRemainingChargeTimeVarArray(IDeserializer iDeserializer) {
        BatteryControlRemainingChargeTime[] batteryControlRemainingChargeTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlRemainingChargeTimeArray = new BatteryControlRemainingChargeTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlRemainingChargeTimeArray[i2] = BatteryControlRemainingChargeTimeSerializer.getOptionalBatteryControlRemainingChargeTime(iDeserializer);
            }
        }
        return batteryControlRemainingChargeTimeArray;
    }
}

