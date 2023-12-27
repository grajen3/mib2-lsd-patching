/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.WavebandInfo;

public class WavebandInfoSerializer {
    public static void putOptionalWavebandInfo(ISerializer iSerializer, WavebandInfo wavebandInfo) {
        boolean bl = wavebandInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wavebandInfo.getWaveband();
            iSerializer.putInt32(n);
            long l = wavebandInfo.getLowerLimit();
            iSerializer.putInt64(l);
            long l2 = wavebandInfo.getUpperLimit();
            iSerializer.putInt64(l2);
            long l3 = wavebandInfo.getStepWidth();
            iSerializer.putInt64(l3);
            long l4 = wavebandInfo.getMultiplier();
            iSerializer.putInt64(l4);
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
            long l;
            long l2;
            long l3;
            long l4;
            int n;
            wavebandInfo = new WavebandInfo();
            wavebandInfo.waveband = n = iDeserializer.getInt32();
            wavebandInfo.lowerLimit = l4 = iDeserializer.getInt64();
            wavebandInfo.upperLimit = l3 = iDeserializer.getInt64();
            wavebandInfo.stepWidth = l2 = iDeserializer.getInt64();
            wavebandInfo.multiplier = l = iDeserializer.getInt64();
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

