/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navmaptile;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.navmaptile.GeneralModelApiService;

public class NavMapTileAdapter
extends AbstractAppAdapter
implements CioExecutor,
GeneralModelApiService {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final String ENTRY_MODE;
    private static final String NAVIGATION;

    public NavMapTileAdapter(AppAdapterSystemServices appAdapterSystemServices) {
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
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowNavView");
                CioActionParameters cioActionParameters2 = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("EntryMode", "Navigation").finishActionParams();
                this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters2);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void _mda_navMapTileEnterNavContext() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowNavView");
        CioActionParameters cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("EntryMode", "Navigation").finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }
}

