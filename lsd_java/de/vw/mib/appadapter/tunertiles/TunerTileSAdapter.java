/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tunertiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.tunertiles.GeneralModelApiService;

public class TunerTileSAdapter
extends AbstractAppAdapter
implements CioExecutor,
GeneralModelApiService {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private CioIntent bindHostedApp;
    private CioIntent tileHeaderAction;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService;

    public TunerTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("RegisterEntertainmentTile", "SmallTile");
        if (cioIntent == null) {
            return;
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setInt("EntertainmentContext", 1);
        cioParametersCreator.setCioIntent("BindHostedApp", this.bindHostedApp);
        cioParametersCreator.setCioIntent("TileHeaderButtonAction", this.tileHeaderAction);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_RADIO");
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if ("BindTunerTileS".equals(contentInformationObject.getCioIntentName())) {
            this.bindHostedApp = (CioIntent)((Object)contentInformationObject);
        } else if ("TunerTileSHeaderButtonAction".equals(contentInformationObject.getCioIntentName())) {
            this.tileHeaderAction = (CioIntent)((Object)contentInformationObject);
        }
        return true;
    }

    @Override
    public void _mda_switchSource() {
        EntertainmentManagerService entertainmentManagerService = (EntertainmentManagerService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = TunerTileSAdapter.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService);
        if (null != entertainmentManagerService) {
            entertainmentManagerService.requestContext(2);
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

