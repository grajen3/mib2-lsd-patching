/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dialogactivation;

import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationAdmin;

public interface SpeechDialogActivationApplicant {
    public static final int CANCEL_REQUEST_REASON_POPUP_STOPS_SPEECH_GOT_ACTIVE;

    default public void setAdmin(SpeechDialogActivationAdmin speechDialogActivationAdmin) {
    }

    default public void updateApplicantsCount(int n) {
    }

    default public void resultChangeActivationState(boolean bl, ActivationState activationState) {
    }

    default public void resultReadActivationState(ActivationState activationState) {
    }

    default public void cancelActivation() {
    }

    default public void cancelRequest(int n) {
    }

    default public void updateActivationState(ActivationState activationState) {
    }
}

