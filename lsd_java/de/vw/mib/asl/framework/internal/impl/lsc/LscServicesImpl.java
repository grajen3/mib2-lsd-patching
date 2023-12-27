/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.impl.lsc.AutomaticLanguageModeInstallerImpl;
import de.vw.mib.asl.framework.internal.impl.lsc.LscLogger;
import de.vw.mib.asl.framework.internal.lsc.AutomaticLanguageModeInstaller;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;

public final class LscServicesImpl
implements LscServices {
    private final AutomaticLanguageModeInstaller automaticLanguageModeInstaller;
    private final LscLogger lscLogger;
    private final GenericEvents genericEvents;
    private final ASLPropertyManager aslPropertyManager;
    private final FactoryResetService factoryResetService;
    private final ASLComponentRegistry componentRegistry;
    private final AsyncServiceFactory asyncServiceFactory;
    private final BundleContext bundleContext;

    LscServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.aslPropertyManager = services.getASLPropertyManager();
        this.genericEvents = services.getGenericEvents();
        Logger logger = this.genericEvents.getLoggerFactory().getLogger(1024);
        this.lscLogger = new LscLogger(logger);
        this.automaticLanguageModeInstaller = new AutomaticLanguageModeInstallerImpl(services, logger);
        this.factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        this.componentRegistry = services.getASLComponentRegistry();
        this.asyncServiceFactory = services.getASLAsyncServiceFactory();
        this.bundleContext = services.getBundleContext();
    }

    @Override
    public AdaptionApi getAdaptionApi() {
        return ServiceManager.adaptionApi;
    }

    @Override
    public AutomaticLanguageModeInstaller getAutomaticLanguageModeInstaller() {
        return this.automaticLanguageModeInstaller;
    }

    @Override
    public ConfigurationManagerDiag getConfigManagerDiag() {
        return ServiceManager.configManagerDiag;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public LscLogger getLscLogger() {
        return this.lscLogger;
    }

    @Override
    public AslPersistenceSyncApi getPersistenceSyncApi() {
        return ServiceManager.persistence;
    }

    @Override
    public ASLPropertyManager getPropertyManager() {
        return this.aslPropertyManager;
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        return this.factoryResetService;
    }

    @Override
    public ASLComponentRegistry getAslComponentRegistry() {
        return this.componentRegistry;
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactory() {
        return this.asyncServiceFactory;
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }
}

