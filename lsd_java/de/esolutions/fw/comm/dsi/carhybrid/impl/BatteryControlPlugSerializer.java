/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPlug;

public class BatteryControlPlugSerializer {
    public static void putOptionalBatteryControlPlug(ISerializer iSerializer, BatteryControlPlug batteryControlPlug) {
        boolean bl = batteryControlPlug == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlPlug.getLockSetup();
            iSerializer.putInt32(n);
            int n2 = batteryControlPlug.getLockState();
            iSerializer.putInt32(n2);
            int n3 = batteryControlPlug.getSupplyState();
            iSerializer.putInt32(n3);
            int n4 = batteryControlPlug.getPlugState();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalBatteryControlPlugVarArray(ISerializer iSerializer, BatteryControlPlug[] batteryControlPlugArray) {
        boolean bl = batteryControlPlugArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlPlugArray.length);
            for (int i2 = 0; i2 < batteryControlPlugArray.length; ++i2) {
                BatteryControlPlugSerializer.putOptionalBatteryControlPlug(iSerializer, batteryControlPlugArray[i2]);
            }
        }
    }

    public static BatteryControlPlug getOptionalBatteryControlPlug(IDeserializer iDeserializer) {
        BatteryControlPlug batteryControlPlug = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            batteryControlPlug = new BatteryControlPlug();
            batteryControlPlug.lockSetup = n4 = iDeserializer.getInt32();
            batteryControlPlug.lockState = n3 = iDeserializer.getInt32();
            batteryControlPlug.supplyState = n2 = iDeserializer.getInt32();
            batteryControlPlug.plugState = n = iDeserializer.getInt32();
        }
        return batteryControlPlug;
    }

    public static BatteryControlPlug[] getOptionalBatteryControlPlugVarArray(IDeserializer iDeserializer) {
        BatteryControlPlug[] batteryControlPlugArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlPlugArray = new BatteryControlPlug[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlPlugArray[i2] = BatteryControlPlugSerializer.getOptionalBatteryControlPlug(iDeserializer);
            }
        }
        return batteryControlPlugArray;
    }
}

