/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.osgi.MIBOsgi;
import java.util.Enumeration;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker$Tracked;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ServiceTracker
implements ServiceTrackerCustomizer {
    final ServiceTrackerCustomizer customizer;
    private ServiceTracker$Tracked tracked;
    protected final BundleContext context;
    protected final Filter filter;

    public ServiceTracker(BundleContext bundleContext, Filter filter, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (filter == null) {
            throw new NullPointerException("no filter specified");
        }
        this.context = bundleContext;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        this.filter = filter;
    }

    public ServiceTracker(BundleContext bundleContext, ServiceReference serviceReference, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        throw new UnsupportedOperationException("ServiceTracker constructor with service reference not supported");
    }

    public ServiceTracker(BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (string == null) {
            throw new NullPointerException("no service name specified");
        }
        this.context = bundleContext;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        try {
            this.filter = bundleContext.createFilter(new StringBuffer().append("(objectClass=").append(string).append(")").toString());
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            throw new RuntimeException(new StringBuffer().append("unexpected InvalidSyntaxException: ").append(invalidSyntaxException.getMessage()).toString());
        }
    }

    public ServiceTracker(BundleContext bundleContext, String[] stringArray, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        if (stringArray == null) {
            throw new NullPointerException("no service name specified");
        }
        this.context = bundleContext;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("(|");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringBuffer.append("(objectClass=");
            stringBuffer.append(stringArray[i2]);
            stringBuffer.append(")");
        }
        stringBuffer.append(")");
        try {
            this.filter = bundleContext.createFilter(stringBuffer.toString());
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            throw new RuntimeException(new StringBuffer().append("unexpected InvalidSyntaxException: ").append(invalidSyntaxException.getMessage()).toString());
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        return this.context.getService(serviceReference);
    }

    public synchronized void close() {
        if (this.tracked == null) {
            return;
        }
        this.tracked.close();
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        this.tracked = null;
        try {
            this.context.removeServiceListener(serviceTracker$Tracked);
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        ServiceReference[] serviceReferenceArray = this.getServiceReferences();
        if (serviceReferenceArray == null) {
            return;
        }
        for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
            serviceTracker$Tracked.untrack(serviceReferenceArray[i2]);
        }
    }

    public Object getService() {
        ServiceReference serviceReference = this.getServiceReference();
        if (serviceReference != null) {
            return this.getService(serviceReference);
        }
        return null;
    }

    public Object getService(ServiceReference serviceReference) {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return null;
        }
        return serviceTracker$Tracked.get(serviceReference);
    }

    public ServiceReference getServiceReference() {
        int n;
        ServiceReference[] serviceReferenceArray = this.getServiceReferences();
        if (serviceReferenceArray == null || serviceReferenceArray.length == 0) {
            return null;
        }
        if (serviceReferenceArray.length == 1) {
            return serviceReferenceArray[0];
        }
        int n2 = 0;
        int[] nArray = new int[serviceReferenceArray.length];
        int n3 = 0;
        int n4 = 128;
        for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
            Object object = serviceReferenceArray[i2].getProperty("service.ranking");
            nArray[i2] = n = object instanceof Integer ? (Integer)object : 0;
            if (n > n4) {
                n2 = i2;
                n4 = n;
                n3 = 1;
                continue;
            }
            if (n != n4) continue;
            ++n3;
        }
        if (n3 > 1) {
            long l = Long.MAX_VALUE;
            for (n = 0; n < serviceReferenceArray.length; ++n) {
                long l2;
                if (nArray[n] != n4 || (l2 = ((Long)serviceReferenceArray[n].getProperty("service.id")).longValue()) >= l) continue;
                n2 = n;
                l = l2;
            }
        }
        return serviceReferenceArray[n2];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServiceReference[] getServiceReferences() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return null;
        }
        ServiceTracker$Tracked serviceTracker$Tracked2 = serviceTracker$Tracked;
        synchronized (serviceTracker$Tracked2) {
            int n = serviceTracker$Tracked.size();
            if (n == 0) {
                return null;
            }
            ServiceReference[] serviceReferenceArray = new ServiceReference[n];
            Enumeration enumeration = serviceTracker$Tracked.keys();
            for (int i2 = 0; i2 < n; ++i2) {
                serviceReferenceArray[i2] = (ServiceReference)enumeration.nextElement();
            }
            return serviceReferenceArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] getServices() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return null;
        }
        ServiceTracker$Tracked serviceTracker$Tracked2 = serviceTracker$Tracked;
        synchronized (serviceTracker$Tracked2) {
            int n = serviceTracker$Tracked.size();
            if (n == 0) {
                return null;
            }
            Object[] objectArray = new Object[n];
            Enumeration enumeration = serviceTracker$Tracked.elements();
            for (int i2 = 0; i2 < n; ++i2) {
                objectArray[i2] = enumeration.nextElement();
            }
            return objectArray;
        }
    }

    public int getTrackingCount() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return -1;
        }
        return serviceTracker$Tracked.getTrackingCount();
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public synchronized void open() {
        ServiceReference[] serviceReferenceArray;
        if (this.tracked != null) {
            return;
        }
        this.tracked = new ServiceTracker$Tracked(this);
        this.context.addServiceListener(this.tracked);
        try {
            serviceReferenceArray = this.context.getServiceReferences(null, ((Object)this.filter).toString());
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            throw new RuntimeException("unexpected InvalidSyntaxException");
        }
        if (serviceReferenceArray == null) {
            return;
        }
        for (int i2 = 0; i2 < serviceReferenceArray.length; ++i2) {
            this.tracked.track(serviceReferenceArray[i2]);
        }
    }

    public void remove(ServiceReference serviceReference) {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return;
        }
        try {
            serviceTracker$Tracked.untrack(serviceReference);
        }
        catch (Exception exception) {
            LogMessage logMessage = MIBOsgi.logger.error(2);
            logMessage.append("service: ").append(serviceReference);
            logMessage.append(" - exception removing service from ServiceTrackerCustomizer of bundle ");
            logMessage.append(this.context.getBundle().getBundleId());
            logMessage.append(" '").append(((Bundle)((Object)this.context)).getHeaders().get("Bundle-Name")).append("' ");
            logMessage.attachThrowable(exception);
            logMessage.log();
        }
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.context.ungetService(serviceReference);
    }

    public int size() {
        ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
        if (serviceTracker$Tracked == null) {
            return 0;
        }
        return serviceTracker$Tracked.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object waitForService(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        Object object = this.getService();
        while (object == null) {
            ServiceTracker$Tracked serviceTracker$Tracked = this.tracked;
            if (serviceTracker$Tracked == null) {
                return null;
            }
            ServiceTracker$Tracked serviceTracker$Tracked2 = serviceTracker$Tracked;
            synchronized (serviceTracker$Tracked2) {
                if (serviceTracker$Tracked.size() == 0) {
                    super.wait(l);
                }
            }
            object = this.getService();
            if (l <= 0L) continue;
            return object;
        }
        return object;
    }
}

