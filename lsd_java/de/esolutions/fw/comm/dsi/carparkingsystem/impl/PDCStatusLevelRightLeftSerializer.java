/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;

public class PDCStatusLevelRightLeftSerializer {
    public static void putOptionalPDCStatusLevelRightLeft(ISerializer iSerializer, PDCStatusLevelRightLeft pDCStatusLevelRightLeft) {
        boolean bl = pDCStatusLevelRightLeft == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCStatusLevelRightLeft.getFront();
            iSerializer.putInt32(n);
            int n2 = pDCStatusLevelRightLeft.getFrontMiddle();
            iSerializer.putInt32(n2);
            int n3 = pDCStatusLevelRightLeft.getRearMiddle();
            iSerializer.putInt32(n3);
            int n4 = pDCStatusLevelRightLeft.getRear();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPDCStatusLevelRightLeftVarArray(ISerializer iSerializer, PDCStatusLevelRightLeft[] pDCStatusLevelRightLeftArray) {
        boolean bl = pDCStatusLevelRightLeftArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCStatusLevelRightLeftArray.length);
            for (int i2 = 0; i2 < pDCStatusLevelRightLeftArray.length; ++i2) {
                PDCStatusLevelRightLeftSerializer.putOptionalPDCStatusLevelRightLeft(iSerializer, pDCStatusLevelRightLeftArray[i2]);
            }
        }
    }

    public static PDCStatusLevelRightLeft getOptionalPDCStatusLevelRightLeft(IDeserializer iDeserializer) {
        PDCStatusLevelRightLeft pDCStatusLevelRightLeft = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            pDCStatusLevelRightLeft = new PDCStatusLevelRightLeft();
            pDCStatusLevelRightLeft.front = n4 = iDeserializer.getInt32();
            pDCStatusLevelRightLeft.frontMiddle = n3 = iDeserializer.getInt32();
            pDCStatusLevelRightLeft.rearMiddle = n2 = iDeserializer.getInt32();
            pDCStatusLevelRightLeft.rear = n = iDeserializer.getInt32();
        }
        return pDCStatusLevelRightLeft;
    }

    public static PDCStatusLevelRightLeft[] getOptionalPDCStatusLevelRightLeftVarArray(IDeserializer iDeserializer) {
        PDCStatusLevelRightLeft[] pDCStatusLevelRightLeftArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCStatusLevelRightLeftArray = new PDCStatusLevelRightLeft[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCStatusLevelRightLeftArray[i2] = PDCStatusLevelRightLeftSerializer.getOptionalPDCStatusLevelRightLeft(iDeserializer);
            }
        }
        return pDCStatusLevelRightLeftArray;
    }
}

