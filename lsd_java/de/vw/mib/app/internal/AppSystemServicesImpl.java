/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.internal;

import de.vw.mib.app.internal.AppSystemServices;
import de.vw.mib.appui.cio.CioVisualizationRegister;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.view.internal.GlobalViewHandlerRegister;
import de.vw.mib.view.internal.ViewHandlerServices;

public class AppSystemServicesImpl
implements AppSystemServices {
    private final LoggerFactory loggerFactory;
    private final StatemachineEventDispatcher eventDispatcher;
    private final PerfService perfService;
    private final SkinClassLoader skinClassLoader;
    private final GlobalViewHandlerRegister globalViewHandlerRegister;
    private final ViewHandlerServices viewHandlerServices;
    private final CioVisualizationRegister cioVisualizationRegister;
    private final ViewEventDispatcher viewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinClassLoader;
    static /* synthetic */ Class class$de$vw$mib$view$internal$GlobalViewHandlerRegister;
    static /* synthetic */ Class class$de$vw$mib$view$internal$ViewHandlerServices;
    static /* synthetic */ Class class$de$vw$mib$appui$cio$CioVisualizationRegister;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$ViewEventDispatcher;

    public AppSystemServicesImpl(LoggerFactory loggerFactory, StatemachineEventDispatcher statemachineEventDispatcher, PerfService perfService, SkinClassLoader skinClassLoader, GlobalViewHandlerRegister globalViewHandlerRegister, ViewHandlerServices viewHandlerServices, CioVisualizationRegister cioVisualizationRegister, ViewEventDispatcher viewEventDispatcher) {
        this.loggerFactory = loggerFactory;
        this.checkInstance(this.loggerFactory, class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = AppSystemServicesImpl.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        this.eventDispatcher = statemachineEventDispatcher;
        this.checkInstance(this.eventDispatcher, class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher = AppSystemServicesImpl.class$("de.vw.mib.event.dispatcher.StatemachineEventDispatcher")) : class$de$vw$mib$event$dispatcher$StatemachineEventDispatcher);
        this.perfService = perfService;
        this.checkInstance(this.perfService, class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = AppSystemServicesImpl.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService);
        this.skinClassLoader = skinClassLoader;
        this.checkInstance(this.skinClassLoader, class$de$vw$mib$skin$SkinClassLoader == null ? (class$de$vw$mib$skin$SkinClassLoader = AppSystemServicesImpl.class$("de.vw.mib.skin.SkinClassLoader")) : class$de$vw$mib$skin$SkinClassLoader);
        this.globalViewHandlerRegister = globalViewHandlerRegister;
        this.checkInstance(this.globalViewHandlerRegister, class$de$vw$mib$view$internal$GlobalViewHandlerRegister == null ? (class$de$vw$mib$view$internal$GlobalViewHandlerRegister = AppSystemServicesImpl.class$("de.vw.mib.view.internal.GlobalViewHandlerRegister")) : class$de$vw$mib$view$internal$GlobalViewHandlerRegister);
        this.viewHandlerServices = viewHandlerServices;
        this.checkInstance(this.viewHandlerServices, class$de$vw$mib$view$internal$ViewHandlerServices == null ? (class$de$vw$mib$view$internal$ViewHandlerServices = AppSystemServicesImpl.class$("de.vw.mib.view.internal.ViewHandlerServices")) : class$de$vw$mib$view$internal$ViewHandlerServices);
        this.cioVisualizationRegister = cioVisualizationRegister;
        this.checkInstance(this.cioVisualizationRegister, class$de$vw$mib$appui$cio$CioVisualizationRegister == null ? (class$de$vw$mib$appui$cio$CioVisualizationRegister = AppSystemServicesImpl.class$("de.vw.mib.appui.cio.CioVisualizationRegister")) : class$de$vw$mib$appui$cio$CioVisualizationRegister);
        this.viewEventDispatcher = viewEventDispatcher;
        this.checkInstance(this.viewEventDispatcher, class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = AppSystemServicesImpl.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher);
    }

    private void checkInstance(Object object, Class clazz) {
        Preconditions.checkInstanceOf(clazz, object, new StringBuffer().append("Service ").append(clazz.getName()).toString());
    }

    @Override
    public LoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override
    public StatemachineEventDispatcher getEventDispatcher() {
        return this.eventDispatcher;
    }

    @Override
    public PerfService getPerfService() {
        return this.perfService;
    }

    @Override
    public SkinClassLoader getSkinClassLoader() {
        return this.skinClassLoader;
    }

    @Override
    public GlobalViewHandlerRegister getGlobalViewHandlerRegister() {
        return this.globalViewHandlerRegister;
    }

    @Override
    public ViewHandlerServices getViewHandlerServices() {
        return this.viewHandlerServices;
    }

    @Override
    public CioVisualizationRegister getCioVisualizationRegister() {
        return this.cioVisualizationRegister;
    }

    @Override
    public ViewEventDispatcher getViewEventDispatcher() {
        return this.viewEventDispatcher;
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

