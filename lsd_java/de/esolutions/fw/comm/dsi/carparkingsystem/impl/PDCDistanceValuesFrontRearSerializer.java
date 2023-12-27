/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;

public class PDCDistanceValuesFrontRearSerializer {
    public static void putOptionalPDCDistanceValuesFrontRear(ISerializer iSerializer, PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear) {
        boolean bl = pDCDistanceValuesFrontRear == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCDistanceValuesFrontRear.getLeft();
            iSerializer.putInt32(n);
            int n2 = pDCDistanceValuesFrontRear.getLeftMiddle();
            iSerializer.putInt32(n2);
            int n3 = pDCDistanceValuesFrontRear.getRightMiddle();
            iSerializer.putInt32(n3);
            int n4 = pDCDistanceValuesFrontRear.getRight();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPDCDistanceValuesFrontRearVarArray(ISerializer iSerializer, PDCDistanceValuesFrontRear[] pDCDistanceValuesFrontRearArray) {
        boolean bl = pDCDistanceValuesFrontRearArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCDistanceValuesFrontRearArray.length);
            for (int i2 = 0; i2 < pDCDistanceValuesFrontRearArray.length; ++i2) {
                PDCDistanceValuesFrontRearSerializer.putOptionalPDCDistanceValuesFrontRear(iSerializer, pDCDistanceValuesFrontRearArray[i2]);
            }
        }
    }

    public static PDCDistanceValuesFrontRear getOptionalPDCDistanceValuesFrontRear(IDeserializer iDeserializer) {
        PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            pDCDistanceValuesFrontRear = new PDCDistanceValuesFrontRear();
            pDCDistanceValuesFrontRear.left = n4 = iDeserializer.getInt32();
            pDCDistanceValuesFrontRear.leftMiddle = n3 = iDeserializer.getInt32();
            pDCDistanceValuesFrontRear.rightMiddle = n2 = iDeserializer.getInt32();
            pDCDistanceValuesFrontRear.right = n = iDeserializer.getInt32();
        }
        return pDCDistanceValuesFrontRear;
    }

    public static PDCDistanceValuesFrontRear[] getOptionalPDCDistanceValuesFrontRearVarArray(IDeserializer iDeserializer) {
        PDCDistanceValuesFrontRear[] pDCDistanceValuesFrontRearArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCDistanceValuesFrontRearArray = new PDCDistanceValuesFrontRear[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCDistanceValuesFrontRearArray[i2] = PDCDistanceValuesFrontRearSerializer.getOptionalPDCDistanceValuesFrontRear(iDeserializer);
            }
        }
        return pDCDistanceValuesFrontRearArray;
    }
}

