/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ProgramInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ProgramInfoSerializer {
    public static void putOptionalProgramInfo(ISerializer iSerializer, ProgramInfo programInfo) {
        boolean bl = programInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = programInfo.getName();
            iSerializer.putOptionalString(string);
            int n = programInfo.getStartHour();
            iSerializer.putInt32(n);
            int n2 = programInfo.getStartMinute();
            iSerializer.putInt32(n2);
            int n3 = programInfo.getStartSecond();
            iSerializer.putInt32(n3);
            int n4 = programInfo.getEndHour();
            iSerializer.putInt32(n4);
            int n5 = programInfo.getEndMinute();
            iSerializer.putInt32(n5);
            int n6 = programInfo.getEndSecond();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalProgramInfoVarArray(ISerializer iSerializer, ProgramInfo[] programInfoArray) {
        boolean bl = programInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(programInfoArray.length);
            for (int i2 = 0; i2 < programInfoArray.length; ++i2) {
                ProgramInfoSerializer.putOptionalProgramInfo(iSerializer, programInfoArray[i2]);
            }
        }
    }

    public static ProgramInfo getOptionalProgramInfo(IDeserializer iDeserializer) {
        ProgramInfo programInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            String string;
            programInfo = new ProgramInfo();
            programInfo.name = string = iDeserializer.getOptionalString();
            programInfo.startHour = n6 = iDeserializer.getInt32();
            programInfo.startMinute = n5 = iDeserializer.getInt32();
            programInfo.startSecond = n4 = iDeserializer.getInt32();
            programInfo.endHour = n3 = iDeserializer.getInt32();
            programInfo.endMinute = n2 = iDeserializer.getInt32();
            programInfo.endSecond = n = iDeserializer.getInt32();
        }
        return programInfo;
    }

    public static ProgramInfo[] getOptionalProgramInfoVarArray(IDeserializer iDeserializer) {
        ProgramInfo[] programInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            programInfoArray = new ProgramInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                programInfoArray[i2] = ProgramInfoSerializer.getOptionalProgramInfo(iDeserializer);
            }
        }
        return programInfoArray;
    }
}

