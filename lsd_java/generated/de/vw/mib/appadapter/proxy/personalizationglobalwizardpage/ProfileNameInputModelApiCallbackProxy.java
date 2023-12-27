/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.personalizationglobalwizardpage;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiCallback;

public class ProfileNameInputModelApiCallbackProxy
extends ProfileNameInputModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public ProfileNameInputModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
        this.modelApiUpEventService = modelApiUpEventService;
    }

    public ModelApiUpEventService getModelApiUpEventService() {
        return this.modelApiUpEventService;
    }

    @Override
    public void _update_getProfileName(String string) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(0);
        modelApiUpEvent.setString(0, string);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _update_getProfileType(int n) {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(1);
        modelApiUpEvent.setInt(0, n);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

