/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sBoundingBoxSerializer {
    public static void putOptionalsBoundingBox(ISerializer iSerializer, sBoundingBox sBoundingBox2) {
        boolean bl = sBoundingBox2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = sBoundingBox2.getMinLat();
            iSerializer.putFloat(f2);
            float f3 = sBoundingBox2.getMinLong();
            iSerializer.putFloat(f3);
            float f4 = sBoundingBox2.getMaxLat();
            iSerializer.putFloat(f4);
            float f5 = sBoundingBox2.getMaxLong();
            iSerializer.putFloat(f5);
        }
    }

    public static void putOptionalsBoundingBoxVarArray(ISerializer iSerializer, sBoundingBox[] sBoundingBoxArray) {
        boolean bl = sBoundingBoxArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sBoundingBoxArray.length);
            for (int i2 = 0; i2 < sBoundingBoxArray.length; ++i2) {
                sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBoxArray[i2]);
            }
        }
    }

    public static sBoundingBox getOptionalsBoundingBox(IDeserializer iDeserializer) {
        sBoundingBox sBoundingBox2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            float f4;
            float f5;
            sBoundingBox2 = new sBoundingBox();
            sBoundingBox2.minLat = f5 = iDeserializer.getFloat();
            sBoundingBox2.minLong = f4 = iDeserializer.getFloat();
            sBoundingBox2.maxLat = f3 = iDeserializer.getFloat();
            sBoundingBox2.maxLong = f2 = iDeserializer.getFloat();
        }
        return sBoundingBox2;
    }

    public static sBoundingBox[] getOptionalsBoundingBoxVarArray(IDeserializer iDeserializer) {
        sBoundingBox[] sBoundingBoxArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sBoundingBoxArray = new sBoundingBox[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sBoundingBoxArray[i2] = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
            }
        }
        return sBoundingBoxArray;
    }
}

