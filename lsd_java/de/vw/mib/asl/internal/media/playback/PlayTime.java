/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

public class PlayTime {
    private final int mTotalTime;
    private final int mPlayTime;
    private final boolean mTotalTimeChanged;
    private final boolean mPlayTimeChanged;

    public PlayTime(int n, int n2, PlayTime playTime) {
        this.mTotalTime = n;
        this.mPlayTime = n2;
        this.mTotalTimeChanged = playTime == null || playTime.getTotalTime() != n;
        this.mPlayTimeChanged = playTime == null || playTime.getPlayTime() != n2;
    }

    public int getPlayTime() {
        return this.mPlayTime;
    }

    public int getTotalTime() {
        return this.mTotalTime;
    }

    public boolean hasTotalTimeChanged() {
        return this.mTotalTimeChanged;
    }

    public boolean hasPlayTimeChanged() {
        return this.mPlayTimeChanged;
    }
}

