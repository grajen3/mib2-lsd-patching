/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.mediatiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;

public class MediaTileSAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private CioIntent bindHostedApp;
    private CioIntent tileHeaderAction;

    public MediaTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[0];
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
        cioParametersCreator.setInt("EntertainmentContext", 2);
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
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_MEDIA");
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if ("BindMediaTileS".equals(contentInformationObject.getCioIntentName())) {
            this.bindHostedApp = (CioIntent)((Object)contentInformationObject);
        } else if ("MediaTileSHeaderButtonAction".equals(contentInformationObject.getCioIntentName())) {
            this.tileHeaderAction = (CioIntent)((Object)contentInformationObject);
        }
        return true;
    }
}

