/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.personalizationglobalwizardpage;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiServiceImpl$1;
import de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiServiceImpl$2;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import generated.de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiCallback;
import generated.de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiService;

public class ProfileNameInputModelApiServiceImpl
implements ProfileNameInputModelApiService,
CioExecutor {
    private static final String CIO_INTENT_PARAM_NAME_GLOBAL_WIZARD_PAGE;
    private static final String CIO_INTENT_NAME;
    private GlobalWizardPage globalWizardPage;
    private final AppAdapterSystemServices systemServices;
    private static final String CIO_ACTION_ENTER_PROFILE_NAME_PARAM_PROFILE_NAME;
    private static final String CIO_ACTION_ENTER_PROFILE_NAME_PARAM_RESULT;
    private static final String CIO_ACTION_PROFILE_NAME_RESULT;
    private static final int INIT_GLOBAL_WIZARD_PAGE_ID;
    private static final int RESULT_ID;
    protected ProfileNameInputModelApiCallback modelApiCallback;
    protected boolean registerPsoPage;
    protected ComfortViewOptionService comfortViewOptionService;
    protected ContentInformationObject cio;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$personalizationglobalwizardpage$ProfileNameInputModelApiCallback;

    ProfileNameInputModelApiServiceImpl(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.modelApiCallback = (ProfileNameInputModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$personalizationglobalwizardpage$ProfileNameInputModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$personalizationglobalwizardpage$ProfileNameInputModelApiCallback = ProfileNameInputModelApiServiceImpl.class$("generated.de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiCallback")) : class$generated$de$vw$mib$appadapter$personalizationglobalwizardpage$ProfileNameInputModelApiCallback);
    }

    void start() {
        PersonalizationService personalizationService = ASLCarFactory.getCarApi().getCarPersonalizationService();
        this.evaluateIntent(personalizationService.getIsActive());
        personalizationService.addListener(new ProfileNameInputModelApiServiceImpl$1(this));
        int n = personalizationService.getActiveDefaultProfileId();
        String string = personalizationService.getActiveProfileName();
        this.modelApiCallback._update_getProfileName(string);
        this.modelApiCallback._update_getProfileType(n);
        this.comfortViewOptionService = ASLCarFactory.getCarApi().getComfortViewOptionService();
        this.comfortViewOptionService.addListener(new ProfileNameInputModelApiServiceImpl$2(this));
    }

    protected void evaluateIntent(boolean bl) {
        if (!ServiceManager.configManagerDiag.isFeatureFlagSet(19)) {
            bl = false;
        }
        this.registerPsoPage = bl;
        this.cio.setAvailable(bl);
        if (bl) {
            this.cio.register();
        } else {
            this.cio.unregister();
        }
    }

    private CioIntent createCallbackCio() {
        CioCreator cioCreator = this.systemServices.getCioFactory().createCio(this.systemServices.getAppName(), this.systemServices.getAppInstanceName());
        cioCreator.setActionId(2);
        CioIntent cioIntent = cioCreator.finishCallbackCioIntent(this);
        return cioIntent;
    }

    @Override
    public void _mda_enterProfileName(String string) {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("EnterPersonalizationProfileName");
        CioActionParameters cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("CurrentProfileName", string).setCioIntent("Result", this.createCallbackCio()).finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if (contentInformationObject.getActionId() == 0) {
            this.globalWizardPage = (GlobalWizardPage)cioActionParameters.getObject("globalWizardPage");
        } else if (contentInformationObject.getActionId() == 2) {
            String string = cioActionParameters.getString("ProfileNameResult");
            this.modelApiCallback._update_getProfileName(string);
            this.globalWizardPage.showPage();
            this.globalWizardPage.markAsFinished();
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if (contentInformationObject.getCioIntentName().equalsIgnoreCase("InitGlobalWizardPage")) {
            this.cio = contentInformationObject;
            return !this.registerPsoPage;
        }
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

