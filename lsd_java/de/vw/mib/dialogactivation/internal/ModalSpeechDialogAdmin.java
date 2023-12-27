/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dialogactivation.internal;

import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.SpeechDialogActivationApplicant;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.popup.PopupSpeechInfoReceiver;
import de.vw.mib.popup.PopupSpeechSegueService;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.ArrayList;
import java.util.Iterator;

final class ModalSpeechDialogAdmin
implements SpeechDialogActivationAdmin,
PopupSpeechInfoReceiver {
    private static final int TRACE_SUB_CLASSIFIER;
    private SpeechDialogActivationApplicant activeApplicant;
    private ArrayList allApplicants;
    private final Logger logger;
    private final String loggerPrefix;
    private final PopupSpeechSegueService popupSpeechSegueService;
    private final AsyncServiceFactory asyncServiceFactoryASL;
    private ActivationState currentActivationState;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupSpeechInfoReceiver;
    static /* synthetic */ Class class$de$vw$mib$dialogactivation$SpeechDialogActivationAdmin;

    ModalSpeechDialogAdmin(PopupSpeechSegueService popupSpeechSegueService, AsyncServiceFactory asyncServiceFactory, Logger logger) {
        this.loggerPrefix = "[SpeechDialogActivationAdmin] ";
        this.popupSpeechSegueService = popupSpeechSegueService;
        this.asyncServiceFactoryASL = asyncServiceFactory;
        this.logger = logger;
        this.activeApplicant = null;
        this.allApplicants = new ArrayList(0);
        this.registerAtPopupManager();
    }

    private void registerAtPopupManager() {
        PopupSpeechInfoReceiver popupSpeechInfoReceiver = (PopupSpeechInfoReceiver)this.asyncServiceFactoryASL.create(this, new Class[]{class$de$vw$mib$popup$PopupSpeechInfoReceiver == null ? (class$de$vw$mib$popup$PopupSpeechInfoReceiver = ModalSpeechDialogAdmin.class$("de.vw.mib.popup.PopupSpeechInfoReceiver")) : class$de$vw$mib$popup$PopupSpeechInfoReceiver});
        this.popupSpeechSegueService.addPopupSpeechInfoReceiver(popupSpeechInfoReceiver);
    }

    private boolean isAnotherAppActive(SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        return this.activeApplicant != null && this.activeApplicant != speechDialogActivationApplicant;
    }

    void addedApplicant(SpeechDialogActivationApplicant speechDialogActivationApplicant, ArrayList arrayList) {
        Object object;
        if (this.logger.isTraceEnabled(2)) {
            object = this.logger.trace(2);
            object.append("[SpeechDialogActivationAdmin] ");
            object.append("addedApplicant( ");
            object.append(super.getClass().getName());
            object.append("  )");
            object.log();
        }
        this.allApplicants = arrayList;
        if (this.allApplicants == null) {
            this.allApplicants = new ArrayList(0);
        }
        object = (SpeechDialogActivationAdmin)this.asyncServiceFactoryASL.create(this, new Class[]{class$de$vw$mib$dialogactivation$SpeechDialogActivationAdmin == null ? (class$de$vw$mib$dialogactivation$SpeechDialogActivationAdmin = ModalSpeechDialogAdmin.class$("de.vw.mib.dialogactivation.SpeechDialogActivationAdmin")) : class$de$vw$mib$dialogactivation$SpeechDialogActivationAdmin});
        speechDialogActivationApplicant.setAdmin((SpeechDialogActivationAdmin)object);
        this.notifyCount(this.allApplicants.size());
        if (this.isAnotherAppActive(speechDialogActivationApplicant)) {
            speechDialogActivationApplicant.updateActivationState(ActivationState.ACTIVE);
        }
    }

    void removedApplicant(SpeechDialogActivationApplicant speechDialogActivationApplicant, ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer("[SpeechDialogActivationAdmin] ");
        stringBuffer.append("removedApplicant( ");
        stringBuffer.append(super.getClass().getName());
        stringBuffer.append("  )");
        this.logger.trace(2, stringBuffer.toString());
        this.allApplicants = arrayList;
        if (this.allApplicants == null) {
            this.allApplicants = new ArrayList(0);
        }
        if (this.activeApplicant == speechDialogActivationApplicant) {
            this.notifyActivationState(speechDialogActivationApplicant, ActivationState.INACTIVE);
            this.notifyActivationStateChangesFinished(ActivationState.INACTIVE);
            this.activeApplicant = null;
        }
        this.notifyCount(this.allApplicants.size());
    }

    private void notifyCount(int n) {
        Iterator iterator = this.allApplicants.iterator();
        while (iterator.hasNext()) {
            SpeechDialogActivationApplicant speechDialogActivationApplicant = (SpeechDialogActivationApplicant)iterator.next();
            speechDialogActivationApplicant.updateApplicantsCount(n);
        }
    }

    private void notifyActivationState(SpeechDialogActivationApplicant speechDialogActivationApplicant, ActivationState activationState) {
        Iterator iterator = this.allApplicants.iterator();
        while (iterator.hasNext()) {
            SpeechDialogActivationApplicant speechDialogActivationApplicant2 = (SpeechDialogActivationApplicant)iterator.next();
            if (speechDialogActivationApplicant2 == speechDialogActivationApplicant) continue;
            speechDialogActivationApplicant2.updateActivationState(activationState);
        }
    }

    private void notifyActivationStateChangesFinished(ActivationState activationState) {
        if (this.currentActivationState != activationState) {
            this.currentActivationState = activationState;
            if (this.currentActivationState == ActivationState.ACTIVE) {
                this.popupSpeechSegueService.receiveSpeechApplicantActive(true);
            } else if (this.currentActivationState == ActivationState.INACTIVE) {
                this.popupSpeechSegueService.receiveSpeechApplicantActive(false);
            } else {
                this.popupSpeechSegueService.receiveSpeechApplicantActive(false);
                this.logger.warn(2, "notifyActivationStateChangesFinished: unknown activationState");
            }
        }
    }

    @Override
    public synchronized void changeActivationState(ActivationState activationState, SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        StringBuffer stringBuffer = new StringBuffer("[SpeechDialogActivationAdmin] ");
        stringBuffer.append("changeActivationState( ");
        stringBuffer.append(activationState.toString()).append(", ");
        stringBuffer.append(super.getClass().getName());
        stringBuffer.append("  )");
        this.logger.trace(2, stringBuffer.toString());
        if (this.isAnotherAppActive(speechDialogActivationApplicant)) {
            speechDialogActivationApplicant.resultChangeActivationState(false, ActivationState.INACTIVE);
        } else {
            speechDialogActivationApplicant.resultChangeActivationState(true, activationState);
            if (activationState.equals(ActivationState.ACTIVE)) {
                this.activeApplicant = speechDialogActivationApplicant;
                this.notifyActivationState(speechDialogActivationApplicant, activationState);
                this.notifyActivationStateChangesFinished(activationState);
            } else if (activationState.equals(ActivationState.INACTIVE)) {
                this.notifyActivationState(speechDialogActivationApplicant, activationState);
                this.notifyActivationStateChangesFinished(activationState);
                this.activeApplicant = null;
            }
        }
    }

    @Override
    public synchronized void forceActivationStateChange(ActivationState activationState, SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        StringBuffer stringBuffer = new StringBuffer("[SpeechDialogActivationAdmin] ");
        stringBuffer.append("forceActivationStateChange( ");
        stringBuffer.append(activationState.toString()).append(", ");
        stringBuffer.append(super.getClass().getName());
        stringBuffer.append("  )");
        this.logger.trace(2, stringBuffer.toString());
        if (activationState.equals(ActivationState.ACTIVE)) {
            if (this.isAnotherAppActive(speechDialogActivationApplicant)) {
                this.activeApplicant.cancelActivation();
            }
            this.notifyActivationState(this.activeApplicant, ActivationState.INACTIVE);
            this.activeApplicant = speechDialogActivationApplicant;
            this.notifyActivationState(speechDialogActivationApplicant, activationState);
            this.notifyActivationStateChangesFinished(activationState);
        } else if (activationState.equals(ActivationState.INACTIVE) && this.activeApplicant == speechDialogActivationApplicant) {
            this.activeApplicant = null;
            this.notifyActivationState(speechDialogActivationApplicant, activationState);
            this.notifyActivationStateChangesFinished(activationState);
        }
    }

    @Override
    public synchronized void readActivationState(SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        if (this.activeApplicant == null) {
            speechDialogActivationApplicant.resultReadActivationState(ActivationState.INACTIVE);
        } else {
            speechDialogActivationApplicant.resultReadActivationState(ActivationState.ACTIVE);
        }
    }

    @Override
    public void receiveStopSpeech() {
        if (this.activeApplicant != null) {
            if (this.logger.isTraceEnabled(2)) {
                LogMessage logMessage = this.logger.trace(2);
                logMessage.append("Sending cancel request due to PO_stopSpeech to active speech client");
                logMessage.append(super.getClass().getName());
                logMessage.log();
            }
            this.activeApplicant.cancelRequest(0);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

