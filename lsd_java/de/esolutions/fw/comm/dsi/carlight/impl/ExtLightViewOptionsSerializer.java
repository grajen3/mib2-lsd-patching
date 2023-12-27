/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.dsi.carlight.impl.ExtLightConfigSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.ExtLightConfig;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ExtLightViewOptionsSerializer {
    public static void putOptionalExtLightViewOptions(ISerializer iSerializer, ExtLightViewOptions extLightViewOptions) {
        boolean bl = extLightViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = extLightViewOptions.getComingHome();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = extLightViewOptions.getLeavingHome();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = extLightViewOptions.getSwitchOnSensitivity();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = extLightViewOptions.getDayLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = extLightViewOptions.getTouristLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = extLightViewOptions.getMotorwayBlinking();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = extLightViewOptions.getAdaptiveLightSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = extLightViewOptions.getHeadlightSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = extLightViewOptions.getGlidingLightSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = extLightViewOptions.getMaskedHighBeam();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            ExtLightConfig extLightConfig = extLightViewOptions.getExtLightConfig();
            ExtLightConfigSerializer.putOptionalExtLightConfig(iSerializer, extLightConfig);
            CarViewOption carViewOption11 = extLightViewOptions.getAutomaticLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = extLightViewOptions.getExtLightSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = extLightViewOptions.getLaserLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = extLightViewOptions.getSignatureLight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = extLightViewOptions.getHeadlightRange();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
        }
    }

    public static void putOptionalExtLightViewOptionsVarArray(ISerializer iSerializer, ExtLightViewOptions[] extLightViewOptionsArray) {
        boolean bl = extLightViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extLightViewOptionsArray.length);
            for (int i2 = 0; i2 < extLightViewOptionsArray.length; ++i2) {
                ExtLightViewOptionsSerializer.putOptionalExtLightViewOptions(iSerializer, extLightViewOptionsArray[i2]);
            }
        }
    }

    public static ExtLightViewOptions getOptionalExtLightViewOptions(IDeserializer iDeserializer) {
        ExtLightViewOptions extLightViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            ExtLightConfig extLightConfig;
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
            extLightViewOptions = new ExtLightViewOptions();
            extLightViewOptions.comingHome = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.leavingHome = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.switchOnSensitivity = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.dayLight = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.touristLight = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.motorwayBlinking = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.adaptiveLightSystem = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.headlightSystem = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.glidingLightSystem = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.maskedHighBeam = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.extLightConfig = extLightConfig = ExtLightConfigSerializer.getOptionalExtLightConfig(iDeserializer);
            extLightViewOptions.automaticLight = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.extLightSetFactoryDefault = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.laserLight = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.signatureLight = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            extLightViewOptions.headlightRange = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return extLightViewOptions;
    }

    public static ExtLightViewOptions[] getOptionalExtLightViewOptionsVarArray(IDeserializer iDeserializer) {
        ExtLightViewOptions[] extLightViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extLightViewOptionsArray = new ExtLightViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extLightViewOptionsArray[i2] = ExtLightViewOptionsSerializer.getOptionalExtLightViewOptions(iDeserializer);
            }
        }
        return extLightViewOptionsArray;
    }
}

