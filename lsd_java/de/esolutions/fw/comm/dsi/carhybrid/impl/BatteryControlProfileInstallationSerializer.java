/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileInstallation;

public class BatteryControlProfileInstallationSerializer {
    public static void putOptionalBatteryControlProfileInstallation(ISerializer iSerializer, BatteryControlProfileInstallation batteryControlProfileInstallation) {
        boolean bl = batteryControlProfileInstallation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlProfileInstallation.isLeadingTime();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlProfileInstallation.isAcTempSetting();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBatteryControlProfileInstallationVarArray(ISerializer iSerializer, BatteryControlProfileInstallation[] batteryControlProfileInstallationArray) {
        boolean bl = batteryControlProfileInstallationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileInstallationArray.length);
            for (int i2 = 0; i2 < batteryControlProfileInstallationArray.length; ++i2) {
                BatteryControlProfileInstallationSerializer.putOptionalBatteryControlProfileInstallation(iSerializer, batteryControlProfileInstallationArray[i2]);
            }
        }
    }

    public static BatteryControlProfileInstallation getOptionalBatteryControlProfileInstallation(IDeserializer iDeserializer) {
        BatteryControlProfileInstallation batteryControlProfileInstallation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            batteryControlProfileInstallation = new BatteryControlProfileInstallation();
            batteryControlProfileInstallation.leadingTime = bl3 = iDeserializer.getBool();
            batteryControlProfileInstallation.acTempSetting = bl2 = iDeserializer.getBool();
        }
        return batteryControlProfileInstallation;
    }

    public static BatteryControlProfileInstallation[] getOptionalBatteryControlProfileInstallationVarArray(IDeserializer iDeserializer) {
        BatteryControlProfileInstallation[] batteryControlProfileInstallationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileInstallationArray = new BatteryControlProfileInstallation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileInstallationArray[i2] = BatteryControlProfileInstallationSerializer.getOptionalBatteryControlProfileInstallation(iDeserializer);
            }
        }
        return batteryControlProfileInstallationArray;
    }
}

