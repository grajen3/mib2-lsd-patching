/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.AdapterActivator;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.admin.IListenerTracker;
import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.tracing.TraceChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ListenerTrackerLocal
implements ServiceTrackerCustomizer,
IListenerTracker {
    private final TraceChannel tracer = Channels.LISTENER_TRACKER;
    private BundleContext bundleContext;
    private ServiceTracker serviceTracker;
    private HashMap serviceMap = new HashMap();
    private DSIAdmin admin;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public ListenerTrackerLocal() {
        this.tracer.log((short)0, "Using ListenerTrackerLocal ");
        this.bundleContext = AdapterActivator.bundleContext;
    }

    @Override
    public void setDSIAdmin(DSIAdmin dSIAdmin) {
        this.admin = dSIAdmin;
    }

    @Override
    public void open() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = ListenerTrackerLocal.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        this.serviceTracker.close();
        ListenerTrackerLocal listenerTrackerLocal = this;
        synchronized (listenerTrackerLocal) {
            this.serviceMap.clear();
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        String string = this.getMapKeyFromReference(serviceReference);
        this.tracer.log((short)0, "%1: addingService: serviceName=%2 ", (Object)string, (Object)object.getClass().getName());
        this.addServiceToMap(string, object);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        IDispatcher iDispatcher;
        String string = this.getMapKeyFromReference(serviceReference);
        this.removeServiceFromMap(string, object);
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        boolean bl = this.bundleContext.ungetService(serviceReference);
        if (this.admin != null && (iDispatcher = this.admin.findDispatcher(string)) != null && object instanceof DSIListener) {
            iDispatcher.removeNotificationListener((DSIListener)object);
        }
        this.tracer.log((short)0, "%3: removedService: serviceName=%1, serviceInstance=%2, unget=%4", object2, object3, (Object)string, (Object)new Boolean(bl));
    }

    private synchronized Object[] getDSIListenerList(String string, int n) {
        this.tracer.log((short)0, "Search listeners for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
        Object[] objectArray = null;
        String string2 = DSIAdmin.generateMapKey(string, n);
        if (this.serviceMap.containsKey(string2)) {
            List list = (List)this.serviceMap.get(string2);
            objectArray = list.toArray();
            this.tracer.log((short)0, "Listeners found for: serviceName=%1, serviceInstance=%2, listeners=%3", (Object)string, (Object)String.valueOf(n), (Object)String.valueOf(list.size()));
        } else {
            this.tracer.log((short)3, "No listeners found for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
        }
        return objectArray;
    }

    private String getMapKeyFromReference(ServiceReference serviceReference) {
        Object object;
        String string = "";
        int n = -1;
        if (serviceReference.getProperty("DEVICE_NAME") != null) {
            string = (String)serviceReference.getProperty("DEVICE_NAME");
        }
        if (serviceReference.getProperty("DEVICE_INSTANCE") != null) {
            object = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
            n = (Integer)object;
        }
        object = DSIAdmin.generateMapKey(string, n);
        return object;
    }

    private synchronized void addServiceToMap(String string, Object object) {
        this.tracer.log((short)0, "adding service to map key=%1 service=%2 ", (Object)string, (Object)object.getClass().getName());
        if (this.serviceMap.containsKey(string)) {
            this.tracer.log((short)0, " key already exist, adding new service to list ");
            Object object2 = this.serviceMap.get(string);
            if (object2 instanceof List) {
                List list = (List)object2;
                list.add(object);
            } else {
                this.tracer.log((short)3, " something went wrong, object of wrong instance detected ");
            }
        } else {
            this.tracer.log((short)0, " key doesent exist, creating new servicemapentry ");
            List list = Collections.synchronizedList(new ArrayList());
            list.add(object);
            this.serviceMap.put(string, list);
        }
        this.tracer.log((short)0, "added to map ");
    }

    private synchronized void removeServiceFromMap(String string, Object object) {
        this.tracer.log((short)0, "%1: removeServiceFromMap, service=%2 ", (Object)string, object);
        if (this.serviceMap.containsKey(string)) {
            List list = (List)this.serviceMap.get(string);
            boolean bl = list.remove(object);
            if (!bl) {
                this.tracer.log((short)3, "%1: service could not removed from listener with service=%2", (Object)string, object);
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Object object2 = iterator.next();
                    this.tracer.log((short)0, "%1: ServiceList service=%2", (Object)string, object2);
                }
            }
            this.tracer.log((short)0, "%1: removeServiceFromMap, list.size=%2", (Object)string, (Object)new Integer(list.size()));
            if (list.size() == 0) {
                this.serviceMap.remove(string);
            }
        }
    }

    @Override
    public Object[] getDSIListener(String string, int n) {
        return this.getDSIListenerList(string, n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

