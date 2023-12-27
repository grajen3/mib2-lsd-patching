/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlClimateOperationModeInstallation;

public class BatteryControlClimateOperationModeInstallationSerializer {
    public static void putOptionalBatteryControlClimateOperationModeInstallation(ISerializer iSerializer, BatteryControlClimateOperationModeInstallation batteryControlClimateOperationModeInstallation) {
        boolean bl = batteryControlClimateOperationModeInstallation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlClimateOperationModeInstallation.isOperationModeImmediatly();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlClimateOperationModeInstallation.isOperationModeTimer1();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlClimateOperationModeInstallation.isOperationModeTimer2();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlClimateOperationModeInstallation.isOperationModeTimer3();
            iSerializer.putBool(bl5);
            boolean bl6 = batteryControlClimateOperationModeInstallation.isOperationModeTimer4();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalBatteryControlClimateOperationModeInstallationVarArray(ISerializer iSerializer, BatteryControlClimateOperationModeInstallation[] batteryControlClimateOperationModeInstallationArray) {
        boolean bl = batteryControlClimateOperationModeInstallationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlClimateOperationModeInstallationArray.length);
            for (int i2 = 0; i2 < batteryControlClimateOperationModeInstallationArray.length; ++i2) {
                BatteryControlClimateOperationModeInstallationSerializer.putOptionalBatteryControlClimateOperationModeInstallation(iSerializer, batteryControlClimateOperationModeInstallationArray[i2]);
            }
        }
    }

    public static BatteryControlClimateOperationModeInstallation getOptionalBatteryControlClimateOperationModeInstallation(IDeserializer iDeserializer) {
        BatteryControlClimateOperationModeInstallation batteryControlClimateOperationModeInstallation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            batteryControlClimateOperationModeInstallation = new BatteryControlClimateOperationModeInstallation();
            batteryControlClimateOperationModeInstallation.operationModeImmediatly = bl6 = iDeserializer.getBool();
            batteryControlClimateOperationModeInstallation.operationModeTimer1 = bl5 = iDeserializer.getBool();
            batteryControlClimateOperationModeInstallation.operationModeTimer2 = bl4 = iDeserializer.getBool();
            batteryControlClimateOperationModeInstallation.operationModeTimer3 = bl3 = iDeserializer.getBool();
            batteryControlClimateOperationModeInstallation.operationModeTimer4 = bl2 = iDeserializer.getBool();
        }
        return batteryControlClimateOperationModeInstallation;
    }

    public static BatteryControlClimateOperationModeInstallation[] getOptionalBatteryControlClimateOperationModeInstallationVarArray(IDeserializer iDeserializer) {
        BatteryControlClimateOperationModeInstallation[] batteryControlClimateOperationModeInstallationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlClimateOperationModeInstallationArray = new BatteryControlClimateOperationModeInstallation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlClimateOperationModeInstallationArray[i2] = BatteryControlClimateOperationModeInstallationSerializer.getOptionalBatteryControlClimateOperationModeInstallation(iDeserializer);
            }
        }
        return batteryControlClimateOperationModeInstallationArray;
    }
}

