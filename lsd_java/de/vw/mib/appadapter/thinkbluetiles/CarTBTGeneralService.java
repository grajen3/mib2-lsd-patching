/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.thinkbluetiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTGeneralModelApiService;

public class CarTBTGeneralService
implements CarTBTGeneralModelApiService {
    private AppAdapterSystemServices systemServices;

    public CarTBTGeneralService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
    }

    @Override
    public void _mda_thinkBlueFullScreen() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
        CioActionParameters cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarTbtView").finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }
}

