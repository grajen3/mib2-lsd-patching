/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.OSRPersonalIdentifierSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRPersonalIdentifier;

public class OSRDeviceSerializer {
    public static void putOptionalOSRDevice(ISerializer iSerializer, OSRDevice oSRDevice) {
        boolean bl = oSRDevice == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRDevice.getName();
            iSerializer.putOptionalString(string);
            OSRPersonalIdentifier oSRPersonalIdentifier = oSRDevice.getPIdentifier();
            OSRPersonalIdentifierSerializer.putOptionalOSRPersonalIdentifier(iSerializer, oSRPersonalIdentifier);
            int n = oSRDevice.getConnectionState();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalOSRDeviceVarArray(ISerializer iSerializer, OSRDevice[] oSRDeviceArray) {
        boolean bl = oSRDeviceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRDeviceArray.length);
            for (int i2 = 0; i2 < oSRDeviceArray.length; ++i2) {
                OSRDeviceSerializer.putOptionalOSRDevice(iSerializer, oSRDeviceArray[i2]);
            }
        }
    }

    public static OSRDevice getOptionalOSRDevice(IDeserializer iDeserializer) {
        OSRDevice oSRDevice = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            OSRPersonalIdentifier oSRPersonalIdentifier;
            String string;
            oSRDevice = new OSRDevice();
            oSRDevice.name = string = iDeserializer.getOptionalString();
            oSRDevice.pIdentifier = oSRPersonalIdentifier = OSRPersonalIdentifierSerializer.getOptionalOSRPersonalIdentifier(iDeserializer);
            oSRDevice.connectionState = n = iDeserializer.getInt32();
        }
        return oSRDevice;
    }

    public static OSRDevice[] getOptionalOSRDeviceVarArray(IDeserializer iDeserializer) {
        OSRDevice[] oSRDeviceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRDeviceArray = new OSRDevice[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRDeviceArray[i2] = OSRDeviceSerializer.getOptionalOSRDevice(iDeserializer);
            }
        }
        return oSRDeviceArray;
    }
}

