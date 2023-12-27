/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.carstatustiles.GeneralModelApiService;

public class GeneralService
implements GeneralModelApiService,
CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final String CIO_ACTION_SHOW_CAR_VIEW_PARAM__CONTEXT;
    private static final String CAR_STATUS_MAIN_VIEW;
    private static final String CAR_STATUS_OIL_VIEW;
    private static final String CAR_STATUS_TIRES_VIEW;
    private final AppAdapterSystemServices systemServices;
    private int currentPageId = 0;
    private static final String HEADER_BUTTON_CIO_NAME;
    private static final String HEADER_BUTTON_INTENT_NAME_MAIN;
    private static final String HEADER_BUTTON_INTENT_NAME_TIRES;
    private static final String HEADER_BUTTON_INTENT_NAME_OIL;
    private final IntObjectMap id2Cio = new IntObjectOptHashMap(3);

    public GeneralService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private void showCarView() {
        CioActionParameters cioActionParameters;
        CioIntent cioIntent;
        switch (this.currentPageId) {
            case 0: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarStatusMainView").finishActionParams();
                break;
            }
            case 1: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarStatusTiresView").finishActionParams();
                break;
            }
            case 2: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarStatusOilView").finishActionParams();
                break;
            }
            default: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarStatusMainView").finishActionParams();
            }
        }
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    @Override
    public void _mda_carStatusFullScreen() {
        this.showCarView();
    }

    @Override
    public void _mda_setCurrentPageByIndex(int n) {
        if (!this.id2Cio.containsKey(n)) {
            this.getLogger().error(0xA004000, new StringBuffer().append("error with switching visualization from ").append(this.currentPageId).append(" to ").append(n).toString());
            return;
        }
        ContentInformationObject contentInformationObject = (ContentInformationObject)this.id2Cio.get(this.currentPageId);
        contentInformationObject.unregister();
        ContentInformationObject contentInformationObject2 = (ContentInformationObject)this.id2Cio.get(n);
        contentInformationObject2.register();
        this.currentPageId = n;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                this.showCarView();
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if (contentInformationObject.getCioName().equals("CarStatusTileSHeaderButtonAction")) {
            int n = 0;
            if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction1")) {
                n = 0;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction2")) {
                n = 1;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction3")) {
                n = 2;
            }
            this.id2Cio.put(n, contentInformationObject);
            if (n != this.currentPageId) {
                return true;
            }
        }
        return false;
    }
}

