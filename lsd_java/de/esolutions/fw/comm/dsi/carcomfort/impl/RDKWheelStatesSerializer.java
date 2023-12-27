/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKWheelStates;

public class RDKWheelStatesSerializer {
    public static void putOptionalRDKWheelStates(ISerializer iSerializer, RDKWheelStates rDKWheelStates) {
        boolean bl = rDKWheelStates == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKWheelStates.getFrontLeft();
            iSerializer.putInt32(n);
            int n2 = rDKWheelStates.getFrontRight();
            iSerializer.putInt32(n2);
            int n3 = rDKWheelStates.getRearLeft();
            iSerializer.putInt32(n3);
            int n4 = rDKWheelStates.getRearRight();
            iSerializer.putInt32(n4);
            int n5 = rDKWheelStates.getSpareWheel();
            iSerializer.putInt32(n5);
            int n6 = rDKWheelStates.getCollectedState();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalRDKWheelStatesVarArray(ISerializer iSerializer, RDKWheelStates[] rDKWheelStatesArray) {
        boolean bl = rDKWheelStatesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKWheelStatesArray.length);
            for (int i2 = 0; i2 < rDKWheelStatesArray.length; ++i2) {
                RDKWheelStatesSerializer.putOptionalRDKWheelStates(iSerializer, rDKWheelStatesArray[i2]);
            }
        }
    }

    public static RDKWheelStates getOptionalRDKWheelStates(IDeserializer iDeserializer) {
        RDKWheelStates rDKWheelStates = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            rDKWheelStates = new RDKWheelStates();
            rDKWheelStates.frontLeft = n6 = iDeserializer.getInt32();
            rDKWheelStates.frontRight = n5 = iDeserializer.getInt32();
            rDKWheelStates.rearLeft = n4 = iDeserializer.getInt32();
            rDKWheelStates.rearRight = n3 = iDeserializer.getInt32();
            rDKWheelStates.spareWheel = n2 = iDeserializer.getInt32();
            rDKWheelStates.collectedState = n = iDeserializer.getInt32();
        }
        return rDKWheelStates;
    }

    public static RDKWheelStates[] getOptionalRDKWheelStatesVarArray(IDeserializer iDeserializer) {
        RDKWheelStates[] rDKWheelStatesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKWheelStatesArray = new RDKWheelStates[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKWheelStatesArray[i2] = RDKWheelStatesSerializer.getOptionalRDKWheelStates(iDeserializer);
            }
        }
        return rDKWheelStatesArray;
    }
}

