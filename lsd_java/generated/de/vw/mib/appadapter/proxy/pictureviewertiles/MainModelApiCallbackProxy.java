/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.pictureviewertiles;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.pictureviewertiles.MainModelApiCallback;
import org.dsi.ifc.global.ResourceLocator;

public class MainModelApiCallbackProxy
extends MainModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public MainModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getCurrentImage(ResourceLocator resourceLocator) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setObject(0, resourceLocator);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

