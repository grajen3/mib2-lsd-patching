/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlEngineInstallation;

public class BatteryControlEngineInstallationSerializer {
    public static void putOptionalBatteryControlEngineInstallation(ISerializer iSerializer, BatteryControlEngineInstallation batteryControlEngineInstallation) {
        boolean bl = batteryControlEngineInstallation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlEngineInstallation.isRangeAdjustmentElectricEngine();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlEngineInstallation.isRangeAdjustmentCombination();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBatteryControlEngineInstallationVarArray(ISerializer iSerializer, BatteryControlEngineInstallation[] batteryControlEngineInstallationArray) {
        boolean bl = batteryControlEngineInstallationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlEngineInstallationArray.length);
            for (int i2 = 0; i2 < batteryControlEngineInstallationArray.length; ++i2) {
                BatteryControlEngineInstallationSerializer.putOptionalBatteryControlEngineInstallation(iSerializer, batteryControlEngineInstallationArray[i2]);
            }
        }
    }

    public static BatteryControlEngineInstallation getOptionalBatteryControlEngineInstallation(IDeserializer iDeserializer) {
        BatteryControlEngineInstallation batteryControlEngineInstallation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            batteryControlEngineInstallation = new BatteryControlEngineInstallation();
            batteryControlEngineInstallation.rangeAdjustmentElectricEngine = bl3 = iDeserializer.getBool();
            batteryControlEngineInstallation.rangeAdjustmentCombination = bl2 = iDeserializer.getBool();
        }
        return batteryControlEngineInstallation;
    }

    public static BatteryControlEngineInstallation[] getOptionalBatteryControlEngineInstallationVarArray(IDeserializer iDeserializer) {
        BatteryControlEngineInstallation[] batteryControlEngineInstallationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlEngineInstallationArray = new BatteryControlEngineInstallation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlEngineInstallationArray[i2] = BatteryControlEngineInstallationSerializer.getOptionalBatteryControlEngineInstallation(iDeserializer);
            }
        }
        return batteryControlEngineInstallationArray;
    }
}

