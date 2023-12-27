/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.careco.impl.BCmETransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConfiguration;
import org.dsi.ifc.careco.BCmETransmittableElements;

public class BCmEConfigurationSerializer {
    public static void putOptionalBCmEConfiguration(ISerializer iSerializer, BCmEConfiguration bCmEConfiguration) {
        boolean bl = bCmEConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConfiguration.getPrimaryEngineType();
            iSerializer.putInt32(n);
            int n2 = bCmEConfiguration.getSecondaryEngineType();
            iSerializer.putInt32(n2);
            BCmETransmittableElements bCmETransmittableElements = bCmEConfiguration.getConsumerListTransmittableElements();
            BCmETransmittableElementsSerializer.putOptionalBCmETransmittableElements(iSerializer, bCmETransmittableElements);
            BCmETransmittableElements bCmETransmittableElements2 = bCmEConfiguration.getConsumerListConsumptionTransmittableElements();
            BCmETransmittableElementsSerializer.putOptionalBCmETransmittableElements(iSerializer, bCmETransmittableElements2);
            BCmETransmittableElements bCmETransmittableElements3 = bCmEConfiguration.getConsumerListRangeTransmittableElements();
            BCmETransmittableElementsSerializer.putOptionalBCmETransmittableElements(iSerializer, bCmETransmittableElements3);
        }
    }

    public static void putOptionalBCmEConfigurationVarArray(ISerializer iSerializer, BCmEConfiguration[] bCmEConfigurationArray) {
        boolean bl = bCmEConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConfigurationArray.length);
            for (int i2 = 0; i2 < bCmEConfigurationArray.length; ++i2) {
                BCmEConfigurationSerializer.putOptionalBCmEConfiguration(iSerializer, bCmEConfigurationArray[i2]);
            }
        }
    }

    public static BCmEConfiguration getOptionalBCmEConfiguration(IDeserializer iDeserializer) {
        BCmEConfiguration bCmEConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BCmETransmittableElements bCmETransmittableElements;
            BCmETransmittableElements bCmETransmittableElements2;
            BCmETransmittableElements bCmETransmittableElements3;
            int n;
            int n2;
            bCmEConfiguration = new BCmEConfiguration();
            bCmEConfiguration.primaryEngineType = n2 = iDeserializer.getInt32();
            bCmEConfiguration.secondaryEngineType = n = iDeserializer.getInt32();
            bCmEConfiguration.consumerListTransmittableElements = bCmETransmittableElements3 = BCmETransmittableElementsSerializer.getOptionalBCmETransmittableElements(iDeserializer);
            bCmEConfiguration.consumerListConsumptionTransmittableElements = bCmETransmittableElements2 = BCmETransmittableElementsSerializer.getOptionalBCmETransmittableElements(iDeserializer);
            bCmEConfiguration.consumerListRangeTransmittableElements = bCmETransmittableElements = BCmETransmittableElementsSerializer.getOptionalBCmETransmittableElements(iDeserializer);
        }
        return bCmEConfiguration;
    }

    public static BCmEConfiguration[] getOptionalBCmEConfigurationVarArray(IDeserializer iDeserializer) {
        BCmEConfiguration[] bCmEConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConfigurationArray = new BCmEConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConfigurationArray[i2] = BCmEConfigurationSerializer.getOptionalBCmEConfiguration(iDeserializer);
            }
        }
        return bCmEConfigurationArray;
    }
}

