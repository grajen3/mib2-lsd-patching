/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sPairedBtDevicesSerializer {
    public static void putOptionalsPairedBtDevices(ISerializer iSerializer, sPairedBtDevices sPairedBtDevices2) {
        boolean bl = sPairedBtDevices2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sPairedBtDevices2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sPairedBtDevices2.getNumberPairedDevices();
            iSerializer.putUInt8(s);
            long[] lArray = sPairedBtDevices2.getBtProfiles();
            iSerializer.putOptionalUInt32VarArray(lArray);
            String[] stringArray = sPairedBtDevices2.getDeviceName();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalsPairedBtDevicesVarArray(ISerializer iSerializer, sPairedBtDevices[] sPairedBtDevicesArray) {
        boolean bl = sPairedBtDevicesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sPairedBtDevicesArray.length);
            for (int i2 = 0; i2 < sPairedBtDevicesArray.length; ++i2) {
                sPairedBtDevicesSerializer.putOptionalsPairedBtDevices(iSerializer, sPairedBtDevicesArray[i2]);
            }
        }
    }

    public static sPairedBtDevices getOptionalsPairedBtDevices(IDeserializer iDeserializer) {
        sPairedBtDevices sPairedBtDevices2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            sPairedBtDevices2 = new sPairedBtDevices();
            sPairedBtDevices2.msg_id = l = iDeserializer.getUInt32();
            sPairedBtDevices2.numberPairedDevices = s = iDeserializer.getUInt8();
            long[] lArray = iDeserializer.getOptionalUInt32VarArray();
            sPairedBtDevices2.btProfiles = lArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            sPairedBtDevices2.deviceName = stringArray;
        }
        return sPairedBtDevices2;
    }

    public static sPairedBtDevices[] getOptionalsPairedBtDevicesVarArray(IDeserializer iDeserializer) {
        sPairedBtDevices[] sPairedBtDevicesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sPairedBtDevicesArray = new sPairedBtDevices[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sPairedBtDevicesArray[i2] = sPairedBtDevicesSerializer.getOptionalsPairedBtDevices(iDeserializer);
            }
        }
        return sPairedBtDevicesArray;
    }
}

