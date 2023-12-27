/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sConnectedBtDevicesSerializer {
    public static void putOptionalsConnectedBtDevices(ISerializer iSerializer, sConnectedBtDevices sConnectedBtDevices2) {
        boolean bl = sConnectedBtDevices2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sConnectedBtDevices2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sConnectedBtDevices2.getNumberConnectedDevices();
            iSerializer.putUInt8(s);
            long[] lArray = sConnectedBtDevices2.getBtProfiles();
            iSerializer.putOptionalUInt32VarArray(lArray);
            String[] stringArray = sConnectedBtDevices2.getDeviceName();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalsConnectedBtDevicesVarArray(ISerializer iSerializer, sConnectedBtDevices[] sConnectedBtDevicesArray) {
        boolean bl = sConnectedBtDevicesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sConnectedBtDevicesArray.length);
            for (int i2 = 0; i2 < sConnectedBtDevicesArray.length; ++i2) {
                sConnectedBtDevicesSerializer.putOptionalsConnectedBtDevices(iSerializer, sConnectedBtDevicesArray[i2]);
            }
        }
    }

    public static sConnectedBtDevices getOptionalsConnectedBtDevices(IDeserializer iDeserializer) {
        sConnectedBtDevices sConnectedBtDevices2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            sConnectedBtDevices2 = new sConnectedBtDevices();
            sConnectedBtDevices2.msg_id = l = iDeserializer.getUInt32();
            sConnectedBtDevices2.numberConnectedDevices = s = iDeserializer.getUInt8();
            long[] lArray = iDeserializer.getOptionalUInt32VarArray();
            sConnectedBtDevices2.btProfiles = lArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            sConnectedBtDevices2.deviceName = stringArray;
        }
        return sConnectedBtDevices2;
    }

    public static sConnectedBtDevices[] getOptionalsConnectedBtDevicesVarArray(IDeserializer iDeserializer) {
        sConnectedBtDevices[] sConnectedBtDevicesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sConnectedBtDevicesArray = new sConnectedBtDevices[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sConnectedBtDevicesArray[i2] = sConnectedBtDevicesSerializer.getOptionalsConnectedBtDevices(iDeserializer);
            }
        }
        return sConnectedBtDevicesArray;
    }
}

