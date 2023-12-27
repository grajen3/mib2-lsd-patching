/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.smartphoneintegration.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.smartphoneintegration.Device;

public class DeviceSerializer {
    public static void putOptionalDevice(ISerializer iSerializer, Device device) {
        boolean bl = device == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = device.getDeviceID();
            iSerializer.putInt32(n);
            String string = device.getDeviceName();
            iSerializer.putOptionalString(string);
            int n2 = device.getConnectionType();
            iSerializer.putInt32(n2);
            String string2 = device.getDeviceAddress();
            iSerializer.putOptionalString(string2);
            int n3 = device.getConnectionMethod();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalDeviceVarArray(ISerializer iSerializer, Device[] deviceArray) {
        boolean bl = deviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(deviceArray.length);
            for (int i2 = 0; i2 < deviceArray.length; ++i2) {
                DeviceSerializer.putOptionalDevice(iSerializer, deviceArray[i2]);
            }
        }
    }

    public static Device getOptionalDevice(IDeserializer iDeserializer) {
        Device device = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            int n2;
            String string2;
            int n3;
            device = new Device();
            device.deviceID = n3 = iDeserializer.getInt32();
            device.deviceName = string2 = iDeserializer.getOptionalString();
            device.connectionType = n2 = iDeserializer.getInt32();
            device.deviceAddress = string = iDeserializer.getOptionalString();
            device.connectionMethod = n = iDeserializer.getInt32();
        }
        return device;
    }

    public static Device[] getOptionalDeviceVarArray(IDeserializer iDeserializer) {
        Device[] deviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            deviceArray = new Device[n];
            for (int i2 = 0; i2 < n; ++i2) {
                deviceArray[i2] = DeviceSerializer.getOptionalDevice(iDeserializer);
            }
        }
        return deviceArray;
    }
}

