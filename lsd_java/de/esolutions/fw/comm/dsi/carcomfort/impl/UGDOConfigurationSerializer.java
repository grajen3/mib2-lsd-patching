/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSpecialFeaturesSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOConfiguration;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;
import org.dsi.ifc.carcomfort.UGDOTransmittableElements;

public class UGDOConfigurationSerializer {
    public static void putOptionalUGDOConfiguration(ISerializer iSerializer, UGDOConfiguration uGDOConfiguration) {
        boolean bl = uGDOConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOConfiguration.getAvailableHardkeys();
            iSerializer.putInt32(n);
            int n2 = uGDOConfiguration.getAvailableSoftkeys();
            iSerializer.putInt32(n2);
            UGDOSpecialFeatures uGDOSpecialFeatures = uGDOConfiguration.getSpecialFeatures();
            UGDOSpecialFeaturesSerializer.putOptionalUGDOSpecialFeatures(iSerializer, uGDOSpecialFeatures);
            int n3 = uGDOConfiguration.getGpsSupervisionRadius();
            iSerializer.putInt32(n3);
            UGDOTransmittableElements uGDOTransmittableElements = uGDOConfiguration.getButtonListTransmittableElements();
            UGDOTransmittableElementsSerializer.putOptionalUGDOTransmittableElements(iSerializer, uGDOTransmittableElements);
        }
    }

    public static void putOptionalUGDOConfigurationVarArray(ISerializer iSerializer, UGDOConfiguration[] uGDOConfigurationArray) {
        boolean bl = uGDOConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOConfigurationArray.length);
            for (int i2 = 0; i2 < uGDOConfigurationArray.length; ++i2) {
                UGDOConfigurationSerializer.putOptionalUGDOConfiguration(iSerializer, uGDOConfigurationArray[i2]);
            }
        }
    }

    public static UGDOConfiguration getOptionalUGDOConfiguration(IDeserializer iDeserializer) {
        UGDOConfiguration uGDOConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UGDOTransmittableElements uGDOTransmittableElements;
            int n;
            UGDOSpecialFeatures uGDOSpecialFeatures;
            int n2;
            int n3;
            uGDOConfiguration = new UGDOConfiguration();
            uGDOConfiguration.availableHardkeys = n3 = iDeserializer.getInt32();
            uGDOConfiguration.availableSoftkeys = n2 = iDeserializer.getInt32();
            uGDOConfiguration.specialFeatures = uGDOSpecialFeatures = UGDOSpecialFeaturesSerializer.getOptionalUGDOSpecialFeatures(iDeserializer);
            uGDOConfiguration.gpsSupervisionRadius = n = iDeserializer.getInt32();
            uGDOConfiguration.buttonListTransmittableElements = uGDOTransmittableElements = UGDOTransmittableElementsSerializer.getOptionalUGDOTransmittableElements(iDeserializer);
        }
        return uGDOConfiguration;
    }

    public static UGDOConfiguration[] getOptionalUGDOConfigurationVarArray(IDeserializer iDeserializer) {
        UGDOConfiguration[] uGDOConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOConfigurationArray = new UGDOConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOConfigurationArray[i2] = UGDOConfigurationSerializer.getOptionalUGDOConfiguration(iDeserializer);
            }
        }
        return uGDOConfigurationArray;
    }
}

