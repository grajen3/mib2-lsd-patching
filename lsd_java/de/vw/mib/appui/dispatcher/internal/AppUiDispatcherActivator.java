/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appui.dispatcher.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.appui.dispatcher.internal.CioIdServiceListener;
import de.vw.mib.appui.dispatcher.internal.cio.CioVisualizationServiceDispatcher;
import de.vw.mib.hmi.utils.OsgiUtil;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;

public class AppUiDispatcherActivator
implements BundleActivatorExtension {
    private BundleContext bundleContext;
    private boolean preloaded = false;
    private LoggerFactory loggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$CioVisualizationService;
    static /* synthetic */ Class class$de$vw$mib$appui$cio$CioVisualizationRegister;

    @Override
    public void preload(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.preloaded = true;
        this.loggerFactory = (LoggerFactory)this.getService((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = AppUiDispatcherActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        CioVisualizationServiceDispatcher cioVisualizationServiceDispatcher = new CioVisualizationServiceDispatcher(this.loggerFactory);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$cio$framework$CioVisualizationService == null ? (class$de$vw$mib$cio$framework$CioVisualizationService = AppUiDispatcherActivator.class$("de.vw.mib.cio.framework.CioVisualizationService")) : class$de$vw$mib$cio$framework$CioVisualizationService).getName(), (class$de$vw$mib$appui$cio$CioVisualizationRegister == null ? (class$de$vw$mib$appui$cio$CioVisualizationRegister = AppUiDispatcherActivator.class$("de.vw.mib.appui.cio.CioVisualizationRegister")) : class$de$vw$mib$appui$cio$CioVisualizationRegister).getName()}, (Object)cioVisualizationServiceDispatcher, null);
        CioIdServiceListener.registerAsCioIdServiceListener(this.bundleContext, cioVisualizationServiceDispatcher);
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

    private Object getService(String string) {
        return OsgiUtil.getService(this.bundleContext, string);
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

