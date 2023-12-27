/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.messages.services.status;

public interface MessagesUpdates {
    default public void onNewMessage(int n, String string) {
    }

    default public void onMessageRead(String string) {
    }
}

