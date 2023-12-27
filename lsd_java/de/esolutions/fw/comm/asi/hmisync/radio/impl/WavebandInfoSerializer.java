/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class WavebandInfoSerializer {
    public static void putOptionalWavebandInfo(ISerializer iSerializer, WavebandInfo wavebandInfo) {
        boolean bl = wavebandInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wavebandInfo.getBandId();
            iSerializer.putInt32(n);
            int n2 = wavebandInfo.getMinFrequency();
            iSerializer.putInt32(n2);
            int n3 = wavebandInfo.getMaxFrequency();
            iSerializer.putInt32(n3);
            int n4 = wavebandInfo.getStepWidth();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalWavebandInfoVarArray(ISerializer iSerializer, WavebandInfo[] wavebandInfoArray) {
        boolean bl = wavebandInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wavebandInfoArray.length);
            for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
                WavebandInfoSerializer.putOptionalWavebandInfo(iSerializer, wavebandInfoArray[i2]);
            }
        }
    }

    public static WavebandInfo getOptionalWavebandInfo(IDeserializer iDeserializer) {
        WavebandInfo wavebandInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            wavebandInfo = new WavebandInfo();
            wavebandInfo.bandId = n4 = iDeserializer.getInt32();
            wavebandInfo.minFrequency = n3 = iDeserializer.getInt32();
            wavebandInfo.maxFrequency = n2 = iDeserializer.getInt32();
            wavebandInfo.stepWidth = n = iDeserializer.getInt32();
        }
        return wavebandInfo;
    }

    public static WavebandInfo[] getOptionalWavebandInfoVarArray(IDeserializer iDeserializer) {
        WavebandInfo[] wavebandInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wavebandInfoArray = new WavebandInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wavebandInfoArray[i2] = WavebandInfoSerializer.getOptionalWavebandInfo(iDeserializer);
            }
        }
        return wavebandInfoArray;
    }
}

