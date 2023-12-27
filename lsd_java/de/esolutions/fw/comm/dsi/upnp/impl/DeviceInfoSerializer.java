/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.upnp.DeviceInfo;

public class DeviceInfoSerializer {
    public static void putOptionalDeviceInfo(ISerializer iSerializer, DeviceInfo deviceInfo) {
        boolean bl = deviceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = deviceInfo.getDeviceName();
            iSerializer.putOptionalString(string);
            String string2 = deviceInfo.getDeviceID();
            iSerializer.putOptionalString(string2);
            int n = deviceInfo.getDeviceType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalDeviceInfoVarArray(ISerializer iSerializer, DeviceInfo[] deviceInfoArray) {
        boolean bl = deviceInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(deviceInfoArray.length);
            for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
                DeviceInfoSerializer.putOptionalDeviceInfo(iSerializer, deviceInfoArray[i2]);
            }
        }
    }

    public static DeviceInfo getOptionalDeviceInfo(IDeserializer iDeserializer) {
        DeviceInfo deviceInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            deviceInfo = new DeviceInfo();
            deviceInfo.deviceName = string2 = iDeserializer.getOptionalString();
            deviceInfo.deviceID = string = iDeserializer.getOptionalString();
            deviceInfo.deviceType = n = iDeserializer.getInt32();
        }
        return deviceInfo;
    }

    public static DeviceInfo[] getOptionalDeviceInfoVarArray(IDeserializer iDeserializer) {
        DeviceInfo[] deviceInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            deviceInfoArray = new DeviceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                deviceInfoArray[i2] = DeviceInfoSerializer.getOptionalDeviceInfo(iDeserializer);
            }
        }
        return deviceInfoArray;
    }
}

