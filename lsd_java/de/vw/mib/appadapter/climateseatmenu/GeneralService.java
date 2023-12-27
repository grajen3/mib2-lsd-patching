/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import generated.de.vw.mib.appadapter.climateseatmenu.GeneralModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.GeneralModelApiService;

public class GeneralService
implements GeneralModelApiService {
    private AppAdapterSystemServices systemServices;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$GeneralModelApiCallback;

    public GeneralService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    private GeneralModelApiCallback getGeneralModelApiCallback() {
        return (GeneralModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$GeneralModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$GeneralModelApiCallback = GeneralService.class$("generated.de.vw.mib.appadapter.climateseatmenu.GeneralModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$GeneralModelApiCallback);
    }

    private int getModelApiSeatInstance() {
        return this.systemServices.getAppInstanceId();
    }

    private int getSeatMenuSide() {
        return this.getModelApiSeatInstance();
    }

    private int getIndexForMainHeadlineText() {
        int n = ASLCarFactory.getSeatApi().getSeatService().getSeatDriverPosition();
        if (n == this.getSeatMenuSide()) {
            return 0;
        }
        return 1;
    }

    public void start() {
        int n = ASLCarFactory.getSeatApi().getSeatService().getSeatDriverPosition();
        this.getGeneralModelApiCallback()._update_getSeatMenuSide(this.getSeatMenuSide());
        this.getGeneralModelApiCallback()._update_getIndexOfDriver(n);
        this.getGeneralModelApiCallback()._update_isDriver(n == this.getSeatMenuSide());
        this.getGeneralModelApiCallback()._update_getIndexForMainHeadlineText(this.getIndexForMainHeadlineText());
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

