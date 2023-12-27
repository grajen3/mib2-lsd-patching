/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tuner;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.tuner.TunerSpaceGesturesModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.tuner.ConnectivityModelApiCallback;
import generated.de.vw.mib.appadapter.tuner.ConnectivityModelApiService;

public class TunerAdapter
extends AbstractAppAdapter
implements CioExecutor,
ConnectivityModelApiService {
    private ConnectivityModelApiCallback guiCallback;
    private TunerSpaceGesturesModelApiService tunerSpaceGesturesModelApiService;
    private CioIntent jumpBackCio = null;
    private static final int JUMP_BACK_ACTION;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$tuner$ConnectivityModelApiCallback;

    public TunerAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.guiCallback = (ConnectivityModelApiCallback)appAdapterSystemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$tuner$ConnectivityModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$tuner$ConnectivityModelApiCallback = TunerAdapter.class$("generated.de.vw.mib.appadapter.tuner.ConnectivityModelApiCallback")) : class$generated$de$vw$mib$appadapter$tuner$ConnectivityModelApiCallback);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this, this.getTunerSpaceGesturesModelApiService()};
        return modelApiServiceArray;
    }

    private TunerSpaceGesturesModelApiService getTunerSpaceGesturesModelApiService() {
        if (this.tunerSpaceGesturesModelApiService == null) {
            this.tunerSpaceGesturesModelApiService = new TunerSpaceGesturesModelApiService(this.systemServices);
        }
        return this.tunerSpaceGesturesModelApiService;
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
        if (5 == n && null != this.guiCallback) {
            this.guiCallback._on_appTunerConnectivityJumpBackToRadioAdvSetup();
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    private CioIntent getJumpBackCio() {
        if (this.jumpBackCio == null) {
            CioCreator cioCreator = this.systemServices.getCioFactory().createCio(this.systemServices.getAppName(), this.systemServices.getAppInstanceName());
            cioCreator.setActionId(5);
            this.jumpBackCio = cioCreator.finishCallbackCioIntent(this.getCioExecutor());
        }
        return this.jumpBackCio;
    }

    @Override
    public void _mda_jumpToNetworkSetup() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSetup", "NetworkingSetup");
        if (cioIntent == null) {
            return;
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setCioIntent("BackButtonAction", this.getJumpBackCio());
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
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

