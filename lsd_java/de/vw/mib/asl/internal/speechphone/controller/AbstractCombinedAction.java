/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.genericevents.EventGeneric;

public abstract class AbstractCombinedAction
implements RecognizedEventConsumer,
ModelEventConsumer {
    @Override
    public void onEvent(EventGeneric eventGeneric) {
        this.onAction(eventGeneric.getReceiverEventId());
    }

    @Override
    public void onRecognizedEvent(int n) {
        this.onAction(n);
    }

    protected abstract void onAction(int n) {
    }

    public void triggerManually() {
        this.onAction(0);
    }
}

