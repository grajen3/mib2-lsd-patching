/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioFormat;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AudioFormatSerializer {
    public static void putOptionalAudioFormat(ISerializer iSerializer, AudioFormat audioFormat) {
        boolean bl = audioFormat == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = audioFormat.getSampleRate();
            iSerializer.putUInt32(l);
            long l2 = audioFormat.getNChannels();
            iSerializer.putUInt32(l2);
            long l3 = audioFormat.getBitsPerSample();
            iSerializer.putUInt32(l3);
            int n = audioFormat.getFormat();
            iSerializer.putEnum(n);
            int n2 = audioFormat.getEndianness();
            iSerializer.putEnum(n2);
        }
    }

    public static void putOptionalAudioFormatVarArray(ISerializer iSerializer, AudioFormat[] audioFormatArray) {
        boolean bl = audioFormatArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioFormatArray.length);
            for (int i2 = 0; i2 < audioFormatArray.length; ++i2) {
                AudioFormatSerializer.putOptionalAudioFormat(iSerializer, audioFormatArray[i2]);
            }
        }
    }

    public static AudioFormat getOptionalAudioFormat(IDeserializer iDeserializer) {
        AudioFormat audioFormat = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            long l2;
            long l3;
            audioFormat = new AudioFormat();
            audioFormat.sampleRate = l3 = iDeserializer.getUInt32();
            audioFormat.nChannels = l2 = iDeserializer.getUInt32();
            audioFormat.bitsPerSample = l = iDeserializer.getUInt32();
            audioFormat.format = n2 = iDeserializer.getEnum();
            audioFormat.endianness = n = iDeserializer.getEnum();
        }
        return audioFormat;
    }

    public static AudioFormat[] getOptionalAudioFormatVarArray(IDeserializer iDeserializer) {
        AudioFormat[] audioFormatArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioFormatArray = new AudioFormat[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioFormatArray[i2] = AudioFormatSerializer.getOptionalAudioFormat(iDeserializer);
            }
        }
        return audioFormatArray;
    }
}

