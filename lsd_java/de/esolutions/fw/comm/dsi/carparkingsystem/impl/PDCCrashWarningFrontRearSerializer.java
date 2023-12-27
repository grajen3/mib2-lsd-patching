/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningFrontRear;

public class PDCCrashWarningFrontRearSerializer {
    public static void putOptionalPDCCrashWarningFrontRear(ISerializer iSerializer, PDCCrashWarningFrontRear pDCCrashWarningFrontRear) {
        boolean bl = pDCCrashWarningFrontRear == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCCrashWarningFrontRear.isLeft();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCCrashWarningFrontRear.isLeftMiddle();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCCrashWarningFrontRear.isRightMiddle();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCCrashWarningFrontRear.isRight();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalPDCCrashWarningFrontRearVarArray(ISerializer iSerializer, PDCCrashWarningFrontRear[] pDCCrashWarningFrontRearArray) {
        boolean bl = pDCCrashWarningFrontRearArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCCrashWarningFrontRearArray.length);
            for (int i2 = 0; i2 < pDCCrashWarningFrontRearArray.length; ++i2) {
                PDCCrashWarningFrontRearSerializer.putOptionalPDCCrashWarningFrontRear(iSerializer, pDCCrashWarningFrontRearArray[i2]);
            }
        }
    }

    public static PDCCrashWarningFrontRear getOptionalPDCCrashWarningFrontRear(IDeserializer iDeserializer) {
        PDCCrashWarningFrontRear pDCCrashWarningFrontRear = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            pDCCrashWarningFrontRear = new PDCCrashWarningFrontRear();
            pDCCrashWarningFrontRear.left = bl5 = iDeserializer.getBool();
            pDCCrashWarningFrontRear.leftMiddle = bl4 = iDeserializer.getBool();
            pDCCrashWarningFrontRear.rightMiddle = bl3 = iDeserializer.getBool();
            pDCCrashWarningFrontRear.right = bl2 = iDeserializer.getBool();
        }
        return pDCCrashWarningFrontRear;
    }

    public static PDCCrashWarningFrontRear[] getOptionalPDCCrashWarningFrontRearVarArray(IDeserializer iDeserializer) {
        PDCCrashWarningFrontRear[] pDCCrashWarningFrontRearArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCCrashWarningFrontRearArray = new PDCCrashWarningFrontRear[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCCrashWarningFrontRearArray[i2] = PDCCrashWarningFrontRearSerializer.getOptionalPDCCrashWarningFrontRear(iDeserializer);
            }
        }
        return pDCCrashWarningFrontRearArray;
    }
}

