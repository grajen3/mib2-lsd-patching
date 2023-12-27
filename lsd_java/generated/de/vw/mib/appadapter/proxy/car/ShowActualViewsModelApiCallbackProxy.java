/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.car;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.car.ShowActualViewsModelApiCallback;

public class ShowActualViewsModelApiCallbackProxy
extends ShowActualViewsModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public ShowActualViewsModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getToFullScreen(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

