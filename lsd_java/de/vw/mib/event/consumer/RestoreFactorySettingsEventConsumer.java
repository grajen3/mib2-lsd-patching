/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.RestoreFactorySettingsEvent;

public interface RestoreFactorySettingsEventConsumer {
    default public void consumeEvent(RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
    }
}

