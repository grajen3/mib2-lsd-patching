/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has;

import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASContextStates;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.HASInitializer;
import de.vw.mib.has.HASRegistry;
import generated.de.vw.mib.has.HASContextStatesImpl;
import generated.de.vw.mib.has.HASListPropertyImpl;
import generated.de.vw.mib.has.containers.impl.ListStateContainerImpl;
import generated.de.vw.mib.has.contexts.appconnect.AppConnectServicesAdapter;
import generated.de.vw.mib.has.contexts.appconnect.impl.AppConnectPropertiesImpl;
import generated.de.vw.mib.has.contexts.appconnect.impl.AppConnectResultsImpl;
import generated.de.vw.mib.has.contexts.car.CarServicesAdapter;
import generated.de.vw.mib.has.contexts.car.impl.CarPropertiesImpl;
import generated.de.vw.mib.has.contexts.car.impl.CarResultsImpl;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerServicesAdapter;
import generated.de.vw.mib.has.contexts.entertainmentmanager.impl.EntertainmentManagerPropertiesImpl;
import generated.de.vw.mib.has.contexts.entertainmentmanager.impl.EntertainmentManagerResultsImpl;
import generated.de.vw.mib.has.contexts.exlap.ExlapServicesAdapter;
import generated.de.vw.mib.has.contexts.exlap.impl.ExlapPropertiesImpl;
import generated.de.vw.mib.has.contexts.exlap.impl.ExlapResultsImpl;
import generated.de.vw.mib.has.contexts.has.HASServicesAdapter;
import generated.de.vw.mib.has.contexts.has.impl.HASPropertiesImpl;
import generated.de.vw.mib.has.contexts.has.impl.HASResultsImpl;
import generated.de.vw.mib.has.contexts.media.MediaServicesAdapter;
import generated.de.vw.mib.has.contexts.media.impl.MediaPropertiesImpl;
import generated.de.vw.mib.has.contexts.media.impl.MediaResultsImpl;
import generated.de.vw.mib.has.contexts.navigation.NavigationServicesAdapter;
import generated.de.vw.mib.has.contexts.navigation.impl.NavigationPropertiesImpl;
import generated.de.vw.mib.has.contexts.navigation.impl.NavigationResultsImpl;
import generated.de.vw.mib.has.contexts.onlineservices.OnlineServicesServicesAdapter;
import generated.de.vw.mib.has.contexts.onlineservices.impl.OnlineServicesPropertiesImpl;
import generated.de.vw.mib.has.contexts.onlineservices.impl.OnlineServicesResultsImpl;
import generated.de.vw.mib.has.contexts.phone.PhoneServicesAdapter;
import generated.de.vw.mib.has.contexts.phone.impl.PhonePropertiesImpl;
import generated.de.vw.mib.has.contexts.phone.impl.PhoneResultsImpl;
import generated.de.vw.mib.has.contexts.radio.RadioServicesAdapter;
import generated.de.vw.mib.has.contexts.radio.impl.RadioPropertiesImpl;
import generated.de.vw.mib.has.contexts.radio.impl.RadioResultsImpl;
import generated.de.vw.mib.has.contexts.sound.SoundServicesAdapter;
import generated.de.vw.mib.has.contexts.sound.impl.SoundPropertiesImpl;
import generated.de.vw.mib.has.contexts.sound.impl.SoundResultsImpl;
import generated.de.vw.mib.has.contexts.system.SystemServicesAdapter;
import generated.de.vw.mib.has.contexts.system.impl.SystemPropertiesImpl;
import generated.de.vw.mib.has.contexts.system.impl.SystemResultsImpl;

