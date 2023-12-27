/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconMasterConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconSteeringWheelHeaterViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconMasterConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeaterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AirconMasterViewOptionsSerializer {
    public static void putOptionalAirconMasterViewOptions(ISerializer iSerializer, AirconMasterViewOptions airconMasterViewOptions) {
        boolean bl = airconMasterViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = airconMasterViewOptions.getAirconSetFactoryDefaultMaster();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = airconMasterViewOptions.getAirconAC();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = airconMasterViewOptions.getAirconMaxAC();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = airconMasterViewOptions.getAirconEcoAC();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = airconMasterViewOptions.getAirconAirCirculationMan();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = airconMasterViewOptions.getAirconAirCirculationAuto();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = airconMasterViewOptions.getAirconAirCirculationSensitivity();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = airconMasterViewOptions.getAirconSolar();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = airconMasterViewOptions.getAirconMiddleExhaust();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = airconMasterViewOptions.getAirconIndirectVentilation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = airconMasterViewOptions.getAirconSynchronisation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = airconMasterViewOptions.getAirconFrontWindowHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = airconMasterViewOptions.getAirconFrontWindowHeaterAuto();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = airconMasterViewOptions.getAirconRearWindowHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            AirconSteeringWheelHeaterViewOptions airconSteeringWheelHeaterViewOptions = airconMasterViewOptions.getAirconSteeringWheelHeaterViewOptions();
            AirconSteeringWheelHeaterViewOptionsSerializer.putOptionalAirconSteeringWheelHeaterViewOptions(iSerializer, airconSteeringWheelHeaterViewOptions);
            CarViewOption carViewOption15 = airconMasterViewOptions.getAirconPopupTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = airconMasterViewOptions.getAirconSuppressVisualisation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = airconMasterViewOptions.getAirconHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = airconMasterViewOptions.getAirconQuickHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = airconMasterViewOptions.getAirconRearAuxHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = airconMasterViewOptions.getAirconResidualHeat();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = airconMasterViewOptions.getAirconDefrost();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = airconMasterViewOptions.getAirconMaxDefrost();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = airconMasterViewOptions.getAirconSideWindowDefrost();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = airconMasterViewOptions.getAirconRearControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = airconMasterViewOptions.getAirconRearControlFondPlus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = airconMasterViewOptions.getAirconSDSAirBlowerCompensation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = airconMasterViewOptions.getAirconTelAirBlowerCompensation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
            CarViewOption carViewOption28 = airconMasterViewOptions.getAirconAirQuality();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption28);
            CarViewOption carViewOption29 = airconMasterViewOptions.getAirconFreshAirConfiguration();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption29);
            CarViewOption carViewOption30 = airconMasterViewOptions.getAirconFreshAirState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption30);
            CarViewOption carViewOption31 = airconMasterViewOptions.getAirconPureAir();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption31);
            AirconMasterConfiguration airconMasterConfiguration = airconMasterViewOptions.getConfiguration();
            AirconMasterConfigurationSerializer.putOptionalAirconMasterConfiguration(iSerializer, airconMasterConfiguration);
        }
    }

    public static void putOptionalAirconMasterViewOptionsVarArray(ISerializer iSerializer, AirconMasterViewOptions[] airconMasterViewOptionsArray) {
        boolean bl = airconMasterViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconMasterViewOptionsArray.length);
            for (int i2 = 0; i2 < airconMasterViewOptionsArray.length; ++i2) {
                AirconMasterViewOptionsSerializer.putOptionalAirconMasterViewOptions(iSerializer, airconMasterViewOptionsArray[i2]);
            }
        }
    }

    public static AirconMasterViewOptions getOptionalAirconMasterViewOptions(IDeserializer iDeserializer) {
        AirconMasterViewOptions airconMasterViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            AirconMasterConfiguration airconMasterConfiguration;
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
            AirconSteeringWheelHeaterViewOptions airconSteeringWheelHeaterViewOptions;
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
            CarViewOption carViewOption30;
            CarViewOption carViewOption31;
            airconMasterViewOptions = new AirconMasterViewOptions();
            airconMasterViewOptions.airconSetFactoryDefaultMaster = carViewOption31 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconAC = carViewOption30 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconMaxAC = carViewOption29 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconEcoAC = carViewOption28 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconAirCirculationMan = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconAirCirculationAuto = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconAirCirculationSensitivity = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconSolar = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconMiddleExhaust = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconIndirectVentilation = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconSynchronisation = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconFrontWindowHeater = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconFrontWindowHeaterAuto = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconRearWindowHeater = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconSteeringWheelHeaterViewOptions = airconSteeringWheelHeaterViewOptions = AirconSteeringWheelHeaterViewOptionsSerializer.getOptionalAirconSteeringWheelHeaterViewOptions(iDeserializer);
            airconMasterViewOptions.airconPopupTime = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconSuppressVisualisation = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconHeater = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconQuickHeater = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconRearAuxHeater = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconResidualHeat = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconDefrost = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconMaxDefrost = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconSideWindowDefrost = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconRearControl = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconRearControlFondPlus = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconSDSAirBlowerCompensation = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconTelAirBlowerCompensation = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconAirQuality = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconFreshAirConfiguration = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconFreshAirState = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.airconPureAir = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconMasterViewOptions.configuration = airconMasterConfiguration = AirconMasterConfigurationSerializer.getOptionalAirconMasterConfiguration(iDeserializer);
        }
        return airconMasterViewOptions;
    }

    public static AirconMasterViewOptions[] getOptionalAirconMasterViewOptionsVarArray(IDeserializer iDeserializer) {
        AirconMasterViewOptions[] airconMasterViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconMasterViewOptionsArray = new AirconMasterViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconMasterViewOptionsArray[i2] = AirconMasterViewOptionsSerializer.getOptionalAirconMasterViewOptions(iDeserializer);
            }
        }
        return airconMasterViewOptionsArray;
    }
}

