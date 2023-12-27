/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.base;

import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.settings.MediaSettings;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;

public final class CmdFactorySettings
extends AbstractCommand {
    public static final int TIMEOUT;
    private final MediaPlayer mPlayer;
    private final ISources mSources;
    private final MediaSettings mSettings;
    private final int mResetBits;
    private int aslDeviceId;

    public CmdFactorySettings(MediaComponents mediaComponents, int n) {
        super(-2017, 0, 1, -1059847936);
        this.mPlayer = mediaComponents.getPlayer();
        this.mSources = mediaComponents.getSources();
        this.mSettings = mediaComponents.getSettings();
        this.mResetBits = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mPlayer == null) {
                    this.commandFailed("Player is null");
                    return;
                }
                this.aslDeviceId = this.mPlayer.getASLActiveMedia().getAslDeviceID();
                this.mPlayer.resetToFactorySettings();
                this.mSettings.resetToFactorySettings();
                this.mSources.resetToFactorySettings();
                if (this.mPlayer.getPlayerState().getActivationState() == 3) {
                    this.mPlayer.rqRestoreVideoFormat(this.NO_OPERATION);
                    this.mPlayer.rqRestoreDefaultPlaybackMode(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                this.mPlayer.rqFactorySettings(this.mResetBits, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("Resetbits: 0x").append(Integer.toHexString(this.mResetBits)).toString();
    }

    @Override
    protected String getStepStr(int n) {
        return null;
    }

    @Override
    public void onEnter() {
        if (IMediaConstants.ESO) {
            SourceHandlingPersistence.getInstance().domainUnavailable();
        }
    }

    @Override
    public void onExit() {
        if (IMediaConstants.ESO) {
            SourceHandlingPersistence.getInstance().setDomainAvailable(this.aslDeviceId);
        }
    }
}

