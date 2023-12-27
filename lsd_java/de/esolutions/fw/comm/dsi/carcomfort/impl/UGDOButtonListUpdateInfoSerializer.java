/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

public class UGDOButtonListUpdateInfoSerializer {
    public static void putOptionalUGDOButtonListUpdateInfo(ISerializer iSerializer, UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        boolean bl = uGDOButtonListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = uGDOButtonListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n2);
            int n3 = uGDOButtonListUpdateInfo.getStartElement();
            iSerializer.putInt32(n3);
            int n4 = uGDOButtonListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n4);
            int n5 = uGDOButtonListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n5);
            int n6 = uGDOButtonListUpdateInfo.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalUGDOButtonListUpdateInfoVarArray(ISerializer iSerializer, UGDOButtonListUpdateInfo[] uGDOButtonListUpdateInfoArray) {
        boolean bl = uGDOButtonListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListUpdateInfoArray.length);
            for (int i2 = 0; i2 < uGDOButtonListUpdateInfoArray.length; ++i2) {
                UGDOButtonListUpdateInfoSerializer.putOptionalUGDOButtonListUpdateInfo(iSerializer, uGDOButtonListUpdateInfoArray[i2]);
            }
        }
    }

    public static UGDOButtonListUpdateInfo getOptionalUGDOButtonListUpdateInfo(IDeserializer iDeserializer) {
        UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            uGDOButtonListUpdateInfo = new UGDOButtonListUpdateInfo();
            uGDOButtonListUpdateInfo.arrayContent = n6 = iDeserializer.getInt32();
            uGDOButtonListUpdateInfo.recordContent = n5 = iDeserializer.getInt32();
            uGDOButtonListUpdateInfo.startElement = n4 = iDeserializer.getInt32();
            uGDOButtonListUpdateInfo.numOfElements = n3 = iDeserializer.getInt32();
            uGDOButtonListUpdateInfo.transactionID = n2 = iDeserializer.getInt32();
            uGDOButtonListUpdateInfo.asgID = n = iDeserializer.getInt32();
        }
        return uGDOButtonListUpdateInfo;
    }

    public static UGDOButtonListUpdateInfo[] getOptionalUGDOButtonListUpdateInfoVarArray(IDeserializer iDeserializer) {
        UGDOButtonListUpdateInfo[] uGDOButtonListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListUpdateInfoArray = new UGDOButtonListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListUpdateInfoArray[i2] = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
            }
        }
        return uGDOButtonListUpdateInfoArray;
    }
}

