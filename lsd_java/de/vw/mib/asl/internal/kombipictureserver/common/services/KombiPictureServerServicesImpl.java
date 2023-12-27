/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.services;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.kombipictureserver.common.services.KombiPictureServerServices;
import de.vw.mib.asl.internal.kombipictureserver.common.services.LoggerFacade;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class KombiPictureServerServicesImpl
implements KombiPictureServerServices {
    private final BundleContext bundleContext;
    private ASLDatapool dataPool;
    private final Logger logger;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final TimerManager timerManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer;

    public KombiPictureServerServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.bundleContext = services.getBundleContext();
        this.threadSwitchingTarget = services.getASLThreadSwitch();
        this.timerManager = services.getTimerManager();
        ServiceReference serviceReference = this.bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = KombiPictureServerServicesImpl.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        LoggerFactory loggerFactory = (LoggerFactory)this.bundleContext.getService(serviceReference);
        this.logger = loggerFactory.getLogger(2);
    }

    @Override
    public LoggerFacade createLoggerFacade(Class clazz, int n) {
        return new LoggerFacade(this.logger, clazz, n);
    }

    @Override
    public ASLDatapool getDataPool() {
        if (this.dataPool == null) {
            this.dataPool = (ASLDatapool)this.getService(class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = KombiPictureServerServicesImpl.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool);
        }
        return this.dataPool;
    }

    @Override
    public DSIKombiPictureServer getDsiKombiPictureServer(Target target) {
        return (DSIKombiPictureServer)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(target, class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = KombiPictureServerServicesImpl.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        return this.threadSwitchingTarget;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    private Object getService(Class clazz) {
        ServiceReference serviceReference = this.bundleContext.getServiceReference(clazz.getName());
        Object object = serviceReference != null ? this.bundleContext.getService(serviceReference) : null;
        return object;
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

