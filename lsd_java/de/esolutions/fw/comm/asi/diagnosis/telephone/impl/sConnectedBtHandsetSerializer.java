/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sConnectedBtHandsetSerializer {
    public static void putOptionalsConnectedBtHandset(ISerializer iSerializer, sConnectedBtHandset sConnectedBtHandset2) {
        boolean bl = sConnectedBtHandset2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sConnectedBtHandset2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sConnectedBtHandset2.getHandsetNumber();
            iSerializer.putEnum(n);
            short s = sConnectedBtHandset2.getFieldStrengthRSSI();
            iSerializer.putUInt8(s);
            String string = sConnectedBtHandset2.getDeviceName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsConnectedBtHandsetVarArray(ISerializer iSerializer, sConnectedBtHandset[] sConnectedBtHandsetArray) {
        boolean bl = sConnectedBtHandsetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sConnectedBtHandsetArray.length);
            for (int i2 = 0; i2 < sConnectedBtHandsetArray.length; ++i2) {
                sConnectedBtHandsetSerializer.putOptionalsConnectedBtHandset(iSerializer, sConnectedBtHandsetArray[i2]);
            }
        }
    }

    public static sConnectedBtHandset getOptionalsConnectedBtHandset(IDeserializer iDeserializer) {
        sConnectedBtHandset sConnectedBtHandset2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            short s;
            int n;
            long l;
            sConnectedBtHandset2 = new sConnectedBtHandset();
            sConnectedBtHandset2.msg_id = l = iDeserializer.getUInt32();
            sConnectedBtHandset2.handsetNumber = n = iDeserializer.getEnum();
            sConnectedBtHandset2.fieldStrengthRSSI = s = iDeserializer.getUInt8();
            sConnectedBtHandset2.deviceName = string = iDeserializer.getOptionalString();
        }
        return sConnectedBtHandset2;
    }

    public static sConnectedBtHandset[] getOptionalsConnectedBtHandsetVarArray(IDeserializer iDeserializer) {
        sConnectedBtHandset[] sConnectedBtHandsetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sConnectedBtHandsetArray = new sConnectedBtHandset[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sConnectedBtHandsetArray[i2] = sConnectedBtHandsetSerializer.getOptionalsConnectedBtHandset(iDeserializer);
            }
        }
        return sConnectedBtHandsetArray;
    }
}

