/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.appconnecttilesmedia;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.appconnecttiles.AppConnectModelApiCallback;

public class AppConnectModelApiCallbackProxy
extends AppConnectModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public AppConnectModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getCurrentActiveConnectionMethod(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getCurrentActiveDeviceName(String string) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setString(0, string);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isSwapUpdated(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(2);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

