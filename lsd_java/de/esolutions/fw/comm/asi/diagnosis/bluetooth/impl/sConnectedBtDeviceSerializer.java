/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sConnectedBtDeviceSerializer {
    public static void putOptionalsConnectedBtDevice(ISerializer iSerializer, sConnectedBtDevice sConnectedBtDevice2) {
        boolean bl = sConnectedBtDevice2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sConnectedBtDevice2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sConnectedBtDevice2.getDeviceNumber();
            iSerializer.putUInt8(s);
            short s2 = sConnectedBtDevice2.getFieldStrengthRSSI();
            iSerializer.putUInt8(s2);
            String string = sConnectedBtDevice2.getDeviceName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsConnectedBtDeviceVarArray(ISerializer iSerializer, sConnectedBtDevice[] sConnectedBtDeviceArray) {
        boolean bl = sConnectedBtDeviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sConnectedBtDeviceArray.length);
            for (int i2 = 0; i2 < sConnectedBtDeviceArray.length; ++i2) {
                sConnectedBtDeviceSerializer.putOptionalsConnectedBtDevice(iSerializer, sConnectedBtDeviceArray[i2]);
            }
        }
    }

    public static sConnectedBtDevice getOptionalsConnectedBtDevice(IDeserializer iDeserializer) {
        sConnectedBtDevice sConnectedBtDevice2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            short s;
            short s2;
            long l;
            sConnectedBtDevice2 = new sConnectedBtDevice();
            sConnectedBtDevice2.msg_id = l = iDeserializer.getUInt32();
            sConnectedBtDevice2.deviceNumber = s2 = iDeserializer.getUInt8();
            sConnectedBtDevice2.fieldStrengthRSSI = s = iDeserializer.getUInt8();
            sConnectedBtDevice2.deviceName = string = iDeserializer.getOptionalString();
        }
        return sConnectedBtDevice2;
    }

    public static sConnectedBtDevice[] getOptionalsConnectedBtDeviceVarArray(IDeserializer iDeserializer) {
        sConnectedBtDevice[] sConnectedBtDeviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sConnectedBtDeviceArray = new sConnectedBtDevice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sConnectedBtDeviceArray[i2] = sConnectedBtDeviceSerializer.getOptionalsConnectedBtDevice(iDeserializer);
            }
        }
        return sConnectedBtDeviceArray;
    }
}

