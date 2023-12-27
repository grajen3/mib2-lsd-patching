/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.DeviceInfo;

public class DeviceInfoSerializer {
    public static void putOptionalDeviceInfo(ISerializer iSerializer, DeviceInfo deviceInfo) {
        boolean bl = deviceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = deviceInfo.getDeviceID();
            iSerializer.putInt64(l);
            int n = deviceInfo.getDeviceType();
            iSerializer.putInt32(n);
            int n2 = deviceInfo.getNumSlots();
            iSerializer.putInt32(n2);
            int n3 = deviceInfo.getFlags();
            iSerializer.putInt32(n3);
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
            int n2;
            int n3;
            long l;
            deviceInfo = new DeviceInfo();
            deviceInfo.deviceID = l = iDeserializer.getInt64();
            deviceInfo.deviceType = n3 = iDeserializer.getInt32();
            deviceInfo.numSlots = n2 = iDeserializer.getInt32();
            deviceInfo.flags = n = iDeserializer.getInt32();
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

