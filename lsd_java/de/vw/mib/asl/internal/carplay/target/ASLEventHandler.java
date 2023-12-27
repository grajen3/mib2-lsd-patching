/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carplay.audio.CarPlayAudiohandling;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.PopupHandler;
import de.vw.mib.asl.internal.carplay.target.ASLHandler;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public class ASLEventHandler {
    private final String classname;
    private final HsmTarget target;
    private final ASLHandler aslhandler;
    private final CarPlayAudiohandling audiohandling;
    private final CarPlayGlobalProperies properties;
    private PopupHandler popupHandler;

    public ASLEventHandler(HsmTarget hsmTarget, ASLHandler aSLHandler, CarPlayAudiohandling carPlayAudiohandling, CarPlayGlobalProperies carPlayGlobalProperies) {
        this.classname = "CARPLAY.ASLEventController";
        this.target = hsmTarget;
        this.aslhandler = aSLHandler;
        this.audiohandling = carPlayAudiohandling;
        this.properties = carPlayGlobalProperies;
    }

    public void setPopupHandler(PopupHandler popupHandler) {
        this.popupHandler = popupHandler;
    }

    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".gotEvent(POWER_ON)").log();
                }
                this.target.startup();
                break;
            }
            case 4300062: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".handle(RELOAD_PERSISTABLES)").log();
                break;
            }
            case 3000009: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLMediaServiceIds.ASL_MEDIA_CURRENT_USB_NAME)").log();
                break;
            }
            case 1076641831: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.ENTER_CAR_PLAY_CANVAS_WITH_UI)").log();
                }
                this.aslhandler.handleAslApiEnterCarPlayCanvas(eventGeneric);
                break;
            }
            case 1076641829: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.ENTER_CAR_PLAY_CONTEXT)  ==> this event will be ignored!").log();
                break;
            }
            case 1076641830: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.LEAVE_CAR_PLAY_CONTEXT)").log();
                }
                this.aslhandler.handleAslApiLeaveCarPlayCanvas();
                break;
            }
            case 1076641833: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.LEAVE_CAR_PLAY_CANVAS)  ==> this event will be ignored!").log();
                break;
            }
            case 1076641834: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.SIMPLE_TOUCH_EVENT)").log();
                }
                this.aslhandler.handleHmiSimpleTouchEvent(eventGeneric);
                break;
            }
            case 1076641835: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.ROTARY_EVENT)").log();
                }
                this.aslhandler.handleHmiRotaryEvent(eventGeneric);
                break;
            }
            case 6100025: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLSmartphoneIntegrationServiceIds.ASL_SMARTPHONEINTEGRATION_MFL_HK)").log();
                }
                if (!this.properties.isConnected()) break;
                this.aslhandler.handleHmiMflEvent(eventGeneric);
                break;
            }
            case 6100027: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLSmartphoneIntegrationServiceIds.ASL_SMARTPHONEINTEGRATION_TA_ACTIVE)").log();
                }
                if (!this.properties.isConnected()) break;
                this.aslhandler.handleTaActive();
                break;
            }
            case 1076641832: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLCarPlayServiceConstants.CANVAS_VIEW_IS_DIMED) - DONT REACT ANYMORE").log();
                break;
            }
            case 100015: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("CARPLAY.ASLEventController").append(".handle( EV_CARPLAY_POPUP_DELAY_TIMER )").log();
                }
                this.popupHandler.popupTimerElapsed();
                break;
            }
            case 1400004: {
                int n;
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATE_STARTUP)").log();
                }
                if ((n = eventGeneric.getInt(0)) != 7) break;
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATE_STARTUP) - lastcontext was carplay: ").append(n).toString()).log();
                }
                this.properties.setActiveEntertainment(true);
                this.properties.setCurrentSoundStatus(162, 2);
                this.audiohandling.setAudioConnection(162, false);
                break;
            }
            case 1400003: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATE)").log();
                }
                this.properties.setActiveEntertainment(true);
                if (this.properties.getCurrentSoundStatus(162) != 1) break;
                this.properties.setCurrentSoundStatus(162, 2);
                this.audiohandling.setAudioConnection(162, false);
                break;
            }
            case 0x155CC5: {
                Object object;
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append("CARPLAY.ASLEventController").append(".handle(ASLEntertainmentmanagerServiceIds.DEACTIVATE)").log();
                }
                this.properties.setActiveEntertainment(false);
                this.audiohandling.releaseAudioConnection(162, false);
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append("CARPLAY.ASLEventController").append(".").append(".handle(ASLEntertainmentmanagerServiceIds.DEACTIVATE) - send DEACTIVATED").log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(-1050929920);
                this.target.sendSafe((EventGeneric)object);
                this.target.triggerObserver(940858624, null);
                break;
            }
            case 1400006: {
                Object object;
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append("CARPLAY.ASLEventController").append(".handle(ASLEntertainmentmanagerServiceIds.CANCEL)").log();
                }
                this.properties.setActiveEntertainment(false);
                this.audiohandling.releaseAudioConnection(162, false);
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append("CARPLAY.ASLEventController").append(".").append(".handle(ASLEntertainmentmanagerServiceIds.CANCEL) - send CANCELED").log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
                this.target.sendSafe((EventGeneric)object);
                this.target.triggerObserver(940858624, null);
                break;
            }
            case 1400026: {
                int n;
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLEntertainmentmanagerServiceIds.CURRENT_CONTEXT)").log();
                }
                if ((n = eventGeneric.getInt(0)) == 7) break;
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(" - save last entertainment context for autoplay: ").append(n).toString()).log();
                }
                this.properties.setLastEntertainmentContextForAutoplay(n);
                break;
            }
            case 1400013: {
                LogMessage logMessage;
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATION_LOST)").log();
                }
                if (!this.properties.isConnected() || this.properties.getCurrentSoundStatus(162) != 1) break;
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(" - our entertainment request is lost => Reset status to not requested and wait for next request from iphone").log();
                }
                this.properties.setCurrentSoundStatus(162, 0);
                break;
            }
            case 4000015: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASL_SOUND_AUDIO_CONNECTION_RELEASED)").append(" AudioSource=").append(eventGeneric.getInt(0)).log();
                }
                int n = eventGeneric.getInt(0);
                if (eventGeneric.getResult() == 0 && this.audiohandling.isOwnAudioConnection(n)) {
                    this.aslhandler.handleAslApiEV_CARPLAY_SOUND_RELEASE_CONNECTION_ANSWER(n);
                    break;
                }
                if (eventGeneric.getResult() != 0 || n != 112) break;
                this.aslhandler.checkDelayedBorrowState(n);
                break;
            }
            case 100003: {
                int n;
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_SOUND_SET_CONNECTION_ANSWER)").append(" AudioSource=").append(new StringBuffer().append(eventGeneric.getInt(0)).append(", resultOK=").append(eventGeneric.getResult() == 0).toString()).log();
                }
                if (!this.audiohandling.isOwnAudioConnection(n = eventGeneric.getInt(0))) break;
                this.aslhandler.handleAslApiEV_CARPLAY_SOUND_SET_CONNECTION_ANSWER(n, eventGeneric.getResult());
                break;
            }
            case 100004: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_SOUND_RELEASE_CONNECTION_ANSWER)").append(" AudioSource=").append(eventGeneric.getInt(0)).log();
                }
                int n = eventGeneric.getInt(0);
                if (eventGeneric.getResult() == 0 && this.audiohandling.isOwnAudioConnection(n)) {
                    this.aslhandler.handleAslApiEV_CARPLAY_SOUND_RELEASE_CONNECTION_ANSWER(n);
                    break;
                }
                if (eventGeneric.getResult() != 0 || n != 112) break;
                this.aslhandler.checkDelayedBorrowState(n);
                break;
            }
            case 4000007: {
                boolean bl = eventGeneric.getBoolean(1);
                boolean bl2 = eventGeneric.getBoolean(0);
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASL_SOUND_USERMUTE_IS_ACTIVE)").append(" muteActive=").append(bl).append(", muteStarted=").append(bl2).log();
                }
                this.properties.setCurrentMuteState(bl);
                break;
            }
            case 4000044: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(ASL_CARPLAY_AUDIBLE)").append(" mediaAudible=").append(bl).log();
                }
                if (bl != this.properties.getCurrentAudibleState() && this.properties.isConnected() && this.properties.getCurrentSoundStatus(162) == 3) {
                    this.audiohandling.checkAudibleStatus(bl);
                }
                this.properties.setCurrentAudibleState(bl);
                break;
            }
            case 4000021: {
                this.aslhandler.handleSoundManagerStatus(eventGeneric);
                break;
            }
            case 100007: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(".handle(EV_CARPLAY_SOUND_SET_VOLUME_LOCK_ANSWER) - Result: ").append(eventGeneric.getResult()).toString()).log();
                }
                if (eventGeneric.getResult() != 0) break;
                this.properties.setVolumeLock(true);
                break;
            }
            case 100008: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(".handle(EV_CARPLAY_SOUND_RELEASE_VOLUME_LOCK_ANSWER) - Result: ").append(eventGeneric.getResult()).toString()).log();
                }
                if (eventGeneric.getResult() != 0) break;
                this.properties.setVolumeLock(false);
                break;
            }
            case 100009: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_AUTOPLAY_TIMER) - timer expired without a change to mainunit => No autoplay").log();
                break;
            }
            case 100010: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_WATCHDOG_TIMER) - timer expired - check the sync now...").log();
                }
                this.aslhandler.checkForSync();
                break;
            }
            case 100011: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_TEARDOWN_TIMER) - timer expired - execute teardown now...").log();
                }
                this.aslhandler.executeTeardown();
                break;
            }
            case 100012: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_EDGE_DELAY_TIMER) - timer expired - execute edge now...").log();
                }
                this.aslhandler.executeEdgeDelay();
                break;
            }
            case 100013: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".handle(EV_CARPLAY_DISCONNECT_DELAY_TIMER) - timer expired - disconnecting now...").log();
                }
                this.target.triggerObserver(1125408000, null);
                break;
            }
            case 6100001: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_CARPLAY").log();
                }
                this.aslhandler.handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_CARPLAY();
                break;
            }
            case 6100002: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_CARPLAY").log();
                }
                this.aslhandler.handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_CARPLAY();
                break;
            }
            case 6100014: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_CARPLAY").log();
                break;
            }
            case 6100015: {
                if (!this.target.isTraceEnabled()) break;
                LogMessage logMessage = this.target.trace();
                logMessage.append("CARPLAY.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_CONNECTION_STOPPED_CARPLAY").log();
                break;
            }
            case 6100028: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(".ASL_SMARTPHONEINTEGRATION_GUI_DIMMING_TRIGGER - dimmed = ").append(bl).toString()).log();
                }
                this.properties.setSdsOpen(bl);
                this.popupHandler.checkPopupState();
                break;
            }
            case 6100034: {
                int n = eventGeneric.getInt(0);
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(".ASL_SMARTPHONEINTEGRATION_OCU_CALLSTATE - ocu_callstate = ").append(n).toString()).log();
                }
                this.aslhandler.handleAslApiOcuCallState(n);
                break;
            }
            case 6100036: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".ASL_SMARTPHONEINTEGRATION_PREPARE_OCU_TRIGGERED_DISCONNECT_CARPLAY - end all iphone calls and give feedback to SMI").log();
                }
                int n = this.properties.getCurrentCallStates().size();
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(new StringBuffer().append(".ASL_SMARTPHONEINTEGRATION_PREPARE_OCU_TRIGGERED_DISCONNECT_CARPLAY - calls to be disconnected: ").append(n).toString()).log();
                }
                for (int i2 = 1; i2 <= n; ++i2) {
                    if (null == this.target.getDSICarPlay()) continue;
                    this.target.getDSICarPlay().postButtonEvent(14, 0);
                    this.target.getDSICarPlay().postButtonEvent(14, 1);
                }
                this.target.startTimer(-1383726848, (long)0, false);
                break;
            }
            case 4300038: {
                this.aslhandler.handleDayNightMode(eventGeneric);
                break;
            }
            case 6000003: {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("CARPLAY.ASLEventController").append(".ASL_CARPLAY_HANGUP_ALL_CALLS").log();
                }
                if (null == this.target.getDSICarPlay()) break;
                this.target.getDSICarPlay().postButtonEvent(14, 0);
                this.target.getDSICarPlay().postButtonEvent(14, 1);
                break;
            }
            default: {
                this.target.trace("Target Carplay - got an unhandled event!");
            }
        }
    }
}

