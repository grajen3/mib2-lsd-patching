/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.CFResponseData;

public class CFResponseDataSerializer {
    public static void putOptionalCFResponseData(ISerializer iSerializer, CFResponseData cFResponseData) {
        boolean bl = cFResponseData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = cFResponseData.getTelCFStatus();
            iSerializer.putInt32(n);
            int n2 = cFResponseData.getTelCFCondition();
            iSerializer.putInt32(n2);
            String string = cFResponseData.getTelCFNumber();
            iSerializer.putOptionalString(string);
            short s = cFResponseData.getTelClass();
            iSerializer.putInt16(s);
            short s2 = cFResponseData.getTelNumType();
            iSerializer.putInt16(s2);
            short s3 = cFResponseData.getTelCFTime();
            iSerializer.putInt16(s3);
        }
    }

    public static void putOptionalCFResponseDataVarArray(ISerializer iSerializer, CFResponseData[] cFResponseDataArray) {
        boolean bl = cFResponseDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(cFResponseDataArray.length);
            for (int i2 = 0; i2 < cFResponseDataArray.length; ++i2) {
                CFResponseDataSerializer.putOptionalCFResponseData(iSerializer, cFResponseDataArray[i2]);
            }
        }
    }

    public static CFResponseData getOptionalCFResponseData(IDeserializer iDeserializer) {
        CFResponseData cFResponseData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            String string;
            int n;
            int n2;
            cFResponseData = new CFResponseData();
            cFResponseData.telCFStatus = n2 = iDeserializer.getInt32();
            cFResponseData.telCFCondition = n = iDeserializer.getInt32();
            cFResponseData.telCFNumber = string = iDeserializer.getOptionalString();
            cFResponseData.telClass = s3 = iDeserializer.getInt16();
            cFResponseData.telNumType = s2 = iDeserializer.getInt16();
            cFResponseData.telCFTime = s = iDeserializer.getInt16();
        }
        return cFResponseData;
    }

    public static CFResponseData[] getOptionalCFResponseDataVarArray(IDeserializer iDeserializer) {
        CFResponseData[] cFResponseDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            cFResponseDataArray = new CFResponseData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                cFResponseDataArray[i2] = CFResponseDataSerializer.getOptionalCFResponseData(iDeserializer);
            }
        }
        return cFResponseDataArray;
    }
}

