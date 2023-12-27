/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterInstallation;

public class BatteryControlWindowheaterInstallationSerializer {
    public static void putOptionalBatteryControlWindowheaterInstallation(ISerializer iSerializer, BatteryControlWindowheaterInstallation batteryControlWindowheaterInstallation) {
        boolean bl = batteryControlWindowheaterInstallation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlWindowheaterInstallation.isFront();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlWindowheaterInstallation.isRear();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBatteryControlWindowheaterInstallationVarArray(ISerializer iSerializer, BatteryControlWindowheaterInstallation[] batteryControlWindowheaterInstallationArray) {
        boolean bl = batteryControlWindowheaterInstallationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlWindowheaterInstallationArray.length);
            for (int i2 = 0; i2 < batteryControlWindowheaterInstallationArray.length; ++i2) {
                BatteryControlWindowheaterInstallationSerializer.putOptionalBatteryControlWindowheaterInstallation(iSerializer, batteryControlWindowheaterInstallationArray[i2]);
            }
        }
    }

    public static BatteryControlWindowheaterInstallation getOptionalBatteryControlWindowheaterInstallation(IDeserializer iDeserializer) {
        BatteryControlWindowheaterInstallation batteryControlWindowheaterInstallation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            batteryControlWindowheaterInstallation = new BatteryControlWindowheaterInstallation();
            batteryControlWindowheaterInstallation.front = bl3 = iDeserializer.getBool();
            batteryControlWindowheaterInstallation.rear = bl2 = iDeserializer.getBool();
        }
        return batteryControlWindowheaterInstallation;
    }

    public static BatteryControlWindowheaterInstallation[] getOptionalBatteryControlWindowheaterInstallationVarArray(IDeserializer iDeserializer) {
        BatteryControlWindowheaterInstallation[] batteryControlWindowheaterInstallationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlWindowheaterInstallationArray = new BatteryControlWindowheaterInstallation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlWindowheaterInstallationArray[i2] = BatteryControlWindowheaterInstallationSerializer.getOptionalBatteryControlWindowheaterInstallation(iDeserializer);
            }
        }
        return batteryControlWindowheaterInstallationArray;
    }
}

