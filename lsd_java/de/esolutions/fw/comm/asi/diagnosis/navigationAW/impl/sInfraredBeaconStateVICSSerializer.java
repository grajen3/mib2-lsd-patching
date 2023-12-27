/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sInfraredBeaconStateVICS;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sInfraredBeaconStateVICSSerializer {
    public static void putOptionalsInfraredBeaconStateVICS(ISerializer iSerializer, sInfraredBeaconStateVICS sInfraredBeaconStateVICS2) {
        boolean bl = sInfraredBeaconStateVICS2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sInfraredBeaconStateVICS2.getMsg_id();
            iSerializer.putUInt32(l);
            boolean bl2 = sInfraredBeaconStateVICS2.isAvailable();
            iSerializer.putBool(bl2);
            short s = sInfraredBeaconStateVICS2.getYearLastMsg();
            iSerializer.putUInt8(s);
            short s2 = sInfraredBeaconStateVICS2.getMonthLastMsg();
            iSerializer.putUInt8(s2);
            short s3 = sInfraredBeaconStateVICS2.getDayLastMsg();
            iSerializer.putUInt8(s3);
            short s4 = sInfraredBeaconStateVICS2.getHourLastMsg();
            iSerializer.putUInt8(s4);
            short s5 = sInfraredBeaconStateVICS2.getMinuteLastMsg();
            iSerializer.putUInt8(s5);
            short s6 = sInfraredBeaconStateVICS2.getSecondsLastMsg();
            iSerializer.putUInt8(s6);
            short s7 = sInfraredBeaconStateVICS2.getIdLastMsg();
            iSerializer.putUInt8(s7);
        }
    }

    public static void putOptionalsInfraredBeaconStateVICSVarArray(ISerializer iSerializer, sInfraredBeaconStateVICS[] sInfraredBeaconStateVICSArray) {
        boolean bl = sInfraredBeaconStateVICSArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sInfraredBeaconStateVICSArray.length);
            for (int i2 = 0; i2 < sInfraredBeaconStateVICSArray.length; ++i2) {
                sInfraredBeaconStateVICSSerializer.putOptionalsInfraredBeaconStateVICS(iSerializer, sInfraredBeaconStateVICSArray[i2]);
            }
        }
    }

    public static sInfraredBeaconStateVICS getOptionalsInfraredBeaconStateVICS(IDeserializer iDeserializer) {
        sInfraredBeaconStateVICS sInfraredBeaconStateVICS2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            short s7;
            boolean bl2;
            long l;
            sInfraredBeaconStateVICS2 = new sInfraredBeaconStateVICS();
            sInfraredBeaconStateVICS2.msg_id = l = iDeserializer.getUInt32();
            sInfraredBeaconStateVICS2.available = bl2 = iDeserializer.getBool();
            sInfraredBeaconStateVICS2.yearLastMsg = s7 = iDeserializer.getUInt8();
            sInfraredBeaconStateVICS2.monthLastMsg = s6 = iDeserializer.getUInt8();
            sInfraredBeaconStateVICS2.dayLastMsg = s5 = iDeserializer.getUInt8();
            sInfraredBeaconStateVICS2.hourLastMsg = s4 = iDeserializer.getUInt8();
            sInfraredBeaconStateVICS2.minuteLastMsg = s3 = iDeserializer.getUInt8();
            sInfraredBeaconStateVICS2.secondsLastMsg = s2 = iDeserializer.getUInt8();
            sInfraredBeaconStateVICS2.idLastMsg = s = iDeserializer.getUInt8();
        }
        return sInfraredBeaconStateVICS2;
    }

    public static sInfraredBeaconStateVICS[] getOptionalsInfraredBeaconStateVICSVarArray(IDeserializer iDeserializer) {
        sInfraredBeaconStateVICS[] sInfraredBeaconStateVICSArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sInfraredBeaconStateVICSArray = new sInfraredBeaconStateVICS[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sInfraredBeaconStateVICSArray[i2] = sInfraredBeaconStateVICSSerializer.getOptionalsInfraredBeaconStateVICS(iDeserializer);
            }
        }
        return sInfraredBeaconStateVICSArray;
    }
}

