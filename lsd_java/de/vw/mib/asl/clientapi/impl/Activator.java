/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.Activator$ServiceListenerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    static final int CLOCK_INTERVAL;
    private BundleActivator listActivator;
    private Activator$ServiceListenerImpl serviceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$clientapi$list$ASLClientListFactory;
    static /* synthetic */ Class class$de$vw$mib$list$HMIListRegistry;

    @Override
    public void start(BundleContext bundleContext) {
        this.listActivator = new de.vw.mib.asl.clientapi.list.impl.Activator();
        this.listActivator.start(bundleContext);
        this.serviceListener = new Activator$ServiceListenerImpl(bundleContext);
        this.serviceListener.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.serviceListener.close();
        this.serviceListener = null;
        this.listActivator.stop(bundleContext);
        this.listActivator = null;
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

