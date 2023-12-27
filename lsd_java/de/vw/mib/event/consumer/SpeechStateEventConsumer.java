/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.SpeechStateEvent;

public interface SpeechStateEventConsumer {
    default public void consumeEvent(SpeechStateEvent speechStateEvent) {
    }
}

