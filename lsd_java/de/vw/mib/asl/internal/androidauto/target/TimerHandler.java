/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.asl.internal.androidauto.target.RequestHandler;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler$1;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler$2;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler$3;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler$4;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class TimerHandler {
    AndroidAutoTarget target;
    AudioHandler audioHandler;
    RequestHandler requestHandler;
    private TimerManager timerManager;
    private Timer audioAnsweringDelayTimer;
    private Timer audioManagerTimeoutTimer;
    private Timer microphoneAnsweringDelayTimer;
    private Timer videoAvailableTimer;

    public TimerHandler(AndroidAutoTarget androidAutoTarget, AudioHandler audioHandler, RequestHandler requestHandler) {
        this.target = androidAutoTarget;
        this.audioHandler = audioHandler;
        this.requestHandler = requestHandler;
        this.timerManager = ServiceManager.timerManager;
        this.initializeAudioAnsweringDelayTimer();
        this.initializeAudioManagerTimeoutTimer();
        this.initializeMicrophoneAnsweringDelayTimer();
        this.initializeVideoAvailableTimer();
    }

    private void initializeAudioAnsweringDelayTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::initializeAudioAnsweringDelayTimer");
        }
        this.audioAnsweringDelayTimer = this.timerManager.createTimer("AA_AUDIO_ANSWERING_DELAY_TIMER", 0, false, new TimerHandler$1(this), Timer.TIMER_THREAD_INVOKER);
    }

    public void startAudioAnsweringDelayTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::startAudioAnsweringDelayTimer");
        }
        if (!this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1484390144)) {
            this.target.startTimer(-1484390144, (long)0, false);
        }
    }

    public void stopAudioAnsweringDelayTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::stopAudioAnsweringDelayTimer");
        }
        if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1484390144)) {
            this.target.stopTimer(-1484390144);
        }
    }

    public boolean isAudioAnsweringDelayTimerStarted() {
        return this.audioAnsweringDelayTimer.isStarted();
    }

    private void initializeAudioManagerTimeoutTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::initializeAudioManagerTimeoutTimer");
        }
        this.audioManagerTimeoutTimer = this.timerManager.createTimer("AA_AUDIO_MANAGER_TIMEOUT_TIMER", 0, false, new TimerHandler$2(this), Timer.TIMER_THREAD_INVOKER);
    }

    public void startAudioManagerTimeoutTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::startAudioManagerTimeoutTimer");
        }
        if (!this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1467612928)) {
            this.target.startTimer(-1467612928, (long)0, false);
        }
    }

    public void stopAudioManagerTimeoutTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::stopAudioManagerTimeoutTimer");
        }
        if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1467612928)) {
            this.target.stopTimer(-1467612928);
        }
    }

    public boolean isAudioManagerTimeoutTimerStarted() {
        return this.audioManagerTimeoutTimer.isStarted();
    }

    private void initializeMicrophoneAnsweringDelayTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::initializeMicrophoneAnsweringDelayTimer");
        }
        this.microphoneAnsweringDelayTimer = this.timerManager.createTimer("AA_MICROPHONE_ANSWERING_DELAY_TIMER", 0, false, new TimerHandler$3(this), Timer.TIMER_THREAD_INVOKER);
    }

    public void startMicrophoneAnsweringDelayTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::startMicrophoneAnsweringDelayTimer");
        }
        if (!this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1450835712)) {
            this.target.startTimer(-1450835712, (long)0, false);
        }
    }

    public void stopMicrophoneAnsweringDelayTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::stopMicrophoneAnsweringDelayTimer");
        }
        if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1450835712)) {
            this.target.stopTimer(-1450835712);
        }
    }

    public boolean isMicrophoneAnsweringDelayTimerStarted() {
        return this.microphoneAnsweringDelayTimer.isStarted();
    }

    private void initializeVideoAvailableTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::initializeVideoAvailableTimer");
        }
        this.videoAvailableTimer = this.timerManager.createTimer("AA_VIDEO_AVAILABLE_TIMER", 0, false, new TimerHandler$4(this), Timer.TIMER_THREAD_INVOKER);
    }

    public void startVideoAvailableTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::startVideoAvailableTimer");
        }
        if (!this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1434058496)) {
            this.target.startTimer(-1434058496, (long)0, false);
        }
    }

    public void stopVideoAvailableTimer() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("TimerHandler::stopVideoAvailableTimer");
        }
        if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1434058496)) {
            this.target.stopTimer(-1434058496);
        }
    }

    public boolean isVideoAvailableTimerStarted() {
        return this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1434058496);
    }
}

