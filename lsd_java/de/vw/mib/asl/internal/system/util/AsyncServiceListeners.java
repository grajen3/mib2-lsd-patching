/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.internal.system.util.AsyncServiceListeners$Notificator;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public final class AsyncServiceListeners {
    private final Map listeners = new IdentityHashMap();
    private final AsyncServiceFactory serviceFactory;
    private final Logger log;

    public AsyncServiceListeners(AsyncServiceFactory asyncServiceFactory, Logger logger) {
        AsyncServiceListeners.checkArgumenNotNull(asyncServiceFactory, "serviceFactory");
        AsyncServiceListeners.checkArgumenNotNull(logger, "log");
        this.serviceFactory = asyncServiceFactory;
        this.log = logger;
    }

    public void addListener(Object object) {
        AsyncServiceListeners.checkArgumenNotNull(object, "listener");
        Object object2 = this.serviceFactory.create(object);
        this.listeners.put(object, object2);
    }

    public void removeListener(Object object) {
        this.listeners.remove(object);
    }

    public void notifyListeners(AsyncServiceListeners$Notificator asyncServiceListeners$Notificator) {
        AsyncServiceListeners.checkArgumenNotNull(asyncServiceListeners$Notificator, "notificator");
        Iterator iterator = this.listeners.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            Object object = map$Entry.getKey();
            Object object2 = map$Entry.getValue();
            try {
                asyncServiceListeners$Notificator.notifyListener(object2);
            }
            catch (RuntimeException runtimeException) {
                this.log.error(2048, new StringBuffer().append("Listener notification failed! Listener was:").append(object).toString(), runtimeException);
            }
        }
    }

    private static void checkArgumenNotNull(Object object, String string) {
        if (object == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Argument >").append(string).append("< must not be null!").toString());
        }
    }
}

