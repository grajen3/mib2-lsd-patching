/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.audio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeHandling;
import de.vw.mib.asl.internal.carlife.common.TimerHandler;
import de.vw.mib.asl.internal.carlife.speech.SpeechApplicant;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public class CarLifeAudiohandling {
    private String classname = "CarLifeAudiohandling";
    private int[] currentSoundStatus = new int[]{0, 0, 0, 0, 0};
    public static final int CARLIFE_AUDIO_ANSWER_TIMEOUT;
    public static final int CARLIFE_AUDIO_MEDIA_ANSWER_TIMEOUT;
    private boolean currentMuteState = false;
    private boolean isSoundManagementAvailable = false;
    private boolean isActiveEntertainment = false;
    private boolean hasPauseButtonSend = false;
    private CarLifeGlobalProperties properties;
    private CarlifeHSMTarget target;
    private SpeechApplicant speechapplicant;
    private CarLifeModeHandling modeHandling;
    private final TimerHandler timerHandler;

    public CarLifeAudiohandling(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties, SpeechApplicant speechApplicant) {
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
        this.speechapplicant = speechApplicant;
        this.timerHandler = new TimerHandler(carlifeHSMTarget);
    }

    public void setModeHandling(CarLifeModeHandling carLifeModeHandling) {
        this.modeHandling = carLifeModeHandling;
    }

    public void handleAslEntertainmentManagerServiceIdsActivate() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsActivate()").log();
        }
        this.setActiveEntertainment(true);
        if (this.getCurrentSoundStatus(167) == 1) {
            this.setCurrentSoundStatus(167, 2);
            this.setAudioConnection(167, false);
        }
    }

    public void handleAslEntertainmentManagerServiceIdsActivateStartup(EventGeneric eventGeneric) {
        int n;
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsActivateStartup()").log();
        }
        if ((n = eventGeneric.getInt(0)) == 10) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(new StringBuffer().append("::handleAslEntertainmentManagerServiceIdsActivateStartup() - lastcontext was carlife: ").append(n).toString()).log();
            }
            this.setActiveEntertainment(true);
            this.setCurrentSoundStatus(167, 2);
            this.setAudioConnection(167, false);
        }
    }

    public void handleAslEntertainmentManagerServiceIdsCurrentContext(EventGeneric eventGeneric) {
        int n;
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsCurrentContext()").log();
        }
        if ((n = eventGeneric.getInt(0)) != 10) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(new StringBuffer().append(" - save last entertainment context for autoplay: ").append(n).toString()).log();
            }
            this.properties.setLastEntertainmentContextForAutoplay(n);
        }
    }

    public void handleAslEntertainmentManagerServiceIdsDeactivate() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsDeactivate()").log();
        }
        this.setActiveEntertainment(false);
        this.releaseAudioConnection(167, false);
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsDeactivate() - send DEACTIVATED").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(-1050929920);
        this.target.sendSafe((EventGeneric)object);
        this.target.triggerObserver(940858624, null);
    }

    public void handleAslEntertainmentManagerServiceIdsCancel() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsCancel()").log();
        }
        this.setActiveEntertainment(false);
        this.releaseAudioConnection(167, false);
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsCancel() - send CANCELED").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
        this.target.sendSafe((EventGeneric)object);
        this.target.triggerObserver(940858624, null);
    }

    public void handleAslEntertainmentManagerServiceIdsActivationLost() {
        LogMessage logMessage;
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslEntertainmentManagerServiceIdsActivationLost()").log();
        }
        if (this.properties.isConnected() && this.getCurrentSoundStatus(167) == 1) {
            if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(" - our entertainment request is lost => Reset status to not requested and wait for next request from phone").log();
            }
            this.setCurrentSoundStatus(167, 0);
        }
    }

    public void handleAslSoundAudioConnectionReleased(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslSoundAudioConnectionReleased(").append(" AudioSource=").append(n).append(" )").log();
        }
        if (eventGeneric.getResult() == 0 && this.isOwnAudioConnection(n)) {
            this.handleAnswerReleaseSoundConnection(n);
        }
    }

    public void handleAslSoundManagerStatus(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 0) {
            LogMessage logMessage;
            if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(this.classname).append("::handleAslSoundManagerStatus(").append(" ASL_SOUND_AUDIOMNGMNT_UNAVAILABLE").append(" )").log();
            }
            this.setSoundManagementAvailable(false);
            if (this.properties.isConnected()) {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append(this.classname).append("::handleAslSoundManagerStatus()").append(" release all connections but leave EntertainmentManager alone").log();
                }
                this.releaseAllConnections(false, true);
                this.setCurrentSoundStatus(167, 0);
            }
        } else if (n == 1) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append("::handleAslSoundManagerStatus(").append(" ASL_SOUND_AUDIOMNGMNT_AVAILABLE").append(" )").log();
            }
            this.setSoundManagementAvailable(true);
        } else if (n == 2) {
            LogMessage logMessage;
            if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(this.classname).append("::handleAslSoundManagerStatus(").append(" ASL_SOUND_AUDIOMNGMNT_AVAILABLE_RESTORE_CONNECTIONS").append(" )").log();
            }
            this.setSoundManagementAvailable(true);
            if (this.properties.isConnected()) {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append(this.classname).append("::handleAslSoundManagerStatus()").append(" - reconnect announcement").log();
                }
                this.setAudioConnection(170, false);
            }
        }
    }

    public void handleAslSoundUserMuteIsActive(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(1);
        boolean bl2 = eventGeneric.getBoolean(0);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslSoundUserMuteIsActive(").append(" muteActive=").append(bl).append(", muteStarted=").append(bl2).append(" )").log();
        }
        this.setCurrentMuteState(bl);
    }

    public void handleAslBaiduCarLifeAudible(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslBaiduCarLifeAudible(").append(" audible=").append(bl).append(" )").log();
        }
        if (this.properties.isConnected() && this.properties.isDSIRegistered() && this.properties.getCurrentAudioMediaOwner() == 2) {
            if (bl) {
                if (this.hasPauseButtonSend) {
                    this.target.getDSICarLife().postButtonEvent(18, 0);
                    this.target.getDSICarLife().postButtonEvent(18, 1);
                    this.hasPauseButtonSend = false;
                }
            } else {
                this.target.getDSICarLife().postButtonEvent(19, 0);
                this.target.getDSICarLife().postButtonEvent(19, 1);
                this.hasPauseButtonSend = true;
            }
        }
    }

    public void handleAslApiEV_CARLIFE_SOUND_SET_CONNECTION_ANSWER(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getResult();
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslApiEV_CARLIFE_SOUND_SET_CONNECTION_ANSWER(").append(" AudioSource=").append(new StringBuffer().append(n).append(", resultOK=").append(n2 == 0).toString()).append(" )").log();
        }
        if (this.isOwnAudioConnection(n)) {
            this.handleAnswerSetSoundConnection(n, n2);
        }
    }

    public void handleAslApiEV_CARLIFE_SOUND_RELEASE_CONNECTION_ANSWER(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getResult();
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslApiEV_CARLIFE_SOUND_RELEASE_CONNECTION_ANSWER(").append(" AudioSource=").append(n).append(" )").log();
        }
        if (n2 == 0 && this.isOwnAudioConnection(n)) {
            this.handleAnswerReleaseSoundConnection(n);
        }
    }

    public void handleAslApiEV_CARLIFE_SOUND_SET_VOLUME_LOCK_ANSWER(EventGeneric eventGeneric) {
        int n = eventGeneric.getResult();
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslApiEV_CARLIFE_SOUND_SET_VOLUME_LOCK_ANSWER( Result= ").append(n).append(" )").log();
        }
        if (n == 0) {
            this.properties.setVolumeLock(true);
        }
    }

    public void handleAslApiEV_CARLIFE_SOUND_RELEASE_VOLUME_LOCK_ANSWER(EventGeneric eventGeneric) {
        int n = eventGeneric.getResult();
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAslApiEV_CARLIFE_SOUND_RELEASE_VOLUME_LOCK_ANSWER( Result= ").append(n).append(" )").log();
        }
        if (n == 0) {
            this.properties.setVolumeLock(false);
        }
    }

    public void handleAnswerSetSoundConnection(int n, int n2) {
        Object object;
        int n3 = this.getCurrentSoundStatus(n);
        int n4 = -1;
        int n5 = -1;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::").append(new StringBuffer().append("handleAnswerSetSoundConnection( ").append(n).append(" )").toString()).log();
        }
        this.timerHandler.stopTimer(n);
        if (n2 == 0 && n3 == 0) {
            if (this.target.isTraceEnabled()) {
                object = this.target.trace();
                object.append(" - WARNING! Got an answer out of order from audio management - got a result_ok for not requested connection ").log();
            }
            return;
        }
        if (n == 169) {
            n5 = 168;
        }
        if (n5 != -1) {
            n4 = this.getCurrentSoundStatus(n5);
        }
        if (n2 == 0) {
            this.setCurrentSoundStatus(n, 3);
            if (n4 != -1) {
                if (n4 == 3) {
                    if (n3 != 3 && this.target.isTraceEnabled()) {
                        object = this.target.trace();
                        object.append(this.classname).append("::").append("handleAnswerSetSoundConnection - result ok, is pair, pair status = ready, own was not ready (pair: ").append(n).append(" and ").append(n5).append(") => response").log();
                    }
                    this.modeHandling.processSetAudioConnection(n5, true);
                } else if (n4 != 2 && n4 == 0) {
                    this.setAudioConnection(168, false);
                }
            } else if (n != 170 && n != 171 && n3 != 3) {
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append(this.classname).append("::").append("handleAnswerSetSoundConnection - result ok, no pair, own was not ready (channel: ").append(n).append(") => response").log();
                }
                if (this.properties.isConnected()) {
                    // empty if block
                }
            }
        } else {
            this.setCurrentSoundStatus(n, 0);
            if (n4 != -1) {
                if (n4 != 0 && (n4 == 2 || n4 == 3)) {
                    if (this.target.isTraceEnabled()) {
                        object = this.target.trace();
                        object.append(this.classname).append("::").append("handleAnswerSetSoundConnection - result Nok, is pair, pair status = ready|pending (pair: ").append(n).append(" and ").append(n5).append(") => response & take audio").log();
                    }
                    this.releaseAudioConnection(n5, false);
                }
            } else if (n != 170 && n != 171 && this.target.isTraceEnabled()) {
                object = this.target.trace();
                object.append(this.classname).append("::").append("handleAnswerSetSoundConnection - result Nok, no pair (channel: ").append(n).append(") => response & take audio").log();
            }
        }
        if (n == 167 && n2 == 0) {
            if (!this.isActiveEntertainment()) {
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append(this.classname).append("::").append("handleAnswerSetSoundConnection - got the media connection but we are not active entertainment => release connection!").log();
                }
                this.releaseAudioConnection(167, true);
            } else {
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append(this.classname).append("::").append("handleAnswerSetSoundConnection - send ACTIVATED").log();
                }
                object = ServiceManager.mGenericEventFactory.newEvent(-1067707136);
                this.target.sendSafe((EventGeneric)object);
                this.target.triggerObserver(924081408, null);
                if (this.properties.isConnected() && this.properties.getCurrentAudioMediaOwner() == 2) {
                    this.changeVolumeLock(false);
                    if (this.getCurrentMuteState()) {
                        this.releaseUserMute();
                    }
                } else {
                    this.changeVolumeLock(true);
                }
            }
        }
        this.modeHandling.processSetAudioConnection(n, n2 == 0);
    }

    public void handleAnswerReleaseSoundConnection(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAnswerReleaseSoundConnection( connection ").append(n).append(" )").log();
        }
        if (this.getCurrentSoundStatus(n) != 2 && this.getCurrentSoundStatus(n) != 1) {
            this.setCurrentSoundStatus(n, 0);
        }
        if (n == 169 && this.speechapplicant.isCarLifeActive()) {
            this.speechapplicant.forceChangeState(ActivationState.INACTIVE);
        }
    }

    public void registerEntertainmentConnection() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::registerEntertainmentConnection()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(-899934976);
        ((EventGeneric)object).setInt(0, 10);
        ((EventGeneric)object).setInt(3, 1369316096);
        this.target.sendSafe((EventGeneric)object);
    }

    public void requestEntertainmentConnection() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(".requestEntertainmentConnection()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(-916712192);
        ((EventGeneric)object).setInt(0, 16);
        ((EventGeneric)object).setInt(1, 10);
        this.target.sendSafe((EventGeneric)object);
    }

    public void setAudioConnection(int n, boolean bl) {
        if (this.getCurrentSoundStatus(n) != 3 || bl) {
            Object object;
            if (this.target.isTraceEnabled()) {
                object = this.target.trace();
                object.append(this.classname).append("::setAudioConnection(").append("audioChannel = ").append(n).append("  )").log();
            }
            this.setCurrentSoundStatus(n, 2);
            object = ServiceManager.mGenericEventFactory.newEvent(34159872);
            ((EventGeneric)object).setInt(0, n);
            ((EventGeneric)object).setSenderEventId(-1585053440);
            if (n == 167) {
                ((EventGeneric)object).setBoolean(2, true);
            }
            this.target.sendSafe((EventGeneric)object);
            this.timerHandler.startTimer(n, n == 167 ? 0 : 0);
        }
    }

    public void releaseAudioConnection(int n, boolean bl) {
        if (this.getCurrentSoundStatus(n) == 3 || this.getCurrentSoundStatus(n) == 2 || bl) {
            Object object;
            if (this.target.isTraceEnabled()) {
                object = this.target.trace();
                object.append(this.classname).append("::releaseAudioConnection(").append("audioChannel = ").append(n).append("  )").log();
            }
            this.setCurrentSoundStatus(n, 0);
            object = ServiceManager.mGenericEventFactory.newEvent(67714304);
            ((EventGeneric)object).setInt(0, n);
            ((EventGeneric)object).setSenderEventId(-1568276224);
            this.target.sendSafe((EventGeneric)object);
        }
        switch (n) {
            case 167: {
                this.modeHandling.requestAudioMedia(1);
                break;
            }
            case 171: {
                this.modeHandling.requestAudioTTS(1);
                break;
            }
            case 168: 
            case 169: {
                this.modeHandling.requestAudioMicrophone(1);
                break;
            }
        }
    }

    public void performRequestAudioMediaToDevice() {
        if (this.getCurrentSoundStatus(167) == 0) {
            this.setCurrentSoundStatus(167, 1);
            this.requestEntertainmentConnection();
        }
    }

    public void performRequestAudioMicrophoneToDevice() {
        this.setAudioConnection(169, false);
    }

    public void performRequestAudioTTSToDevice() {
        this.setAudioConnection(171, false);
    }

    public boolean isOwnAudioConnection(int n) {
        return this.transformConnectionToInternNumber(n) != -1;
    }

    public void releaseAllConnections(boolean bl, boolean bl2) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::releaseAllConnections( releaseEntertainment= ").append(bl).append(", releaseAnnouncement= ").append(bl2).append(" )").toString()).log();
        }
        this.releaseAudioConnection(169, false);
        this.releaseAudioConnection(168, false);
        this.releaseAudioConnection(171, false);
        if (bl2) {
            this.releaseAudioConnection(170, false);
        }
    }

    public void changeVolumeLock(boolean bl) {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(new StringBuffer().append("::changeVolumeLock - setting volume lock = ").append(bl ? "active" : "inactive").toString()).log();
        }
        if (bl == this.properties.isVolumeLock() && this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(new StringBuffer().append("::changeVolumeLock - info: volume lock is already ").append(bl ? "active" : "inactive").append(" but setting it anyway").toString()).log();
        }
        if (bl) {
            object = ServiceManager.mGenericEventFactory.newEvent(185154816);
            ((EventGeneric)object).setInt(0, 167);
            ((EventGeneric)object).setSenderEventId(-1517944576);
            this.target.sendSafe((EventGeneric)object);
        } else {
            object = ServiceManager.mGenericEventFactory.newEvent(201932032);
            ((EventGeneric)object).setInt(0, 167);
            ((EventGeneric)object).setSenderEventId(-1501167360);
            this.target.sendSafe((EventGeneric)object);
        }
    }

    public void releaseUserMute() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::releaseUserMute").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(789134592);
        this.target.sendSafe((EventGeneric)object);
    }

    public int getCurrentSoundStatus(int n) {
        int n2 = this.transformConnectionToInternNumber(n);
        if (n2 >= 0 && n2 < this.currentSoundStatus.length) {
            return this.currentSoundStatus[n2];
        }
        return 0;
    }

    public void setCurrentSoundStatus(int n, int n2) {
        int n3;
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::setCurrentSoundStatus( audioConnection=").append(n).append(", newStatus=").append(n2).append("  )").log();
        }
        if ((n3 = this.transformConnectionToInternNumber(n)) >= 0 && n3 < this.currentSoundStatus.length) {
            this.currentSoundStatus[n3] = n2;
        }
    }

    public int transformConnectionToInternNumber(int n) {
        switch (n) {
            case 167: {
                return 0;
            }
            case 170: {
                return 1;
            }
            case 168: {
                return 2;
            }
            case 169: {
                return 3;
            }
            case 171: {
                return 4;
            }
        }
        return -1;
    }

    public boolean getCurrentMuteState() {
        return this.currentMuteState;
    }

    public void setCurrentMuteState(boolean bl) {
        this.currentMuteState = bl;
    }

    public boolean isSoundManagementAvailable() {
        return this.isSoundManagementAvailable;
    }

    public void setSoundManagementAvailable(boolean bl) {
        this.isSoundManagementAvailable = bl;
    }

    public boolean isActiveEntertainment() {
        return this.isActiveEntertainment;
    }

    public void setActiveEntertainment(boolean bl) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::setActiveEntertainment( isActiveEntertainment=").append(bl).append("  )").log();
        }
        this.isActiveEntertainment = bl;
    }

    public void resetPauseButtonSend() {
        this.hasPauseButtonSend = false;
    }

    public void handleConnectionTimeout(int n) {
        this.releaseAudioConnection(n, true);
        this.setCurrentSoundStatus(n, 0);
        this.modeHandling.processSetAudioConnection(n, false);
    }

    public void handleConnectionLost() {
        this.timerHandler.stopAll();
        this.releaseAllConnections(true, true);
        if (this.isActiveEntertainment() && this.getCurrentSoundStatus(167) == 3) {
            this.changeVolumeLock(true);
        }
        this.resetPauseButtonSend();
    }
}

