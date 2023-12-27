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
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;

public class BatteryControlProfileRA0Serializer {
    public static void putOptionalBatteryControlProfileRA0(ISerializer iSerializer, BatteryControlProfileRA0 batteryControlProfileRA0) {
        boolean bl = batteryControlProfileRA0 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA0.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA0.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            BatteryControlProfileOperation2 batteryControlProfileOperation2 = batteryControlProfileRA0.getProfileOperation2();
            BatteryControlProfileOperation2Serializer.putOptionalBatteryControlProfileOperation2(iSerializer, batteryControlProfileOperation2);
            int n2 = batteryControlProfileRA0.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA0.getMinChargeLevel();
            iSerializer.putInt32(n3);
            int n4 = batteryControlProfileRA0.getMinRange();
            iSerializer.putInt32(n4);
            int n5 = batteryControlProfileRA0.getTargetChargeLevel();
            iSerializer.putInt32(n5);
            int n6 = batteryControlProfileRA0.getTargetChargeDuration();
            iSerializer.putInt32(n6);
            int n7 = batteryControlProfileRA0.getTargetChargeRange();
            iSerializer.putInt32(n7);
            int n8 = batteryControlProfileRA0.getUnitRange();
            iSerializer.putInt32(n8);
            boolean bl2 = batteryControlProfileRA0.isRangeCalculationSetup();
            iSerializer.putBool(bl2);
            int n9 = batteryControlProfileRA0.getTemperature();
            iSerializer.putInt32(n9);
            int n10 = batteryControlProfileRA0.getTemperatureUnit();
            iSerializer.putInt32(n10);
            int n11 = batteryControlProfileRA0.getLeadTime();
            iSerializer.putInt32(n11);
            int n12 = batteryControlProfileRA0.getHoldingTimePlug();
            iSerializer.putInt32(n12);
            int n13 = batteryControlProfileRA0.getHoldingTimeBattery();
            iSerializer.putInt32(n13);
            int n14 = batteryControlProfileRA0.getProviderDataId();
            iSerializer.putInt32(n14);
            String string = batteryControlProfileRA0.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBatteryControlProfileRA0VarArray(ISerializer iSerializer, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        boolean bl = batteryControlProfileRA0Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA0Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA0Array.length; ++i2) {
                BatteryControlProfileRA0Serializer.putOptionalBatteryControlProfileRA0(iSerializer, batteryControlProfileRA0Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA0 getOptionalBatteryControlProfileRA0(IDeserializer iDeserializer) {
        BatteryControlProfileRA0 batteryControlProfileRA0 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            boolean bl2;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            BatteryControlProfileOperation2 batteryControlProfileOperation2;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n14;
            batteryControlProfileRA0 = new BatteryControlProfileRA0();
            batteryControlProfileRA0.pos = n14 = iDeserializer.getInt32();
            batteryControlProfileRA0.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA0.profileOperation2 = batteryControlProfileOperation2 = BatteryControlProfileOperation2Serializer.getOptionalBatteryControlProfileOperation2(iDeserializer);
            batteryControlProfileRA0.maxCurrent = n13 = iDeserializer.getInt32();
            batteryControlProfileRA0.minChargeLevel = n12 = iDeserializer.getInt32();
            batteryControlProfileRA0.minRange = n11 = iDeserializer.getInt32();
            batteryControlProfileRA0.targetChargeLevel = n10 = iDeserializer.getInt32();
            batteryControlProfileRA0.targetChargeDuration = n9 = iDeserializer.getInt32();
            batteryControlProfileRA0.targetChargeRange = n8 = iDeserializer.getInt32();
            batteryControlProfileRA0.unitRange = n7 = iDeserializer.getInt32();
            batteryControlProfileRA0.rangeCalculationSetup = bl2 = iDeserializer.getBool();
            batteryControlProfileRA0.temperature = n6 = iDeserializer.getInt32();
            batteryControlProfileRA0.temperatureUnit = n5 = iDeserializer.getInt32();
            batteryControlProfileRA0.leadTime = n4 = iDeserializer.getInt32();
            batteryControlProfileRA0.holdingTimePlug = n3 = iDeserializer.getInt32();
            batteryControlProfileRA0.holdingTimeBattery = n2 = iDeserializer.getInt32();
            batteryControlProfileRA0.providerDataId = n = iDeserializer.getInt32();
            batteryControlProfileRA0.name = string = iDeserializer.getOptionalString();
        }
        return batteryControlProfileRA0;
    }

    public static BatteryControlProfileRA0[] getOptionalBatteryControlProfileRA0VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA0[] batteryControlProfileRA0Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA0Array = new BatteryControlProfileRA0[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA0Array[i2] = BatteryControlProfileRA0Serializer.getOptionalBatteryControlProfileRA0(iDeserializer);
            }
        }
        return batteryControlProfileRA0Array;
    }
}

