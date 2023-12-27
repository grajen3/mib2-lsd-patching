/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.speech;

import de.vw.mib.asl.internal.carplay.audio.CarPlayAudiohandling;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.CarPlayHMIRequestParameterConfiguration;
import de.vw.mib.asl.internal.carplay.target.ASLHandler;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.internal.SpeechDialogActivationApplicantAdapter;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;
import org.osgi.framework.BundleContext;

public class SpeechApplicant
extends SpeechDialogActivationApplicantAdapter {
    private final String classname;
    private HsmTarget target;
    private CarPlayGlobalProperies properties;
    private CarPlayAudiohandling audiohandling;
    private ASLHandler aslhandler;
    private int applicantsCount = -1;
    private SpeechDialogActivationAdmin admin;
    private ActivationState carplayState = ActivationState.INACTIVE;
    private boolean wasSiriStart = false;
    private ActivationState isOtherSpeechActive = ActivationState.INACTIVE;

    public SpeechApplicant(BundleContext bundleContext, HsmTarget hsmTarget, CarPlayGlobalProperies carPlayGlobalProperies) {
        super(bundleContext);
        this.classname = "SpeechApplicant";
        this.target = hsmTarget;
        this.properties = carPlayGlobalProperies;
    }

    public void setAudiohandling(CarPlayAudiohandling carPlayAudiohandling) {
        this.audiohandling = carPlayAudiohandling;
    }

    public void setASLHandler(ASLHandler aSLHandler) {
        this.aslhandler = aSLHandler;
    }

    void readActivationState() {
        if (this.admin != null) {
            this.admin.readActivationState(this);
        } else if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.warn();
            logMessage.append("SpeechApplicant").append(".readActivationState: Instance of SpeechDialogActivationAdmin is NULL!").log();
        }
    }

    void changeState(ActivationState activationState) {
        if (this.admin != null) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("SpeechApplicant").append(".changeState(ACTIVE=").append(ActivationState.ACTIVE.equals(activationState)).log();
            }
            this.admin.changeActivationState(activationState, this);
        } else if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.warn();
            logMessage.append("SpeechApplicant").append(".readActivationState: Instance of SpeechDialogActivationAdmin is NULL!").log();
        }
    }

    public void forceChangeState(ActivationState activationState) {
        if (this.admin != null) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("SpeechApplicant").append(".forceChangeState(ACTIVE=").append(ActivationState.ACTIVE.equals(activationState)).log();
            }
            this.admin.forceActivationStateChange(activationState, this);
            this.carplayState = activationState;
        } else if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.warn();
            logMessage.append("SpeechApplicant").append(".forceChangeState: Instance of SpeechDialogActivationAdmin is NULL!").log();
        }
    }

    public void unregister() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".unregister()").log();
        }
        if (this.isRegistered()) {
            this.unregisterService();
            this.admin = null;
        }
    }

    @Override
    public void setAdmin(SpeechDialogActivationAdmin speechDialogActivationAdmin) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".setAdmin()").log();
        }
        this.admin = speechDialogActivationAdmin;
    }

    @Override
    public void updateApplicantsCount(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".updateApplicantsCount(count=").append(n).append(")").log();
        }
        this.applicantsCount = n;
    }

    @Override
    public void resultChangeActivationState(boolean bl, ActivationState activationState) {
        LogMessage logMessage;
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".resultChangeActivationState(granted=").append(bl ? "true" : "false").append(",resultState=").append(activationState == ActivationState.ACTIVE ? "ACTIVE" : "INACTIVE").append(")").log();
        }
        if (bl && ActivationState.ACTIVE.equals(activationState)) {
            this.setWasSiriStart(true);
            this.carplayState = ActivationState.ACTIVE;
            this.target.getDSICarPlay().requestSIRIAction(1);
        } else if (bl && ActivationState.INACTIVE.equals(activationState)) {
            this.carplayState = ActivationState.INACTIVE;
            this.setWasSiriStart(false);
        } else if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".resultChangeActivationState: speech activation not granted by admin").log();
        }
    }

    @Override
    public void cancelActivation() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".cancelActivation()").log();
        }
        if (this.isCarplayActive()) {
            this.target.getDSICarPlay().requestSIRIAction(1);
            this.target.getDSICarPlay().requestSIRIAction(2);
        }
        this.carplayState = ActivationState.INACTIVE;
    }

    @Override
    public void resultReadActivationState(ActivationState activationState) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".resultReadActivationState(currentState=").append(activationState == ActivationState.ACTIVE ? "ACTIVE" : "INACTIVE").append(")").log();
        }
        if (ActivationState.INACTIVE.equals(activationState)) {
            this.changeState(ActivationState.ACTIVE);
        }
    }

    @Override
    public void updateActivationState(ActivationState activationState) {
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append("SpeechApplicant").append(".updateActivationState(newState=").append(activationState == ActivationState.ACTIVE ? "ACTIVE" : "INACTIVE").append(")").log();
        }
        if (!this.isCarplayActive() && this.properties.getActiveSpeech() != 2 && this.properties.getConnectionState() == 3) {
            AppStateRequest[] appStateRequestArray;
            if (this.properties.isDelayBorrowAudio() && this.properties.getCurrentMainAudioSource() == 2 && this.properties.getCurrentMainAudioType() == 2) {
                if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append("SpeechApplicant").append(".updateActivationState - delayed borrowing is active => BORROW audio").log();
                }
                if (this.properties.getCurrentSoundStatus(151) == 0 && this.properties.getCurrentSoundStatus(163) == 0 && this.properties.getCurrentSoundStatus(152) == 0 && this.properties.getCurrentSoundStatus(153) == 0 && this.properties.getCurrentSoundStatus(this.properties.getRingtoneConnection()) == 0) {
                    this.audiohandling.borrowMainAudio("Borrow Audio: SDS is now active and is overlaying the media source (delayed borrowing was triggered)");
                } else if (this.target.isTraceEnabled()) {
                    object = this.target.trace();
                    object.append("SpeechApplicant").append(".updateActivationState - Dont borrow because there is another own audio connection active").log();
                }
                this.properties.setDelayBorrowAudio(false);
            }
            CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration = this.properties.getParamconfig();
            super.getClass();
            object = carPlayHMIRequestParameterConfiguration.getRessourceRequest(0);
            if (activationState == ActivationState.ACTIVE) {
                CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration2 = this.properties.getParamconfig();
                super.getClass();
                appStateRequestArray = carPlayHMIRequestParameterConfiguration2.getAppStateRequest(3);
            } else {
                CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration3 = this.properties.getParamconfig();
                super.getClass();
                appStateRequestArray = carPlayHMIRequestParameterConfiguration3.getAppStateRequest(4);
            }
            this.target.getDSICarPlay().requestModeChange((ResourceRequest[])object, appStateRequestArray, "User initiated");
        }
        this.setOtherSpeechActive(activationState);
    }

    @Override
    public void cancelRequest(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(new StringBuffer().append(".cancelRequest(cancelRequestReason=").append(n).append(")").toString()).log();
        }
        if (this.properties.isConnected()) {
            this.aslhandler.handleTaActive();
        }
    }

    public boolean isCarplayActive() {
        return ActivationState.ACTIVE.equals(this.carplayState);
    }

    public void PrewarmSiri() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".PrewarmSiri()").log();
        }
        this.target.getDSICarPlay().requestSIRIAction(0);
    }

    public void StopSiri() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".StopSiri()").log();
        }
        this.setWasSiriStart(false);
        this.target.getDSICarPlay().requestSIRIAction(2);
    }

    public boolean wasSiriStart() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".wasSiriStart(), value=").append(this.wasSiriStart).log();
        }
        return this.wasSiriStart;
    }

    public void setWasSiriStart(boolean bl) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".setWasSiriStart(), value=").append(bl).log();
        }
        this.wasSiriStart = bl;
    }

    public ActivationState isOtherSpeechActive() {
        return this.isOtherSpeechActive;
    }

    public void setOtherSpeechActive(ActivationState activationState) {
        this.isOtherSpeechActive = activationState;
    }
}

