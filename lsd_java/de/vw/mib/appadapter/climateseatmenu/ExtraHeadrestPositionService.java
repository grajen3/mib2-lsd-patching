/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraHeadrestPositionModelApiService;

public class ExtraHeadrestPositionService
implements ExtraHeadrestPositionModelApiService {
    private AppAdapterSystemServices systemServices;

    public ExtraHeadrestPositionService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_tidyUpTriggered() {
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 2, true);
    }

    @Override
    public void _mda_undoTriggered() {
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 2, false);
    }

    public void start() {
    }
}

