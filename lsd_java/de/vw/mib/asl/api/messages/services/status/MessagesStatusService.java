/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.messages.services.status;

import de.vw.mib.asl.api.messages.services.detail.MessageKey;
import de.vw.mib.asl.api.messages.services.status.MessagesUpdates;

public interface MessagesStatusService {
    default public void register(MessagesUpdates messagesUpdates) {
    }

    default public MessageKey[] registerWithHistory(MessagesUpdates messagesUpdates) {
    }

    default public MessageKey[] getMessageHistory() {
    }

    default public void unregister(MessagesUpdates messagesUpdates) {
    }

    default public void markMessageRead(int n, String string) {
    }

    default public void markMessageRead(MessageKey messageKey) {
    }
}

