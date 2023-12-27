/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCSupportedFunctions;

public class PDCSupportedFunctionsSerializer {
    public static void putOptionalPDCSupportedFunctions(ISerializer iSerializer, PDCSupportedFunctions pDCSupportedFunctions) {
        boolean bl = pDCSupportedFunctions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCSupportedFunctions.isPla();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCSupportedFunctions.isIpa();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCSupportedFunctions.isPp();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCSupportedFunctions.isGp();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalPDCSupportedFunctionsVarArray(ISerializer iSerializer, PDCSupportedFunctions[] pDCSupportedFunctionsArray) {
        boolean bl = pDCSupportedFunctionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCSupportedFunctionsArray.length);
            for (int i2 = 0; i2 < pDCSupportedFunctionsArray.length; ++i2) {
                PDCSupportedFunctionsSerializer.putOptionalPDCSupportedFunctions(iSerializer, pDCSupportedFunctionsArray[i2]);
            }
        }
    }

    public static PDCSupportedFunctions getOptionalPDCSupportedFunctions(IDeserializer iDeserializer) {
        PDCSupportedFunctions pDCSupportedFunctions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            pDCSupportedFunctions = new PDCSupportedFunctions();
            pDCSupportedFunctions.pla = bl5 = iDeserializer.getBool();
            pDCSupportedFunctions.ipa = bl4 = iDeserializer.getBool();
            pDCSupportedFunctions.pp = bl3 = iDeserializer.getBool();
            pDCSupportedFunctions.gp = bl2 = iDeserializer.getBool();
        }
        return pDCSupportedFunctions;
    }

    public static PDCSupportedFunctions[] getOptionalPDCSupportedFunctionsVarArray(IDeserializer iDeserializer) {
        PDCSupportedFunctions[] pDCSupportedFunctionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCSupportedFunctionsArray = new PDCSupportedFunctions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCSupportedFunctionsArray[i2] = PDCSupportedFunctionsSerializer.getOptionalPDCSupportedFunctions(iDeserializer);
            }
        }
        return pDCSupportedFunctionsArray;
    }
}

