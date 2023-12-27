/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.app.framework.internal.ModelApiEventService$DownEvent;

class ModelApiEventService$1
implements Runnable {
    private final /* synthetic */ AppDiagController val$appDiagController;
    private final /* synthetic */ ModelApiEventService$DownEvent val$downEvent;
    private final /* synthetic */ ModelApiEventService this$0;

    ModelApiEventService$1(ModelApiEventService modelApiEventService, AppDiagController appDiagController, ModelApiEventService$DownEvent modelApiEventService$DownEvent) {
        this.this$0 = modelApiEventService;
        this.val$appDiagController = appDiagController;
        this.val$downEvent = modelApiEventService$DownEvent;
    }

    @Override
    public void run() {
        this.val$appDiagController.onModelApiDownCall(this.val$downEvent, 1);
        this.val$downEvent.dispatch();
    }
}

