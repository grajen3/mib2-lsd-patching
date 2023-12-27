/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.cardriverassistance.impl.NVConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.NVConfiguration;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class NVViewOptionsSerializer {
    public static void putOptionalNVViewOptions(ISerializer iSerializer, NVViewOptions nVViewOptions) {
        boolean bl = nVViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = nVViewOptions.getActivation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = nVViewOptions.getContrast();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = nVViewOptions.getBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = nVViewOptions.getObjectDetection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = nVViewOptions.getColorPA();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = nVViewOptions.getDesignPA();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = nVViewOptions.getDisplay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = nVViewOptions.getZoomPanning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = nVViewOptions.getSound();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = nVViewOptions.getSymbol();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            NVConfiguration nVConfiguration = nVViewOptions.getConfiguration();
            NVConfigurationSerializer.putOptionalNVConfiguration(iSerializer, nVConfiguration);
            CarViewOption carViewOption11 = nVViewOptions.getSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = nVViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = nVViewOptions.getWarningTimegap();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
        }
    }

    public static void putOptionalNVViewOptionsVarArray(ISerializer iSerializer, NVViewOptions[] nVViewOptionsArray) {
        boolean bl = nVViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nVViewOptionsArray.length);
            for (int i2 = 0; i2 < nVViewOptionsArray.length; ++i2) {
                NVViewOptionsSerializer.putOptionalNVViewOptions(iSerializer, nVViewOptionsArray[i2]);
            }
        }
    }

    public static NVViewOptions getOptionalNVViewOptions(IDeserializer iDeserializer) {
        NVViewOptions nVViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            NVConfiguration nVConfiguration;
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
            nVViewOptions = new NVViewOptions();
            nVViewOptions.activation = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.contrast = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.brightness = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.objectDetection = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.colorPA = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.designPA = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.display = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.zoomPanning = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.sound = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.symbol = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.configuration = nVConfiguration = NVConfigurationSerializer.getOptionalNVConfiguration(iDeserializer);
            nVViewOptions.system = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.setFactoryDefault = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            nVViewOptions.warningTimegap = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return nVViewOptions;
    }

    public static NVViewOptions[] getOptionalNVViewOptionsVarArray(IDeserializer iDeserializer) {
        NVViewOptions[] nVViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nVViewOptionsArray = new NVViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nVViewOptionsArray[i2] = NVViewOptionsSerializer.getOptionalNVViewOptions(iDeserializer);
            }
        }
        return nVViewOptionsArray;
    }
}

