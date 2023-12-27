/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.ReconnectInfo;

public class ReconnectInfoSerializer {
    public static void putOptionalReconnectInfo(ISerializer iSerializer, ReconnectInfo reconnectInfo) {
        boolean bl = reconnectInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = reconnectInfo.getReconnectIndicator();
            iSerializer.putInt32(n);
            String[] stringArray = reconnectInfo.getDeviceNameList();
            iSerializer.putOptionalStringVarArray(stringArray);
            int[] nArray = reconnectInfo.getServiceTypeList();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalReconnectInfoVarArray(ISerializer iSerializer, ReconnectInfo[] reconnectInfoArray) {
        boolean bl = reconnectInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(reconnectInfoArray.length);
            for (int i2 = 0; i2 < reconnectInfoArray.length; ++i2) {
                ReconnectInfoSerializer.putOptionalReconnectInfo(iSerializer, reconnectInfoArray[i2]);
            }
        }
    }

    public static ReconnectInfo getOptionalReconnectInfo(IDeserializer iDeserializer) {
        ReconnectInfo reconnectInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            reconnectInfo = new ReconnectInfo();
            reconnectInfo.reconnectIndicator = n = iDeserializer.getInt32();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            reconnectInfo.deviceNameList = stringArray;
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            reconnectInfo.serviceTypeList = nArray;
        }
        return reconnectInfo;
    }

    public static ReconnectInfo[] getOptionalReconnectInfoVarArray(IDeserializer iDeserializer) {
        ReconnectInfo[] reconnectInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            reconnectInfoArray = new ReconnectInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                reconnectInfoArray[i2] = ReconnectInfoSerializer.getOptionalReconnectInfo(iDeserializer);
            }
        }
        return reconnectInfoArray;
    }
}

