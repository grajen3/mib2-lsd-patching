/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderAPI;
import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.displaymanagement.WritableHelper;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayTimer;
import de.vw.mib.asl.framework.internal.displaymanagement.WritableHelperHighEso;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.DisplayableServiceImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public class DisplayManagementServicesImpl
implements DisplayManagementServices {
    private final ConfigurationManagerDiag configurationManager;
    private final GenericEvents genericEvents;
    private final ASLInfotainmentrecorderAPI aslInfotainmentrecorderApi;
    private final ASLNavigationAPI aslNavigationApi;
    private final ASLSystemAPI aslSystemApi;
    private final TimerManager timerManager;
    private final DSIProxy dsiProxy;
    private final Logger logger;
    private final WritableHelper writableHelper;
    private final BundleContext bundleContext;
    private final PerfService perfService;
    private final ASLPropertyManager aslPropertyManager;
    private final DisplayTimer displayTimer;
    private final DisplayableServiceImpl displayableService;
    private final AsyncServiceFactory asyncServiceFactory;

    public DisplayManagementServicesImpl() {
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.asyncServiceFactory = services.getASLAsyncServiceFactory();
        this.configurationManager = services.getConfigurationManagerDiag();
        this.genericEvents = services.getGenericEvents();
        this.timerManager = services.getTimerManager();
        this.bundleContext = services.getBundleContext();
        this.logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
        this.perfService = services.getPerfService();
        this.aslPropertyManager = services.getASLPropertyManager();
        this.aslInfotainmentrecorderApi = ASLInfotainmentrecorderFactory.getInfotainmentrecorderApi();
        this.aslNavigationApi = ASLNavigationFactory.getNavigationApi();
        this.aslSystemApi = ASLSystemFactory.getSystemApi();
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.writableHelper = new WritableHelperHighEso();
        this.displayTimer = new DisplayTimer(this.genericEvents, this.logger);
        this.displayableService = new DisplayableServiceImpl();
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
    public ASLInfotainmentrecorderAPI getAslInfotainmentrecorderApi() {
        return this.aslInfotainmentrecorderApi;
    }

    @Override
    public ASLNavigationAPI getAslNavigationApi() {
        return this.aslNavigationApi;
    }

    @Override
    public ASLSystemAPI getAslSystemApi() {
        return this.aslSystemApi;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public DSIProxy getDsiProxy() {
        return this.dsiProxy;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public WritableHelper getWritableHelper() {
        return this.writableHelper;
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public PerfService getPerfService() {
        return this.perfService;
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.aslPropertyManager;
    }

    @Override
    public DisplayTimer getDisplayTimer() {
        return this.displayTimer;
    }

    @Override
    public DisplayableServiceImpl getDisplayableService() {
        return this.displayableService;
    }

    @Override
    public AsyncServiceFactory getAslAsyncServiceFactory() {
        return this.asyncServiceFactory;
    }
}

