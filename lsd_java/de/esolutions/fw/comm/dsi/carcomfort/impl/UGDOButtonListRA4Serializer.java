/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;

public class UGDOButtonListRA4Serializer {
    public static void putOptionalUGDOButtonListRA4(ISerializer iSerializer, UGDOButtonListRA4 uGDOButtonListRA4) {
        boolean bl = uGDOButtonListRA4 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOButtonListRA4.getPos();
            iSerializer.putInt32(n);
            String string = uGDOButtonListRA4.getName();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalUGDOButtonListRA4VarArray(ISerializer iSerializer, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        boolean bl = uGDOButtonListRA4Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOButtonListRA4Array.length);
            for (int i2 = 0; i2 < uGDOButtonListRA4Array.length; ++i2) {
                UGDOButtonListRA4Serializer.putOptionalUGDOButtonListRA4(iSerializer, uGDOButtonListRA4Array[i2]);
            }
        }
    }

    public static UGDOButtonListRA4 getOptionalUGDOButtonListRA4(IDeserializer iDeserializer) {
        UGDOButtonListRA4 uGDOButtonListRA4 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            uGDOButtonListRA4 = new UGDOButtonListRA4();
            uGDOButtonListRA4.pos = n = iDeserializer.getInt32();
            uGDOButtonListRA4.name = string = iDeserializer.getOptionalString();
        }
        return uGDOButtonListRA4;
    }

    public static UGDOButtonListRA4[] getOptionalUGDOButtonListRA4VarArray(IDeserializer iDeserializer) {
        UGDOButtonListRA4[] uGDOButtonListRA4Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOButtonListRA4Array = new UGDOButtonListRA4[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOButtonListRA4Array[i2] = UGDOButtonListRA4Serializer.getOptionalUGDOButtonListRA4(iDeserializer);
            }
        }
        return uGDOButtonListRA4Array;
    }
}

