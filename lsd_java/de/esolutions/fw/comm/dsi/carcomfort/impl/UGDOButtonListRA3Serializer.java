/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSpecialFeaturesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA3Serializer {
    public static void putOptionalUGDOButtonListRA3(ISerializer iSerializer, UGDOButtonListRA3 uGDOButtonListRA3) {
        boolean bl = uGDOButtonListRA3 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListRA3.getPos();
            iSerializer.putInt32(n);
            UGDOSpecialFeatures uGDOSpecialFeatures = uGDOButtonListRA3.getSpecialFeatures();
            UGDOSpecialFeaturesSerializer.putOptionalUGDOSpecialFeatures(iSerializer, uGDOSpecialFeatures);
        }
    }

    public static void putOptionalUGDOButtonListRA3VarArray(ISerializer iSerializer, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        boolean bl = uGDOButtonListRA3Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListRA3Array.length);
            for (int i2 = 0; i2 < uGDOButtonListRA3Array.length; ++i2) {
                UGDOButtonListRA3Serializer.putOptionalUGDOButtonListRA3(iSerializer, uGDOButtonListRA3Array[i2]);
            }
        }
    }

    public static UGDOButtonListRA3 getOptionalUGDOButtonListRA3(IDeserializer iDeserializer) {
        UGDOButtonListRA3 uGDOButtonListRA3 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UGDOSpecialFeatures uGDOSpecialFeatures;
            int n;
            uGDOButtonListRA3 = new UGDOButtonListRA3();
            uGDOButtonListRA3.pos = n = iDeserializer.getInt32();
            uGDOButtonListRA3.specialFeatures = uGDOSpecialFeatures = UGDOSpecialFeaturesSerializer.getOptionalUGDOSpecialFeatures(iDeserializer);
        }
        return uGDOButtonListRA3;
    }

    public static UGDOButtonListRA3[] getOptionalUGDOButtonListRA3VarArray(IDeserializer iDeserializer) {
        UGDOButtonListRA3[] uGDOButtonListRA3Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListRA3Array = new UGDOButtonListRA3[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListRA3Array[i2] = UGDOButtonListRA3Serializer.getOptionalUGDOButtonListRA3(iDeserializer);
            }
        }
        return uGDOButtonListRA3Array;
    }
}

