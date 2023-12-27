/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.DisplaySPIImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DisplaySPIActivator
implements BundleActivator {
    private ServiceRegistration clientService;
    static /* synthetic */ Class class$de$vw$mib$graphics$display$spi$DisplaySPI;

    @Override
    public void start(BundleContext bundleContext) {
        DisplaySPIImpl displaySPIImpl = new DisplaySPIImpl();
        this.clientService = bundleContext.registerService((class$de$vw$mib$graphics$display$spi$DisplaySPI == null ? (class$de$vw$mib$graphics$display$spi$DisplaySPI = DisplaySPIActivator.class$("de.vw.mib.graphics.display.spi.DisplaySPI")) : class$de$vw$mib$graphics$display$spi$DisplaySPI).getName(), (Object)displaySPIImpl, (Dictionary)new Hashtable());
        displaySPIImpl.initDisplaySPI();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.clientService != null) {
            bundleContext.ungetService(this.clientService.getReference());
        }
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

