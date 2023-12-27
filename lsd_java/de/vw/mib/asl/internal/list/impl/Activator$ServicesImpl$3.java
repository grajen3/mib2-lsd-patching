/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.Activator;
import de.vw.mib.asl.internal.list.impl.Activator$ServicesImpl;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class Activator$ServicesImpl$3
extends ServiceTracker {
    private final /* synthetic */ Activator val$this$0;
    private final /* synthetic */ Activator$ServicesImpl this$1;

    Activator$ServicesImpl$3(Activator$ServicesImpl activator$ServicesImpl, BundleContext bundleContext, Filter filter, ServiceTrackerCustomizer serviceTrackerCustomizer, Activator activator) {
        this.this$1 = activator$ServicesImpl;
        this.val$this$0 = activator;
        super(bundleContext, filter, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ThreadSwitchingTarget threadSwitchingTarget;
        this.this$1.threadSwitch = threadSwitchingTarget = (ThreadSwitchingTarget)super.addingService(serviceReference);
        return threadSwitchingTarget;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$1.threadSwitch = null;
        super.removedService(serviceReference, object);
    }
}

