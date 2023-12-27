/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.AudioFormat;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.AudioFormatSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AudioDataSerializer {
    public static void putOptionalAudioData(ISerializer iSerializer, AudioData audioData) {
        boolean bl = audioData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte[] byArray = audioData.getAudioData();
            iSerializer.putOptionalInt8VarArray(byArray);
            int n = audioData.getAudioDataSize();
            iSerializer.putInt32(n);
            AudioFormat audioFormat = audioData.getFormat();
            AudioFormatSerializer.putOptionalAudioFormat(iSerializer, audioFormat);
        }
    }

    public static void putOptionalAudioDataVarArray(ISerializer iSerializer, AudioData[] audioDataArray) {
        boolean bl = audioDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioDataArray.length);
            for (int i2 = 0; i2 < audioDataArray.length; ++i2) {
                AudioDataSerializer.putOptionalAudioData(iSerializer, audioDataArray[i2]);
            }
        }
    }

    public static AudioData getOptionalAudioData(IDeserializer iDeserializer) {
        AudioData audioData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            AudioFormat audioFormat;
            int n;
            audioData = new AudioData();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            audioData.audioData = byArray;
            audioData.audioDataSize = n = iDeserializer.getInt32();
            audioData.format = audioFormat = AudioFormatSerializer.getOptionalAudioFormat(iDeserializer);
        }
        return audioData;
    }

    public static AudioData[] getOptionalAudioDataVarArray(IDeserializer iDeserializer) {
        AudioData[] audioDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioDataArray = new AudioData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioDataArray[i2] = AudioDataSerializer.getOptionalAudioData(iDeserializer);
            }
        }
        return audioDataArray;
    }
}

