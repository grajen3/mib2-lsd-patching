/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.audio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.CarPlayHMIRequestParameterConfiguration;
import de.vw.mib.asl.internal.carplay.speech.SpeechApplicant;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;

public class CarPlayAudiohandling {
    private String classname = "CarPlayAudiohandling";
    private CarPlayGlobalProperies properties;
    private HsmTarget target;
    private SpeechApplicant speechapplicant;

    public CarPlayAudiohandling(HsmTarget hsmTarget, CarPlayGlobalProperies carPlayGlobalProperies, SpeechApplicant speechApplicant) {
        this.target = hsmTarget;
        this.properties = carPlayGlobalProperies;
        this.speechapplicant = speechApplicant;
    }

    public void registerEntertainmentConnection() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(".registerEntertainmentConnection()").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(-899934976);
        ((EventGeneric)object).setInt(0, 7);
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
        ((EventGeneric)object).setInt(0, 2);
        ((EventGeneric)object).setInt(1, 7);
        this.target.sendSafe((EventGeneric)object);
    }

    public void setAudioConnection(int n, boolean bl) {
        if (this.properties.getCurrentSoundStatus(n) != 3 || bl) {
            Object object;
            if (this.target.isTraceEnabled()) {
                object = this.target.trace();
                object.append(this.classname).append(".setAudioConnection()").append(", audioChannel == ").append(n).log();
            }
            this.properties.setCurrentSoundStatus(n, 2);
            object = ServiceManager.mGenericEventFactory.newEvent(34159872);
            ((EventGeneric)object).setInt(0, n);
            ((EventGeneric)object).setSenderEventId(-1551499008);
            if (n == 162) {
                ((EventGeneric)object).setBoolean(2, true);
            }
            this.target.sendSafe((EventGeneric)object);
        }
    }

    public void releaseAudioConnection(int n, boolean bl) {
        if (this.properties.getCurrentSoundStatus(n) == 3 || this.properties.getCurrentSoundStatus(n) == 2 || bl) {
            Object object;
            if (this.target.isTraceEnabled()) {
                object = this.target.trace();
                object.append(this.classname).append(".releaseAudioConnection()").append(", audioChannel == ").append(n).log();
            }
            this.properties.setCurrentSoundStatus(n, 0);
            object = ServiceManager.mGenericEventFactory.newEvent(67714304);
            ((EventGeneric)object).setInt(0, n);
            ((EventGeneric)object).setSenderEventId(-1534721792);
            this.target.sendSafe((EventGeneric)object);
        }
    }

    public synchronized void handleAudioSourceChange(int n, int n2, boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - handleAudioSourceChange - new audio type = ").append(n).toString());
        }
        if (!this.properties.isSoundManagementAvailable()) {
            if (bl) {
                this.properties.setPhoneWaitsForResponseMainAudioType(false);
                this.target.getDSICarPlay().responseUpdateMainAudioType(n);
            }
            this.takeMainAudio("Take Audio: Audio management is not available and audio request can not be handled");
            return;
        }
        if (n == 1 && this.properties.getOcuCallState() != 0) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("CARPLAY - handleAudioSourceChange - new type is ALERT and an ocu call in ongoing => disconnect carplay!");
            }
            this.target.triggerObserver(1125408000, null);
            return;
        }
        if (this.properties.isConnected() && this.properties.isActiveEntertainment() && this.properties.getCurrentSoundStatus(162) == 3 && this.properties.getCurrentMainAudioSource() == 2) {
            this.changeVolumeLock(false);
        } else {
            this.changeVolumeLock(true);
        }
        if (n != 4) {
            if (this.speechapplicant.isCarplayActive()) {
                this.speechapplicant.forceChangeState(ActivationState.INACTIVE);
            }
            this.releaseAudioConnection(152, false);
            this.releaseAudioConnection(153, false);
        }
        if (this.properties.getRingtoneConnection() == 151) {
            if (n != 3 && n != 1) {
                this.releaseAudioConnection(151, false);
            }
        } else {
            if (n != 3) {
                this.releaseAudioConnection(151, false);
            }
            if (n != 1) {
                this.releaseAudioConnection(this.properties.getRingtoneConnection(), false);
            }
        }
        if (n != 3) {
            this.releaseAudioConnection(163, false);
        }
        if (n == 0) {
            if (bl) {
                this.properties.setPhoneWaitsForResponseMainAudioType(false);
                this.target.getDSICarPlay().responseUpdateMainAudioType(0);
            }
        } else if (n == 1) {
            if (this.properties.getCurrentSoundStatus(this.properties.getRingtoneConnection()) == 0) {
                this.setAudioConnection(this.properties.getRingtoneConnection(), false);
            } else if (bl && this.properties.getCurrentSoundStatus(this.properties.getRingtoneConnection()) == 3) {
                this.properties.setPhoneWaitsForResponseMainAudioType(false);
                this.target.getDSICarPlay().responseUpdateMainAudioType(1);
            }
        } else if (n == 4) {
            if (!this.speechapplicant.isCarplayActive()) {
                this.speechapplicant.forceChangeState(ActivationState.ACTIVE);
            }
            if (this.properties.getCurrentSoundStatus(152) == 0 || this.properties.getCurrentSoundStatus(153) == 0) {
                this.setAudioConnection(152, false);
                this.setAudioConnection(153, false);
            } else if (bl && this.properties.getCurrentSoundStatus(152) == 3 && this.properties.getCurrentSoundStatus(153) == 3) {
                this.properties.setPhoneWaitsForResponseMainAudioType(false);
                this.target.getDSICarPlay().responseUpdateMainAudioType(4);
            }
        } else if (n == 3) {
            this.hangUpOcu();
            if (this.properties.getCurrentSoundStatus(151) == 0 || this.properties.getCurrentSoundStatus(163) == 0) {
                this.setAudioConnection(151, false);
                this.setAudioConnection(163, false);
            } else if (bl && this.properties.getCurrentSoundStatus(151) == 3 && this.properties.getCurrentSoundStatus(163) == 3) {
                this.properties.setPhoneWaitsForResponseMainAudioType(false);
                this.target.getDSICarPlay().responseUpdateMainAudioType(3);
            }
        } else if (n == 2) {
            LogMessage logMessage;
            if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(this.classname).append(new StringBuffer().append(".handleAudioSourceChange - TRACE: isTypeChange: ").append(bl).append(", currentMAT: ").append(this.properties.getCurrentMainAudioType()).append(", isFirst: ").append(this.properties.isAutoplayFirstMediaRequest()).toString()).log();
            }
            if (bl && this.properties.getCurrentMainAudioType() != 2 && this.properties.isAutoplayFirstMediaRequest()) {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append(this.classname).append(".handleAudioSourceChange - detected a change to media - starting timer").log();
                }
                this.properties.setAutoplayFirstMediaRequest(false);
                this.target.startTimer(-1450835712, (long)0, false);
            }
            if (this.properties.getCurrentSoundStatus(162) == 0) {
                this.properties.setCurrentSoundStatus(162, 1);
                this.requestEntertainmentConnection();
            } else if (bl && this.properties.getCurrentSoundStatus(162) == 3) {
                this.properties.setPhoneWaitsForResponseMainAudioType(false);
                this.target.getDSICarPlay().responseUpdateMainAudioType(2);
            }
            if (this.properties.getCurrentMuteState() && this.properties.getCurrentSoundStatus(162) == 3) {
                this.releaseUserMute();
            }
        }
    }

    public boolean isOwnAudioConnection(int n) {
        return this.properties.transformConnectionToInternNumber(n) != -1;
    }

    public void releaseAllConnections(boolean bl, boolean bl2) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append(".releaseAllConnections - releaseEntertainment: ").append(bl).append(", releaseAnnouncement: ").append(bl2).toString()).log();
        }
        this.releaseAudioConnection(151, false);
        this.releaseAudioConnection(163, false);
        if (this.properties.getRingtoneConnection() != 151) {
            this.releaseAudioConnection(this.properties.getRingtoneConnection(), false);
        }
        this.releaseAudioConnection(152, false);
        this.releaseAudioConnection(153, false);
        if (bl2) {
            this.releaseAudioConnection(154, false);
            this.releaseAudioConnection(155, false);
        }
        if (bl && this.properties.getCurrentSoundStatus(162) != 0) {
            this.releaseAudioConnection(162, true);
        }
    }

    public void takeMainAudio(String string) {
        if (!this.properties.isConnected()) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(".takeMainAudio - ignore request to take audio because we are not connected").log();
            }
            return;
        }
        if (this.properties.isPhoneWaitsForResponseMainAudioType()) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("CARPLAY - there is a pending mainAudioType change we have to answer...");
            }
            this.properties.setPhoneWaitsForResponseMainAudioType(false);
            this.target.getDSICarPlay().responseUpdateMainAudioType(0);
        }
        if (this.properties.getCurrentMainAudioSource() != 2) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(".takeMainAudio - ignore request to take audio because device dont have audio").log();
            }
            return;
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace("CARPLAY - send TAKE AUDIO request...");
        }
        CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration = this.properties.getParamconfig();
        super.getClass();
        ResourceRequest[] resourceRequestArray = carPlayHMIRequestParameterConfiguration.getRessourceRequest(2);
        CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration2 = this.properties.getParamconfig();
        super.getClass();
        AppStateRequest[] appStateRequestArray = carPlayHMIRequestParameterConfiguration2.getAppStateRequest(0);
        this.target.getDSICarPlay().requestModeChange(resourceRequestArray, appStateRequestArray, string.equals("") ? "User initiated" : string);
        this.properties.setAudioBorrowState(false);
        this.properties.setDelayBorrowAudio(false);
        this.target.stopTimer(-1450835712);
    }

    public void borrowMainAudio(String string) {
        if (!this.properties.isConnected()) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(".borrowMainAudio - ignore request to borrow audio because we are not connected").log();
            }
            return;
        }
        if (this.properties.isPhoneWaitsForResponseMainAudioType()) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("CARPLAY - there is a pending mainAudioType change we have to answer...");
            }
            this.properties.setPhoneWaitsForResponseMainAudioType(false);
            this.target.getDSICarPlay().responseUpdateMainAudioType(0);
        }
        if (this.properties.getCurrentMainAudioSource() != 2) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(".borrowMainAudio - ignore request to borrow audio because device dont have audio").log();
            }
            return;
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace("CARPLAY - send BORROW AUDIO request...");
        }
        CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration = this.properties.getParamconfig();
        super.getClass();
        ResourceRequest[] resourceRequestArray = carPlayHMIRequestParameterConfiguration.getRessourceRequest(4);
        CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration2 = this.properties.getParamconfig();
        super.getClass();
        AppStateRequest[] appStateRequestArray = carPlayHMIRequestParameterConfiguration2.getAppStateRequest(0);
        this.target.getDSICarPlay().requestModeChange(resourceRequestArray, appStateRequestArray, string.equals("") ? "User initiated" : string);
        this.properties.setAudioBorrowState(true);
    }

    public void unborrowMainAudio(String string) {
        if (!this.properties.isConnected()) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(".unborrowMainAudio - ignore request to unborrow audio because we are not connected").log();
            }
            return;
        }
        if (this.properties.getCurrentMainAudioSource() == 2) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append(this.classname).append(".takeMainAudio - ignore request to unborrow audio because device already has audio").log();
            }
            return;
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace("CARPLAY - send UNBORROW AUDIO request...");
        }
        CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration = this.properties.getParamconfig();
        super.getClass();
        ResourceRequest[] resourceRequestArray = carPlayHMIRequestParameterConfiguration.getRessourceRequest(5);
        CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration2 = this.properties.getParamconfig();
        super.getClass();
        AppStateRequest[] appStateRequestArray = carPlayHMIRequestParameterConfiguration2.getAppStateRequest(0);
        this.target.getDSICarPlay().requestModeChange(resourceRequestArray, appStateRequestArray, string.equals("") ? "User initiated" : string);
        this.properties.setAudioBorrowState(false);
    }

    public void changeVolumeLock(boolean bl) {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(new StringBuffer().append(".changeVolumeLock - setting volume lock = ").append(bl ? "active" : "inactive").toString()).log();
        }
        if (bl == this.properties.isVolumeLock() && this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(new StringBuffer().append(".changeVolumeLock - info: volume lock is already ").append(bl ? "active" : "inactive").append(" but setting it anyway").toString()).log();
        }
        if (bl) {
            object = ServiceManager.mGenericEventFactory.newEvent(185154816);
            ((EventGeneric)object).setInt(0, 162);
            ((EventGeneric)object).setSenderEventId(-1484390144);
            this.target.sendSafe((EventGeneric)object);
        } else {
            object = ServiceManager.mGenericEventFactory.newEvent(201932032);
            ((EventGeneric)object).setInt(0, 162);
            ((EventGeneric)object).setSenderEventId(-1467612928);
            this.target.sendSafe((EventGeneric)object);
        }
    }

    public void releaseUserMute() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append(".releaseUserMute").log();
        }
        object = ServiceManager.mGenericEventFactory.newEvent(789134592);
        this.target.sendSafe((EventGeneric)object);
    }

    public boolean checkAudioSourceState(int n) {
        return this.properties.getCurrentSoundStatus(n) == 3;
    }

    public void hangUpOcu() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("CARPLAY - send HANG_UP to OCU...");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1050929856);
        this.target.sendSafe(eventGeneric);
    }

    public void checkAudibleStatus(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("CARPLAY - checkAudibleStatus - mediaAudible = ").append(bl).toString());
        }
        if (!bl && this.properties.getCurrentMainAudioSource() == 2) {
            if (this.properties.getCurrentSoundStatus(151) == 0 && this.properties.getCurrentSoundStatus(163) == 0 && this.properties.getCurrentSoundStatus(152) == 0 && this.properties.getCurrentSoundStatus(153) == 0 && this.properties.getCurrentSoundStatus(this.properties.getRingtoneConnection()) == 0) {
                if (this.properties.getLastPTTKey() == 1) {
                    this.properties.setDelayBorrowAudio(true);
                } else {
                    this.borrowMainAudio("Borrow audio: Audio is not audible but overlain by another audio source");
                }
            }
        } else if (bl && this.properties.getCurrentMainAudioSource() != 2 && this.properties.isAudioBorrowState()) {
            this.unborrowMainAudio("Unborrow Audio: Audio is audible again and borrow state can be ended");
        }
    }
}

