/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.IntLightConfigSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class IntLightViewOptionsSerializer {
    public static void putOptionalIntLightViewOptions(ISerializer iSerializer, IntLightViewOptions intLightViewOptions) {
        boolean bl = intLightViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = intLightViewOptions.getIntLightState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = intLightViewOptions.getIntLightColour();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = intLightViewOptions.getIntLightEnvironment();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = intLightViewOptions.getIntLightTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = intLightViewOptions.getIntLightSpeed();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = intLightViewOptions.getIntLightBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = intLightViewOptions.getIntLightIlluminationSet1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = intLightViewOptions.getIntLightIlluminationSet2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = intLightViewOptions.getIntLightIlluminationSet3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = intLightViewOptions.getIntLightIlluminationSet4();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = intLightViewOptions.getIntLightIlluminationSet5();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = intLightViewOptions.getIntLightIlluminationSet6();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = intLightViewOptions.getIntLightIlluminationSet7();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = intLightViewOptions.getIntLightIlluminationSet8();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = intLightViewOptions.getIntLightIlluminationProfile1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = intLightViewOptions.getIntLightIlluminationProfile2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = intLightViewOptions.getIntLightIlluminationProfile3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = intLightViewOptions.getIntLightIlluminationProfile4();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = intLightViewOptions.getIntLightIlluminationProfile5();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = intLightViewOptions.getIntLightIlluminationProfile6();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = intLightViewOptions.getIntLightIlluminationProfile7();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = intLightViewOptions.getIntLightIlluminationProfile8();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = intLightViewOptions.getIntLightActiveProfile();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = intLightViewOptions.getIntLightAmbientLightColor();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = intLightViewOptions.getIntLightContourLightColor();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = intLightViewOptions.getIntLightRGBColorList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = intLightViewOptions.getIntLightFollowUpTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
            CarViewOption carViewOption28 = intLightViewOptions.getIntLightSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption28);
            IntLightConfig intLightConfig = intLightViewOptions.getIntLightConfig();
            IntLightConfigSerializer.putOptionalIntLightConfig(iSerializer, intLightConfig);
            CarViewOption carViewOption29 = intLightViewOptions.getIntLightDoorContact();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption29);
        }
    }

    public static void putOptionalIntLightViewOptionsVarArray(ISerializer iSerializer, IntLightViewOptions[] intLightViewOptionsArray) {
        boolean bl = intLightViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightViewOptionsArray.length);
            for (int i2 = 0; i2 < intLightViewOptionsArray.length; ++i2) {
                IntLightViewOptionsSerializer.putOptionalIntLightViewOptions(iSerializer, intLightViewOptionsArray[i2]);
            }
        }
    }

    public static IntLightViewOptions getOptionalIntLightViewOptions(IDeserializer iDeserializer) {
        IntLightViewOptions intLightViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            IntLightConfig intLightConfig;
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
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            CarViewOption carViewOption21;
            CarViewOption carViewOption22;
            CarViewOption carViewOption23;
            CarViewOption carViewOption24;
            CarViewOption carViewOption25;
            CarViewOption carViewOption26;
            CarViewOption carViewOption27;
            CarViewOption carViewOption28;
            CarViewOption carViewOption29;
            intLightViewOptions = new IntLightViewOptions();
            intLightViewOptions.intLightState = carViewOption29 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightColour = carViewOption28 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightEnvironment = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightTemperature = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightSpeed = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightBrightness = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet1 = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet2 = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet3 = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet4 = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet5 = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet6 = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet7 = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationSet8 = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile1 = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile2 = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile3 = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile4 = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile5 = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile6 = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile7 = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightIlluminationProfile8 = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightActiveProfile = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightAmbientLightColor = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightContourLightColor = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightRGBColorList = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightFollowUpTime = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightSetFactoryDefault = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            intLightViewOptions.intLightConfig = intLightConfig = IntLightConfigSerializer.getOptionalIntLightConfig(iDeserializer);
            intLightViewOptions.intLightDoorContact = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return intLightViewOptions;
    }

    public static IntLightViewOptions[] getOptionalIntLightViewOptionsVarArray(IDeserializer iDeserializer) {
        IntLightViewOptions[] intLightViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightViewOptionsArray = new IntLightViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightViewOptionsArray[i2] = IntLightViewOptionsSerializer.getOptionalIntLightViewOptions(iDeserializer);
            }
        }
        return intLightViewOptionsArray;
    }
}

