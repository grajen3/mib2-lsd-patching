/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.drivingdatatiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataModelApiCallback;

public class CarDrivingDataModelApiCallbackProxy
extends CarDrivingDataModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public CarDrivingDataModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getMode(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getPrimaryEngineType(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getSecondaryEngineType(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(2);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getBCMenu1(int[] nArray, int[] nArray2, int[] nArray3) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(4);
        modelApiUpEvent.setObject(0, nArray);
        modelApiUpEvent.setObject(1, nArray2);
        modelApiUpEvent.setObject(2, nArray3);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getBCMenu2(int[] nArray, int[] nArray2, int[] nArray3) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(5);
        modelApiUpEvent.setObject(0, nArray);
        modelApiUpEvent.setObject(1, nArray2);
        modelApiUpEvent.setObject(2, nArray3);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getBCMenu3(int[] nArray, int[] nArray2, int[] nArray3) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(6);
        modelApiUpEvent.setObject(0, nArray);
        modelApiUpEvent.setObject(1, nArray2);
        modelApiUpEvent.setObject(2, nArray3);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getFunctionAvailabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(3);
        modelApiUpEvent.setBoolean(0, bl);
        modelApiUpEvent.setBoolean(1, bl2);
        modelApiUpEvent.setBoolean(2, bl3);
        modelApiUpEvent.setBoolean(3, bl4);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

