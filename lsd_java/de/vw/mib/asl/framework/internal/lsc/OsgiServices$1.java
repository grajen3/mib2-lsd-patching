/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.lsc.OsgiServices$ServiceConsumer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

final class OsgiServices$1
extends ServiceTracker {
    private final /* synthetic */ OsgiServices$ServiceConsumer val$consumer;

    OsgiServices$1(BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer, OsgiServices$ServiceConsumer osgiServices$ServiceConsumer) {
        this.val$consumer = osgiServices$ServiceConsumer;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = super.addingService(serviceReference);
        this.val$consumer.onServiceAvailable(object);
        this.close();
        return object;
    }
}

