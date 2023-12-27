/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoConstants;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.asl.internal.androidauto.target.GestureHandler;
import de.vw.mib.asl.internal.androidauto.target.NavigationListener;
import de.vw.mib.asl.internal.androidauto.target.SpeechHandler;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler;
import de.vw.mib.genericevents.EventGeneric;

class ASLHandler {
    public String classname = "ANDROIDAUTO.ASLHandler";
    private final AndroidAutoTarget target;
    private final AndroidAutoGlobalProperties properties;
    private final StartupHandler startupHandler;
    private final SpeechHandler speechHandler;
    private final AudioHandler audioHandler;
    private NavigationListener navigationListener;
    private TimerHandler timerHandler;
    private GestureHandler gestureHandler;

    public ASLHandler(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler, AudioHandler audioHandler, SpeechHandler speechHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
        this.audioHandler = audioHandler;
        this.speechHandler = speechHandler;
        this.timerHandler = null;
        int n = ServiceManager.configManagerDiag.getLayoutAndroidAutoCanvasDimensionWidth();
        int n2 = ServiceManager.configManagerDiag.getLayoutAndroidAutoCanvasDimensionWidth();
        if (androidAutoTarget.isTraceEnabled()) {
            androidAutoTarget.trace(new StringBuffer().append("ASLHandler.canvasWidthResolution: ").append(n).toString());
        }
        this.gestureHandler = new GestureHandler(androidAutoTarget, startupHandler, n, n2);
    }

    public void initTimerHandler(TimerHandler timerHandler) {
        this.timerHandler = timerHandler;
    }

    public void initNavigationListener(NavigationListener navigationListener) {
        this.navigationListener = navigationListener;
    }

