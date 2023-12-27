/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCConfiguration;
import org.dsi.ifc.carparkingsystem.WCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class WCViewOptionsSerializer {
    public static void putOptionalWCViewOptions(ISerializer iSerializer, WCViewOptions wCViewOptions) {
        boolean bl = wCViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = wCViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = wCViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = wCViewOptions.getAutoActivation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = wCViewOptions.getVehiclePanelInfo();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = wCViewOptions.getPinPukState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = wCViewOptions.getPanelList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = wCViewOptions.getEnterPinPuk();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = wCViewOptions.getStartScanning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = wCViewOptions.getStartPairing();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = wCViewOptions.getStartSoftwareUpdate();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = wCViewOptions.getChangePin();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = wCViewOptions.getChangePanelName();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            WCConfiguration wCConfiguration = wCViewOptions.getConfiguration();
            WCConfigurationSerializer.putOptionalWCConfiguration(iSerializer, wCConfiguration);
        }
    }

    public static void putOptionalWCViewOptionsVarArray(ISerializer iSerializer, WCViewOptions[] wCViewOptionsArray) {
        boolean bl = wCViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCViewOptionsArray.length);
            for (int i2 = 0; i2 < wCViewOptionsArray.length; ++i2) {
                WCViewOptionsSerializer.putOptionalWCViewOptions(iSerializer, wCViewOptionsArray[i2]);
            }
        }
    }

    public static WCViewOptions getOptionalWCViewOptions(IDeserializer iDeserializer) {
        WCViewOptions wCViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            WCConfiguration wCConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            wCViewOptions = new WCViewOptions();
            wCViewOptions.systemOnOff = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.setFactoryDefault = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.autoActivation = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.vehiclePanelInfo = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.pinPukState = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.panelList = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.enterPinPuk = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.startScanning = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.startPairing = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.startSoftwareUpdate = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.changePin = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.changePanelName = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            wCViewOptions.configuration = wCConfiguration = WCConfigurationSerializer.getOptionalWCConfiguration(iDeserializer);
        }
        return wCViewOptions;
    }

    public static WCViewOptions[] getOptionalWCViewOptionsVarArray(IDeserializer iDeserializer) {
        WCViewOptions[] wCViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCViewOptionsArray = new WCViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCViewOptionsArray[i2] = WCViewOptionsSerializer.getOptionalWCViewOptions(iDeserializer);
            }
        }
        return wCViewOptionsArray;
    }
}

