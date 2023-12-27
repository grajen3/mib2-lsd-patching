/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.speechsetup;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.speechsetup.SettingsViewModelService;
import de.vw.mib.appadapter.speechsetup.utils.SpeechSetupLogger;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.log4mib.Logger;

public class SpeechSetupAppAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private final SettingsViewModelService settingsViewModelService;
    private final ModelApiService[] modelApiServices;
    private final SpeechSetupLogger logger;

    public SpeechSetupAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        Logger logger = appAdapterSystemServices.getLogger(4096);
        this.logger = new SpeechSetupLogger(logger, 8192, "[[SpS]]");
        this.settingsViewModelService = new SettingsViewModelService(appAdapterSystemServices, this.logger);
        this.modelApiServices = new ModelApiService[]{this.settingsViewModelService};
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return this.modelApiServices;
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 0: {
                this.settingsViewModelService.execute(contentInformationObject, cioActionParameters);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 0: {
                return this.settingsViewModelService.onCioIntentRegistration(contentInformationObject);
            }
        }
        return true;
    }
}

