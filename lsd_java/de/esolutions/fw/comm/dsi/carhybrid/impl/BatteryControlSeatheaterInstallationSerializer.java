/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterInstallation;

public class BatteryControlSeatheaterInstallationSerializer {
    public static void putOptionalBatteryControlSeatheaterInstallation(ISerializer iSerializer, BatteryControlSeatheaterInstallation batteryControlSeatheaterInstallation) {
        boolean bl = batteryControlSeatheaterInstallation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlSeatheaterInstallation.isFrontLeft();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlSeatheaterInstallation.isFrontRight();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlSeatheaterInstallation.isRearLeft();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlSeatheaterInstallation.isRearRight();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalBatteryControlSeatheaterInstallationVarArray(ISerializer iSerializer, BatteryControlSeatheaterInstallation[] batteryControlSeatheaterInstallationArray) {
        boolean bl = batteryControlSeatheaterInstallationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlSeatheaterInstallationArray.length);
            for (int i2 = 0; i2 < batteryControlSeatheaterInstallationArray.length; ++i2) {
                BatteryControlSeatheaterInstallationSerializer.putOptionalBatteryControlSeatheaterInstallation(iSerializer, batteryControlSeatheaterInstallationArray[i2]);
            }
        }
    }

    public static BatteryControlSeatheaterInstallation getOptionalBatteryControlSeatheaterInstallation(IDeserializer iDeserializer) {
        BatteryControlSeatheaterInstallation batteryControlSeatheaterInstallation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            batteryControlSeatheaterInstallation = new BatteryControlSeatheaterInstallation();
            batteryControlSeatheaterInstallation.frontLeft = bl5 = iDeserializer.getBool();
            batteryControlSeatheaterInstallation.frontRight = bl4 = iDeserializer.getBool();
            batteryControlSeatheaterInstallation.rearLeft = bl3 = iDeserializer.getBool();
            batteryControlSeatheaterInstallation.rearRight = bl2 = iDeserializer.getBool();
        }
        return batteryControlSeatheaterInstallation;
    }

    public static BatteryControlSeatheaterInstallation[] getOptionalBatteryControlSeatheaterInstallationVarArray(IDeserializer iDeserializer) {
        BatteryControlSeatheaterInstallation[] batteryControlSeatheaterInstallationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlSeatheaterInstallationArray = new BatteryControlSeatheaterInstallation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlSeatheaterInstallationArray[i2] = BatteryControlSeatheaterInstallationSerializer.getOptionalBatteryControlSeatheaterInstallation(iDeserializer);
            }
        }
        return batteryControlSeatheaterInstallationArray;
    }
}