public class HASInitializerImpl
implements HASInitializer {
    @Override
    public void init(HASFactory hASFactory, HASEngineAPI hASEngineAPI) {
        hASEngineAPI.init(hASFactory);
        hASFactory.setEngine(hASEngineAPI);
        HASContextStatesImpl hASContextStatesImpl = new HASContextStatesImpl(hASEngineAPI.getDatapool(), hASFactory);
        HASInitializerImpl.registerAppConnect(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerCar(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerEntertainmentManager(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerExlap(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerHAS(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerMedia(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerNavigation(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerOnlineServices(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerPhone(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerRadio(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerSound(hASEngineAPI, hASContextStatesImpl);
        HASInitializerImpl.registerSystem(hASEngineAPI, hASContextStatesImpl);
        hASContextStatesImpl.updateContextState("HAS", 2);
    }

    private static void registerAppConnect(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        AppConnectPropertiesImpl appConnectPropertiesImpl = new AppConnectPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("AppConnect", hASContextStates, appConnectPropertiesImpl, new AppConnectResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new AppConnectServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerProperty(57, hASContext);
    }

    private static void registerCar(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        CarPropertiesImpl carPropertiesImpl = new CarPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Car", hASContextStates, carPropertiesImpl, new CarResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new CarServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerProperty(42, hASContext);
        hASRegistry.registerProperty(52, hASContext);
        hASRegistry.registerProperty(56, hASContext);
    }

    private static void registerEntertainmentManager(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        EntertainmentManagerPropertiesImpl entertainmentManagerPropertiesImpl = new EntertainmentManagerPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("EntertainmentManager", hASContextStates, entertainmentManagerPropertiesImpl, new EntertainmentManagerResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new EntertainmentManagerServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerAction(14, hASContext);
        hASRegistry.registerAction(18, hASContext);
        hASRegistry.registerAction(39, hASContext);
        hASRegistry.registerProperty(58, hASContext);
    }

    private static void registerExlap(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        ExlapPropertiesImpl exlapPropertiesImpl = new ExlapPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Exlap", hASContextStates, exlapPropertiesImpl, new ExlapResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new ExlapServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerProperty(30, hASContext);
    }

    private static void registerHAS(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        HASPropertiesImpl hASPropertiesImpl = new HASPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("HAS", hASContextStates, hASPropertiesImpl, new HASResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new HASServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerProperty(1, hASContext);
    }

    private static void registerMedia(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        MediaPropertiesImpl mediaPropertiesImpl = new MediaPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Media", hASContextStates, mediaPropertiesImpl, new MediaResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new MediaServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerAction(6, hASContext);
        hASRegistry.registerAction(7, hASContext);
        hASRegistry.registerAction(8, hASContext);
        hASRegistry.registerAction(15, hASContext);
        hASRegistry.registerAction(16, hASContext);
        hASRegistry.registerAction(17, hASContext);
        hASRegistry.registerAction(19, hASContext);
        hASRegistry.registerAction(29, hASContext);
        hASRegistry.registerAction(32, hASContext);
        hASRegistry.registerAction(33, hASContext);
        hASRegistry.registerAction(35, hASContext);
        hASRegistry.registerAction(36, hASContext);
        hASRegistry.registerProperty(21, hASContext);
        hASRegistry.registerProperty(22, hASContext);
        hASRegistry.registerImmediateProperty(23, hASContext);
        hASRegistry.registerProperty(27, hASContext);
        hASRegistry.registerImmediateProperty(41, hASContext);
        hASRegistry.registerProperty(43, hASContext);
        hASRegistry.registerProperty(47, hASContext);
        hASRegistry.registerProperty(50, hASContext);
        HASInitializerImpl.registerMediaBrowserList(hASRegistry, hASContext, mediaPropertiesImpl);
    }

    private static void registerMediaBrowserList(HASRegistry hASRegistry, HASContext hASContext, MediaPropertiesImpl mediaPropertiesImpl) {
        HASListPropertyImpl hASListPropertyImpl = new HASListPropertyImpl(1, "MediaBrowser", 29, 41, new ListStateContainerImpl(), mediaPropertiesImpl);
        mediaPropertiesImpl.setMediaBrowserList(hASRegistry.registerList(hASListPropertyImpl, hASContext));
    }

    private static void registerNavigation(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        NavigationPropertiesImpl navigationPropertiesImpl = new NavigationPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Navigation", hASContextStates, navigationPropertiesImpl, new NavigationResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new NavigationServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerAction(1, hASContext);
        hASRegistry.registerAction(2, hASContext);
        hASRegistry.registerAction(3, hASContext);
        hASRegistry.registerAction(5, hASContext);
        hASRegistry.registerAction(9, hASContext);
        hASRegistry.registerAction(20, hASContext);
        hASRegistry.registerAction(38, hASContext);
        hASRegistry.registerProperty(1, hASContext);
        hASRegistry.registerImmediateProperty(7, hASContext);
        hASRegistry.registerProperty(8, hASContext);
        hASRegistry.registerProperty(20, hASContext);
        hASRegistry.registerProperty(24, hASContext);
        hASRegistry.registerProperty(29, hASContext);
    }

    private static void registerOnlineServices(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        OnlineServicesPropertiesImpl onlineServicesPropertiesImpl = new OnlineServicesPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("OnlineServices", hASContextStates, onlineServicesPropertiesImpl, new OnlineServicesResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new OnlineServicesServicesAdapter());
        hASRegistry.registerContext(hASContext);
    }

    private static void registerPhone(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        PhonePropertiesImpl phonePropertiesImpl = new PhonePropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Phone", hASContextStates, phonePropertiesImpl, new PhoneResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new PhoneServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerAction(4, hASContext);
    }

    private static void registerRadio(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        RadioPropertiesImpl radioPropertiesImpl = new RadioPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Radio", hASContextStates, radioPropertiesImpl, new RadioResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new RadioServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerAction(21, hASContext);
        hASRegistry.registerAction(22, hASContext);
        hASRegistry.registerAction(23, hASContext);
        hASRegistry.registerAction(24, hASContext);
        hASRegistry.registerAction(25, hASContext);
        hASRegistry.registerAction(26, hASContext);
        hASRegistry.registerAction(27, hASContext);
        hASRegistry.registerAction(28, hASContext);
        hASRegistry.registerAction(30, hASContext);
        hASRegistry.registerAction(31, hASContext);
        hASRegistry.registerProperty(28, hASContext);
        hASRegistry.registerProperty(31, hASContext);
        hASRegistry.registerProperty(32, hASContext);
        hASRegistry.registerProperty(33, hASContext);
        hASRegistry.registerProperty(34, hASContext);
        hASRegistry.registerProperty(35, hASContext);
        hASRegistry.registerProperty(36, hASContext);
        hASRegistry.registerProperty(37, hASContext);
        hASRegistry.registerProperty(38, hASContext);
        hASRegistry.registerProperty(39, hASContext);
        hASRegistry.registerProperty(40, hASContext);
        hASRegistry.registerProperty(48, hASContext);
        hASRegistry.registerProperty(49, hASContext);
    }

    private static void registerSound(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        SoundPropertiesImpl soundPropertiesImpl = new SoundPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("Sound", hASContextStates, soundPropertiesImpl, new SoundResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new SoundServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerAction(10, hASContext);
        hASRegistry.registerAction(11, hASContext);
        hASRegistry.registerAction(12, hASContext);
        hASRegistry.registerAction(13, hASContext);
        hASRegistry.registerAction(34, hASContext);
        hASRegistry.registerImmediateProperty(25, hASContext);
        hASRegistry.registerProperty(26, hASContext);
        hASRegistry.registerImmediateProperty(45, hASContext);
        hASRegistry.registerProperty(46, hASContext);
    }

    private static void registerSystem(HASEngineAPI hASEngineAPI, HASContextStates hASContextStates) {
        HASRegistry hASRegistry = hASEngineAPI.getRegistry();
        SystemPropertiesImpl systemPropertiesImpl = new SystemPropertiesImpl(hASEngineAPI.getDatapool(), hASEngineAPI.getBaseContainerFactory());
        HASContext hASContext = new HASContext("System", hASContextStates, systemPropertiesImpl, new SystemResultsImpl(hASEngineAPI.getCallResults(), hASEngineAPI.getBaseContainerFactory()), new SystemServicesAdapter());
        hASRegistry.registerContext(hASContext);
        hASRegistry.registerProperty(2, hASContext);
        hASRegistry.registerProperty(3, hASContext);
        hASRegistry.registerProperty(4, hASContext);
        hASRegistry.registerProperty(5, hASContext);
        hASRegistry.registerProperty(6, hASContext);
        hASRegistry.registerProperty(9, hASContext);
        hASRegistry.registerProperty(10, hASContext);
        hASRegistry.registerProperty(11, hASContext);
        hASRegistry.registerProperty(12, hASContext);
        hASRegistry.registerProperty(13, hASContext);
        hASRegistry.registerProperty(14, hASContext);
        hASRegistry.registerProperty(15, hASContext);
        hASRegistry.registerProperty(16, hASContext);
        hASRegistry.registerProperty(17, hASContext);
        hASRegistry.registerProperty(18, hASContext);
        hASRegistry.registerProperty(19, hASContext);
        hASRegistry.registerImmediateProperty(44, hASContext);
        hASRegistry.registerProperty(51, hASContext);
        hASRegistry.registerProperty(59, hASContext);
    }
}

