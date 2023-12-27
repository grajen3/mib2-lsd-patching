/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.events.commands;

import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

public class RecognitionConsumer
implements RecognizedEventConsumer {
    protected final SystemEventDispatcher eventDispatcher;
    protected final int responseEvent;

    public RecognitionConsumer(SystemEventDispatcher systemEventDispatcher, int n) {
        this.eventDispatcher = systemEventDispatcher;
        this.responseEvent = n;
    }

    @Override
    public void onRecognizedEvent(int n) {
        this.informModel();
    }

    private void informModel() {
        this.eventDispatcher.createAndSubmitHMIEvent(this.responseEvent);
    }
}

