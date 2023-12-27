/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.tvtunertiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiCallback;

public class TVTunerModelApiCallbackProxy
extends TVTunerModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public TVTunerModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getActiveSource(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentStationName(String string) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setString(0, string);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isAVAvailable(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(2);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isCASDisclaimerVisible(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(3);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isTVTunerStartingDisclaimerVisible(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(4);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isTVTunerNotAvailableDisclaimerVisible(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(5);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

