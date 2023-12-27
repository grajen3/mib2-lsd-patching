/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.speechsetup;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.speechsetup.utils.SpeechSetupLogger;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.speechsetup.SettingsViewModelApiService;

public class SettingsViewModelService
implements SettingsViewModelApiService,
CioExecutor {
    private static final String PREFIX;
    private CioIntent backButtonCio = null;
    private final AppAdapterSystemServices appAdapterSystemServices;
    private final SpeechSetupLogger logger;

    SettingsViewModelService(AppAdapterSystemServices appAdapterSystemServices, SpeechSetupLogger speechSetupLogger) {
        this.appAdapterSystemServices = appAdapterSystemServices;
        this.logger = speechSetupLogger;
    }

    @Override
    public void _mda_backTriggered() {
        CioIntent cioIntent;
        if (this.backButtonCio != null) {
            cioIntent = this.backButtonCio;
        } else {
            cioIntent = this.appAdapterSystemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_MENU");
            this.logger.warn().append("[SettingsViewModelService] ").append("Back Button CIO was not set. Return to main menu.").log();
        }
        this.appAdapterSystemServices.getCioDispatcher().dispatch(cioIntent);
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 0: {
                this.backButtonCio = cioActionParameters.getCioIntent("BackButtonAction");
                CioIntent cioIntent = this.appAdapterSystemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_SPEECHSETUP");
                this.appAdapterSystemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

