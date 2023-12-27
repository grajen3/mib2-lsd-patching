/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class Capabilities {
    public boolean skipFwd;
    public boolean skipBwd;
    public boolean browseWhilePlay;
    public boolean fastFwd;
    public boolean fastBwd;
    public boolean sloMoFwd;
    public boolean sloMoBwd;
    public boolean stillFwd;
    public boolean stillBwd;
    public boolean play;
    public boolean resume;
    public boolean pause;
    public boolean stop;
    public boolean setEntry;
    public boolean setTimePos;
    public boolean playbackModes;
    public boolean detailInfos;
    public boolean playView;
    public boolean playSimilarEntries;
    public boolean totalPlaytime;
    public boolean extendedPlayView;
    public boolean playTime;
    public boolean playbackModeTakeOver;
    public boolean playbackModeToggle;

    public Capabilities() {
        this.skipFwd = false;
        this.skipBwd = false;
        this.browseWhilePlay = false;
        this.fastFwd = false;
        this.fastBwd = false;
        this.sloMoFwd = false;
        this.sloMoBwd = false;
        this.stillFwd = false;
        this.stillBwd = false;
        this.play = false;
        this.resume = false;
        this.pause = false;
        this.stop = false;
        this.setEntry = false;
        this.setTimePos = false;
        this.playbackModes = false;
        this.detailInfos = false;
        this.playView = false;
        this.playSimilarEntries = false;
        this.totalPlaytime = false;
        this.extendedPlayView = false;
        this.playTime = false;
        this.playbackModeTakeOver = false;
        this.playbackModeToggle = false;
    }

    public Capabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22) {
        this.skipFwd = bl;
        this.skipBwd = bl2;
        this.browseWhilePlay = bl3;
        this.fastFwd = bl4;
        this.fastBwd = bl5;
        this.sloMoFwd = bl6;
        this.sloMoBwd = bl7;
        this.stillFwd = bl8;
        this.stillBwd = bl9;
        this.play = bl10;
        this.resume = bl11;
        this.pause = bl12;
        this.stop = bl13;
        this.setEntry = bl14;
        this.setTimePos = bl15;
        this.playbackModes = bl16;
        this.detailInfos = bl17;
        this.playView = bl18;
        this.playSimilarEntries = bl19;
        this.totalPlaytime = bl20;
        this.extendedPlayView = bl21;
        this.playTime = bl22;
        this.playbackModeTakeOver = false;
        this.playbackModeToggle = false;
    }

    public Capabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23, boolean bl24) {
        this.skipFwd = bl;
        this.skipBwd = bl2;
        this.browseWhilePlay = bl3;
        this.fastFwd = bl4;
        this.fastBwd = bl5;
        this.sloMoFwd = bl6;
        this.sloMoBwd = bl7;
        this.stillFwd = bl8;
        this.stillBwd = bl9;
        this.play = bl10;
        this.resume = bl11;
        this.pause = bl12;
        this.stop = bl13;
        this.setEntry = bl14;
        this.setTimePos = bl15;
        this.playbackModes = bl16;
        this.detailInfos = bl17;
        this.playView = bl18;
        this.playSimilarEntries = bl19;
        this.totalPlaytime = bl20;
        this.extendedPlayView = bl21;
        this.playTime = bl22;
        this.playbackModeTakeOver = bl23;
        this.playbackModeToggle = bl24;
    }

    public boolean isSkipFwd() {
        return this.skipFwd;
    }

    public boolean isSkipBwd() {
        return this.skipBwd;
    }

    public boolean isBrowseWhilePlay() {
        return this.browseWhilePlay;
    }

    public boolean isFastFwd() {
        return this.fastFwd;
    }

    public boolean isFastBwd() {
        return this.fastBwd;
    }

    public boolean isSloMoFwd() {
        return this.sloMoFwd;
    }

    public boolean isSloMoBwd() {
        return this.sloMoBwd;
    }

    public boolean isStillFwd() {
        return this.stillFwd;
    }

    public boolean isStillBwd() {
        return this.stillBwd;
    }

    public boolean isPlay() {
        return this.play;
    }

    public boolean isResume() {
        return this.resume;
    }

    public boolean isPause() {
        return this.pause;
    }

    public boolean isStop() {
        return this.stop;
    }

    public boolean isSetEntry() {
        return this.setEntry;
    }

    public boolean isSetTimePos() {
        return this.setTimePos;
    }

    public boolean isPlaybackModes() {
        return this.playbackModes;
    }

    public boolean isDetailInfos() {
        return this.detailInfos;
    }

    public boolean isPlayView() {
        return this.playView;
    }

    public boolean isPlaySimilarEntries() {
        return this.playSimilarEntries;
    }

    public boolean isTotalPlaytime() {
        return this.totalPlaytime;
    }

    public boolean isExtendedPlayView() {
        return this.extendedPlayView;
    }

    public boolean isPlayTime() {
        return this.playTime;
    }

    public boolean isPlaybackModeTakeOver() {
        return this.playbackModeTakeOver;
    }

    public boolean isPlaybackModeToggle() {
        return this.playbackModeToggle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("Capabilities");
        stringBuffer.append('(');
        stringBuffer.append("skipFwd");
        stringBuffer.append('=');
        stringBuffer.append(this.skipFwd);
        stringBuffer.append(',');
        stringBuffer.append("skipBwd");
        stringBuffer.append('=');
        stringBuffer.append(this.skipBwd);
        stringBuffer.append(',');
        stringBuffer.append("browseWhilePlay");
        stringBuffer.append('=');
        stringBuffer.append(this.browseWhilePlay);
        stringBuffer.append(',');
        stringBuffer.append("fastFwd");
        stringBuffer.append('=');
        stringBuffer.append(this.fastFwd);
        stringBuffer.append(',');
        stringBuffer.append("fastBwd");
        stringBuffer.append('=');
        stringBuffer.append(this.fastBwd);
        stringBuffer.append(',');
        stringBuffer.append("sloMoFwd");
        stringBuffer.append('=');
        stringBuffer.append(this.sloMoFwd);
        stringBuffer.append(',');
        stringBuffer.append("sloMoBwd");
        stringBuffer.append('=');
        stringBuffer.append(this.sloMoBwd);
        stringBuffer.append(',');
        stringBuffer.append("stillFwd");
        stringBuffer.append('=');
        stringBuffer.append(this.stillFwd);
        stringBuffer.append(',');
        stringBuffer.append("stillBwd");
        stringBuffer.append('=');
        stringBuffer.append(this.stillBwd);
        stringBuffer.append(',');
        stringBuffer.append("play");
        stringBuffer.append('=');
        stringBuffer.append(this.play);
        stringBuffer.append(',');
        stringBuffer.append("resume");
        stringBuffer.append('=');
        stringBuffer.append(this.resume);
        stringBuffer.append(',');
        stringBuffer.append("pause");
        stringBuffer.append('=');
        stringBuffer.append(this.pause);
        stringBuffer.append(',');
        stringBuffer.append("stop");
        stringBuffer.append('=');
        stringBuffer.append(this.stop);
        stringBuffer.append(',');
        stringBuffer.append("setEntry");
        stringBuffer.append('=');
        stringBuffer.append(this.setEntry);
        stringBuffer.append(',');
        stringBuffer.append("setTimePos");
        stringBuffer.append('=');
        stringBuffer.append(this.setTimePos);
        stringBuffer.append(',');
        stringBuffer.append("playbackModes");
        stringBuffer.append('=');
        stringBuffer.append(this.playbackModes);
        stringBuffer.append(',');
        stringBuffer.append("detailInfos");
        stringBuffer.append('=');
        stringBuffer.append(this.detailInfos);
        stringBuffer.append(',');
        stringBuffer.append("playView");
        stringBuffer.append('=');
        stringBuffer.append(this.playView);
        stringBuffer.append(',');
        stringBuffer.append("playSimilarEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.playSimilarEntries);
        stringBuffer.append(',');
        stringBuffer.append("totalPlaytime");
        stringBuffer.append('=');
        stringBuffer.append(this.totalPlaytime);
        stringBuffer.append(',');
        stringBuffer.append("extendedPlayView");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedPlayView);
        stringBuffer.append(',');
        stringBuffer.append("playTime");
        stringBuffer.append('=');
        stringBuffer.append(this.playTime);
        stringBuffer.append(',');
        stringBuffer.append("playbackModeTakeOver");
        stringBuffer.append('=');
        stringBuffer.append(this.playbackModeTakeOver);
        stringBuffer.append(',');
        stringBuffer.append("playbackModeToggle");
        stringBuffer.append('=');
        stringBuffer.append(this.playbackModeToggle);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

