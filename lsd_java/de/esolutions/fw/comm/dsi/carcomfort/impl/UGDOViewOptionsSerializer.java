/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOConfiguration;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class UGDOViewOptionsSerializer {
    public static void putOptionalUGDOViewOptions(ISerializer iSerializer, UGDOViewOptions uGDOViewOptions) {
        boolean bl = uGDOViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = uGDOViewOptions.getLearningData();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = uGDOViewOptions.getDeleteButton();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = uGDOViewOptions.getVersionData();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = uGDOViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = uGDOViewOptions.getDestinationReached();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = uGDOViewOptions.getLearning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = uGDOViewOptions.getSynchronisation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = uGDOViewOptions.getOpenDoor();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = uGDOViewOptions.getButtonList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            UGDOConfiguration uGDOConfiguration = uGDOViewOptions.getConfiguration();
            UGDOConfigurationSerializer.putOptionalUGDOConfiguration(iSerializer, uGDOConfiguration);
        }
    }

    public static void putOptionalUGDOViewOptionsVarArray(ISerializer iSerializer, UGDOViewOptions[] uGDOViewOptionsArray) {
        boolean bl = uGDOViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOViewOptionsArray.length);
            for (int i2 = 0; i2 < uGDOViewOptionsArray.length; ++i2) {
                UGDOViewOptionsSerializer.putOptionalUGDOViewOptions(iSerializer, uGDOViewOptionsArray[i2]);
            }
        }
    }

    public static UGDOViewOptions getOptionalUGDOViewOptions(IDeserializer iDeserializer) {
        UGDOViewOptions uGDOViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UGDOConfiguration uGDOConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            uGDOViewOptions = new UGDOViewOptions();
            uGDOViewOptions.learningData = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.deleteButton = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.versionData = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.setFactoryDefault = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.destinationReached = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.learning = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.synchronisation = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.openDoor = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.buttonList = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            uGDOViewOptions.configuration = uGDOConfiguration = UGDOConfigurationSerializer.getOptionalUGDOConfiguration(iDeserializer);
        }
        return uGDOViewOptions;
    }

    public static UGDOViewOptions[] getOptionalUGDOViewOptionsVarArray(IDeserializer iDeserializer) {
        UGDOViewOptions[] uGDOViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOViewOptionsArray = new UGDOViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOViewOptionsArray[i2] = UGDOViewOptionsSerializer.getOptionalUGDOViewOptions(iDeserializer);
            }
        }
        return uGDOViewOptionsArray;
    }
}

