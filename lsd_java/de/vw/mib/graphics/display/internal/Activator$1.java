/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.asl.ASLDisplayManagerTarget;
import de.vw.mib.graphics.display.internal.Activator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class Activator$1
extends ServiceTracker {
    private final /* synthetic */ Activator this$0;

    Activator$1(Activator activator, BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        this.this$0 = activator;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ASLDisplayManagerTarget aSLDisplayManagerTarget = (ASLDisplayManagerTarget)super.addingService(serviceReference);
        Activator.access$000(this.this$0).set(aSLDisplayManagerTarget);
        this.close();
        return aSLDisplayManagerTarget;
    }
}

