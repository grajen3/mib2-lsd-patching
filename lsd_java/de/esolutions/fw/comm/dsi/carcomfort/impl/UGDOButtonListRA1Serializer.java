/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSpecialFeaturesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA1Serializer {
    public static void putOptionalUGDOButtonListRA1(ISerializer iSerializer, UGDOButtonListRA1 uGDOButtonListRA1) {
        boolean bl = uGDOButtonListRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListRA1.getPos();
            iSerializer.putInt32(n);
            float f2 = uGDOButtonListRA1.getPositionLatitude();
            iSerializer.putFloat(f2);
            float f3 = uGDOButtonListRA1.getPositionLongitude();
            iSerializer.putFloat(f3);
            int n2 = uGDOButtonListRA1.getLearnedState();
            iSerializer.putInt32(n2);
            UGDOSpecialFeatures uGDOSpecialFeatures = uGDOButtonListRA1.getSpecialFeatures();
            UGDOSpecialFeaturesSerializer.putOptionalUGDOSpecialFeatures(iSerializer, uGDOSpecialFeatures);
        }
    }

    public static void putOptionalUGDOButtonListRA1VarArray(ISerializer iSerializer, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        boolean bl = uGDOButtonListRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListRA1Array.length);
            for (int i2 = 0; i2 < uGDOButtonListRA1Array.length; ++i2) {
                UGDOButtonListRA1Serializer.putOptionalUGDOButtonListRA1(iSerializer, uGDOButtonListRA1Array[i2]);
            }
        }
    }

    public static UGDOButtonListRA1 getOptionalUGDOButtonListRA1(IDeserializer iDeserializer) {
        UGDOButtonListRA1 uGDOButtonListRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UGDOSpecialFeatures uGDOSpecialFeatures;
            int n;
            float f2;
            float f3;
            int n2;
            uGDOButtonListRA1 = new UGDOButtonListRA1();
            uGDOButtonListRA1.pos = n2 = iDeserializer.getInt32();
            uGDOButtonListRA1.positionLatitude = f3 = iDeserializer.getFloat();
            uGDOButtonListRA1.positionLongitude = f2 = iDeserializer.getFloat();
            uGDOButtonListRA1.learnedState = n = iDeserializer.getInt32();
            uGDOButtonListRA1.specialFeatures = uGDOSpecialFeatures = UGDOSpecialFeaturesSerializer.getOptionalUGDOSpecialFeatures(iDeserializer);
        }
        return uGDOButtonListRA1;
    }

    public static UGDOButtonListRA1[] getOptionalUGDOButtonListRA1VarArray(IDeserializer iDeserializer) {
        UGDOButtonListRA1[] uGDOButtonListRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListRA1Array = new UGDOButtonListRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListRA1Array[i2] = UGDOButtonListRA1Serializer.getOptionalUGDOButtonListRA1(iDeserializer);
            }
        }
        return uGDOButtonListRA1Array;
    }
}

