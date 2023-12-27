/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;

public class DoorLockingComfortOpenSettingsSerializer {
    public static void putOptionalDoorLockingComfortOpenSettings(ISerializer iSerializer, DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        boolean bl = doorLockingComfortOpenSettings == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = doorLockingComfortOpenSettings.isDriverWindow();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingComfortOpenSettings.isCodriverWindow();
            iSerializer.putBool(bl3);
            boolean bl4 = doorLockingComfortOpenSettings.isDriverRearWindow();
            iSerializer.putBool(bl4);
            boolean bl5 = doorLockingComfortOpenSettings.isCodriverRearWindow();
            iSerializer.putBool(bl5);
            boolean bl6 = doorLockingComfortOpenSettings.isSunRoof();
            iSerializer.putBool(bl6);
            boolean bl7 = doorLockingComfortOpenSettings.isRearBlind();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalDoorLockingComfortOpenSettingsVarArray(ISerializer iSerializer, DoorLockingComfortOpenSettings[] doorLockingComfortOpenSettingsArray) {
        boolean bl = doorLockingComfortOpenSettingsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingComfortOpenSettingsArray.length);
            for (int i2 = 0; i2 < doorLockingComfortOpenSettingsArray.length; ++i2) {
                DoorLockingComfortOpenSettingsSerializer.putOptionalDoorLockingComfortOpenSettings(iSerializer, doorLockingComfortOpenSettingsArray[i2]);
            }
        }
    }

    public static DoorLockingComfortOpenSettings getOptionalDoorLockingComfortOpenSettings(IDeserializer iDeserializer) {
        DoorLockingComfortOpenSettings doorLockingComfortOpenSettings = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            doorLockingComfortOpenSettings = new DoorLockingComfortOpenSettings();
            doorLockingComfortOpenSettings.driverWindow = bl7 = iDeserializer.getBool();
            doorLockingComfortOpenSettings.codriverWindow = bl6 = iDeserializer.getBool();
            doorLockingComfortOpenSettings.driverRearWindow = bl5 = iDeserializer.getBool();
            doorLockingComfortOpenSettings.codriverRearWindow = bl4 = iDeserializer.getBool();
            doorLockingComfortOpenSettings.sunRoof = bl3 = iDeserializer.getBool();
            doorLockingComfortOpenSettings.rearBlind = bl2 = iDeserializer.getBool();
        }
        return doorLockingComfortOpenSettings;
    }

    public static DoorLockingComfortOpenSettings[] getOptionalDoorLockingComfortOpenSettingsVarArray(IDeserializer iDeserializer) {
        DoorLockingComfortOpenSettings[] doorLockingComfortOpenSettingsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingComfortOpenSettingsArray = new DoorLockingComfortOpenSettings[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingComfortOpenSettingsArray[i2] = DoorLockingComfortOpenSettingsSerializer.getOptionalDoorLockingComfortOpenSettings(iDeserializer);
            }
        }
        return doorLockingComfortOpenSettingsArray;
    }
}

