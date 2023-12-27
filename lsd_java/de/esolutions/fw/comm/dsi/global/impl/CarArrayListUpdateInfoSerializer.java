/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class CarArrayListUpdateInfoSerializer {
    public static void putOptionalCarArrayListUpdateInfo(ISerializer iSerializer, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        boolean bl = carArrayListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carArrayListUpdateInfo.getAsgID();
            iSerializer.putInt32(n);
            int n2 = carArrayListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n2);
            int n3 = carArrayListUpdateInfo.getRecordContent();
            iSerializer.putInt32(n3);
            int n4 = carArrayListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n4);
            int n5 = carArrayListUpdateInfo.getStartElement();
            iSerializer.putInt32(n5);
            int n6 = carArrayListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalCarArrayListUpdateInfoVarArray(ISerializer iSerializer, CarArrayListUpdateInfo[] carArrayListUpdateInfoArray) {
        boolean bl = carArrayListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carArrayListUpdateInfoArray.length);
            for (int i2 = 0; i2 < carArrayListUpdateInfoArray.length; ++i2) {
                CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, carArrayListUpdateInfoArray[i2]);
            }
        }
    }

    public static CarArrayListUpdateInfo getOptionalCarArrayListUpdateInfo(IDeserializer iDeserializer) {
        CarArrayListUpdateInfo carArrayListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            carArrayListUpdateInfo = new CarArrayListUpdateInfo();
            carArrayListUpdateInfo.asgID = n6 = iDeserializer.getInt32();
            carArrayListUpdateInfo.transactionID = n5 = iDeserializer.getInt32();
            carArrayListUpdateInfo.recordContent = n4 = iDeserializer.getInt32();
            carArrayListUpdateInfo.arrayContent = n3 = iDeserializer.getInt32();
            carArrayListUpdateInfo.startElement = n2 = iDeserializer.getInt32();
            carArrayListUpdateInfo.numOfElements = n = iDeserializer.getInt32();
        }
        return carArrayListUpdateInfo;
    }

    public static CarArrayListUpdateInfo[] getOptionalCarArrayListUpdateInfoVarArray(IDeserializer iDeserializer) {
        CarArrayListUpdateInfo[] carArrayListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carArrayListUpdateInfoArray = new CarArrayListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carArrayListUpdateInfoArray[i2] = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
            }
        }
        return carArrayListUpdateInfoArray;
    }
}

