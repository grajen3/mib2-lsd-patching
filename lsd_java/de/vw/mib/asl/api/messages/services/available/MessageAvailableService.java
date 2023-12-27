/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.messages.services.available;

import de.vw.mib.asl.api.messages.services.available.MessagesAvailableUpdate;

public interface MessageAvailableService {
    default public void register(MessagesAvailableUpdate messagesAvailableUpdate) {
    }

    default public void unregister(MessagesAvailableUpdate messagesAvailableUpdate) {
    }
}

