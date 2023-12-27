/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import org.dsi.ifc.media.ChapterInfo;

public class Skipper {
    private static final int RT_SKIP;
    private static int SKIP_TO_TRACK_BEGIN_AFTER;
    private static int SKIP_TO_CHAPTER_BEGIN_AFTER;
    private final MediaPlayer mPlayer;
    private int mRequestedSkipType = -1;
    private int mRequestedSkipCount = -1;
    private long mBeforeSkipEntryID = -1L;
    private long mBeforeSkipPlayPos = -1L;
    private long mBeforeSkipChapterFirstPos = -1L;
    private long mBeforeSkipChapterLastPos = -1L;

    public Skipper(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void skipTrack(int n, boolean bl, ResponseHandler responseHandler) {
        if (this.mPlayer.registerForResponse(5000, responseHandler)) {
            int n2;
            boolean bl2;
            ChapterInfo chapterInfo;
            long l = this.mPlayer.getActiveTrackId();
            int n3 = this.mPlayer.getTimePos();
            int n4 = 0;
            int n5 = 1;
            long l2 = 0L;
            long l3 = 0L;
            ChapterInfo chapterInfo2 = chapterInfo = this.mPlayer.getActiveTrackDetails() != null ? this.mPlayer.getActiveTrackDetails().getChapterInfo() : null;
            if (chapterInfo != null && chapterInfo.numChapters > 1) {
                n5 = chapterInfo.numChapters;
                n4 = chapterInfo.activeChapter;
                l2 = chapterInfo.activeChapterFirstTimePos;
                l3 = chapterInfo.activeChapterLastTimePos;
            }
            int n6 = n;
            boolean bl3 = bl2 = n5 > 1 && n4 > 0;
            if (bl && n < 0) {
                long l4 = bl2 ? (long)n3 - l2 : (long)n3;
                int n7 = n2 = bl2 ? SKIP_TO_CHAPTER_BEGIN_AFTER : SKIP_TO_TRACK_BEGIN_AFTER;
                if (!(l4 < (long)n2 || l2 <= 0L && bl2)) {
                    ++n6;
                }
            }
            this.mBeforeSkipEntryID = l;
            this.mBeforeSkipPlayPos = n3;
            this.mBeforeSkipChapterFirstPos = l2;
            this.mBeforeSkipChapterLastPos = l3;
            int n8 = 0;
            int n9 = 0;
            if (n6 < 0) {
                n8 = Math.max(n6, -n4);
                n9 = n6 - n8;
                this.mRequestedSkipCount = Math.abs(n9 == 0 ? n8 : n9);
                n2 = this.mRequestedSkipCount == 1 ? 5 : 7;
                this.mRequestedSkipType = n9 == 0 ? n2 : 1;
            } else if (n6 > 0) {
                n8 = Math.min(n6, n5 - (n4 + 1));
                n9 = n6 - n8;
                this.mRequestedSkipCount = n9 == 0 ? n8 : n9;
                this.mRequestedSkipType = n9 == 0 ? 6 : 0;
            } else {
                this.mRequestedSkipCount = 0;
                int n10 = this.mRequestedSkipType = bl2 ? 5 : 2;
            }
            if (ServiceManager.logger.isTraceEnabled(1024)) {
                ServiceManager.logger.trace(1024, new StringBuffer().append("skip: ").append(this.getSkipTypeStr(this.mRequestedSkipType)).append(" count:").append(this.mRequestedSkipCount).toString());
            }
            this.mPlayer.getDSI().skip(this.mRequestedSkipType, this.mRequestedSkipCount);
            this.mPlayer.pauseIfNotOnTop();
            if (!this.mPlayer.isWaitForSkipSensible(this.mRequestedSkipType == 1)) {
                this.mPlayer.fireResponse(true, "wait for skip detection is not sensible for this media");
            }
        }
    }

    public void detectSkipCompletion(long l, int n) {
        block10: {
            block11: {
                if (!this.mPlayer.isRegisteredForResponse(5000)) break block10;
                if (!this.mPlayer.isWaitForSkipSensible(this.mRequestedSkipType == 1)) break block11;
                switch (this.mRequestedSkipType) {
                    case 2: 
                    case 5: {
                        if (this.mBeforeSkipEntryID == l && (long)n <= this.mBeforeSkipPlayPos) {
                            this.mPlayer.fireResponse(true);
                            break;
                        }
                        break block10;
                    }
                    case 0: 
                    case 1: {
                        if (this.mBeforeSkipEntryID != l || this.mBeforeSkipEntryID == l && ((long)n < this.mBeforeSkipPlayPos || this.mBeforeSkipPlayPos == 0L && n > 0)) {
                            this.mPlayer.fireResponse(true);
                            break;
                        }
                        break block10;
                    }
                    case 7: {
                        if (this.mBeforeSkipEntryID == l && (long)n < this.mBeforeSkipChapterFirstPos) {
                            this.mPlayer.fireResponse(true);
                            break;
                        }
                        break block10;
                    }
                    case 6: {
                        if (this.mBeforeSkipEntryID == l && (long)n >= this.mBeforeSkipChapterLastPos) {
                            this.mPlayer.fireResponse(true);
                            break;
                        }
                        break block10;
                    }
                    default: {
                        this.mPlayer.fireResponse(false, "Requested Skip Type unknown.");
                        break;
                    }
                }
                break block10;
            }
            this.mPlayer.fireResponse(true, "entryId and/or timePosition is not handled by media, returning true");
        }
    }

    private String getSkipTypeStr(int n) {
        switch (n) {
            case 2: {
                return "begin_entry";
            }
            case 1: {
                return "prev_entry";
            }
            case 0: {
                return "next_entry";
            }
            case 5: {
                return "begin_chapter";
            }
            case 7: {
                return "prev_chapter";
            }
            case 6: {
                return "next_chapter";
            }
        }
        return "unknown";
    }

    static {
        SKIP_TO_TRACK_BEGIN_AFTER = 3000;
        SKIP_TO_CHAPTER_BEGIN_AFTER = 3000;
    }
}

