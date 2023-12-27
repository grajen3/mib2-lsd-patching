/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tunerautostoreglobalwizardpage;

import de.vw.mib.asl.api.radio.AppAdapterTunerAutoStoreGlobalWizardPageCallback;
import generated.de.vw.mib.appadapter.tunerautostoreglobalwizardpage.InitialModelApiCallback;

public class AppAdapterTunerAutoStoreGlobalWizardPageCallbackImpl
implements AppAdapterTunerAutoStoreGlobalWizardPageCallback {
    private InitialModelApiCallback guiCallback;

    public AppAdapterTunerAutoStoreGlobalWizardPageCallbackImpl(InitialModelApiCallback initialModelApiCallback) {
        this.guiCallback = initialModelApiCallback;
    }

    @Override
    public void _update_getActionResult(int n) {
        if (null != this.guiCallback) {
            this.guiCallback._update_getActionResult(n);
        }
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanCancelled() {
        if (null != this.guiCallback) {
            this.guiCallback._on_appTunerAutostoreGlobalWizardPageInitialScanCancelled();
        }
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanError() {
        if (null != this.guiCallback) {
            this.guiCallback._on_appTunerAutostoreGlobalWizardPageInitialScanError();
        }
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanFinished() {
        if (null != this.guiCallback) {
            this.guiCallback._on_appTunerAutostoreGlobalWizardPageInitialScanFinished();
        }
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanStarted() {
        if (null != this.guiCallback) {
            this.guiCallback._on_appTunerAutostoreGlobalWizardPageInitialScanStarted();
        }
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialSuccessful() {
        if (null != this.guiCallback) {
            this.guiCallback._on_appTunerAutostoreGlobalWizardPageInitialSuccessful();
        }
    }
}

