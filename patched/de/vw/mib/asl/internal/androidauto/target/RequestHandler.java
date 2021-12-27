/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.api.impl.ExboxGuidanceListenerImpl;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.asl.internal.androidauto.target.NavigationListener;
import de.vw.mib.asl.internal.androidauto.target.SpeechHandler;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler;
import de.vw.mib.genericevents.EventGeneric;

public class RequestHandler {
    AndroidAutoTarget target;
    private AudioHandler audioHandler;
    private NavigationListener navigationHandler;
    private AndroidAutoGlobalProperties properties;
    private SpeechHandler speechHandler;
    private StartupHandler startupHandler;
    private TimerHandler timerHandler;
    private ExboxGuidanceListenerImpl exboxGuidanceListenerImpl;

    public RequestHandler(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler, AudioHandler audioHandler, SpeechHandler speechHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
        this.audioHandler = audioHandler;
        this.speechHandler = speechHandler;
        this.navigationHandler = null;
        this.timerHandler = null;
        this.exboxGuidanceListenerImpl = null;
    }

    public void initTimerHandler(TimerHandler timerHandler) {
        this.timerHandler = timerHandler;
    }

    public void initNavigationListener(NavigationListener navigationListener) {
        this.navigationHandler = navigationListener;
    }

    public void initExBoxNavServices(ExboxGuidanceListenerImpl exboxGuidanceListenerImpl) {
        this.exboxGuidanceListenerImpl = exboxGuidanceListenerImpl;
    }

    public void performVideoFocusRequestNotification(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("RequestHandler::performVideoFocusRequestNotification - videoFocusMode = ").append(n).toString());
        }
        switch (n) {
            case 1: {
                if (this.properties.getVideoFocusState() == 2) {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(840195328);
                    this.target.sendSafe(eventGeneric);
                    this.properties.setVideoFocusState(1);
                } else if (this.target.isTraceEnabled()) {
                    this.target.trace("=> VideoFocus is already projected...");
                }
                this.target.getDSIAndroidAuto2().videoFocusNotification(1, false);
                break;
            }
            case 2: {
                if (this.properties.getVideoFocusState() == 1) {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(856972544);
                    this.target.sendSafe(eventGeneric);
                    this.properties.setVideoFocusState(2);
                } else if (this.target.isTraceEnabled()) {
                    this.target.trace("=> VideoFocus is already native...");
                }
                this.target.getDSIAndroidAuto2().videoFocusNotification(2, false);
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("VideoFocusMode ").append(n).append(" is invalid!").toString());
            }
        }
    }

    public void performVideoAvailable(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("RequestHandler::performVideoAvailable - videoAvailable = ").append(bl).toString());
        }
        if (bl) {
            this.properties.setVideoStreamAvailable(true);
            if (this.timerHandler.isVideoAvailableTimerStarted()) {
                this.timerHandler.stopVideoAvailableTimer();
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(845622272, this.properties.isVideoStreamAvailable());
        } else {
            this.properties.setVideoStreamAvailable(false);
        }
    }

    public void videoAvailableTimerExpired() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("RequestHandler::videoAvailableTimerExpired");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(845622272, false);
    }

    public void performAudioFocusRequestNotification(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("RequestHandler::performAudioFocusRequestNotification - audioFocusRequestType = ").append(n).toString());
            this.target.trace(new StringBuffer().append("=====> properties.isUserMuteStarted() = ").append(this.properties.isUserMuteStarted()).toString());
            this.target.trace(new StringBuffer().append("=====> properties.isUserMuteActive() = ").append(this.properties.isUserMuteActive()).toString());
            this.target.trace(new StringBuffer().append("=====> properties.isAudible() = ").append(this.properties.isAudible()).toString());
        }
        switch (n) {
            case 1: {
                this.properties.setCurrentAudioFocusRequest(1);
                this.audioHandler.performAudioFocusRequestGain();
                break;
            }
            case 2: {
                this.properties.setCurrentAudioFocusRequest(2);
                this.audioHandler.performAudioFocusRequestGainTransient();
                break;
            }
            case 3: {
                this.properties.setCurrentAudioFocusRequest(3);
                this.audioHandler.performAudioFocusRequestGainTransientMayDuck();
                break;
            }
            case 4: {
                this.properties.setCurrentAudioFocusRequest(4);
                this.audioHandler.performAudioFocusRequestRelease();
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("AudioFocusRequestType ").append(n).append(" is invalid!").toString());
            }
        }
    }

    public void performVoiceSessionNotification(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("RequestHandler::performVoiceSessionNotification - voiceSessionStatus = ").append(n).toString());
        }
        switch (n) {
            case 1: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace("===> forceStartGALSpeech()");
                }
                this.speechHandler.forceStartGALSpeech();
                break;
            }
            case 2: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace("===> forceStopGALSpeech()");
                }
                this.speechHandler.forceStopGALSpeech();
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("VoiceSessionStatus ").append(n).append(" is invalid!").toString());
            }
        }
    }

    public void voiceSessionStartDelayTimerExpired() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("RequestHandler::voiceSessionStartDelayTimerExpired");
        }
        this.speechHandler.forceStartGALSpeech();
    }

    public void performMicrophoneRequestNotification(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("RequestHandler::performMicrophoneRequestNotification - micModeStatus = ").append(n).toString());
        }
        switch (n) {
            case 1: {
                this.audioHandler.performMicrophoneRequestMicrophoneOpen();
                break;
            }
            case 2: {
                this.audioHandler.performMicrophoneRequestMicrophoneClose();
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("MicModeStatus ").append(n).append(" is invalid!").toString());
            }
        }
    }

    public void performNavFocusRequestNotification(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("RequestHandler::performNavFocusRequestNotification - navFocusType = ").append(n).toString());
        }
        switch (n) {
            case 1: {
                // ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, false);
                // this.properties.setAndroidAutoNavigationActive(false);
                // if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
                //     this.target.getDSIAndroidAuto2().navFocusNotification(1, false);
                // }
                // if (this.exboxGuidanceListenerImpl == null) break;
                // this.exboxGuidanceListenerImpl.setSmartphoneGuidanceInactive();
                // break;
            }
            case 2: {
                if (this.navigationHandler.isGuidanceActive()) {
                    if (this.target.isTraceEnabled()) {
                        this.target.trace("RequestHandler::performNavFocusRequestNotification ==> sending stopGuidance() to native navigation...");
                    }
                    // this.navigationHandler.stopGuidance();
                }
                // ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, true);
                this.properties.setAndroidAutoNavigationActive(true);
                if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
                    this.target.getDSIAndroidAuto2().navFocusNotification(2, false);
                }
                // if (this.exboxGuidanceListenerImpl == null) break;
                // this.exboxGuidanceListenerImpl.setSmartphoneGuidanceActive();
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("NavFocusType ").append(n).append(" is invalid!").toString());
            }
        }
    }
}

