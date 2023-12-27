/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.AnimationEvent;

public interface AnimationEventConsumer {
    default public void consumeEvent(AnimationEvent animationEvent) {
    }
}

