/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sound;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class MediaAudioManager
extends AbstractMediaTarget {
    private static final int AUDIO_CONNECTION_UNDEFINED;
    private static final int AUDIO_CONNECTION_SUPPRESSION;
    private static final int AUDIO_CONNECTION_DUMMY;
    private boolean standbyActive;
    private boolean standbyPowerSaveActive;
    private boolean audioConnectionAvailability = false;
    private static final int RT_REQUEST_AUDIO_CONNECTION;
    private static final int RT_WAIT_FOR_MEDIA_NOT_AUDIBLE;
    private int mActiveAudioConnection = -1;
    private int mRequestedAudioConnection = -1;
    private static final int RT_FADE_TO;
    private boolean mMediaAudible;
    private boolean mMuteActive;
    private boolean mMuteStarted;
    private boolean mMuteBeforeAmUnavailable;
    private static final int RT_MUTE;
    private static final int RT_DEMUTE;
    private static int[] OBSERVER;
    public static final int EV_MEDIA_SOUND_SET_CONNECTION_ANSWER;
    public static final int EV_MEDIA_SOUND_FADE_TO_CONNECTION_ANSWER;

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 32768;
    }

    public MediaAudioManager(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 347017984;
    }

    public void rqWaitForMediaNotAudible(ResponseHandler responseHandler) {
        this.registerForResponse(RT_WAIT_FOR_MEDIA_NOT_AUDIBLE, responseHandler);
        if (!this.isAudioConnectionAvailable()) {
            this.fireResponse(true, "nothing done, audio connection not available");
            return;
        }
    }

    public void rqMute(ResponseHandler responseHandler) {
        int n = 2000;
        this.rqMuteState(RT_MUTE, 2000, responseHandler);
    }

    public void rqDemute(ResponseHandler responseHandler) {
        int n = 1000;
        this.rqMuteState(RT_DEMUTE, 1000, responseHandler);
    }

    private void rqMuteState(int n, int n2, ResponseHandler responseHandler) {
        if (this.registerForResponse(n, n2, responseHandler)) {
            if (n != RT_MUTE && n != RT_DEMUTE) {
                this.fireResponse(false, "unsupported requestType for rqMuteState");
                return;
            }
            if (!this.isAudioConnectionAvailable()) {
                this.fireResponse(true, "nothing done, audio connection not available");
                return;
            }
            if (!this.detectRqMuteStateCompleted(this.mMuteStarted, this.mMediaAudible)) {
                if (this.isRegisteredForResponse(RT_MUTE)) {
                    this.requestMute(true, "rqMute");
                } else if (this.isRegisteredForResponse(RT_DEMUTE)) {
                    this.requestMute(false, "rqMute");
                }
            }
        }
    }

    private boolean detectRqMuteStateCompleted(boolean bl, boolean bl2) {
        if (this.isRegisteredForResponse(RT_MUTE) || this.isRegisteredForResponse(RT_DEMUTE)) {
            boolean bl3 = false;
            if (this.isRegisteredForResponse(RT_MUTE)) {
                bl3 = bl && !bl2;
            } else if (this.isRegisteredForResponse(RT_DEMUTE)) {
                boolean bl4 = bl3 = !bl && bl2;
            }
            if (bl3) {
                this.fireResponse(true);
                return true;
            }
        }
        return false;
    }

    public void requestMute(boolean bl, String string) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("SOUND # requestMute(").append(bl).append(") by :").append(string).toString());
        }
        if (this.isAudioConnectionAvailable()) {
            int n = bl ? 34159872 : 67714304;
            EventGeneric eventGeneric = this.newServiceEvent(n);
            eventGeneric.setInt(0, 8);
            this.sendSafe(eventGeneric);
        } else {
            this.mMuteActive = bl;
        }
    }

    private void lockDummyVolumeConnection() {
        EventGeneric eventGeneric = this.newServiceEvent(185154816);
        eventGeneric.setInt(0, 20);
        this.sendSafe(eventGeneric);
    }

    private void lockLastRequestedVolumeConnection() {
        if (this.mRequestedAudioConnection != -1) {
            EventGeneric eventGeneric = this.newServiceEvent(185154816);
            eventGeneric.setInt(0, this.mRequestedAudioConnection);
            this.sendSafe(eventGeneric);
        }
    }

    public void unlockAllVolumeConnections() {
        EventGeneric eventGeneric;
        if (this.mActiveAudioConnection != -1) {
            eventGeneric = this.newServiceEvent(201932032);
            eventGeneric.setInt(0, this.mActiveAudioConnection);
            this.sendSafe(eventGeneric);
        }
        if (this.mActiveAudioConnection != this.mRequestedAudioConnection && this.mRequestedAudioConnection != -1) {
            eventGeneric = this.newServiceEvent(201932032);
            eventGeneric.setInt(0, this.mRequestedAudioConnection);
            this.sendSafe(eventGeneric);
        }
    }

    public boolean isAudioConnectionMatching(MediaCollector mediaCollector) {
        return this.getMatchingConnection(mediaCollector) == this.mActiveAudioConnection;
    }

    public boolean isStandbyActive() {
        return this.standbyActive;
    }

    public boolean isAudioConnectionAvailable() {
        return this.audioConnectionAvailability;
    }

    public void resetLastRequestedConnections() {
        this.mActiveAudioConnection = -1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObservers(OBSERVER);
                EventGeneric eventGeneric2 = this.newEvent(279909120, -1551499008);
                eventGeneric2.setObject(0, this);
                this.sendSafe(eventGeneric2);
                MediaObjectAccessor.soundHandler = this;
                this.sendSafe(this.newEvent(-1338698496, 470367488));
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                break;
            }
            case 100001: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Received answer from audio management: result: ").append(eventGeneric.getResult()).append(", connection ").append(eventGeneric.getInt(0)).log();
                }
                if (eventGeneric.getResult() != 0) break;
                this.responseAudioConnection(eventGeneric.getInt(0));
                break;
            }
            case 100002: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Received MEDIA_SOUND_FADE_TO_CONNECTION_ANSWER").log();
                }
                if (!this.isRegisteredForResponse(RT_FADE_TO)) break;
                this.fireResponse(true);
                break;
            }
            case 3600023: {
                boolean bl;
                if (this.isTraceEnabled()) {
                    this.trace().append(new StringBuffer().append("TargetMedia.gotEvent(").append(eventGeneric.getReceiverEventId()).append(") [ASL_INQUIRY_RUNNING]").toString()).log();
                }
                EventGeneric eventGeneric3 = this.newServiceEvent((bl = eventGeneric.getBoolean(0)) ? 34159872 : 67714304);
                eventGeneric3.setInt(0, 200);
                this.sendSafe(eventGeneric3);
                break;
            }
            case 4000007: {
                boolean bl = eventGeneric.getBoolean(1);
                boolean bl2 = eventGeneric.getBoolean(0);
                if (this.mMuteStarted != bl2) {
                    if (this.isTraceEnabled()) {
                        this.trace(new StringBuffer().append("SOUND # muteStarted:").append(bl2).toString());
                    }
                    this.mMuteStarted = bl2;
                    this.detectRqMuteStateCompleted(bl2, this.mMediaAudible);
                }
                if (this.mMuteActive == bl) break;
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("SOUND # muteActive:").append(bl).toString());
                }
                this.mMuteActive = bl;
                break;
            }
            case 4000030: {
                this.sendSafe(this.newEvent(279909120, -1400504064));
                break;
            }
            case 4000029: {
                if (this.audioConnectionAvailability) {
                    this.sendSafe(this.newEvent(279909120, -1383726848));
                    break;
                }
                this.mMuteActive = true;
                break;
            }
            case 4000016: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.mMediaAudible == bl) break;
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("SOUND # mediaAudible:").append(bl).toString());
                }
                this.mMediaAudible = bl;
                if (this.isRegisteredForResponse(RT_MUTE) || this.isRegisteredForResponse(RT_DEMUTE)) {
                    this.detectRqMuteStateCompleted(this.mMuteStarted, bl);
                    return;
                }
                if (bl) {
                    this.sendSafe(this.newEvent(279909120, -1434058496));
                    break;
                }
                if (this.isRegisteredForResponse(RT_WAIT_FOR_MEDIA_NOT_AUDIBLE)) {
                    this.fireResponse(true);
                    break;
                }
                this.sendSafe(this.newEvent(279909120, -1417281280));
                break;
            }
            case 4000021: {
                switch (eventGeneric.getInt(0)) {
                    case 0: {
                        if (this.isTraceEnabled()) {
                            this.trace().append("Received ASL_SOUND_AUDIOMNGMNT_UNAVAILABLE").log();
                        }
                        if (this.audioConnectionAvailability) {
                            if (this.isTraceEnabled()) {
                                this.trace().append(new StringBuffer().append("setting mMuteBeforeAmUnavailable from ").append(this.mMuteBeforeAmUnavailable).append(" to ").append(this.mMuteActive).toString()).log();
                            }
                            this.mMuteBeforeAmUnavailable = this.mMuteActive;
                        } else if (this.isTraceEnabled()) {
                            this.trace().append(new StringBuffer().append("not touching mMuteBeforeAmUnavailable ").append(this.mMuteBeforeAmUnavailable).toString()).log();
                        }
                        this.audioConnectionAvailability = false;
                        this.fireResponse(true, "faking success due to AUDIOMNGMNT_STATUS_CO_UNAVAILABLE");
                        this.sendSafe(this.newEvent(279909120, -1132068608));
                        break block0;
                    }
                    case 1: {
                        if (this.isTraceEnabled()) {
                            this.trace().append("Received ASL_SOUND_AUDIOMNGMNT_STATUS_AVAILABLE").log();
                        }
                        this.audioConnectionAvailability = true;
                        this.sendSafe(this.newEvent(279909120, -1115291392));
                        break block0;
                    }
                    case 2: {
                        if (this.isTraceEnabled()) {
                            this.trace().append("Received ASL_SOUND_AUDIOMNGMNT_AVAILABLE_RESTORE_CONNECTIONS").log();
                        }
                        this.audioConnectionAvailability = true;
                        this.sendSafe(this.newEvent(279909120, -1115291392));
                        break block0;
                    }
                }
                break;
            }
            case 4000048: {
                boolean bl = eventGeneric.getBoolean(0);
                this.valueChangedBoolean(928779264, bl);
                break;
            }
            case 4300042: 
            case 4300055: {
                this.standbyPowerSaveActive = true;
                break;
            }
            case 4300053: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Received ASLSystemServiceIds.TRANSITION_TO_STANDBY").log();
                }
                this.standbyActive = true;
                this.standbyPowerSaveActive = false;
                break;
            }
            case 4300054: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Received ASL_SYSTEM_TRANSITION_TO_ON").log();
                }
                this.standbyActive = false;
                this.standbyPowerSaveActive = false;
                break;
            }
        }
    }

    public void rqAudioConnection(MediaCollector mediaCollector, ResponseHandler responseHandler) {
        int n = this.getMatchingConnection(mediaCollector);
        if (n == -1) {
            this.error().append("No connection could be found for media: ").append(mediaCollector).log();
        }
        this.rqAudioConnection(n, responseHandler, false);
        this.lockLastRequestedVolumeConnection();
    }

    private void rqAudioConnection(int n, ResponseHandler responseHandler, boolean bl) {
        if (this.registerForResponse(RT_REQUEST_AUDIO_CONNECTION, responseHandler)) {
            this.mRequestedAudioConnection = n;
            if (this.mRequestedAudioConnection == -1) {
                this.fireResponse(false, "No connection could be found");
                return;
            }
            if (!this.audioConnectionAvailability) {
                this.fireResponse(true, "AM not available!");
                return;
            }
            if (bl && this.mRequestedAudioConnection == this.mActiveAudioConnection) {
                this.fireResponse(true, "Audio connections identical and no entertainment suppression wanted -> ignore!");
                return;
            }
            if (!bl && this.mRequestedAudioConnection == this.mActiveAudioConnection && this.mMediaAudible) {
                this.requestAudioConnection(9, true);
            } else {
                this.requestAudioConnection(this.mRequestedAudioConnection, true);
            }
        }
    }

    private void responseAudioConnection(int n) {
        this.mActiveAudioConnection = n;
        if (this.isRegisteredForResponse(RT_REQUEST_AUDIO_CONNECTION)) {
            if (n == 8) {
                this.fireResponse(false, "Mute connection active... this must never happen!");
                return;
            }
            if (n == 9 && this.mRequestedAudioConnection != 9) {
                if (this.mRequestedAudioConnection != -1) {
                    this.requestAudioConnection(this.mRequestedAudioConnection, true);
                } else {
                    this.fireResponse(false, "Requested connection == -1");
                }
            } else {
                this.fireResponse(this.mRequestedAudioConnection == n, new StringBuffer().append("REQUESTED: ").append(this.getConnectionStr(this.mRequestedAudioConnection)).append(" RESPONSED: ").append(this.getConnectionStr(n)).toString());
            }
        }
    }

    private String getConnectionStr(int n) {
        String string = "UNKNOWN_CONNECTION";
        switch (n) {
            case 9: {
                string = "CL_FCT_AMP_ENT_SUPPRESSION";
                break;
            }
            case 216: {
                string = "CL_ENT_AMP_EXBOX_AUXADAPTER";
                break;
            }
            case 215: {
                string = "CL_ENT_AMP_EXBOX_AUXIN";
                break;
            }
            case 217: {
                string = "CL_ENT_AMP_EXBOX_BTDEVICE";
                break;
            }
            case 214: {
                string = "CL_ENT_AMP_EXBOX_DMB";
                break;
            }
            case 42: {
                string = "CL_ENT_AMP_MEDIA_AIRPLAY";
                break;
            }
            case 17: {
                string = "CL_ENT_AMP_MEDIA_AUXADAPTER";
                break;
            }
            case 16: {
                string = "CL_ENT_AMP_MEDIA_AUXIN";
                break;
            }
            case 40: {
                string = "CL_ENT_AMP_MEDIA_BLURAY";
                break;
            }
            case 21: {
                string = "CL_ENT_AMP_MEDIA_BTDEVICE";
                break;
            }
            case 18: {
                string = "CL_ENT_AMP_MEDIA_CDA";
                break;
            }
            case 24: {
                string = "CL_ENT_AMP_MEDIA_CDA_DVDC";
                break;
            }
            case 45: {
                string = "CL_ENT_AMP_MEDIA_CLOUD";
                break;
            }
            case 27: {
                string = "CL_ENT_AMP_MEDIA_DVBT";
                break;
            }
            case 19: {
                string = "CL_ENT_AMP_MEDIA_DVD";
                break;
            }
            case 23: {
                string = "CL_ENT_AMP_MEDIA_DVD_DVDC";
                break;
            }
            case 41: {
                string = "CL_ENT_AMP_MEDIA_HDMI";
                break;
            }
            case 20: {
                string = "CL_ENT_AMP_MEDIA_MFP";
                break;
            }
            case 201: {
                string = "CL_ENT_AMP_MEDIA_MFP_BORDBOOK";
                break;
            }
            case 49: {
                string = "CL_ENT_AMP_MEDIA_TV_AV";
                break;
            }
            case 44: {
                string = "CL_ENT_AMP_MEDIA_UPNP";
                break;
            }
            case 91: {
                string = "CL_ENT_AMP_MENU_PHONE_RINGER_MFP";
                break;
            }
            case 240: {
                string = "CL_ENT_AMP_MIRRORLINK";
                break;
            }
            case 95: {
                string = "CL_ENT_AMP_PHONE_RINGER_MFP";
                break;
            }
            case 13: {
                string = "CL_ENT_AMP_TUNER_AM";
                break;
            }
            case 26: {
                string = "CL_ENT_AMP_TUNER_DAB";
                break;
            }
            case 12: {
                string = "CL_ENT_AMP_TUNER_FM";
                break;
            }
            case 43: {
                string = "CL_ENT_AMP_TUNER_ONLINE";
                break;
            }
            case 46: {
                string = "CL_ENT_AMP_TUNER_PERSONAL";
                break;
            }
            case 28: {
                string = "CL_ENT_AMP_TUNER_SDARS";
                break;
            }
            case 15: {
                string = "CL_ENT_AMP_TUNER_TI";
                break;
            }
            default: {
                string = "UNKNOWN_CONNECTION";
            }
        }
        return new StringBuffer().append(string).append(" (").append(n).append(")").toString();
    }

    private void requestAudioConnection(int n, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaAudioManager.requestAudioConnection()").append(n).log();
        }
        this.sendAudioConnectionRequest(n, bl);
    }

    private void sendAudioConnectionRequest(int n, boolean bl) {
        EventGeneric eventGeneric = this.newServiceEvent(34159872);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setBoolean(2, true);
        eventGeneric.setSenderEventId(-1585053440);
        this.sendSafe(eventGeneric);
    }

    private int getMatchingConnection(MediaCollector mediaCollector) {
        if (mediaCollector.isCDDA()) {
            if (!mediaCollector.isDVDChanger()) {
                return 18;
            }
            return 18;
        }
        if (mediaCollector.isDVDAudio() || mediaCollector.isDVDVideo()) {
            if (!mediaCollector.isDVDChanger()) {
                return 19;
            }
            return 19;
        }
        if (mediaCollector.isBT()) {
            return 21;
        }
        if (mediaCollector.isIPod()) {
            return 20;
        }
        if (mediaCollector.isAUX()) {
            boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(60);
            return bl ? 215 : 16;
        }
        return 20;
    }

    public void rqDummyAudioConnection(ResponseHandler responseHandler) {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaAudioManager.requestDummyAudioConnection()").log();
        }
        if (this.isAudioConnectionAvailable()) {
            this.lockDummyVolumeConnection();
        }
        this.rqAudioConnection(20, responseHandler, true);
    }

    public void rqMediaFadeIn(ResponseHandler responseHandler) {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaAudioManager.requestMediaFadeIn()").log();
        }
        if (this.registerForResponse(RT_FADE_TO, responseHandler)) {
            if (this.isAudioConnectionAvailable()) {
                EventGeneric eventGeneric = this.newServiceEvent(50937088);
                eventGeneric.setInt(0, this.mActiveAudioConnection);
                eventGeneric.setSenderEventId(-1568276224);
                this.sendSafe(eventGeneric);
            } else {
                this.fireResponse(true, "not fading in, audio connection not available");
            }
        }
    }

    public boolean isMediaOnTop() {
        return this.mMediaAudible;
    }

    public boolean isMuteActive() {
        return this.mMuteActive;
    }

    public boolean isMuteStarted() {
        return this.mMuteStarted;
    }

    public boolean isStandbyPowerSaveActive() {
        return this.standbyPowerSaveActive;
    }

    @Override
    public int getComponentId() {
        return 4;
    }

    public boolean isMediaAudibleAfterDemute() {
        return !this.isMediaOnTop() && this.isMuteActive();
    }

    public boolean isMuteBeforeAmUnavailable() {
        return this.mMuteBeforeAmUnavailable;
    }

    static {
        RT_REQUEST_AUDIO_CONNECTION = MediaAudioManager.assignRequestId();
        RT_WAIT_FOR_MEDIA_NOT_AUDIBLE = MediaAudioManager.assignRequestId();
        RT_FADE_TO = MediaAudioManager.assignRequestId();
        RT_MUTE = MediaAudioManager.assignRequestId();
        RT_DEMUTE = MediaAudioManager.assignRequestId();
        OBSERVER = new int[]{118045952, 269040896, 352926976, 805911808, 503921920, 487144704, -1745996288, 362627328, 379404544, 178077952, 396181760};
    }
}

