/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sLastPairedBtDevicesSerializer {
    public static void putOptionalsLastPairedBtDevices(ISerializer iSerializer, sLastPairedBtDevices sLastPairedBtDevices2) {
        boolean bl = sLastPairedBtDevices2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sLastPairedBtDevices2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sLastPairedBtDevices2.getWhichLastPaired();
            iSerializer.putUInt8(s);
            long l2 = sLastPairedBtDevices2.getDeviceAdress();
            iSerializer.putUInt64(l2);
            String string = sLastPairedBtDevices2.getDeviceName();
            iSerializer.putOptionalString(string);
            String string2 = sLastPairedBtDevices2.getBtSupplierName();
            iSerializer.putOptionalString(string2);
            String string3 = sLastPairedBtDevices2.getBtModel();
            iSerializer.putOptionalString(string3);
            String string4 = sLastPairedBtDevices2.getBtSoftwareVersion();
            iSerializer.putOptionalString(string4);
            int[] nArray = sLastPairedBtDevices2.getBtProfilesVersion();
            iSerializer.putOptionalUInt16VarArray(nArray);
        }
    }

    public static void putOptionalsLastPairedBtDevicesVarArray(ISerializer iSerializer, sLastPairedBtDevices[] sLastPairedBtDevicesArray) {
        boolean bl = sLastPairedBtDevicesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sLastPairedBtDevicesArray.length);
            for (int i2 = 0; i2 < sLastPairedBtDevicesArray.length; ++i2) {
                sLastPairedBtDevicesSerializer.putOptionalsLastPairedBtDevices(iSerializer, sLastPairedBtDevicesArray[i2]);
            }
        }
    }

    public static sLastPairedBtDevices getOptionalsLastPairedBtDevices(IDeserializer iDeserializer) {
        sLastPairedBtDevices sLastPairedBtDevices2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            long l;
            short s;
            long l2;
            sLastPairedBtDevices2 = new sLastPairedBtDevices();
            sLastPairedBtDevices2.msg_id = l2 = iDeserializer.getUInt32();
            sLastPairedBtDevices2.whichLastPaired = s = iDeserializer.getUInt8();
            sLastPairedBtDevices2.deviceAdress = l = iDeserializer.getUInt64();
            sLastPairedBtDevices2.deviceName = string4 = iDeserializer.getOptionalString();
            sLastPairedBtDevices2.btSupplierName = string3 = iDeserializer.getOptionalString();
            sLastPairedBtDevices2.btModel = string2 = iDeserializer.getOptionalString();
            sLastPairedBtDevices2.btSoftwareVersion = string = iDeserializer.getOptionalString();
            int[] nArray = iDeserializer.getOptionalUInt16VarArray();
            sLastPairedBtDevices2.btProfilesVersion = nArray;
        }
        return sLastPairedBtDevices2;
    }

    public static sLastPairedBtDevices[] getOptionalsLastPairedBtDevicesVarArray(IDeserializer iDeserializer) {
        sLastPairedBtDevices[] sLastPairedBtDevicesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sLastPairedBtDevicesArray = new sLastPairedBtDevices[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sLastPairedBtDevicesArray[i2] = sLastPairedBtDevicesSerializer.getOptionalsLastPairedBtDevices(iDeserializer);
            }
        }
        return sLastPairedBtDevicesArray;
    }
}

