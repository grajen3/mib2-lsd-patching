/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class ChapterInfo {
    public int activeChapter;
    public int numChapters;
    public long activeChapterFirstTimePos;
    public long activeChapterLastTimePos;

    public ChapterInfo() {
        this.activeChapter = 0;
        this.numChapters = 0;
        this.activeChapterFirstTimePos = 0L;
        this.activeChapterLastTimePos = 0L;
    }

    public ChapterInfo(int n, int n2, long l, long l2) {
        this.activeChapter = n;
        this.numChapters = n2;
        this.activeChapterFirstTimePos = l;
        this.activeChapterLastTimePos = l2;
    }

    public int getActiveChapter() {
        return this.activeChapter;
    }

    public int getNumChapters() {
        return this.numChapters;
    }

    public long getActiveChapterFirstTimePos() {
        return this.activeChapterFirstTimePos;
    }

    public long getActiveChapterLastTimePos() {
        return this.activeChapterLastTimePos;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("ChapterInfo");
        stringBuffer.append('(');
        stringBuffer.append("activeChapter");
        stringBuffer.append('=');
        stringBuffer.append(this.activeChapter);
        stringBuffer.append(',');
        stringBuffer.append("numChapters");
        stringBuffer.append('=');
        stringBuffer.append(this.numChapters);
        stringBuffer.append(',');
        stringBuffer.append("activeChapterFirstTimePos");
        stringBuffer.append('=');
        stringBuffer.append(this.activeChapterFirstTimePos);
        stringBuffer.append(',');
        stringBuffer.append("activeChapterLastTimePos");
        stringBuffer.append('=');
        stringBuffer.append(this.activeChapterLastTimePos);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

