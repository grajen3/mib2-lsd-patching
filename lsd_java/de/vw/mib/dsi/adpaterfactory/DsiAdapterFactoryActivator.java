/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.adpaterfactory;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.dsi.adpaterfactory.DsiAdapterFactoryManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.dsi.ifc.base.IFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public final class DsiAdapterFactoryActivator
implements BundleActivatorExtension {
    private static final String DSI_ADAPTER_FACTORY_CLASS;
    private static final String CREATE_ERROR_MSG_PRE;
    private static final String CREATE_NORMAL_NO_FACTORY;
    private Logger logger;
    private ServiceRegistration adapterManagerServiceRegistration;
    private boolean preloaded = false;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$org$dsi$ifc$base$IAdapterManager;

    @Override
    public void preload(BundleContext bundleContext) {
        this.logger = ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = DsiAdapterFactoryActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(1);
        DsiAdapterFactoryManager dsiAdapterFactoryManager = DsiAdapterFactoryManager.getDefault();
        IFactory iFactory = this.createFactory();
        if (iFactory != null) {
            dsiAdapterFactoryManager.registerFactories(iFactory);
        }
        this.adapterManagerServiceRegistration = bundleContext.registerService((class$org$dsi$ifc$base$IAdapterManager == null ? (class$org$dsi$ifc$base$IAdapterManager = DsiAdapterFactoryActivator.class$("org.dsi.ifc.base.IAdapterManager")) : class$org$dsi$ifc$base$IAdapterManager).getName(), (Object)dsiAdapterFactoryManager, null);
        this.preloaded = true;
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        DsiAdapterFactoryManager dsiAdapterFactoryManager;
        if (this.adapterManagerServiceRegistration != null) {
            this.adapterManagerServiceRegistration.unregister();
            this.adapterManagerServiceRegistration = null;
        }
        if ((dsiAdapterFactoryManager = DsiAdapterFactoryManager.getDefault()) != null) {
            dsiAdapterFactoryManager.unregisterAllFactories();
        }
    }

    private IFactory createFactory() {
        String string = null;
        try {
            string = System.getProperty("dsi.adapter.factory.class");
            if (string == null) {
                this.logger.normal(1, "DSI adapter factory: no factory defined");
                return null;
            }
            Class clazz = ClassLoader.getSystemClassLoader().loadClass(string);
            return (IFactory)clazz.newInstance();
        }
        catch (Throwable throwable) {
            this.logger.error(1, new StringBuffer().append("Could not create DSI adapter factory. Class name ").append(string).toString(), throwable);
            return null;
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

