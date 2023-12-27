/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.controller.DestinationInputCityMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.city.service.CityAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.DestinationInputCountryUpdater;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.service.CountryAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.service.CountryStateService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneshotMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.service.OneShotService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.service.PostalCodeAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.service.StateAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.service.StreetAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListenerImpl;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.ASLSpeechNavigationControllerDestinationInputDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.city.ASLSpeechNavigationControllerDestinationInputCityDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.country.ASLSpeechNavigationControllerDestinationInputCountryDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.crossing.ASLSpeechNavigationControllerDestinationInputCrossingDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.postalcode.ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.state.ASLSpeechNavigationControllerDestinationInputStateDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.street.ASLSpeechNavigationControllerDestinationInputStreetDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class DestinationInputBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public DestinationInputBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        ResultListHandler resultListHandler = this.resultHandler.getResultListHandler();
        ResultItemHandler resultItemHandler = this.resultHandler.getResultItemHandler();
        DestinationDetailListenerImpl destinationDetailListenerImpl = new DestinationDetailListenerImpl();
        try {
            Object object = new DestinationInputHelpController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 1877029696);
            object = new DestinationInputCountryUpdater();
            ((DestinationInputCountryUpdater)object).registerOnLocationChanges();
            object = new DestinationInputCountryMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 2078356288);
            resultControllerRouter.register((ModelEventConsumer)object, 2078356288);
            resultControllerRouter.register((RecognizedEventConsumer)object, -505334976);
            resultControllerRouter.register((ModelEventConsumer)object, -505334976);
            object = new DestinationInputCountryController(new CountryAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1931398336);
            resultControllerRouter.register((ModelEventConsumer)object, 1124473088);
            resultControllerRouter.register((ModelEventConsumer)object, 1141250304);
            object = new DestinationInputStateMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, -1092537536);
            resultControllerRouter.register((ModelEventConsumer)object, -1092537536);
            resultControllerRouter.register((RecognizedEventConsumer)object, -488557760);
            resultControllerRouter.register((ModelEventConsumer)object, -488557760);
            object = new DestinationInputStateController(new StateAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -941542592);
            resultControllerRouter.register((ModelEventConsumer)object, 1158027520);
            resultControllerRouter.register((ModelEventConsumer)object, 1174804736);
            object = new DestinationInputCountryStateController(new CountryStateService(new ApplicationVariantImpl()), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1058983104);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1075760320);
            resultControllerRouter.register((ModelEventConsumer)object, 1208359168);
            resultControllerRouter.register((ModelEventConsumer)object, 1191581952);
            object = new DestinationInputCityMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 2095133504);
            resultControllerRouter.register((ModelEventConsumer)object, 2095133504);
            resultControllerRouter.register((RecognizedEventConsumer)object, -471780544);
            resultControllerRouter.register((ModelEventConsumer)object, -471780544);
            object = new DestinationInputCityController(new CityAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1897843904);
            resultControllerRouter.register((RecognizedEventConsumer)object, -924765376);
            resultControllerRouter.register((RecognizedEventConsumer)object, -119459008);
            resultControllerRouter.register((ModelEventConsumer)object, 1225136384);
            resultControllerRouter.register((ModelEventConsumer)object, 1241913600);
            object = new DestinationInputPostalCodeMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 2111910720);
            resultControllerRouter.register((ModelEventConsumer)object, 2111910720);
            resultControllerRouter.register((RecognizedEventConsumer)object, -455003328);
            resultControllerRouter.register((ModelEventConsumer)object, -455003328);
            object = new DestinationInputPostalCodeController(new PostalCodeAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -102681792);
            resultControllerRouter.register((RecognizedEventConsumer)object, -85904576);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1864289472);
            resultControllerRouter.register((ModelEventConsumer)object, 1258690816);
            object = new DestinationInputStreetMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 2128687936);
            resultControllerRouter.register((ModelEventConsumer)object, 2128687936);
            resultControllerRouter.register((RecognizedEventConsumer)object, -438226112);
            resultControllerRouter.register((ModelEventConsumer)object, -438226112);
            object = new DestinationInputStreetController(new StreetAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1830735040);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1730071744);
            resultControllerRouter.register((RecognizedEventConsumer)object, -907988160);
            resultControllerRouter.register((RecognizedEventConsumer)object, -891210944);
            resultControllerRouter.register((ModelEventConsumer)object, 1275468032);
            resultControllerRouter.register((ModelEventConsumer)object, 1292245248);
            object = new DestinationInputHouseNumberMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 2145465152);
            resultControllerRouter.register((ModelEventConsumer)object, 2145465152);
            resultControllerRouter.register((RecognizedEventConsumer)object, -421448896);
            resultControllerRouter.register((ModelEventConsumer)object, -421448896);
            object = new DestinationInputHouseNumberController(new HouseNumberDataService(), (ResultItemRowNumberHandler)resultListHandler, resultItemHandler);
            resultControllerRouter.register((ModelEventConsumer)object, 1309022464);
            resultControllerRouter.register((ModelEventConsumer)object, 1862670592);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1797180608);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1495190720);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1478413504);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1713294528);
            resultControllerRouter.register((RecognizedEventConsumer)object, -874433728);
            object = new DestinationInputCrossingMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, -2132724928);
            resultControllerRouter.register((ModelEventConsumer)object, -2132724928);
            resultControllerRouter.register((RecognizedEventConsumer)object, -404671680);
            resultControllerRouter.register((ModelEventConsumer)object, -404671680);
            object = new DestinationInputCrossingController(new StreetAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1780403392);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1696517312);
            resultControllerRouter.register((ModelEventConsumer)object, 1342576896);
            resultControllerRouter.register((ModelEventConsumer)object, 1359354112);
            object = new DestinationInputOneshotMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, -1428081856);
            resultControllerRouter.register((ModelEventConsumer)object, -1428081856);
            resultControllerRouter.register((RecognizedEventConsumer)object, -320785600);
            resultControllerRouter.register((ModelEventConsumer)object, -320785600);
            resultControllerRouter.register((ModelEventConsumer)object, 1929779456);
            resultControllerRouter.register((ModelEventConsumer)object, 1627789568);
            object = new DestinationInputOneShotController(new OneShotService(new ApplicationVariantImpl()), resultListHandler);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1444859072);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1461636288);
            resultControllerRouter.register((ModelEventConsumer)object, 1594235136);
            resultControllerRouter.register((ModelEventConsumer)object, 1611012352);
            resultControllerRouter.register((ModelEventConsumer)object, 1577457920);
            resultControllerRouter.register((ModelEventConsumer)object, -975097024);
            resultControllerRouter.register((ModelEventConsumer)object, 1644566784);
            resultControllerRouter.register((ModelEventConsumer)object, 1661344000);
            resultControllerRouter.register((ModelEventConsumer)object, 1678121216);
            resultControllerRouter.register((RecognizedEventConsumer)object, -69127360);
            resultControllerRouter.register((RecognizedEventConsumer)object, -52350144);
            resultControllerRouter.register((RecognizedEventConsumer)object, -35572928);
            object = new DestinationInputDetailController(destinationDetailListenerImpl);
            resultControllerRouter.register((ModelEventConsumer)object, 1694898432);
            resultControllerRouter.register((ModelEventConsumer)object, 1711675648);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1124473088, 1141250304, 1158027520, 1174804736, 1191581952, 1208359168, 1225136384, 1241913600, 1258690816, 1275468032, 1292245248, 1342576896, 1309022464, 1325799680, 1359354112, 1577457920, 1594235136, 1611012352, 1627789568, 1929779456, -975097024, -958319808, -1394527424, -1377750208, -1360972992, -1344195776, 1644566784, 1661344000, 1678121216, 1862670592, -1008651456, -991874240, -1495190720, 2078356288, -505334976, -1092537536, -488557760, 2095133504, -471780544, 2111910720, -455003328, -1428081856, -320785600, 2128687936, -438226112, 2145465152, -421448896, -2132724928, -404671680, 1694898432, 1711675648, -1713294528});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = DestinationInputBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputCountryDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputStateDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputCityDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputStreetDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputCrossingDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl.getInstance());
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

