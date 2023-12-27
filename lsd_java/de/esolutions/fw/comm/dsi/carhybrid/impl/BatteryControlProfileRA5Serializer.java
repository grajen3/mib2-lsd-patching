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
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;

public class BatteryControlProfileRA5Serializer {
    public static void putOptionalBatteryControlProfileRA5(ISerializer iSerializer, BatteryControlProfileRA5 batteryControlProfileRA5) {
        boolean bl = batteryControlProfileRA5 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA5.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA5.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            BatteryControlProfileOperation2 batteryControlProfileOperation2 = batteryControlProfileRA5.getProfileOperation2();
            BatteryControlProfileOperation2Serializer.putOptionalBatteryControlProfileOperation2(iSerializer, batteryControlProfileOperation2);
            int n2 = batteryControlProfileRA5.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA5.getTargetChargeLevel();
            iSerializer.putInt32(n3);
            int n4 = batteryControlProfileRA5.getProviderDataId();
            iSerializer.putInt32(n4);
            String string = batteryControlProfileRA5.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBatteryControlProfileRA5VarArray(ISerializer iSerializer, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        boolean bl = batteryControlProfileRA5Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA5Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA5Array.length; ++i2) {
                BatteryControlProfileRA5Serializer.putOptionalBatteryControlProfileRA5(iSerializer, batteryControlProfileRA5Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA5 getOptionalBatteryControlProfileRA5(IDeserializer iDeserializer) {
        BatteryControlProfileRA5 batteryControlProfileRA5 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            BatteryControlProfileOperation2 batteryControlProfileOperation2;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n4;
            batteryControlProfileRA5 = new BatteryControlProfileRA5();
            batteryControlProfileRA5.pos = n4 = iDeserializer.getInt32();
            batteryControlProfileRA5.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA5.profileOperation2 = batteryControlProfileOperation2 = BatteryControlProfileOperation2Serializer.getOptionalBatteryControlProfileOperation2(iDeserializer);
            batteryControlProfileRA5.maxCurrent = n3 = iDeserializer.getInt32();
            batteryControlProfileRA5.targetChargeLevel = n2 = iDeserializer.getInt32();
            batteryControlProfileRA5.providerDataId = n = iDeserializer.getInt32();
            batteryControlProfileRA5.name = string = iDeserializer.getOptionalString();
        }
        return batteryControlProfileRA5;
    }

    public static BatteryControlProfileRA5[] getOptionalBatteryControlProfileRA5VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA5[] batteryControlProfileRA5Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA5Array = new BatteryControlProfileRA5[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA5Array[i2] = BatteryControlProfileRA5Serializer.getOptionalBatteryControlProfileRA5(iDeserializer);
            }
        }
        return batteryControlProfileRA5Array;
    }
}

