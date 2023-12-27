/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.ASLCarAPI;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppService;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.clock.DateTimeService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceService;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceServiceImpl;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.TileInstallerImpl;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionAppProvider;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionAppServiceImpl;
import de.vw.mib.asl.internal.impl.homescreen.util.HostedAppBinder;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class HomeScreenServicesImpl
implements HomeScreenServices {
    private final GenericEvents genericEvents;
    private final Logger logger;
    private final ServiceRegister serviceRegister;
    private final BundleContext bundleContext;
    private final ASLListManager listManager;
    private final ASLPropertyManager aslPropertyManager;
    private final FactoryResetService factoryResetService;
    private final ConfigurationManager configurationManager;
    private final DriverDistractionPreventionService driverDistractionPreventionService;
    private final Tile[] tiles;
    private final TimerManager timerManager;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final TileSelectionAppServiceImpl tileSelectionAppService;
    private final SystemEventDispatcher systemEventDispatcher;
    private TileInstaller tileInstaller;
    private CioDictionary cioDictionary;
    private CioDispatcher cioDispatcher;
    private CioFactory cioFactory;
    private HostedAppBinder hostedAppBinder;
    private DateTimeService dateTimeService;
    private PersonalizationService personalizationService;
    private HomescreenPersistenceService homescreenPersistenceService;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$cio$CioFactory;

    public HomeScreenServicesImpl(Tile[] tileArray) {
        this.tiles = tileArray;
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        ASLCarAPI aSLCarAPI = ASLCarFactory.getCarApi();
        Services services = aSLFrameworkAPI.getServices();
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.listManager = services.getASLListManager();
        this.aslPropertyManager = services.getASLPropertyManager();
        this.genericEvents = services.getGenericEvents();
        this.serviceRegister = this.genericEvents.getServiceRegister();
        this.bundleContext = services.getBundleContext();
        this.timerManager = services.getTimerManager();
        this.threadSwitchingTarget = services.getASLThreadSwitch();
        this.systemEventDispatcher = services.getSystemEventDispatcher();
        this.dateTimeService = aSLSystemAPI.getDateTimeService();
        this.factoryResetService = aSLSystemAPI.getFactoryResetService();
        this.driverDistractionPreventionService = aSLSystemAPI.getDriverDistractionPreventionService();
        this.personalizationService = aSLCarAPI.getCarPersonalizationService();
        this.configurationManager = services.getConfigurationManagerDiag();
        this.homescreenPersistenceService = HomescreenPersistenceServiceImpl.getInstance();
        this.tileInstaller = new TileInstallerImpl(this);
        this.tileSelectionAppService = new TileSelectionAppServiceImpl(this, this.tileInstaller);
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
    public ASLPropertyManager getASLPropertyManager() {
        return this.aslPropertyManager;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public ASLListManager getASLListManager() {
        return this.listManager;
    }

    @Override
    public CioDictionary getCioDictionary() {
        if (this.cioDictionary == null) {
            this.cioDictionary = (CioDictionary)this.retrieveOsgiService(class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = HomeScreenServicesImpl.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary);
        }
        return this.cioDictionary;
    }

    @Override
    public CioDispatcher getCioDispatcher() {
        if (this.cioDispatcher == null) {
            this.cioDispatcher = (CioDispatcher)this.retrieveOsgiService(class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = HomeScreenServicesImpl.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher);
        }
        return this.cioDispatcher;
    }

    @Override
    public CioFactory getCioFactory() {
        if (this.cioFactory == null) {
            this.cioFactory = (CioFactory)this.retrieveOsgiService(class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = HomeScreenServicesImpl.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory);
        }
        return this.cioFactory;
    }

    @Override
    public Tile[] getTiles() {
        return this.tiles;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        return this.threadSwitchingTarget;
    }

    @Override
    public HostedAppBinder getHostedAppBinder() {
        if (this.hostedAppBinder == null) {
            this.hostedAppBinder = new HostedAppBinder(this.getCioDictionary(), this.getCioDispatcher(), this.getCioFactory());
        }
        return this.hostedAppBinder;
    }

    @Override
    public TileSelectionAppProvider getTileSelectionAppProvider() {
        return this.tileSelectionAppService;
    }

    @Override
    public TileSelectionAppService getTileSelectionAppService() {
        return this.tileSelectionAppService;
    }

    @Override
    public DateTimeService getDateTimeService() {
        return this.dateTimeService;
    }

    @Override
    public PersonalizationService getPersonalizationService() {
        return this.personalizationService;
    }

    @Override
    public HomescreenPersistenceService getHomeScreenPersistenceService() {
        return this.homescreenPersistenceService;
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        return this.factoryResetService;
    }

    @Override
    public TileInstaller getTileInstaller() {
        return this.tileInstaller;
    }

    @Override
    public DriverDistractionPreventionService getDriverDistractionPreventionService() {
        return this.driverDistractionPreventionService;
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.systemEventDispatcher;
    }

    @Override
    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

    private Object retrieveOsgiService(Class clazz) {
        ServiceReference serviceReference = this.bundleContext.getServiceReference(clazz.getName());
        return this.bundleContext.getService(serviceReference);
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

