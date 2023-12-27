/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.ModelApiEventService$1;
import de.vw.mib.app.framework.internal.ModelApiEventService$2;
import de.vw.mib.app.framework.internal.ModelApiEventService$DownEvent;
import de.vw.mib.app.framework.internal.ModelApiEventService$UpEvent;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;
import de.vw.mib.threads.MIBInvoker;

final class ModelApiEventService {
    private final MIBInvoker hsmTaskInvoker;
    private final MIBInvoker uiThreadInvoker;

    ModelApiEventService(MIBInvoker mIBInvoker, MIBInvoker mIBInvoker2) {
        this.hsmTaskInvoker = mIBInvoker;
        this.uiThreadInvoker = mIBInvoker2;
    }

    ModelApiDownEvent createEvent(int n, ModelApiDownEventHandler modelApiDownEventHandler) {
        return new ModelApiEventService$DownEvent(this, n, modelApiDownEventHandler);
    }

    ModelApiUpEvent createEvent(int n, ModelApiUpEventHandler modelApiUpEventHandler) {
        return new ModelApiEventService$UpEvent(this, n, modelApiUpEventHandler);
    }

    void sendEvent(AppDiagController appDiagController, ModelApiDownEvent modelApiDownEvent) {
        ModelApiEventService$DownEvent modelApiEventService$DownEvent = (ModelApiEventService$DownEvent)modelApiDownEvent;
        if (modelApiEventService$DownEvent.isUnbound()) {
            appDiagController.onModelApiUnboundDownCall(modelApiEventService$DownEvent);
            return;
        }
        appDiagController.onModelApiDownCall(modelApiEventService$DownEvent, 0);
        this.hsmTaskInvoker.invoke(new ModelApiEventService$1(this, appDiagController, modelApiEventService$DownEvent));
    }

    void sendEvent(AppDiagController appDiagController, ModelApiUpEvent modelApiUpEvent) {
        ModelApiEventService$UpEvent modelApiEventService$UpEvent = (ModelApiEventService$UpEvent)modelApiUpEvent;
        if (modelApiEventService$UpEvent.isUnbound()) {
            appDiagController.onModelApiUnboundUpCall(modelApiUpEvent);
            return;
        }
        appDiagController.onModelApiUpCall(modelApiEventService$UpEvent, 0);
        this.uiThreadInvoker.invoke(new ModelApiEventService$2(this, appDiagController, modelApiEventService$UpEvent));
    }
}

