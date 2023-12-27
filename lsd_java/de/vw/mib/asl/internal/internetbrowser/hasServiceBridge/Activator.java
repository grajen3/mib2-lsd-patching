/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.hasServiceBridge;

import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.BrowserServiceBridge;
import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.DSIHASImpl;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.SubRegistry;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.ServiceAdmin;
import org.dsi.ifc.has.DSIHAS;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivator,
SubRegistry,
ServiceAdmin {
    private BundleContext context;
    private Logger logger;
    private ServiceAdmin serviceAdmin;
    private AsyncServiceFactory asyncFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHAS;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        this.logger = loggerFactory.getLogger(32768);
        BrowserServiceBridge.setLogger(this.logger);
        MIBOsgi.getInstance().addSubRegistry(this);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    @Override
    public Object getService(String[] stringArray, Object object, Dictionary dictionary) {
        if (object instanceof ServiceAdmin) {
            this.serviceAdmin = (ServiceAdmin)object;
            return this;
        }
        return object;
    }

    @Override
    public boolean startService(String string, int n) {
        if (string.equals((class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = Activator.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS).getName()) && n == 1) {
            Hashtable hashtable = new Hashtable();
            ((Dictionary)hashtable).put("DEVICE_NAME", string);
            ((Dictionary)hashtable).put("DEVICE_INSTANCE", new Integer(n));
            DSIHASImpl dSIHASImpl = new DSIHASImpl(n, this.logger);
            BrowserServiceBridge.setDSIHASImpl(dSIHASImpl);
            DSIHAS dSIHAS = (DSIHAS)this.getAsyncServiceFactory().create(dSIHASImpl, new Class[]{class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = Activator.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS});
            this.context.registerService(string, (Object)dSIHAS, (Dictionary)hashtable);
            return true;
        }
        return this.serviceAdmin.startService(string, n);
    }

    @Override
    public boolean stopService(String string, int n) {
        if (string.equals((class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = Activator.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS).getName())) {
            // empty if block
        }
        return this.serviceAdmin.stopService(string, n);
    }

    private AsyncServiceFactory getAsyncServiceFactory() {
        if (null == this.asyncFactory) {
            String string = "(MIBThreadId=3)";
            try {
                ServiceReference[] serviceReferenceArray = this.context.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), string);
                this.asyncFactory = (AsyncServiceFactory)this.context.getService(serviceReferenceArray[0]);
            }
            catch (Exception exception) {
                throw new RuntimeException("Could not get async service factory", exception);
            }
        }
        return this.asyncFactory;
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

