/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.messages2;

import de.vw.mib.asl.internal.speechphone.messages2.MessageAction;

class MessageAction$UnreadMessage {
    public final String messageID;
    public final int accountId;
    private final /* synthetic */ MessageAction this$0;

    public MessageAction$UnreadMessage(MessageAction messageAction, int n, String string) {
        this.this$0 = messageAction;
        this.accountId = n;
        this.messageID = string;
    }
}

