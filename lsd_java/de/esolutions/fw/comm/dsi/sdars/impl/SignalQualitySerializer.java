/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.SignalQuality;

public class SignalQualitySerializer {
    public static void putOptionalSignalQuality(ISerializer iSerializer, SignalQuality signalQuality) {
        boolean bl = signalQuality == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = signalQuality.getCompositeQuality();
            iSerializer.putInt32(n);
            int n2 = signalQuality.getSatelliteQuality();
            iSerializer.putInt32(n2);
            int n3 = signalQuality.getTerrestrialQuality();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSignalQualityVarArray(ISerializer iSerializer, SignalQuality[] signalQualityArray) {
        boolean bl = signalQualityArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(signalQualityArray.length);
            for (int i2 = 0; i2 < signalQualityArray.length; ++i2) {
                SignalQualitySerializer.putOptionalSignalQuality(iSerializer, signalQualityArray[i2]);
            }
        }
    }

    public static SignalQuality getOptionalSignalQuality(IDeserializer iDeserializer) {
        SignalQuality signalQuality = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            signalQuality = new SignalQuality();
            signalQuality.compositeQuality = n3 = iDeserializer.getInt32();
            signalQuality.satelliteQuality = n2 = iDeserializer.getInt32();
            signalQuality.terrestrialQuality = n = iDeserializer.getInt32();
        }
        return signalQuality;
    }

    public static SignalQuality[] getOptionalSignalQualityVarArray(IDeserializer iDeserializer) {
        SignalQuality[] signalQualityArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            signalQualityArray = new SignalQuality[n];
            for (int i2 = 0; i2 < n; ++i2) {
                signalQualityArray[i2] = SignalQualitySerializer.getOptionalSignalQuality(iDeserializer);
            }
        }
        return signalQualityArray;
    }
}

