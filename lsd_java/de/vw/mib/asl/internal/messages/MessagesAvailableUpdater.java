/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.messages.services.available.MessageAvailableService;
import de.vw.mib.asl.api.messages.services.available.MessagesAvailableUpdate;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import java.util.HashMap;
import java.util.Iterator;

public class MessagesAvailableUpdater
implements MessageAvailableService {
    private final HashMap listeners = new HashMap();
    private boolean available = false;

    public void onAvailableChanged(boolean bl) {
        if (this.available != bl) {
            this.available = bl;
            Iterator iterator = this.listeners.values().iterator();
            while (iterator.hasNext()) {
                MessagesAvailableUpdate messagesAvailableUpdate = (MessagesAvailableUpdate)iterator.next();
                messagesAvailableUpdate.onAvailableChanged(bl);
            }
        }
    }

    @Override
    public void register(MessagesAvailableUpdate messagesAvailableUpdate) {
        MessagesAvailableUpdate messagesAvailableUpdate2 = (MessagesAvailableUpdate)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(messagesAvailableUpdate);
        this.listeners.put(messagesAvailableUpdate, messagesAvailableUpdate2);
        messagesAvailableUpdate2.onAvailableChanged(this.available);
    }

    @Override
    public void unregister(MessagesAvailableUpdate messagesAvailableUpdate) {
        this.listeners.remove(messagesAvailableUpdate);
    }
}

