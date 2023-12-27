/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class TrustedDeviceSerializer {
    public static void putOptionalTrustedDevice(ISerializer iSerializer, TrustedDevice trustedDevice) {
        boolean bl = trustedDevice == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = trustedDevice.getDeviceName();
            iSerializer.putOptionalString(string);
            String string2 = trustedDevice.getDeviceAddress();
            iSerializer.putOptionalString(string2);
            int n = trustedDevice.getDeviceRole();
            iSerializer.putInt32(n);
            int n2 = trustedDevice.getDeviceClass();
            iSerializer.putInt32(n2);
            int n3 = trustedDevice.getDeviceSecurity();
            iSerializer.putInt32(n3);
            int n4 = trustedDevice.getLinkMode();
            iSerializer.putInt32(n4);
            int n5 = trustedDevice.getLinkkeyStrength();
            iSerializer.putInt32(n5);
            int n6 = trustedDevice.getLastConnectedServiceTypes();
            iSerializer.putInt32(n6);
            int n7 = trustedDevice.getActiveServiceTypes();
            iSerializer.putInt32(n7);
            int n8 = trustedDevice.getOfferedServiceTypes();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalTrustedDeviceVarArray(ISerializer iSerializer, TrustedDevice[] trustedDeviceArray) {
        boolean bl = trustedDeviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trustedDeviceArray.length);
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                TrustedDeviceSerializer.putOptionalTrustedDevice(iSerializer, trustedDeviceArray[i2]);
            }
        }
    }

    public static TrustedDevice getOptionalTrustedDevice(IDeserializer iDeserializer) {
        TrustedDevice trustedDevice = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            String string;
            String string2;
            trustedDevice = new TrustedDevice();
            trustedDevice.deviceName = string2 = iDeserializer.getOptionalString();
            trustedDevice.deviceAddress = string = iDeserializer.getOptionalString();
            trustedDevice.deviceRole = n8 = iDeserializer.getInt32();
            trustedDevice.deviceClass = n7 = iDeserializer.getInt32();
            trustedDevice.deviceSecurity = n6 = iDeserializer.getInt32();
            trustedDevice.linkMode = n5 = iDeserializer.getInt32();
            trustedDevice.linkkeyStrength = n4 = iDeserializer.getInt32();
            trustedDevice.lastConnectedServiceTypes = n3 = iDeserializer.getInt32();
            trustedDevice.activeServiceTypes = n2 = iDeserializer.getInt32();
            trustedDevice.offeredServiceTypes = n = iDeserializer.getInt32();
        }
        return trustedDevice;
    }

    public static TrustedDevice[] getOptionalTrustedDeviceVarArray(IDeserializer iDeserializer) {
        TrustedDevice[] trustedDeviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trustedDeviceArray = new TrustedDevice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trustedDeviceArray[i2] = TrustedDeviceSerializer.getOptionalTrustedDevice(iDeserializer);
            }
        }
        return trustedDeviceArray;
    }
}

