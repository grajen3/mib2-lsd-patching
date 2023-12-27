/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCTransmittableElementsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCConfiguration;
import org.dsi.ifc.carkombi.DCTransmittableElements;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class DCConfigurationSerializer {
    public static void putOptionalDCConfiguration(ISerializer iSerializer, DCConfiguration dCConfiguration) {
        boolean bl = dCConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCConfiguration.getMaxVolume();
            iSerializer.putInt32(n);
            DCTransmittableElements dCTransmittableElements = dCConfiguration.getElementContentSelectionListTransmittableElements();
            DCTransmittableElementsSerializer.putOptionalDCTransmittableElements(iSerializer, dCTransmittableElements);
            boolean bl2 = dCConfiguration.isDependencyDrivingProfile();
            iSerializer.putBool(bl2);
            CarArrayListTransmittableElements carArrayListTransmittableElements = dCConfiguration.getDisplayPresetsListTransmittableElements();
            CarArrayListTransmittableElementsSerializer.putOptionalCarArrayListTransmittableElements(iSerializer, carArrayListTransmittableElements);
            int[] nArray = dCConfiguration.getDisplayPresetsListRAConfig();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalDCConfigurationVarArray(ISerializer iSerializer, DCConfiguration[] dCConfigurationArray) {
        boolean bl = dCConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCConfigurationArray.length);
            for (int i2 = 0; i2 < dCConfigurationArray.length; ++i2) {
                DCConfigurationSerializer.putOptionalDCConfiguration(iSerializer, dCConfigurationArray[i2]);
            }
        }
    }

    public static DCConfiguration getOptionalDCConfiguration(IDeserializer iDeserializer) {
        DCConfiguration dCConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarArrayListTransmittableElements carArrayListTransmittableElements;
            boolean bl2;
            DCTransmittableElements dCTransmittableElements;
            int n;
            dCConfiguration = new DCConfiguration();
            dCConfiguration.maxVolume = n = iDeserializer.getInt32();
            dCConfiguration.elementContentSelectionListTransmittableElements = dCTransmittableElements = DCTransmittableElementsSerializer.getOptionalDCTransmittableElements(iDeserializer);
            dCConfiguration.dependencyDrivingProfile = bl2 = iDeserializer.getBool();
            dCConfiguration.displayPresetsListTransmittableElements = carArrayListTransmittableElements = CarArrayListTransmittableElementsSerializer.getOptionalCarArrayListTransmittableElements(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            dCConfiguration.displayPresetsListRAConfig = nArray;
        }
        return dCConfiguration;
    }

    public static DCConfiguration[] getOptionalDCConfigurationVarArray(IDeserializer iDeserializer) {
        DCConfiguration[] dCConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCConfigurationArray = new DCConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCConfigurationArray[i2] = DCConfigurationSerializer.getOptionalDCConfiguration(iDeserializer);
            }
        }
        return dCConfigurationArray;
    }
}

