/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceInfo;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Collection;

class ServiceRegistry$Entry {
    protected CopyOnWriteArrayList services = new CopyOnWriteArrayList();

    ServiceRegistry$Entry() {
    }

    synchronized void addService(ServiceInfo serviceInfo) {
        this.services.addIfAbsent(serviceInfo);
    }

    synchronized ServiceInfo getRandomService() {
        if (this.services.isEmpty()) {
            return null;
        }
        return (ServiceInfo)this.services.get(0);
    }

    synchronized Collection getServices() {
        return new ArrayList(this.services);
    }

    synchronized void removeService(ServiceInfo serviceInfo) {
        this.services.remove(serviceInfo);
    }
}

