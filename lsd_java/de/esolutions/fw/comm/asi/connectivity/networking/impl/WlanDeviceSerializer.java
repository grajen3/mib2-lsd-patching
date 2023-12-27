/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class WlanDeviceSerializer {
    public static void putOptionalWlanDevice(ISerializer iSerializer, WlanDevice wlanDevice) {
        boolean bl = wlanDevice == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = wlanDevice.getHwaddr();
            iSerializer.putInt64(l);
            String string = wlanDevice.getName();
            iSerializer.putOptionalString(string);
            int n = wlanDevice.getState();
            iSerializer.putEnum(n);
            int n2 = wlanDevice.getWlantype();
            iSerializer.putEnum(n2);
            boolean bl2 = wlanDevice.isKnownAtStartUp();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalWlanDeviceVarArray(ISerializer iSerializer, WlanDevice[] wlanDeviceArray) {
        boolean bl = wlanDeviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wlanDeviceArray.length);
            for (int i2 = 0; i2 < wlanDeviceArray.length; ++i2) {
                WlanDeviceSerializer.putOptionalWlanDevice(iSerializer, wlanDeviceArray[i2]);
            }
        }
    }

    public static WlanDevice getOptionalWlanDevice(IDeserializer iDeserializer) {
        WlanDevice wlanDevice = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            int n2;
            String string;
            long l;
            wlanDevice = new WlanDevice();
            wlanDevice.hwaddr = l = iDeserializer.getInt64();
            wlanDevice.name = string = iDeserializer.getOptionalString();
            wlanDevice.state = n2 = iDeserializer.getEnum();
            wlanDevice.wlantype = n = iDeserializer.getEnum();
            wlanDevice.knownAtStartUp = bl2 = iDeserializer.getBool();
        }
        return wlanDevice;
    }

    public static WlanDevice[] getOptionalWlanDeviceVarArray(IDeserializer iDeserializer) {
        WlanDevice[] wlanDeviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wlanDeviceArray = new WlanDevice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wlanDeviceArray[i2] = WlanDeviceSerializer.getOptionalWlanDevice(iDeserializer);
            }
        }
        return wlanDeviceArray;
    }
}

