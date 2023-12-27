/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climatebar;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.log4mib.Logger;

public class ClimateBarSeatControlService
implements ModelApiService,
CioExecutor,
CioRegistrationListener {
    private static final String CIO_ACTION_HIDE_PUSHUP_PARAM_CIO;
    private static final String CIO_ACTION_HIDE_PUSHUP_ACTION_USAGE_LEFT_SEAT_MENU;
    private static final String CIO_ACTION_HIDE_PUSHUP_ACTION_USAGE_RIGHT_SEAT_MENU;
    private static final int CIO_ACTION_HIDE_PUSHUP_INSTANCE;
    private final AppAdapterSystemServices systemServices;

    public ClimateBarSeatControlService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    private Logger getLogger() {
        return this.systemServices.getLogger(0xA004000);
    }

    private void initCioIntents(CioIntent cioIntent) {
        CioCreator cioCreator = this.systemServices.getCioFactory().createCio(this.systemServices.getAppName(), this.systemServices.getAppInstanceName());
        cioCreator.setPayloadData(cioIntent.getUsage());
        CioIntent cioIntent2 = cioCreator.finishCallbackCioIntent(this);
        CioActionParameters cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setCioIntent("HidePushupAction", cioIntent2).finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    private boolean usageSupported(String string) {
        return string.compareTo("LeftSeatMenu") == 0 || string.compareTo("RightSeatMenu") == 0;
    }

    private void initializeSeatCioIntents() {
        this.systemServices.getCioDictionary().addCioRegistrationListener("InitClimateBarPushup", this);
    }

    public void start() {
        this.initializeSeatCioIntents();
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        if (contentInformationObject.getActionId() == 0) {
            String string = (String)((CioIntent)((Object)contentInformationObject)).getPayloadData();
            if (!"LeftSeatMenu".equals(string) && !"RightSeatMenu".equals(string)) {
                this.getLogger().error(128).append("Got wrong seat instance ID during CIO execution").log();
            }
        } else {
            this.getLogger().error(128).append("Got wrong CIO actionId during CIO execution").log();
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void cioRegistered(String string, CioIntent cioIntent) {
        if ("InitClimateBarPushup".compareTo(string) == 0 && this.usageSupported(cioIntent.getUsage())) {
            this.initCioIntents(cioIntent);
        }
    }

    @Override
    public void cioUnregistered(String string, CioIntent cioIntent) {
    }
}

