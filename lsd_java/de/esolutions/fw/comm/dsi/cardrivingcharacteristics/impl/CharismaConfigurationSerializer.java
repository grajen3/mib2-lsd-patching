/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaOperationModeSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaProfilesSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaScreensSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.CharismaOperationMode;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProfiles;
import org.dsi.ifc.cardrivingcharacteristics.CharismaScreens;
import org.dsi.ifc.cardrivingcharacteristics.CharismaTransmittableElements;

public class CharismaConfigurationSerializer {
    public static void putOptionalCharismaConfiguration(ISerializer iSerializer, CharismaConfiguration charismaConfiguration) {
        boolean bl = charismaConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CharismaProfiles charismaProfiles = charismaConfiguration.getProfilesAvailable();
            CharismaProfilesSerializer.putOptionalCharismaProfiles(iSerializer, charismaProfiles);
            CharismaTransmittableElements charismaTransmittableElements = charismaConfiguration.getCharismaListTransmittableElements();
            CharismaTransmittableElementsSerializer.putOptionalCharismaTransmittableElements(iSerializer, charismaTransmittableElements);
            int n = charismaConfiguration.getSystemType();
            iSerializer.putInt32(n);
            CharismaScreens charismaScreens = charismaConfiguration.getScreensAvailable();
            CharismaScreensSerializer.putOptionalCharismaScreens(iSerializer, charismaScreens);
            CharismaOperationMode charismaOperationMode = charismaConfiguration.getOperationModesAvailable();
            CharismaOperationModeSerializer.putOptionalCharismaOperationMode(iSerializer, charismaOperationMode);
        }
    }

    public static void putOptionalCharismaConfigurationVarArray(ISerializer iSerializer, CharismaConfiguration[] charismaConfigurationArray) {
        boolean bl = charismaConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaConfigurationArray.length);
            for (int i2 = 0; i2 < charismaConfigurationArray.length; ++i2) {
                CharismaConfigurationSerializer.putOptionalCharismaConfiguration(iSerializer, charismaConfigurationArray[i2]);
            }
        }
    }

    public static CharismaConfiguration getOptionalCharismaConfiguration(IDeserializer iDeserializer) {
        CharismaConfiguration charismaConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CharismaOperationMode charismaOperationMode;
            CharismaScreens charismaScreens;
            int n;
            CharismaTransmittableElements charismaTransmittableElements;
            CharismaProfiles charismaProfiles;
            charismaConfiguration = new CharismaConfiguration();
            charismaConfiguration.profilesAvailable = charismaProfiles = CharismaProfilesSerializer.getOptionalCharismaProfiles(iDeserializer);
            charismaConfiguration.charismaListTransmittableElements = charismaTransmittableElements = CharismaTransmittableElementsSerializer.getOptionalCharismaTransmittableElements(iDeserializer);
            charismaConfiguration.systemType = n = iDeserializer.getInt32();
            charismaConfiguration.screensAvailable = charismaScreens = CharismaScreensSerializer.getOptionalCharismaScreens(iDeserializer);
            charismaConfiguration.operationModesAvailable = charismaOperationMode = CharismaOperationModeSerializer.getOptionalCharismaOperationMode(iDeserializer);
        }
        return charismaConfiguration;
    }

    public static CharismaConfiguration[] getOptionalCharismaConfigurationVarArray(IDeserializer iDeserializer) {
        CharismaConfiguration[] charismaConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaConfigurationArray = new CharismaConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaConfigurationArray[i2] = CharismaConfigurationSerializer.getOptionalCharismaConfiguration(iDeserializer);
            }
        }
        return charismaConfigurationArray;
    }
}

