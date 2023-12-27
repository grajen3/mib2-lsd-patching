/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class EAViewOptionsSerializer {
    public static void putOptionalEAViewOptions(ISerializer iSerializer, EAViewOptions eAViewOptions) {
        boolean bl = eAViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = eAViewOptions.getSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = eAViewOptions.getPedalJerk();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = eAViewOptions.getSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = eAViewOptions.getFreeWheeling();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = eAViewOptions.getStartStop();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
        }
    }

    public static void putOptionalEAViewOptionsVarArray(ISerializer iSerializer, EAViewOptions[] eAViewOptionsArray) {
        boolean bl = eAViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(eAViewOptionsArray.length);
            for (int i2 = 0; i2 < eAViewOptionsArray.length; ++i2) {
                EAViewOptionsSerializer.putOptionalEAViewOptions(iSerializer, eAViewOptionsArray[i2]);
            }
        }
    }

    public static EAViewOptions getOptionalEAViewOptions(IDeserializer iDeserializer) {
        EAViewOptions eAViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            eAViewOptions = new EAViewOptions();
            eAViewOptions.system = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            eAViewOptions.pedalJerk = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            eAViewOptions.setFactoryDefault = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            eAViewOptions.freeWheeling = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            eAViewOptions.startStop = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return eAViewOptions;
    }

    public static EAViewOptions[] getOptionalEAViewOptionsVarArray(IDeserializer iDeserializer) {
        EAViewOptions[] eAViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            eAViewOptionsArray = new EAViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                eAViewOptionsArray[i2] = EAViewOptionsSerializer.getOptionalEAViewOptions(iDeserializer);
            }
        }
        return eAViewOptionsArray;
    }
}

