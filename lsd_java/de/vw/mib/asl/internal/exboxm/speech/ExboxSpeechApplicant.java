/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.speech;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.exboxm.ExBoxMAudio;
import de.vw.mib.asl.internal.exboxm.IntStringMap;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant$1;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant$2;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechKeyHandlerListener;
import de.vw.mib.asl.internal.exboxm.speech.SpeechConnectionStatusListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxSpeechListener;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateService;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import de.vw.mib.asl.internal.exboxm.util.Preconditions;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.internal.SpeechDialogActivationApplicantAdapter;

public class ExboxSpeechApplicant
extends SpeechDialogActivationApplicantAdapter
implements ExboxSpeechKeyHandlerListener {
    final ExboxLogger exboxLogger;
    private final ExBoxMAudio exBoxMAudio;
    private ActivationState exboxSpeechActivationState = ActivationState.INACTIVE;
    private ExboxServices exboxServices;
    private int speechConnectionStatus = 0;
    private SpeechDialogActivationAdmin speechDialogActivationAdmin;
    private ActivationState adminActivationState;
    private static final IntStringMap REQUEST_CONTEXT_TO_NAME = new IntStringMap("Unknown", new int[]{8, 0}, new String[]{"SDS", "BACK"});
    static /* synthetic */ Class class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechApplicant;

    public ExboxSpeechApplicant(ExboxServices exboxServices, ExBoxMAudio exBoxMAudio) {
        super(exboxServices.getBundleContext());
        Preconditions.checkArgumentNotNull(exBoxMAudio, "The exBoxAudio must not be null.");
        Preconditions.checkArgumentNotNull(exboxServices.getLogger(), "The logger must not be null.");
        Preconditions.checkArgumentNotNull(exboxServices.getExboxStateService(), "The ExboxStateService must not be null.");
        this.exboxServices = exboxServices;
        this.exBoxMAudio = exBoxMAudio;
        this.exboxLogger = new ExboxLogger(exboxServices.getLogger(), class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechApplicant == null ? (class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechApplicant = ExboxSpeechApplicant.class$("de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant")) : class$de$vw$mib$asl$internal$exboxm$speech$ExboxSpeechApplicant);
        this.exBoxMAudio.setSpeechConnectionStatusListener(this.createSpeechConnectionStatusListener());
        exboxServices.getExboxStateService().setSpeechListener(this.createExboxSpeechListener());
    }

    private void activateSpeech() {
        if (!this.isExboxSpeechApplicantActive()) {
            if (ActivationState.INACTIVE.equals(this.adminActivationState)) {
                this.changeActivationState(ActivationState.ACTIVE);
            } else {
                this.exboxLogger.trace("activateSpeech: Exbox speech can't be activated.");
            }
        } else {
            this.exboxLogger.trace("activateSpeech: Exbox speech is already active.");
        }
    }

    private void changeActivationState(ActivationState activationState) {
        if (this.speechDialogActivationAdmin != null) {
            if (activationState.toString() != null) {
                this.exboxLogger.trace(new StringBuffer().append("Try to change activation state at speech admin to ").append(activationState.toString()).append(".").toString());
            }
            this.speechDialogActivationAdmin.changeActivationState(activationState, this);
        } else {
            this.exboxLogger.warn("Change activation state called but speech admin is null!");
        }
    }

    private SpeechConnectionStatusListener createSpeechConnectionStatusListener() {
        return new ExboxSpeechApplicant$1(this);
    }

    ExboxSpeechListener createExboxSpeechListener() {
        return new ExboxSpeechApplicant$2(this);
    }

    void deactivateSpeech() {
        if (this.isExboxSpeechApplicantActive()) {
            this.changeActivationState(ActivationState.INACTIVE);
        } else {
            this.exboxLogger.trace("deactivateSpeech: Exbox speech is already inactive.");
        }
    }

    void handleSpeechConnectionStatusChange(int n) {
        if (this.speechConnectionStatus != n) {
            switch (n) {
                case 0: {
                    this.deactivateSpeech();
                    break;
                }
                case 2: {
                    this.exboxLogger.trace(new StringBuffer().append("isExboxSpeechApplicantActive=").append(this.isExboxSpeechApplicantActive()).append(" isSpeechConnectionEstablished=").append(this.isSpeechConnectionEstablished()).toString());
                    if (!this.isExboxSpeechApplicantActive() || this.isSpeechConnectionEstablished()) break;
                    this.requestDisplaySpeech();
                    break;
                }
                case 1: {
                    break;
                }
            }
            this.speechConnectionStatus = n;
        }
    }

    private boolean isExboxSpeechApplicantActive() {
        return ActivationState.ACTIVE.equals(this.exboxSpeechActivationState);
    }

    private boolean isSpeechConnectionEstablished() {
        return this.speechConnectionStatus == 2;
    }

    private boolean isSpeechConnectionReleased() {
        return this.speechConnectionStatus == 0;
    }

    private void readActivationState() {
        if (this.speechDialogActivationAdmin != null) {
            this.exboxLogger.trace("Read activation state from speech admin.");
            this.speechDialogActivationAdmin.readActivationState(this);
        } else {
            this.exboxLogger.warn("Read activation state called, but admin is null!");
        }
    }

    private void releaseAudioConnectionSpeech() {
        if (!this.isSpeechConnectionReleased()) {
            this.exboxLogger.trace("Release Exbox speech audio connection.");
            this.exBoxMAudio.releaseAudioConnectionSpeech();
        }
    }

    private void releaseDisplaySpeech() {
        this.exboxLogger.trace("ASL>HMI: Signal backstack display request.");
        this.signalContextRequestToModel(0);
    }

    private void requestAudioConnectionSpeech() {
        this.exboxLogger.trace("Request Exbox speech audio connection.");
        this.exBoxMAudio.requestAudioConnectionSpeech();
    }

    private void requestDisplaySpeech() {
        this.exboxLogger.trace("requestDisplaySpeech called!");
        this.signalContextRequestToModel(8);
    }

    private void signalContextRequestToModel(int n) {
        String string = REQUEST_CONTEXT_TO_NAME.get(n);
        this.exboxLogger.trace(new StringBuffer().append("signalContextRequestToModel called! Context id is ").append(n).append(" (").append(string).append("). Datapool value ASL.ExBoxM.requestContext. Model event EXBOXM_REQUEST_CONTEXT_CHANGED.").toString());
        ExboxServicesProvider.getExBoxServices().getAslPropertyManager().valueChangedInteger(3504, n);
    }

    private void stopSpeechSession() {
        if (this.isExboxSpeechApplicantActive()) {
            if (this.isSpeechConnectionEstablished()) {
                this.releaseDisplaySpeech();
            }
            this.releaseAudioConnectionSpeech();
        }
    }

    @Override
    public void cancelActivation() {
        this.exboxLogger.trace("cancelActivation() called from admin, because another applicant forced to be the active");
        this.stopSpeechSession();
        this.exboxSpeechActivationState = ActivationState.INACTIVE;
    }

    @Override
    public void cancelRequest(int n) {
        if (n == 0) {
            this.exboxLogger.trace("cancelRequest() called from admin");
            this.stopSpeechSession();
            this.deactivateSpeech();
        } else {
            this.exboxLogger.warn(new StringBuffer().append("cancelRequest() ==> not handled cancel request reason with id=").append(n).toString());
        }
    }

    @Override
    public void resultChangeActivationState(boolean bl, ActivationState activationState) {
        this.exboxLogger.trace("resultChangeActivationState called!");
        if (!this.exboxSpeechActivationState.equals(activationState)) {
            this.exboxSpeechActivationState = activationState;
            if (bl && ActivationState.ACTIVE.equals(activationState)) {
                this.exboxLogger.trace("Changed activation state to ACTIVE.");
                if (!this.isSpeechConnectionEstablished()) {
                    this.requestAudioConnectionSpeech();
                }
            } else if (bl && ActivationState.INACTIVE.equals(activationState)) {
                this.exboxLogger.trace("Changed activation state to INACTIVE.");
            } else {
                this.exboxLogger.trace("Change of activation state was not granted by speech admin.");
            }
        } else {
            this.exboxLogger.trace(new StringBuffer().append("Nothing to be done. Result state equals current activation state which is ").append(this.exboxSpeechActivationState).append(".").toString());
        }
    }

    @Override
    public void resultReadActivationState(ActivationState activationState) {
        this.exboxLogger.trace(new StringBuffer().append("resultReadActivationState called. Admin activation state is ").append(activationState).append(".").toString());
        this.adminActivationState = activationState;
    }

    @Override
    public void setAdmin(SpeechDialogActivationAdmin speechDialogActivationAdmin) {
        this.speechDialogActivationAdmin = speechDialogActivationAdmin;
    }

    @Override
    public void onSpeechAbortKeyPressed() {
        this.exboxLogger.trace("Handle onSpeechAbortKeyPressed.");
        this.releaseAudioConnectionSpeech();
        this.deactivateSpeech();
    }

    @Override
    public void onSpeechKeyDoublePressed() {
        this.exboxLogger.trace("Handle onSpeechKeyDoublePressed.");
        this.stopSpeechSession();
        this.deactivateSpeech();
    }

    @Override
    public void onSpeechKeyPressed() {
        this.exboxLogger.trace("Handle onSpeechKeyPressed.");
        this.readActivationState();
    }

    @Override
    public void onSpeechKeyReleased() {
        this.exboxLogger.trace("Handle onSpeechKeyReleased.");
        ExboxStateService exboxStateService = this.exboxServices.getExboxStateService();
        if (exboxStateService.isExboxOperationStateNormal()) {
            this.activateSpeech();
        } else {
            this.showSdsNotAvailablePopup();
        }
    }

    private void showSdsNotAvailablePopup() {
        this.exboxLogger.trace("showSdsNotAvailablePopup called!");
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1909787136);
    }

    @Override
    public void onSpeechKeyUltraLongPressed() {
        this.exboxLogger.trace("Handle onSpeechKeyUltraLongPressed.");
        this.stopSpeechSession();
        this.deactivateSpeech();
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

