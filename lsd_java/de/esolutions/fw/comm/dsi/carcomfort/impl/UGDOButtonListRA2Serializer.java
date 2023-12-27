/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSpecialFeaturesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA2Serializer {
    public static void putOptionalUGDOButtonListRA2(ISerializer iSerializer, UGDOButtonListRA2 uGDOButtonListRA2) {
        boolean bl = uGDOButtonListRA2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListRA2.getPos();
            iSerializer.putInt32(n);
            int n2 = uGDOButtonListRA2.getLearnedState();
            iSerializer.putInt32(n2);
            UGDOSpecialFeatures uGDOSpecialFeatures = uGDOButtonListRA2.getSpecialFeatures();
            UGDOSpecialFeaturesSerializer.putOptionalUGDOSpecialFeatures(iSerializer, uGDOSpecialFeatures);
        }
    }

    public static void putOptionalUGDOButtonListRA2VarArray(ISerializer iSerializer, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        boolean bl = uGDOButtonListRA2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListRA2Array.length);
            for (int i2 = 0; i2 < uGDOButtonListRA2Array.length; ++i2) {
                UGDOButtonListRA2Serializer.putOptionalUGDOButtonListRA2(iSerializer, uGDOButtonListRA2Array[i2]);
            }
        }
    }

    public static UGDOButtonListRA2 getOptionalUGDOButtonListRA2(IDeserializer iDeserializer) {
        UGDOButtonListRA2 uGDOButtonListRA2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UGDOSpecialFeatures uGDOSpecialFeatures;
            int n;
            int n2;
            uGDOButtonListRA2 = new UGDOButtonListRA2();
            uGDOButtonListRA2.pos = n2 = iDeserializer.getInt32();
            uGDOButtonListRA2.learnedState = n = iDeserializer.getInt32();
            uGDOButtonListRA2.specialFeatures = uGDOSpecialFeatures = UGDOSpecialFeaturesSerializer.getOptionalUGDOSpecialFeatures(iDeserializer);
        }
        return uGDOButtonListRA2;
    }

    public static UGDOButtonListRA2[] getOptionalUGDOButtonListRA2VarArray(IDeserializer iDeserializer) {
        UGDOButtonListRA2[] uGDOButtonListRA2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListRA2Array = new UGDOButtonListRA2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListRA2Array[i2] = UGDOButtonListRA2Serializer.getOptionalUGDOButtonListRA2(iDeserializer);
            }
        }
        return uGDOButtonListRA2Array;
    }
}

