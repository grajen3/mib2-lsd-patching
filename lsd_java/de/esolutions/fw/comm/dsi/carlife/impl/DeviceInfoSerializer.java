/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.DeviceInfo;

public class DeviceInfoSerializer {
    public static void putOptionalDeviceInfo(ISerializer iSerializer, DeviceInfo deviceInfo) {
        boolean bl = deviceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = deviceInfo.getOs();
            iSerializer.putOptionalString(string);
            String string2 = deviceInfo.getBoard();
            iSerializer.putOptionalString(string2);
            String string3 = deviceInfo.getBootloader();
            iSerializer.putOptionalString(string3);
            String string4 = deviceInfo.getBrand();
            iSerializer.putOptionalString(string4);
            String string5 = deviceInfo.getCpuAbi();
            iSerializer.putOptionalString(string5);
            String string6 = deviceInfo.getCpuAbi2();
            iSerializer.putOptionalString(string6);
            String string7 = deviceInfo.getDevice();
            iSerializer.putOptionalString(string7);
            String string8 = deviceInfo.getDisplay();
            iSerializer.putOptionalString(string8);
            String string9 = deviceInfo.getFingerprint();
            iSerializer.putOptionalString(string9);
            String string10 = deviceInfo.getHardware();
            iSerializer.putOptionalString(string10);
            String string11 = deviceInfo.getHost();
            iSerializer.putOptionalString(string11);
            String string12 = deviceInfo.getCid();
            iSerializer.putOptionalString(string12);
            String string13 = deviceInfo.getManufacturer();
            iSerializer.putOptionalString(string13);
            String string14 = deviceInfo.getModel();
            iSerializer.putOptionalString(string14);
            String string15 = deviceInfo.getProduct();
            iSerializer.putOptionalString(string15);
            String string16 = deviceInfo.getSerial();
            iSerializer.putOptionalString(string16);
            String string17 = deviceInfo.getCodename();
            iSerializer.putOptionalString(string17);
            String string18 = deviceInfo.getIncremental();
            iSerializer.putOptionalString(string18);
            String string19 = deviceInfo.getRelease();
            iSerializer.putOptionalString(string19);
            String string20 = deviceInfo.getSdk();
            iSerializer.putOptionalString(string20);
            String string21 = deviceInfo.getSdkInt();
            iSerializer.putOptionalString(string21);
            String string22 = deviceInfo.getToken();
            iSerializer.putOptionalString(string22);
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
            String string7;
            String string8;
            String string9;
            String string10;
            String string11;
            String string12;
            String string13;
            String string14;
            String string15;
            String string16;
            String string17;
            String string18;
            String string19;
            String string20;
            String string21;
            String string22;
            deviceInfo = new DeviceInfo();
            deviceInfo.os = string22 = iDeserializer.getOptionalString();
            deviceInfo.board = string21 = iDeserializer.getOptionalString();
            deviceInfo.bootloader = string20 = iDeserializer.getOptionalString();
            deviceInfo.brand = string19 = iDeserializer.getOptionalString();
            deviceInfo.cpuAbi = string18 = iDeserializer.getOptionalString();
            deviceInfo.cpuAbi2 = string17 = iDeserializer.getOptionalString();
            deviceInfo.device = string16 = iDeserializer.getOptionalString();
            deviceInfo.display = string15 = iDeserializer.getOptionalString();
            deviceInfo.fingerprint = string14 = iDeserializer.getOptionalString();
            deviceInfo.hardware = string13 = iDeserializer.getOptionalString();
            deviceInfo.host = string12 = iDeserializer.getOptionalString();
            deviceInfo.cid = string11 = iDeserializer.getOptionalString();
            deviceInfo.manufacturer = string10 = iDeserializer.getOptionalString();
            deviceInfo.model = string9 = iDeserializer.getOptionalString();
            deviceInfo.product = string8 = iDeserializer.getOptionalString();
            deviceInfo.serial = string7 = iDeserializer.getOptionalString();
            deviceInfo.codename = string6 = iDeserializer.getOptionalString();
            deviceInfo.incremental = string5 = iDeserializer.getOptionalString();
            deviceInfo.release = string4 = iDeserializer.getOptionalString();
            deviceInfo.sdk = string3 = iDeserializer.getOptionalString();
            deviceInfo.sdkInt = string2 = iDeserializer.getOptionalString();
            deviceInfo.token = string = iDeserializer.getOptionalString();
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

