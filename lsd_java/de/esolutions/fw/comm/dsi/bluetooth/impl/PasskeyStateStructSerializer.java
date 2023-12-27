/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;

public class PasskeyStateStructSerializer {
    public static void putOptionalPasskeyStateStruct(ISerializer iSerializer, PasskeyStateStruct passkeyStateStruct) {
        boolean bl = passkeyStateStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = passkeyStateStruct.getBtPasskeyState();
            iSerializer.putInt32(n);
            String string = passkeyStateStruct.getBtDeviceName();
            iSerializer.putOptionalString(string);
            String string2 = passkeyStateStruct.getBtDeviceAddress();
            iSerializer.putOptionalString(string2);
            String string3 = passkeyStateStruct.getBtPasskey();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalPasskeyStateStructVarArray(ISerializer iSerializer, PasskeyStateStruct[] passkeyStateStructArray) {
        boolean bl = passkeyStateStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(passkeyStateStructArray.length);
            for (int i2 = 0; i2 < passkeyStateStructArray.length; ++i2) {
                PasskeyStateStructSerializer.putOptionalPasskeyStateStruct(iSerializer, passkeyStateStructArray[i2]);
            }
        }
    }

    public static PasskeyStateStruct getOptionalPasskeyStateStruct(IDeserializer iDeserializer) {
        PasskeyStateStruct passkeyStateStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            int n;
            passkeyStateStruct = new PasskeyStateStruct();
            passkeyStateStruct.btPasskeyState = n = iDeserializer.getInt32();
            passkeyStateStruct.btDeviceName = string3 = iDeserializer.getOptionalString();
            passkeyStateStruct.btDeviceAddress = string2 = iDeserializer.getOptionalString();
            passkeyStateStruct.btPasskey = string = iDeserializer.getOptionalString();
        }
        return passkeyStateStruct;
    }

    public static PasskeyStateStruct[] getOptionalPasskeyStateStructVarArray(IDeserializer iDeserializer) {
        PasskeyStateStruct[] passkeyStateStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            passkeyStateStructArray = new PasskeyStateStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                passkeyStateStructArray[i2] = PasskeyStateStructSerializer.getOptionalPasskeyStateStruct(iDeserializer);
            }
        }
        return passkeyStateStructArray;
    }
}

