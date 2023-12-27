/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class VolumeLockStateSerializer {
    public static void putOptionalVolumeLockState(ISerializer iSerializer, VolumeLockState volumeLockState) {
        boolean bl = volumeLockState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = volumeLockState.getAudioContext();
            iSerializer.putInt32(n);
            int n2 = volumeLockState.getState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalVolumeLockStateVarArray(ISerializer iSerializer, VolumeLockState[] volumeLockStateArray) {
        boolean bl = volumeLockStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(volumeLockStateArray.length);
            for (int i2 = 0; i2 < volumeLockStateArray.length; ++i2) {
                VolumeLockStateSerializer.putOptionalVolumeLockState(iSerializer, volumeLockStateArray[i2]);
            }
        }
    }

    public static VolumeLockState getOptionalVolumeLockState(IDeserializer iDeserializer) {
        VolumeLockState volumeLockState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            volumeLockState = new VolumeLockState();
            volumeLockState.audioContext = n2 = iDeserializer.getInt32();
            volumeLockState.state = n = iDeserializer.getInt32();
        }
        return volumeLockState;
    }

    public static VolumeLockState[] getOptionalVolumeLockStateVarArray(IDeserializer iDeserializer) {
        VolumeLockState[] volumeLockStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            volumeLockStateArray = new VolumeLockState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                volumeLockStateArray[i2] = VolumeLockStateSerializer.getOptionalVolumeLockState(iDeserializer);
            }
        }
        return volumeLockStateArray;
    }
}

