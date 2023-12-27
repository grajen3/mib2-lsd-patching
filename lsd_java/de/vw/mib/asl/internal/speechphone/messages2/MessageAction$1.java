/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.messages2;

import de.vw.mib.asl.internal.speechphone.messages2.MessageAction;

class MessageAction$1
implements Runnable {
    private final /* synthetic */ MessageAction this$0;

    MessageAction$1(MessageAction messageAction) {
        this.this$0 = messageAction;
    }

    @Override
    public void run() {
        this.this$0.connections.systemEventDispatcher().createAndSubmitHMIEvent(-727106816);
    }
}

