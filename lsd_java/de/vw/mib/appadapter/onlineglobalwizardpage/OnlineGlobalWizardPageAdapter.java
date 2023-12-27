/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.onlineglobalwizardpage;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.onlineglobalwizardpage.OnlineGlobalWizardPageAdapter$1;
import de.vw.mib.appadapter.onlineglobalwizardpage.modelapi.InformationModelApiServiceImpl;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;

public class OnlineGlobalWizardPageAdapter
extends AbstractAppAdapter
implements CioExecutor {
    public static final int ACTION_INIT_PAGE;
    public static final int ACTION_SUCCESS;
    public static final int ACTION_CANCEL;
    private static final String CIO_INTENT_NAME_INIT_GLOBAL_WIZARD_PAGE;
    private static final String CIO_INTENT_NAME_BIND_HOSTED_APP;
    private final InformationModelApiServiceImpl apiServiceImpl = new InformationModelApiServiceImpl(this);
    private ContentInformationObject currentCioIntentInitGlobalWizardPage = null;
    private ContentInformationObject currentCioIntentBindHostedApp = null;
    private int onlineServiceState = -1;

    public OnlineGlobalWizardPageAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 0: {
                GlobalWizardPage globalWizardPage = (GlobalWizardPage)cioActionParameters.getObject("globalWizardPage");
                this.apiServiceImpl.setGlobalWizardPage(globalWizardPage);
                break;
            }
            case 1: {
                this.apiServiceImpl.success();
                break;
            }
            case 2: {
                this.apiServiceImpl.cancel();
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if ("InitGlobalWizardPage".equals(contentInformationObject.getCioIntentName())) {
            this.currentCioIntentInitGlobalWizardPage = contentInformationObject;
        }
        if ("BindHostedApp".equals(contentInformationObject.getCioIntentName())) {
            this.currentCioIntentBindHostedApp = contentInformationObject;
        }
        return this.onlineServiceState != 0;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this.apiServiceImpl};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
        this.onlineServiceState = ASLOnlineFactory.getOnlineCoreServices().getOnlineServicesAvailabilityStatus();
        this.registerCioIntentIfOnlineServiceAvailable(this.onlineServiceState, this.currentCioIntentInitGlobalWizardPage);
        this.registerCioIntentIfOnlineServiceAvailable(this.onlineServiceState, this.currentCioIntentBindHostedApp);
        ASLOnlineFactory.getOnlineCoreServices().registerForOnlineServicesAvailabilityStatus(new OnlineGlobalWizardPageAdapter$1(this));
    }

    private void registerCioIntentIfOnlineServiceAvailable(int n, ContentInformationObject contentInformationObject) {
        if (contentInformationObject != null) {
            if (n == 0 && !contentInformationObject.isRegistered()) {
                contentInformationObject.register();
            } else if (n == 1 && contentInformationObject.isRegistered()) {
                contentInformationObject.unregister();
            }
        }
    }

    @Override
    public void stop() {
    }

    public void showConnectivitySetup() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowConnectivityConfiguration");
        CioIntent cioIntent2 = this.createCallbackCio(1);
        CioIntent cioIntent3 = this.createCallbackCio(2);
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setCioIntent("Callback_Success", cioIntent2);
        cioParametersCreator.setCioIntent("Callback_Cancel", cioIntent3);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    private CioIntent createCallbackCio(int n) {
        CioCreator cioCreator = this.systemServices.getCioFactory().createCio(this.systemServices.getAppName(), this.systemServices.getAppInstanceName());
        cioCreator.setActionId(n);
        return cioCreator.finishCallbackCioIntent(this);
    }

    public void showGlobalSetupWizard() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_GLOBAL_SETUP_WIZARD");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    static /* synthetic */ ContentInformationObject access$000(OnlineGlobalWizardPageAdapter onlineGlobalWizardPageAdapter) {
        return onlineGlobalWizardPageAdapter.currentCioIntentInitGlobalWizardPage;
    }

    static /* synthetic */ void access$100(OnlineGlobalWizardPageAdapter onlineGlobalWizardPageAdapter, int n, ContentInformationObject contentInformationObject) {
        onlineGlobalWizardPageAdapter.registerCioIntentIfOnlineServiceAvailable(n, contentInformationObject);
    }

    static /* synthetic */ ContentInformationObject access$200(OnlineGlobalWizardPageAdapter onlineGlobalWizardPageAdapter) {
        return onlineGlobalWizardPageAdapter.currentCioIntentBindHostedApp;
    }
}

