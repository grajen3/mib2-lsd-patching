/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FileSPIImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FileSPIActivator
implements BundleActivator {
    private ServiceRegistration clientService;
    static /* synthetic */ Class class$de$vw$mib$file$spi$FileSPI;

    @Override
    public void start(BundleContext bundleContext) {
        this.clientService = bundleContext.registerService((class$de$vw$mib$file$spi$FileSPI == null ? (class$de$vw$mib$file$spi$FileSPI = FileSPIActivator.class$("de.vw.mib.file.spi.FileSPI")) : class$de$vw$mib$file$spi$FileSPI).getName(), (Object)FileSPIImpl.getInstance(), (Dictionary)new Hashtable());
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

