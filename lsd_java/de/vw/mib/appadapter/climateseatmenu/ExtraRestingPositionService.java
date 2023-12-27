/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraRestingPositionModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraRestingPositionModelApiService;

public class ExtraRestingPositionService
implements ExtraRestingPositionModelApiService {
    private AppAdapterSystemServices systemServices;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRestingPositionModelApiCallback;

    public ExtraRestingPositionService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    private ExtraRestingPositionModelApiCallback getExtraRestingPositionModelApiCallback() {
        return (ExtraRestingPositionModelApiCallback)this.systemServices.getModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRestingPositionModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRestingPositionModelApiCallback = ExtraRestingPositionService.class$("generated.de.vw.mib.appadapter.climateseatmenu.ExtraRestingPositionModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRestingPositionModelApiCallback);
    }

    public void start() {
    }

    public void changeSeatExtra(int n, int n2, boolean bl) {
        ASLCarFactory.getSeatApi().getSeatService().changeSeatExtra(n, n2, bl);
    }

    @Override
    public void _mda_buttonRestingPressed() {
        this.changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 4, true);
    }

    @Override
    public void _mda_buttonRestingReleased() {
        this.changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 4, false);
    }

    @Override
    public void _mda_buttonWorkingPressed() {
        this.changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 5, true);
    }

    @Override
    public void _mda_buttonWorkingReleased() {
        this.changeSeatExtra(ASLCarFactory.getSeatApi().getSeatService().getSeatFrontPassengerPosition(), 5, false);
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

