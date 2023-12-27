/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.SpeechCommandEvent;

public interface ReadOutManagerEventConsumer {
    default public void consumeEvent(SpeechCommandEvent speechCommandEvent) {
    }
}

