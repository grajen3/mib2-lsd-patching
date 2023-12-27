/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.servicebridge;

import de.vw.mib.asl.internal.online.servicebridge.DSIHASImpl;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.SubRegistry;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator,
SubRegistry,
ServiceAdmin {
    private ServiceAdmin serviceAdmin;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHAS;

    @Override
    public void start(BundleContext bundleContext) {
        de.vw.mib.asl.framework.internal.framework.ServiceManager.bundleContext = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
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
            de.vw.mib.asl.framework.internal.framework.ServiceManager.bundleContext.registerService(string, (Object)new DSIHASImpl(n), (Dictionary)hashtable);
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

