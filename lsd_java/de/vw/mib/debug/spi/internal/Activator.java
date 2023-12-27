/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.internal;

import de.vw.mib.debug.spi.internal.DebugSPI_Service;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$debug$spi$DebugSPI;

    @Override
    public void start(BundleContext bundleContext) {
        DebugSPI_Service debugSPI_Service = new DebugSPI_Service();
        bundleContext.registerService((class$de$vw$mib$debug$spi$DebugSPI == null ? (class$de$vw$mib$debug$spi$DebugSPI = Activator.class$("de.vw.mib.debug.spi.DebugSPI")) : class$de$vw$mib$debug$spi$DebugSPI).getName(), (Object)debugSPI_Service, null);
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

