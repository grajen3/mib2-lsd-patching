/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.app.framework.internal.ModelApiEventService$UpEvent;

class ModelApiEventService$2
implements Runnable {
    private final /* synthetic */ AppDiagController val$appDiagController;
    private final /* synthetic */ ModelApiEventService$UpEvent val$upEvent;
    private final /* synthetic */ ModelApiEventService this$0;

    ModelApiEventService$2(ModelApiEventService modelApiEventService, AppDiagController appDiagController, ModelApiEventService$UpEvent modelApiEventService$UpEvent) {
        this.this$0 = modelApiEventService;
        this.val$appDiagController = appDiagController;
        this.val$upEvent = modelApiEventService$UpEvent;
    }

    @Override
    public void run() {
        this.val$appDiagController.onModelApiUpCall(this.val$upEvent, 1);
        this.val$upEvent.dispatch();
    }
}

