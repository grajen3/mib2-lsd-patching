/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconRowConfigurationSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconZoneViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconRowConfiguration;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AirconRowViewOptionsSerializer {
    public static void putOptionalAirconRowViewOptions(ISerializer iSerializer, AirconRowViewOptions airconRowViewOptions) {
        boolean bl = airconRowViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = airconRowViewOptions.getAirconSystemOnOffRow();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = airconRowViewOptions.getAirconSetFactoryDefaultRow();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = airconRowViewOptions.getAirconNozzleList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = airconRowViewOptions.getAirconNozzleControl();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = airconRowViewOptions.getAirconNozzleStatus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            AirconZoneViewOptions airconZoneViewOptions = airconRowViewOptions.getZoneLeftViewOptions();
            AirconZoneViewOptionsSerializer.putOptionalAirconZoneViewOptions(iSerializer, airconZoneViewOptions);
            AirconZoneViewOptions airconZoneViewOptions2 = airconRowViewOptions.getZoneRightViewOptions();
            AirconZoneViewOptionsSerializer.putOptionalAirconZoneViewOptions(iSerializer, airconZoneViewOptions2);
            AirconRowConfiguration airconRowConfiguration = airconRowViewOptions.getConfiguration();
            AirconRowConfigurationSerializer.putOptionalAirconRowConfiguration(iSerializer, airconRowConfiguration);
        }
    }

    public static void putOptionalAirconRowViewOptionsVarArray(ISerializer iSerializer, AirconRowViewOptions[] airconRowViewOptionsArray) {
        boolean bl = airconRowViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconRowViewOptionsArray.length);
            for (int i2 = 0; i2 < airconRowViewOptionsArray.length; ++i2) {
                AirconRowViewOptionsSerializer.putOptionalAirconRowViewOptions(iSerializer, airconRowViewOptionsArray[i2]);
            }
        }
    }

    public static AirconRowViewOptions getOptionalAirconRowViewOptions(IDeserializer iDeserializer) {
        AirconRowViewOptions airconRowViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            AirconRowConfiguration airconRowConfiguration;
            AirconZoneViewOptions airconZoneViewOptions;
            AirconZoneViewOptions airconZoneViewOptions2;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            airconRowViewOptions = new AirconRowViewOptions();
            airconRowViewOptions.airconSystemOnOffRow = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconRowViewOptions.airconSetFactoryDefaultRow = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconRowViewOptions.airconNozzleList = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconRowViewOptions.airconNozzleControl = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconRowViewOptions.airconNozzleStatus = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            airconRowViewOptions.zoneLeftViewOptions = airconZoneViewOptions2 = AirconZoneViewOptionsSerializer.getOptionalAirconZoneViewOptions(iDeserializer);
            airconRowViewOptions.zoneRightViewOptions = airconZoneViewOptions = AirconZoneViewOptionsSerializer.getOptionalAirconZoneViewOptions(iDeserializer);
            airconRowViewOptions.configuration = airconRowConfiguration = AirconRowConfigurationSerializer.getOptionalAirconRowConfiguration(iDeserializer);
        }
        return airconRowViewOptions;
    }

    public static AirconRowViewOptions[] getOptionalAirconRowViewOptionsVarArray(IDeserializer iDeserializer) {
        AirconRowViewOptions[] airconRowViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconRowViewOptionsArray = new AirconRowViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconRowViewOptionsArray[i2] = AirconRowViewOptionsSerializer.getOptionalAirconRowViewOptions(iDeserializer);
            }
        }
        return airconRowViewOptionsArray;
    }
}

