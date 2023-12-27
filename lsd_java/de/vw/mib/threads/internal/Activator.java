/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.internal.ServiceManager;
import de.vw.mib.threads.internal.ThreadConfiguration;
import de.vw.mib.threads.internal.ThreadManager;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivatorExtension {
    private boolean preloaded = false;
    static /* synthetic */ Class class$de$vw$mib$debug$spi$DebugSPI;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;

    @Override
    public void preload(BundleContext bundleContext) {
        ServiceManager.debugSpi = (DebugSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$debug$spi$DebugSPI == null ? (class$de$vw$mib$debug$spi$DebugSPI = Activator.class$("de.vw.mib.debug.spi.DebugSPI")) : class$de$vw$mib$debug$spi$DebugSPI).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.errorHandler = (ErrorHandler)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName()));
        bundleContext.registerService((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName(), (Object)new ThreadManager(new ThreadConfiguration()), null);
        this.preloaded = true;
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
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

