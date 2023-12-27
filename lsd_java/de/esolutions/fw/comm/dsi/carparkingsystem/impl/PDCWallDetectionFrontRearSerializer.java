/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionFrontRear;

public class PDCWallDetectionFrontRearSerializer {
    public static void putOptionalPDCWallDetectionFrontRear(ISerializer iSerializer, PDCWallDetectionFrontRear pDCWallDetectionFrontRear) {
        boolean bl = pDCWallDetectionFrontRear == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCWallDetectionFrontRear.isSector1();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCWallDetectionFrontRear.isSector2();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCWallDetectionFrontRear.isSector3();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCWallDetectionFrontRear.isSector4();
            iSerializer.putBool(bl5);
            boolean bl6 = pDCWallDetectionFrontRear.isSector5();
            iSerializer.putBool(bl6);
            boolean bl7 = pDCWallDetectionFrontRear.isSector6();
            iSerializer.putBool(bl7);
            boolean bl8 = pDCWallDetectionFrontRear.isSector7();
            iSerializer.putBool(bl8);
            boolean bl9 = pDCWallDetectionFrontRear.isSector8();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalPDCWallDetectionFrontRearVarArray(ISerializer iSerializer, PDCWallDetectionFrontRear[] pDCWallDetectionFrontRearArray) {
        boolean bl = pDCWallDetectionFrontRearArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCWallDetectionFrontRearArray.length);
            for (int i2 = 0; i2 < pDCWallDetectionFrontRearArray.length; ++i2) {
                PDCWallDetectionFrontRearSerializer.putOptionalPDCWallDetectionFrontRear(iSerializer, pDCWallDetectionFrontRearArray[i2]);
            }
        }
    }

    public static PDCWallDetectionFrontRear getOptionalPDCWallDetectionFrontRear(IDeserializer iDeserializer) {
        PDCWallDetectionFrontRear pDCWallDetectionFrontRear = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            pDCWallDetectionFrontRear = new PDCWallDetectionFrontRear();
            pDCWallDetectionFrontRear.sector1 = bl9 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector2 = bl8 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector3 = bl7 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector4 = bl6 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector5 = bl5 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector6 = bl4 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector7 = bl3 = iDeserializer.getBool();
            pDCWallDetectionFrontRear.sector8 = bl2 = iDeserializer.getBool();
        }
        return pDCWallDetectionFrontRear;
    }

    public static PDCWallDetectionFrontRear[] getOptionalPDCWallDetectionFrontRearVarArray(IDeserializer iDeserializer) {
        PDCWallDetectionFrontRear[] pDCWallDetectionFrontRearArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCWallDetectionFrontRearArray = new PDCWallDetectionFrontRear[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCWallDetectionFrontRearArray[i2] = PDCWallDetectionFrontRearSerializer.getOptionalPDCWallDetectionFrontRear(iDeserializer);
            }
        }
        return pDCWallDetectionFrontRearArray;
    }
}

