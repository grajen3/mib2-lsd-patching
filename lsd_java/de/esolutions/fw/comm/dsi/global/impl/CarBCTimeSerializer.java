/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCTime;

public class CarBCTimeSerializer {
    public static void putOptionalCarBCTime(ISerializer iSerializer, CarBCTime carBCTime) {
        boolean bl = carBCTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCTime.getState();
            iSerializer.putInt32(n);
            int n2 = carBCTime.getTimeValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarBCTimeVarArray(ISerializer iSerializer, CarBCTime[] carBCTimeArray) {
        boolean bl = carBCTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCTimeArray.length);
            for (int i2 = 0; i2 < carBCTimeArray.length; ++i2) {
                CarBCTimeSerializer.putOptionalCarBCTime(iSerializer, carBCTimeArray[i2]);
            }
        }
    }

    public static CarBCTime getOptionalCarBCTime(IDeserializer iDeserializer) {
        CarBCTime carBCTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            carBCTime = new CarBCTime();
            carBCTime.state = n2 = iDeserializer.getInt32();
            carBCTime.timeValue = n = iDeserializer.getInt32();
        }
        return carBCTime;
    }

    public static CarBCTime[] getOptionalCarBCTimeVarArray(IDeserializer iDeserializer) {
        CarBCTime[] carBCTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCTimeArray = new CarBCTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCTimeArray[i2] = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
            }
        }
        return carBCTimeArray;
    }
}

