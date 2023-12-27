/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.navhomeadressglobalwizardpage;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.navhomeadressglobalwizardpage.HomeAdressInputModelApiCallback;

public class HomeAdressInputModelApiCallbackProxy
extends HomeAdressInputModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public HomeAdressInputModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getActionResult(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_isNaviAppAvailable(boolean bl) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setBoolean(0, bl);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _on_appNavHomeAdressGlobalWizardPageHomeAdressInputHomeStored() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(2);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

