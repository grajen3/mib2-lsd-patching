/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.app.framework.internal.ModelApiEventService$BaseModelApiEvent;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;

final class ModelApiEventService$UpEvent
extends ModelApiEventService$BaseModelApiEvent
implements ModelApiUpEvent {
    private final ModelApiUpEventHandler eventHandler;
    private final /* synthetic */ ModelApiEventService this$0;

    ModelApiEventService$UpEvent(ModelApiEventService modelApiEventService, int n, ModelApiUpEventHandler modelApiUpEventHandler) {
        this.this$0 = modelApiEventService;
        super(modelApiEventService, n);
        this.eventHandler = modelApiUpEventHandler;
    }

    void dispatch() {
        this.eventHandler.onModelApiUpEvent(this);
    }

    @Override
    boolean isUnbound() {
        return this.eventHandler == null;
    }
}

