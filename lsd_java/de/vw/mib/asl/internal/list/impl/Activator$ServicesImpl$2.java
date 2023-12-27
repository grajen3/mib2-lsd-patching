/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.Activator;
import de.vw.mib.asl.internal.list.impl.Activator$ServicesImpl;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class Activator$ServicesImpl$2
extends ServiceTracker {
    private final /* synthetic */ Activator val$this$0;
    private final /* synthetic */ Activator$ServicesImpl this$1;

    Activator$ServicesImpl$2(Activator$ServicesImpl activator$ServicesImpl, BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, Activator activator) {
        this.this$1 = activator$ServicesImpl;
        this.val$this$0 = activator;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TimerManager timerManager;
        this.this$1.timerManager = timerManager = (TimerManager)super.addingService(serviceReference);
        return timerManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$1.timerManager = null;
        super.removedService(serviceReference, object);
    }
}

