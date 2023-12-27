/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.nav;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.nav.HomeAddressInputModelApiCallback;

public class HomeAddressInputModelApiCallbackProxy
extends HomeAddressInputModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public HomeAddressInputModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _on_appNavHomeAddressInputSetupWizardRequest() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

