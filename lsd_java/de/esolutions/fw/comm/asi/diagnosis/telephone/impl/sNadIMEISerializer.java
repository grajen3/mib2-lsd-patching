/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sNadIMEISerializer {
    public static void putOptionalsNadIMEI(ISerializer iSerializer, sNadIMEI sNadIMEI2) {
        boolean bl = sNadIMEI2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sNadIMEI2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sNadIMEI2.getNadIMEI();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsNadIMEIVarArray(ISerializer iSerializer, sNadIMEI[] sNadIMEIArray) {
        boolean bl = sNadIMEIArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNadIMEIArray.length);
            for (int i2 = 0; i2 < sNadIMEIArray.length; ++i2) {
                sNadIMEISerializer.putOptionalsNadIMEI(iSerializer, sNadIMEIArray[i2]);
            }
        }
    }

    public static sNadIMEI getOptionalsNadIMEI(IDeserializer iDeserializer) {
        sNadIMEI sNadIMEI2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sNadIMEI2 = new sNadIMEI();
            sNadIMEI2.msg_id = l = iDeserializer.getUInt32();
            sNadIMEI2.nadIMEI = string = iDeserializer.getOptionalString();
        }
        return sNadIMEI2;
    }

    public static sNadIMEI[] getOptionalsNadIMEIVarArray(IDeserializer iDeserializer) {
        sNadIMEI[] sNadIMEIArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNadIMEIArray = new sNadIMEI[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNadIMEIArray[i2] = sNadIMEISerializer.getOptionalsNadIMEI(iDeserializer);
            }
        }
        return sNadIMEIArray;
    }
}

