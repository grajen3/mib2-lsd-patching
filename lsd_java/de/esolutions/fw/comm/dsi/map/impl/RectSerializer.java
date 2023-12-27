/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.map.Rect;

public class RectSerializer {
    public static void putOptionalRect(ISerializer iSerializer, Rect rect) {
        boolean bl = rect == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rect.getKordX();
            iSerializer.putInt32(n);
            int n2 = rect.getKordY();
            iSerializer.putInt32(n2);
            int n3 = rect.getDiffX();
            iSerializer.putInt32(n3);
            int n4 = rect.getDiffY();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalRectVarArray(ISerializer iSerializer, Rect[] rectArray) {
        boolean bl = rectArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rectArray.length);
            for (int i2 = 0; i2 < rectArray.length; ++i2) {
                RectSerializer.putOptionalRect(iSerializer, rectArray[i2]);
            }
        }
    }

    public static Rect getOptionalRect(IDeserializer iDeserializer) {
        Rect rect = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            rect = new Rect();
            rect.kordX = n4 = iDeserializer.getInt32();
            rect.kordY = n3 = iDeserializer.getInt32();
            rect.diffX = n2 = iDeserializer.getInt32();
            rect.diffY = n = iDeserializer.getInt32();
        }
        return rect;
    }

    public static Rect[] getOptionalRectVarArray(IDeserializer iDeserializer) {
        Rect[] rectArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rectArray = new Rect[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rectArray[i2] = RectSerializer.getOptionalRect(iDeserializer);
            }
        }
        return rectArray;
    }
}

