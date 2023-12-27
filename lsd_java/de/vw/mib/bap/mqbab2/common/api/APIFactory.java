/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api;

import de.vw.mib.asl.api.bap.BAPInterfaceProvider;
import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoDummyService;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoService;
import de.vw.mib.bap.mqbab2.common.api.car.CarASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.car.CarService;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeDummyService;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayDummyService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationAdapter;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxService;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventAdapter;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.persistence.PersistenceAdapter;
import de.vw.mib.bap.mqbab2.common.api.persistence.PersistenceService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationDummyService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.timer.TimerAdapter;
import de.vw.mib.bap.mqbab2.common.api.timer.TimerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerASLDataAdapter;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerDummyService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingServiceImpl;
import de.vw.mib.bap.stream.BitStreamTransformer;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.format.FixFormat;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class APIFactory
implements APIFactoryInterface {
    private static APIFactoryInterface INSTANCE;
    private static AddressbookService addressbookService;
    private static AndroidAutoService androidAutoService;
    private static CarService carService;
    private static CarLifeService carLifeService;
    private static CarPlayService carPlayService;
    private static ConnectivityService connectivityService;
    private static ExboxService exboxService;
    private static HMIEventService hmiEventService;
    private static MediaService mediaService;
    private static NavigationService navigationService;
    private static PhoneService phoneService;
    private static RadioService radioService;
    private static SmartphoneIntegrationService smartphoneIntegrationService;
    private static SoundService soundService;
    private static SpeechService speechService;
    private static SystemService systemService;
    private static TvTunerService tvTunerService;
    private static ValetParkingService valetParkingService;
    private static BAPDispatcher bapDispatcher;
    private static BitStreamTransformer bitStreamTransformer;
    private static PersistenceService persistenceService;
    private static Logger logger;
    private static ConfigurationService configurationService;
    private static ThreadSwitchingTarget threadSwitchingService;
    private static TimerService timerService;
    private static ASLDatapool dataPool;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$BAPSystemEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;

    private APIFactory() {
    }

    public static APIFactoryInterface getAPIFactory() {
        if (INSTANCE == null) {
            INSTANCE = new APIFactory();
        }
        return INSTANCE;
    }

    @Override
    public AddressbookService getAddressbookService() {
        if (addressbookService == null) {
            addressbookService = new AddressbookASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return addressbookService;
    }

    @Override
    public AndroidAutoService getAndroidAutoService() {
        if (androidAutoService == null) {
            androidAutoService = this.getConfigurationService().isAndroidAutoFeatureSelected() ? new AndroidAutoASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool()) : new AndroidAutoDummyService();
        }
        return androidAutoService;
    }

    @Override
    public CarService getCarService() {
        if (carService == null) {
            carService = new CarASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return carService;
    }

    @Override
    public CarLifeService getCarLifeService() {
        if (carLifeService == null) {
            carLifeService = this.getConfigurationService().isCarLifeFeatureSelected() ? new CarLifeASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool()) : new CarLifeDummyService();
        }
        return carLifeService;
    }

    @Override
    public CarPlayService getCarPlayService() {
        if (carPlayService == null) {
            carPlayService = this.getConfigurationService().isCarPlayFeatureSelected() ? new CarPlayASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool()) : new CarPlayDummyService();
        }
        return carPlayService;
    }

    @Override
    public ConnectivityService getConnectivityService() {
        if (connectivityService == null) {
            connectivityService = new ConnectivityASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return connectivityService;
    }

    @Override
    public ExboxService getExboxService() {
        if (exboxService == null) {
            exboxService = new ExboxASLDataAdapter();
        }
        return exboxService;
    }

    @Override
    public HMIEventService getHMIEventService() {
        if (hmiEventService == null) {
            hmiEventService = new HMIEventAdapter(APIFactory.getAPIFactory());
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().registerService((class$de$vw$mib$event$consumer$BAPSystemEventConsumer == null ? (class$de$vw$mib$event$consumer$BAPSystemEventConsumer = APIFactory.class$("de.vw.mib.event.consumer.BAPSystemEventConsumer")) : class$de$vw$mib$event$consumer$BAPSystemEventConsumer).getName(), (Object)hmiEventService, null);
        }
        return hmiEventService;
    }

    @Override
    public MediaService getMediaService() {
        if (mediaService == null) {
            mediaService = new MediaASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return mediaService;
    }

    @Override
    public NavigationService getNavigationService() {
        if (navigationService == null) {
            navigationService = new NavigationASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return navigationService;
    }

    @Override
    public PhoneService getPhoneService() {
        if (phoneService == null) {
            phoneService = new PhoneASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return phoneService;
    }

    @Override
    public RadioService getRadioService() {
        if (radioService == null) {
            radioService = new RadioASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return radioService;
    }

    @Override
    public SmartphoneIntegrationService getSmartphoneIntegrationService() {
        if (smartphoneIntegrationService == null) {
            smartphoneIntegrationService = this.getConfigurationService().isAppConnectFeatureSelected() ? new SmartphoneIntegrationASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool()) : new SmartphoneIntegrationDummyService();
        }
        return smartphoneIntegrationService;
    }

    @Override
    public SoundService getSoundService() {
        if (soundService == null) {
            soundService = new SoundASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return soundService;
    }

    @Override
    public SpeechService getSpeechService() {
        if (speechService == null) {
            speechService = new SpeechASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return speechService;
    }

    @Override
    public SystemService getSystemService() {
        if (systemService == null) {
            systemService = new SystemASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool());
        }
        return systemService;
    }

    @Override
    public TvTunerService getTvTunerService() {
        if (tvTunerService == null) {
            tvTunerService = this.getConfigurationService().isTvFeatureSelected() ? new TvTunerASLDataAdapter(APIFactory.getAPIFactory(), this.getDataPool()) : new TvTunerDummyService();
        }
        return tvTunerService;
    }

    @Override
    public ValetParkingService getValetParkingService() {
        if (valetParkingService == null) {
            valetParkingService = new ValetParkingServiceImpl();
        }
        return valetParkingService;
    }

    @Override
    public BAPDispatcher getBapDispatcher() {
        if (bapDispatcher == null) {
            bapDispatcher = new BAPInterfaceProvider(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext()).getBapDispatcher();
        }
        return bapDispatcher;
    }

    @Override
    public BitStreamTransformer getBitStreamTransformer() {
        if (bitStreamTransformer == null) {
            bitStreamTransformer = new BitStreamTransformer();
        }
        return bitStreamTransformer;
    }

    @Override
    public PersistenceService getPersistenceService() {
        if (persistenceService == null) {
            persistenceService = new PersistenceAdapter(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), APIFactory.getAPIFactory());
        }
        return persistenceService;
    }

    @Override
    public Logger getLogger() {
        LoggerFactory loggerFactory;
        if (logger == null && (loggerFactory = (LoggerFactory)APIFactory.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = APIFactory.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory)) != null) {
            logger = loggerFactory.getLogger(2);
        }
        return logger;
    }

    @Override
    public GenericEvents getGenericEventsService() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
    }

    @Override
    public EventFactory getEventFactory() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getEventFactory();
    }

    @Override
    public FixFormat getFixFormatter() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getFixFormat4Asl();
    }

    @Override
    public ConfigurationService getConfigurationService() {
        if (configurationService == null) {
            configurationService = new ConfigurationAdapter(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getConfigurationManagerDiag(), APIFactory.getAPIFactory(), this.getDataPool());
        }
        return configurationService;
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingService() {
        if (threadSwitchingService == null) {
            threadSwitchingService = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
        }
        return threadSwitchingService;
    }

    @Override
    public TimerService getTimerService() {
        if (timerService == null) {
            timerService = new TimerAdapter(APIFactory.getAPIFactory());
        }
        return timerService;
    }

    private ASLDatapool getDataPool() {
        if (dataPool == null) {
            dataPool = (ASLDatapool)APIFactory.getService(class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = APIFactory.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool);
        }
        return dataPool;
    }

    private static Object getService(Class clazz) {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        Object object = serviceReference != null ? bundleContext.getService(serviceReference) : null;
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

    static {
        bapDispatcher = null;
    }
}

