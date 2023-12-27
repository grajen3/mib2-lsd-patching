/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homebutton;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.homescreen.ASLHomeScreenFactory;
import de.vw.mib.asl.api.homescreen.HomeScreenPages;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.homebutton.HomeButtonServices;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class HomeButtonServicesImpl
implements HomeButtonServices {
    private final ServiceRegister serviceRegister;
    private final GenericEvents genericEvents;
    private final EventDispatcherHSM eventDispatcher;
    private final Logger logger;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final UserInteractionLockService lockService;
    private final ASLPropertyManager aslPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public HomeButtonServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.genericEvents = services.getGenericEvents();
        this.serviceRegister = this.genericEvents.getServiceRegister();
        this.eventDispatcher = this.genericEvents.getEventDispatcher();
        this.logger = aSLFrameworkAPI.getASLLogger();
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        this.lockService = aSLSystemAPI.getUserInteractionLockService();
        this.aslPropertyManager = services.getASLPropertyManager();
        BundleContext bundleContext = services.getBundleContext();
        this.cioDictionary = (CioDictionary)this.retrieveServiceFromOsgi(class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = HomeButtonServicesImpl.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary, bundleContext);
        this.cioDispatcher = (CioDispatcher)this.retrieveServiceFromOsgi(class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = HomeButtonServicesImpl.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher, bundleContext);
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public EventDispatcherHSM getEventDispatcher() {
        return this.eventDispatcher;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public CioDictionary getCioDictionary() {
        return this.cioDictionary;
    }

    @Override
    public CioDispatcher getCioDispatcher() {
        return this.cioDispatcher;
    }

    @Override
    public UserInteractionLockService getUserInteractionLockService() {
        return this.lockService;
    }

    private Object retrieveServiceFromOsgi(Class clazz, BundleContext bundleContext) {
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
    }

    @Override
    public HomeScreenPages getHomeScreenPages() {
        return ASLHomeScreenFactory.getHomeScreenApi().getHomeScreenPages();
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

