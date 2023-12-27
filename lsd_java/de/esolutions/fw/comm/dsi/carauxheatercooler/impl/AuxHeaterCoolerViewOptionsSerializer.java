/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerConfiguration;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AuxHeaterCoolerViewOptionsSerializer {
    public static void putOptionalAuxHeaterCoolerViewOptions(ISerializer iSerializer, AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        boolean bl = auxHeaterCoolerViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = auxHeaterCoolerViewOptions.getAuxHeaterCoolerState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerRemainingTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerDefaultStartMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerEngineHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimerStatus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer3();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = auxHeaterCoolerViewOptions.getAuxHeaterSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerErrorReason();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerCurrentHeaterState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            int n = auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimerMode();
            iSerializer.putInt32(n);
            CarViewOption carViewOption15 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerPopup();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerExtendedConditioning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerWindowHeating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerUnlockClimating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerTargetTemperature();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = auxHeaterCoolerViewOptions.getAuxHeaterCoolerAirQuality();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            AuxHeaterCoolerConfiguration auxHeaterCoolerConfiguration = auxHeaterCoolerViewOptions.getConfiguration();
            AuxHeaterCoolerConfigurationSerializer.putOptionalAuxHeaterCoolerConfiguration(iSerializer, auxHeaterCoolerConfiguration);
        }
    }

    public static void putOptionalAuxHeaterCoolerViewOptionsVarArray(ISerializer iSerializer, AuxHeaterCoolerViewOptions[] auxHeaterCoolerViewOptionsArray) {
        boolean bl = auxHeaterCoolerViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(auxHeaterCoolerViewOptionsArray.length);
            for (int i2 = 0; i2 < auxHeaterCoolerViewOptionsArray.length; ++i2) {
                AuxHeaterCoolerViewOptionsSerializer.putOptionalAuxHeaterCoolerViewOptions(iSerializer, auxHeaterCoolerViewOptionsArray[i2]);
            }
        }
    }

    public static AuxHeaterCoolerViewOptions getOptionalAuxHeaterCoolerViewOptions(IDeserializer iDeserializer) {
        AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            AuxHeaterCoolerConfiguration auxHeaterCoolerConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            int n;
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
            auxHeaterCoolerViewOptions = new AuxHeaterCoolerViewOptions();
            auxHeaterCoolerViewOptions.auxHeaterCoolerState = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerOnOff = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerRemainingTime = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerRunningTime = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerMode = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerDefaultStartMode = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerEngineHeater = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerTimerStatus = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerTimer1 = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerTimer2 = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerTimer3 = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterSetFactoryDefault = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerErrorReason = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerCurrentHeaterState = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerTimerMode = n = iDeserializer.getInt32();
            auxHeaterCoolerViewOptions.auxHeaterCoolerPopup = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerExtendedConditioning = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerWindowHeating = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerUnlockClimating = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerTargetTemperature = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.auxHeaterCoolerAirQuality = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            auxHeaterCoolerViewOptions.configuration = auxHeaterCoolerConfiguration = AuxHeaterCoolerConfigurationSerializer.getOptionalAuxHeaterCoolerConfiguration(iDeserializer);
        }
        return auxHeaterCoolerViewOptions;
    }

    public static AuxHeaterCoolerViewOptions[] getOptionalAuxHeaterCoolerViewOptionsVarArray(IDeserializer iDeserializer) {
        AuxHeaterCoolerViewOptions[] auxHeaterCoolerViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            auxHeaterCoolerViewOptionsArray = new AuxHeaterCoolerViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                auxHeaterCoolerViewOptionsArray[i2] = AuxHeaterCoolerViewOptionsSerializer.getOptionalAuxHeaterCoolerViewOptions(iDeserializer);
            }
        }
        return auxHeaterCoolerViewOptionsArray;
    }
}

