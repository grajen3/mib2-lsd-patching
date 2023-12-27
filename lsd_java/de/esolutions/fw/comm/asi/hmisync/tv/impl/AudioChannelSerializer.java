/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.AudioChannel;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AudioChannelSerializer {
    public static void putOptionalAudioChannel(ISerializer iSerializer, AudioChannel audioChannel) {
        boolean bl = audioChannel == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = audioChannel.getId();
            iSerializer.putInt32(n);
            String string = audioChannel.getLanguage();
            iSerializer.putOptionalString(string);
            int n2 = audioChannel.getFormat();
            iSerializer.putInt32(n2);
            int n3 = audioChannel.getDescription();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalAudioChannelVarArray(ISerializer iSerializer, AudioChannel[] audioChannelArray) {
        boolean bl = audioChannelArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioChannelArray.length);
            for (int i2 = 0; i2 < audioChannelArray.length; ++i2) {
                AudioChannelSerializer.putOptionalAudioChannel(iSerializer, audioChannelArray[i2]);
            }
        }
    }

    public static AudioChannel getOptionalAudioChannel(IDeserializer iDeserializer) {
        AudioChannel audioChannel = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            int n3;
            audioChannel = new AudioChannel();
            audioChannel.id = n3 = iDeserializer.getInt32();
            audioChannel.language = string = iDeserializer.getOptionalString();
            audioChannel.format = n2 = iDeserializer.getInt32();
            audioChannel.description = n = iDeserializer.getInt32();
        }
        return audioChannel;
    }

    public static AudioChannel[] getOptionalAudioChannelVarArray(IDeserializer iDeserializer) {
        AudioChannel[] audioChannelArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioChannelArray = new AudioChannel[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioChannelArray[i2] = AudioChannelSerializer.getOptionalAudioChannel(iDeserializer);
            }
        }
        return audioChannelArray;
    }
}

