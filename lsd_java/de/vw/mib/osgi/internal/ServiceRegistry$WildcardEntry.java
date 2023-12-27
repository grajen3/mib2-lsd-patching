/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceInfo;
import de.vw.mib.osgi.internal.ServiceRegistry;
import de.vw.mib.osgi.internal.ServiceRegistry$Entry;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

final class ServiceRegistry$WildcardEntry
extends ServiceRegistry$Entry {
    private final /* synthetic */ ServiceRegistry this$0;

    ServiceRegistry$WildcardEntry(ServiceRegistry serviceRegistry) {
        this.this$0 = serviceRegistry;
    }

    @Override
    void addService(ServiceInfo serviceInfo) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    Collection getServices() {
        HashSet hashSet = new HashSet();
        Map map = this.this$0.serviceMap;
        synchronized (map) {
            Iterator iterator = this.this$0.serviceMap.values().iterator();
            while (iterator.hasNext()) {
                hashSet.addAll(((ServiceRegistry$Entry)iterator.next()).services);
            }
        }
        return hashSet;
    }

    @Override
    void removeService(ServiceInfo serviceInfo) {
    }
}

