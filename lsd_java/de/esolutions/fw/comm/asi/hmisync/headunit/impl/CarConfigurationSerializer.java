/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class CarConfigurationSerializer {
    public static void putOptionalCarConfiguration(ISerializer iSerializer, CarConfiguration carConfiguration) {
        boolean bl = carConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = carConfiguration.getVersion();
            iSerializer.putInt8(by);
            byte by2 = carConfiguration.getCarBrand();
            iSerializer.putInt8(by2);
            byte by3 = carConfiguration.getCarClass();
            iSerializer.putInt8(by3);
            byte by4 = carConfiguration.getCarGeneration();
            iSerializer.putInt8(by4);
            byte by5 = carConfiguration.getCarDerivate();
            iSerializer.putInt8(by5);
            byte by6 = carConfiguration.getCarDerivateSupplement();
            iSerializer.putInt8(by6);
        }
    }

    public static void putOptionalCarConfigurationVarArray(ISerializer iSerializer, CarConfiguration[] carConfigurationArray) {
        boolean bl = carConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carConfigurationArray.length);
            for (int i2 = 0; i2 < carConfigurationArray.length; ++i2) {
                CarConfigurationSerializer.putOptionalCarConfiguration(iSerializer, carConfigurationArray[i2]);
            }
        }
    }

    public static CarConfiguration getOptionalCarConfiguration(IDeserializer iDeserializer) {
        CarConfiguration carConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            byte by4;
            byte by5;
            byte by6;
            carConfiguration = new CarConfiguration();
            carConfiguration.version = by6 = iDeserializer.getInt8();
            carConfiguration.carBrand = by5 = iDeserializer.getInt8();
            carConfiguration.carClass = by4 = iDeserializer.getInt8();
            carConfiguration.carGeneration = by3 = iDeserializer.getInt8();
            carConfiguration.carDerivate = by2 = iDeserializer.getInt8();
            carConfiguration.carDerivateSupplement = by = iDeserializer.getInt8();
        }
        return carConfiguration;
    }

    public static CarConfiguration[] getOptionalCarConfigurationVarArray(IDeserializer iDeserializer) {
        CarConfiguration[] carConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carConfigurationArray = new CarConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carConfigurationArray[i2] = CarConfigurationSerializer.getOptionalCarConfiguration(iDeserializer);
            }
        }
        return carConfigurationArray;
    }
}

