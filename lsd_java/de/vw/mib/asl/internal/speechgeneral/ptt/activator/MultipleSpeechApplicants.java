/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt.activator;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.AbstractDialogActivator;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.dialogactivation.ActivationState;

public class MultipleSpeechApplicants
extends AbstractDialogActivator {
    private final SpeechGeneralLogger logger;

    public MultipleSpeechApplicants(DialogSession dialogSession, Services services) {
        super("MultipleSpeechApplicants", dialogSession, services);
        this.logger = new SpeechGeneralLogger(new StringBuffer().append("[").append(this.name).append("] ").toString(), 4096);
    }

    @Override
    public void onSinglePressed(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onSinglePressed(n);
        } else {
            this.dialogSession.readSpeechAdminActivationState();
        }
    }

    @Override
    public void onSingleReleased(int n) {
        if (this.dialogSession.isActive()) {
            this.dialogSession.onReleased(n);
        } else if (ActivationState.INACTIVE.equals(this.dialogSession.getLastSpeechAdminActivationState())) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Activate new speech session.").log();
            }
            this.dialogSession.activate();
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("No activation on release event, because another applicant was active at the beginning of user interaction.").log();
        }
    }
}

