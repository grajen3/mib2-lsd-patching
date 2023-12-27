/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

public class DiscoveredDeviceSerializer {
    public static void putOptionalDiscoveredDevice(ISerializer iSerializer, DiscoveredDevice discoveredDevice) {
        boolean bl = discoveredDevice == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = discoveredDevice.getDeviceName();
            iSerializer.putOptionalString(string);
            String string2 = discoveredDevice.getDeviceAddress();
            iSerializer.putOptionalString(string2);
            String string3 = discoveredDevice.getDeviceClass();
            iSerializer.putOptionalString(string3);
            int n = discoveredDevice.getServiceTypes();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalDiscoveredDeviceVarArray(ISerializer iSerializer, DiscoveredDevice[] discoveredDeviceArray) {
        boolean bl = discoveredDeviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(discoveredDeviceArray.length);
            for (int i2 = 0; i2 < discoveredDeviceArray.length; ++i2) {
                DiscoveredDeviceSerializer.putOptionalDiscoveredDevice(iSerializer, discoveredDeviceArray[i2]);
            }
        }
    }

    public static DiscoveredDevice getOptionalDiscoveredDevice(IDeserializer iDeserializer) {
        DiscoveredDevice discoveredDevice = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            String string3;
            discoveredDevice = new DiscoveredDevice();
            discoveredDevice.deviceName = string3 = iDeserializer.getOptionalString();
            discoveredDevice.deviceAddress = string2 = iDeserializer.getOptionalString();
            discoveredDevice.deviceClass = string = iDeserializer.getOptionalString();
            discoveredDevice.serviceTypes = n = iDeserializer.getInt32();
        }
        return discoveredDevice;
    }

    public static DiscoveredDevice[] getOptionalDiscoveredDeviceVarArray(IDeserializer iDeserializer) {
        DiscoveredDevice[] discoveredDeviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            discoveredDeviceArray = new DiscoveredDevice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                discoveredDeviceArray[i2] = DiscoveredDeviceSerializer.getOptionalDiscoveredDevice(iDeserializer);
            }
        }
        return discoveredDeviceArray;
    }
}

