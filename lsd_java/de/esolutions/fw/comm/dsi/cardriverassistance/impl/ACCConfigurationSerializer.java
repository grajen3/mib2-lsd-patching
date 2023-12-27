/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.ACCAvailableDrivingProgramsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.ACCAvailableDrivingPrograms;
import org.dsi.ifc.cardriverassistance.ACCConfiguration;

public class ACCConfigurationSerializer {
    public static void putOptionalACCConfiguration(ISerializer iSerializer, ACCConfiguration aCCConfiguration) {
        boolean bl = aCCConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms = aCCConfiguration.getDrivingPrograms();
            ACCAvailableDrivingProgramsSerializer.putOptionalACCAvailableDrivingPrograms(iSerializer, aCCAvailableDrivingPrograms);
        }
    }

    public static void putOptionalACCConfigurationVarArray(ISerializer iSerializer, ACCConfiguration[] aCCConfigurationArray) {
        boolean bl = aCCConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aCCConfigurationArray.length);
            for (int i2 = 0; i2 < aCCConfigurationArray.length; ++i2) {
                ACCConfigurationSerializer.putOptionalACCConfiguration(iSerializer, aCCConfigurationArray[i2]);
            }
        }
    }

    public static ACCConfiguration getOptionalACCConfiguration(IDeserializer iDeserializer) {
        ACCConfiguration aCCConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms;
            aCCConfiguration = new ACCConfiguration();
            aCCConfiguration.drivingPrograms = aCCAvailableDrivingPrograms = ACCAvailableDrivingProgramsSerializer.getOptionalACCAvailableDrivingPrograms(iDeserializer);
        }
        return aCCConfiguration;
    }

    public static ACCConfiguration[] getOptionalACCConfigurationVarArray(IDeserializer iDeserializer) {
        ACCConfiguration[] aCCConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aCCConfigurationArray = new ACCConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aCCConfigurationArray[i2] = ACCConfigurationSerializer.getOptionalACCConfiguration(iDeserializer);
            }
        }
        return aCCConfigurationArray;
    }
}

