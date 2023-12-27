/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileOperation2Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileOperationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;

public class BatteryControlProfileRA7Serializer {
    public static void putOptionalBatteryControlProfileRA7(ISerializer iSerializer, BatteryControlProfileRA7 batteryControlProfileRA7) {
        boolean bl = batteryControlProfileRA7 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA7.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA7.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            BatteryControlProfileOperation2 batteryControlProfileOperation2 = batteryControlProfileRA7.getProfileOperation2();
            BatteryControlProfileOperation2Serializer.putOptionalBatteryControlProfileOperation2(iSerializer, batteryControlProfileOperation2);
            int n2 = batteryControlProfileRA7.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA7.getMinChargeLevel();
            iSerializer.putInt32(n3);
            int n4 = batteryControlProfileRA7.getTemperature();
            iSerializer.putInt32(n4);
            int n5 = batteryControlProfileRA7.getTemperatureUnit();
            iSerializer.putInt32(n5);
            int n6 = batteryControlProfileRA7.getLeadTime();
            iSerializer.putInt32(n6);
            int n7 = batteryControlProfileRA7.getHoldingTimePlug();
            iSerializer.putInt32(n7);
            int n8 = batteryControlProfileRA7.getHoldingTimeBattery();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalBatteryControlProfileRA7VarArray(ISerializer iSerializer, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        boolean bl = batteryControlProfileRA7Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA7Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA7Array.length; ++i2) {
                BatteryControlProfileRA7Serializer.putOptionalBatteryControlProfileRA7(iSerializer, batteryControlProfileRA7Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA7 getOptionalBatteryControlProfileRA7(IDeserializer iDeserializer) {
        BatteryControlProfileRA7 batteryControlProfileRA7 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            BatteryControlProfileOperation2 batteryControlProfileOperation2;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n8;
            batteryControlProfileRA7 = new BatteryControlProfileRA7();
            batteryControlProfileRA7.pos = n8 = iDeserializer.getInt32();
            batteryControlProfileRA7.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA7.profileOperation2 = batteryControlProfileOperation2 = BatteryControlProfileOperation2Serializer.getOptionalBatteryControlProfileOperation2(iDeserializer);
            batteryControlProfileRA7.maxCurrent = n7 = iDeserializer.getInt32();
            batteryControlProfileRA7.minChargeLevel = n6 = iDeserializer.getInt32();
            batteryControlProfileRA7.temperature = n5 = iDeserializer.getInt32();
            batteryControlProfileRA7.temperatureUnit = n4 = iDeserializer.getInt32();
            batteryControlProfileRA7.leadTime = n3 = iDeserializer.getInt32();
            batteryControlProfileRA7.holdingTimePlug = n2 = iDeserializer.getInt32();
            batteryControlProfileRA7.holdingTimeBattery = n = iDeserializer.getInt32();
        }
        return batteryControlProfileRA7;
    }

    public static BatteryControlProfileRA7[] getOptionalBatteryControlProfileRA7VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA7[] batteryControlProfileRA7Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA7Array = new BatteryControlProfileRA7[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA7Array[i2] = BatteryControlProfileRA7Serializer.getOptionalBatteryControlProfileRA7(iDeserializer);
            }
        }
        return batteryControlProfileRA7Array;
    }
}

