/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.services;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.globalgoodbye.services.GlobalGoodByeServices;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class GlobalGoodByeServicesImpl
implements GlobalGoodByeServices {
    private final Logger logger;
    private final EventFactory eventFactory;
    private final SystemEventDispatcher systemEventDispatcher;
    private final ASLPropertyManager aslPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    public GlobalGoodByeServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.eventFactory = services.getEventFactory();
        this.systemEventDispatcher = services.getSystemEventDispatcher();
        this.aslPropertyManager = services.getASLPropertyManager();
        BundleContext bundleContext = services.getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = GlobalGoodByeServicesImpl.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(serviceReference);
        this.logger = loggerFactory.getLogger(0x50008000);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public EventFactory getEventFactory() {
        return this.eventFactory;
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.systemEventDispatcher;
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.aslPropertyManager;
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

