/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sRadioBeaconStateVICS;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sRadioBeaconStateVICSSerializer {
    public static void putOptionalsRadioBeaconStateVICS(ISerializer iSerializer, sRadioBeaconStateVICS sRadioBeaconStateVICS2) {
        boolean bl = sRadioBeaconStateVICS2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sRadioBeaconStateVICS2.getMsg_id();
            iSerializer.putUInt32(l);
            boolean bl2 = sRadioBeaconStateVICS2.isAvailable();
            iSerializer.putBool(bl2);
            short s = sRadioBeaconStateVICS2.getYearLastMsg();
            iSerializer.putUInt8(s);
            short s2 = sRadioBeaconStateVICS2.getMonthLastMsg();
            iSerializer.putUInt8(s2);
            short s3 = sRadioBeaconStateVICS2.getDayLastMsg();
            iSerializer.putUInt8(s3);
            short s4 = sRadioBeaconStateVICS2.getHourLastMsg();
            iSerializer.putUInt8(s4);
            short s5 = sRadioBeaconStateVICS2.getMinuteLastMsg();
            iSerializer.putUInt8(s5);
            short s6 = sRadioBeaconStateVICS2.getSecondsLastMsg();
            iSerializer.putUInt8(s6);
            short s7 = sRadioBeaconStateVICS2.getIdLastMsg();
            iSerializer.putUInt8(s7);
        }
    }

    public static void putOptionalsRadioBeaconStateVICSVarArray(ISerializer iSerializer, sRadioBeaconStateVICS[] sRadioBeaconStateVICSArray) {
        boolean bl = sRadioBeaconStateVICSArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sRadioBeaconStateVICSArray.length);
            for (int i2 = 0; i2 < sRadioBeaconStateVICSArray.length; ++i2) {
                sRadioBeaconStateVICSSerializer.putOptionalsRadioBeaconStateVICS(iSerializer, sRadioBeaconStateVICSArray[i2]);
            }
        }
    }

    public static sRadioBeaconStateVICS getOptionalsRadioBeaconStateVICS(IDeserializer iDeserializer) {
        sRadioBeaconStateVICS sRadioBeaconStateVICS2 = null;
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
            sRadioBeaconStateVICS2 = new sRadioBeaconStateVICS();
            sRadioBeaconStateVICS2.msg_id = l = iDeserializer.getUInt32();
            sRadioBeaconStateVICS2.available = bl2 = iDeserializer.getBool();
            sRadioBeaconStateVICS2.yearLastMsg = s7 = iDeserializer.getUInt8();
            sRadioBeaconStateVICS2.monthLastMsg = s6 = iDeserializer.getUInt8();
            sRadioBeaconStateVICS2.dayLastMsg = s5 = iDeserializer.getUInt8();
            sRadioBeaconStateVICS2.hourLastMsg = s4 = iDeserializer.getUInt8();
            sRadioBeaconStateVICS2.minuteLastMsg = s3 = iDeserializer.getUInt8();
            sRadioBeaconStateVICS2.secondsLastMsg = s2 = iDeserializer.getUInt8();
            sRadioBeaconStateVICS2.idLastMsg = s = iDeserializer.getUInt8();
        }
        return sRadioBeaconStateVICS2;
    }

    public static sRadioBeaconStateVICS[] getOptionalsRadioBeaconStateVICSVarArray(IDeserializer iDeserializer) {
        sRadioBeaconStateVICS[] sRadioBeaconStateVICSArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sRadioBeaconStateVICSArray = new sRadioBeaconStateVICS[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sRadioBeaconStateVICSArray[i2] = sRadioBeaconStateVICSSerializer.getOptionalsRadioBeaconStateVICS(iDeserializer);
            }
        }
        return sRadioBeaconStateVICSArray;
    }
}

