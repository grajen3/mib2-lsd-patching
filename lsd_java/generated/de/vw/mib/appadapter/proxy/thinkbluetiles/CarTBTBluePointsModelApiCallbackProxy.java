/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.thinkbluetiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTBluePointsModelApiCallback;

public class CarTBTBluePointsModelApiCallbackProxy
extends CarTBTBluePointsModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public CarTBTBluePointsModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getBluePointsTrend(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getEcoAverageTrip(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

