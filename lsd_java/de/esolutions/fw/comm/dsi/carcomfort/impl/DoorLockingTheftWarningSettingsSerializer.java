/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;

public class DoorLockingTheftWarningSettingsSerializer {
    public static void putOptionalDoorLockingTheftWarningSettings(ISerializer iSerializer, DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        boolean bl = doorLockingTheftWarningSettings == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = doorLockingTheftWarningSettings.isInterior();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingTheftWarningSettings.isDecline();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalDoorLockingTheftWarningSettingsVarArray(ISerializer iSerializer, DoorLockingTheftWarningSettings[] doorLockingTheftWarningSettingsArray) {
        boolean bl = doorLockingTheftWarningSettingsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingTheftWarningSettingsArray.length);
            for (int i2 = 0; i2 < doorLockingTheftWarningSettingsArray.length; ++i2) {
                DoorLockingTheftWarningSettingsSerializer.putOptionalDoorLockingTheftWarningSettings(iSerializer, doorLockingTheftWarningSettingsArray[i2]);
            }
        }
    }

    public static DoorLockingTheftWarningSettings getOptionalDoorLockingTheftWarningSettings(IDeserializer iDeserializer) {
        DoorLockingTheftWarningSettings doorLockingTheftWarningSettings = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            doorLockingTheftWarningSettings = new DoorLockingTheftWarningSettings();
            doorLockingTheftWarningSettings.interior = bl3 = iDeserializer.getBool();
            doorLockingTheftWarningSettings.decline = bl2 = iDeserializer.getBool();
        }
        return doorLockingTheftWarningSettings;
    }

    public static DoorLockingTheftWarningSettings[] getOptionalDoorLockingTheftWarningSettingsVarArray(IDeserializer iDeserializer) {
        DoorLockingTheftWarningSettings[] doorLockingTheftWarningSettingsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingTheftWarningSettingsArray = new DoorLockingTheftWarningSettings[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingTheftWarningSettingsArray[i2] = DoorLockingTheftWarningSettingsSerializer.getOptionalDoorLockingTheftWarningSettings(iDeserializer);
            }
        }
        return doorLockingTheftWarningSettingsArray;
    }
}

