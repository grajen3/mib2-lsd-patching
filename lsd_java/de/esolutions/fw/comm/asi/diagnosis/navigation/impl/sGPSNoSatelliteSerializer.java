/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sGPSNoSatelliteSerializer {
    public static void putOptionalsGPSNoSatellite(ISerializer iSerializer, sGPSNoSatellite sGPSNoSatellite2) {
        boolean bl = sGPSNoSatellite2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sGPSNoSatellite2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sGPSNoSatellite2.getYear();
            iSerializer.putUInt8(s);
            short s2 = sGPSNoSatellite2.getMonth();
            iSerializer.putUInt8(s2);
            short s3 = sGPSNoSatellite2.getDay();
            iSerializer.putUInt8(s3);
            short s4 = sGPSNoSatellite2.getHour();
            iSerializer.putUInt8(s4);
            short s5 = sGPSNoSatellite2.getMinute();
            iSerializer.putUInt8(s5);
            short s6 = sGPSNoSatellite2.getSeconds();
            iSerializer.putUInt8(s6);
        }
    }

    public static void putOptionalsGPSNoSatelliteVarArray(ISerializer iSerializer, sGPSNoSatellite[] sGPSNoSatelliteArray) {
        boolean bl = sGPSNoSatelliteArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sGPSNoSatelliteArray.length);
            for (int i2 = 0; i2 < sGPSNoSatelliteArray.length; ++i2) {
                sGPSNoSatelliteSerializer.putOptionalsGPSNoSatellite(iSerializer, sGPSNoSatelliteArray[i2]);
            }
        }
    }

    public static sGPSNoSatellite getOptionalsGPSNoSatellite(IDeserializer iDeserializer) {
        sGPSNoSatellite sGPSNoSatellite2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            long l;
            sGPSNoSatellite2 = new sGPSNoSatellite();
            sGPSNoSatellite2.msg_id = l = iDeserializer.getUInt32();
            sGPSNoSatellite2.year = s6 = iDeserializer.getUInt8();
            sGPSNoSatellite2.month = s5 = iDeserializer.getUInt8();
            sGPSNoSatellite2.day = s4 = iDeserializer.getUInt8();
            sGPSNoSatellite2.hour = s3 = iDeserializer.getUInt8();
            sGPSNoSatellite2.minute = s2 = iDeserializer.getUInt8();
            sGPSNoSatellite2.seconds = s = iDeserializer.getUInt8();
        }
        return sGPSNoSatellite2;
    }

    public static sGPSNoSatellite[] getOptionalsGPSNoSatelliteVarArray(IDeserializer iDeserializer) {
        sGPSNoSatellite[] sGPSNoSatelliteArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sGPSNoSatelliteArray = new sGPSNoSatellite[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sGPSNoSatelliteArray[i2] = sGPSNoSatelliteSerializer.getOptionalsGPSNoSatellite(iDeserializer);
            }
        }
        return sGPSNoSatelliteArray;
    }
}

