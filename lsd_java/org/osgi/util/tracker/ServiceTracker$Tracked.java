/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import java.util.Hashtable;
import java.util.Vector;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

class ServiceTracker$Tracked
extends Hashtable
implements ServiceListener {
    private static final long serialVersionUID;
    private final Vector adding = new Vector(10, 10);
    private boolean closed = false;
    private int trackingCount = 0;
    private final /* synthetic */ ServiceTracker this$0;

    protected ServiceTracker$Tracked(ServiceTracker serviceTracker) {
        this.this$0 = serviceTracker;
    }

    protected void close() {
        this.closed = true;
    }

    protected int getTrackingCount() {
        return this.trackingCount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void track(ServiceReference serviceReference) {
        Object object = this.get(serviceReference);
        if (object != null) {
            this.this$0.customizer.modifiedService(serviceReference, object);
            return;
        }
        ServiceTracker$Tracked serviceTracker$Tracked = this;
        synchronized (serviceTracker$Tracked) {
            if (this.adding.indexOf(serviceReference, 0) != -1) {
                return;
            }
            this.adding.addElement(serviceReference);
        }
        boolean bl = false;
        try {
            object = this.this$0.customizer.addingService(serviceReference);
        }
        finally {
            ServiceTracker$Tracked serviceTracker$Tracked2 = this;
            synchronized (serviceTracker$Tracked2) {
                if (this.adding.removeElement(serviceReference)) {
                    if (object != null) {
                        this.put(serviceReference, object);
                        ++this.trackingCount;
                        super.notifyAll();
                    }
                } else {
                    bl = true;
                }
            }
        }
        if (bl) {
            this.this$0.customizer.removedService(serviceReference, object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void untrack(ServiceReference serviceReference) {
        Object object;
        ServiceTracker$Tracked serviceTracker$Tracked = this;
        synchronized (serviceTracker$Tracked) {
            if (this.adding.removeElement(serviceReference)) {
                return;
            }
            object = this.remove(serviceReference);
            if (object == null) {
                return;
            }
            ++this.trackingCount;
        }
        this.this$0.customizer.removedService(serviceReference, object);
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (this.closed) {
            return;
        }
        ServiceReference serviceReference = serviceEvent.getServiceReference();
        switch (serviceEvent.getType()) {
            case 1: 
            case 2: {
                if (this.this$0.filter.match(serviceReference)) {
                    this.track(serviceReference);
                    return;
                }
                this.untrack(serviceReference);
                break;
            }
            case 4: {
                this.untrack(serviceReference);
                break;
            }
        }
    }
}

