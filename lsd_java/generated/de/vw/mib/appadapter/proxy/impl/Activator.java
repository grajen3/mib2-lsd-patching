/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.impl;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.log4mib.LoggerFactory;
import generated.de.vw.mib.appadapter.proxy.impl.AppAdapterProxyFactory;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivatorExtension {
    private boolean preloaded;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory;

    @Override
    public void preload(BundleContext bundleContext) {
        this.preloaded = true;
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        bundleContext.registerService((class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory == null ? (class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory = Activator.class$("de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory")) : class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory).getName(), (Object)new AppAdapterProxyFactory(loggerFactory), null);
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
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

