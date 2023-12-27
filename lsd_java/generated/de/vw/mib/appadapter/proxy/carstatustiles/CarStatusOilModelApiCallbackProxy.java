/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.carstatustiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusOilModelApiCallback;

public class CarStatusOilModelApiCallbackProxy
extends CarStatusOilModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public CarStatusOilModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getOilLevel(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(2);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getOilLevelAvailability(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(3);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getOilWarning(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(4);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

