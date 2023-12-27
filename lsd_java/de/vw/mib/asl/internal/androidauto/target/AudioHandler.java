/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler$1;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

class AudioHandler {
    AndroidAutoTarget target;
    private AndroidAutoGlobalProperties properties;
    private StartupHandler startupHandler;
    private TimerHandler timerHandler;
    private TimerManager timerManager;

    public AudioHandler(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
        this.timerHandler = null;
    }

    public void initTimerHandler(TimerHandler timerHandler) {
        this.timerHandler = timerHandler;
    }

    public void handleAslSoundAudiomngmntStatus(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslSoundAudiomngmntStatus - state = ").append(n).toString());
        }
        switch (n) {
            case 0: {
                this.properties.setAudioManagementAvailable(false);
                this.releaseSoundConnection(156);
                this.releaseSoundConnection(160);
                this.releaseSoundConnection(161);
                this.releaseSoundConnection(158);
                this.releaseSoundConnection(159);
                this.properties.setEntertainmentState(2);
                this.properties.setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(0);
                this.properties.setAudioState_CL_ANN_AMP_GAL_LOWERING(0);
                this.properties.setAudioState_CL_ANN_AMP_GAL_SPEECH(0);
                this.properties.setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(0);
                this.handleNewAudioFocusState(3, true);
                break;
            }
            case 1: {
                this.properties.setAudioManagementAvailable(true);
                break;
            }
            case 2: {
                this.properties.setAudioManagementAvailable(true);
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.setSoundConnection(160);
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("State ").append(n).append(" is invalid!").toString());
            }
        }
    }

    public void registerTargetToEntertainmentManager() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::registerTargetToEntertainmentManager");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-899934976);
        eventGeneric.setInt(0, 8);
        eventGeneric.setInt(3, 1369316096);
        this.target.sendSafe(eventGeneric);
        this.properties.setEntertainmentState(1);
    }

    public void requestEntertainmentConnection() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::requestEntertainmentConnection");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-916712192);
        eventGeneric.setInt(0, 1);
        eventGeneric.setInt(1, 8);
        this.target.sendSafe(eventGeneric);
        this.properties.setEntertainmentState(3);
    }

    public void handleAslEntertainmentmanagerServiceIdsCancel() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::handleAslEntertainmentmanagerServiceIdsCancel");
        }
        this.properties.setEntertainmentState(2);
        this.handleNewAudioFocusState(3, true);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
        this.target.sendSafe(eventGeneric);
        eventGeneric = ServiceManager.mGenericEventFactory.newEvent(940858624);
        this.target.sendSafe(eventGeneric);
    }

    public void handleAslEntertainmentmanagerServiceIdsLoss() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::handleAslEntertainmentmanagerServiceIdsLoss");
        }
        this.properties.setEntertainmentState(2);
        this.handleNewAudioFocusState(3, true);
    }

    public void handleAslEntertainmentmanagerServiceIdsActivate() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::handleAslEntertainmentmanagerServiceIdsActivate");
        }
        this.setSoundConnection(156);
        this.setEntertainmentVolumeLock();
        this.properties.setAudioConnectionToObserve(156);
        this.timerHandler.startAudioManagerTimeoutTimer();
        this.properties.setEntertainmentState(4);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(924081408);
        this.target.sendSafe(eventGeneric);
    }

    public void handleEntertainmentmanagerServiceIdsActivateStartup(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::handleEntertainmentmanagerServiceIdsActivateStartup");
        }
        if (eventGeneric.getInt(0) == 8) {
            this.properties.setEntertainmentState(2);
            this.handleAslEntertainmentmanagerServiceIdsActivate();
        }
    }

    public void handleAslEntertainmentmanagerServiceIdsDeactivate() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::handleAslEntertainmentmanagerServiceIdsDeactivate");
        }
        this.properties.setEntertainmentState(2);
        this.handleNewAudioFocusState(3, true);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1050929920);
        this.target.sendSafe(eventGeneric);
        eventGeneric = ServiceManager.mGenericEventFactory.newEvent(940858624);
        this.target.sendSafe(eventGeneric);
    }

    public void setSoundConnection(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("AudioHandler::setSoundConnection - audioconstant: ").append(n).toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        eventGeneric.setInt(0, n);
        if (n == 156) {
            eventGeneric.setBoolean(1, true);
        }
        eventGeneric.setBoolean(2, true);
        eventGeneric.setSenderEventId(-1551499008);
        this.target.sendSafe(eventGeneric);
        switch (n) {
            case 156: {
                this.properties.setEntertainmentState(4);
                break;
            }
            case 160: {
                this.properties.setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(1);
                break;
            }
            case 161: {
                this.properties.setAudioState_CL_ANN_AMP_GAL_LOWERING(1);
                break;
            }
            case 158: {
                this.properties.setAudioState_CL_ANN_AMP_GAL_SPEECH(1);
                break;
            }
            case 159: {
                this.properties.setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(1);
                break;
            }
        }
    }

    public void releaseSoundConnection(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("AudioHandler::releaseSoundConnection - audioconstant: ").append(n).toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
        eventGeneric.setInt(0, n);
        eventGeneric.setSenderEventId(-1534721792);
        this.target.sendSafe(eventGeneric);
    }

    public void setEntertainmentVolumeLock() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::setEntertainmentVolumeLock");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
        eventGeneric.setInt(0, 156);
        this.target.sendSafe(eventGeneric);
    }

    public void releaseEntertainmentVolumeLock() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::releaseEntertainmentVolumeLock");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
        eventGeneric.setInt(0, 156);
        this.target.sendSafe(eventGeneric);
    }

    public void handleAslSoundUsermuteIsActive(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        boolean bl2 = eventGeneric.getBoolean(1);
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslSoundUsermuteIsActive");
            this.target.trace(new StringBuffer().append("ASL_SOUND_USERMUTE_IS_ACTIVE_P0_STARTED_BOOLEAN = ").append(bl).toString());
            this.target.trace(new StringBuffer().append("ASL_SOUND_USERMUTE_IS_ACTIVE_P1_ACTIVE_BOOLEAN  = ").append(bl2).toString());
        }
        if (bl && !this.properties.isUserMuteStarted() && this.properties.getCurrentAudioFocusState() == 1) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("==> muteStarted=true during GAIN ---> Sending LOSS");
            }
            this.handleNewAudioFocusState(3, true);
            this.releaseEntertainmentVolumeLock();
        }
        if (!bl && this.properties.isUserMuteStarted() && this.properties.getLastAudioFocusState() == 1 && this.properties.getEntertainmentState() == 5 && this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("properties.getLastAudioFocusState() = ").append(this.properties.getLastAudioFocusState()).toString());
            this.target.trace(new StringBuffer().append("properties.getEntertainmentState() = ").append(this.properties.getEntertainmentState()).toString());
        }
        this.properties.setUserMuteStarted(bl);
        this.properties.setUserMuteActive(bl2);
    }

    private void releaseUserMute() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::releaseUserMute");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(789134592);
        this.target.sendSafe(eventGeneric);
    }

    public void fadeIn_CL_ENT_AMP_GAL_MEDIA() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("=> starting Timer for FadeIn GAL Media...");
        }
        this.timerManager = ServiceManager.timerManager;
        Timer timer = this.timerManager.createTimer("AUDIO_FADE_IN_GAL_MEDIA_WAIT_TIMER", 0, false, new AudioHandler$1(this), Timer.TIMER_THREAD_INVOKER);
        timer.start();
    }

    public void handleAslSoundAudioConnectionStarted(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslSoundAudioConnectionStarted - AudioSource = ").append(eventGeneric.getInt(0)).toString());
        }
        if (eventGeneric.getResult() == 0 && this.properties.getCurrentAudioFocusState() == 1) {
            switch (eventGeneric.getInt(0)) {
                case 31: 
                case 32: 
                case 33: 
                case 34: {
                    this.handleNewAudioFocusState(5, true);
                    break;
                }
                case 84: 
                case 85: {
                    this.handleNewAudioFocusState(5, true);
                    break;
                }
            }
        }
    }

    public void handleAslSoundAudioConnectionReleased(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslSoundAudioConnectionReleased - AudioSource = ").append(eventGeneric.getInt(0)).toString());
        }
        if (eventGeneric.getResult() == 0) {
            switch (eventGeneric.getInt(0)) {
                case 156: {
                    this.properties.setEntertainmentState(2);
                    this.handleNewAudioFocusState(3, true);
                    break;
                }
                case 160: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(0);
                    break;
                }
                case 161: {
                    if (this.properties.getAudioState_CL_ANN_AMP_GAL_LOWERING() == 0) break;
                    this.properties.setAudioState_CL_ANN_AMP_GAL_LOWERING(0);
                    this.handleNewAudioFocusState(3, true);
                    break;
                }
                case 158: {
                    if (this.properties.getAudioState_CL_ANN_AMP_GAL_SPEECH() == 0) break;
                    this.properties.setAudioState_CL_ANN_AMP_GAL_SPEECH(0);
                    this.handleNewAudioFocusState(3, true);
                    break;
                }
                case 159: {
                    if (this.properties.getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() == 0) break;
                    this.properties.setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(0);
                    if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                    this.target.getDSIAndroidAuto2().microphoneNotification(2, true);
                    break;
                }
            }
        }
    }

    public void handleAslApiEV_ANDROIDAUTO_SOUND_SET_CONNECTION_ANSWER(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslApiEV_ANDROIDAUTO_SOUND_SET_CONNECTION_ANSWER - AudioSource = ").append(eventGeneric.getInt(0)).toString());
            this.target.trace(new StringBuffer().append("--> properties.getAudioConnectionToObserve() = ").append(this.properties.getAudioConnectionToObserve()).toString());
        }
        if (eventGeneric.getResult() == 0) {
            switch (eventGeneric.getInt(0)) {
                case 156: {
                    this.properties.setEntertainmentState(5);
                    if (this.properties.getAudioConnectionToObserve() == 156) {
                        this.properties.setAudioConnectionToObserve(0);
                        this.timerHandler.stopAudioManagerTimeoutTimer();
                    }
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1067707136);
                    this.target.sendSafe(eventGeneric2);
                    this.target.trace("====> Calling audioHandler.fadeIn_CL_ENT_AMP_GAL_MEDIA();");
                    this.fadeIn_CL_ENT_AMP_GAL_MEDIA();
                    break;
                }
                case 160: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(2);
                    break;
                }
                case 161: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_LOWERING(2);
                    if (this.properties.getAudioConnectionToObserve() != 161) break;
                    this.properties.setAudioConnectionToObserve(0);
                    this.timerHandler.stopAudioManagerTimeoutTimer();
                    break;
                }
                case 158: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_SPEECH(2);
                    if (this.properties.getAudioConnectionToObserve() != 158) break;
                    this.properties.setAudioConnectionToObserve(0);
                    this.timerHandler.stopAudioManagerTimeoutTimer();
                    break;
                }
                case 159: {
                    this.properties.setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(2);
                    break;
                }
            }
        }
    }

    public void handleAslApiEV_ANDROIDAUTO_SOUND_RELEASE_CONNECTION_ANSWER(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslApiEV_ANDROIDAUTO_SOUND_RELEASE_CONNECTION_ANSWER - AudioSource = ").append(eventGeneric.getInt(0)).toString());
            this.target.trace(new StringBuffer().append("--> properties.getAudioConnectionToObserve() = ").append(this.properties.getAudioConnectionToObserve()).toString());
        }
        if (eventGeneric.getResult() == 0) {
            switch (eventGeneric.getInt(0)) {
                case 156: {
                    this.properties.setEntertainmentState(2);
                    if (this.properties.getAudioConnectionToObserve() != 156) break;
                    this.properties.setAudioConnectionToObserve(0);
                    this.timerHandler.stopAudioManagerTimeoutTimer();
                    break;
                }
                case 160: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_ANNOUNCEMENT(0);
                    break;
                }
                case 161: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_LOWERING(0);
                    if (this.properties.getAudioConnectionToObserve() != 161) break;
                    this.properties.setAudioConnectionToObserve(0);
                    this.timerHandler.stopAudioManagerTimeoutTimer();
                    break;
                }
                case 158: {
                    this.properties.setAudioState_CL_ANN_AMP_GAL_SPEECH(0);
                    if (this.properties.getAudioConnectionToObserve() != 158) break;
                    this.properties.setAudioConnectionToObserve(0);
                    this.timerHandler.stopAudioManagerTimeoutTimer();
                    break;
                }
                case 159: {
                    this.properties.setAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT(0);
                    break;
                }
            }
        }
    }

    public void handleAslAndroidAutoAudible(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslAndroidAutoAudible - ASL_ANDROIDAUTO_AUDIBLE_P0_BOOLEAN = ").append(bl).toString());
        }
        this.properties.setAudible(bl);
        if (bl) {
            if (this.properties.getCurrentAudioFocusState() == 5 && this.properties.getLastAudioFocusState() == 1) {
                this.handleNewAudioFocusState(1, true);
            } else if (this.properties.getCurrentAudioFocusState() == 5 && this.properties.getLastAudioFocusState() == 7) {
                this.handleNewAudioFocusState(3, true);
            }
        }
    }

    public void performAudioAvailable(int n, boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performAudioAvailable");
        }
        switch (n) {
            case 0: {
                if (bl) {
                    this.releaseEntertainmentVolumeLock();
                }
                if (bl || this.properties.isUserMuteStarted()) break;
                this.setEntertainmentVolumeLock();
                break;
            }
            case 1: {
                if (bl && this.properties.getCurrentAudioFocusState() == 1 && this.properties.getAudioState_CL_ANN_AMP_GAL_LOWERING() == 0) {
                    this.setSoundConnection(161);
                }
                if (bl || this.properties.getAudioState_CL_ANN_AMP_GAL_LOWERING() == 0) break;
                this.releaseSoundConnection(161);
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("AudioChannelType ").append(n).append(" is invalid!").toString());
            }
        }
    }

    void performAudioFocusRequestGain() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performAudioFocusRequestGain");
        }
        if (this.properties.getAudioState_CL_ANN_AMP_GAL_SPEECH() != 0) {
            this.releaseSoundConnection(158);
            this.properties.setAudioConnectionToObserve(158);
            this.timerHandler.startAudioManagerTimeoutTimer();
        }
        if (this.properties.getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() != 0) {
            this.releaseSoundConnection(159);
        }
        if (this.properties.getEntertainmentState() < 3) {
            this.requestEntertainmentConnection();
        } else if (this.properties.getEntertainmentState() < 4) {
            this.setSoundConnection(156);
            this.properties.setAudioConnectionToObserve(156);
            this.timerHandler.startAudioManagerTimeoutTimer();
        }
        this.handleNewAudioFocusState(1, false);
        this.properties.setCurrentAudioFocusRequest(0);
        if (this.properties.isUserMuteActive()) {
            this.releaseUserMute();
        }
    }

    void performAudioFocusRequestGainTransient() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performAudioFocusRequestGainTransient");
        }
        if (this.properties.getCurrentAudioFocusState() == 5) {
            this.handleNewAudioFocusState(5, false);
            this.properties.setCurrentAudioFocusRequest(0);
        } else {
            if (this.properties.getAudioState_CL_ANN_AMP_GAL_SPEECH() == 0) {
                this.setSoundConnection(158);
                this.properties.setAudioConnectionToObserve(158);
                this.timerHandler.startAudioManagerTimeoutTimer();
            }
            this.handleNewAudioFocusState(7, false);
            this.properties.setCurrentAudioFocusRequest(0);
        }
    }

    void performAudioFocusRequestGainTransientMayDuck() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performAudioFocusRequestRelease");
        }
        if (this.properties.getCurrentAudioFocusState() == 5) {
            this.handleNewAudioFocusState(5, false);
            this.properties.setCurrentAudioFocusRequest(0);
        } else {
            if (this.properties.getAudioState_CL_ANN_AMP_GAL_LOWERING() == 0) {
                this.setSoundConnection(161);
                this.properties.setAudioConnectionToObserve(161);
                this.timerHandler.startAudioManagerTimeoutTimer();
            }
            this.handleNewAudioFocusState(7, false);
            this.properties.setCurrentAudioFocusRequest(0);
        }
    }

    void performAudioFocusRequestRelease() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performAudioFocusRequestRelease");
        }
        if (this.properties.getAudioState_CL_ANN_AMP_GAL_LOWERING() != 0) {
            this.releaseSoundConnection(161);
            this.properties.setAudioConnectionToObserve(161);
            this.timerHandler.startAudioManagerTimeoutTimer();
        }
        if (this.properties.getAudioState_CL_ANN_AMP_GAL_SPEECH() != 0) {
            this.releaseSoundConnection(158);
            this.properties.setAudioConnectionToObserve(158);
            this.timerHandler.startAudioManagerTimeoutTimer();
        }
        if (this.properties.getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() != 0) {
            this.releaseSoundConnection(159);
        }
        this.handleNewAudioFocusState(3, false);
        this.properties.setCurrentAudioFocusRequest(0);
    }

    public void handleNewAudioFocusState(int n, boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::handleNewAudioFocusState");
        }
        if (this.properties.getCurrentAudioFocusState() != n) {
            this.properties.setLastAudioFocusState(this.properties.getCurrentAudioFocusState());
            this.properties.setCurrentAudioFocusState(n);
        }
        if (bl) {
            this.sendAudioFocusNotification(bl);
        } else {
            this.timerHandler.startAudioAnsweringDelayTimer();
        }
        if (this.properties.isUserMuteActive() && this.properties.getLastAudioFocusState() != 1) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("==> Mute active, lastAudioFocusState != AUDIOFOCUSSTATE_GAIN ------> setEntertainmentVolumeLock");
            }
            this.setEntertainmentVolumeLock();
        }
    }

    public void audioAnsweringDelayTimerExpired() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::answeringDelayTimerExpired");
        }
        this.sendAudioFocusNotification(false);
    }

    public void audioManagerTimeoutTimerExpired() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::audioManagerTimeoutTimerExpired");
        }
        this.properties.setAudioConnectionToObserve(0);
        this.performAudioFocusRequestRelease();
    }

    private void sendAudioFocusNotification(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::sendAudioFocusNotification");
        }
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().audioFocusNotification(this.properties.getCurrentAudioFocusState(), bl);
        }
    }

    public void performMicrophoneRequestMicrophoneOpen() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performMicrophoneRequestMicrophoneOpen");
        }
        if (this.properties.getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() == 0) {
            this.setSoundConnection(159);
        }
        this.timerHandler.startMicrophoneAnsweringDelayTimer();
    }

    public void performMicrophoneRequestMicrophoneClose() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::performMicrophoneRequestMicrophoneClose");
        }
        this.releaseSoundConnection(159);
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().microphoneNotification(2, false);
        }
    }

    public void microphoneAnsweringDelayTimerExpired() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("AudioHandler::microphoneAnsweringDelayTimerExpired");
        }
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().microphoneNotification(1, false);
        }
    }

    private void postButtonEvent(int n, int n2) {
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().postButtonEvent(n, n2);
        }
    }
}