    public void handleAslApiEnterAndroidAutoCanvas() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslApiEnterAndroidAutoCanvas");
            this.target.trace(new StringBuffer().append("properties.getVideoFocusState() = ").append(AndroidAutoConstants.VIDEOFOCUS_STATE[this.properties.getVideoFocusState()]).toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1030070784);
        this.target.sendSafe(eventGeneric);
        if (this.properties.getVideoFocusState() != 1 && this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().videoFocusNotification(1, true);
        }
        this.properties.setVideoFocusState(1);
        if (!this.properties.isVideoStreamAvailable()) {
            this.timerHandler.startVideoAvailableTimer();
        }
    }

    public void handleAslApiLeaveAndroidAutoCanvas() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslApiLeaveAndroidAutoCanvas");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1013293568);
        this.target.sendSafe(eventGeneric);
        if (this.properties.getVideoFocusState() != 2 && this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().videoFocusNotification(2, true);
        }
        this.properties.setVideoFocusState(2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(845622272, true);
    }

    public void handleAslApiTouchEventGesture(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslApiTouchEventGesture");
        }
        if (null != this.gestureHandler) {
            this.gestureHandler.handleTouchEventGesture(n, n2, n3, n4, n5, n6, n7);
        }
    }

    public void handleAslApiRotaryEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslApiRotaryEvent - gesture = ").append(n).toString());
        }
        switch (n) {
            case 0: {
                if (!this.startupHandler.isDSI2Registered() || !this.startupHandler.isDeviceConnected()) break;
                this.target.getDSIAndroidAuto2().postRotaryEvent(-1);
                break;
            }
            case 1: {
                if (!this.startupHandler.isDSI2Registered() || !this.startupHandler.isDeviceConnected()) break;
                this.target.getDSIAndroidAuto2().postRotaryEvent(1);
                break;
            }
            case 2: {
                if (!this.startupHandler.isDSI2Registered() || !this.startupHandler.isDeviceConnected()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(23, 0);
                break;
            }
            case 3: {
                if (!this.startupHandler.isDSI2Registered() || !this.startupHandler.isDeviceConnected()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(23, 0);
                break;
            }
            case 4: {
                if (!this.startupHandler.isDSI2Registered() || !this.startupHandler.isDeviceConnected()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(23, 1);
                break;
            }
        }
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_GAL() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_GAL");
        }
        this.startupHandler.setDeviceConnected(true);
        this.startupHandler.startAndroidAutoService2();
        this.audioHandler.setSoundConnection(160);
        if (!this.speechHandler.isRegistered()) {
            this.speechHandler.registerService();
        }
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_GAL() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_GAL");
        }
        if (this.navigationListener.isGuidanceActive()) {
            this.properties.setAndroidAutoNavigationActive(false);
            if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
                this.target.getDSIAndroidAuto2().navFocusNotification(1, true);
            }
        }
        DayNightService dayNightService = ASLSystemFactory.getSystemApi().getDayNightService();
        boolean bl = this.convertDayNightSensorValueToIsNightBoolean(dayNightService.getDayNightModeSensorValue());
        this.handleAslSystemDayNightMode(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, this.properties.isAndroidAutoNavigationActive());
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_GAL() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("ASLHandler::handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_GAL");
        }
        this.startupHandler.setDeviceConnected(false);
        this.properties.setVideoStreamAvailable(false);
        this.properties.setVideoFocusState(2);
        this.properties.setCurrentAudioFocusState(3);
        this.properties.setLastAudioFocusState(3);
        this.properties.setCurrentAudioFocusRequest(0);
        this.properties.setAudioConnectionToObserve(0);
        this.timerHandler.stopAudioAnsweringDelayTimer();
        this.timerHandler.stopAudioManagerTimeoutTimer();
        this.timerHandler.stopMicrophoneAnsweringDelayTimer();
        this.timerHandler.stopVideoAvailableTimer();
        this.audioHandler.releaseSoundConnection(160);
        if (this.properties.getAudioState_CL_ANN_AMP_GAL_LOWERING() > 0) {
            this.audioHandler.releaseSoundConnection(161);
        }
        if (this.properties.getAudioState_CL_ANN_AMP_GAL_SPEECH() > 0) {
            this.audioHandler.releaseSoundConnection(158);
        }
        if (this.properties.getAudioState_CL_SYS_AMP_GAL_SPEECH_INPUT() > 0) {
            this.audioHandler.releaseSoundConnection(159);
        }
        if (this.properties.getEntertainmentState() == 5) {
            this.audioHandler.setEntertainmentVolumeLock();
        }
        if (this.properties.isGALSpeechActive()) {
            this.speechHandler.forceStopGALSpeech();
        }
        if (this.speechHandler.isServiceRegistered()) {
            this.speechHandler.unregisterService();
        }
        this.properties.setAndroidAutoNavigationActive(false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, this.properties.isAndroidAutoNavigationActive());
    }

    public void handleAslSystemDayNightMode(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleAslSystemDayNightMode - isNightModeActive = ").append(bl).toString());
        }
        this.properties.setNightModeActive(bl);
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered()) {
            this.target.getDSIAndroidAuto2().setNightMode(bl);
        }
    }

    public void handleASLSmartphoneIntegrationMflHk(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("ASLHandler::handleASLSmartphoneIntegrationMflHk - mflHk = ").append(n).toString());
        }
        switch (n) {
            case 0: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(87, 0);
                this.target.getDSIAndroidAuto2().postButtonEvent(87, 1);
                break;
            }
            case 1: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(90, 0);
                break;
            }
            case 2: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(88, 0);
                this.target.getDSIAndroidAuto2().postButtonEvent(88, 1);
                break;
            }
            case 3: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(89, 1);
                break;
            }
            case 4: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(90, 1);
                break;
            }
            case 5: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(89, 0);
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(85, 0);
                break;
            }
            case 12: {
                if (!this.startupHandler.isDeviceConnected() || !this.startupHandler.isDSI2Registered()) break;
                this.target.getDSIAndroidAuto2().postButtonEvent(85, 1);
                break;
            }
        }
    }

    boolean convertDayNightSensorValueToIsNightBoolean(int n) {
        return n == 2;
    }
}

