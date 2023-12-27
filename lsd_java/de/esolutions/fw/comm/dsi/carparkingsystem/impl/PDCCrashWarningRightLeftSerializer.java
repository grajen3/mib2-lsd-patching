/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningRightLeft;

public class PDCCrashWarningRightLeftSerializer {
    public static void putOptionalPDCCrashWarningRightLeft(ISerializer iSerializer, PDCCrashWarningRightLeft pDCCrashWarningRightLeft) {
        boolean bl = pDCCrashWarningRightLeft == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCCrashWarningRightLeft.isFront();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCCrashWarningRightLeft.isFrontMiddle();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCCrashWarningRightLeft.isRearMiddle();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCCrashWarningRightLeft.isRear();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalPDCCrashWarningRightLeftVarArray(ISerializer iSerializer, PDCCrashWarningRightLeft[] pDCCrashWarningRightLeftArray) {
        boolean bl = pDCCrashWarningRightLeftArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCCrashWarningRightLeftArray.length);
            for (int i2 = 0; i2 < pDCCrashWarningRightLeftArray.length; ++i2) {
                PDCCrashWarningRightLeftSerializer.putOptionalPDCCrashWarningRightLeft(iSerializer, pDCCrashWarningRightLeftArray[i2]);
            }
        }
    }

    public static PDCCrashWarningRightLeft getOptionalPDCCrashWarningRightLeft(IDeserializer iDeserializer) {
        PDCCrashWarningRightLeft pDCCrashWarningRightLeft = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            pDCCrashWarningRightLeft = new PDCCrashWarningRightLeft();
            pDCCrashWarningRightLeft.front = bl5 = iDeserializer.getBool();
            pDCCrashWarningRightLeft.frontMiddle = bl4 = iDeserializer.getBool();
            pDCCrashWarningRightLeft.rearMiddle = bl3 = iDeserializer.getBool();
            pDCCrashWarningRightLeft.rear = bl2 = iDeserializer.getBool();
        }
        return pDCCrashWarningRightLeft;
    }

    public static PDCCrashWarningRightLeft[] getOptionalPDCCrashWarningRightLeftVarArray(IDeserializer iDeserializer) {
        PDCCrashWarningRightLeft[] pDCCrashWarningRightLeftArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCCrashWarningRightLeftArray = new PDCCrashWarningRightLeft[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCCrashWarningRightLeftArray[i2] = PDCCrashWarningRightLeftSerializer.getOptionalPDCCrashWarningRightLeft(iDeserializer);
            }
        }
        return pDCCrashWarningRightLeftArray;
    }
}

