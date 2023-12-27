/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.CarFunction;

public class CarFunctionSerializer {
    public static void putOptionalCarFunction(ISerializer iSerializer, CarFunction carFunction) {
        boolean bl = carFunction == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carFunction.getId();
            iSerializer.putInt32(n);
            boolean bl2 = carFunction.isEnabled();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalCarFunctionVarArray(ISerializer iSerializer, CarFunction[] carFunctionArray) {
        boolean bl = carFunctionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carFunctionArray.length);
            for (int i2 = 0; i2 < carFunctionArray.length; ++i2) {
                CarFunctionSerializer.putOptionalCarFunction(iSerializer, carFunctionArray[i2]);
            }
        }
    }

    public static CarFunction getOptionalCarFunction(IDeserializer iDeserializer) {
        CarFunction carFunction = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            carFunction = new CarFunction();
            carFunction.id = n = iDeserializer.getInt32();
            carFunction.enabled = bl2 = iDeserializer.getBool();
        }
        return carFunction;
    }

    public static CarFunction[] getOptionalCarFunctionVarArray(IDeserializer iDeserializer) {
        CarFunction[] carFunctionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carFunctionArray = new CarFunction[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carFunctionArray[i2] = CarFunctionSerializer.getOptionalCarFunction(iDeserializer);
            }
        }
        return carFunctionArray;
    }
}

