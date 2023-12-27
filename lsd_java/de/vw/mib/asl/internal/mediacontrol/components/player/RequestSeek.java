/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.internal.mediacontrol.common.MediaControlTimer;
import de.vw.mib.asl.internal.mediacontrol.common.component.AbstractComponentRequest;
import de.vw.mib.asl.internal.mediacontrol.common.component.ResponseHandler;
import de.vw.mib.asl.internal.mediacontrol.components.player.ListenerPlaybackState;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;
import de.vw.mib.asl.internal.mediacontrol.components.player.RequestSeek$1;
import org.dsi.ifc.upnp.DSIUPNPPlayer;

public class RequestSeek
extends AbstractComponentRequest
implements ListenerPlaybackState {
    private static final int SEEK_INTERVALL;
    private static final int[] SEEK_STEPS;
    private final MediaControlTimer mIncreaseSeekSpeedTimer = new MediaControlTimer(new RequestSeek$1(this), 4000, "increase_seek_speed");
    private String mCurrentSeekDeviceId;
    private int mCurrentSeekDirection;
    private int mCurrentSeekSpeedIndex = 0;
    private boolean mSeekAborted;
    private boolean mSeekStateReached;

    public RequestSeek(Player player) {
        super(player);
        player.getState().addPlaybackStateListener(this);
    }

    private Player getPlayer() {
        return (Player)this.getComponent();
    }

    private DSIUPNPPlayer getDSI() {
        return this.getPlayer().getDSI();
    }

    public void rqSeek(String string, int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(responseHandler)) {
            this.mCurrentSeekDeviceId = string;
            this.mCurrentSeekDirection = n;
            this.mCurrentSeekSpeedIndex = 0;
            this.mSeekAborted = false;
            this.mSeekStateReached = false;
            this.getDSI().seek(this.mCurrentSeekDeviceId, n, SEEK_STEPS[this.mCurrentSeekSpeedIndex]);
            this.mIncreaseSeekSpeedTimer.start();
        }
    }

    void increaseSeekSpeed() {
        if (this.isRegisteredForResponse() && this.mCurrentSeekSpeedIndex < SEEK_STEPS.length - 1 && !this.mSeekAborted) {
            ++this.mCurrentSeekSpeedIndex;
            this.getDSI().seek(this.mCurrentSeekDeviceId, this.mCurrentSeekDirection, SEEK_STEPS[this.mCurrentSeekSpeedIndex]);
            this.mIncreaseSeekSpeedTimer.start();
        }
    }

    public void stopSeek() {
        if (this.isRegisteredForResponse()) {
            this.mIncreaseSeekSpeedTimer.stop();
            this.mSeekAborted = true;
            this.fireResponse(true, "seek aborted by user");
        }
    }

    @Override
    public void updatePlaybackState(PlayerState playerState) {
        if (this.isRegisteredForResponse()) {
            boolean bl;
            int n = playerState.getPlaybackState(this.mCurrentSeekDeviceId);
            boolean bl2 = bl = n == 3;
            if (bl) {
                this.mSeekStateReached = true;
            }
            if (this.mSeekStateReached && bl && this.mSeekAborted) {
                this.fireResponse(true, "aborted by user (after SEEK state reached)");
                return;
            }
            if (this.mSeekStateReached && !bl && !this.mSeekAborted) {
                this.fireResponse(true, "aborted by playback state change");
                this.mSeekAborted = false;
                this.mIncreaseSeekSpeedTimer.stop();
            }
        }
    }

    static {
        SEEK_STEPS = new int[]{1, 2, 4, 6, 7};
    }
}

