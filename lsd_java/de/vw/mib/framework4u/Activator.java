/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.collections.CollectionsHelper;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.framework4u.SizeWarningsLogger;
import de.vw.mib.timer.spi.TimerSPI;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$timer$spi$TimerSPI;
    static /* synthetic */ Class class$de$vw$mib$framework4u$Framework4U;

    @Override
    public void start(BundleContext bundleContext) {
        TimerSPI timerSPI = (TimerSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = Activator.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI).getName()));
        bundleContext.registerService(new String[]{(class$de$vw$mib$framework4u$Framework4U == null ? (class$de$vw$mib$framework4u$Framework4U = Activator.class$("de.vw.mib.framework4u.Framework4U")) : class$de$vw$mib$framework4u$Framework4U).getName()}, (Object)new Framework4U(timerSPI), null);
        if (System.getProperty("de.vw.mib.developmentbuild") != null) {
            CollectionsHelper.setSizeWarningsListener(new SizeWarningsLogger(bundleContext));
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

