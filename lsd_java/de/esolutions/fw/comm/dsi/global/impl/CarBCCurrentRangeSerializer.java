/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCCurrentRange;

public class CarBCCurrentRangeSerializer {
    public static void putOptionalCarBCCurrentRange(ISerializer iSerializer, CarBCCurrentRange carBCCurrentRange) {
        boolean bl = carBCCurrentRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCCurrentRange.getState();
            iSerializer.putInt32(n);
            int n2 = carBCCurrentRange.getCurrentRangeValue();
            iSerializer.putInt32(n2);
            int n3 = carBCCurrentRange.getCurrentRangeUnit();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalCarBCCurrentRangeVarArray(ISerializer iSerializer, CarBCCurrentRange[] carBCCurrentRangeArray) {
        boolean bl = carBCCurrentRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCCurrentRangeArray.length);
            for (int i2 = 0; i2 < carBCCurrentRangeArray.length; ++i2) {
                CarBCCurrentRangeSerializer.putOptionalCarBCCurrentRange(iSerializer, carBCCurrentRangeArray[i2]);
            }
        }
    }

    public static CarBCCurrentRange getOptionalCarBCCurrentRange(IDeserializer iDeserializer) {
        CarBCCurrentRange carBCCurrentRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            carBCCurrentRange = new CarBCCurrentRange();
            carBCCurrentRange.state = n3 = iDeserializer.getInt32();
            carBCCurrentRange.currentRangeValue = n2 = iDeserializer.getInt32();
            carBCCurrentRange.currentRangeUnit = n = iDeserializer.getInt32();
        }
        return carBCCurrentRange;
    }

    public static CarBCCurrentRange[] getOptionalCarBCCurrentRangeVarArray(IDeserializer iDeserializer) {
        CarBCCurrentRange[] carBCCurrentRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCCurrentRangeArray = new CarBCCurrentRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCCurrentRangeArray[i2] = CarBCCurrentRangeSerializer.getOptionalCarBCCurrentRange(iDeserializer);
            }
        }
        return carBCCurrentRangeArray;
    }
}

