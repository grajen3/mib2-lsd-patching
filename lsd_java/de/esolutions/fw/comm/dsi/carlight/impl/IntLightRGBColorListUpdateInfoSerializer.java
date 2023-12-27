/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;

public class IntLightRGBColorListUpdateInfoSerializer {
    public static void putOptionalIntLightRGBColorListUpdateInfo(ISerializer iSerializer, IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        boolean bl = intLightRGBColorListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = intLightRGBColorListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = intLightRGBColorListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n2);
            int n3 = intLightRGBColorListUpdateInfo.getStartElement();
            iSerializer.putInt32(n3);
            int n4 = intLightRGBColorListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n4);
            int n5 = intLightRGBColorListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalIntLightRGBColorListUpdateInfoVarArray(ISerializer iSerializer, IntLightRGBColorListUpdateInfo[] intLightRGBColorListUpdateInfoArray) {
        boolean bl = intLightRGBColorListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightRGBColorListUpdateInfoArray.length);
            for (int i2 = 0; i2 < intLightRGBColorListUpdateInfoArray.length; ++i2) {
                IntLightRGBColorListUpdateInfoSerializer.putOptionalIntLightRGBColorListUpdateInfo(iSerializer, intLightRGBColorListUpdateInfoArray[i2]);
            }
        }
    }

    public static IntLightRGBColorListUpdateInfo getOptionalIntLightRGBColorListUpdateInfo(IDeserializer iDeserializer) {
        IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo();
            intLightRGBColorListUpdateInfo.arrayContent = n5 = iDeserializer.getInt32();
            intLightRGBColorListUpdateInfo.recordContent = n4 = iDeserializer.getInt32();
            intLightRGBColorListUpdateInfo.startElement = n3 = iDeserializer.getInt32();
            intLightRGBColorListUpdateInfo.numOfElements = n2 = iDeserializer.getInt32();
            intLightRGBColorListUpdateInfo.transactionID = n = iDeserializer.getInt32();
        }
        return intLightRGBColorListUpdateInfo;
    }

    public static IntLightRGBColorListUpdateInfo[] getOptionalIntLightRGBColorListUpdateInfoVarArray(IDeserializer iDeserializer) {
        IntLightRGBColorListUpdateInfo[] intLightRGBColorListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightRGBColorListUpdateInfoArray = new IntLightRGBColorListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightRGBColorListUpdateInfoArray[i2] = IntLightRGBColorListUpdateInfoSerializer.getOptionalIntLightRGBColorListUpdateInfo(iDeserializer);
            }
        }
        return intLightRGBColorListUpdateInfoArray;
    }
}

