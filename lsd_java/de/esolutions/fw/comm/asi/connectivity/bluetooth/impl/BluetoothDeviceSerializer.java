/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class BluetoothDeviceSerializer {
    public static void putOptionalBluetoothDevice(ISerializer iSerializer, BluetoothDevice bluetoothDevice) {
        boolean bl = bluetoothDevice == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = bluetoothDevice.getName();
            iSerializer.putOptionalString(string);
            long l = bluetoothDevice.getAddress();
            iSerializer.putInt64(l);
            boolean bl2 = bluetoothDevice.isConnected();
            iSerializer.putBool(bl2);
            boolean bl3 = bluetoothDevice.isKnownAtStartup();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBluetoothDeviceVarArray(ISerializer iSerializer, BluetoothDevice[] bluetoothDeviceArray) {
        boolean bl = bluetoothDeviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bluetoothDeviceArray.length);
            for (int i2 = 0; i2 < bluetoothDeviceArray.length; ++i2) {
                BluetoothDeviceSerializer.putOptionalBluetoothDevice(iSerializer, bluetoothDeviceArray[i2]);
            }
        }
    }

    public static BluetoothDevice getOptionalBluetoothDevice(IDeserializer iDeserializer) {
        BluetoothDevice bluetoothDevice = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            long l;
            String string;
            bluetoothDevice = new BluetoothDevice();
            bluetoothDevice.name = string = iDeserializer.getOptionalString();
            bluetoothDevice.address = l = iDeserializer.getInt64();
            bluetoothDevice.connected = bl3 = iDeserializer.getBool();
            bluetoothDevice.knownAtStartup = bl2 = iDeserializer.getBool();
        }
        return bluetoothDevice;
    }

    public static BluetoothDevice[] getOptionalBluetoothDeviceVarArray(IDeserializer iDeserializer) {
        BluetoothDevice[] bluetoothDeviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bluetoothDeviceArray = new BluetoothDevice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bluetoothDeviceArray[i2] = BluetoothDeviceSerializer.getOptionalBluetoothDevice(iDeserializer);
            }
        }
        return bluetoothDeviceArray;
    }
}

