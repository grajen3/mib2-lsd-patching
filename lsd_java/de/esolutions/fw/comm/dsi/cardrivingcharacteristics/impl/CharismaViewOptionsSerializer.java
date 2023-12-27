/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class CharismaViewOptionsSerializer {
    public static void putOptionalCharismaViewOptions(ISerializer iSerializer, CharismaViewOptions charismaViewOptions) {
        boolean bl = charismaViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = charismaViewOptions.getActiveProfile();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = charismaViewOptions.getTrailerMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = charismaViewOptions.getProgButton();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = charismaViewOptions.getProfileComfort();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = charismaViewOptions.getProfileAutoNormal();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = charismaViewOptions.getProfileDynamic();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = charismaViewOptions.getProfileOffroadAllroad();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = charismaViewOptions.getProfileEfficiency();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = charismaViewOptions.getProfileRaceSport();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = charismaViewOptions.getProfileIndividual();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = charismaViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = charismaViewOptions.getCharismaList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CharismaConfiguration charismaConfiguration = charismaViewOptions.getConfiguration();
            CharismaConfigurationSerializer.putOptionalCharismaConfiguration(iSerializer, charismaConfiguration);
            CarViewOption carViewOption13 = charismaViewOptions.getProfileRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = charismaViewOptions.getProfileLift();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = charismaViewOptions.getActiveOperationMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = charismaViewOptions.getEvMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = charismaViewOptions.getHybridMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = charismaViewOptions.getSustainingMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = charismaViewOptions.getChargingMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = charismaViewOptions.getSocControlMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = charismaViewOptions.getProfileOffroadLevel2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = charismaViewOptions.getProfileOffroadLevel3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = charismaViewOptions.getProfileOffroadLevel4();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = charismaViewOptions.getHybridSportMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = charismaViewOptions.getSound();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
        }
    }

    public static void putOptionalCharismaViewOptionsVarArray(ISerializer iSerializer, CharismaViewOptions[] charismaViewOptionsArray) {
        boolean bl = charismaViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaViewOptionsArray.length);
            for (int i2 = 0; i2 < charismaViewOptionsArray.length; ++i2) {
                CharismaViewOptionsSerializer.putOptionalCharismaViewOptions(iSerializer, charismaViewOptionsArray[i2]);
            }
        }
    }

    public static CharismaViewOptions getOptionalCharismaViewOptions(IDeserializer iDeserializer) {
        CharismaViewOptions charismaViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
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
            CharismaConfiguration charismaConfiguration;
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
            charismaViewOptions = new CharismaViewOptions();
            charismaViewOptions.activeProfile = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.trailerMode = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.progButton = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileComfort = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileAutoNormal = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileDynamic = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileOffroadAllroad = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileEfficiency = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileRaceSport = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileIndividual = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.setFactoryDefault = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.charismaList = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.configuration = charismaConfiguration = CharismaConfigurationSerializer.getOptionalCharismaConfiguration(iDeserializer);
            charismaViewOptions.profileRange = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileLift = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.activeOperationMode = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.evMode = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.hybridMode = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.sustainingMode = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.chargingMode = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.socControlMode = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileOffroadLevel2 = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileOffroadLevel3 = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.profileOffroadLevel4 = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.hybridSportMode = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            charismaViewOptions.sound = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return charismaViewOptions;
    }

    public static CharismaViewOptions[] getOptionalCharismaViewOptionsVarArray(IDeserializer iDeserializer) {
        CharismaViewOptions[] charismaViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaViewOptionsArray = new CharismaViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaViewOptionsArray[i2] = CharismaViewOptionsSerializer.getOptionalCharismaViewOptions(iDeserializer);
            }
        }
        return charismaViewOptionsArray;
    }
}

