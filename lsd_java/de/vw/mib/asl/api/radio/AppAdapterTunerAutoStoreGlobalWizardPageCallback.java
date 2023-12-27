/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio;

public interface AppAdapterTunerAutoStoreGlobalWizardPageCallback {
    public static final int GET_ACTION_RESULT_ENUM_OK;
    public static final int GET_ACTION_RESULT_ENUM_ERROR;
    public static final int GET_ACTION_RESULT_ENUM_IN_PROGRESS;
    public static final int GET_ACTION_RESULT_ENUM_NOT_TAKEN;

    default public void _update_getActionResult(int n) {
    }

    default public void _on_appTunerAutostoreGlobalWizardPageInitialScanCancelled() {
    }

    default public void _on_appTunerAutostoreGlobalWizardPageInitialScanError() {
    }

    default public void _on_appTunerAutostoreGlobalWizardPageInitialScanFinished() {
    }

    default public void _on_appTunerAutostoreGlobalWizardPageInitialScanStarted() {
    }

    default public void _on_appTunerAutostoreGlobalWizardPageInitialSuccessful() {
    }
}

