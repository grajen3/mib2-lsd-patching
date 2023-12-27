/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionRightLeft;

public class PDCWallDetectionRightLeftSerializer {
    public static void putOptionalPDCWallDetectionRightLeft(ISerializer iSerializer, PDCWallDetectionRightLeft pDCWallDetectionRightLeft) {
        boolean bl = pDCWallDetectionRightLeft == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCWallDetectionRightLeft.isSector1();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCWallDetectionRightLeft.isSector2();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCWallDetectionRightLeft.isSector3();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCWallDetectionRightLeft.isSector4();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalPDCWallDetectionRightLeftVarArray(ISerializer iSerializer, PDCWallDetectionRightLeft[] pDCWallDetectionRightLeftArray) {
        boolean bl = pDCWallDetectionRightLeftArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCWallDetectionRightLeftArray.length);
            for (int i2 = 0; i2 < pDCWallDetectionRightLeftArray.length; ++i2) {
                PDCWallDetectionRightLeftSerializer.putOptionalPDCWallDetectionRightLeft(iSerializer, pDCWallDetectionRightLeftArray[i2]);
            }
        }
    }

    public static PDCWallDetectionRightLeft getOptionalPDCWallDetectionRightLeft(IDeserializer iDeserializer) {
        PDCWallDetectionRightLeft pDCWallDetectionRightLeft = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            pDCWallDetectionRightLeft = new PDCWallDetectionRightLeft();
            pDCWallDetectionRightLeft.sector1 = bl5 = iDeserializer.getBool();
            pDCWallDetectionRightLeft.sector2 = bl4 = iDeserializer.getBool();
            pDCWallDetectionRightLeft.sector3 = bl3 = iDeserializer.getBool();
            pDCWallDetectionRightLeft.sector4 = bl2 = iDeserializer.getBool();
        }
        return pDCWallDetectionRightLeft;
    }

    public static PDCWallDetectionRightLeft[] getOptionalPDCWallDetectionRightLeftVarArray(IDeserializer iDeserializer) {
        PDCWallDetectionRightLeft[] pDCWallDetectionRightLeftArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCWallDetectionRightLeftArray = new PDCWallDetectionRightLeft[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCWallDetectionRightLeftArray[i2] = PDCWallDetectionRightLeftSerializer.getOptionalPDCWallDetectionRightLeft(iDeserializer);
            }
        }
        return pDCWallDetectionRightLeftArray;
    }
}

