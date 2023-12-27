/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sUsbOvercurrentSerializer {
    public static void putOptionalsUsbOvercurrent(ISerializer iSerializer, sUsbOvercurrent sUsbOvercurrent2) {
        boolean bl = sUsbOvercurrent2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sUsbOvercurrent2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sUsbOvercurrent2.getState();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsUsbOvercurrentVarArray(ISerializer iSerializer, sUsbOvercurrent[] sUsbOvercurrentArray) {
        boolean bl = sUsbOvercurrentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sUsbOvercurrentArray.length);
            for (int i2 = 0; i2 < sUsbOvercurrentArray.length; ++i2) {
                sUsbOvercurrentSerializer.putOptionalsUsbOvercurrent(iSerializer, sUsbOvercurrentArray[i2]);
            }
        }
    }

    public static sUsbOvercurrent getOptionalsUsbOvercurrent(IDeserializer iDeserializer) {
        sUsbOvercurrent sUsbOvercurrent2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            sUsbOvercurrent2 = new sUsbOvercurrent();
            sUsbOvercurrent2.msg_id = l = iDeserializer.getUInt32();
            sUsbOvercurrent2.state = n = iDeserializer.getEnum();
        }
        return sUsbOvercurrent2;
    }

    public static sUsbOvercurrent[] getOptionalsUsbOvercurrentVarArray(IDeserializer iDeserializer) {
        sUsbOvercurrent[] sUsbOvercurrentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sUsbOvercurrentArray = new sUsbOvercurrent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sUsbOvercurrentArray[i2] = sUsbOvercurrentSerializer.getOptionalsUsbOvercurrent(iDeserializer);
            }
        }
        return sUsbOvercurrentArray;
    }
}

