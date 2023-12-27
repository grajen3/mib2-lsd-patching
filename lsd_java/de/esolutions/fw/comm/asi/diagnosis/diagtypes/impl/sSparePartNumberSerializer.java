/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sSparePartNumberSerializer {
    public static void putOptionalsSparePartNumber(ISerializer iSerializer, sSparePartNumber sSparePartNumber2) {
        boolean bl = sSparePartNumber2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSparePartNumber2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sSparePartNumber2.getNumber();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsSparePartNumberVarArray(ISerializer iSerializer, sSparePartNumber[] sSparePartNumberArray) {
        boolean bl = sSparePartNumberArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSparePartNumberArray.length);
            for (int i2 = 0; i2 < sSparePartNumberArray.length; ++i2) {
                sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, sSparePartNumberArray[i2]);
            }
        }
    }

    public static sSparePartNumber getOptionalsSparePartNumber(IDeserializer iDeserializer) {
        sSparePartNumber sSparePartNumber2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sSparePartNumber2 = new sSparePartNumber();
            sSparePartNumber2.msg_id = l = iDeserializer.getUInt32();
            sSparePartNumber2.number = string = iDeserializer.getOptionalString();
        }
        return sSparePartNumber2;
    }

    public static sSparePartNumber[] getOptionalsSparePartNumberVarArray(IDeserializer iDeserializer) {
        sSparePartNumber[] sSparePartNumberArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSparePartNumberArray = new sSparePartNumber[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSparePartNumberArray[i2] = sSparePartNumberSerializer.getOptionalsSparePartNumber(iDeserializer);
            }
        }
        return sSparePartNumberArray;
    }
}

