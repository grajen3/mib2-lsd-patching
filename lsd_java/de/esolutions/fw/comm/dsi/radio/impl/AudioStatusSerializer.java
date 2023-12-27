/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.AudioStatus;

public class AudioStatusSerializer {
    public static void putOptionalAudioStatus(ISerializer iSerializer, AudioStatus audioStatus) {
        boolean bl = audioStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = audioStatus.getSID();
            iSerializer.putInt64(l);
            int n = audioStatus.getSCIDI();
            iSerializer.putInt32(n);
            int n2 = audioStatus.getDRCStatus();
            iSerializer.putInt32(n2);
            int n3 = audioStatus.getMusicSpeech();
            iSerializer.putInt32(n3);
            int n4 = audioStatus.getAudioMode();
            iSerializer.putInt32(n4);
            int n5 = audioStatus.getDecodingAlgorithm();
            iSerializer.putInt32(n5);
            int n6 = audioStatus.getAudioBitrate();
            iSerializer.putInt32(n6);
            int n7 = audioStatus.getOriginalStatus();
            iSerializer.putInt32(n7);
            int n8 = audioStatus.getCopyrightStatus();
            iSerializer.putInt32(n8);
            int n9 = audioStatus.getSamplingRate();
            iSerializer.putInt32(n9);
        }
    }

    public static void putOptionalAudioStatusVarArray(ISerializer iSerializer, AudioStatus[] audioStatusArray) {
        boolean bl = audioStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioStatusArray.length);
            for (int i2 = 0; i2 < audioStatusArray.length; ++i2) {
                AudioStatusSerializer.putOptionalAudioStatus(iSerializer, audioStatusArray[i2]);
            }
        }
    }

    public static AudioStatus getOptionalAudioStatus(IDeserializer iDeserializer) {
        AudioStatus audioStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            long l;
            audioStatus = new AudioStatus();
            audioStatus.sID = l = iDeserializer.getInt64();
            audioStatus.sCIDI = n9 = iDeserializer.getInt32();
            audioStatus.dRCStatus = n8 = iDeserializer.getInt32();
            audioStatus.musicSpeech = n7 = iDeserializer.getInt32();
            audioStatus.audioMode = n6 = iDeserializer.getInt32();
            audioStatus.decodingAlgorithm = n5 = iDeserializer.getInt32();
            audioStatus.audioBitrate = n4 = iDeserializer.getInt32();
            audioStatus.originalStatus = n3 = iDeserializer.getInt32();
            audioStatus.copyrightStatus = n2 = iDeserializer.getInt32();
            audioStatus.samplingRate = n = iDeserializer.getInt32();
        }
        return audioStatus;
    }

    public static AudioStatus[] getOptionalAudioStatusVarArray(IDeserializer iDeserializer) {
        AudioStatus[] audioStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioStatusArray = new AudioStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioStatusArray[i2] = AudioStatusSerializer.getOptionalAudioStatus(iDeserializer);
            }
        }
        return audioStatusArray;
    }
}

