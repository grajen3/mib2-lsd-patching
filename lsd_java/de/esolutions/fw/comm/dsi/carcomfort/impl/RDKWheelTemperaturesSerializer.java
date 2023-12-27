/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;

public class RDKWheelTemperaturesSerializer {
    public static void putOptionalRDKWheelTemperatures(ISerializer iSerializer, RDKWheelTemperatures rDKWheelTemperatures) {
        boolean bl = rDKWheelTemperatures == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKWheelTemperatures.getTemperatureUnit();
            iSerializer.putInt32(n);
            int n2 = rDKWheelTemperatures.getFrontLeft();
            iSerializer.putInt32(n2);
            int n3 = rDKWheelTemperatures.getFrontRight();
            iSerializer.putInt32(n3);
            int n4 = rDKWheelTemperatures.getRearLeft();
            iSerializer.putInt32(n4);
            int n5 = rDKWheelTemperatures.getRearRight();
            iSerializer.putInt32(n5);
            int n6 = rDKWheelTemperatures.getSpareWheel();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalRDKWheelTemperaturesVarArray(ISerializer iSerializer, RDKWheelTemperatures[] rDKWheelTemperaturesArray) {
        boolean bl = rDKWheelTemperaturesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKWheelTemperaturesArray.length);
            for (int i2 = 0; i2 < rDKWheelTemperaturesArray.length; ++i2) {
                RDKWheelTemperaturesSerializer.putOptionalRDKWheelTemperatures(iSerializer, rDKWheelTemperaturesArray[i2]);
            }
        }
    }

    public static RDKWheelTemperatures getOptionalRDKWheelTemperatures(IDeserializer iDeserializer) {
        RDKWheelTemperatures rDKWheelTemperatures = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            rDKWheelTemperatures = new RDKWheelTemperatures();
            rDKWheelTemperatures.temperatureUnit = n6 = iDeserializer.getInt32();
            rDKWheelTemperatures.frontLeft = n5 = iDeserializer.getInt32();
            rDKWheelTemperatures.frontRight = n4 = iDeserializer.getInt32();
            rDKWheelTemperatures.rearLeft = n3 = iDeserializer.getInt32();
            rDKWheelTemperatures.rearRight = n2 = iDeserializer.getInt32();
            rDKWheelTemperatures.spareWheel = n = iDeserializer.getInt32();
        }
        return rDKWheelTemperatures;
    }

    public static RDKWheelTemperatures[] getOptionalRDKWheelTemperaturesVarArray(IDeserializer iDeserializer) {
        RDKWheelTemperatures[] rDKWheelTemperaturesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKWheelTemperaturesArray = new RDKWheelTemperatures[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKWheelTemperaturesArray[i2] = RDKWheelTemperaturesSerializer.getOptionalRDKWheelTemperatures(iDeserializer);
            }
        }
        return rDKWheelTemperaturesArray;
    }
}

