/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFrameworkNotifierInstaller$1;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import org.osgi.framework.BundleContext;

public class DdpFrameworkNotifierInstaller {
    private final BundleContext bundleContext;
    private final DriverDistractionPreventionService ddpService;
    private final ThreadSwitchingTarget threadSwitcher;
    static /* synthetic */ Class class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler;

    public DdpFrameworkNotifierInstaller(ThreadSwitchingTarget threadSwitchingTarget, DriverDistractionPreventionService driverDistractionPreventionService, BundleContext bundleContext) {
        Preconditions.checkArgumentNotNull(threadSwitchingTarget, "ThreadSwitcher must be given.");
        Preconditions.checkArgumentNotNull(driverDistractionPreventionService, "DDP service must be given.");
        Preconditions.checkArgumentNotNull(bundleContext, "BundleContext must be given.");
        this.threadSwitcher = threadSwitchingTarget;
        this.ddpService = driverDistractionPreventionService;
        this.bundleContext = bundleContext;
    }

    public void install() {
        new DdpFrameworkNotifierInstaller$1(this, this.bundleContext, (class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler == null ? (class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler = DdpFrameworkNotifierInstaller.class$("de.vw.mib.driverdistractionprevention.DriverDistractionPreventionHandler")) : class$de$vw$mib$driverdistractionprevention$DriverDistractionPreventionHandler).getName(), null).open();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ DriverDistractionPreventionService access$100(DdpFrameworkNotifierInstaller ddpFrameworkNotifierInstaller) {
        return ddpFrameworkNotifierInstaller.ddpService;
    }

    static /* synthetic */ ThreadSwitchingTarget access$200(DdpFrameworkNotifierInstaller ddpFrameworkNotifierInstaller) {
        return ddpFrameworkNotifierInstaller.threadSwitcher;
    }
}

