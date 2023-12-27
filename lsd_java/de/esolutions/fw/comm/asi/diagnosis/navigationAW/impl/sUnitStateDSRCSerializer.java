/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sUnitStateDSRC;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sUnitStateDSRCSerializer {
    public static void putOptionalsUnitStateDSRC(ISerializer iSerializer, sUnitStateDSRC sUnitStateDSRC2) {
        boolean bl = sUnitStateDSRC2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sUnitStateDSRC2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sUnitStateDSRC2.getCardPlugInState();
            iSerializer.putEnum(n);
            int n2 = sUnitStateDSRC2.getCardAuthState();
            iSerializer.putEnum(n2);
            int n3 = sUnitStateDSRC2.getCardWritingState();
            iSerializer.putEnum(n3);
            int n4 = sUnitStateDSRC2.getCardReadingState();
            iSerializer.putEnum(n4);
            int n5 = sUnitStateDSRC2.getCardAnormalState();
            iSerializer.putEnum(n5);
            int n6 = sUnitStateDSRC2.getEtcBarState();
            iSerializer.putEnum(n6);
            short s = sUnitStateDSRC2.getRetryCounterEtcComm();
            iSerializer.putUInt8(s);
            short s2 = sUnitStateDSRC2.getErrorCounterEtcComm();
            iSerializer.putUInt8(s2);
            boolean bl2 = sUnitStateDSRC2.isDateTimeValid();
            iSerializer.putBool(bl2);
            short s3 = sUnitStateDSRC2.getYearLastErrorComm();
            iSerializer.putUInt8(s3);
            short s4 = sUnitStateDSRC2.getMonthLastErrorComm();
            iSerializer.putUInt8(s4);
            short s5 = sUnitStateDSRC2.getDayLastErrorComm();
            iSerializer.putUInt8(s5);
            short s6 = sUnitStateDSRC2.getHourLastErrorComm();
            iSerializer.putUInt8(s6);
            short s7 = sUnitStateDSRC2.getMinuteLastErrorComm();
            iSerializer.putUInt8(s7);
            short s8 = sUnitStateDSRC2.getSecondsLastErrorComm();
            iSerializer.putUInt8(s8);
            int n7 = sUnitStateDSRC2.getCardType();
            iSerializer.putEnum(n7);
        }
    }

    public static void putOptionalsUnitStateDSRCVarArray(ISerializer iSerializer, sUnitStateDSRC[] sUnitStateDSRCArray) {
        boolean bl = sUnitStateDSRCArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sUnitStateDSRCArray.length);
            for (int i2 = 0; i2 < sUnitStateDSRCArray.length; ++i2) {
                sUnitStateDSRCSerializer.putOptionalsUnitStateDSRC(iSerializer, sUnitStateDSRCArray[i2]);
            }
        }
    }

    public static sUnitStateDSRC getOptionalsUnitStateDSRC(IDeserializer iDeserializer) {
        sUnitStateDSRC sUnitStateDSRC2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            boolean bl2;
            short s7;
            short s8;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            long l;
            sUnitStateDSRC2 = new sUnitStateDSRC();
            sUnitStateDSRC2.msg_id = l = iDeserializer.getUInt32();
            sUnitStateDSRC2.cardPlugInState = n7 = iDeserializer.getEnum();
            sUnitStateDSRC2.cardAuthState = n6 = iDeserializer.getEnum();
            sUnitStateDSRC2.cardWritingState = n5 = iDeserializer.getEnum();
            sUnitStateDSRC2.cardReadingState = n4 = iDeserializer.getEnum();
            sUnitStateDSRC2.cardAnormalState = n3 = iDeserializer.getEnum();
            sUnitStateDSRC2.etcBarState = n2 = iDeserializer.getEnum();
            sUnitStateDSRC2.retryCounterEtcComm = s8 = iDeserializer.getUInt8();
            sUnitStateDSRC2.errorCounterEtcComm = s7 = iDeserializer.getUInt8();
            sUnitStateDSRC2.dateTimeValid = bl2 = iDeserializer.getBool();
            sUnitStateDSRC2.yearLastErrorComm = s6 = iDeserializer.getUInt8();
            sUnitStateDSRC2.monthLastErrorComm = s5 = iDeserializer.getUInt8();
            sUnitStateDSRC2.dayLastErrorComm = s4 = iDeserializer.getUInt8();
            sUnitStateDSRC2.hourLastErrorComm = s3 = iDeserializer.getUInt8();
            sUnitStateDSRC2.minuteLastErrorComm = s2 = iDeserializer.getUInt8();
            sUnitStateDSRC2.secondsLastErrorComm = s = iDeserializer.getUInt8();
            sUnitStateDSRC2.cardType = n = iDeserializer.getEnum();
        }
        return sUnitStateDSRC2;
    }

    public static sUnitStateDSRC[] getOptionalsUnitStateDSRCVarArray(IDeserializer iDeserializer) {
        sUnitStateDSRC[] sUnitStateDSRCArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sUnitStateDSRCArray = new sUnitStateDSRC[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sUnitStateDSRCArray[i2] = sUnitStateDSRCSerializer.getOptionalsUnitStateDSRC(iDeserializer);
            }
        }
        return sUnitStateDSRCArray;
    }
}

