/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarArrayListTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAConfiguration;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class SIAConfigurationSerializer {
    public static void putOptionalSIAConfiguration(ISerializer iSerializer, SIAConfiguration sIAConfiguration) {
        boolean bl = sIAConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarArrayListTransmittableElements carArrayListTransmittableElements = sIAConfiguration.getHistoryListTransmittableElements();
            CarArrayListTransmittableElementsSerializer.putOptionalCarArrayListTransmittableElements(iSerializer, carArrayListTransmittableElements);
            int[] nArray = sIAConfiguration.getHistoryListRAConfig();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalSIAConfigurationVarArray(ISerializer iSerializer, SIAConfiguration[] sIAConfigurationArray) {
        boolean bl = sIAConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAConfigurationArray.length);
            for (int i2 = 0; i2 < sIAConfigurationArray.length; ++i2) {
                SIAConfigurationSerializer.putOptionalSIAConfiguration(iSerializer, sIAConfigurationArray[i2]);
            }
        }
    }

    public static SIAConfiguration getOptionalSIAConfiguration(IDeserializer iDeserializer) {
        SIAConfiguration sIAConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarArrayListTransmittableElements carArrayListTransmittableElements;
            sIAConfiguration = new SIAConfiguration();
            sIAConfiguration.historyListTransmittableElements = carArrayListTransmittableElements = CarArrayListTransmittableElementsSerializer.getOptionalCarArrayListTransmittableElements(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            sIAConfiguration.historyListRAConfig = nArray;
        }
        return sIAConfiguration;
    }

    public static SIAConfiguration[] getOptionalSIAConfigurationVarArray(IDeserializer iDeserializer) {
        SIAConfiguration[] sIAConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAConfigurationArray = new SIAConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAConfigurationArray[i2] = SIAConfigurationSerializer.getOptionalSIAConfiguration(iDeserializer);
            }
        }
        return sIAConfigurationArray;
    }
}

