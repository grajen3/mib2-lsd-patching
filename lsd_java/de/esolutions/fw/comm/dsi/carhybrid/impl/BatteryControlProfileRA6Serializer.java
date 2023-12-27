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
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;

public class BatteryControlProfileRA6Serializer {
    public static void putOptionalBatteryControlProfileRA6(ISerializer iSerializer, BatteryControlProfileRA6 batteryControlProfileRA6) {
        boolean bl = batteryControlProfileRA6 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA6.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA6.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            BatteryControlProfileOperation2 batteryControlProfileOperation2 = batteryControlProfileRA6.getProfileOperation2();
            BatteryControlProfileOperation2Serializer.putOptionalBatteryControlProfileOperation2(iSerializer, batteryControlProfileOperation2);
            int n2 = batteryControlProfileRA6.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA6.getTargetChargeLevel();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalBatteryControlProfileRA6VarArray(ISerializer iSerializer, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        boolean bl = batteryControlProfileRA6Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA6Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA6Array.length; ++i2) {
                BatteryControlProfileRA6Serializer.putOptionalBatteryControlProfileRA6(iSerializer, batteryControlProfileRA6Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA6 getOptionalBatteryControlProfileRA6(IDeserializer iDeserializer) {
        BatteryControlProfileRA6 batteryControlProfileRA6 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            BatteryControlProfileOperation2 batteryControlProfileOperation2;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n3;
            batteryControlProfileRA6 = new BatteryControlProfileRA6();
            batteryControlProfileRA6.pos = n3 = iDeserializer.getInt32();
            batteryControlProfileRA6.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA6.profileOperation2 = batteryControlProfileOperation2 = BatteryControlProfileOperation2Serializer.getOptionalBatteryControlProfileOperation2(iDeserializer);
            batteryControlProfileRA6.maxCurrent = n2 = iDeserializer.getInt32();
            batteryControlProfileRA6.targetChargeLevel = n = iDeserializer.getInt32();
        }
        return batteryControlProfileRA6;
    }

    public static BatteryControlProfileRA6[] getOptionalBatteryControlProfileRA6VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA6[] batteryControlProfileRA6Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA6Array = new BatteryControlProfileRA6[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA6Array[i2] = BatteryControlProfileRA6Serializer.getOptionalBatteryControlProfileRA6(iDeserializer);
            }
        }
        return batteryControlProfileRA6Array;
    }
}

