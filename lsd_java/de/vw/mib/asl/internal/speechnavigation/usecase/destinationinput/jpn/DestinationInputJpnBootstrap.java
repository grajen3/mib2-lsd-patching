/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberMainControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.service.ChomeAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.service.MunicipalityAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.service.OneShotJpnService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.service.PlaceAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.controller.DestinationInputPrefectureMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.prefecture.service.PrefectureAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.service.WardAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListenerImpl;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.ASLSpeechNavigationControllerDestinationInputDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.chome.ASLSpeechNavigationControllerDestinationInputChomeDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.municipality.ASLSpeechNavigationControllerDestinationInputMunicipalityDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.oneshot.ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.place.ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.prefecture.ASLSpeechNavigationControllerDestinationInputPrefectureDeviceImpl;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.ward.ASLSpeechNavigationControllerDestinationInputWardDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class DestinationInputJpnBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public DestinationInputJpnBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        ResultListHandler resultListHandler = this.resultHandler.getResultListHandler();
        ResultItemHandler resultItemHandler = this.resultHandler.getResultItemHandler();
        DestinationDetailListenerImpl destinationDetailListenerImpl = new DestinationDetailListenerImpl();
        try {
            RecognizedEventConsumer recognizedEventConsumer = new DestinationInputHelpController();
            resultControllerRouter.register(recognizedEventConsumer, 1877029696);
            recognizedEventConsumer = new DestinationInputPrefectureMainController();
            resultControllerRouter.register(recognizedEventConsumer, -840879296);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -387894464);
            recognizedEventConsumer = new DestinationInputPrefectureController(new PrefectureAdditionalDataService(), resultListHandler);
            resultControllerRouter.register(recognizedEventConsumer, -773770432);
            resultControllerRouter.register(recognizedEventConsumer, -756993216);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1376131328);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1392908544);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1409685760);
            recognizedEventConsumer = new DestinationInputMunicipalityMainController();
            resultControllerRouter.register(recognizedEventConsumer, -824102080);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -371117248);
            recognizedEventConsumer = new DestinationInputMunicipalityController(new MunicipalityAdditionalDataService(), resultListHandler);
            resultControllerRouter.register(recognizedEventConsumer, -740216000);
            resultControllerRouter.register(recognizedEventConsumer, -723438784);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1426462976);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1443240192);
            recognizedEventConsumer = new DestinationInputWardController(new WardAdditionalDataService(), resultListHandler);
            resultControllerRouter.register(recognizedEventConsumer, -689884352);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1460017408);
            recognizedEventConsumer = new DestinationInputPlaceMainController();
            resultControllerRouter.register(recognizedEventConsumer, -807324864);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -354340032);
            recognizedEventConsumer = new DestinationInputPlaceController(new PlaceAdditionalDataService(), resultListHandler);
            resultControllerRouter.register(recognizedEventConsumer, -673107136);
            resultControllerRouter.register(recognizedEventConsumer, -656329920);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1476794624);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1493571840);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1510349056);
            recognizedEventConsumer = new DestinationInputChomeMainController();
            resultControllerRouter.register(recognizedEventConsumer, -790547648);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -337562816);
            recognizedEventConsumer = new DestinationInputChomeController(new ChomeAdditionalDataService(), resultListHandler);
            resultControllerRouter.register(recognizedEventConsumer, -639552704);
            resultControllerRouter.register(recognizedEventConsumer, -622775488);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1527126272);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1543903488);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1560680704);
            recognizedEventConsumer = new DestinationInputHouseNumberMainControllerJPN();
            resultControllerRouter.register(recognizedEventConsumer, 2145465152);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -421448896);
            recognizedEventConsumer = new DestinationInputHouseNumberControllerJPN(new HouseNumberDataService(), (ResultItemRowNumberHandler)resultListHandler, resultItemHandler);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1309022464);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1862670592);
            resultControllerRouter.register(recognizedEventConsumer, -1797180608);
            resultControllerRouter.register(recognizedEventConsumer, -1478413504);
            resultControllerRouter.register(recognizedEventConsumer, -1713294528);
            recognizedEventConsumer = new DestinationInputOneshotJpnMainController(destinationDetailListenerImpl);
            resultControllerRouter.register(recognizedEventConsumer, -1428081856);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -320785600);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1627789568);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1929779456);
            recognizedEventConsumer = new DestinationInputOneShotJpnController((AdditionalDataService)new OneShotJpnService(), resultListHandler, destinationDetailListenerImpl);
            resultControllerRouter.register(recognizedEventConsumer, -1444859072);
            resultControllerRouter.register(recognizedEventConsumer, -1461636288);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1577457920);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1611012352);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -153013440);
            recognizedEventConsumer = new DestinationInputDetailController(destinationDetailListenerImpl);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1694898432);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1711675648);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1376131328, 1392908544, 1409685760, 1426462976, 1443240192, 1460017408, 1476794624, 1493571840, 1510349056, 1527126272, 1543903488, 1560680704, 1309022464, -605998272, -589221056, -572443840, -555666624, -538889408, -522112192, -1360972992, -1344195776, 1577457920, 1611012352, 1627789568, 1862670592, 1929779456, -153013440, -136236224, -387894464, -371117248, -354340032, -337562816, -421448896, -320785600, 1694898432, 1711675648});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = DestinationInputJpnBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputOneshotDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputPrefectureDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputMunicipalityDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputWardDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputChomeDeviceImpl.getInstance());
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl.getInstance());
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

