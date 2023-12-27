/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.media;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.media.EnterModelApiCallback;

public class EnterModelApiCallbackProxy
extends EnterModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public EnterModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _on_appMediaEnterShowBluetoothMediaDeviceSelection() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

