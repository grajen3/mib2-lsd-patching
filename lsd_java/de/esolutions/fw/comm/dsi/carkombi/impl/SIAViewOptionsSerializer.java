/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.SIAConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAConfiguration;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SIAViewOptionsSerializer {
    public static void putOptionalSIAViewOptions(ISerializer iSerializer, SIAViewOptions sIAViewOptions) {
        boolean bl = sIAViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = sIAViewOptions.getOilInspection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = sIAViewOptions.getServiceData();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = sIAViewOptions.getReset();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = sIAViewOptions.getHistoryList();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = sIAViewOptions.getDistanceOilUser();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = sIAViewOptions.getDistanceAirFilterUser();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = sIAViewOptions.getDistanceOilFilterUser();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = sIAViewOptions.getInspectionDistanceUser();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = sIAViewOptions.getDailyAverageMileage();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            SIAConfiguration sIAConfiguration = sIAViewOptions.getConfiguration();
            SIAConfigurationSerializer.putOptionalSIAConfiguration(iSerializer, sIAConfiguration);
        }
    }

    public static void putOptionalSIAViewOptionsVarArray(ISerializer iSerializer, SIAViewOptions[] sIAViewOptionsArray) {
        boolean bl = sIAViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAViewOptionsArray.length);
            for (int i2 = 0; i2 < sIAViewOptionsArray.length; ++i2) {
                SIAViewOptionsSerializer.putOptionalSIAViewOptions(iSerializer, sIAViewOptionsArray[i2]);
            }
        }
    }

    public static SIAViewOptions getOptionalSIAViewOptions(IDeserializer iDeserializer) {
        SIAViewOptions sIAViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            SIAConfiguration sIAConfiguration;
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            CarViewOption carViewOption9;
            sIAViewOptions = new SIAViewOptions();
            sIAViewOptions.oilInspection = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.serviceData = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.reset = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.historyList = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.distanceOilUser = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.distanceAirFilterUser = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.distanceOilFilterUser = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.inspectionDistanceUser = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.dailyAverageMileage = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            sIAViewOptions.configuration = sIAConfiguration = SIAConfigurationSerializer.getOptionalSIAConfiguration(iDeserializer);
        }
        return sIAViewOptions;
    }

    public static SIAViewOptions[] getOptionalSIAViewOptionsVarArray(IDeserializer iDeserializer) {
        SIAViewOptions[] sIAViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAViewOptionsArray = new SIAViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAViewOptionsArray[i2] = SIAViewOptionsSerializer.getOptionalSIAViewOptions(iDeserializer);
            }
        }
        return sIAViewOptionsArray;
    }
}

