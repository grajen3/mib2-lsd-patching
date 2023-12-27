/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKWheelPressures;

public class RDKWheelPressuresSerializer {
    public static void putOptionalRDKWheelPressures(ISerializer iSerializer, RDKWheelPressures rDKWheelPressures) {
        boolean bl = rDKWheelPressures == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKWheelPressures.getPressureUnit();
            iSerializer.putInt32(n);
            int n2 = rDKWheelPressures.getFrontLeft();
            iSerializer.putInt32(n2);
            int n3 = rDKWheelPressures.getFrontRight();
            iSerializer.putInt32(n3);
            int n4 = rDKWheelPressures.getRearLeft();
            iSerializer.putInt32(n4);
            int n5 = rDKWheelPressures.getRearRight();
            iSerializer.putInt32(n5);
            int n6 = rDKWheelPressures.getSpareWheel();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalRDKWheelPressuresVarArray(ISerializer iSerializer, RDKWheelPressures[] rDKWheelPressuresArray) {
        boolean bl = rDKWheelPressuresArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKWheelPressuresArray.length);
            for (int i2 = 0; i2 < rDKWheelPressuresArray.length; ++i2) {
                RDKWheelPressuresSerializer.putOptionalRDKWheelPressures(iSerializer, rDKWheelPressuresArray[i2]);
            }
        }
    }

    public static RDKWheelPressures getOptionalRDKWheelPressures(IDeserializer iDeserializer) {
        RDKWheelPressures rDKWheelPressures = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            rDKWheelPressures = new RDKWheelPressures();
            rDKWheelPressures.pressureUnit = n6 = iDeserializer.getInt32();
            rDKWheelPressures.frontLeft = n5 = iDeserializer.getInt32();
            rDKWheelPressures.frontRight = n4 = iDeserializer.getInt32();
            rDKWheelPressures.rearLeft = n3 = iDeserializer.getInt32();
            rDKWheelPressures.rearRight = n2 = iDeserializer.getInt32();
            rDKWheelPressures.spareWheel = n = iDeserializer.getInt32();
        }
        return rDKWheelPressures;
    }

    public static RDKWheelPressures[] getOptionalRDKWheelPressuresVarArray(IDeserializer iDeserializer) {
        RDKWheelPressures[] rDKWheelPressuresArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKWheelPressuresArray = new RDKWheelPressures[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKWheelPressuresArray[i2] = RDKWheelPressuresSerializer.getOptionalRDKWheelPressures(iDeserializer);
            }
        }
        return rDKWheelPressuresArray;
    }
}

