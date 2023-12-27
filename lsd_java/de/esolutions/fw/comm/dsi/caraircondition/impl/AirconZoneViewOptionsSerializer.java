/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AirconZoneViewOptionsSerializer {
    public static void putOptionalAirconZoneViewOptions(ISerializer iSerializer, AirconZoneViewOptions airconZoneViewOptions) {
        boolean bl = airconZoneViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = airconZoneViewOptions.getAirconTemp();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = airconZoneViewOptions.getAirconAirVolume();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = airconZoneViewOptions.getAirconAirDistribution();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = airconZoneViewOptions.getAirconFootwellTemp();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = airconZoneViewOptions.getAirconSeatHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = airconZoneViewOptions.getAirconSeatVentilation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = airconZoneViewOptions.getAirconSeatHeaterDistribution();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = airconZoneViewOptions.getAirconSeatVentilationDistribution();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = airconZoneViewOptions.getAirconTempStep();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = airconZoneViewOptions.getAirconAirVolumeRegulated();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = airconZoneViewOptions.getAirconNeckHeater();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = airconZoneViewOptions.getAirconSurfaceHeaterState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = airconZoneViewOptions.getAirconSurfaceHeaterLink();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = airconZoneViewOptions.getAirconSurfaceHeaterHeaterLevel();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = airconZoneViewOptions.getAirconIndividualClimatisation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = airconZoneViewOptions.getAirconIonisator();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = airconZoneViewOptions.getAirconBodyCloseMeasures();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = airconZoneViewOptions.getAirconClimateStyle();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = airconZoneViewOptions.getAirconClimateState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
        }
    }

    public static void putOptionalAirconZoneViewOptionsVarArray(ISerializer iSerializer, AirconZoneViewOptions[] airconZoneViewOptionsArray) {
        boolean bl = airconZoneViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconZoneViewOptionsArray.length);
            for (int i2 = 0; i2 < airconZoneViewOptionsArray.length; ++i2) {
                AirconZoneViewOptionsSerializer.putOptionalAirconZoneViewOptions(iSerializer, airconZoneViewOptionsArray[i2]);
            }
        }
    }

    public static AirconZoneViewOptions getOptionalAirconZoneViewOptions(IDeserializer iDeserializer) {
        AirconZoneViewOptions airconZoneViewOptions = null;
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
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            airconZoneViewOptions = new AirconZoneViewOptions();
            airconZoneViewOptions.airconTemp = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconAirVolume = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconAirDistribution = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconFootwellTemp = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSeatHeater = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSeatVentilation = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSeatHeaterDistribution = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSeatVentilationDistribution = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconTempStep = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconAirVolumeRegulated = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconNeckHeater = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSurfaceHeaterState = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSurfaceHeaterLink = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconSurfaceHeaterHeaterLevel = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconIndividualClimatisation = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconIonisator = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconBodyCloseMeasures = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconClimateStyle = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconZoneViewOptions.airconClimateState = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return airconZoneViewOptions;
    }

    public static AirconZoneViewOptions[] getOptionalAirconZoneViewOptionsVarArray(IDeserializer iDeserializer) {
        AirconZoneViewOptions[] airconZoneViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconZoneViewOptionsArray = new AirconZoneViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconZoneViewOptionsArray[i2] = AirconZoneViewOptionsSerializer.getOptionalAirconZoneViewOptions(iDeserializer);
            }
        }
        return airconZoneViewOptionsArray;
    }
}

