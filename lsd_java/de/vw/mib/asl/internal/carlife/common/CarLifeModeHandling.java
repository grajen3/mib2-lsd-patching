/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.audio.CarLifeAudiohandling;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.CarLifeHelper;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeParameter;
import de.vw.mib.asl.internal.carlife.common.CarLifeResourceOwner;
import de.vw.mib.asl.internal.carlife.speech.SpeechApplicant;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;

public class CarLifeModeHandling {
    private final int WAIT_DONT_WAIT;
    private final int WAIT_FOR_MEDIA;
    private final int WAIT_FOR_MICROPHONE_IN;
    private final int WAIT_FOR_MICROPHONE_OUT;
    private final int WAIT_FOR_TTS;
    public String classname = "CarLifeModeHandling";
    private final CarlifeHSMTarget target;
    private final CarLifeGlobalProperties properties;
    private final CarLifeAudiohandling audiohandling;
    private final ASLNavigationServices navServices;
    private final SpeechApplicant speechapplicant;
    private CarLifeResourceOwner requiredResourceOwner;
    private boolean handleModeChangeInProgress;
    private byte waitForAudioResponse = 0;

    public CarLifeModeHandling(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties, CarLifeAudiohandling carLifeAudiohandling, ASLNavigationServices aSLNavigationServices, SpeechApplicant speechApplicant) {
        this.WAIT_DONT_WAIT = 0;
        this.WAIT_FOR_MEDIA = 1;
        this.WAIT_FOR_MICROPHONE_IN = 2;
        this.WAIT_FOR_MICROPHONE_OUT = 4;
        this.WAIT_FOR_TTS = 8;
        Preconditions.checkNotNull(carlifeHSMTarget, "CarlifeHSMTarget must not be null!");
        Preconditions.checkNotNull(carLifeGlobalProperties, "Porperties must not be null!");
        Preconditions.checkNotNull(carLifeAudiohandling, "AudioHandling must not be null!");
        Preconditions.checkNotNull(aSLNavigationServices, "NavigationServices must not be null!");
        Preconditions.checkNotNull(speechApplicant, "SpeechApplicant must not be null!");
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
        this.audiohandling = carLifeAudiohandling;
        this.navServices = aSLNavigationServices;
        this.speechapplicant = speechApplicant;
        this.requiredResourceOwner = null;
        this.resetResourceHandlingStatusData();
    }

    public int getMainScreenOwner(Resource[] resourceArray) {
        return CarLifeHelper.getOwner(resourceArray, 1);
    }

    public int getAudioMediaOwner(Resource[] resourceArray) {
        return CarLifeHelper.getOwner(resourceArray, 3);
    }

    public int getAudioMicrophoneOwner(Resource[] resourceArray) {
        return CarLifeHelper.getOwner(resourceArray, 2);
    }

    public int getAudioTTSOwner(Resource[] resourceArray) {
        return CarLifeHelper.getOwner(resourceArray, 4);
    }

    public int getNavigationOwner(AppState[] appStateArray) {
        return CarLifeHelper.getOwner(appStateArray, 1);
    }

    public int getSpeechOwner(AppState[] appStateArray) {
        return CarLifeHelper.getOwner(appStateArray, 2);
    }

