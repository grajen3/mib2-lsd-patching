/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

public interface DialogSystemPublisher {
    public static final int DIALOG_STEP_AUDIO_REQUESTING;
    public static final int DIALOG_STEP_DIALOG_BEGIN;
    public static final int DIALOG_STEP_RECOGNITION;
    public static final int DIALOG_STEP_PROMPTING;
    public static final int DIALOG_STEP_PAUSE;
    public static final int DIALOG_STEP_DIALOG_END;
    public static final int DIALOG_STEP_AUDIO_RELEASING;

    default public void onDialogStepStarted(int n) {
    }

    default public void onDialogStepActive(int n) {
    }

    default public void onDialogStepPostProcessing(int n) {
    }

    default public void onDialogStepFinished(int n) {
    }

    default public void onSlotStateChanged(int n, int n2) {
    }

    default public void onApplicationStateChanged(int n) {
    }
}

