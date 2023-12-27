/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivatePlayer;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdDeactivatePlayer;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;

public class CmdActivateSource
extends AbstractCommand {
    private static int TIMEOUT = 20000;
    private static boolean mPerformancePingSent = false;
    private static final int EXECUTION_STEP_01_REQUEST_SOURCE_ACTIVATION;
    private static final int EXECUTION_STEP_02_ACTIVATE_PLAYER;
    private final MediaComponents components;
    private final MediaAudioManager mSound;
    private final MediaPlayer mPlayer;
    private final MediaMainBrowser mMainBrowser;
    private final ISources mSources;
    private final MediaCollector mMedia;
    private final boolean mRestorePlaymode;
    private final boolean mResume;

    public CmdActivateSource(MediaComponents mediaComponents, MediaCollector mediaCollector, boolean bl, boolean bl2) {
        this(mediaComponents, mediaCollector, bl, bl2, true);
    }

    public CmdActivateSource(MediaComponents mediaComponents, MediaCollector mediaCollector, boolean bl, boolean bl2, boolean bl3) {
        super(7, bl3 ? 1 : 2, 2, TIMEOUT);
        if (mediaCollector == null) {
            throw new IllegalArgumentException("Cannot activate source <null>.");
        }
        this.components = mediaComponents;
        this.mSound = mediaComponents.getSound();
        this.mPlayer = mediaComponents.getPlayer();
        this.mSources = mediaComponents.getSources();
        this.mMainBrowser = mediaComponents.getBrowser_MainView();
        this.mMedia = mediaCollector;
        this.mRestorePlaymode = bl;
        this.mResume = bl2;
    }

    @Override
    public void execute(int n) {
        if (this.mSources == null || this.mSound == null || this.mPlayer == null) {
            this.commandFailed("Sources, Sound or Player is null");
            return;
        }
        switch (n) {
            case 1: {
                this.mSources.rqRequestSourceActivation(this.mMedia, this.NEXT_STEP);
                return;
            }
            case 2: {
                AbstractCommand abstractCommand;
                if (this.mMedia.isMediaPlayable()) {
                    abstractCommand = new CmdActivatePlayer(this.components, this.mMedia, this.mRestorePlaymode, this.mResume);
                } else {
                    if (this.mMedia.isDisconnectableButNotPlayable()) {
                        this.mSources.setDisconnectedState(this.mMedia);
                        CurrentAudioSourceState.set(5);
                        SourceIconController.getInstance().setCurrentAudioSource(this.mMedia.getAslDeviceID());
                    }
                    abstractCommand = new CmdDeactivatePlayer(this.mSound, this.mPlayer, this.mSources, false, false);
                }
                this.rqExecuteCmd(abstractCommand, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        MediaCollector mediaCollector = this.mPlayer.getActiveMedia();
        if (mediaCollector != null && mediaCollector != MediaCollector.EMPTY && mediaCollector != this.mMedia) {
            if (!mediaCollector.storesOwnPlaybackState()) {
                this.mPlayer.pause(false);
            }
            this.mPlayer.abortSeek();
        }
    }

    @Override
    public void onExit() {
        if (this.mSources != null && this.mMedia != null) {
            this.mSources.endActivation(this.mMedia, this, this.mSound.isAudioConnectionAvailable());
        }
        if (this.isCompleted() && !this.mMedia.isDisconnectableButNotPlayable()) {
            MediaObjectAccessor.mMediaController.synchronizeBrowser(true, "CmdActivateSource.onExit()");
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "REQUEST_SOURCE_ACTIVATION";
            }
            case 2: {
                return "SUBCOMMAND_ACTIVATE_PLAYER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = this.mRestorePlaymode ? " [restorePlaymode]" : "";
        String string2 = this.mResume ? " [resume]" : "";
        return new StringBuffer().append("MediaCollector: ").append(this.mMedia).append(string).append(string2).toString();
    }
}

