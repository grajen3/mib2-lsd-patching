/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife;

import de.vw.mib.asl.internal.carlife.ASLHandler;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.audio.CarLifeAudiohandling;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.PopupHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public class ASLEventHandler {
    private final String classname;
    private CarlifeHSMTarget target;
    private ASLHandler aslhandler;
    private CarLifeAudiohandling audiohandling;
    private CarLifeGlobalProperties properties;
    private PopupHandler popupHandler;

    public ASLEventHandler(CarlifeHSMTarget carlifeHSMTarget, ASLHandler aSLHandler, CarLifeAudiohandling carLifeAudiohandling, CarLifeGlobalProperties carLifeGlobalProperties) {
        this.classname = "CARLIFE.ASLEventController";
        this.target = carlifeHSMTarget;
        this.aslhandler = aSLHandler;
        this.audiohandling = carLifeAudiohandling;
        this.properties = carLifeGlobalProperties;
    }

    public void setPopupHandler(PopupHandler popupHandler) {
        this.popupHandler = popupHandler;
    }

    public void gotEvent(EventGeneric eventGeneric) {
        LogMessage logMessage;
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append(new StringBuffer().append("gotEvent: ").append(eventGeneric.getReceiverEventId()).toString()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".gotEvent(POWER_ON)").log();
                }
                this.target.startup();
                break;
            }
            case 1076641846: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLCarLifeServiceConstants.ENTER_CAR_LIFE_CANVAS)").log();
                }
                this.aslhandler.handleAslApiEnterCarLifeCanvas();
                break;
            }
            case 1076641847: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLCarLifeServiceConstants.LEAVE_CAR_LIFE_CANVAS)").log();
                }
                this.aslhandler.handleAslApiLeaveCarLifeCanvas();
                break;
            }
            case 1076641849: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLCarLifeServiceConstants.TOUCH_EVENT)").log();
                }
                this.aslhandler.handleHmiSimpleTouchEvent(eventGeneric);
                break;
            }
            case 1076641848: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLCarLifeServiceConstants.TOUCH_EVENT_GESTURE)").log();
                }
                this.aslhandler.handleHmiTouchEventGesture(eventGeneric);
                break;
            }
            case 1076641850: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLCarLifeServiceConstants.ROTARY_EVENT)").log();
                }
                this.aslhandler.handleHmiRotaryEvent(eventGeneric);
                break;
            }
            case 6100025: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLSmartphoneIntegrationServiceIds.ASL_SMARTPHONEINTEGRATION_MFL_HK)").log();
                }
                if (!this.properties.isConnected()) break;
                this.aslhandler.handleHmiMflEvent(eventGeneric);
                break;
            }
            case 6100027: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLSmartphoneIntegrationServiceIds.ASL_SMARTPHONEINTEGRATION_TA_ACTIVE)").log();
                }
                if (!this.properties.isConnected()) break;
                this.aslhandler.handleTaActive();
                break;
            }
            case 1076641851: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(ASLCarLifeServiceConstants.RELAUNCH_APP)").log();
                }
                this.aslhandler.sendRelaunchApp();
                break;
            }
            case 1400004: {
                this.audiohandling.handleAslEntertainmentManagerServiceIdsActivateStartup(eventGeneric);
                break;
            }
            case 1400003: {
                this.audiohandling.handleAslEntertainmentManagerServiceIdsActivate();
                break;
            }
            case 0x155CC5: {
                this.audiohandling.handleAslEntertainmentManagerServiceIdsDeactivate();
                break;
            }
            case 1400006: {
                this.audiohandling.handleAslEntertainmentManagerServiceIdsCancel();
                break;
            }
            case 1400026: {
                this.audiohandling.handleAslEntertainmentManagerServiceIdsCurrentContext(eventGeneric);
                break;
            }
            case 1400013: {
                this.audiohandling.handleAslEntertainmentManagerServiceIdsActivationLost();
                break;
            }
            case 4000015: {
                this.audiohandling.handleAslSoundAudioConnectionReleased(eventGeneric);
                break;
            }
            case 4000021: {
                this.audiohandling.handleAslSoundManagerStatus(eventGeneric);
                break;
            }
            case 4000007: {
                this.audiohandling.handleAslSoundUserMuteIsActive(eventGeneric);
                break;
            }
            case 4000050: {
                this.audiohandling.handleAslBaiduCarLifeAudible(eventGeneric);
                break;
            }
            case 100001: {
                this.audiohandling.handleAslApiEV_CARLIFE_SOUND_SET_CONNECTION_ANSWER(eventGeneric);
                break;
            }
            case 100002: {
                this.audiohandling.handleAslApiEV_CARLIFE_SOUND_RELEASE_CONNECTION_ANSWER(eventGeneric);
                break;
            }
            case 100005: {
                this.audiohandling.handleAslApiEV_CARLIFE_SOUND_SET_VOLUME_LOCK_ANSWER(eventGeneric);
                break;
            }
            case 100006: {
                this.audiohandling.handleAslApiEV_CARLIFE_SOUND_RELEASE_VOLUME_LOCK_ANSWER(eventGeneric);
                break;
            }
            case 100010: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(EV_CARLIFE_AUDIO_LOWERING_TIMER) - timer expired").log();
                }
                this.audiohandling.handleConnectionTimeout(171);
                break;
            }
            case 100007: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(EV_CARLIFE_AUDIOMEDIA_TIMER) - timer expired").log();
                }
                this.audiohandling.handleConnectionTimeout(167);
                break;
            }
            case 100009: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(EV_CARLIFE_AUDIOSPEECH_TIMER) - timer expired").log();
                }
                this.audiohandling.handleConnectionTimeout(168);
                break;
            }
            case 100008: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(EV_CARLIFE_AUDIOSPEECH_INPUT_TIMER) - timer expired").log();
                }
                this.audiohandling.handleConnectionTimeout(169);
                break;
            }
            case 100011: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".handle(EV_CARLIFE_DISCONNECT_DELAY_TIMER) - timer expired - disconnecting now...").log();
                }
                this.target.triggerObserver(-1944822528, null);
                break;
            }
            case 6100101: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_CARLIFE").log();
                }
                this.aslhandler.handleConnectionEstablished();
                break;
            }
            case 6100102: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_CARLIFE").log();
                }
                this.aslhandler.handleConnectionLost();
                break;
            }
            case 6100103: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_CARLIFE").log();
                }
                this.aslhandler.handleConnectionStarted();
                break;
            }
            case 6100104: {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARLIFE.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_STOPPED_CARLIFE").log();
                }
                this.aslhandler.handleConnectionStopped();
                break;
            }
            case 6100028: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage2 = this.target.trace();
                    logMessage2.append("CARLIFE.ASLEventController").append(new StringBuffer().append(".ASL_SMARTPHONEINTEGRATION_GUI_DIMMING_TRIGGER - dimmed = ").append(bl).toString()).log();
                }
                this.properties.setSdsOpen(bl);
                this.popupHandler.checkPopupState();
                break;
            }
            case 4300038: {
                this.aslhandler.handleDayNightMode(eventGeneric);
                break;
            }
            default: {
                this.target.trace("Target Carlife - got an unhandled event!");
            }
        }
    }
}

