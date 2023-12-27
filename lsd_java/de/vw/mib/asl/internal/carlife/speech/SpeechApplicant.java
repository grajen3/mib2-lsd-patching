/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.speech;

import de.vw.mib.asl.internal.carlife.ASLHandler;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.audio.CarLifeAudiohandling;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.internal.SpeechDialogActivationApplicantAdapter;
import de.vw.mib.log4mib.LogMessage;
import org.osgi.framework.BundleContext;

public class SpeechApplicant
extends SpeechDialogActivationApplicantAdapter {
    private final String classname;
    private CarlifeHSMTarget target;
    private CarLifeGlobalProperties properties;
    private CarLifeAudiohandling audiohandling;
    private ASLHandler aslhandler;
    private SpeechDialogActivationAdmin admin;
    private ActivationState carlifeState = ActivationState.INACTIVE;
    private ActivationState isOtherSpeechActive = ActivationState.INACTIVE;

    public SpeechApplicant(BundleContext bundleContext, CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties) {
        super(bundleContext);
        this.classname = "SpeechApplicant";
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
    }

    public void setAudiohandling(CarLifeAudiohandling carLifeAudiohandling) {
        this.audiohandling = carLifeAudiohandling;
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
            this.carlifeState = activationState;
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
    public void resultChangeActivationState(boolean bl, ActivationState activationState) {
        LogMessage logMessage;
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".resultChangeActivationState(granted=").append(bl ? "true" : "false").append(",resultState=").append(activationState == ActivationState.ACTIVE ? "ACTIVE" : "INACTIVE").append(")").log();
        }
        if (bl && ActivationState.ACTIVE.equals(activationState)) {
            this.carlifeState = ActivationState.ACTIVE;
        } else if (bl && ActivationState.INACTIVE.equals(activationState)) {
            this.carlifeState = ActivationState.INACTIVE;
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
        this.carlifeState = ActivationState.INACTIVE;
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
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("SpeechApplicant").append(".updateActivationState(newState=").append(activationState == ActivationState.ACTIVE ? "ACTIVE" : "INACTIVE").append(")").log();
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

    public boolean isCarLifeActive() {
        return ActivationState.ACTIVE.equals(this.carlifeState);
    }

    public ActivationState isOtherSpeechActive() {
        return this.isOtherSpeechActive;
    }

    public void setOtherSpeechActive(ActivationState activationState) {
        this.isOtherSpeechActive = activationState;
    }
}

