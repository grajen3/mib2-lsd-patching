/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.audio.AmplifierCapabilities;

public class AmplifierCapabilitiesSerializer {
    public static void putOptionalAmplifierCapabilities(ISerializer iSerializer, AmplifierCapabilities amplifierCapabilities) {
        boolean bl = amplifierCapabilities == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = amplifierCapabilities.getAmplifier();
            iSerializer.putInt32(n);
            boolean bl2 = amplifierCapabilities.isBalance();
            iSerializer.putBool(bl2);
            boolean bl3 = amplifierCapabilities.isFader();
            iSerializer.putBool(bl3);
            boolean bl4 = amplifierCapabilities.isSubwoofer();
            iSerializer.putBool(bl4);
            int n2 = amplifierCapabilities.getEqualizer();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalAmplifierCapabilitiesVarArray(ISerializer iSerializer, AmplifierCapabilities[] amplifierCapabilitiesArray) {
        boolean bl = amplifierCapabilitiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(amplifierCapabilitiesArray.length);
            for (int i2 = 0; i2 < amplifierCapabilitiesArray.length; ++i2) {
                AmplifierCapabilitiesSerializer.putOptionalAmplifierCapabilities(iSerializer, amplifierCapabilitiesArray[i2]);
            }
        }
    }

    public static AmplifierCapabilities getOptionalAmplifierCapabilities(IDeserializer iDeserializer) {
        AmplifierCapabilities amplifierCapabilities = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            int n2;
            amplifierCapabilities = new AmplifierCapabilities();
            amplifierCapabilities.amplifier = n2 = iDeserializer.getInt32();
            amplifierCapabilities.balance = bl4 = iDeserializer.getBool();
            amplifierCapabilities.fader = bl3 = iDeserializer.getBool();
            amplifierCapabilities.subwoofer = bl2 = iDeserializer.getBool();
            amplifierCapabilities.equalizer = n = iDeserializer.getInt32();
        }
        return amplifierCapabilities;
    }

    public static AmplifierCapabilities[] getOptionalAmplifierCapabilitiesVarArray(IDeserializer iDeserializer) {
        AmplifierCapabilities[] amplifierCapabilitiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            amplifierCapabilitiesArray = new AmplifierCapabilities[n];
            for (int i2 = 0; i2 < n; ++i2) {
                amplifierCapabilitiesArray[i2] = AmplifierCapabilitiesSerializer.getOptionalAmplifierCapabilities(iDeserializer);
            }
        }
        return amplifierCapabilitiesArray;
    }
}

