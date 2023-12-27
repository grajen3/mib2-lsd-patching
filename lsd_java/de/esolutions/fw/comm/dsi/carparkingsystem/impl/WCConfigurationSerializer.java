/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarArrayListTransmittableElementsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCConfiguration;
import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class WCConfigurationSerializer {
    public static void putOptionalWCConfiguration(ISerializer iSerializer, WCConfiguration wCConfiguration) {
        boolean bl = wCConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wCConfiguration.getVehiclePanelSizeY();
            iSerializer.putInt32(n);
            int n2 = wCConfiguration.getVehiclePanelSizeX();
            iSerializer.putInt32(n2);
            int n3 = wCConfiguration.getVehiclePanelPositionY();
            iSerializer.putInt32(n3);
            int n4 = wCConfiguration.getVehiclePanelPositionX();
            iSerializer.putInt32(n4);
            int n5 = wCConfiguration.getVehicleWidth();
            iSerializer.putInt32(n5);
            CarArrayListTransmittableElements carArrayListTransmittableElements = wCConfiguration.getPanelListTransmittableElements();
            CarArrayListTransmittableElementsSerializer.putOptionalCarArrayListTransmittableElements(iSerializer, carArrayListTransmittableElements);
            int[] nArray = wCConfiguration.getPanelListRAConfig();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalWCConfigurationVarArray(ISerializer iSerializer, WCConfiguration[] wCConfigurationArray) {
        boolean bl = wCConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCConfigurationArray.length);
            for (int i2 = 0; i2 < wCConfigurationArray.length; ++i2) {
                WCConfigurationSerializer.putOptionalWCConfiguration(iSerializer, wCConfigurationArray[i2]);
            }
        }
    }

    public static WCConfiguration getOptionalWCConfiguration(IDeserializer iDeserializer) {
        WCConfiguration wCConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarArrayListTransmittableElements carArrayListTransmittableElements;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            wCConfiguration = new WCConfiguration();
            wCConfiguration.vehiclePanelSizeY = n5 = iDeserializer.getInt32();
            wCConfiguration.vehiclePanelSizeX = n4 = iDeserializer.getInt32();
            wCConfiguration.vehiclePanelPositionY = n3 = iDeserializer.getInt32();
            wCConfiguration.vehiclePanelPositionX = n2 = iDeserializer.getInt32();
            wCConfiguration.vehicleWidth = n = iDeserializer.getInt32();
            wCConfiguration.panelListTransmittableElements = carArrayListTransmittableElements = CarArrayListTransmittableElementsSerializer.getOptionalCarArrayListTransmittableElements(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            wCConfiguration.panelListRAConfig = nArray;
        }
        return wCConfiguration;
    }

    public static WCConfiguration[] getOptionalWCConfigurationVarArray(IDeserializer iDeserializer) {
        WCConfiguration[] wCConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCConfigurationArray = new WCConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCConfigurationArray[i2] = WCConfigurationSerializer.getOptionalWCConfiguration(iDeserializer);
            }
        }
        return wCConfigurationArray;
    }
}

