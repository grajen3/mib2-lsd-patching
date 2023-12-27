/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.messages.services.detail.MessageResponse;

class TargetASLMessagesService$MessageServiceTask {
    private final int accountId;
    private final String messageId;
    private final MessageResponse callback;

    public TargetASLMessagesService$MessageServiceTask(int n, String string, MessageResponse messageResponse) {
        this.accountId = n;
        this.messageId = string;
        this.callback = messageResponse;
    }

    public String getMessageID() {
        return this.messageId;
    }

    public int getAccountID() {
        return this.accountId;
    }

    public MessageResponse getCallback() {
        return this.callback;
    }
}

