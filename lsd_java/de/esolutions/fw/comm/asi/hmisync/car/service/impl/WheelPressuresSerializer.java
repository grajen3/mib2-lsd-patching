/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.WheelPressures;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class WheelPressuresSerializer {
    public static void putOptionalWheelPressures(ISerializer iSerializer, WheelPressures wheelPressures) {
        boolean bl = wheelPressures == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wheelPressures.getPressureUnit();
            iSerializer.putInt32(n);
            int n2 = wheelPressures.getFrontLeft();
            iSerializer.putInt32(n2);
            int n3 = wheelPressures.getFrontRight();
            iSerializer.putInt32(n3);
            int n4 = wheelPressures.getRearLeft();
            iSerializer.putInt32(n4);
            int n5 = wheelPressures.getRearRight();
            iSerializer.putInt32(n5);
            int n6 = wheelPressures.getSpareWheel();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalWheelPressuresVarArray(ISerializer iSerializer, WheelPressures[] wheelPressuresArray) {
        boolean bl = wheelPressuresArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wheelPressuresArray.length);
            for (int i2 = 0; i2 < wheelPressuresArray.length; ++i2) {
                WheelPressuresSerializer.putOptionalWheelPressures(iSerializer, wheelPressuresArray[i2]);
            }
        }
    }

    public static WheelPressures getOptionalWheelPressures(IDeserializer iDeserializer) {
        WheelPressures wheelPressures = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            wheelPressures = new WheelPressures();
            wheelPressures.pressureUnit = n6 = iDeserializer.getInt32();
            wheelPressures.frontLeft = n5 = iDeserializer.getInt32();
            wheelPressures.frontRight = n4 = iDeserializer.getInt32();
            wheelPressures.rearLeft = n3 = iDeserializer.getInt32();
            wheelPressures.rearRight = n2 = iDeserializer.getInt32();
            wheelPressures.spareWheel = n = iDeserializer.getInt32();
        }
        return wheelPressures;
    }

    public static WheelPressures[] getOptionalWheelPressuresVarArray(IDeserializer iDeserializer) {
        WheelPressures[] wheelPressuresArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wheelPressuresArray = new WheelPressures[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wheelPressuresArray[i2] = WheelPressuresSerializer.getOptionalWheelPressures(iDeserializer);
            }
        }
        return wheelPressuresArray;
    }
}

