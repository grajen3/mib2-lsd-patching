/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;

public class CmdSetVideoSize
extends AbstractCommand {
    private static int TIMEOUT = 2000;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_SET_VIDEO_SIZE;
    private final MediaPlayer mPlayer;
    private final boolean mMaximized;

    public CmdSetVideoSize(MediaPlayer mediaPlayer, boolean bl) {
        super(2, 0, 1, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mMaximized = bl;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mPlayer == null) {
                    this.commandFailed("Player is null");
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
                this.mPlayer.setVideoSize(this.mMaximized);
                this.nextStep();
                break;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("videoMaximized = ").append(this.mMaximized).toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "SET_VIDEO_SIZE";
            }
        }
        return "UNKNOWN";
    }
}

