/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCConsumption;

public class CarBCConsumptionSerializer {
    public static void putOptionalCarBCConsumption(ISerializer iSerializer, CarBCConsumption carBCConsumption) {
        boolean bl = carBCConsumption == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCConsumption.getState();
            iSerializer.putInt32(n);
            float f2 = carBCConsumption.getConsumptionValue();
            iSerializer.putFloat(f2);
            int n2 = carBCConsumption.getConsumptionUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalCarBCConsumptionVarArray(ISerializer iSerializer, CarBCConsumption[] carBCConsumptionArray) {
        boolean bl = carBCConsumptionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCConsumptionArray.length);
            for (int i2 = 0; i2 < carBCConsumptionArray.length; ++i2) {
                CarBCConsumptionSerializer.putOptionalCarBCConsumption(iSerializer, carBCConsumptionArray[i2]);
            }
        }
    }

    public static CarBCConsumption getOptionalCarBCConsumption(IDeserializer iDeserializer) {
        CarBCConsumption carBCConsumption = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            int n2;
            carBCConsumption = new CarBCConsumption();
            carBCConsumption.state = n2 = iDeserializer.getInt32();
            carBCConsumption.consumptionValue = f2 = iDeserializer.getFloat();
            carBCConsumption.consumptionUnit = n = iDeserializer.getInt32();
        }
        return carBCConsumption;
    }

    public static CarBCConsumption[] getOptionalCarBCConsumptionVarArray(IDeserializer iDeserializer) {
        CarBCConsumption[] carBCConsumptionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCConsumptionArray = new CarBCConsumption[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCConsumptionArray[i2] = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
            }
        }
        return carBCConsumptionArray;
    }
}

