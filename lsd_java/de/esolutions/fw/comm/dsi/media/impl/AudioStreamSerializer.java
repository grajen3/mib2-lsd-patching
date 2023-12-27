/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.AudioStream;

public class AudioStreamSerializer {
    public static void putOptionalAudioStream(ISerializer iSerializer, AudioStream audioStream) {
        boolean bl = audioStream == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = audioStream.getLanguageCode();
            iSerializer.putInt32(n);
            int n2 = audioStream.getNumChannels();
            iSerializer.putInt32(n2);
            int n3 = audioStream.getAudioCoding();
            iSerializer.putInt32(n3);
            int n4 = audioStream.getSamplingRate();
            iSerializer.putInt32(n4);
            int n5 = audioStream.getAudioLanguageExtension();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalAudioStreamVarArray(ISerializer iSerializer, AudioStream[] audioStreamArray) {
        boolean bl = audioStreamArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioStreamArray.length);
            for (int i2 = 0; i2 < audioStreamArray.length; ++i2) {
                AudioStreamSerializer.putOptionalAudioStream(iSerializer, audioStreamArray[i2]);
            }
        }
    }

    public static AudioStream getOptionalAudioStream(IDeserializer iDeserializer) {
        AudioStream audioStream = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            audioStream = new AudioStream();
            audioStream.languageCode = n5 = iDeserializer.getInt32();
            audioStream.numChannels = n4 = iDeserializer.getInt32();
            audioStream.audioCoding = n3 = iDeserializer.getInt32();
            audioStream.samplingRate = n2 = iDeserializer.getInt32();
            audioStream.audioLanguageExtension = n = iDeserializer.getInt32();
        }
        return audioStream;
    }

    public static AudioStream[] getOptionalAudioStreamVarArray(IDeserializer iDeserializer) {
        AudioStream[] audioStreamArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioStreamArray = new AudioStream[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioStreamArray[i2] = AudioStreamSerializer.getOptionalAudioStream(iDeserializer);
            }
        }
        return audioStreamArray;
    }
}

