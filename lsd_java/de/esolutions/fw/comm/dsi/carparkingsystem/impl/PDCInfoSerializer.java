/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCInfo;

public class PDCInfoSerializer {
    public static void putOptionalPDCInfo(ISerializer iSerializer, PDCInfo pDCInfo) {
        boolean bl = pDCInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCInfo.isLimitedFunctionality();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCInfo.isTrunkOpen();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalPDCInfoVarArray(ISerializer iSerializer, PDCInfo[] pDCInfoArray) {
        boolean bl = pDCInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCInfoArray.length);
            for (int i2 = 0; i2 < pDCInfoArray.length; ++i2) {
                PDCInfoSerializer.putOptionalPDCInfo(iSerializer, pDCInfoArray[i2]);
            }
        }
    }

    public static PDCInfo getOptionalPDCInfo(IDeserializer iDeserializer) {
        PDCInfo pDCInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            pDCInfo = new PDCInfo();
            pDCInfo.limitedFunctionality = bl3 = iDeserializer.getBool();
            pDCInfo.trunkOpen = bl2 = iDeserializer.getBool();
        }
        return pDCInfo;
    }

    public static PDCInfo[] getOptionalPDCInfoVarArray(IDeserializer iDeserializer) {
        PDCInfo[] pDCInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCInfoArray = new PDCInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCInfoArray[i2] = PDCInfoSerializer.getOptionalPDCInfo(iDeserializer);
            }
        }
        return pDCInfoArray;
    }
}

