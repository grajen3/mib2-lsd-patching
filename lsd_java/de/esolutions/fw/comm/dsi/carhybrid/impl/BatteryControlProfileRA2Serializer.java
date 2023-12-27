/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileOperationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;

public class BatteryControlProfileRA2Serializer {
    public static void putOptionalBatteryControlProfileRA2(ISerializer iSerializer, BatteryControlProfileRA2 batteryControlProfileRA2) {
        boolean bl = batteryControlProfileRA2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfileRA2.getPos();
            iSerializer.putInt32(n);
            BatteryControlProfileOperation batteryControlProfileOperation = batteryControlProfileRA2.getProfileOperation();
            BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperation);
            int n2 = batteryControlProfileRA2.getMaxCurrent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfileRA2.getTargetChargeLevel();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalBatteryControlProfileRA2VarArray(ISerializer iSerializer, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        boolean bl = batteryControlProfileRA2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileRA2Array.length);
            for (int i2 = 0; i2 < batteryControlProfileRA2Array.length; ++i2) {
                BatteryControlProfileRA2Serializer.putOptionalBatteryControlProfileRA2(iSerializer, batteryControlProfileRA2Array[i2]);
            }
        }
    }

    public static BatteryControlProfileRA2 getOptionalBatteryControlProfileRA2(IDeserializer iDeserializer) {
        BatteryControlProfileRA2 batteryControlProfileRA2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            BatteryControlProfileOperation batteryControlProfileOperation;
            int n3;
            batteryControlProfileRA2 = new BatteryControlProfileRA2();
            batteryControlProfileRA2.pos = n3 = iDeserializer.getInt32();
            batteryControlProfileRA2.profileOperation = batteryControlProfileOperation = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            batteryControlProfileRA2.maxCurrent = n2 = iDeserializer.getInt32();
            batteryControlProfileRA2.targetChargeLevel = n = iDeserializer.getInt32();
        }
        return batteryControlProfileRA2;
    }

    public static BatteryControlProfileRA2[] getOptionalBatteryControlProfileRA2VarArray(IDeserializer iDeserializer) {
        BatteryControlProfileRA2[] batteryControlProfileRA2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileRA2Array = new BatteryControlProfileRA2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileRA2Array[i2] = BatteryControlProfileRA2Serializer.getOptionalBatteryControlProfileRA2(iDeserializer);
            }
        }
        return batteryControlProfileRA2Array;
    }
}

