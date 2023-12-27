/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSConfiguration;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class RGSViewOptionsSerializer {
    public static void putOptionalRGSViewOptions(ISerializer iSerializer, RGSViewOptions rGSViewOptions) {
        boolean bl = rGSViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = rGSViewOptions.getBeltPretensionerFrontDataLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = rGSViewOptions.getBeltPretensionerFrontDataRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = rGSViewOptions.getBeltPretensionerRearDataLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = rGSViewOptions.getBeltPretensionerRearDataRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = rGSViewOptions.getPreCrashSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = rGSViewOptions.getRgsSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = rGSViewOptions.getPreSenseSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = rGSViewOptions.getPreSenseWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = rGSViewOptions.getLocalHazardDetection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = rGSViewOptions.getLocalHazardInformation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            RGSConfiguration rGSConfiguration = rGSViewOptions.getConfiguration();
            RGSConfigurationSerializer.putOptionalRGSConfiguration(iSerializer, rGSConfiguration);
        }
    }

    public static void putOptionalRGSViewOptionsVarArray(ISerializer iSerializer, RGSViewOptions[] rGSViewOptionsArray) {
        boolean bl = rGSViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rGSViewOptionsArray.length);
            for (int i2 = 0; i2 < rGSViewOptionsArray.length; ++i2) {
                RGSViewOptionsSerializer.putOptionalRGSViewOptions(iSerializer, rGSViewOptionsArray[i2]);
            }
        }
    }

    public static RGSViewOptions getOptionalRGSViewOptions(IDeserializer iDeserializer) {
        RGSViewOptions rGSViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            RGSConfiguration rGSConfiguration;
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
            rGSViewOptions = new RGSViewOptions();
            rGSViewOptions.beltPretensionerFrontDataLeft = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.beltPretensionerFrontDataRight = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.beltPretensionerRearDataLeft = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.beltPretensionerRearDataRight = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.preCrashSystem = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.rgsSetFactoryDefault = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.preSenseSystem = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.preSenseWarning = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.localHazardDetection = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.localHazardInformation = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            rGSViewOptions.configuration = rGSConfiguration = RGSConfigurationSerializer.getOptionalRGSConfiguration(iDeserializer);
        }
        return rGSViewOptions;
    }

    public static RGSViewOptions[] getOptionalRGSViewOptionsVarArray(IDeserializer iDeserializer) {
        RGSViewOptions[] rGSViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rGSViewOptionsArray = new RGSViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rGSViewOptionsArray[i2] = RGSViewOptionsSerializer.getOptionalRGSViewOptions(iDeserializer);
            }
        }
        return rGSViewOptionsArray;
    }
}

