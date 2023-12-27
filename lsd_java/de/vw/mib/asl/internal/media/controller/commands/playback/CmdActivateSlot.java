/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivatePlayer;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdDeactivatePlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;

public class CmdActivateSlot
extends AbstractCommand {
    private static int TIMEOUT = 20000;
    private static final int STEP_01_LOCK_VOLUME;
    private static final int STEP_02_WAIT_FOR_READY_TO_PLAY;
    private static final int STEP_03_REQUEST_SOURCE_ACTIVATION;
    private static final int STEP_04_ACTIVATE_PLAYER;
    private final MediaComponents mComponents;
    private final MediaAudioManager mSound;
    private final MediaPlayer mPlayer;
    private final ISources mSources;
    private MediaCollector mSlot = null;

    public CmdActivateSlot(MediaComponents mediaComponents) {
        super(7, 1, 4, TIMEOUT);
        this.mComponents = mediaComponents;
        this.mSound = mediaComponents.getSound();
        this.mPlayer = mediaComponents.getPlayer();
        this.mSources = mediaComponents.getSources();
    }

    @Override
    public void execute(int n) {
        if (this.mSources == null || this.mSound == null || this.mPlayer == null) {
            this.commandFailed("Sources, Sound or Player is null");
            return;
        }
        switch (n) {
            case 1: {
                this.mSound.rqAudioConnection(this.mPlayer.getActiveMedia(), this.NEXT_STEP);
                return;
            }
            case 2: {
                this.suspendTimer("wait for slotchange");
                this.mPlayer.rqWaitForState(1, 0, this.NEXT_STEP);
                return;
            }
            case 3: {
                this.resumeTimer();
                this.mSlot = this.mPlayer.getActiveSlot();
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("active slot:").append(this.mSlot.toStringShort()).toString());
                }
                this.mSources.rqRequestSourceActivation(this.mSlot, this.NEXT_STEP);
                return;
            }
            case 4: {
                AbstractCommand abstractCommand = this.mSlot.isMediaPlayable() ? new CmdActivatePlayer(this.mComponents, this.mSlot, false, true) : new CmdDeactivatePlayer(this.mSound, this.mPlayer, this.mSources, false, false);
                this.rqExecuteCmd(abstractCommand, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        this.mPlayer.abortSeek();
    }

    @Override
    public void onExit() {
        if (this.mSources != null && this.mSlot != null) {
            this.mSources.endActivation(this.mSlot, this, this.mSound.isAudioConnectionAvailable());
        }
        if (this.isCompleted() && !this.mSlot.isDisconnectableButNotPlayable()) {
            MediaObjectAccessor.mMediaController.synchronizeBrowser(true, "CmdActivateSource.onExit()");
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "LOCK_VOLUME";
            }
            case 2: {
                return "WAIT_FOR_READY_TO_PLAY";
            }
            case 3: {
                return "REQUEST_SOURCE_ACTIVATION";
            }
            case 4: {
                return "ACTIVATE_PLAYER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return null;
    }
}

