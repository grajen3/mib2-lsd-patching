/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.thinkbluetiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTConsumptionModelApiCallback;

public class CarTBTConsumptionModelApiCallbackProxy
extends CarTBTConsumptionModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public CarTBTConsumptionModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getConsumptionTrend(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(2);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentConsumption(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(3);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentConsumptionDecimal(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(4);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentConsumptionUnit(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(5);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentHybridConsumptionUnit(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(6);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

