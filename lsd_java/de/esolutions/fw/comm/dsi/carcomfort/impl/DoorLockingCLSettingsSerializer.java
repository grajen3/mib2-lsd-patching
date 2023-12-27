/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingCLSettings;

public class DoorLockingCLSettingsSerializer {
    public static void putOptionalDoorLockingCLSettings(ISerializer iSerializer, DoorLockingCLSettings doorLockingCLSettings) {
        boolean bl = doorLockingCLSettings == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = doorLockingCLSettings.isSeperateDoor();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingCLSettings.isSideDoors();
            iSerializer.putBool(bl3);
            boolean bl4 = doorLockingCLSettings.isAllDoors();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalDoorLockingCLSettingsVarArray(ISerializer iSerializer, DoorLockingCLSettings[] doorLockingCLSettingsArray) {
        boolean bl = doorLockingCLSettingsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingCLSettingsArray.length);
            for (int i2 = 0; i2 < doorLockingCLSettingsArray.length; ++i2) {
                DoorLockingCLSettingsSerializer.putOptionalDoorLockingCLSettings(iSerializer, doorLockingCLSettingsArray[i2]);
            }
        }
    }

    public static DoorLockingCLSettings getOptionalDoorLockingCLSettings(IDeserializer iDeserializer) {
        DoorLockingCLSettings doorLockingCLSettings = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            doorLockingCLSettings = new DoorLockingCLSettings();
            doorLockingCLSettings.seperateDoor = bl4 = iDeserializer.getBool();
            doorLockingCLSettings.sideDoors = bl3 = iDeserializer.getBool();
            doorLockingCLSettings.allDoors = bl2 = iDeserializer.getBool();
        }
        return doorLockingCLSettings;
    }

    public static DoorLockingCLSettings[] getOptionalDoorLockingCLSettingsVarArray(IDeserializer iDeserializer) {
        DoorLockingCLSettings[] doorLockingCLSettingsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingCLSettingsArray = new DoorLockingCLSettings[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingCLSettingsArray[i2] = DoorLockingCLSettingsSerializer.getOptionalDoorLockingCLSettings(iDeserializer);
            }
        }
        return doorLockingCLSettingsArray;
    }
}

