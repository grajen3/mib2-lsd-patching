/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SpoilerConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SpoilerViewOptionsSerializer {
    public static void putOptionalSpoilerViewOptions(ISerializer iSerializer, SpoilerViewOptions spoilerViewOptions) {
        boolean bl = spoilerViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = spoilerViewOptions.getPositionSelection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = spoilerViewOptions.getPosition0();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = spoilerViewOptions.getPosition1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = spoilerViewOptions.getPosition2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = spoilerViewOptions.getPosition3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = spoilerViewOptions.getPosition4();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = spoilerViewOptions.getPosition5();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = spoilerViewOptions.getState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = spoilerViewOptions.getActuation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = spoilerViewOptions.getMessages();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = spoilerViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = spoilerViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            SpoilerConfiguration spoilerConfiguration = spoilerViewOptions.getConfiguration();
            SpoilerConfigurationSerializer.putOptionalSpoilerConfiguration(iSerializer, spoilerConfiguration);
        }
    }

    public static void putOptionalSpoilerViewOptionsVarArray(ISerializer iSerializer, SpoilerViewOptions[] spoilerViewOptionsArray) {
        boolean bl = spoilerViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(spoilerViewOptionsArray.length);
            for (int i2 = 0; i2 < spoilerViewOptionsArray.length; ++i2) {
                SpoilerViewOptionsSerializer.putOptionalSpoilerViewOptions(iSerializer, spoilerViewOptionsArray[i2]);
            }
        }
    }

    public static SpoilerViewOptions getOptionalSpoilerViewOptions(IDeserializer iDeserializer) {
        SpoilerViewOptions spoilerViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SpoilerConfiguration spoilerConfiguration;
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
            spoilerViewOptions = new SpoilerViewOptions();
            spoilerViewOptions.positionSelection = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.position0 = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.position1 = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.position2 = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.position3 = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.position4 = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.position5 = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.state = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.actuation = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.messages = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.setFactoryDefault = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.systemOnOff = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            spoilerViewOptions.configuration = spoilerConfiguration = SpoilerConfigurationSerializer.getOptionalSpoilerConfiguration(iDeserializer);
        }
        return spoilerViewOptions;
    }

    public static SpoilerViewOptions[] getOptionalSpoilerViewOptionsVarArray(IDeserializer iDeserializer) {
        SpoilerViewOptions[] spoilerViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            spoilerViewOptionsArray = new SpoilerViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                spoilerViewOptionsArray[i2] = SpoilerViewOptionsSerializer.getOptionalSpoilerViewOptions(iDeserializer);
            }
        }
        return spoilerViewOptionsArray;
    }
}

