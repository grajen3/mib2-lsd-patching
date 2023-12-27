/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;

public class PDCDistanceValuesFrontRearExtSerializer {
    public static void putOptionalPDCDistanceValuesFrontRearExt(ISerializer iSerializer, PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt) {
        boolean bl = pDCDistanceValuesFrontRearExt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCDistanceValuesFrontRearExt.getSpacing5();
            iSerializer.putInt32(n);
            int n2 = pDCDistanceValuesFrontRearExt.getSpacing6();
            iSerializer.putInt32(n2);
            int n3 = pDCDistanceValuesFrontRearExt.getSpacing7();
            iSerializer.putInt32(n3);
            int n4 = pDCDistanceValuesFrontRearExt.getSpacing8();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPDCDistanceValuesFrontRearExtVarArray(ISerializer iSerializer, PDCDistanceValuesFrontRearExt[] pDCDistanceValuesFrontRearExtArray) {
        boolean bl = pDCDistanceValuesFrontRearExtArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCDistanceValuesFrontRearExtArray.length);
            for (int i2 = 0; i2 < pDCDistanceValuesFrontRearExtArray.length; ++i2) {
                PDCDistanceValuesFrontRearExtSerializer.putOptionalPDCDistanceValuesFrontRearExt(iSerializer, pDCDistanceValuesFrontRearExtArray[i2]);
            }
        }
    }

    public static PDCDistanceValuesFrontRearExt getOptionalPDCDistanceValuesFrontRearExt(IDeserializer iDeserializer) {
        PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            pDCDistanceValuesFrontRearExt = new PDCDistanceValuesFrontRearExt();
            pDCDistanceValuesFrontRearExt.spacing5 = n4 = iDeserializer.getInt32();
            pDCDistanceValuesFrontRearExt.spacing6 = n3 = iDeserializer.getInt32();
            pDCDistanceValuesFrontRearExt.spacing7 = n2 = iDeserializer.getInt32();
            pDCDistanceValuesFrontRearExt.spacing8 = n = iDeserializer.getInt32();
        }
        return pDCDistanceValuesFrontRearExt;
    }

    public static PDCDistanceValuesFrontRearExt[] getOptionalPDCDistanceValuesFrontRearExtVarArray(IDeserializer iDeserializer) {
        PDCDistanceValuesFrontRearExt[] pDCDistanceValuesFrontRearExtArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCDistanceValuesFrontRearExtArray = new PDCDistanceValuesFrontRearExt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCDistanceValuesFrontRearExtArray[i2] = PDCDistanceValuesFrontRearExtSerializer.getOptionalPDCDistanceValuesFrontRearExt(iDeserializer);
            }
        }
        return pDCDistanceValuesFrontRearExtArray;
    }
}

