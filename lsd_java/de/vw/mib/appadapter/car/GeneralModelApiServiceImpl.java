/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioIntent;
import generated.de.vw.mib.appadapter.car.GeneralModelApiService;

public class GeneralModelApiServiceImpl
implements GeneralModelApiService {
    private final AppAdapterSystemServices systemServices;

    public GeneralModelApiServiceImpl(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_showAmbienceLightSetup() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowAmbienceLightView");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    @Override
    public void _mda_showParkHeater() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_PARK_HEATER");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }
}

