/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sSerialNumberSerializer {
    public static void putOptionalsSerialNumber(ISerializer iSerializer, sSerialNumber sSerialNumber2) {
        boolean bl = sSerialNumber2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSerialNumber2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sSerialNumber2.getNumber();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsSerialNumberVarArray(ISerializer iSerializer, sSerialNumber[] sSerialNumberArray) {
        boolean bl = sSerialNumberArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSerialNumberArray.length);
            for (int i2 = 0; i2 < sSerialNumberArray.length; ++i2) {
                sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, sSerialNumberArray[i2]);
            }
        }
    }

    public static sSerialNumber getOptionalsSerialNumber(IDeserializer iDeserializer) {
        sSerialNumber sSerialNumber2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sSerialNumber2 = new sSerialNumber();
            sSerialNumber2.msg_id = l = iDeserializer.getUInt32();
            sSerialNumber2.number = string = iDeserializer.getOptionalString();
        }
        return sSerialNumber2;
    }

    public static sSerialNumber[] getOptionalsSerialNumberVarArray(IDeserializer iDeserializer) {
        sSerialNumber[] sSerialNumberArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSerialNumberArray = new sSerialNumber[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSerialNumberArray[i2] = sSerialNumberSerializer.getOptionalsSerialNumber(iDeserializer);
            }
        }
        return sSerialNumberArray;
    }
}

