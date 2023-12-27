/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;

public final class VideoFormat {
    private final MediaPlayer mPlayer;
    private final int mRequestType;
    private int mDsiVideoFormat;

    public void invalidate() {
        this.mDsiVideoFormat = -1;
    }

    public VideoFormat(MediaPlayer mediaPlayer, int n) {
        this.mPlayer = mediaPlayer;
        this.mRequestType = n;
    }

    public void rqSetVideoFormat(int n, ResponseHandler responseHandler) {
        if (this.mPlayer.registerForResponse(this.mRequestType, responseHandler)) {
            if (this.mPlayer.getActiveMedia().getMediaCaps() == null || !this.mPlayer.getActiveMedia().getMediaCaps().isVideoSupport()) {
                this.mPlayer.fireResponse(false, "capabilities must not be null and allow for video playback");
                return;
            }
            int n2 = this.getDsiVideoFormat(n);
            if (this.mDsiVideoFormat != n2) {
                this.mPlayer.getDSI().setVideoFormat(n2);
            } else {
                this.mPlayer.fireResponse(true, this.mRequestType);
            }
        }
    }

    public int getDsiVideoFormat(int n) {
        switch (n) {
            case 0: {
                return 5;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
        }
        this.mPlayer.warn("VIDEO FORMAT: asl video format unknown (mapping to DSIMediaPlayer.VIDEOFORMAT_AUTOMATIC).");
        return 5;
    }

    public int dsiVideoFormatChanged(int n) {
        this.mDsiVideoFormat = n;
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: {
                this.mPlayer.warn("VIDEO FORMAT: reported video format = 'original' not supported.");
                break;
            }
            default: {
                this.mPlayer.warn("VIDEO FORMAT: reported video format unknown.");
            }
        }
        this.mPlayer.valueChangedInteger(113, n2);
        this.mPlayer.fireResponse(true, this.mRequestType);
        return n2;
    }

    public static String getVidoFormatStr(int n) {
        switch (n) {
            case 0: {
                return "automatic";
            }
            case 1: {
                return "16:9";
            }
            case 2: {
                return "4:3";
            }
            case 3: {
                return "14:9";
            }
            case 4: {
                return "47:20 (Cinemascope)";
            }
        }
        return "unknown";
    }
}

