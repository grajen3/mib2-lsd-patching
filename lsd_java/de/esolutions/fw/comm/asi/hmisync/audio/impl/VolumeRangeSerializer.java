/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class VolumeRangeSerializer {
    public static void putOptionalVolumeRange(ISerializer iSerializer, VolumeRange volumeRange) {
        boolean bl = volumeRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = volumeRange.getMin();
            iSerializer.putInt32(n);
            int n2 = volumeRange.getMax();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalVolumeRangeVarArray(ISerializer iSerializer, VolumeRange[] volumeRangeArray) {
        boolean bl = volumeRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(volumeRangeArray.length);
            for (int i2 = 0; i2 < volumeRangeArray.length; ++i2) {
                VolumeRangeSerializer.putOptionalVolumeRange(iSerializer, volumeRangeArray[i2]);
            }
        }
    }

    public static VolumeRange getOptionalVolumeRange(IDeserializer iDeserializer) {
        VolumeRange volumeRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            volumeRange = new VolumeRange();
            volumeRange.min = n2 = iDeserializer.getInt32();
            volumeRange.max = n = iDeserializer.getInt32();
        }
        return volumeRange;
    }

    public static VolumeRange[] getOptionalVolumeRangeVarArray(IDeserializer iDeserializer) {
        VolumeRange[] volumeRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            volumeRangeArray = new VolumeRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                volumeRangeArray[i2] = VolumeRangeSerializer.getOptionalVolumeRange(iDeserializer);
            }
        }
        return volumeRangeArray;
    }
}

