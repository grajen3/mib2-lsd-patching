/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class PAViewOptionsSerializer {
    public static void putOptionalPAViewOptions(ISerializer iSerializer, PAViewOptions pAViewOptions) {
        boolean bl = pAViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = pAViewOptions.getPaSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = pAViewOptions.getPaSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = pAViewOptions.getPaConfigInformation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = pAViewOptions.getPaConfigWarning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = pAViewOptions.getPaWarningTimegap();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
        }
    }

    public static void putOptionalPAViewOptionsVarArray(ISerializer iSerializer, PAViewOptions[] pAViewOptionsArray) {
        boolean bl = pAViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pAViewOptionsArray.length);
            for (int i2 = 0; i2 < pAViewOptionsArray.length; ++i2) {
                PAViewOptionsSerializer.putOptionalPAViewOptions(iSerializer, pAViewOptionsArray[i2]);
            }
        }
    }

    public static PAViewOptions getOptionalPAViewOptions(IDeserializer iDeserializer) {
        PAViewOptions pAViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            pAViewOptions = new PAViewOptions();
            pAViewOptions.paSystemOnOff = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            pAViewOptions.paSetFactoryDefault = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            pAViewOptions.paConfigInformation = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            pAViewOptions.paConfigWarning = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            pAViewOptions.paWarningTimegap = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return pAViewOptions;
    }

    public static PAViewOptions[] getOptionalPAViewOptionsVarArray(IDeserializer iDeserializer) {
        PAViewOptions[] pAViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pAViewOptionsArray = new PAViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pAViewOptionsArray[i2] = PAViewOptionsSerializer.getOptionalPAViewOptions(iDeserializer);
            }
        }
        return pAViewOptionsArray;
    }
}

