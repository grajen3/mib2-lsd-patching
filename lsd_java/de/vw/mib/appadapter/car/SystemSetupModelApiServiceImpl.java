/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import generated.de.vw.mib.appadapter.car.SystemSetupModelApiService;

public class SystemSetupModelApiServiceImpl
implements SystemSetupModelApiService {
    private final AppAdapterSystemServices systemServices;

    public SystemSetupModelApiServiceImpl(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_showDateTimeView() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSetup", "DateTimeSetup");
        this.systemServices.getCioDispatcher().dispatch(cioIntent, this.getBackCioAction(cioIntent));
    }

    @Override
    public void _mda_showUnitsView() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSetup", "UnitsSetup");
        this.systemServices.getCioDispatcher().dispatch(cioIntent, this.getBackCioAction(cioIntent));
    }

    private CioActionParameters getBackCioAction(CioIntent cioIntent) {
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setCioIntent("BackButtonAction", this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_CAR"));
        return cioParametersCreator.finishActionParams();
    }
}

