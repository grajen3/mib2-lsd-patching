/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.asl.ASLDisplayManagerTarget;
import de.vw.mib.graphics.display.internal.ASLDisplayManager;
import de.vw.mib.graphics.display.internal.ASLDisplayManagerTargetDelegate;
import de.vw.mib.graphics.display.internal.Activator$1;
import de.vw.mib.graphics.display.internal.ServiceManager;
import de.vw.mib.graphics.display.spi.DisplaySPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    private BundleContext context;
    private final ASLDisplayManagerTargetDelegate displayManagerTargetDelegate = new ASLDisplayManagerTargetDelegate();
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLDisplayManagerTarget;
    static /* synthetic */ Class class$de$vw$mib$graphics$display$spi$DisplaySPI;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$display$DisplayManager;

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        new Activator$1(this, this.context, (class$de$vw$mib$asl$ASLDisplayManagerTarget == null ? (class$de$vw$mib$asl$ASLDisplayManagerTarget = Activator.class$("de.vw.mib.asl.ASLDisplayManagerTarget")) : class$de$vw$mib$asl$ASLDisplayManagerTarget).getName(), null).open();
        ServiceManager.displaySPI = (DisplaySPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$display$spi$DisplaySPI == null ? (class$de$vw$mib$graphics$display$spi$DisplaySPI = Activator.class$("de.vw.mib.graphics.display.spi.DisplaySPI")) : class$de$vw$mib$graphics$display$spi$DisplaySPI).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        this.registerDisplayManagerService(bundleContext, this.displayManagerTargetDelegate);
    }

    private void registerDisplayManagerService(BundleContext bundleContext, ASLDisplayManagerTarget aSLDisplayManagerTarget) {
        String string = (class$de$vw$mib$graphics$display$DisplayManager == null ? (class$de$vw$mib$graphics$display$DisplayManager = Activator.class$("de.vw.mib.graphics.display.DisplayManager")) : class$de$vw$mib$graphics$display$DisplayManager).getName();
        ASLDisplayManager aSLDisplayManager = new ASLDisplayManager(ServiceManager.loggerFactory, aSLDisplayManagerTarget);
        bundleContext.registerService(string, (Object)aSLDisplayManager, null);
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

    static /* synthetic */ ASLDisplayManagerTargetDelegate access$000(Activator activator) {
        return activator.displayManagerTargetDelegate;
    }
}

