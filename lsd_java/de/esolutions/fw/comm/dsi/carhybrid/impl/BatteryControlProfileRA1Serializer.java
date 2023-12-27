/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileOperationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;

public class BatteryControlProfileRA1Serializer {
    public static void putOptionalBatteryControlProfileRA1(ISerializer iSerializer, BatteryControlProfileRA1 batteryControlProfileRA1) {
        boolean bl = batteryControlProfileRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA1.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA1.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            int n2 = batteryControlProfileRA1.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA1.getTargetChargeLevel();
            iSerializer.putInt32(n3);
            int n4 = batteryControlProfileRA1.getProviderDataId();
            iSerializer.putInt32(n4);
            String string = batteryControlProfileRA1.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBatteryControlProfileRA1VarArray(ISerializer iSerializer, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        boolean bl = batteryControlProfileRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA1Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA1Array.length; ++i2) {
                BatteryControlProfileRA1Serializer.putOptionalBatteryControlProfileRA1(iSerializer, batteryControlProfileRA1Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA1 getOptionalBatteryControlProfileRA1(IDeserializer iDeserializer) {
        BatteryControlProfileRA1 batteryControlProfileRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n4;
            batteryControlProfileRA1 = new BatteryControlProfileRA1();
            batteryControlProfileRA1.pos = n4 = iDeserializer.getInt32();
            batteryControlProfileRA1.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA1.maxCurrent = n3 = iDeserializer.getInt32();
            batteryControlProfileRA1.targetChargeLevel = n2 = iDeserializer.getInt32();
            batteryControlProfileRA1.providerDataId = n = iDeserializer.getInt32();
            batteryControlProfileRA1.name = string = iDeserializer.getOptionalString();
        }
        return batteryControlProfileRA1;
    }

    public static BatteryControlProfileRA1[] getOptionalBatteryControlProfileRA1VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA1[] batteryControlProfileRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA1Array = new BatteryControlProfileRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA1Array[i2] = BatteryControlProfileRA1Serializer.getOptionalBatteryControlProfileRA1(iDeserializer);
            }
        }
        return batteryControlProfileRA1Array;
    }
}

