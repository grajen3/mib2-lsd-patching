/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraTidyUpModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraTidyUpModelApiService;

public class ExtraTidyUpService
implements ExtraTidyUpModelApiService {
    private AppAdapterSystemServices systemServices;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraTidyUpModelApiCallback;

    public ExtraTidyUpService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_buttonTidyUpPressed() {
        this.getLogger().info(256).append("_mda_buttonTidyUpPressed() called").log();
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(0, 1, true);
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(1, 1, true);
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(2, 1, true);
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(3, 1, true);
    }

    @Override
    public void _mda_buttonTidyUpReleased() {
        this.getLogger().info(256).append("_mda_buttonTidyUpReleased() called").log();
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(0, 1, false);
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(1, 1, false);
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(2, 1, false);
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(3, 1, false);
    }

    private ExtraTidyUpModelApiCallback getExtraTidyUpModelApiCallback() {
        return (ExtraTidyUpModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraTidyUpModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraTidyUpModelApiCallback = ExtraTidyUpService.class$("generated.de.vw.mib.appadapter.climateseatmenu.ExtraTidyUpModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraTidyUpModelApiCallback);
    }

    public void start() {
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(256);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

