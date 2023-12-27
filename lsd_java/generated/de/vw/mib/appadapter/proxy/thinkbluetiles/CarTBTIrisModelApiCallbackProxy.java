/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.thinkbluetiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTIrisModelApiCallback;

public class CarTBTIrisModelApiCallbackProxy
extends CarTBTIrisModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public CarTBTIrisModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getBluePoints(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(7);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentAcceleration(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(8);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentGear(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(9);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentIrisSegment(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(10);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getDisplayDurationHintIcon(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(11);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getDrivingBehaviorMode(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(12);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getIrisSegmentsValues(int[] nArray) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(13);
        modelApiUpEvent.setObject(0, nArray);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getMaxAcceleration(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(14);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getRecommendedGear(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(15);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

