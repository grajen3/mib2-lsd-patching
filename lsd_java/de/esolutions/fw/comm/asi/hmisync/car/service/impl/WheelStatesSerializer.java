/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.WheelStates;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class WheelStatesSerializer {
    public static void putOptionalWheelStates(ISerializer iSerializer, WheelStates wheelStates) {
        boolean bl = wheelStates == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wheelStates.getFrontLeft();
            iSerializer.putInt32(n);
            int n2 = wheelStates.getFrontRight();
            iSerializer.putInt32(n2);
            int n3 = wheelStates.getRearLeft();
            iSerializer.putInt32(n3);
            int n4 = wheelStates.getRearRight();
            iSerializer.putInt32(n4);
            int n5 = wheelStates.getSpareWheel();
            iSerializer.putInt32(n5);
            int n6 = wheelStates.getCollectedState();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalWheelStatesVarArray(ISerializer iSerializer, WheelStates[] wheelStatesArray) {
        boolean bl = wheelStatesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wheelStatesArray.length);
            for (int i2 = 0; i2 < wheelStatesArray.length; ++i2) {
                WheelStatesSerializer.putOptionalWheelStates(iSerializer, wheelStatesArray[i2]);
            }
        }
    }

    public static WheelStates getOptionalWheelStates(IDeserializer iDeserializer) {
        WheelStates wheelStates = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            wheelStates = new WheelStates();
            wheelStates.frontLeft = n6 = iDeserializer.getInt32();
            wheelStates.frontRight = n5 = iDeserializer.getInt32();
            wheelStates.rearLeft = n4 = iDeserializer.getInt32();
            wheelStates.rearRight = n3 = iDeserializer.getInt32();
            wheelStates.spareWheel = n2 = iDeserializer.getInt32();
            wheelStates.collectedState = n = iDeserializer.getInt32();
        }
        return wheelStates;
    }

    public static WheelStates[] getOptionalWheelStatesVarArray(IDeserializer iDeserializer) {
        WheelStates[] wheelStatesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wheelStatesArray = new WheelStates[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wheelStatesArray[i2] = WheelStatesSerializer.getOptionalWheelStates(iDeserializer);
            }
        }
        return wheelStatesArray;
    }
}

