/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.core;

import de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListener;
import de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListenerService;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Iterator;

public class EntertainmentContextListenerServiceImpl
implements EntertainmentContextListenerService {
    private final AsyncServiceFactory asyncServiceFactory;
    private final ObjectObjectOptHashMap listeners = new ObjectObjectOptHashMap();
    private boolean hasValue = false;
    private int lastValue;

    public EntertainmentContextListenerServiceImpl(AsyncServiceFactory asyncServiceFactory) {
        this.asyncServiceFactory = asyncServiceFactory;
    }

    @Override
    public void registerEntertainmentContextListener(EntertainmentContextListener entertainmentContextListener) {
        EntertainmentContextListener entertainmentContextListener2 = (EntertainmentContextListener)this.asyncServiceFactory.create(entertainmentContextListener);
        if (this.hasValue) {
            entertainmentContextListener2.updateContext(this.lastValue);
        }
        this.listeners.put(entertainmentContextListener, entertainmentContextListener2);
    }

    @Override
    public void unregisterEntertainmentContextListener(EntertainmentContextListener entertainmentContextListener) {
        this.listeners.remove(entertainmentContextListener);
    }

    public void updateContext(int n) {
        this.hasValue = true;
        this.lastValue = n;
        Iterator iterator = this.listeners.valueIterator();
        while (iterator.hasNext()) {
            EntertainmentContextListener entertainmentContextListener = (EntertainmentContextListener)iterator.next();
            entertainmentContextListener.updateContext(n);
        }
    }
}

