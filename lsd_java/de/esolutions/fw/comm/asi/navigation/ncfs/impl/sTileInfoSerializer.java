/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTileInfoSerializer {
    public static void putOptionalsTileInfo(ISerializer iSerializer, sTileInfo sTileInfo2) {
        boolean bl = sTileInfo2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTileInfo2.getId();
            iSerializer.putUInt32(l);
            long l2 = sTileInfo2.getVersion();
            iSerializer.putInt64(l2);
            int n = sTileInfo2.getExpiration();
            iSerializer.putInt32(n);
            sBoundingBox sBoundingBox2 = sTileInfo2.getBoundingBox();
            sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
        }
    }

    public static void putOptionalsTileInfoVarArray(ISerializer iSerializer, sTileInfo[] sTileInfoArray) {
        boolean bl = sTileInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTileInfoArray.length);
            for (int i2 = 0; i2 < sTileInfoArray.length; ++i2) {
                sTileInfoSerializer.putOptionalsTileInfo(iSerializer, sTileInfoArray[i2]);
            }
        }
    }

    public static sTileInfo getOptionalsTileInfo(IDeserializer iDeserializer) {
        sTileInfo sTileInfo2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            sBoundingBox sBoundingBox2;
            int n;
            long l;
            long l2;
            sTileInfo2 = new sTileInfo();
            sTileInfo2.id = l2 = iDeserializer.getUInt32();
            sTileInfo2.version = l = iDeserializer.getInt64();
            sTileInfo2.expiration = n = iDeserializer.getInt32();
            sTileInfo2.boundingBox = sBoundingBox2 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
        }
        return sTileInfo2;
    }

    public static sTileInfo[] getOptionalsTileInfoVarArray(IDeserializer iDeserializer) {
        sTileInfo[] sTileInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTileInfoArray = new sTileInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTileInfoArray[i2] = sTileInfoSerializer.getOptionalsTileInfo(iDeserializer);
            }
        }
        return sTileInfoArray;
    }
}

