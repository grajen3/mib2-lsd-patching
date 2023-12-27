/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCConfiguration;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DCViewOptionsSerializer {
    public static void putOptionalDCViewOptions(ISerializer iSerializer, DCViewOptions dCViewOptions) {
        boolean bl = dCViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = dCViewOptions.getBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = dCViewOptions.getVolume();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = dCViewOptions.getElementContentSelectionList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = dCViewOptions.getDisplay1Setup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = dCViewOptions.getDisplay1MainSelection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = dCViewOptions.getDisplay2Setup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = dCViewOptions.getDisplay2MainSelection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = dCViewOptions.getDisplay3Setup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = dCViewOptions.getDisplay3MainSelection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = dCViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = dCViewOptions.getAdditionalInstrumentSetup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = dCViewOptions.getAdditionalInstrument2Setup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = dCViewOptions.getDisplayPresetsList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = dCViewOptions.getActiveDisplayPreset();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = dCViewOptions.getDisplayViewConfiguration();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = dCViewOptions.getDisplayDependency();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = dCViewOptions.getLedConfiguration();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            DCConfiguration dCConfiguration = dCViewOptions.getConfiguration();
            DCConfigurationSerializer.putOptionalDCConfiguration(iSerializer, dCConfiguration);
        }
    }

    public static void putOptionalDCViewOptionsVarArray(ISerializer iSerializer, DCViewOptions[] dCViewOptionsArray) {
        boolean bl = dCViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCViewOptionsArray.length);
            for (int i2 = 0; i2 < dCViewOptionsArray.length; ++i2) {
                DCViewOptionsSerializer.putOptionalDCViewOptions(iSerializer, dCViewOptionsArray[i2]);
            }
        }
    }

    public static DCViewOptions getOptionalDCViewOptions(IDeserializer iDeserializer) {
        DCViewOptions dCViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DCConfiguration dCConfiguration;
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
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            dCViewOptions = new DCViewOptions();
            dCViewOptions.brightness = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.volume = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.elementContentSelectionList = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.display1Setup = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.display1MainSelection = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.display2Setup = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.display2MainSelection = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.display3Setup = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.display3MainSelection = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.setFactoryDefault = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.additionalInstrumentSetup = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.additionalInstrument2Setup = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.displayPresetsList = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.activeDisplayPreset = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.displayViewConfiguration = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.displayDependency = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.ledConfiguration = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            dCViewOptions.configuration = dCConfiguration = DCConfigurationSerializer.getOptionalDCConfiguration(iDeserializer);
        }
        return dCViewOptions;
    }

    public static DCViewOptions[] getOptionalDCViewOptionsVarArray(IDeserializer iDeserializer) {
        DCViewOptions[] dCViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCViewOptionsArray = new DCViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCViewOptionsArray[i2] = DCViewOptionsSerializer.getOptionalDCViewOptions(iDeserializer);
            }
        }
        return dCViewOptionsArray;
    }
}

