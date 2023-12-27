/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sBluetoothStateSerializer {
    public static void putOptionalsBluetoothState(ISerializer iSerializer, sBluetoothState sBluetoothState2) {
        boolean bl = sBluetoothState2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sBluetoothState2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sBluetoothState2.getBtAccessMode();
            iSerializer.putEnum(n);
            int n2 = sBluetoothState2.getBtOnOff();
            iSerializer.putEnum(n2);
        }
    }

    public static void putOptionalsBluetoothStateVarArray(ISerializer iSerializer, sBluetoothState[] sBluetoothStateArray) {
        boolean bl = sBluetoothStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sBluetoothStateArray.length);
            for (int i2 = 0; i2 < sBluetoothStateArray.length; ++i2) {
                sBluetoothStateSerializer.putOptionalsBluetoothState(iSerializer, sBluetoothStateArray[i2]);
            }
        }
    }

    public static sBluetoothState getOptionalsBluetoothState(IDeserializer iDeserializer) {
        sBluetoothState sBluetoothState2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            sBluetoothState2 = new sBluetoothState();
            sBluetoothState2.msg_id = l = iDeserializer.getUInt32();
            sBluetoothState2.btAccessMode = n2 = iDeserializer.getEnum();
            sBluetoothState2.btOnOff = n = iDeserializer.getEnum();
        }
        return sBluetoothState2;
    }

    public static sBluetoothState[] getOptionalsBluetoothStateVarArray(IDeserializer iDeserializer) {
        sBluetoothState[] sBluetoothStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sBluetoothStateArray = new sBluetoothState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sBluetoothStateArray[i2] = sBluetoothStateSerializer.getOptionalsBluetoothState(iDeserializer);
            }
        }
        return sBluetoothStateArray;
    }
}

