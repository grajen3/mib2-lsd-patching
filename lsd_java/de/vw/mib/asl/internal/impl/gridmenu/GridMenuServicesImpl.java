/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistenceService;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistenceServiceImpl;
import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServices;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.debug.screenshot.ScreenshotProvider;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class GridMenuServicesImpl
implements GridMenuServices {
    private final ASLListManager aslListManager;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final ConfigurationManagerDiag configurationManager;
    private final GenericEvents genericEvents;
    private final Logger logger;
    private final ScreenshotProvider screenshotProvider;
    private final ServiceRegister serviceRegister;
    private final ASLSystemAPI systemAPI;
    private final GridMenuPersistenceService persistenceService;
    private final ASLPropertyManager propertyManager;
    static /* synthetic */ Class class$de$vw$mib$debug$screenshot$ScreenshotProvider;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public GridMenuServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.genericEvents = services.getGenericEvents();
        this.serviceRegister = this.genericEvents.getServiceRegister();
        this.configurationManager = services.getConfigurationManagerDiag();
        this.systemAPI = ASLSystemFactory.getSystemApi();
        this.aslListManager = services.getASLListManager();
        this.persistenceService = GridMenuPersistenceServiceImpl.getInstance();
        this.propertyManager = services.getASLPropertyManager();
        BundleContext bundleContext = services.getBundleContext();
        this.screenshotProvider = (ScreenshotProvider)this.retrieveOsgiService(bundleContext, class$de$vw$mib$debug$screenshot$ScreenshotProvider == null ? (class$de$vw$mib$debug$screenshot$ScreenshotProvider = GridMenuServicesImpl.class$("de.vw.mib.debug.screenshot.ScreenshotProvider")) : class$de$vw$mib$debug$screenshot$ScreenshotProvider);
        this.cioDictionary = (CioDictionary)this.retrieveOsgiService(bundleContext, class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = GridMenuServicesImpl.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary);
        this.cioDispatcher = (CioDispatcher)this.retrieveOsgiService(bundleContext, class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = GridMenuServicesImpl.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher);
    }

    @Override
    public ASLListManager getAslListManager() {
        return this.aslListManager;
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
    public ConfigurationManagerDiag getConfigurationManager() {
        return this.configurationManager;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public GridMenuPersistenceService getPersistenceService() {
        return this.persistenceService;
    }

    @Override
    public ScreenshotProvider getScreenshotProvider() {
        return this.screenshotProvider;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public ASLPropertyManager getASLPropertyManager() {
        return this.propertyManager;
    }

    @Override
    public ASLSystemAPI getSystemAPI() {
        return this.systemAPI;
    }

    private Object retrieveOsgiService(BundleContext bundleContext, Class clazz) {
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
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

