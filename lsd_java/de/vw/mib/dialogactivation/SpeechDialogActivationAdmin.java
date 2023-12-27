/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dialogactivation;

import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.dialogactivation.SpeechDialogActivationApplicant;

public interface SpeechDialogActivationAdmin {
    default public void changeActivationState(ActivationState activationState, SpeechDialogActivationApplicant speechDialogActivationApplicant) {
    }

    default public void readActivationState(SpeechDialogActivationApplicant speechDialogActivationApplicant) {
    }

    default public void forceActivationStateChange(ActivationState activationState, SpeechDialogActivationApplicant speechDialogActivationApplicant) {
    }
}

