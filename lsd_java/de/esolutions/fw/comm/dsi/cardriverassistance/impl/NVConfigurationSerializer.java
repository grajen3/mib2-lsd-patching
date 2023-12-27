/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.NVConfiguration;

public class NVConfigurationSerializer {
    public static void putOptionalNVConfiguration(ISerializer iSerializer, NVConfiguration nVConfiguration) {
        boolean bl = nVConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = nVConfiguration.isInstallationHUDDisplay();
            iSerializer.putBool(bl2);
            boolean bl3 = nVConfiguration.isInstallationKombiDisplay();
            iSerializer.putBool(bl3);
            boolean bl4 = nVConfiguration.isInstallationMMIDisplay();
            iSerializer.putBool(bl4);
            boolean bl5 = nVConfiguration.isPanning();
            iSerializer.putBool(bl5);
            boolean bl6 = nVConfiguration.isAnimalDetection();
            iSerializer.putBool(bl6);
            boolean bl7 = nVConfiguration.isPedestrianDetection();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalNVConfigurationVarArray(ISerializer iSerializer, NVConfiguration[] nVConfigurationArray) {
        boolean bl = nVConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nVConfigurationArray.length);
            for (int i2 = 0; i2 < nVConfigurationArray.length; ++i2) {
                NVConfigurationSerializer.putOptionalNVConfiguration(iSerializer, nVConfigurationArray[i2]);
            }
        }
    }

    public static NVConfiguration getOptionalNVConfiguration(IDeserializer iDeserializer) {
        NVConfiguration nVConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            nVConfiguration = new NVConfiguration();
            nVConfiguration.installationHUDDisplay = bl7 = iDeserializer.getBool();
            nVConfiguration.installationKombiDisplay = bl6 = iDeserializer.getBool();
            nVConfiguration.installationMMIDisplay = bl5 = iDeserializer.getBool();
            nVConfiguration.panning = bl4 = iDeserializer.getBool();
            nVConfiguration.animalDetection = bl3 = iDeserializer.getBool();
            nVConfiguration.pedestrianDetection = bl2 = iDeserializer.getBool();
        }
        return nVConfiguration;
    }

    public static NVConfiguration[] getOptionalNVConfigurationVarArray(IDeserializer iDeserializer) {
        NVConfiguration[] nVConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nVConfigurationArray = new NVConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nVConfigurationArray[i2] = NVConfigurationSerializer.getOptionalNVConfiguration(iDeserializer);
            }
        }
        return nVConfigurationArray;
    }
}

