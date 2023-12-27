/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.tunerautostoreglobalwizardpage;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.tunerautostoreglobalwizardpage.InitialModelApiCallback;

public class InitialModelApiCallbackProxy
extends InitialModelApiCallback {
    private final ModelApiUpEventService modelApiUpEventService;

    public InitialModelApiCallbackProxy(ModelApiUpEventService modelApiUpEventService, AppDefinition appDefinition, Logger logger) {
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
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanCancelled() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(3);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanError() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(4);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanFinished() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(5);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialScanStarted() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(6);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }

    @Override
    public void _on_appTunerAutostoreGlobalWizardPageInitialSuccessful() {
        ModelApiUpEvent modelApiUpEvent = this.modelApiUpEventService.createEvent(7);
        this.modelApiUpEventService.sendEvent(modelApiUpEvent);
    }
}

