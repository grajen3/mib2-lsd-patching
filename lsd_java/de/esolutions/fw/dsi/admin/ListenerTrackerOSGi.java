/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.AdapterActivator;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.admin.IListenerTracker;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.tracing.TraceChannel;
import java.util.ArrayList;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class ListenerTrackerOSGi
implements IListenerTracker {
    private final TraceChannel tracer = Channels.LISTENER_TRACKER;
    private BundleContext bundleContext;
    private ServiceTracker serviceTracker;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public ListenerTrackerOSGi() {
        this.tracer.log((short)0, "Using ListenerTrackerOSGi ");
        this.bundleContext = AdapterActivator.bundleContext;
    }

    @Override
    public void open() {
        this.serviceTracker = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = ListenerTrackerOSGi.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), null);
        this.serviceTracker.open();
    }

    @Override
    public void close() {
        this.serviceTracker.close();
    }

    private Object[] getDSIListenerList(String string, int n) {
        this.tracer.log((short)0, "Search listeners for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
        ArrayList arrayList = new ArrayList();
        ServiceReference[] serviceReferenceArray = this.serviceTracker.getServiceReferences();
        if (serviceReferenceArray != null && serviceReferenceArray.length != 0) {
            for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
                Object object = this.bundleContext.getService(serviceReferenceArray[i2]);
                Object object2 = serviceReferenceArray[i2].getProperty("DEVICE_NAME");
                Object object3 = serviceReferenceArray[i2].getProperty("DEVICE_INSTANCE");
                if (object2 != null && object3 != null) {
                    String string2 = (String)object2;
                    short s = ((Integer)object3).shortValue();
                    if (string2.equals(string) && s == n) {
                        arrayList.add(object);
                    }
                } else {
                    this.tracer.log((short)4, "Invalid service properties: objectClassName=%1, serviceClassName=%2, serviceInstance=%3, serviceNameProperty=%4, serviceInstanceProperty=%5", (Object)object.getClass().getName(), (Object)string, (Object)String.valueOf(n), object2, object3);
                }
                this.bundleContext.ungetService(serviceReferenceArray[i2]);
            }
            if (arrayList.size() > 0) {
                this.tracer.log((short)0, "Listeners found for: serviceName=%1, serviceInstance=%2, listeners=%3", (Object)string, (Object)String.valueOf(n), (Object)String.valueOf(arrayList.size()));
            } else {
                this.tracer.log((short)3, "No listeners found for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
            }
        } else {
            this.tracer.log((short)3, "No service references found for: serviceName=%1, serviceInstance=%2", (Object)string, (Object)String.valueOf(n));
        }
        return arrayList.toArray();
    }

    @Override
    public Object[] getDSIListener(String string, int n) {
        return this.getDSIListenerList(string, n);
    }

    @Override
    public void setDSIAdmin(DSIAdmin dSIAdmin) {
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

