/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.globalsetupwizard.wizard.WizardService;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistenceService;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistenceServiceImpl;
import de.vw.mib.asl.internal.globalsetupwizard.GlobalSetupWizardServices;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class GlobalSetupWizardServicesImpl
implements GlobalSetupWizardServices {
    private final ASLListManager listManager;
    private final CioDictionary cioDictionary;
    private final ASLPropertyManager propertyManager;
    private final Logger logger;
    private final GenericEvents genericEvents;
    private final ServiceRegister serviceRegister;
    private final CioFactory cioFactory;
    private final CioDispatcher cioDispatcher;
    private final GlobalSetupWizardPersistenceService globalSetupWirzadPersistenceService;
    private final FactoryResetService factoryResetService;
    private final StartupStateService startupStateService;
    private final SystemStateService systemStateService;
    private WizardService wizardService;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioFactory;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public GlobalSetupWizardServicesImpl() {
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
        this.listManager = services.getASLListManager();
        this.propertyManager = services.getASLPropertyManager();
        this.genericEvents = services.getGenericEvents();
        this.serviceRegister = this.genericEvents.getServiceRegister();
        BundleContext bundleContext = services.getBundleContext();
        this.cioDictionary = (CioDictionary)this.retrieveOsgiService(bundleContext, class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = GlobalSetupWizardServicesImpl.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary);
        this.cioFactory = (CioFactory)this.retrieveOsgiService(bundleContext, class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = GlobalSetupWizardServicesImpl.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory);
        this.cioDispatcher = (CioDispatcher)this.retrieveOsgiService(bundleContext, class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = GlobalSetupWizardServicesImpl.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher);
        this.globalSetupWirzadPersistenceService = GlobalSetupWizardPersistenceServiceImpl.getInstance();
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        this.factoryResetService = aSLSystemAPI.getFactoryResetService();
        this.systemStateService = aSLSystemAPI.getSystemStateService();
        this.startupStateService = ASLStartupv7rFactory.getStartupv7rApi().getStartupStateService();
    }

    @Override
    public StartupStateService getStartupStateService() {
        return this.startupStateService;
    }

    @Override
    public ASLListManager getListManager() {
        return this.listManager;
    }

    @Override
    public CioDictionary getCioDictionary() {
        return this.cioDictionary;
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.propertyManager;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public CioFactory getCioFactory() {
        return this.cioFactory;
    }

    @Override
    public CioDispatcher getCioDispatcher() {
        return this.cioDispatcher;
    }

    @Override
    public GlobalSetupWizardPersistenceService getGlobalSetupWirzadPersistenceService() {
        return this.globalSetupWirzadPersistenceService;
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        return this.factoryResetService;
    }

    @Override
    public SystemStateService getSystemStateService() {
        return this.systemStateService;
    }

    @Override
    public WizardService getWizardService() {
        return this.wizardService;
    }

    public void setWizardService(WizardService wizardService) {
        this.wizardService = wizardService;
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

