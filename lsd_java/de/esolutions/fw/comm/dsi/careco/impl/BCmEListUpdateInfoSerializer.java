/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

public class BCmEListUpdateInfoSerializer {
    public static void putOptionalBCmEListUpdateInfo(ISerializer iSerializer, BCmEListUpdateInfo bCmEListUpdateInfo) {
        boolean bl = bCmEListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = bCmEListUpdateInfo.getStartElement();
            iSerializer.putInt32(n2);
            int n3 = bCmEListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n3);
            int n4 = bCmEListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n4);
            int n5 = bCmEListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n5);
            int n6 = bCmEListUpdateInfo.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalBCmEListUpdateInfoVarArray(ISerializer iSerializer, BCmEListUpdateInfo[] bCmEListUpdateInfoArray) {
        boolean bl = bCmEListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEListUpdateInfoArray.length);
            for (int i2 = 0; i2 < bCmEListUpdateInfoArray.length; ++i2) {
                BCmEListUpdateInfoSerializer.putOptionalBCmEListUpdateInfo(iSerializer, bCmEListUpdateInfoArray[i2]);
            }
        }
    }

    public static BCmEListUpdateInfo getOptionalBCmEListUpdateInfo(IDeserializer iDeserializer) {
        BCmEListUpdateInfo bCmEListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            bCmEListUpdateInfo = new BCmEListUpdateInfo();
            bCmEListUpdateInfo.arrayContent = n6 = iDeserializer.getInt32();
            bCmEListUpdateInfo.startElement = n5 = iDeserializer.getInt32();
            bCmEListUpdateInfo.numOfElements = n4 = iDeserializer.getInt32();
            bCmEListUpdateInfo.transactionID = n3 = iDeserializer.getInt32();
            bCmEListUpdateInfo.recordContent = n2 = iDeserializer.getInt32();
            bCmEListUpdateInfo.asgID = n = iDeserializer.getInt32();
        }
        return bCmEListUpdateInfo;
    }

    public static BCmEListUpdateInfo[] getOptionalBCmEListUpdateInfoVarArray(IDeserializer iDeserializer) {
        BCmEListUpdateInfo[] bCmEListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEListUpdateInfoArray = new BCmEListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEListUpdateInfoArray[i2] = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
            }
        }
        return bCmEListUpdateInfoArray;
    }
}

