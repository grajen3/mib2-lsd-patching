/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tvtunertiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.tvtunertiles.listener.TVTunerTileSComponentHandler;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiCallback;

public class TVTunerTileSAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private CioIntent bindHostedApp;
    private CioIntent tileHeaderAction;
    private TVTunerModelApiCallback modelCallback;
    private TVTunerTileSComponentHandler componentHandler;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiCallback;

    public TVTunerTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.modelCallback = (TVTunerModelApiCallback)appAdapterSystemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiCallback = TVTunerTileSAdapter.class$("generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiCallback")) : class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiCallback);
        this.componentHandler = new TVTunerTileSComponentHandler(this.modelCallback);
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_TVTUNER");
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if ("BindTVTunerTileS".equals(contentInformationObject.getCioIntentName())) {
            this.bindHostedApp = (CioIntent)((Object)contentInformationObject);
        } else if ("TVTunerTileSHeaderButtonAction".equals(contentInformationObject.getCioIntentName())) {
            this.tileHeaderAction = (CioIntent)((Object)contentInformationObject);
        }
        return true;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this.componentHandler};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void ready() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("RegisterEntertainmentTile", "SmallTile");
        if (cioIntent == null) {
            return;
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setInt("EntertainmentContext", 5);
        cioParametersCreator.setCioIntent("BindHostedApp", this.bindHostedApp);
        cioParametersCreator.setCioIntent("TileHeaderButtonAction", this.tileHeaderAction);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
        this.componentHandler.registerListener();
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
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

