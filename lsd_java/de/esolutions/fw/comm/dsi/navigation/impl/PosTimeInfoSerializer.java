/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.PosTimeInfo;

public class PosTimeInfoSerializer {
    public static void putOptionalPosTimeInfo(ISerializer iSerializer, PosTimeInfo posTimeInfo) {
        boolean bl = posTimeInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = posTimeInfo.getTimeZoneOffset();
            iSerializer.putInt32(n);
            boolean bl2 = posTimeInfo.isSummerTimeValidity();
            iSerializer.putBool(bl2);
            short s = posTimeInfo.getSummerTimeMonthFrom();
            iSerializer.putInt16(s);
            short s2 = posTimeInfo.getSummerTimeDayFrom();
            iSerializer.putInt16(s2);
            short s3 = posTimeInfo.getSummerTimeHourFrom();
            iSerializer.putInt16(s3);
            short s4 = posTimeInfo.getSummerTimeMonthTo();
            iSerializer.putInt16(s4);
            short s5 = posTimeInfo.getSummerTimeDayTo();
            iSerializer.putInt16(s5);
            short s6 = posTimeInfo.getSummerTimeHourTo();
            iSerializer.putInt16(s6);
            short s7 = posTimeInfo.getSummerTimeYearFrom();
            iSerializer.putInt16(s7);
            short s8 = posTimeInfo.getSummerTimeYearTo();
            iSerializer.putInt16(s8);
        }
    }

    public static void putOptionalPosTimeInfoVarArray(ISerializer iSerializer, PosTimeInfo[] posTimeInfoArray) {
        boolean bl = posTimeInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(posTimeInfoArray.length);
            for (int i2 = 0; i2 < posTimeInfoArray.length; ++i2) {
                PosTimeInfoSerializer.putOptionalPosTimeInfo(iSerializer, posTimeInfoArray[i2]);
            }
        }
    }

    public static PosTimeInfo getOptionalPosTimeInfo(IDeserializer iDeserializer) {
        PosTimeInfo posTimeInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            short s7;
            short s8;
            boolean bl2;
            int n;
            posTimeInfo = new PosTimeInfo();
            posTimeInfo.timeZoneOffset = n = iDeserializer.getInt32();
            posTimeInfo.summerTimeValidity = bl2 = iDeserializer.getBool();
            posTimeInfo.summerTimeMonthFrom = s8 = iDeserializer.getInt16();
            posTimeInfo.summerTimeDayFrom = s7 = iDeserializer.getInt16();
            posTimeInfo.summerTimeHourFrom = s6 = iDeserializer.getInt16();
            posTimeInfo.summerTimeMonthTo = s5 = iDeserializer.getInt16();
            posTimeInfo.summerTimeDayTo = s4 = iDeserializer.getInt16();
            posTimeInfo.summerTimeHourTo = s3 = iDeserializer.getInt16();
            posTimeInfo.summerTimeYearFrom = s2 = iDeserializer.getInt16();
            posTimeInfo.summerTimeYearTo = s = iDeserializer.getInt16();
        }
        return posTimeInfo;
    }

    public static PosTimeInfo[] getOptionalPosTimeInfoVarArray(IDeserializer iDeserializer) {
        PosTimeInfo[] posTimeInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            posTimeInfoArray = new PosTimeInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                posTimeInfoArray[i2] = PosTimeInfoSerializer.getOptionalPosTimeInfo(iDeserializer);
            }
        }
        return posTimeInfoArray;
    }
}

