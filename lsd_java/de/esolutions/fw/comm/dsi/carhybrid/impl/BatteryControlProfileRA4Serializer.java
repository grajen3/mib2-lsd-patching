/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileOperationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;

public class BatteryControlProfileRA4Serializer {
    public static void putOptionalBatteryControlProfileRA4(ISerializer iSerializer, BatteryControlProfileRA4 batteryControlProfileRA4) {
        boolean bl = batteryControlProfileRA4 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA4.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA4.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            int n2 = batteryControlProfileRA4.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA4.getMinChargeLevel();
            iSerializer.putInt32(n3);
            int n4 = batteryControlProfileRA4.getTemperature();
            iSerializer.putInt32(n4);
            int n5 = batteryControlProfileRA4.getTemperatureUnit();
            iSerializer.putInt32(n5);
            int n6 = batteryControlProfileRA4.getLeadTime();
            iSerializer.putInt32(n6);
            int n7 = batteryControlProfileRA4.getHoldingTimePlug();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalBatteryControlProfileRA4VarArray(ISerializer iSerializer, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        boolean bl = batteryControlProfileRA4Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA4Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA4Array.length; ++i2) {
                BatteryControlProfileRA4Serializer.putOptionalBatteryControlProfileRA4(iSerializer, batteryControlProfileRA4Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA4 getOptionalBatteryControlProfileRA4(IDeserializer iDeserializer) {
        BatteryControlProfileRA4 batteryControlProfileRA4 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n7;
            batteryControlProfileRA4 = new BatteryControlProfileRA4();
            batteryControlProfileRA4.pos = n7 = iDeserializer.getInt32();
            batteryControlProfileRA4.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA4.maxCurrent = n6 = iDeserializer.getInt32();
            batteryControlProfileRA4.minChargeLevel = n5 = iDeserializer.getInt32();
            batteryControlProfileRA4.temperature = n4 = iDeserializer.getInt32();
            batteryControlProfileRA4.temperatureUnit = n3 = iDeserializer.getInt32();
            batteryControlProfileRA4.leadTime = n2 = iDeserializer.getInt32();
            batteryControlProfileRA4.holdingTimePlug = n = iDeserializer.getInt32();
        }
        return batteryControlProfileRA4;
    }

    public static BatteryControlProfileRA4[] getOptionalBatteryControlProfileRA4VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA4[] batteryControlProfileRA4Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA4Array = new BatteryControlProfileRA4[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA4Array[i2] = BatteryControlProfileRA4Serializer.getOptionalBatteryControlProfileRA4(iDeserializer);
            }
        }
        return batteryControlProfileRA4Array;
    }
}

