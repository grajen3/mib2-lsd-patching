/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.FontSPIImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FontSPIActivator
implements BundleActivator {
    private ServiceRegistration clientService;
    private FontSPIImpl fspii;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$spi$FontSPI;

    @Override
    public void start(BundleContext bundleContext) {
        this.fspii = new FontSPIImpl();
        this.clientService = bundleContext.registerService((class$de$vw$mib$graphics$font$spi$FontSPI == null ? (class$de$vw$mib$graphics$font$spi$FontSPI = FontSPIActivator.class$("de.vw.mib.graphics.font.spi.FontSPI")) : class$de$vw$mib$graphics$font$spi$FontSPI).getName(), (Object)this.fspii, (Dictionary)new Hashtable());
        this.fspii.initNative();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.fspii.uninitNative();
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

