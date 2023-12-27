/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.VideoFormat;

public class CmdSetVideoFormat
extends AbstractCommand {
    private static int TIMEOUT = 2000;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_SET_VIDEO_FORMAT;
    private final MediaPlayer mPlayer;
    private final int mVideoFormat;

    public CmdSetVideoFormat(MediaPlayer mediaPlayer, int n) {
        super(2, 0, 1, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mVideoFormat = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mPlayer == null) {
                    this.commandFailed("Player is null");
                    return;
                }
                if (this.mPlayer.getActiveMedia() == null) {
                    this.commandFailed("player.activeMedia is null.");
                    return;
                }
                if (this.mPlayer.getActiveMedia().getMediaCaps() == null || !this.mPlayer.getActiveMedia().getMediaCaps().isVideoSupport()) {
                    this.commandFailed("Active Media does not support video playback.");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                this.mPlayer.rqVideoFormat(this.mVideoFormat, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("videoFormat = ").append(VideoFormat.getVidoFormatStr(this.mVideoFormat)).toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "SET_VIDEO_FORMAT";
            }
        }
        return "UNKNOWN";
    }
}

