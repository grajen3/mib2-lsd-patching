/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SoundRangeSerializer {
    public static void putOptionalSoundRange(ISerializer iSerializer, SoundRange soundRange) {
        boolean bl = soundRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = soundRange.getMin();
            iSerializer.putInt32(n);
            int n2 = soundRange.getMax();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalSoundRangeVarArray(ISerializer iSerializer, SoundRange[] soundRangeArray) {
        boolean bl = soundRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(soundRangeArray.length);
            for (int i2 = 0; i2 < soundRangeArray.length; ++i2) {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRangeArray[i2]);
            }
        }
    }

    public static SoundRange getOptionalSoundRange(IDeserializer iDeserializer) {
        SoundRange soundRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            soundRange = new SoundRange();
            soundRange.min = n2 = iDeserializer.getInt32();
            soundRange.max = n = iDeserializer.getInt32();
        }
        return soundRange;
    }

    public static SoundRange[] getOptionalSoundRangeVarArray(IDeserializer iDeserializer) {
        SoundRange[] soundRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            soundRangeArray = new SoundRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                soundRangeArray[i2] = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
            }
        }
        return soundRangeArray;
    }
}

