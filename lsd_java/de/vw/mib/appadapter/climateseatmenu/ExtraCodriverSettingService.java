/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraCodriverSettingModelApiService;

public class ExtraCodriverSettingService
implements ExtraCodriverSettingModelApiService {
    private AppAdapterSystemServices systemServices;

    public ExtraCodriverSettingService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_extraCodriverSettingTriggered(boolean bl) {
        if (bl) {
            ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 3, true);
        } else {
            ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 3, false);
        }
    }

    public void start() {
    }
}

