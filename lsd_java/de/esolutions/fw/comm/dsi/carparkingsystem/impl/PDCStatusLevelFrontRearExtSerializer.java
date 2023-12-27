/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;

public class PDCStatusLevelFrontRearExtSerializer {
    public static void putOptionalPDCStatusLevelFrontRearExt(ISerializer iSerializer, PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt) {
        boolean bl = pDCStatusLevelFrontRearExt == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCStatusLevelFrontRearExt.getStatusLevel5();
            iSerializer.putInt32(n);
            int n2 = pDCStatusLevelFrontRearExt.getStatusLevel6();
            iSerializer.putInt32(n2);
            int n3 = pDCStatusLevelFrontRearExt.getStatusLevel7();
            iSerializer.putInt32(n3);
            int n4 = pDCStatusLevelFrontRearExt.getStatusLevel8();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPDCStatusLevelFrontRearExtVarArray(ISerializer iSerializer, PDCStatusLevelFrontRearExt[] pDCStatusLevelFrontRearExtArray) {
        boolean bl = pDCStatusLevelFrontRearExtArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCStatusLevelFrontRearExtArray.length);
            for (int i2 = 0; i2 < pDCStatusLevelFrontRearExtArray.length; ++i2) {
                PDCStatusLevelFrontRearExtSerializer.putOptionalPDCStatusLevelFrontRearExt(iSerializer, pDCStatusLevelFrontRearExtArray[i2]);
            }
        }
    }

    public static PDCStatusLevelFrontRearExt getOptionalPDCStatusLevelFrontRearExt(IDeserializer iDeserializer) {
        PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            pDCStatusLevelFrontRearExt = new PDCStatusLevelFrontRearExt();
            pDCStatusLevelFrontRearExt.statusLevel5 = n4 = iDeserializer.getInt32();
            pDCStatusLevelFrontRearExt.statusLevel6 = n3 = iDeserializer.getInt32();
            pDCStatusLevelFrontRearExt.statusLevel7 = n2 = iDeserializer.getInt32();
            pDCStatusLevelFrontRearExt.statusLevel8 = n = iDeserializer.getInt32();
        }
        return pDCStatusLevelFrontRearExt;
    }

    public static PDCStatusLevelFrontRearExt[] getOptionalPDCStatusLevelFrontRearExtVarArray(IDeserializer iDeserializer) {
        PDCStatusLevelFrontRearExt[] pDCStatusLevelFrontRearExtArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCStatusLevelFrontRearExtArray = new PDCStatusLevelFrontRearExt[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCStatusLevelFrontRearExtArray[i2] = PDCStatusLevelFrontRearExtSerializer.getOptionalPDCStatusLevelFrontRearExt(iDeserializer);
            }
        }
        return pDCStatusLevelFrontRearExtArray;
    }
}

