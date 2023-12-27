/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;

public class PDCStatusLevelFrontRearSerializer {
    public static void putOptionalPDCStatusLevelFrontRear(ISerializer iSerializer, PDCStatusLevelFrontRear pDCStatusLevelFrontRear) {
        boolean bl = pDCStatusLevelFrontRear == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCStatusLevelFrontRear.getLeft();
            iSerializer.putInt32(n);
            int n2 = pDCStatusLevelFrontRear.getLeftMiddle();
            iSerializer.putInt32(n2);
            int n3 = pDCStatusLevelFrontRear.getRightMiddle();
            iSerializer.putInt32(n3);
            int n4 = pDCStatusLevelFrontRear.getRight();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPDCStatusLevelFrontRearVarArray(ISerializer iSerializer, PDCStatusLevelFrontRear[] pDCStatusLevelFrontRearArray) {
        boolean bl = pDCStatusLevelFrontRearArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCStatusLevelFrontRearArray.length);
            for (int i2 = 0; i2 < pDCStatusLevelFrontRearArray.length; ++i2) {
                PDCStatusLevelFrontRearSerializer.putOptionalPDCStatusLevelFrontRear(iSerializer, pDCStatusLevelFrontRearArray[i2]);
            }
        }
    }

    public static PDCStatusLevelFrontRear getOptionalPDCStatusLevelFrontRear(IDeserializer iDeserializer) {
        PDCStatusLevelFrontRear pDCStatusLevelFrontRear = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            pDCStatusLevelFrontRear = new PDCStatusLevelFrontRear();
            pDCStatusLevelFrontRear.left = n4 = iDeserializer.getInt32();
            pDCStatusLevelFrontRear.leftMiddle = n3 = iDeserializer.getInt32();
            pDCStatusLevelFrontRear.rightMiddle = n2 = iDeserializer.getInt32();
            pDCStatusLevelFrontRear.right = n = iDeserializer.getInt32();
        }
        return pDCStatusLevelFrontRear;
    }

    public static PDCStatusLevelFrontRear[] getOptionalPDCStatusLevelFrontRearVarArray(IDeserializer iDeserializer) {
        PDCStatusLevelFrontRear[] pDCStatusLevelFrontRearArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCStatusLevelFrontRearArray = new PDCStatusLevelFrontRear[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCStatusLevelFrontRearArray[i2] = PDCStatusLevelFrontRearSerializer.getOptionalPDCStatusLevelFrontRear(iDeserializer);
            }
        }
        return pDCStatusLevelFrontRearArray;
    }
}

