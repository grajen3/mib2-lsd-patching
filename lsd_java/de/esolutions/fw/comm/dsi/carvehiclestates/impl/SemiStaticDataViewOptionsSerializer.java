/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class SemiStaticDataViewOptionsSerializer {
    public static void putOptionalSemiStaticDataViewOptions(ISerializer iSerializer, SemiStaticDataViewOptions semiStaticDataViewOptions) {
        boolean bl = semiStaticDataViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = semiStaticDataViewOptions.getMaxChargingAirPressure();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = semiStaticDataViewOptions.getMaxOutputPower();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = semiStaticDataViewOptions.getMaxTorque();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = semiStaticDataViewOptions.getEngineDisplacement();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = semiStaticDataViewOptions.getTypeOfInjectionSystem();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
        }
    }

    public static void putOptionalSemiStaticDataViewOptionsVarArray(ISerializer iSerializer, SemiStaticDataViewOptions[] semiStaticDataViewOptionsArray) {
        boolean bl = semiStaticDataViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(semiStaticDataViewOptionsArray.length);
            for (int i2 = 0; i2 < semiStaticDataViewOptionsArray.length; ++i2) {
                SemiStaticDataViewOptionsSerializer.putOptionalSemiStaticDataViewOptions(iSerializer, semiStaticDataViewOptionsArray[i2]);
            }
        }
    }

    public static SemiStaticDataViewOptions getOptionalSemiStaticDataViewOptions(IDeserializer iDeserializer) {
        SemiStaticDataViewOptions semiStaticDataViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            semiStaticDataViewOptions = new SemiStaticDataViewOptions();
            semiStaticDataViewOptions.maxChargingAirPressure = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            semiStaticDataViewOptions.maxOutputPower = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            semiStaticDataViewOptions.maxTorque = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            semiStaticDataViewOptions.engineDisplacement = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            semiStaticDataViewOptions.typeOfInjectionSystem = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return semiStaticDataViewOptions;
    }

    public static SemiStaticDataViewOptions[] getOptionalSemiStaticDataViewOptionsVarArray(IDeserializer iDeserializer) {
        SemiStaticDataViewOptions[] semiStaticDataViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            semiStaticDataViewOptionsArray = new SemiStaticDataViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                semiStaticDataViewOptionsArray[i2] = SemiStaticDataViewOptionsSerializer.getOptionalSemiStaticDataViewOptions(iDeserializer);
            }
        }
        return semiStaticDataViewOptionsArray;
    }
}

