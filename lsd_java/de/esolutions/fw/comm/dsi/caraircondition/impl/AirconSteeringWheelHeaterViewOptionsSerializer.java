/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeaterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AirconSteeringWheelHeaterViewOptionsSerializer {
    public static void putOptionalAirconSteeringWheelHeaterViewOptions(ISerializer iSerializer, AirconSteeringWheelHeaterViewOptions airconSteeringWheelHeaterViewOptions) {
        boolean bl = airconSteeringWheelHeaterViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = airconSteeringWheelHeaterViewOptions.getHeating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = airconSteeringWheelHeaterViewOptions.getAutoHeating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = airconSteeringWheelHeaterViewOptions.getHeatingStep();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = airconSteeringWheelHeaterViewOptions.getAdjustViaSeatHeating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = airconSteeringWheelHeaterViewOptions.getCurrentState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
        }
    }

    public static void putOptionalAirconSteeringWheelHeaterViewOptionsVarArray(ISerializer iSerializer, AirconSteeringWheelHeaterViewOptions[] airconSteeringWheelHeaterViewOptionsArray) {
        boolean bl = airconSteeringWheelHeaterViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconSteeringWheelHeaterViewOptionsArray.length);
            for (int i2 = 0; i2 < airconSteeringWheelHeaterViewOptionsArray.length; ++i2) {
                AirconSteeringWheelHeaterViewOptionsSerializer.putOptionalAirconSteeringWheelHeaterViewOptions(iSerializer, airconSteeringWheelHeaterViewOptionsArray[i2]);
            }
        }
    }

    public static AirconSteeringWheelHeaterViewOptions getOptionalAirconSteeringWheelHeaterViewOptions(IDeserializer iDeserializer) {
        AirconSteeringWheelHeaterViewOptions airconSteeringWheelHeaterViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            airconSteeringWheelHeaterViewOptions = new AirconSteeringWheelHeaterViewOptions();
            airconSteeringWheelHeaterViewOptions.heating = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconSteeringWheelHeaterViewOptions.autoHeating = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconSteeringWheelHeaterViewOptions.heatingStep = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconSteeringWheelHeaterViewOptions.adjustViaSeatHeating = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconSteeringWheelHeaterViewOptions.currentState = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return airconSteeringWheelHeaterViewOptions;
    }

    public static AirconSteeringWheelHeaterViewOptions[] getOptionalAirconSteeringWheelHeaterViewOptionsVarArray(IDeserializer iDeserializer) {
        AirconSteeringWheelHeaterViewOptions[] airconSteeringWheelHeaterViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconSteeringWheelHeaterViewOptionsArray = new AirconSteeringWheelHeaterViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconSteeringWheelHeaterViewOptionsArray[i2] = AirconSteeringWheelHeaterViewOptionsSerializer.getOptionalAirconSteeringWheelHeaterViewOptions(iDeserializer);
            }
        }
        return airconSteeringWheelHeaterViewOptionsArray;
    }
}

