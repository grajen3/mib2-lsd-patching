/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

public class DCElementContentSelectionListUpdateInfoSerializer {
    public static void putOptionalDCElementContentSelectionListUpdateInfo(ISerializer iSerializer, DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        boolean bl = dCElementContentSelectionListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCElementContentSelectionListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = dCElementContentSelectionListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n2);
            int n3 = dCElementContentSelectionListUpdateInfo.getStartElement();
            iSerializer.putInt32(n3);
            int n4 = dCElementContentSelectionListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n4);
            int n5 = dCElementContentSelectionListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n5);
            int n6 = dCElementContentSelectionListUpdateInfo.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalDCElementContentSelectionListUpdateInfoVarArray(ISerializer iSerializer, DCElementContentSelectionListUpdateInfo[] dCElementContentSelectionListUpdateInfoArray) {
        boolean bl = dCElementContentSelectionListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCElementContentSelectionListUpdateInfoArray.length);
            for (int i2 = 0; i2 < dCElementContentSelectionListUpdateInfoArray.length; ++i2) {
                DCElementContentSelectionListUpdateInfoSerializer.putOptionalDCElementContentSelectionListUpdateInfo(iSerializer, dCElementContentSelectionListUpdateInfoArray[i2]);
            }
        }
    }

    public static DCElementContentSelectionListUpdateInfo getOptionalDCElementContentSelectionListUpdateInfo(IDeserializer iDeserializer) {
        DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            dCElementContentSelectionListUpdateInfo = new DCElementContentSelectionListUpdateInfo();
            dCElementContentSelectionListUpdateInfo.arrayContent = n6 = iDeserializer.getInt32();
            dCElementContentSelectionListUpdateInfo.recordContent = n5 = iDeserializer.getInt32();
            dCElementContentSelectionListUpdateInfo.startElement = n4 = iDeserializer.getInt32();
            dCElementContentSelectionListUpdateInfo.numOfElements = n3 = iDeserializer.getInt32();
            dCElementContentSelectionListUpdateInfo.transactionID = n2 = iDeserializer.getInt32();
            dCElementContentSelectionListUpdateInfo.asgID = n = iDeserializer.getInt32();
        }
        return dCElementContentSelectionListUpdateInfo;
    }

    public static DCElementContentSelectionListUpdateInfo[] getOptionalDCElementContentSelectionListUpdateInfoVarArray(IDeserializer iDeserializer) {
        DCElementContentSelectionListUpdateInfo[] dCElementContentSelectionListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCElementContentSelectionListUpdateInfoArray = new DCElementContentSelectionListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCElementContentSelectionListUpdateInfoArray[i2] = DCElementContentSelectionListUpdateInfoSerializer.getOptionalDCElementContentSelectionListUpdateInfo(iDeserializer);
            }
        }
        return dCElementContentSelectionListUpdateInfoArray;
    }
}

