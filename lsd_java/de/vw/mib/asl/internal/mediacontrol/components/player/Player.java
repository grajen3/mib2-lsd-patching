/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.component.ResponseHandler;
import de.vw.mib.asl.internal.mediacontrol.components.player.AbstractPlayer;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;
import de.vw.mib.asl.internal.mediacontrol.components.player.RequestSeek;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.ListEntry;

public class Player
extends AbstractPlayer {
    private static final int RT_PAUSE = Player.assignRequestId();
    private static final int RT_RESUME = Player.assignRequestId();
    private static final int RT_VOLUME = Player.assignRequestId();
    private static final int RT_SET_TIME_POS = Player.assignRequestId();
    private static final int RT_PLAY_ENTRY = Player.assignRequestId();
    private static final int RT_SKIP = Player.assignRequestId();
    private String mRqDeviceId;
    private int mRqTimePosition;
    private String mRqEntryId;
    private PlayerState mPlayerState = new PlayerState();
    private static int SKIP_TO_TRACK_BEGIN_AFTER = 3000;
    private RequestSeek rqSeek = new RequestSeek(this);

    public Player(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getComponentId() {
        return 1;
    }

    public PlayerState getState() {
        return this.mPlayerState;
    }

    public void dsiUPNPPlayerUpdateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
        this.getState().updateDevices(deviceInfoArray, n == 1);
    }

    public void rqPause(String string, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_PAUSE, responseHandler)) {
            if (this.getState().isPaused(string)) {
                this.fireResponse(true, "pause already active");
                return;
            }
            this.mRqDeviceId = string;
            this.getDSI().pause(string);
        }
    }

    public void rqResume(String string, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_RESUME, responseHandler)) {
            if (this.getState().isPlaying(string)) {
                this.fireResponse(true, "play already active");
                return;
            }
            this.mRqDeviceId = string;
            this.getDSI().resume(string);
        }
    }

    public void dsiUPNPPlayerUpdatePlaybackState(String string, int n, int n2) {
        this.getState().updatePlaybackState(string, n, n2 == 1);
        if (this.isRegisteredForResponse(RT_PAUSE) && Helper.isSameString(this.mRqDeviceId, string) && this.getState().isPaused(string)) {
            this.fireResponse(true);
        }
        if (this.isRegisteredForResponse(RT_RESUME) && Helper.isSameString(this.mRqDeviceId, string) && this.getState().isPlaying(string)) {
            this.fireResponse(true);
        }
    }

    public void rqPlayEntry(String[] stringArray, ListEntry[] listEntryArray, String string, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_PLAY_ENTRY, responseHandler)) {
            this.getDSI().setEntry(stringArray, string, listEntryArray, 0);
            this.fireResponse(true, "fire & forget");
        }
    }

    public void rqSetTimePosition(String string, int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_TIME_POS, responseHandler)) {
            this.mRqDeviceId = string;
            this.mRqEntryId = this.getState().getActiveTrackId(string);
            this.mRqTimePosition = n;
            String[] stringArray = new String[]{string};
            this.getDSI().setEntry(stringArray, this.mRqEntryId, null, n);
        }
    }

    public void rqSkip(String string, int n, boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SKIP, responseHandler)) {
            long l;
            int n2 = n;
            if (bl && n < 0 && (l = this.getState().getTimePosition(string)) >= (long)SKIP_TO_TRACK_BEGIN_AFTER) {
                ++n2;
            }
            if (n2 > 0) {
                this.getDSI().skip(string, 0, n2);
            } else if (n2 < 0) {
                this.getDSI().skip(string, 1, Math.abs(n2));
            } else {
                this.getDSI().skip(string, 2, 0);
            }
            this.fireResponse(true, "fire & forget");
        }
    }

    public void rqSeek(String string, int n, ResponseHandler responseHandler) {
        this.rqSeek.rqSeek(string, n, responseHandler);
    }

    public void stopSeek() {
        this.rqSeek.stopSeek();
    }

    public void dsiUPNPPlayerUpdatePlayPosition(String string, String string2, int n, int n2, int n3) {
        this.getState().updatePlayPosition(string, string2, n, n2, n3 == 1);
        if (this.isRegisteredForResponse(RT_SET_TIME_POS) && Helper.isSameString(this.mRqDeviceId, string) && Helper.isSameString(this.mRqEntryId, string2) && this.mRqTimePosition - 1000 <= n && n <= this.mRqTimePosition + 1000) {
            this.fireResponse(true, new StringBuffer().append("new timePosition=").append(n).toString());
        }
    }

    public void dsiUPNPPlayerUpdateDetailInfo(String string, EntryInfo entryInfo, ResourceLocator resourceLocator, int n) {
        this.getState().updateDetailInfo(string, entryInfo, resourceLocator, n == 1);
    }

    public void rqIncVolume(String string, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_VOLUME, responseHandler)) {
            this.mRqDeviceId = string;
            this.getDSI().increaseVolume(string);
            this.fireResponse(true, "device may not answer -> do not wait for response-> fire & forget");
        }
    }

    public void rqDecVolume(String string, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_VOLUME, responseHandler)) {
            this.mRqDeviceId = string;
            this.getDSI().decreaseVolume(string);
            this.fireResponse(true, "device may not answer -> do not wait for response-> fire & forget");
        }
    }

    public void dsiUPNPPlayerUpdateVolume(String string, int n, int n2) {
        this.getState().updateVolume(string, n, n2 == 1);
        if (this.isRegisteredForResponse(RT_VOLUME) && Helper.isSameString(this.mRqDeviceId, string)) {
            this.fireResponse(true, new StringBuffer().append("new Volume: ").append(n).toString());
        }
    }

    public void dsiUPNPPlayerAsyncException(int n, String string, int n2) {
        if (n2 == 1006 || n2 == 1007 || n2 == 1008) {
            if (this.isRegisteredForResponse(RT_VOLUME)) {
                this.fireResponse(false, new StringBuffer().append("async: ").append(string).toString());
            }
        } else if (n2 == 1000) {
            if (this.isRegisteredForResponse(RT_PAUSE)) {
                this.fireResponse(false, new StringBuffer().append("async: ").append(string).toString());
            }
        } else if (n2 == 1001) {
            if (this.isRegisteredForResponse(RT_RESUME)) {
                this.fireResponse(false, new StringBuffer().append("async: ").append(string).toString());
            }
        } else if (n2 == 1005) {
            if (this.rqSeek.isRegisteredForResponse()) {
                this.fireResponse(false, new StringBuffer().append("async: ").append(string).toString());
            }
        } else if (n2 == 1004) {
            if (this.isRegisteredForResponse(RT_SKIP)) {
                this.fireResponse(false, new StringBuffer().append("async: ").append(string).toString());
            }
        } else if (n2 == 1002 && (this.isRegisteredForResponse(RT_PLAY_ENTRY) || this.isRegisteredForResponse(RT_SET_TIME_POS))) {
            this.fireResponse(false, new StringBuffer().append("async: ").append(string).toString());
        }
    }
}

