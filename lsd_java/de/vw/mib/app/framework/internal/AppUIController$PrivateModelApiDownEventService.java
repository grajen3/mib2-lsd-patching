/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;

final class AppUIController$PrivateModelApiDownEventService
implements ModelApiDownEventService {
    private final AppDiagController appDiag;
    private ModelApiDownEventHandler modelApiDownEventHandler;
    private final ModelApiEventService modelApiEventService;
    private final /* synthetic */ AppUIController this$0;

    AppUIController$PrivateModelApiDownEventService(AppUIController appUIController, AppDiagController appDiagController, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.this$0 = appUIController;
        this.appDiag = appDiagController;
        this.modelApiEventService = services$EventDispatcherServices.getModelApiEventService();
    }

    @Override
    public ModelApiDownEvent createEvent(int n) {
        return this.modelApiEventService.createEvent(n, this.modelApiDownEventHandler);
    }

    @Override
    public void sendEvent(ModelApiDownEvent modelApiDownEvent) {
        this.modelApiEventService.sendEvent(this.appDiag, modelApiDownEvent);
    }

    void setModelApiDownEventHandler(ModelApiDownEventHandler modelApiDownEventHandler) {
        this.modelApiDownEventHandler = modelApiDownEventHandler;
    }
}

