/*
 * Decompiled with CFR 0.151-SNAPSHOT (5569f06-dirty).
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.asl.internal.androidauto.target.RequestHandler;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

class DSIHandler {
    private AndroidAutoTarget target;
    private AudioHandler audioHandler;
    private RequestHandler requestHandler;

    DSIHandler(AndroidAutoTarget androidAutoTarget, AudioHandler audioHandler, RequestHandler requestHandler) {
        this.target = androidAutoTarget;
        this.audioHandler = audioHandler;
        this.requestHandler = requestHandler;
    }

    public void handleDsiAndroidAuto2VideoFocusRequestNotification(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VideoFocusRequestNotification - validFlag      = ").append(n2).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VideoFocusRequestNotification - videoFocusMode = ").append(n).toString());
        }
        if (n2 == 1) {
            this.requestHandler.performVideoFocusRequestNotification(n);
        }
    }

    public void handleDsiAndroidAuto2VideoAvailable(boolean bl, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VideoFocusRequestNotification - validFlag      = ").append(n).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VideoFocusRequestNotification - videoAvailable = ").append(bl).toString());
        }
        if (n == 1) {
            this.requestHandler.performVideoAvailable(bl);
        }
    }

    public void handleDsiAndroidAuto2AudioFocusRequestNotification(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VideoFocusRequestNotification - validFlag             = ").append(n2).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VideoFocusRequestNotification - audioFocusRequestType = ").append(n).toString());
        }
        if (n2 == 1) {
            this.requestHandler.performAudioFocusRequestNotification(n);
        }
    }

    public void handleDsiAndroidAuto2AudioAvailable(int n, boolean bl, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2AudioAvailable - validFlag        = ").append(n2).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2AudioAvailable - audioChannelType = ").append(n).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2AudioAvailable - audioAvailable   = ").append(bl).toString());
        }
        if (n2 == 1) {
            this.audioHandler.performAudioAvailable(n, bl);
        }
    }

    public void handleDsiAndroidAuto2VoiceSessionNotification(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VoiceSessionNotification - validFlag          = ").append(n2).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2VoiceSessionNotification - voiceSessionStatus = ").append(n).toString());
        }
        if (n2 == 1) {
            this.requestHandler.performVoiceSessionNotification(n);
        }
    }

    public void handleDsiAndroidAuto2MicrophoneRequestNotification(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2MicrophoneRequestNotification - validFlag     = ").append(n2).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2MicrophoneRequestNotification - micModeStatus = ").append(n).toString());
        }
        if (n2 == 1) {
            this.requestHandler.performMicrophoneRequestNotification(n);
        }
    }

    public void handleDsiAndroidAuto2NavFocusRequestNotification(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2NavFocusRequestNotification - validFlag    = ").append(n2).toString());
            this.target.trace(new StringBuffer().append("DSIHandler::handleDsiAndroidAuto2NavFocusRequestNotification - navFocusType = ").append(n).toString());
        }
        // System.out.println("** Ignore performNavFocusRequestNotification");
        if (n2 == 1) {
            // Required to allow aa nav to actually start
            this.requestHandler.performNavFocusRequestNotification(n);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, true);
    }
}

