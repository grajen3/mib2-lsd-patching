/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.appadapter;

import de.vw.mib.asl.api.radio.AppAdapterTunerAutoStoreGlobalWizardPageCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;

public class ApiAppAdapterGlobalSetupWizard {
    public static AppAdapterTunerAutoStoreGlobalWizardPageCallback appAdapterTunerAutoStoreCallbackInstance;

    public static void setPresetAutoStoreResult(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("setPresetAutoStoreResult: ").append(n).log();
        }
        try {
            if (null != appAdapterTunerAutoStoreCallbackInstance) {
                switch (n) {
                    case 2: {
                        appAdapterTunerAutoStoreCallbackInstance._on_appTunerAutostoreGlobalWizardPageInitialScanStarted();
                        appAdapterTunerAutoStoreCallbackInstance._update_getActionResult(n);
                        break;
                    }
                    case 0: {
                        appAdapterTunerAutoStoreCallbackInstance._on_appTunerAutostoreGlobalWizardPageInitialSuccessful();
                        appAdapterTunerAutoStoreCallbackInstance._on_appTunerAutostoreGlobalWizardPageInitialScanFinished();
                        appAdapterTunerAutoStoreCallbackInstance._update_getActionResult(n);
                        break;
                    }
                    case 1: {
                        appAdapterTunerAutoStoreCallbackInstance._on_appTunerAutostoreGlobalWizardPageInitialScanCancelled();
                        appAdapterTunerAutoStoreCallbackInstance._update_getActionResult(n);
                        break;
                    }
                    default: {
                        appAdapterTunerAutoStoreCallbackInstance._on_appTunerAutostoreGlobalWizardPageInitialScanFinished();
                        appAdapterTunerAutoStoreCallbackInstance._update_getActionResult(0);
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void activateStartScanButton() {
        try {
            if (null != appAdapterTunerAutoStoreCallbackInstance) {
                appAdapterTunerAutoStoreCallbackInstance._update_getActionResult(3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

