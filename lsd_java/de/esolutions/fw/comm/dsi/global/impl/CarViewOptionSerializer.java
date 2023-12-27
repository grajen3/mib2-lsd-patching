/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarViewOption;

public class CarViewOptionSerializer {
    public static void putOptionalCarViewOption(ISerializer iSerializer, CarViewOption carViewOption) {
        boolean bl = carViewOption == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carViewOption.getState();
            iSerializer.putInt32(n);
            int n2 = carViewOption.getReason();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarViewOptionVarArray(ISerializer iSerializer, CarViewOption[] carViewOptionArray) {
        boolean bl = carViewOptionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carViewOptionArray.length);
            for (int i2 = 0; i2 < carViewOptionArray.length; ++i2) {
                CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOptionArray[i2]);
            }
        }
    }

    public static CarViewOption getOptionalCarViewOption(IDeserializer iDeserializer) {
        CarViewOption carViewOption = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            carViewOption = new CarViewOption();
            carViewOption.state = n2 = iDeserializer.getInt32();
            carViewOption.reason = n = iDeserializer.getInt32();
        }
        return carViewOption;
    }

    public static CarViewOption[] getOptionalCarViewOptionVarArray(IDeserializer iDeserializer) {
        CarViewOption[] carViewOptionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carViewOptionArray = new CarViewOption[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carViewOptionArray[i2] = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            }
        }
        return carViewOptionArray;
    }
}

