/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;

public class PDCDistanceValuesRightLeftSerializer {
    public static void putOptionalPDCDistanceValuesRightLeft(ISerializer iSerializer, PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft) {
        boolean bl = pDCDistanceValuesRightLeft == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCDistanceValuesRightLeft.getFront();
            iSerializer.putInt32(n);
            int n2 = pDCDistanceValuesRightLeft.getFrontMiddle();
            iSerializer.putInt32(n2);
            int n3 = pDCDistanceValuesRightLeft.getRearMiddle();
            iSerializer.putInt32(n3);
            int n4 = pDCDistanceValuesRightLeft.getRear();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPDCDistanceValuesRightLeftVarArray(ISerializer iSerializer, PDCDistanceValuesRightLeft[] pDCDistanceValuesRightLeftArray) {
        boolean bl = pDCDistanceValuesRightLeftArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCDistanceValuesRightLeftArray.length);
            for (int i2 = 0; i2 < pDCDistanceValuesRightLeftArray.length; ++i2) {
                PDCDistanceValuesRightLeftSerializer.putOptionalPDCDistanceValuesRightLeft(iSerializer, pDCDistanceValuesRightLeftArray[i2]);
            }
        }
    }

    public static PDCDistanceValuesRightLeft getOptionalPDCDistanceValuesRightLeft(IDeserializer iDeserializer) {
        PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            pDCDistanceValuesRightLeft = new PDCDistanceValuesRightLeft();
            pDCDistanceValuesRightLeft.front = n4 = iDeserializer.getInt32();
            pDCDistanceValuesRightLeft.frontMiddle = n3 = iDeserializer.getInt32();
            pDCDistanceValuesRightLeft.rearMiddle = n2 = iDeserializer.getInt32();
            pDCDistanceValuesRightLeft.rear = n = iDeserializer.getInt32();
        }
        return pDCDistanceValuesRightLeft;
    }

    public static PDCDistanceValuesRightLeft[] getOptionalPDCDistanceValuesRightLeftVarArray(IDeserializer iDeserializer) {
        PDCDistanceValuesRightLeft[] pDCDistanceValuesRightLeftArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCDistanceValuesRightLeftArray = new PDCDistanceValuesRightLeft[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCDistanceValuesRightLeftArray[i2] = PDCDistanceValuesRightLeftSerializer.getOptionalPDCDistanceValuesRightLeft(iDeserializer);
            }
        }
        return pDCDistanceValuesRightLeftArray;
    }
}

