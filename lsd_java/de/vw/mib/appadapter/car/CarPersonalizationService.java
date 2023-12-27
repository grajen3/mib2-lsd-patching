/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.car.PersonalizationModelApiCallback;
import generated.de.vw.mib.appadapter.car.PersonalizationModelApiService;

public class CarPersonalizationService
implements PersonalizationModelApiService,
CioExecutor {
    private static final int CIO_ACTION_ENTER_PROFILE_NAME;
    private static final String CIO_ACTION_ENTER_PROFILE_NAME_PARAM_PROFILE_NAME;
    private static final String CIO_ACTION_ENTER_PROFILE_NAME_PARAM_RESULT;
    private static final String CIO_ACTION_PROFILE_NAME_RESULT;
    private CioIntent resultCioIntent;
    private AppAdapterSystemServices systemServices;
    PersonalizationModelApiCallback modelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback;

    public CarPersonalizationService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.modelApiCallback = (PersonalizationModelApiCallback)this.systemServices.getModelApiClient(class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback = CarPersonalizationService.class$("generated.de.vw.mib.appadapter.car.PersonalizationModelApiCallback")) : class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback);
    }

    private void registerCio() {
    }

    void start() {
        this.registerCio();
        this.getPersonalizationModelApiCallback()._update_getProfileName("");
    }

    private Logger getLogger() {
        return this.systemServices.getLogger(0xA004000);
    }

    private PersonalizationModelApiCallback getPersonalizationModelApiCallback() {
        return (PersonalizationModelApiCallback)this.systemServices.getModelApiClient(class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback = CarPersonalizationService.class$("generated.de.vw.mib.appadapter.car.PersonalizationModelApiCallback")) : class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiCallback);
    }

    private void showCarContextAndGoOutOfTheGlobalSetupWizard() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_CAR");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    @Override
    public void _mda_finishEnterProfileName(String string) {
        if (this.resultCioIntent != null) {
            CioActionParameters cioActionParameters = this.systemServices.getCioFactory().createActionParameters(this.resultCioIntent).setString("ProfileNameResult", string).finishActionParams();
            this.systemServices.getCioDispatcher().dispatch(this.resultCioIntent, cioActionParameters);
            this.resultCioIntent = null;
            this.getPersonalizationModelApiCallback()._update_getProfileName("");
        } else {
            this.getLogger().error(1024).append("resultCioIntent is null, can't return result of").log();
        }
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 0: {
                String string = cioActionParameters.getString("CurrentProfileName");
                this.resultCioIntent = cioActionParameters.getCioIntent("Result");
                this.getPersonalizationModelApiCallback()._update_getProfileName(string);
                this.showCarContextAndGoOutOfTheGlobalSetupWizard();
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