    public void handleModeChanges(Resource[] resourceArray, AppState[] appStateArray) {
        if (!this.handleModeChangeInProgress) {
            LogMessage logMessage;
            this.handleModeChangeInProgress = true;
            if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(this.classname).append("::handleModeChanges").log();
            }
            this.handleVideoOwnerChange(resourceArray);
            this.handleAudioMediaOwnerChange(resourceArray);
            this.handleAudioMicrophoneOwnerChange(resourceArray);
            this.handleAudioTTSOwnerChange(resourceArray);
            this.handleNavigationOwnerChange(appStateArray);
            this.handleSpeechOwnerChange(appStateArray);
            if (this.waitForAudioResponse == 0) {
                if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
                    this.target.getDSICarLife().responseModeChange(CarLifeModeParameter.getResources(this.properties.getCurrentResourceOwner()), CarLifeModeParameter.getAppStates(this.properties.getCurrentResourceOwner()));
                    if (this.target.isTraceEnabled()) {
                        logMessage = this.target.trace();
                        logMessage.append(" - immediately responding").log();
                    }
                    this.handleModeChangeInProgress = false;
                    this.sendSetMode();
                }
            } else if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(new StringBuffer().append(" - no response - wait for audio channels - waitForAudioResponse: ").append(this.waitForAudioResponse).toString()).log();
            }
        } else if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(" - not processed due to running handleModeChange").log();
        }
    }

    public void requestVideo(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::requestVideo( ").append(n).append(" )").toString()).log();
        }
        this.getRequiredResourceOwner().setScreenOwner(n);
        this.sendSetMode();
    }

    public void requestAudioMedia(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::requestAudioMedia( ").append(n).append(" )").toString()).log();
        }
        this.getRequiredResourceOwner().setAudioMediaOwner(n);
        this.sendSetMode();
    }

    public void requestAudioMicrophone(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::requestAudioMicrophone( ").append(n).append(" )").toString()).log();
        }
        this.getRequiredResourceOwner().setAudioMicrophoneOwner(n);
        this.sendSetMode();
    }

    public void requestAudioTTS(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::requestAudioTTS( ").append(n).append(" )").toString()).log();
        }
        this.getRequiredResourceOwner().setAudioTTSOwner(n);
        this.sendSetMode();
    }

    public void requestNavigation(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::requestNavigation( ").append(n).append(" )").toString()).log();
        }
        this.getRequiredResourceOwner().setNavigationOwner(n);
        this.sendSetMode();
    }

    public void requestSpeech(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append(new StringBuffer().append("::requestSpeech( ").append(n).append(" )").toString()).log();
        }
        this.getRequiredResourceOwner().setSpeechOwner(n);
        this.sendSetMode();
    }

    public void sendInitialRequest() {
        this.resetResourceHandlingStatusData();
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::sendInitialRequest()").log();
        }
        int n = 1;
        if (this.properties.isCanvasVisible()) {
            n = 2;
        }
        this.getRequiredResourceOwner().setScreenOwner(n);
        this.getRequiredResourceOwner().setAudioMediaOwner(1);
        this.getRequiredResourceOwner().setAudioMicrophoneOwner(1);
        this.getRequiredResourceOwner().setAudioTTSOwner(1);
        int n2 = this.properties.isHmiRouteGuidanceActive() ? 1 : 0;
        this.getRequiredResourceOwner().setNavigationOwner(n2);
        int n3 = this.speechapplicant.isOtherSpeechActive() == ActivationState.ACTIVE ? 1 : 0;
        this.getRequiredResourceOwner().setSpeechOwner(n3);
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            this.target.getDSICarLife().setMode(CarLifeModeParameter.getResources(this.getRequiredResourceOwner()), CarLifeModeParameter.getAppStates(this.getRequiredResourceOwner()));
            this.properties.setSetModeActive(true);
        }
    }

    private void resetResourceHandlingStatusData() {
        this.requiredResourceOwner = null;
        this.properties.setSetModeActive(false);
        this.handleModeChangeInProgress = false;
        this.waitForAudioResponse = 0;
    }

    public void sendRelaunchApp() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::sendRelaunchApp()").log();
        }
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            this.target.getDSICarLife().setMode(CarLifeModeParameter.getResources(this.properties.getCurrentResourceOwner()), CarLifeModeParameter.getAppStates(this.properties.getCurrentResourceOwner()));
            this.properties.setSetModeActive(true);
        }
    }

    public void sendSetMode() {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append(this.classname).append("::sendSetMode()").log();
        }
        if (!this.properties.isSetModeActive() && this.properties.isConnected() && !this.handleModeChangeInProgress) {
            if (!this.getRequiredResourceOwner().equals(this.properties.getCurrentResourceOwner())) {
                object = new CarLifeResourceOwner(this.properties.getCurrentResourceOwner());
                boolean bl = false;
                if (!bl && ((CarLifeResourceOwner)object).getScreenOwner() != this.getRequiredResourceOwner().getScreenOwner()) {
                    ((CarLifeResourceOwner)object).setScreenOwner(this.getRequiredResourceOwner().getScreenOwner());
                    bl = true;
                    if (this.target.isTraceEnabled()) {
                        this.target.trace(" - video owner changed");
                    }
                }
                if (!bl && ((CarLifeResourceOwner)object).getAudioMediaOwner() != this.getRequiredResourceOwner().getAudioMediaOwner()) {
                    ((CarLifeResourceOwner)object).setAudioMediaOwner(this.getRequiredResourceOwner().getAudioMediaOwner());
                    bl = true;
                    if (this.target.isTraceEnabled()) {
                        this.target.trace(" - audio media owner changed");
                    }
                }
                if (!bl && ((CarLifeResourceOwner)object).getAudioMicrophoneOwner() != this.getRequiredResourceOwner().getAudioMicrophoneOwner()) {
                    ((CarLifeResourceOwner)object).setAudioMicrophoneOwner(this.getRequiredResourceOwner().getAudioMicrophoneOwner());
                    bl = true;
                    if (this.target.isTraceEnabled()) {
                        this.target.trace(" - audio micro owner changed");
                    }
                }
                if (!bl && ((CarLifeResourceOwner)object).getAudioTTSOwner() != this.getRequiredResourceOwner().getAudioTTSOwner()) {
                    ((CarLifeResourceOwner)object).setAudioTTSOwner(this.getRequiredResourceOwner().getAudioTTSOwner());
                    bl = true;
                    if (this.target.isTraceEnabled()) {
                        this.target.trace(" - audio tts owner changed");
                    }
                }
                if (!bl && ((CarLifeResourceOwner)object).getNavigationOwner() != this.getRequiredResourceOwner().getNavigationOwner()) {
                    ((CarLifeResourceOwner)object).setNavigationOwner(this.getRequiredResourceOwner().getNavigationOwner());
                    bl = true;
                    if (this.target.isTraceEnabled()) {
                        this.target.trace(" - navi owner changed");
                    }
                }
                if (!bl && ((CarLifeResourceOwner)object).getSpeechOwner() != this.getRequiredResourceOwner().getSpeechOwner()) {
                    ((CarLifeResourceOwner)object).setSpeechOwner(this.getRequiredResourceOwner().getSpeechOwner());
                    bl = true;
                    if (this.target.isTraceEnabled()) {
                        this.target.trace(" - speech owner changed");
                    }
                }
                if (bl && this.properties.isConnected() && this.properties.isDSIRegistered()) {
                    this.target.getDSICarLife().setMode(CarLifeModeParameter.getResources((CarLifeResourceOwner)object), CarLifeModeParameter.getAppStates((CarLifeResourceOwner)object));
                    this.properties.setSetModeActive(true);
                }
            } else if (this.target.isTraceEnabled()) {
                this.target.trace("sendMode skipped - owners in sync");
            }
        } else if (this.target.isTraceEnabled()) {
            if (!this.properties.isConnected()) {
                this.target.trace("sendMode blocked - no connection");
            } else if (this.properties.isSetModeActive()) {
                this.target.trace("sendMode blocked - missing answer");
            } else {
                this.target.trace("sendMode blocked - processing mode changes");
            }
        }
    }

    public void processSetAudioConnection(int n, boolean bl) {
        LogMessage logMessage;
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append(this.classname).append("::processSetAudioConnection(connection=").append(n).append(", success=").append(bl).append(" )").log();
        }
        switch (n) {
            case 167: {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse & 0xFFFFFFFE);
                break;
            }
            case 169: {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse & 0xFFFFFFFD);
                break;
            }
            case 168: {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse & 0xFFFFFFFB);
                break;
            }
            case 171: {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse & 0xFFFFFFF7);
                break;
            }
        }
        if (this.handleModeChangeInProgress && this.waitForAudioResponse == 0) {
            if (this.target.isTraceEnabled()) {
                logMessage = this.target.trace();
                logMessage.append(" - delayed responding").log();
            }
            if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
                if (!bl) {
                    switch (n) {
                        case 167: {
                            this.getRequiredResourceOwner().setAudioMediaOwner(1);
                            break;
                        }
                        case 169: {
                            this.getRequiredResourceOwner().setAudioMicrophoneOwner(1);
                            break;
                        }
                        case 168: {
                            this.getRequiredResourceOwner().setAudioMicrophoneOwner(1);
                            break;
                        }
                        case 171: {
                            this.getRequiredResourceOwner().setAudioTTSOwner(1);
                            break;
                        }
                    }
                }
                this.target.getDSICarLife().responseModeChange(CarLifeModeParameter.getResources(this.properties.getCurrentResourceOwner()), CarLifeModeParameter.getAppStates(this.properties.getCurrentResourceOwner()));
                this.handleModeChangeInProgress = false;
                this.sendSetMode();
            }
        } else if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append(new StringBuffer().append(" - still waiting - waitForAudioResponse:").append(this.waitForAudioResponse).toString()).log();
        }
    }

    protected CarLifeResourceOwner getRequiredResourceOwner() {
        if (null == this.requiredResourceOwner) {
            this.requiredResourceOwner = new CarLifeResourceOwner(this.properties.getCurrentResourceOwner());
        }
        return this.requiredResourceOwner;
    }

    private void handleVideoOwnerChange(Resource[] resourceArray) {
        int n = this.getMainScreenOwner(resourceArray);
        if (n != this.properties.getCurrentScreenOwner()) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("CARLIFE - screen owner change requested");
            }
            if (n == 2) {
                if (this.properties.getCurrentScreenOwner() != 0 && !this.properties.isCanvasVisible()) {
                    if (this.target.isTraceEnabled()) {
                        this.target.trace("CARLIFE - trigger ASL_SMARTPHONEINTEGRATION_CARLIFE_TRIGGERED_CONTEXTSWITCH_TO_CARLIFE");
                    }
                    this.target.triggerObserver(-1978376960, null);
                }
            } else if (n == 1) {
                if (this.properties.getCurrentScreenOwner() != 0 && this.properties.isCanvasVisible()) {
                    if (this.target.isTraceEnabled()) {
                        this.target.trace("CARLIFE - trigger ASL_SMARTPHONEINTEGRATION_CARLIFE_TRIGGERED_CONTEXTSWITCH_LEFT_CARLIFE");
                    }
                    this.target.triggerObserver(-1961599744, null);
                }
            } else if (n == 0) {
                // empty if block
            }
            this.properties.setCurrentScreenOwner(n);
        }
        this.getRequiredResourceOwner().setScreenOwner(n);
    }

    private void handleAudioMediaOwnerChange(Resource[] resourceArray) {
        int n;
        int n2;
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleAudioMediaModeChange()").log();
        }
        if (CarLifeHelper.isSwitchResOwnerFromDevice(n2 = this.properties.getCurrentAudioMediaOwner(), n = this.getAudioMediaOwner(resourceArray))) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Media source is no longer device");
            }
            this.audiohandling.releaseAudioConnection(167, false);
        } else if (CarLifeHelper.isSwitchResOwnerToDevice(n2, n)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Media source is now device");
            }
            this.audiohandling.performRequestAudioMediaToDevice();
            if (this.audiohandling.getCurrentSoundStatus(167) != 3) {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse | 1);
            } else if (this.properties.isConnected()) {
                this.audiohandling.changeVolumeLock(false);
                if (this.audiohandling.getCurrentMuteState()) {
                    this.audiohandling.releaseUserMute();
                }
            }
        }
        this.properties.setCurrentAudioMediaOwner(n);
        this.getRequiredResourceOwner().setAudioMediaOwner(n);
    }

    private void handleAudioMicrophoneOwnerChange(Resource[] resourceArray) {
        int n = this.properties.getCurrentAudioMicrophoneOwner();
        int n2 = this.getAudioMicrophoneOwner(resourceArray);
        this.properties.setCurrentAudioMicrophoneOwner(n2);
        if (CarLifeHelper.isSwitchResOwnerFromDevice(n, n2)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Microphone source is no longer device");
            }
            this.audiohandling.releaseAudioConnection(169, false);
            this.audiohandling.releaseAudioConnection(168, false);
        } else if (CarLifeHelper.isSwitchResOwnerToDevice(n, n2)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Microphone source is now device");
            }
            this.audiohandling.performRequestAudioMicrophoneToDevice();
            if (this.audiohandling.getCurrentSoundStatus(169) != 3) {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse | 2);
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse | 4);
            }
        }
        this.getRequiredResourceOwner().setAudioMicrophoneOwner(n2);
    }

    private void handleAudioTTSOwnerChange(Resource[] resourceArray) {
        int n = this.properties.getCurrentAudioTTSOwner();
        int n2 = this.getAudioTTSOwner(resourceArray);
        this.properties.setCurrentAudioTTSOwner(n2);
        if (CarLifeHelper.isSwitchResOwnerFromDevice(n, n2)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - TTS source is no longer device");
            }
            this.audiohandling.releaseAudioConnection(171, false);
        } else if (CarLifeHelper.isSwitchResOwnerToDevice(n, n2)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - TTS source is now device");
            }
            this.audiohandling.performRequestAudioTTSToDevice();
            if (this.audiohandling.getCurrentSoundStatus(171) != 3) {
                this.waitForAudioResponse = (byte)(this.waitForAudioResponse | 8);
            }
        }
        this.getRequiredResourceOwner().setAudioTTSOwner(n2);
    }

    private void handleNavigationOwnerChange(AppState[] appStateArray) {
        int n = this.getNavigationOwner(appStateArray);
        int n2 = this.properties.getActiveNavigation();
        if (CarLifeHelper.isSwitchAppOwnerToDevice(n2, n)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Active navigation is now: CARLIFE");
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(1332161536, true);
            this.properties.setActiveNavigation(n);
            if (this.navServices.isServiceAvailable()) {
                this.navServices.stopGuidance(6);
            } else if (this.target.isTraceEnabled()) {
                this.target.trace(" - We can not stop hmi navi because service is not ready yet");
            }
        } else if (CarLifeHelper.isSwitchAppOwnerToMainUnit(n2, n)) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Active Navigation is now: HMI");
            }
            if (n2 == 2) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1332161536, false);
            }
            this.properties.setActiveNavigation(n);
        } else if (n == 0) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(" - Navigation is now inactive");
            }
            if (n2 == 2) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1332161536, false);
            }
            this.properties.setActiveNavigation(n);
        }
        this.getRequiredResourceOwner().setNavigationOwner(n);
    }

    private void handleSpeechOwnerChange(AppState[] appStateArray) {
        int n;
        int n2;
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append(this.classname).append("::handleSpeechModeChange()").log();
        }
        if (CarLifeHelper.isSwitchAppOwnerFromDevice(n2 = this.properties.getActiveSpeech(), n = this.getSpeechOwner(appStateArray))) {
            if (this.speechapplicant.isCarLifeActive()) {
                this.speechapplicant.forceChangeState(ActivationState.INACTIVE);
            }
        } else if (CarLifeHelper.isSwitchAppOwnerToDevice(n2, n)) {
            this.speechapplicant.forceChangeState(ActivationState.ACTIVE);
        }
        this.properties.setActiveSpeech(n);
        this.getRequiredResourceOwner().setSpeechOwner(n);
    }
}

