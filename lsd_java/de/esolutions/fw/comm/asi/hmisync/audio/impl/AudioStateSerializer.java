/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AudioStateSerializer {
    public static void putOptionalAudioState(ISerializer iSerializer, AudioState audioState) {
        boolean bl = audioState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = audioState.getAudioContext();
            iSerializer.putInt32(n);
            int n2 = audioState.getAudioState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalAudioStateVarArray(ISerializer iSerializer, AudioState[] audioStateArray) {
        boolean bl = audioStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(audioStateArray.length);
            for (int i2 = 0; i2 < audioStateArray.length; ++i2) {
                AudioStateSerializer.putOptionalAudioState(iSerializer, audioStateArray[i2]);
            }
        }
    }

    public static AudioState getOptionalAudioState(IDeserializer iDeserializer) {
        AudioState audioState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            audioState = new AudioState();
            audioState.audioContext = n2 = iDeserializer.getInt32();
            audioState.audioState = n = iDeserializer.getInt32();
        }
        return audioState;
    }

    public static AudioState[] getOptionalAudioStateVarArray(IDeserializer iDeserializer) {
        AudioState[] audioStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            audioStateArray = new AudioState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                audioStateArray[i2] = AudioStateSerializer.getOptionalAudioState(iDeserializer);
            }
        }
        return audioStateArray;
    }
}

