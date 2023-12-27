/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sGPSOffroadSerializer {
    public static void putOptionalsGPSOffroad(ISerializer iSerializer, sGPSOffroad sGPSOffroad2) {
        boolean bl = sGPSOffroad2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sGPSOffroad2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sGPSOffroad2.getYear();
            iSerializer.putUInt8(s);
            short s2 = sGPSOffroad2.getMonth();
            iSerializer.putUInt8(s2);
            short s3 = sGPSOffroad2.getDay();
            iSerializer.putUInt8(s3);
            short s4 = sGPSOffroad2.getHour();
            iSerializer.putUInt8(s4);
            short s5 = sGPSOffroad2.getMinute();
            iSerializer.putUInt8(s5);
            short s6 = sGPSOffroad2.getSeconds();
            iSerializer.putUInt8(s6);
        }
    }

    public static void putOptionalsGPSOffroadVarArray(ISerializer iSerializer, sGPSOffroad[] sGPSOffroadArray) {
        boolean bl = sGPSOffroadArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sGPSOffroadArray.length);
            for (int i2 = 0; i2 < sGPSOffroadArray.length; ++i2) {
                sGPSOffroadSerializer.putOptionalsGPSOffroad(iSerializer, sGPSOffroadArray[i2]);
            }
        }
    }

    public static sGPSOffroad getOptionalsGPSOffroad(IDeserializer iDeserializer) {
        sGPSOffroad sGPSOffroad2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            long l;
            sGPSOffroad2 = new sGPSOffroad();
            sGPSOffroad2.msg_id = l = iDeserializer.getUInt32();
            sGPSOffroad2.year = s6 = iDeserializer.getUInt8();
            sGPSOffroad2.month = s5 = iDeserializer.getUInt8();
            sGPSOffroad2.day = s4 = iDeserializer.getUInt8();
            sGPSOffroad2.hour = s3 = iDeserializer.getUInt8();
            sGPSOffroad2.minute = s2 = iDeserializer.getUInt8();
            sGPSOffroad2.seconds = s = iDeserializer.getUInt8();
        }
        return sGPSOffroad2;
    }

    public static sGPSOffroad[] getOptionalsGPSOffroadVarArray(IDeserializer iDeserializer) {
        sGPSOffroad[] sGPSOffroadArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sGPSOffroadArray = new sGPSOffroad[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sGPSOffroadArray[i2] = sGPSOffroadSerializer.getOptionalsGPSOffroad(iDeserializer);
            }
        }
        return sGPSOffroadArray;
    }
}

