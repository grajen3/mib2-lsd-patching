/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.climateseatmenu.ClimateSeatMenuControlModelApiService;

public class ClimateSeatMenuControlService
implements ClimateSeatMenuControlModelApiService,
CioExecutor {
    private static final String CIO_ACTION_HIDE_PUSHUP_PARAM_CIO;
    private static final String CIO_ACTION_SHOW_POPUP_PARAM_CIO;
    private static final String CIO_ACTION_HIDE_PUSHUP_ACTION_USAGE_LEFT_SEAT_MENU;
    private static final String CIO_ACTION_HIDE_PUSHUP_ACTION_USAGE_RIGHT_SEAT_MENU;
    private static final int CIO_ACTION_HIDE_PUSHUP_INSTANCE;
    private static final int CIO_ACTION_OPEN_POPUP_INSTANCE;
    private CioIntent hidePushUpIntent;
    private CioIntent showPopupIntent;
    private AppAdapterSystemServices systemServices;

    public ClimateSeatMenuControlService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    private Logger getLogger() {
        return this.systemServices.getLogger(0xA004000);
    }

    private String getSeatUseForCurrentInstance() {
        return this.systemServices.getAppInstanceId() == 0 ? "LeftSeatMenu" : "RightSeatMenu";
    }

    private void registerCio() {
        CioCreator cioCreator = this.systemServices.getCioFactory().createCio(this.systemServices.getAppName(), this.systemServices.getAppInstanceName());
        cioCreator.setActionId(0);
        cioCreator.register("InitClimateBarPushup", this.getSeatUseForCurrentInstance(), this);
        CioCreator cioCreator2 = this.systemServices.getCioFactory().createCio(this.systemServices.getAppName(), this.systemServices.getAppInstanceName());
        cioCreator2.setActionId(1);
        cioCreator2.register("InitClimateBarPushup", this.getSeatUseForCurrentInstance(), this);
    }

    void start() {
        this.registerCio();
    }

    @Override
    public void _mda_hidePushup() {
        if (this.hidePushUpIntent != null) {
            this.systemServices.getCioDispatcher().dispatch(this.hidePushUpIntent);
        } else {
            this.getLogger().error(256).append("hidePushUpIntent is null, can't close pushup").log();
        }
    }

    @Override
    public void _mda_showPopup() {
        if (this.showPopupIntent != null) {
            this.systemServices.getCioDispatcher().dispatch(this.showPopupIntent);
        } else {
            this.getLogger().error(256).append("showPopupIntent is null, can't open popup").log();
        }
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if (contentInformationObject.getActionId() == 0) {
            this.hidePushUpIntent = cioActionParameters.getCioIntent("HidePushupAction");
        } else if (contentInformationObject.getActionId() == 1) {
            this.showPopupIntent = cioActionParameters.getCioIntent("ShowPopupAction");
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

