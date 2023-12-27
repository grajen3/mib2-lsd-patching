/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sBluetoothDeviceNameSerializer {
    public static void putOptionalsBluetoothDeviceName(ISerializer iSerializer, sBluetoothDeviceName sBluetoothDeviceName2) {
        boolean bl = sBluetoothDeviceName2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sBluetoothDeviceName2.getMac();
            iSerializer.putUInt64(l);
            String string = sBluetoothDeviceName2.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsBluetoothDeviceNameVarArray(ISerializer iSerializer, sBluetoothDeviceName[] sBluetoothDeviceNameArray) {
        boolean bl = sBluetoothDeviceNameArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sBluetoothDeviceNameArray.length);
            for (int i2 = 0; i2 < sBluetoothDeviceNameArray.length; ++i2) {
                sBluetoothDeviceNameSerializer.putOptionalsBluetoothDeviceName(iSerializer, sBluetoothDeviceNameArray[i2]);
            }
        }
    }

    public static sBluetoothDeviceName getOptionalsBluetoothDeviceName(IDeserializer iDeserializer) {
        sBluetoothDeviceName sBluetoothDeviceName2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sBluetoothDeviceName2 = new sBluetoothDeviceName();
            sBluetoothDeviceName2.mac = l = iDeserializer.getUInt64();
            sBluetoothDeviceName2.name = string = iDeserializer.getOptionalString();
        }
        return sBluetoothDeviceName2;
    }

    public static sBluetoothDeviceName[] getOptionalsBluetoothDeviceNameVarArray(IDeserializer iDeserializer) {
        sBluetoothDeviceName[] sBluetoothDeviceNameArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sBluetoothDeviceNameArray = new sBluetoothDeviceName[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sBluetoothDeviceNameArray[i2] = sBluetoothDeviceNameSerializer.getOptionalsBluetoothDeviceName(iDeserializer);
            }
        }
        return sBluetoothDeviceNameArray;
    }
}

