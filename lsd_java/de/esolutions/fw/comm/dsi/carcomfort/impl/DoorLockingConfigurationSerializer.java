/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingCLSettingsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.DoorLockingCLSettings;
import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingUserListTransmittableElements;

public class DoorLockingConfigurationSerializer {
    public static void putOptionalDoorLockingConfiguration(ISerializer iSerializer, DoorLockingConfiguration doorLockingConfiguration) {
        boolean bl = doorLockingConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = doorLockingConfiguration.getNumberOfDoors();
            iSerializer.putInt32(n);
            int n2 = doorLockingConfiguration.getNumberOfWindows();
            iSerializer.putInt32(n2);
            boolean bl2 = doorLockingConfiguration.isSunRoof();
            iSerializer.putBool(bl2);
            boolean bl3 = doorLockingConfiguration.isRearBlindButton();
            iSerializer.putBool(bl3);
            boolean bl4 = doorLockingConfiguration.isRearBlindSunProtection();
            iSerializer.putBool(bl4);
            boolean bl5 = doorLockingConfiguration.isRearBlindReverseGear();
            iSerializer.putBool(bl5);
            boolean bl6 = doorLockingConfiguration.isKessy();
            iSerializer.putBool(bl6);
            boolean bl7 = doorLockingConfiguration.isBootBlind();
            iSerializer.putBool(bl7);
            boolean bl8 = doorLockingConfiguration.isIndividual();
            iSerializer.putBool(bl8);
            int n3 = doorLockingConfiguration.getProfiles();
            iSerializer.putInt32(n3);
            DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements = doorLockingConfiguration.getProfilesTransmittableElements();
            DoorLockingUserListTransmittableElementsSerializer.putOptionalDoorLockingUserListTransmittableElements(iSerializer, doorLockingUserListTransmittableElements);
            boolean bl9 = doorLockingConfiguration.isDriverWindowInCO();
            iSerializer.putBool(bl9);
            boolean bl10 = doorLockingConfiguration.isExtendedKeyMapping();
            iSerializer.putBool(bl10);
            boolean bl11 = doorLockingConfiguration.isKeyDetection();
            iSerializer.putBool(bl11);
            boolean bl12 = doorLockingConfiguration.isAtne();
            iSerializer.putBool(bl12);
            boolean bl13 = doorLockingConfiguration.isTemporaryKeyAssignment();
            iSerializer.putBool(bl13);
            boolean bl14 = doorLockingConfiguration.isSideBlinds();
            iSerializer.putBool(bl14);
            boolean bl15 = doorLockingConfiguration.isKeyMappingAutomatic();
            iSerializer.putBool(bl15);
            DoorLockingCLSettings doorLockingCLSettings = doorLockingConfiguration.getCentralLockingSettings();
            DoorLockingCLSettingsSerializer.putOptionalDoorLockingCLSettings(iSerializer, doorLockingCLSettings);
            boolean bl16 = doorLockingConfiguration.isRestore();
            iSerializer.putBool(bl16);
            int n4 = doorLockingConfiguration.getNumOfParams();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalDoorLockingConfigurationVarArray(ISerializer iSerializer, DoorLockingConfiguration[] doorLockingConfigurationArray) {
        boolean bl = doorLockingConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(doorLockingConfigurationArray.length);
            for (int i2 = 0; i2 < doorLockingConfigurationArray.length; ++i2) {
                DoorLockingConfigurationSerializer.putOptionalDoorLockingConfiguration(iSerializer, doorLockingConfigurationArray[i2]);
            }
        }
    }

    public static DoorLockingConfiguration getOptionalDoorLockingConfiguration(IDeserializer iDeserializer) {
        DoorLockingConfiguration doorLockingConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            DoorLockingCLSettings doorLockingCLSettings;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            DoorLockingUserListTransmittableElements doorLockingUserListTransmittableElements;
            int n2;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            int n3;
            int n4;
            doorLockingConfiguration = new DoorLockingConfiguration();
            doorLockingConfiguration.numberOfDoors = n4 = iDeserializer.getInt32();
            doorLockingConfiguration.numberOfWindows = n3 = iDeserializer.getInt32();
            doorLockingConfiguration.sunRoof = bl16 = iDeserializer.getBool();
            doorLockingConfiguration.rearBlindButton = bl15 = iDeserializer.getBool();
            doorLockingConfiguration.rearBlindSunProtection = bl14 = iDeserializer.getBool();
            doorLockingConfiguration.rearBlindReverseGear = bl13 = iDeserializer.getBool();
            doorLockingConfiguration.kessy = bl12 = iDeserializer.getBool();
            doorLockingConfiguration.bootBlind = bl11 = iDeserializer.getBool();
            doorLockingConfiguration.individual = bl10 = iDeserializer.getBool();
            doorLockingConfiguration.profiles = n2 = iDeserializer.getInt32();
            doorLockingConfiguration.profilesTransmittableElements = doorLockingUserListTransmittableElements = DoorLockingUserListTransmittableElementsSerializer.getOptionalDoorLockingUserListTransmittableElements(iDeserializer);
            doorLockingConfiguration.driverWindowInCO = bl9 = iDeserializer.getBool();
            doorLockingConfiguration.extendedKeyMapping = bl8 = iDeserializer.getBool();
            doorLockingConfiguration.keyDetection = bl7 = iDeserializer.getBool();
            doorLockingConfiguration.atne = bl6 = iDeserializer.getBool();
            doorLockingConfiguration.temporaryKeyAssignment = bl5 = iDeserializer.getBool();
            doorLockingConfiguration.sideBlinds = bl4 = iDeserializer.getBool();
            doorLockingConfiguration.keyMappingAutomatic = bl3 = iDeserializer.getBool();
            doorLockingConfiguration.centralLockingSettings = doorLockingCLSettings = DoorLockingCLSettingsSerializer.getOptionalDoorLockingCLSettings(iDeserializer);
            doorLockingConfiguration.restore = bl2 = iDeserializer.getBool();
            doorLockingConfiguration.numOfParams = n = iDeserializer.getInt32();
        }
        return doorLockingConfiguration;
    }

    public static DoorLockingConfiguration[] getOptionalDoorLockingConfigurationVarArray(IDeserializer iDeserializer) {
        DoorLockingConfiguration[] doorLockingConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            doorLockingConfigurationArray = new DoorLockingConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                doorLockingConfigurationArray[i2] = DoorLockingConfigurationSerializer.getOptionalDoorLockingConfiguration(iDeserializer);
            }
        }
        return doorLockingConfigurationArray;
    }
}

