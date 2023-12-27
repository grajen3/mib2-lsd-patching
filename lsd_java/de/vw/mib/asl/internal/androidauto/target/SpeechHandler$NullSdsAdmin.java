/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.internal.androidauto.target.SpeechHandler;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;
import de.vw.mib.dialogactivation.SpeechDialogActivationApplicant;

class SpeechHandler$NullSdsAdmin
implements SpeechDialogActivationAdmin {
    private final /* synthetic */ SpeechHandler this$0;

    SpeechHandler$NullSdsAdmin(SpeechHandler speechHandler) {
        this.this$0 = speechHandler;
    }

    @Override
    public void changeActivationState(ActivationState activationState, SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        this.handleNoSDSAdminAvailable();
    }

    @Override
    public void forceActivationStateChange(ActivationState activationState, SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        this.handleNoSDSAdminAvailable();
    }

    @Override
    public void readActivationState(SpeechDialogActivationApplicant speechDialogActivationApplicant) {
        this.handleNoSDSAdminAvailable();
    }

    private void handleNoSDSAdminAvailable() {
        this.this$0.target.error("no SDSAdmin available, cannot start speech");
    }
}

