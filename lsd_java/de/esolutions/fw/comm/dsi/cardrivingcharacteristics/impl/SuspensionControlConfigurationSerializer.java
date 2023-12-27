/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlAdditionalFunctionsSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlAirProfilesSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlDRCProfilesSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlLevelsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlLevels;

public class SuspensionControlConfigurationSerializer {
    public static void putOptionalSuspensionControlConfiguration(ISerializer iSerializer, SuspensionControlConfiguration suspensionControlConfiguration) {
        boolean bl = suspensionControlConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = suspensionControlConfiguration.getDeviceType();
            iSerializer.putInt32(n);
            int n2 = suspensionControlConfiguration.getModelType();
            iSerializer.putInt32(n2);
            SuspensionControlAirProfiles suspensionControlAirProfiles = suspensionControlConfiguration.getAirProfileAvailability();
            SuspensionControlAirProfilesSerializer.putOptionalSuspensionControlAirProfiles(iSerializer, suspensionControlAirProfiles);
            SuspensionControlDRCProfiles suspensionControlDRCProfiles = suspensionControlConfiguration.getDrcProfileAvailability();
            SuspensionControlDRCProfilesSerializer.putOptionalSuspensionControlDRCProfiles(iSerializer, suspensionControlDRCProfiles);
            SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions = suspensionControlConfiguration.getAdditionalFunctionsAvailability();
            SuspensionControlAdditionalFunctionsSerializer.putOptionalSuspensionControlAdditionalFunctions(iSerializer, suspensionControlAdditionalFunctions);
            SuspensionControlLevels suspensionControlLevels = suspensionControlConfiguration.getLevelsAvailability();
            SuspensionControlLevelsSerializer.putOptionalSuspensionControlLevels(iSerializer, suspensionControlLevels);
        }
    }

    public static void putOptionalSuspensionControlConfigurationVarArray(ISerializer iSerializer, SuspensionControlConfiguration[] suspensionControlConfigurationArray) {
        boolean bl = suspensionControlConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlConfigurationArray.length);
            for (int i2 = 0; i2 < suspensionControlConfigurationArray.length; ++i2) {
                SuspensionControlConfigurationSerializer.putOptionalSuspensionControlConfiguration(iSerializer, suspensionControlConfigurationArray[i2]);
            }
        }
    }

    public static SuspensionControlConfiguration getOptionalSuspensionControlConfiguration(IDeserializer iDeserializer) {
        SuspensionControlConfiguration suspensionControlConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SuspensionControlLevels suspensionControlLevels;
            SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions;
            SuspensionControlDRCProfiles suspensionControlDRCProfiles;
            SuspensionControlAirProfiles suspensionControlAirProfiles;
            int n;
            int n2;
            suspensionControlConfiguration = new SuspensionControlConfiguration();
            suspensionControlConfiguration.deviceType = n2 = iDeserializer.getInt32();
            suspensionControlConfiguration.modelType = n = iDeserializer.getInt32();
            suspensionControlConfiguration.airProfileAvailability = suspensionControlAirProfiles = SuspensionControlAirProfilesSerializer.getOptionalSuspensionControlAirProfiles(iDeserializer);
            suspensionControlConfiguration.drcProfileAvailability = suspensionControlDRCProfiles = SuspensionControlDRCProfilesSerializer.getOptionalSuspensionControlDRCProfiles(iDeserializer);
            suspensionControlConfiguration.additionalFunctionsAvailability = suspensionControlAdditionalFunctions = SuspensionControlAdditionalFunctionsSerializer.getOptionalSuspensionControlAdditionalFunctions(iDeserializer);
            suspensionControlConfiguration.levelsAvailability = suspensionControlLevels = SuspensionControlLevelsSerializer.getOptionalSuspensionControlLevels(iDeserializer);
        }
        return suspensionControlConfiguration;
    }

    public static SuspensionControlConfiguration[] getOptionalSuspensionControlConfigurationVarArray(IDeserializer iDeserializer) {
        SuspensionControlConfiguration[] suspensionControlConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlConfigurationArray = new SuspensionControlConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlConfigurationArray[i2] = SuspensionControlConfigurationSerializer.getOptionalSuspensionControlConfiguration(iDeserializer);
            }
        }
        return suspensionControlConfigurationArray;
    }
}

