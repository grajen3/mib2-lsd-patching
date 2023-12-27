/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.PlaymodeInfo;

public class PlaymodeInfoSerializer {
    public static void putOptionalPlaymodeInfo(ISerializer iSerializer, PlaymodeInfo playmodeInfo) {
        boolean bl = playmodeInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = playmodeInfo.getShuffleMode();
            iSerializer.putInt32(n);
            int n2 = playmodeInfo.getRepeatMode();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPlaymodeInfoVarArray(ISerializer iSerializer, PlaymodeInfo[] playmodeInfoArray) {
        boolean bl = playmodeInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(playmodeInfoArray.length);
            for (int i2 = 0; i2 < playmodeInfoArray.length; ++i2) {
                PlaymodeInfoSerializer.putOptionalPlaymodeInfo(iSerializer, playmodeInfoArray[i2]);
            }
        }
    }

    public static PlaymodeInfo getOptionalPlaymodeInfo(IDeserializer iDeserializer) {
        PlaymodeInfo playmodeInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            playmodeInfo = new PlaymodeInfo();
            playmodeInfo.shuffleMode = n2 = iDeserializer.getInt32();
            playmodeInfo.repeatMode = n = iDeserializer.getInt32();
        }
        return playmodeInfo;
    }

    public static PlaymodeInfo[] getOptionalPlaymodeInfoVarArray(IDeserializer iDeserializer) {
        PlaymodeInfo[] playmodeInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            playmodeInfoArray = new PlaymodeInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                playmodeInfoArray[i2] = PlaymodeInfoSerializer.getOptionalPlaymodeInfo(iDeserializer);
            }
        }
        return playmodeInfoArray;
    }
}

