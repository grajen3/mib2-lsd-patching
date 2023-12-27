/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.app.framework.internal.ModelApiEventService$BaseModelApiEvent;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;

final class ModelApiEventService$DownEvent
extends ModelApiEventService$BaseModelApiEvent
implements ModelApiDownEvent {
    private final ModelApiDownEventHandler eventHandler;
    private final /* synthetic */ ModelApiEventService this$0;

    ModelApiEventService$DownEvent(ModelApiEventService modelApiEventService, int n, ModelApiDownEventHandler modelApiDownEventHandler) {
        this.this$0 = modelApiEventService;
        super(modelApiEventService, n);
        this.eventHandler = modelApiDownEventHandler;
    }

    void dispatch() {
        this.eventHandler.onModelApiDownEvent(this);
    }

    @Override
    boolean isUnbound() {
        return this.eventHandler == null;
    }
}

