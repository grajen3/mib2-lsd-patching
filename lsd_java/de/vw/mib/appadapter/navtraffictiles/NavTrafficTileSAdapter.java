/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navtraffictiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

public class NavTrafficTileSAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final String ENTRY_MODE;
    private static final String TRAFFIC;

    public NavTrafficTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
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
                CioActionParameters cioActionParameters2 = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("EntryMode", "Traffic").finishActionParams();
                this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters2);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

