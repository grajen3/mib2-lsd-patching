/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class LDWHCAViewOptionsSerializer {
    public static void putOptionalLDWHCAViewOptions(ISerializer iSerializer, LDWHCAViewOptions lDWHCAViewOptions) {
        boolean bl = lDWHCAViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = lDWHCAViewOptions.getHCAToleranceLevel();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = lDWHCAViewOptions.getLDWSteeringWheelVibration();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = lDWHCAViewOptions.getHCAInterventionStyle();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = lDWHCAViewOptions.getLDWWarningTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = lDWHCAViewOptions.getLdwhcaSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = lDWHCAViewOptions.getLdwhcaSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = lDWHCAViewOptions.getLdwhcaWarningSound();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
        }
    }

    public static void putOptionalLDWHCAViewOptionsVarArray(ISerializer iSerializer, LDWHCAViewOptions[] lDWHCAViewOptionsArray) {
        boolean bl = lDWHCAViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lDWHCAViewOptionsArray.length);
            for (int i2 = 0; i2 < lDWHCAViewOptionsArray.length; ++i2) {
                LDWHCAViewOptionsSerializer.putOptionalLDWHCAViewOptions(iSerializer, lDWHCAViewOptionsArray[i2]);
            }
        }
    }

    public static LDWHCAViewOptions getOptionalLDWHCAViewOptions(IDeserializer iDeserializer) {
        LDWHCAViewOptions lDWHCAViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            lDWHCAViewOptions = new LDWHCAViewOptions();
            lDWHCAViewOptions.hCAToleranceLevel = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            lDWHCAViewOptions.lDWSteeringWheelVibration = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            lDWHCAViewOptions.hCAInterventionStyle = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            lDWHCAViewOptions.lDWWarningTime = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            lDWHCAViewOptions.ldwhcaSetFactoryDefault = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            lDWHCAViewOptions.ldwhcaSystemOnOff = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            lDWHCAViewOptions.ldwhcaWarningSound = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return lDWHCAViewOptions;
    }

    public static LDWHCAViewOptions[] getOptionalLDWHCAViewOptionsVarArray(IDeserializer iDeserializer) {
        LDWHCAViewOptions[] lDWHCAViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lDWHCAViewOptionsArray = new LDWHCAViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lDWHCAViewOptionsArray[i2] = LDWHCAViewOptionsSerializer.getOptionalLDWHCAViewOptions(iDeserializer);
            }
        }
        return lDWHCAViewOptionsArray;
    }
}

