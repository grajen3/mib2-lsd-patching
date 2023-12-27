/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;

public class CmdSkip
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_RQ_SKIP;
    private final MediaPlayer mPlayer;
    private final int mOffset;
    private final boolean mConsiderTimePos;

    public CmdSkip(MediaPlayer mediaPlayer, int n, boolean bl) {
        super(2, 0, 1, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mOffset = n;
        this.mConsiderTimePos = bl && !this.mPlayer.getActiveMedia().isBT();
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mPlayer == null || !this.mPlayer.isActive()) {
                    this.commandFailed("player is not ready");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                this.mPlayer.rqSkipTrack(this.mOffset, this.mConsiderTimePos, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("offset = ").append(this.mOffset).append(", considerTimePos = ").append(this.mConsiderTimePos).toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "RQ_SKIP";
            }
        }
        return "UNKNOWN";
    }
}

