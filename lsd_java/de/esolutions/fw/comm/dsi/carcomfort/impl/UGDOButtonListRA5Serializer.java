/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;

public class UGDOButtonListRA5Serializer {
    public static void putOptionalUGDOButtonListRA5(ISerializer iSerializer, UGDOButtonListRA5 uGDOButtonListRA5) {
        boolean bl = uGDOButtonListRA5 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListRA5.getPos();
            iSerializer.putInt32(n);
            int n2 = uGDOButtonListRA5.getLearnedState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalUGDOButtonListRA5VarArray(ISerializer iSerializer, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        boolean bl = uGDOButtonListRA5Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListRA5Array.length);
            for (int i2 = 0; i2 < uGDOButtonListRA5Array.length; ++i2) {
                UGDOButtonListRA5Serializer.putOptionalUGDOButtonListRA5(iSerializer, uGDOButtonListRA5Array[i2]);
            }
        }
    }

    public static UGDOButtonListRA5 getOptionalUGDOButtonListRA5(IDeserializer iDeserializer) {
        UGDOButtonListRA5 uGDOButtonListRA5 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            uGDOButtonListRA5 = new UGDOButtonListRA5();
            uGDOButtonListRA5.pos = n2 = iDeserializer.getInt32();
            uGDOButtonListRA5.learnedState = n = iDeserializer.getInt32();
        }
        return uGDOButtonListRA5;
    }

    public static UGDOButtonListRA5[] getOptionalUGDOButtonListRA5VarArray(IDeserializer iDeserializer) {
        UGDOButtonListRA5[] uGDOButtonListRA5Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListRA5Array = new UGDOButtonListRA5[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListRA5Array[i2] = UGDOButtonListRA5Serializer.getOptionalUGDOButtonListRA5(iDeserializer);
            }
        }
        return uGDOButtonListRA5Array;
    }
}

