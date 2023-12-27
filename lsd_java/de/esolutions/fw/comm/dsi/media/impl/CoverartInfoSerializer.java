/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.CoverartInfo;

public class CoverartInfoSerializer {
    public static void putOptionalCoverartInfo(ISerializer iSerializer, CoverartInfo coverartInfo) {
        boolean bl = coverartInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = coverartInfo.getArtist();
            iSerializer.putOptionalString(string);
            String string2 = coverartInfo.getAlbum();
            iSerializer.putOptionalString(string2);
            String string3 = coverartInfo.getTitle();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalCoverartInfoVarArray(ISerializer iSerializer, CoverartInfo[] coverartInfoArray) {
        boolean bl = coverartInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(coverartInfoArray.length);
            for (int i2 = 0; i2 < coverartInfoArray.length; ++i2) {
                CoverartInfoSerializer.putOptionalCoverartInfo(iSerializer, coverartInfoArray[i2]);
            }
        }
    }

    public static CoverartInfo getOptionalCoverartInfo(IDeserializer iDeserializer) {
        CoverartInfo coverartInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            coverartInfo = new CoverartInfo();
            coverartInfo.artist = string3 = iDeserializer.getOptionalString();
            coverartInfo.album = string2 = iDeserializer.getOptionalString();
            coverartInfo.title = string = iDeserializer.getOptionalString();
        }
        return coverartInfo;
    }

    public static CoverartInfo[] getOptionalCoverartInfoVarArray(IDeserializer iDeserializer) {
        CoverartInfo[] coverartInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            coverartInfoArray = new CoverartInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                coverartInfoArray[i2] = CoverartInfoSerializer.getOptionalCoverartInfo(iDeserializer);
            }
        }
        return coverartInfoArray;
    }
}

