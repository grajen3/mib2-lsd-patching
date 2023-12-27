/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifierInstaller;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifierInstaller$1$1;
import de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DdpFrameworkNotifierInstaller$1
extends ServiceTracker {
    private final /* synthetic */ DdpFrameworkNotifierInstaller this$0;

    DdpFrameworkNotifierInstaller$1(DdpFrameworkNotifierInstaller ddpFrameworkNotifierInstaller, BundleContext bundleContext, String string, ServiceTrackerCustomizer serviceTrackerCustomizer) {
        this.this$0 = ddpFrameworkNotifierInstaller;
        super(bundleContext, string, serviceTrackerCustomizer);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        DriverDistractionPreventionHandler driverDistractionPreventionHandler = (DriverDistractionPreventionHandler)super.addingService(serviceReference);
        DdpFrameworkNotifierInstaller.access$200(this.this$0).enqueue(new DdpFrameworkNotifierInstaller$1$1(this, driverDistractionPreventionHandler));
        this.close();
        return driverDistractionPreventionHandler;
    }

    static /* synthetic */ DdpFrameworkNotifierInstaller access$000(DdpFrameworkNotifierInstaller$1 ddpFrameworkNotifierInstaller$1) {
        return ddpFrameworkNotifierInstaller$1.this$0;
    }
}

