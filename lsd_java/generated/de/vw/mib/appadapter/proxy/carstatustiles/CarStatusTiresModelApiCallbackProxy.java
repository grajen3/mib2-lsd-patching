/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.carstatustiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusTiresModelApiCallback;

public class CarStatusTiresModelApiCallbackProxy
extends CarStatusTiresModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public CarStatusTiresModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getRDKSystem(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(5);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getRKA_RDKS_States(boolean[] blArray) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(6);
        modelApiUpEvent.setObject(0, blArray);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isRDKSFSGControlOn(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(7);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getRDKSTires(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(8);
        modelApiUpEvent.setInt(0, n);
        modelApiUpEvent.setInt(1, n2);
        modelApiUpEvent.setInt(2, n3);
        modelApiUpEvent.setInt(3, n4);
        modelApiUpEvent.setInt(4, n5);
        modelApiUpEvent.setInt(5, n6);
        modelApiUpEvent.setInt(6, n7);
        modelApiUpEvent.setInt(7, n8);
        modelApiUpEvent.setInt(8, n9);
        modelApiUpEvent.setInt(9, n10);
        modelApiUpEvent.setInt(10, n11);
        modelApiUpEvent.setInt(11, n12);
        modelApiUpEvent.setInt(12, n13);
        modelApiUpEvent.setInt(13, n14);
        modelApiUpEvent.setInt(14, n15);
        modelApiUpEvent.setInt(15, n16);
        modelApiUpEvent.setInt(16, n17);
        modelApiUpEvent.setInt(17, n18);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

