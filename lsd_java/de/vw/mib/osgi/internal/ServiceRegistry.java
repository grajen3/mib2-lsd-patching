/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.SubRegistry;
import de.vw.mib.osgi.internal.BundleInfo$ServiceListenerEntry;
import de.vw.mib.osgi.internal.ServiceInfo;
import de.vw.mib.osgi.internal.ServiceRegistry$Entry;
import de.vw.mib.osgi.internal.ServiceRegistry$WildcardEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

final class ServiceRegistry {
    private static final int INITIAL_SERVICE_MAP_SIZE;
    private static ServiceRegistry INSTANCE;
    static final String GENERAL_SERVICE;
    private final CowArray serviceListeners = new CowArray();
    final Map serviceMap = new HashMap(100);
    private final CowArray subRegistries = new CowArray();

    static ServiceRegistry getInstance() {
        return INSTANCE;
    }

    static ServiceRegistry resetInstance() {
        INSTANCE = new ServiceRegistry();
        return INSTANCE;
    }

    private ServiceRegistry() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ServiceRegistry$Entry getEntry(String string) {
        Map map = this.serviceMap;
        synchronized (map) {
            ServiceRegistry$Entry serviceRegistry$Entry = (ServiceRegistry$Entry)this.serviceMap.get(string);
            if (serviceRegistry$Entry == null) {
                serviceRegistry$Entry = string.equals("*") ? new ServiceRegistry$WildcardEntry(this) : new ServiceRegistry$Entry();
                this.serviceMap.put(string, serviceRegistry$Entry);
            }
            return serviceRegistry$Entry;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean hasEntry(String string) {
        Map map = this.serviceMap;
        synchronized (map) {
            return this.serviceMap.containsKey(string);
        }
    }

    void addServiceListener(BundleInfo$ServiceListenerEntry bundleInfo$ServiceListenerEntry) {
        this.serviceListeners.addIfNotAlreadyIn(bundleInfo$ServiceListenerEntry);
    }

    void addSubRegistry(SubRegistry subRegistry) {
        this.subRegistries.addIfNotAlreadyIn(subRegistry);
    }

    Object getService(ServiceInfo serviceInfo) {
        if (this.subRegistries.size() > 0) {
            String[] stringArray = serviceInfo.getServiceInterfaces();
            Object object = serviceInfo.getService();
            Dictionary dictionary = serviceInfo.getProperties();
            Object[] objectArray = this.subRegistries.getArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                SubRegistry subRegistry = (SubRegistry)objectArray[i2];
                object = subRegistry.getService(stringArray, object, dictionary);
            }
            return object;
        }
        return serviceInfo.getService();
    }

    ServiceInfo getServiceInfo(String string) {
        if (this.hasEntry(string)) {
            ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry(string);
            return serviceRegistry$Entry.getRandomService();
        }
        return null;
    }

    Collection getServiceInfos(String string) {
        if (this.hasEntry(string)) {
            ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry(string);
            return serviceRegistry$Entry.getServices();
        }
        return new ArrayList(0);
    }

    void registerService(ServiceInfo serviceInfo) {
        Object object;
        String[] stringArray = serviceInfo.getServiceInterfaces();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = this.getEntry(stringArray[i2]);
            ((ServiceRegistry$Entry)object).addService(serviceInfo);
        }
        ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry("*");
        serviceRegistry$Entry.addService(serviceInfo);
        object = new ServiceEvent(1, serviceInfo);
        Object[] objectArray = this.serviceListeners.getArray();
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            BundleInfo$ServiceListenerEntry bundleInfo$ServiceListenerEntry = (BundleInfo$ServiceListenerEntry)objectArray[i3];
            if (bundleInfo$ServiceListenerEntry.filter != null && !bundleInfo$ServiceListenerEntry.filter.match(serviceInfo.getProperties())) continue;
            try {
                bundleInfo$ServiceListenerEntry.listener.serviceChanged((ServiceEvent)object);
                continue;
            }
            catch (Exception exception) {
                MIBOsgi.logger.error(2).append("error while notifying service listener!").attachThrowable(exception).log();
            }
        }
    }

    void removeServiceListener(ServiceListener serviceListener) {
        for (int i2 = 0; i2 < this.serviceListeners.size(); ++i2) {
            BundleInfo$ServiceListenerEntry bundleInfo$ServiceListenerEntry = (BundleInfo$ServiceListenerEntry)this.serviceListeners.get(i2);
            if (bundleInfo$ServiceListenerEntry.listener != serviceListener) continue;
            this.serviceListeners.remove(bundleInfo$ServiceListenerEntry);
            return;
        }
    }

    void unregisterService(ServiceInfo serviceInfo) {
        Object object;
        String[] stringArray = serviceInfo.getServiceInterfaces();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = this.getEntry(stringArray[i2]);
            ((ServiceRegistry$Entry)object).removeService(serviceInfo);
        }
        ServiceRegistry$Entry serviceRegistry$Entry = this.getEntry("*");
        serviceRegistry$Entry.removeService(serviceInfo);
        object = new ServiceEvent(4, serviceInfo);
        Object[] objectArray = this.serviceListeners.getArray();
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            BundleInfo$ServiceListenerEntry bundleInfo$ServiceListenerEntry = (BundleInfo$ServiceListenerEntry)objectArray[i3];
            if (bundleInfo$ServiceListenerEntry.filter != null && !bundleInfo$ServiceListenerEntry.filter.match(serviceInfo.getProperties())) continue;
            bundleInfo$ServiceListenerEntry.listener.serviceChanged((ServiceEvent)object);
        }
    }

    static {
        INSTANCE = new ServiceRegistry();
    }
}

