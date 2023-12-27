/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerDevices;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerPlaybackState;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlListenerVolume;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdDecVolume;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdIncVolume;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdPause;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdPlayTrack;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdResume;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdSeek;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdSetTimePosition;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdSkip;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandQueue;
import de.vw.mib.asl.internal.mediacontrol.services.Components;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl$1;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl$2;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl$3;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl$4;

public class ServiceMediaControlPlayerImpl
implements MediaControlServicePlayer {
    private final CommandQueue mQueue;
    private final Components mComponents;
    private Command mSeek;

    public ServiceMediaControlPlayerImpl(CommandQueue commandQueue, Components components) {
        this.mQueue = commandQueue;
        this.mComponents = components;
    }

    @Override
    public void addDevicesListener(MediaControlListenerDevices mediaControlListenerDevices) {
        this.mComponents.getPlayer().getState().addDevicesListener(new ServiceMediaControlPlayerImpl$1(this, mediaControlListenerDevices));
    }

    @Override
    public void addPlaybackStateListener(MediaControlListenerPlaybackState mediaControlListenerPlaybackState) {
        this.mComponents.getPlayer().getState().addPlaybackStateListener(new ServiceMediaControlPlayerImpl$2(this, mediaControlListenerPlaybackState));
    }

    @Override
    public void addActiveTrackListener(MediaControlListenerActiveTrack mediaControlListenerActiveTrack) {
        this.mComponents.getPlayer().getState().addActiveTrackListener(new ServiceMediaControlPlayerImpl$3(this, mediaControlListenerActiveTrack));
    }

    @Override
    public void addVolumeListener(MediaControlListenerVolume mediaControlListenerVolume) {
        this.mComponents.getPlayer().getState().addVolumeListener(new ServiceMediaControlPlayerImpl$4(this, mediaControlListenerVolume));
    }

    @Override
    public void increaseVolume(String string, MediaControlCallback mediaControlCallback) {
        CmdIncVolume cmdIncVolume = new CmdIncVolume(this.mComponents.getPlayer(), string);
        if (mediaControlCallback != null) {
            cmdIncVolume.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdIncVolume);
    }

    @Override
    public void decreaseVolume(String string, MediaControlCallback mediaControlCallback) {
        CmdDecVolume cmdDecVolume = new CmdDecVolume(this.mComponents.getPlayer(), string);
        if (mediaControlCallback != null) {
            cmdDecVolume.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdDecVolume);
    }

    @Override
    public void pause(String string, MediaControlCallback mediaControlCallback) {
        CmdPause cmdPause = new CmdPause(this.mComponents.getPlayer(), string);
        if (mediaControlCallback != null) {
            cmdPause.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdPause);
    }

    @Override
    public void resume(String string, MediaControlCallback mediaControlCallback) {
        CmdResume cmdResume = new CmdResume(this.mComponents.getPlayer(), string);
        if (mediaControlCallback != null) {
            cmdResume.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdResume);
    }

    @Override
    public void setTimePosition(String string, int n, MediaControlCallback mediaControlCallback) {
        CmdSetTimePosition cmdSetTimePosition = new CmdSetTimePosition(this.mComponents.getPlayer(), string, n);
        if (mediaControlCallback != null) {
            cmdSetTimePosition.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdSetTimePosition);
    }

    @Override
    public void playTrack(String[] stringArray, String string, MediaControlCallback mediaControlCallback) {
        CmdPlayTrack cmdPlayTrack = new CmdPlayTrack(this.mComponents.getPlayer(), this.mComponents.getBrowser(), stringArray, string);
        if (mediaControlCallback != null) {
            cmdPlayTrack.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdPlayTrack);
    }

    @Override
    public void skip(String string, int n, boolean bl, MediaControlCallback mediaControlCallback) {
        CmdSkip cmdSkip = new CmdSkip(this.mComponents.getPlayer(), string, n, bl);
        if (mediaControlCallback != null) {
            cmdSkip.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
        }
        this.mQueue.addCommand(cmdSkip);
    }

    @Override
    public void seekBw(String string, MediaControlCallback mediaControlCallback) {
        if (this.mSeek != null && this.mSeek.isExecuting()) {
            return;
        }
        Command command = CmdSeek.createSeekBw(this.mComponents.getPlayer(), string);
        if (mediaControlCallback != null) {
            command.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
            this.mSeek = null;
        }
        this.mSeek = command;
        this.mQueue.addCommand(command);
    }

    @Override
    public void seekFw(String string, MediaControlCallback mediaControlCallback) {
        if (this.mSeek != null && this.mSeek.isExecuting()) {
            return;
        }
        Command command = CmdSeek.createSeekFw(this.mComponents.getPlayer(), string);
        if (mediaControlCallback != null) {
            command.setCommandCallback(Helper.getDefaultCommandCallback(mediaControlCallback));
            this.mSeek = null;
        }
        this.mSeek = command;
        this.mQueue.addCommand(command);
    }

    @Override
    public void stopSeek(String string, MediaControlCallback mediaControlCallback) {
        if (this.mSeek != null) {
            if (this.mSeek.isWaiting()) {
                this.mSeek.cancel("seek aborted by user (before execution)");
            } else {
                this.mComponents.getPlayer().stopSeek();
            }
        }
    }
}

