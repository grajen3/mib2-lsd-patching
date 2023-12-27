/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt;

import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.ptt.StateTracker;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.internal.SpeechDialogActivationApplicantAdapter;
import de.vw.mib.log4mib.LogMessage;
import org.osgi.framework.BundleContext;

public class SpeechApplicant
extends SpeechDialogActivationApplicantAdapter {
    private int applicantsCount = -1;
    private ActivationState lastSpeechAdminActivationState;
    private SpeechDialogActivationAdmin admin = null;
    private final StateTracker stateTracker;
    private final DialogSession dialogSession;
    private final String TRACE_PREFIX;
    private final int TRACE_CLASSIFIER;
    private final SpeechGeneralLogger logger = new SpeechGeneralLogger("[SDS-SpeechApplicant] ", 4096);
    private boolean ignoreEndTone;

    public SpeechApplicant(BundleContext bundleContext, StateTracker stateTracker, DialogSession dialogSession) {
        super(bundleContext);
        this.TRACE_PREFIX = "[SDS-SpeechApplicant] ";
        this.TRACE_CLASSIFIER = 4096;
        this.stateTracker = stateTracker;
        this.dialogSession = dialogSession;
        this.ignoreEndTone = false;
    }

    public void onDialogFinished() {
        if (this.admin != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Finishing Dialog ==> notify Admin. ").log();
            }
            this.admin.changeActivationState(ActivationState.INACTIVE, this);
        } else {
            this.logger.warn().append("Instance of SpeechDialogActivationAdmin is NULL!").log();
        }
    }

    public void readSpeechAdminActivationState() {
        if (this.admin != null) {
            this.admin.readActivationState(this);
        } else {
            this.logger.warn().append("readSpeechAdminActivationState: Instance of SpeechDialogActivationAdmin is NULL!").log();
        }
    }

    public void requestDialogActivation() {
        if (this.admin != null) {
            this.admin.changeActivationState(ActivationState.ACTIVE, this);
        } else {
            this.dialogSession.requestDialogActivationGranted();
            this.logger.warn().append("requestDialogActivation: Instance of SpeechDialogActivationAdmin is NULL!").log();
        }
    }

    public ActivationState getLastSpeechAdminActivationState() {
        return this.lastSpeechAdminActivationState;
    }

    boolean isMultipleApplicants() {
        return this.applicantsCount > 1;
    }

    @Override
    public void setAdmin(SpeechDialogActivationAdmin speechDialogActivationAdmin) {
        this.admin = speechDialogActivationAdmin;
    }

    @Override
    public void resultReadActivationState(ActivationState activationState) {
        this.lastSpeechAdminActivationState = activationState;
    }

    @Override
    public void resultChangeActivationState(boolean bl, ActivationState activationState) {
        if (bl) {
            if (activationState.equals(ActivationState.ACTIVE)) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace().append("resultChangeActivationState(granted, ACTIVE) ==> start dialog ").log();
                }
                this.dialogSession.requestDialogActivationGranted();
            } else if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("resultChangeActivationState(granted, INACTIVE) ==> finished dialog ").log();
            }
        } else if (activationState.equals(ActivationState.INACTIVE)) {
            this.logger.info().append("resultChangeActivationState(not-granted, INACTIVE) ==> starting dialog was rejected by admin ").log();
        }
    }

    @Override
    public void updateApplicantsCount(int n) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.trace();
            logMessage.append("updateApplicantsCount( ").append(n).append(" )");
            logMessage.log();
        }
        this.applicantsCount = n;
        this.stateTracker.updateApplicantsCount(n);
    }

    @Override
    public void cancelActivation() {
        this.ignoreEndTone = true;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("cancelActivation() ==> SDS is going down ignoring end jingle tone").log();
        }
        this.dialogSession.cancel();
    }

    @Override
    public void cancelRequest(int n) {
        if (n == 0) {
            this.dialogSession.cancel();
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("cancelRequest() ==> not handled cancel request reason with id=").append(n).log();
        }
    }

    public boolean ignoreEndTone() {
        return this.ignoreEndTone;
    }

    public void setIgnoreEndTone(boolean bl) {
        this.ignoreEndTone = bl;
    }
}

