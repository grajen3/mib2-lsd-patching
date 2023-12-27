/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.common.ModelView;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.DeviceDetails;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.PlaybackState;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.TrackDetails;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.TrackPosition;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.ViewOpenDevice$1;
import de.vw.mib.asl.internal.mediacontrol.common.MediaControlTimer;
import de.vw.mib.genericevents.EventGeneric;

public class ViewOpenDevice
implements ModelView {
    private final MediaControlAPI mMediaControlAPI;
    private final TrackPosition mTimeBar;
    private final PlaybackState mPlaybackState;
    private final DeviceDetails mDeviceDetails;
    private final TrackDetails mTrackDetails;
    private String mCurrentlyOpenDeviceId;
    private static int[] ACTIONS = new int[]{-1225173440, -1543940544, -1560717760, -1275505088, -1258727872, -1527163328, -1493608896, -1476831680, -1460054464, -1443277248, -1141287360};
    private static final int DEBOUNCE_TIMEOUT;
    MediaControlTimer mSkipTimer = new MediaControlTimer(new ViewOpenDevice$1(this), 500, "skip timer");
    private int mPendingSkips = 0;
    private boolean mPendingSkipsConsiderTimePos = false;

    public ViewOpenDevice(MediaControlAPI mediaControlAPI) {
        this.mTimeBar = new TrackPosition(mediaControlAPI);
        this.mPlaybackState = new PlaybackState(mediaControlAPI);
        this.mDeviceDetails = new DeviceDetails(mediaControlAPI);
        this.mTrackDetails = new TrackDetails(mediaControlAPI);
        this.mMediaControlAPI = mediaControlAPI;
    }

    @Override
    public int[] getSupportedActions() {
        return ACTIONS;
    }

    @Override
    public void handleAction(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1079441846: {
                String string;
                this.mCurrentlyOpenDeviceId = string = eventGeneric.getString(0);
                this.mTimeBar.setOpenedDevice(string);
                this.mDeviceDetails.setOpenedDevice(string);
                this.mTrackDetails.setOpenedDevice(string);
                this.mPlaybackState.setOpenDevice(string);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1323280640);
                break;
            }
            case 1079441844: {
                this.mMediaControlAPI.getPlayerService().resume(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
            case 1079441843: {
                this.mMediaControlAPI.getPlayerService().pause(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
            case 1079441828: {
                int n = eventGeneric.getInt(0);
                this.mMediaControlAPI.getPlayerService().setTimePosition(this.mCurrentlyOpenDeviceId, n, MediaControlCallback.NOP);
                break;
            }
            case 1079441827: {
                this.mMediaControlAPI.getPlayerService().increaseVolume(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
            case 1079441826: {
                this.mMediaControlAPI.getPlayerService().decreaseVolume(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
            case 1079441830: {
                this.debounceSkip(this.mCurrentlyOpenDeviceId, -1, true);
                break;
            }
            case 1079441831: {
                this.debounceSkip(this.mCurrentlyOpenDeviceId, 1, false);
                break;
            }
            case 1079441833: {
                this.mMediaControlAPI.getPlayerService().seekFw(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
            case 1079441832: {
                this.mMediaControlAPI.getPlayerService().seekBw(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
            case 1079441851: {
                this.mMediaControlAPI.getPlayerService().stopSeek(this.mCurrentlyOpenDeviceId, MediaControlCallback.NOP);
                break;
            }
        }
    }

    private void debounceSkip(String string, int n, boolean bl) {
        if (!this.mSkipTimer.isRunning()) {
            this.mPendingSkips = 0;
            this.mPendingSkipsConsiderTimePos = bl;
            this.executeSkip(n);
        } else {
            this.mPendingSkips += n;
        }
        this.mSkipTimer.restart();
    }

    private void executeSkip(int n) {
        this.mMediaControlAPI.getPlayerService().skip(this.mCurrentlyOpenDeviceId, n, this.mPendingSkipsConsiderTimePos, MediaControlCallback.NOP);
    }

    static /* synthetic */ int access$000(ViewOpenDevice viewOpenDevice) {
        return viewOpenDevice.mPendingSkips;
    }

    static /* synthetic */ void access$100(ViewOpenDevice viewOpenDevice, int n) {
        viewOpenDevice.executeSkip(n);
    }

    static /* synthetic */ int access$002(ViewOpenDevice viewOpenDevice, int n) {
        viewOpenDevice.mPendingSkips = n;
        return viewOpenDevice.mPendingSkips;
    }
}

