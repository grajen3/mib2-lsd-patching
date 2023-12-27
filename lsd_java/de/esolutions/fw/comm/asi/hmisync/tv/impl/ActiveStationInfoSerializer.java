/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.AudioChannel;
import de.esolutions.fw.comm.asi.hmisync.tv.ProgramInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.AudioChannelSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ActiveStationInfoSerializer {
    public static void putOptionalActiveStationInfo(ISerializer iSerializer, ActiveStationInfo activeStationInfo) {
        boolean bl = activeStationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = activeStationInfo.getId();
            iSerializer.putInt64(l);
            String string = activeStationInfo.getStationName();
            iSerializer.putOptionalString(string);
            String string2 = activeStationInfo.getChannelName();
            iSerializer.putOptionalString(string2);
            int[] nArray = activeStationInfo.getStationConfig();
            iSerializer.putOptionalInt32VarArray(nArray);
            int[] nArray2 = activeStationInfo.getStationFlags();
            iSerializer.putOptionalInt32VarArray(nArray2);
            ProgramInfo programInfo = activeStationInfo.getCurrentProgram();
            ProgramInfoSerializer.putOptionalProgramInfo(iSerializer, programInfo);
            ProgramInfo programInfo2 = activeStationInfo.getNextProgram();
            ProgramInfoSerializer.putOptionalProgramInfo(iSerializer, programInfo2);
            AudioChannel[] audioChannelArray = activeStationInfo.getAudioChannels();
            AudioChannelSerializer.putOptionalAudioChannelVarArray(iSerializer, audioChannelArray);
        }
    }

    public static void putOptionalActiveStationInfoVarArray(ISerializer iSerializer, ActiveStationInfo[] activeStationInfoArray) {
        boolean bl = activeStationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(activeStationInfoArray.length);
            for (int i2 = 0; i2 < activeStationInfoArray.length; ++i2) {
                ActiveStationInfoSerializer.putOptionalActiveStationInfo(iSerializer, activeStationInfoArray[i2]);
            }
        }
    }

    public static ActiveStationInfo getOptionalActiveStationInfo(IDeserializer iDeserializer) {
        ActiveStationInfo activeStationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ProgramInfo programInfo;
            ProgramInfo programInfo2;
            String string;
            String string2;
            long l;
            activeStationInfo = new ActiveStationInfo();
            activeStationInfo.id = l = iDeserializer.getInt64();
            activeStationInfo.stationName = string2 = iDeserializer.getOptionalString();
            activeStationInfo.channelName = string = iDeserializer.getOptionalString();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            activeStationInfo.stationConfig = nArray;
            int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
            activeStationInfo.stationFlags = nArray2;
            activeStationInfo.currentProgram = programInfo2 = ProgramInfoSerializer.getOptionalProgramInfo(iDeserializer);
            activeStationInfo.nextProgram = programInfo = ProgramInfoSerializer.getOptionalProgramInfo(iDeserializer);
            AudioChannel[] audioChannelArray = AudioChannelSerializer.getOptionalAudioChannelVarArray(iDeserializer);
            activeStationInfo.audioChannels = audioChannelArray;
        }
        return activeStationInfo;
    }

    public static ActiveStationInfo[] getOptionalActiveStationInfoVarArray(IDeserializer iDeserializer) {
        ActiveStationInfo[] activeStationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            activeStationInfoArray = new ActiveStationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                activeStationInfoArray[i2] = ActiveStationInfoSerializer.getOptionalActiveStationInfo(iDeserializer);
            }
        }
        return activeStationInfoArray;
    }
}

