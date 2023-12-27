/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public class StartStopListUpdateInfoSerializer {
    public static void putOptionalStartStopListUpdateInfo(ISerializer iSerializer, StartStopListUpdateInfo startStopListUpdateInfo) {
        boolean bl = startStopListUpdateInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = startStopListUpdateInfo.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = startStopListUpdateInfo.getStartElement();
            iSerializer.putInt32(n2);
            int n3 = startStopListUpdateInfo.getNumOfElements();
            iSerializer.putInt32(n3);
            int n4 = startStopListUpdateInfo.getTransactionID();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalStartStopListUpdateInfoVarArray(ISerializer iSerializer, StartStopListUpdateInfo[] startStopListUpdateInfoArray) {
        boolean bl = startStopListUpdateInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(startStopListUpdateInfoArray.length);
            for (int i2 = 0; i2 < startStopListUpdateInfoArray.length; ++i2) {
                StartStopListUpdateInfoSerializer.putOptionalStartStopListUpdateInfo(iSerializer, startStopListUpdateInfoArray[i2]);
            }
        }
    }

    public static StartStopListUpdateInfo getOptionalStartStopListUpdateInfo(IDeserializer iDeserializer) {
        StartStopListUpdateInfo startStopListUpdateInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            startStopListUpdateInfo = new StartStopListUpdateInfo();
            startStopListUpdateInfo.arrayContent = n4 = iDeserializer.getInt32();
            startStopListUpdateInfo.startElement = n3 = iDeserializer.getInt32();
            startStopListUpdateInfo.numOfElements = n2 = iDeserializer.getInt32();
            startStopListUpdateInfo.transactionID = n = iDeserializer.getInt32();
        }
        return startStopListUpdateInfo;
    }

    public static StartStopListUpdateInfo[] getOptionalStartStopListUpdateInfoVarArray(IDeserializer iDeserializer) {
        StartStopListUpdateInfo[] startStopListUpdateInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            startStopListUpdateInfoArray = new StartStopListUpdateInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                startStopListUpdateInfoArray[i2] = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
            }
        }
        return startStopListUpdateInfoArray;
    }
}

