/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sBluetoothMACSerializer {
    public static void putOptionalsBluetoothMAC(ISerializer iSerializer, sBluetoothMAC sBluetoothMAC2) {
        boolean bl = sBluetoothMAC2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sBluetoothMAC2.getMsg_id();
            iSerializer.putUInt32(l);
            long l2 = sBluetoothMAC2.getMac();
            iSerializer.putUInt64(l2);
        }
    }

    public static void putOptionalsBluetoothMACVarArray(ISerializer iSerializer, sBluetoothMAC[] sBluetoothMACArray) {
        boolean bl = sBluetoothMACArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sBluetoothMACArray.length);
            for (int i2 = 0; i2 < sBluetoothMACArray.length; ++i2) {
                sBluetoothMACSerializer.putOptionalsBluetoothMAC(iSerializer, sBluetoothMACArray[i2]);
            }
        }
    }

    public static sBluetoothMAC getOptionalsBluetoothMAC(IDeserializer iDeserializer) {
        sBluetoothMAC sBluetoothMAC2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            sBluetoothMAC2 = new sBluetoothMAC();
            sBluetoothMAC2.msg_id = l2 = iDeserializer.getUInt32();
            sBluetoothMAC2.mac = l = iDeserializer.getUInt64();
        }
        return sBluetoothMAC2;
    }

    public static sBluetoothMAC[] getOptionalsBluetoothMACVarArray(IDeserializer iDeserializer) {
        sBluetoothMAC[] sBluetoothMACArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sBluetoothMACArray = new sBluetoothMAC[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sBluetoothMACArray[i2] = sBluetoothMACSerializer.getOptionalsBluetoothMAC(iDeserializer);
            }
        }
        return sBluetoothMACArray;
    }
}

