/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.MissedCallIndicator;

public class MissedCallIndicatorSerializer {
    public static void putOptionalMissedCallIndicator(ISerializer iSerializer, MissedCallIndicator missedCallIndicator) {
        boolean bl = missedCallIndicator == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = missedCallIndicator.isMissedCall();
            iSerializer.putBool(bl2);
            int n = missedCallIndicator.getMissedCallCount();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalMissedCallIndicatorVarArray(ISerializer iSerializer, MissedCallIndicator[] missedCallIndicatorArray) {
        boolean bl = missedCallIndicatorArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(missedCallIndicatorArray.length);
            for (int i2 = 0; i2 < missedCallIndicatorArray.length; ++i2) {
                MissedCallIndicatorSerializer.putOptionalMissedCallIndicator(iSerializer, missedCallIndicatorArray[i2]);
            }
        }
    }

    public static MissedCallIndicator getOptionalMissedCallIndicator(IDeserializer iDeserializer) {
        MissedCallIndicator missedCallIndicator = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            missedCallIndicator = new MissedCallIndicator();
            missedCallIndicator.missedCall = bl2 = iDeserializer.getBool();
            missedCallIndicator.missedCallCount = n = iDeserializer.getInt32();
        }
        return missedCallIndicator;
    }

    public static MissedCallIndicator[] getOptionalMissedCallIndicatorVarArray(IDeserializer iDeserializer) {
        MissedCallIndicator[] missedCallIndicatorArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            missedCallIndicatorArray = new MissedCallIndicator[n];
            for (int i2 = 0; i2 < n; ++i2) {
                missedCallIndicatorArray[i2] = MissedCallIndicatorSerializer.getOptionalMissedCallIndicator(iDeserializer);
            }
        }
        return missedCallIndicatorArray;
    }
}

