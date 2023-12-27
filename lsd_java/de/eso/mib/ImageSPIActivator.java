/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.ImageSPIImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ImageSPIActivator
implements BundleActivator {
    private ServiceRegistration clientService;
    private ImageSPIImpl ispii;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$spi$ImageSPI;

    @Override
    public void start(BundleContext bundleContext) {
        this.ispii = new ImageSPIImpl();
        this.clientService = bundleContext.registerService((class$de$vw$mib$graphics$image$spi$ImageSPI == null ? (class$de$vw$mib$graphics$image$spi$ImageSPI = ImageSPIActivator.class$("de.vw.mib.graphics.image.spi.ImageSPI")) : class$de$vw$mib$graphics$image$spi$ImageSPI).getName(), (Object)this.ispii, (Dictionary)new Hashtable());
        this.ispii.initNative();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.ispii.uninitNative();
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

