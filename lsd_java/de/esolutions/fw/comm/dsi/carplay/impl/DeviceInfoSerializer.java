/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.DeviceInfo;

public class DeviceInfoSerializer {
    public static void putOptionalDeviceInfo(ISerializer iSerializer, DeviceInfo deviceInfo) {
        boolean bl = deviceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = deviceInfo.getDeviceID();
            iSerializer.putOptionalString(string);
            String string2 = deviceInfo.getDeviceName();
            iSerializer.putOptionalString(string2);
            String string3 = deviceInfo.getDeviceLanguage();
            iSerializer.putOptionalString(string3);
            String string4 = deviceInfo.getOsBuildVersion();
            iSerializer.putOptionalString(string4);
            String string5 = deviceInfo.getAirplayVersion();
            iSerializer.putOptionalString(string5);
            String string6 = deviceInfo.getSessionID();
            iSerializer.putOptionalString(string6);
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
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            deviceInfo = new DeviceInfo();
            deviceInfo.deviceID = string6 = iDeserializer.getOptionalString();
            deviceInfo.deviceName = string5 = iDeserializer.getOptionalString();
            deviceInfo.deviceLanguage = string4 = iDeserializer.getOptionalString();
            deviceInfo.osBuildVersion = string3 = iDeserializer.getOptionalString();
            deviceInfo.airplayVersion = string2 = iDeserializer.getOptionalString();
            deviceInfo.sessionID = string = iDeserializer.getOptionalString();
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

