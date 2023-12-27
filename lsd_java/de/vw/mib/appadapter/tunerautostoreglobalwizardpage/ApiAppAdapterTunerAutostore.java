/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tunerautostoreglobalwizardpage;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.tunerautostoreglobalwizardpage.AppAdapterTunerAutoStoreGlobalWizardPageCallbackImpl;
import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.AppAdapterTunerAutoStoreGlobalWizardPageCallback;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import generated.de.vw.mib.appadapter.tunerautostoreglobalwizardpage.InitialModelApiCallback;
import generated.de.vw.mib.appadapter.tunerautostoreglobalwizardpage.InitialModelApiService;

public final class ApiAppAdapterTunerAutostore
implements InitialModelApiService {
    private InitialModelApiCallback guiCallback;
    private AppAdapterTunerAutoStoreGlobalWizardPageCallback appCallback;
    private ASLRadioAPI aslRadioApi;
    private GlobalWizardPage globalWizardPage;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$tunerautostoreglobalwizardpage$InitialModelApiCallback;

    public ApiAppAdapterTunerAutostore(AppAdapterSystemServices appAdapterSystemServices) {
        this.guiCallback = (InitialModelApiCallback)appAdapterSystemServices.getModelApiClient(class$generated$de$vw$mib$appadapter$tunerautostoreglobalwizardpage$InitialModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$tunerautostoreglobalwizardpage$InitialModelApiCallback = ApiAppAdapterTunerAutostore.class$("generated.de.vw.mib.appadapter.tunerautostoreglobalwizardpage.InitialModelApiCallback")) : class$generated$de$vw$mib$appadapter$tunerautostoreglobalwizardpage$InitialModelApiCallback);
        this.appCallback = new AppAdapterTunerAutoStoreGlobalWizardPageCallbackImpl(this.guiCallback);
        this.aslRadioApi = ASLRadioFactory.getRadioApi();
        this.setTunerAutostoreAppAdapterCallbackInstance();
    }

    @Override
    public void _mda_startScan() {
        if (null != this.aslRadioApi) {
            this.aslRadioApi.startInitialAutostore();
        }
    }

    @Override
    public void _mda_stopScan() {
        if (null != this.aslRadioApi) {
            this.aslRadioApi.stopInitialAutostore();
        }
    }

    private void setTunerAutostoreAppAdapterCallbackInstance() {
        if (null != this.aslRadioApi) {
            this.aslRadioApi.setAppAdapterTunerAutoStoreGlobalWizardPageCallbackInstance(this.appCallback);
        }
    }

    public void _mda_setupPageReady() {
        if (this.globalWizardPage != null) {
            // empty if block
        }
    }

    public void setGlobalWizardPage(GlobalWizardPage globalWizardPage) {
        this.globalWizardPage = globalWizardPage;
    }

    @Override
    public void _mda_userInformed() {
        if (this.globalWizardPage != null) {
            this.globalWizardPage.markAsFinished();
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

