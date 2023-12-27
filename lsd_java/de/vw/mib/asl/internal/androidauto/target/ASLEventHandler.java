/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.internal.androidauto.target.ASLHandler;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

class ASLEventHandler {
    private final String classname;
    private AndroidAutoTarget target;
    private AudioHandler audioHandler;
    private ASLHandler aslHandler;

    public ASLEventHandler(AndroidAutoTarget androidAutoTarget, AudioHandler audioHandler, ASLHandler aSLHandler) {
        this.classname = "ANDROIDAUTO.ASLEventHandler";
        this.target = androidAutoTarget;
        this.audioHandler = audioHandler;
        this.aslHandler = aSLHandler;
    }

    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".gotEvent(POWER_ON)").log();
                }
                this.target.startup();
                break;
            }
            case 1076641824: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(ASLAndroidAutoServiceConstants.ENTER_ANDROID_AUTO_CANVAS)").log();
                }
                this.aslHandler.handleAslApiEnterAndroidAutoCanvas();
                break;
            }
            case 1076641825: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(ASLAndroidAutoServiceConstants.LEAVE_ANDROID_AUTO_CANVAS)").log();
                }
                this.aslHandler.handleAslApiLeaveAndroidAutoCanvas();
                break;
            }
            case 1076641826: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(ASLAndroidAutoServiceConstants.TOUCH_EVENT_GESTURE)").log();
                }
                this.aslHandler.handleAslApiTouchEventGesture(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(3), eventGeneric.getInt(4), eventGeneric.getInt(5), eventGeneric.getInt(6));
                break;
            }
            case 1076641828: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(ASLAndroidAutoServiceConstants.ROTARY_EVENT)").log();
                }
                this.aslHandler.handleAslApiRotaryEvent(eventGeneric);
                break;
            }
            case 1400004: {
                this.audioHandler.handleEntertainmentmanagerServiceIdsActivateStartup(eventGeneric);
                break;
            }
            case 1400003: {
                this.audioHandler.handleAslEntertainmentmanagerServiceIdsActivate();
                break;
            }
            case 0x155CC5: {
                this.audioHandler.handleAslEntertainmentmanagerServiceIdsDeactivate();
                break;
            }
            case 1400006: {
                this.audioHandler.handleAslEntertainmentmanagerServiceIdsCancel();
                break;
            }
            case 1400013: {
                this.audioHandler.handleAslEntertainmentmanagerServiceIdsLoss();
                break;
            }
            case 4000015: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(ASLSoundServiceIds.ASL_SOUND_AUDIO_CONNECTION_RELEASED)").append(" AudioSource=").append(eventGeneric.getInt(0)).log();
                }
                this.audioHandler.handleAslSoundAudioConnectionReleased(eventGeneric);
                break;
            }
            case 4000024: {
                this.audioHandler.handleAslSoundAudioConnectionStarted(eventGeneric);
                break;
            }
            case 100003: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(EV_ANDROIDAUTO_SOUND_SET_CONNECTION_ANSWER)").append(" AudioSource=").append(eventGeneric.getInt(0)).log();
                }
                this.audioHandler.handleAslApiEV_ANDROIDAUTO_SOUND_SET_CONNECTION_ANSWER(eventGeneric);
                break;
            }
            case 100004: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(EV_ANDROIDAUTO_SOUND_RELEASE_CONNECTION_ANSWER)").append(" AudioSource=").append(eventGeneric.getInt(0)).log();
                }
                this.audioHandler.handleAslApiEV_ANDROIDAUTO_SOUND_RELEASE_CONNECTION_ANSWER(eventGeneric);
                break;
            }
            case 4000007: {
                this.audioHandler.handleAslSoundUsermuteIsActive(eventGeneric);
                break;
            }
            case 4000045: {
                this.audioHandler.handleAslAndroidAutoAudible(eventGeneric);
                break;
            }
            case 4000021: {
                this.audioHandler.handleAslSoundAudiomngmntStatus(eventGeneric);
                break;
            }
            case 100007: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("ANDROIDAUTO.ASLEventHandler").append("handle(EV_ANDROIDAUTO_AUDIO_ANSWERING_DELAY_TIMER_EXPIRED)").log();
                }
                this.audioHandler.audioAnsweringDelayTimerExpired();
                break;
            }
            case 100008: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("ANDROIDAUTO.ASLEventHandler").append("handle(EV_ANDROIDAUTO_AUDIOMANAGER_TIMEOUT_DELAY_TIMER_EXPIRED)").log();
                }
                this.audioHandler.audioManagerTimeoutTimerExpired();
                break;
            }
            case 100009: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("ANDROIDAUTO.ASLEventHandler").append("handle(EV_ANDROIDAUTO_MICROPHONE_ANSWERING_DELAY_TIMER_EXPIRED)").log();
                }
                this.audioHandler.microphoneAnsweringDelayTimerExpired();
                break;
            }
            case 100010: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("ANDROIDAUTO.ASLEventHandler").append("handle(EV_ANDROIDAUTO_VIDEO_AVAILABLE_DELAY_TIMER_EXPIRED)").log();
                }
                this.target.getRequestHandler().videoAvailableTimerExpired();
                break;
            }
            case 6100005: {
                this.aslHandler.handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_GAL();
                break;
            }
            case 6100006: {
                this.aslHandler.handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_GAL();
                break;
            }
            case 6100016: {
                this.aslHandler.handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_GAL();
                break;
            }
            case 6100025: {
                this.aslHandler.handleASLSmartphoneIntegrationMflHk(eventGeneric);
                break;
            }
            case 4300038: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ANDROIDAUTO.ASLEventHandler").append(".handle(ASLSystemServiceIds.DAYNIGHT_MODE)").log();
                }
                this.aslHandler.handleAslSystemDayNightMode(eventGeneric.getBoolean(0));
                break;
            }
        }
    }
}

