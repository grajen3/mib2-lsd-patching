/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.comm.dsi.tvtuner.impl.AudioChannelSerializer;
import de.esolutions.fw.comm.dsi.tvtuner.impl.ServiceInfoSerializer;
import de.esolutions.fw.comm.dsi.tvtuner.impl.TimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.Time;

public class ProgramInfoSerializer {
    public static void putOptionalProgramInfo(ISerializer iSerializer, ProgramInfo programInfo) {
        boolean bl = programInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            ServiceInfo serviceInfo = programInfo.getServiceInfo();
            ServiceInfoSerializer.putOptionalServiceInfo(iSerializer, serviceInfo);
            String string = programInfo.getChannelName();
            iSerializer.putOptionalString(string);
            int n = programInfo.getNormArea();
            iSerializer.putInt32(n);
            int n2 = programInfo.getVideoFormat();
            iSerializer.putInt32(n2);
            AudioChannel[] audioChannelArray = programInfo.getAvailableAudioChannels();
            AudioChannelSerializer.putOptionalAudioChannelVarArray(iSerializer, audioChannelArray);
            int n3 = programInfo.getSelectedAudioChannel();
            iSerializer.putInt32(n3);
            int n4 = programInfo.getEpgFlag();
            iSerializer.putInt32(n4);
            int n5 = programInfo.getTeletextFlag();
            iSerializer.putInt32(n5);
            int n6 = programInfo.getVariantDatabroadcastFlag();
            iSerializer.putInt32(n6);
            int n7 = programInfo.getDatabroadcastFlag1();
            iSerializer.putInt32(n7);
            int n8 = programInfo.getDatabroadcastFlag2();
            iSerializer.putInt32(n8);
            int n9 = programInfo.getBwsFlag();
            iSerializer.putInt32(n9);
            int n10 = programInfo.getSlsFlag();
            iSerializer.putInt32(n10);
            int n11 = programInfo.getTxtFlag();
            iSerializer.putInt32(n11);
            int n12 = programInfo.getCasFlag();
            iSerializer.putInt32(n12);
            int n13 = programInfo.getVisAudioFlag();
            iSerializer.putInt32(n13);
            int n14 = programInfo.getAnnouncement();
            iSerializer.putInt32(n14);
            int n15 = programInfo.getCaDescriptor();
            iSerializer.putInt32(n15);
            int n16 = programInfo.getCasStatus();
            iSerializer.putInt32(n16);
            short s = programInfo.getParentalRating();
            iSerializer.putInt16(s);
            Time time = programInfo.getNowStartTime();
            TimeSerializer.putOptionalTime(iSerializer, time);
            Time time2 = programInfo.getNowEndTime();
            TimeSerializer.putOptionalTime(iSerializer, time2);
            String string2 = programInfo.getNowProgramInfo();
            iSerializer.putOptionalString(string2);
            Time time3 = programInfo.getNextStartTime();
            TimeSerializer.putOptionalTime(iSerializer, time3);
            Time time4 = programInfo.getNextEndTime();
            TimeSerializer.putOptionalTime(iSerializer, time4);
            String string3 = programInfo.getNextProgramInfo();
            iSerializer.putOptionalString(string3);
            int n17 = programInfo.getSubtitleFlag();
            iSerializer.putInt32(n17);
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
            String string;
            Time time;
            Time time2;
            String string2;
            Time time3;
            Time time4;
            short s;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            String string3;
            ServiceInfo serviceInfo;
            programInfo = new ProgramInfo();
            programInfo.serviceInfo = serviceInfo = ServiceInfoSerializer.getOptionalServiceInfo(iDeserializer);
            programInfo.channelName = string3 = iDeserializer.getOptionalString();
            programInfo.normArea = n17 = iDeserializer.getInt32();
            programInfo.videoFormat = n16 = iDeserializer.getInt32();
            AudioChannel[] audioChannelArray = AudioChannelSerializer.getOptionalAudioChannelVarArray(iDeserializer);
            programInfo.availableAudioChannels = audioChannelArray;
            programInfo.selectedAudioChannel = n15 = iDeserializer.getInt32();
            programInfo.epgFlag = n14 = iDeserializer.getInt32();
            programInfo.teletextFlag = n13 = iDeserializer.getInt32();
            programInfo.variantDatabroadcastFlag = n12 = iDeserializer.getInt32();
            programInfo.databroadcastFlag1 = n11 = iDeserializer.getInt32();
            programInfo.databroadcastFlag2 = n10 = iDeserializer.getInt32();
            programInfo.bwsFlag = n9 = iDeserializer.getInt32();
            programInfo.slsFlag = n8 = iDeserializer.getInt32();
            programInfo.txtFlag = n7 = iDeserializer.getInt32();
            programInfo.casFlag = n6 = iDeserializer.getInt32();
            programInfo.visAudioFlag = n5 = iDeserializer.getInt32();
            programInfo.announcement = n4 = iDeserializer.getInt32();
            programInfo.caDescriptor = n3 = iDeserializer.getInt32();
            programInfo.casStatus = n2 = iDeserializer.getInt32();
            programInfo.parentalRating = s = iDeserializer.getInt16();
            programInfo.nowStartTime = time4 = TimeSerializer.getOptionalTime(iDeserializer);
            programInfo.nowEndTime = time3 = TimeSerializer.getOptionalTime(iDeserializer);
            programInfo.nowProgramInfo = string2 = iDeserializer.getOptionalString();
            programInfo.nextStartTime = time2 = TimeSerializer.getOptionalTime(iDeserializer);
            programInfo.nextEndTime = time = TimeSerializer.getOptionalTime(iDeserializer);
            programInfo.nextProgramInfo = string = iDeserializer.getOptionalString();
            programInfo.subtitleFlag = n = iDeserializer.getInt32();
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

