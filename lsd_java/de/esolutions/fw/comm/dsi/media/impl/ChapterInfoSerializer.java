/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.ChapterInfo;

public class ChapterInfoSerializer {
    public static void putOptionalChapterInfo(ISerializer iSerializer, ChapterInfo chapterInfo) {
        boolean bl = chapterInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = chapterInfo.getActiveChapter();
            iSerializer.putInt32(n);
            int n2 = chapterInfo.getNumChapters();
            iSerializer.putInt32(n2);
            long l = chapterInfo.getActiveChapterFirstTimePos();
            iSerializer.putInt64(l);
            long l2 = chapterInfo.getActiveChapterLastTimePos();
            iSerializer.putInt64(l2);
        }
    }

    public static void putOptionalChapterInfoVarArray(ISerializer iSerializer, ChapterInfo[] chapterInfoArray) {
        boolean bl = chapterInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(chapterInfoArray.length);
            for (int i2 = 0; i2 < chapterInfoArray.length; ++i2) {
                ChapterInfoSerializer.putOptionalChapterInfo(iSerializer, chapterInfoArray[i2]);
            }
        }
    }

    public static ChapterInfo getOptionalChapterInfo(IDeserializer iDeserializer) {
        ChapterInfo chapterInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            long l2;
            int n;
            int n2;
            chapterInfo = new ChapterInfo();
            chapterInfo.activeChapter = n2 = iDeserializer.getInt32();
            chapterInfo.numChapters = n = iDeserializer.getInt32();
            chapterInfo.activeChapterFirstTimePos = l2 = iDeserializer.getInt64();
            chapterInfo.activeChapterLastTimePos = l = iDeserializer.getInt64();
        }
        return chapterInfo;
    }

    public static ChapterInfo[] getOptionalChapterInfoVarArray(IDeserializer iDeserializer) {
        ChapterInfo[] chapterInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            chapterInfoArray = new ChapterInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                chapterInfoArray[i2] = ChapterInfoSerializer.getOptionalChapterInfo(iDeserializer);
            }
        }
        return chapterInfoArray;
    }
}

