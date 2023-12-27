/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sBluetoothDevicesSerializer {
    public static void putOptionalsBluetoothDevices(ISerializer iSerializer, sBluetoothDevices sBluetoothDevices2) {
        boolean bl = sBluetoothDevices2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sBluetoothDevices2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sBluetoothDevices2.getScannedDevices();
            iSerializer.putUInt8(s);
            short s2 = sBluetoothDevices2.getPairedDevices();
            iSerializer.putUInt8(s2);
            short s3 = sBluetoothDevices2.getConnectedDevices();
            iSerializer.putUInt8(s3);
        }
    }

    public static void putOptionalsBluetoothDevicesVarArray(ISerializer iSerializer, sBluetoothDevices[] sBluetoothDevicesArray) {
        boolean bl = sBluetoothDevicesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sBluetoothDevicesArray.length);
            for (int i2 = 0; i2 < sBluetoothDevicesArray.length; ++i2) {
                sBluetoothDevicesSerializer.putOptionalsBluetoothDevices(iSerializer, sBluetoothDevicesArray[i2]);
            }
        }
    }

    public static sBluetoothDevices getOptionalsBluetoothDevices(IDeserializer iDeserializer) {
        sBluetoothDevices sBluetoothDevices2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            long l;
            sBluetoothDevices2 = new sBluetoothDevices();
            sBluetoothDevices2.msg_id = l = iDeserializer.getUInt32();
            sBluetoothDevices2.scannedDevices = s3 = iDeserializer.getUInt8();
            sBluetoothDevices2.pairedDevices = s2 = iDeserializer.getUInt8();
            sBluetoothDevices2.connectedDevices = s = iDeserializer.getUInt8();
        }
        return sBluetoothDevices2;
    }

    public static sBluetoothDevices[] getOptionalsBluetoothDevicesVarArray(IDeserializer iDeserializer) {
        sBluetoothDevices[] sBluetoothDevicesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sBluetoothDevicesArray = new sBluetoothDevices[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sBluetoothDevicesArray[i2] = sBluetoothDevicesSerializer.getOptionalsBluetoothDevices(iDeserializer);
            }
        }
        return sBluetoothDevicesArray;
    }
}

