/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOContent;

public class UGDOContentSerializer {
    public static void putOptionalUGDOContent(ISerializer iSerializer, UGDOContent uGDOContent) {
        boolean bl = uGDOContent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOContent.getHardkey();
            iSerializer.putInt32(n);
            int n2 = uGDOContent.getSoftkey();
            iSerializer.putInt32(n2);
            int n3 = uGDOContent.getContent();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalUGDOContentVarArray(ISerializer iSerializer, UGDOContent[] uGDOContentArray) {
        boolean bl = uGDOContentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOContentArray.length);
            for (int i2 = 0; i2 < uGDOContentArray.length; ++i2) {
                UGDOContentSerializer.putOptionalUGDOContent(iSerializer, uGDOContentArray[i2]);
            }
        }
    }

    public static UGDOContent getOptionalUGDOContent(IDeserializer iDeserializer) {
        UGDOContent uGDOContent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            uGDOContent = new UGDOContent();
            uGDOContent.hardkey = n3 = iDeserializer.getInt32();
            uGDOContent.softkey = n2 = iDeserializer.getInt32();
            uGDOContent.content = n = iDeserializer.getInt32();
        }
        return uGDOContent;
    }

    public static UGDOContent[] getOptionalUGDOContentVarArray(IDeserializer iDeserializer) {
        UGDOContent[] uGDOContentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOContentArray = new UGDOContent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOContentArray[i2] = UGDOContentSerializer.getOptionalUGDOContent(iDeserializer);
            }
        }
        return uGDOContentArray;
    }
}

