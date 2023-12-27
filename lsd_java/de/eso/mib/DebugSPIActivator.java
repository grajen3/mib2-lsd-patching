/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.DebugSPIImpl;
import de.eso.mib.PersistenceListener;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;
import org.dsi.ifc.persistence.DSIPersistence;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class DebugSPIActivator
implements BundleActivator,
ServiceTrackerCustomizer {
    private ServiceRegistration clientService;
    private DebugSPIImpl dspii;
    private BundleContext context;
    private ServiceTracker tracker;
    private PersistenceListener persistenceListener;
    private static final int PERSISTENCE_INSTANCE_ID;
    static /* synthetic */ Class class$de$vw$mib$debug$spi$DebugSPI;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistenceListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    @Override
    public void start(BundleContext bundleContext) {
        this.dspii = new DebugSPIImpl();
        this.dspii.init();
        this.clientService = bundleContext.registerService((class$de$vw$mib$debug$spi$DebugSPI == null ? (class$de$vw$mib$debug$spi$DebugSPI = DebugSPIActivator.class$("de.vw.mib.debug.spi.DebugSPI")) : class$de$vw$mib$debug$spi$DebugSPI).getName(), (Object)this.dspii, (Dictionary)new Hashtable());
        this.persistenceListener = new PersistenceListener(this.dspii);
        this.context = bundleContext;
        Filter filter = this.context.createFilter(new StringBuffer().append("(| (objectClass=").append((class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = DebugSPIActivator.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence).getName()).append("))").toString());
        this.tracker = new ServiceTracker(this.context, filter, (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.clientService != null) {
            bundleContext.ungetService(this.clientService.getReference());
        }
        this.dspii.exit();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object;
        Object object2 = this.context.getService(serviceReference);
        if (object2 instanceof DSIPersistence && (object = serviceReference.getProperty("DEVICE_INSTANCE")) != null && (Integer)object == 0) {
            DSIPersistence dSIPersistence = (DSIPersistence)object2;
            this.persistenceListener.addDsi(dSIPersistence);
            dSIPersistence.setNotification(this.persistenceListener);
            Properties properties = new Properties();
            properties.put("DEVICE_NAME", (class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = DebugSPIActivator.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener).getName());
            properties.put("DEVICE_INSTANCE", new Integer(0));
            this.context.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DebugSPIActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.persistenceListener, (Dictionary)properties);
            this.persistenceListener.subscribeKeys();
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
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

