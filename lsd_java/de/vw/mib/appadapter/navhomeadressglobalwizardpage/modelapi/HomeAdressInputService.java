/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navhomeadressglobalwizardpage.modelapi;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.navhomeadressglobalwizardpage.NavHomeAdressGlobalWizardPageAdapter;
import de.vw.mib.appadapter.navhomeadressglobalwizardpage.cio.IntentSetNavHomeAddress;
import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioIntentChangeListener;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import generated.de.vw.mib.appadapter.navhomeadressglobalwizardpage.HomeAdressInputModelApiCallback;
import generated.de.vw.mib.appadapter.navhomeadressglobalwizardpage.HomeAdressInputModelApiService;

public class HomeAdressInputService
implements HomeAdressInputModelApiService,
CioIntentChangeListener,
INavServiceStateListener {
    private HomeAdressInputModelApiCallback callback;
    private IntentSetNavHomeAddress intentShowHomeAddressInput;
    private IntentSetNavHomeAddress intentSetHomeAddressToCCP;
    private ASLNavigationAPI navapi;
    public boolean isTest = false;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$navhomeadressglobalwizardpage$HomeAdressInputModelApiCallback;

    public void ready() {
        this.callback = (HomeAdressInputModelApiCallback)NavHomeAdressGlobalWizardPageAdapter.getSystemServices().createModelApiClient(class$generated$de$vw$mib$appadapter$navhomeadressglobalwizardpage$HomeAdressInputModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$navhomeadressglobalwizardpage$HomeAdressInputModelApiCallback = HomeAdressInputService.class$("generated.de.vw.mib.appadapter.navhomeadressglobalwizardpage.HomeAdressInputModelApiCallback")) : class$generated$de$vw$mib$appadapter$navhomeadressglobalwizardpage$HomeAdressInputModelApiCallback);
        if (this.navapi == null && !this.isTest) {
            try {
                this.navapi = ASLNavigationFactory.getNavigationApi();
                this.navapi.registerNavServiceStateListener(this);
                this.callback._update_isNaviAppAvailable(this.navapi.getNavigationServiceState() == 100);
            }
            catch (Exception exception) {
                this.callback._update_isNaviAppAvailable(false);
            }
        }
    }

    @Override
    public void _mda_enterAddress() {
        if (this.intentShowHomeAddressInput != null) {
            this.intentShowHomeAddressInput.createAndDispatch();
        }
    }

    @Override
    public void _mda_setCCP() {
        if (this.intentSetHomeAddressToCCP != null) {
            this.intentSetHomeAddressToCCP.createAndDispatch();
        }
    }

    private CioIntent createBackIntent(int n) {
        AppAdapterSystemServices appAdapterSystemServices = NavHomeAdressGlobalWizardPageAdapter.getSystemServices();
        CioFactory cioFactory = appAdapterSystemServices.getCioFactory();
        CioCreator cioCreator = cioFactory.createCio(appAdapterSystemServices.getAppName(), appAdapterSystemServices.getAppInstanceName());
        cioCreator.setActionId(n);
        return cioCreator.finishCallbackCioIntent(NavHomeAdressGlobalWizardPageAdapter.getExecutor());
    }

    public void callbackFromEnterAddress(int n, GlobalWizardPage globalWizardPage) {
        AppAdapterSystemServices appAdapterSystemServices = NavHomeAdressGlobalWizardPageAdapter.getSystemServices();
        CioIntent cioIntent = appAdapterSystemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_GLOBAL_SETUP_WIZARD");
        appAdapterSystemServices.getCioDispatcher().dispatch(cioIntent);
        switch (n) {
            case 200: {
                this.callback._update_getActionResult(0);
                this.callback._on_appNavHomeAdressGlobalWizardPageHomeAdressInputHomeStored();
                globalWizardPage.markAsFinished();
                break;
            }
            case 201: {
                this.callback._update_getActionResult(1);
                break;
            }
            case 202: {
                this.callback._update_getActionResult(0);
                break;
            }
        }
    }

    public void callbackFromSetCCP(int n, GlobalWizardPage globalWizardPage) {
        switch (n) {
            case 100: {
                this.callback._update_getActionResult(0);
                this.callback._on_appNavHomeAdressGlobalWizardPageHomeAdressInputHomeStored();
                globalWizardPage.markAsFinished();
                break;
            }
            case 101: {
                this.callback._update_getActionResult(1);
                break;
            }
        }
    }

    @Override
    public void cioAvailabilityStateChanged(CioIntent cioIntent, boolean bl) {
        if (this.intentShowHomeAddressInput.equalsIntent(cioIntent)) {
            this.callback._update_isNaviAppAvailable(bl);
        } else if (this.intentSetHomeAddressToCCP.equalsIntent(cioIntent)) {
            this.callback._update_isNaviAppAvailable(bl);
        }
    }

    @Override
    public void navServiceStateChanged() {
        boolean bl = this.navapi.getNavigationServiceState() == 100;
        this.callback._update_isNaviAppAvailable(bl);
        if (bl) {
            this.intentShowHomeAddressInput = new IntentSetNavHomeAddress("Input", this.createBackIntent(200), this.createBackIntent(201), this.createBackIntent(202));
            this.intentSetHomeAddressToCCP = new IntentSetNavHomeAddress("CCP", this.createBackIntent(100), this.createBackIntent(101), null);
        }
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

