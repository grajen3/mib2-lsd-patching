/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSpecialFeaturesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA0Serializer {
    public static void putOptionalUGDOButtonListRA0(ISerializer iSerializer, UGDOButtonListRA0 uGDOButtonListRA0) {
        boolean bl = uGDOButtonListRA0 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListRA0.getPos();
            iSerializer.putInt32(n);
            String string = uGDOButtonListRA0.getName();
            iSerializer.putOptionalString(string);
            float f2 = uGDOButtonListRA0.getPositionLatitude();
            iSerializer.putFloat(f2);
            float f3 = uGDOButtonListRA0.getPositionLongitude();
            iSerializer.putFloat(f3);
            int n2 = uGDOButtonListRA0.getLearnedState();
            iSerializer.putInt32(n2);
            int n3 = uGDOButtonListRA0.getHardkey();
            iSerializer.putInt32(n3);
            int n4 = uGDOButtonListRA0.getSoftkey();
            iSerializer.putInt32(n4);
            UGDOSpecialFeatures uGDOSpecialFeatures = uGDOButtonListRA0.getSpecialFeatures();
            UGDOSpecialFeaturesSerializer.putOptionalUGDOSpecialFeatures(iSerializer, uGDOSpecialFeatures);
        }
    }

    public static void putOptionalUGDOButtonListRA0VarArray(ISerializer iSerializer, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        boolean bl = uGDOButtonListRA0Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListRA0Array.length);
            for (int i2 = 0; i2 < uGDOButtonListRA0Array.length; ++i2) {
                UGDOButtonListRA0Serializer.putOptionalUGDOButtonListRA0(iSerializer, uGDOButtonListRA0Array[i2]);
            }
        }
    }

    public static UGDOButtonListRA0 getOptionalUGDOButtonListRA0(IDeserializer iDeserializer) {
        UGDOButtonListRA0 uGDOButtonListRA0 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            UGDOSpecialFeatures uGDOSpecialFeatures;
            int n;
            int n2;
            int n3;
            float f2;
            float f3;
            String string;
            int n4;
            uGDOButtonListRA0 = new UGDOButtonListRA0();
            uGDOButtonListRA0.pos = n4 = iDeserializer.getInt32();
            uGDOButtonListRA0.name = string = iDeserializer.getOptionalString();
            uGDOButtonListRA0.positionLatitude = f3 = iDeserializer.getFloat();
            uGDOButtonListRA0.positionLongitude = f2 = iDeserializer.getFloat();
            uGDOButtonListRA0.learnedState = n3 = iDeserializer.getInt32();
            uGDOButtonListRA0.hardkey = n2 = iDeserializer.getInt32();
            uGDOButtonListRA0.softkey = n = iDeserializer.getInt32();
            uGDOButtonListRA0.specialFeatures = uGDOSpecialFeatures = UGDOSpecialFeaturesSerializer.getOptionalUGDOSpecialFeatures(iDeserializer);
        }
        return uGDOButtonListRA0;
    }

    public static UGDOButtonListRA0[] getOptionalUGDOButtonListRA0VarArray(IDeserializer iDeserializer) {
        UGDOButtonListRA0[] uGDOButtonListRA0Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListRA0Array = new UGDOButtonListRA0[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListRA0Array[i2] = UGDOButtonListRA0Serializer.getOptionalUGDOButtonListRA0(iDeserializer);
            }
        }
        return uGDOButtonListRA0Array;
    }
}

