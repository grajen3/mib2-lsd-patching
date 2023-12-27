/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCFISAdditionalConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCFunctionSupportSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCConfiguration;
import org.dsi.ifc.carkombi.BCFISAdditionalConfiguration;
import org.dsi.ifc.carkombi.BCFunctionSupport;
import org.dsi.ifc.carkombi.BCTransmittableElements;

public class BCConfigurationSerializer {
    public static void putOptionalBCConfiguration(ISerializer iSerializer, BCConfiguration bCConfiguration) {
        boolean bl = bCConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCConfiguration.getPrimaryEngineType();
            iSerializer.putInt32(n);
            int n2 = bCConfiguration.getSecondaryEngineType();
            iSerializer.putInt32(n2);
            BCFISAdditionalConfiguration bCFISAdditionalConfiguration = bCConfiguration.getFisAdditionalConfiguration();
            BCFISAdditionalConfigurationSerializer.putOptionalBCFISAdditionalConfiguration(iSerializer, bCFISAdditionalConfiguration);
            BCTransmittableElements bCTransmittableElements = bCConfiguration.getTransmittableElementsVehicleState();
            BCTransmittableElementsSerializer.putOptionalBCTransmittableElements(iSerializer, bCTransmittableElements);
            BCFunctionSupport bCFunctionSupport = bCConfiguration.getFunctionSupport();
            BCFunctionSupportSerializer.putOptionalBCFunctionSupport(iSerializer, bCFunctionSupport);
        }
    }

    public static void putOptionalBCConfigurationVarArray(ISerializer iSerializer, BCConfiguration[] bCConfigurationArray) {
        boolean bl = bCConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCConfigurationArray.length);
            for (int i2 = 0; i2 < bCConfigurationArray.length; ++i2) {
                BCConfigurationSerializer.putOptionalBCConfiguration(iSerializer, bCConfigurationArray[i2]);
            }
        }
    }

    public static BCConfiguration getOptionalBCConfiguration(IDeserializer iDeserializer) {
        BCConfiguration bCConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BCFunctionSupport bCFunctionSupport;
            BCTransmittableElements bCTransmittableElements;
            BCFISAdditionalConfiguration bCFISAdditionalConfiguration;
            int n;
            int n2;
            bCConfiguration = new BCConfiguration();
            bCConfiguration.primaryEngineType = n2 = iDeserializer.getInt32();
            bCConfiguration.secondaryEngineType = n = iDeserializer.getInt32();
            bCConfiguration.fisAdditionalConfiguration = bCFISAdditionalConfiguration = BCFISAdditionalConfigurationSerializer.getOptionalBCFISAdditionalConfiguration(iDeserializer);
            bCConfiguration.transmittableElementsVehicleState = bCTransmittableElements = BCTransmittableElementsSerializer.getOptionalBCTransmittableElements(iDeserializer);
            bCConfiguration.functionSupport = bCFunctionSupport = BCFunctionSupportSerializer.getOptionalBCFunctionSupport(iDeserializer);
        }
        return bCConfiguration;
    }

    public static BCConfiguration[] getOptionalBCConfigurationVarArray(IDeserializer iDeserializer) {
        BCConfiguration[] bCConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCConfigurationArray = new BCConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCConfigurationArray[i2] = BCConfigurationSerializer.getOptionalBCConfiguration(iDeserializer);
            }
        }
        return bCConfigurationArray;
    }
}

