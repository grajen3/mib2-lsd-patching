/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;

public class BatteryControlPowerProviderRAESerializer {
    public static void putOptionalBatteryControlPowerProviderRAE(ISerializer iSerializer, BatteryControlPowerProviderRAE batteryControlPowerProviderRAE) {
        boolean bl = batteryControlPowerProviderRAE == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlPowerProviderRAE.getPos();
            iSerializer.putInt32(n);
            String string = batteryControlPowerProviderRAE.getProvider();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalBatteryControlPowerProviderRAEVarArray(ISerializer iSerializer, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        boolean bl = batteryControlPowerProviderRAEArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlPowerProviderRAEArray.length);
            for (int i2 = 0; i2 < batteryControlPowerProviderRAEArray.length; ++i2) {
                BatteryControlPowerProviderRAESerializer.putOptionalBatteryControlPowerProviderRAE(iSerializer, batteryControlPowerProviderRAEArray[i2]);
            }
        }
    }

    public static BatteryControlPowerProviderRAE getOptionalBatteryControlPowerProviderRAE(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRAE batteryControlPowerProviderRAE = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            batteryControlPowerProviderRAE = new BatteryControlPowerProviderRAE();
            batteryControlPowerProviderRAE.pos = n = iDeserializer.getInt32();
            batteryControlPowerProviderRAE.provider = string = iDeserializer.getOptionalString();
        }
        return batteryControlPowerProviderRAE;
    }

    public static BatteryControlPowerProviderRAE[] getOptionalBatteryControlPowerProviderRAEVarArray(IDeserializer iDeserializer) {
        BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlPowerProviderRAEArray = new BatteryControlPowerProviderRAE[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlPowerProviderRAEArray[i2] = BatteryControlPowerProviderRAESerializer.getOptionalBatteryControlPowerProviderRAE(iDeserializer);
            }
        }
        return batteryControlPowerProviderRAEArray;
    }
}

