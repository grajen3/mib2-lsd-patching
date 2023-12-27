/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationListController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationNBestListController;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.service.LastDestinationAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.service.LastDestinationDataService;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.lastdestinations.ASLSpeechNavigationControllerLastDestinationsDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class LastDestinationBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public LastDestinationBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        try {
            RecognizedEventConsumer recognizedEventConsumer = new LastDestinationMainController();
            resultControllerRouter.register(recognizedEventConsumer, -1981729984);
            recognizedEventConsumer = new LastDestinationListController(new LastDestinationDataService(), this.resultHandler.getResultItemRowNumberHandler());
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1172386624);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1541485376);
            resultControllerRouter.register(recognizedEventConsumer, 1205941056);
            resultControllerRouter.register(recognizedEventConsumer, 1541485376);
            recognizedEventConsumer = new LastDestinationNBestListController(new LastDestinationAdditionalDataService(), this.resultHandler.getResultListHandler());
            resultControllerRouter.register(recognizedEventConsumer, 1189163840);
            recognizedEventConsumer = new LastDestinationDetailController();
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1558262592);
            recognizedEventConsumer = new LastDestinationHelpController();
            resultControllerRouter.register(recognizedEventConsumer, 1793143616);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1172386624, 1541485376, 1558262592});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = LastDestinationBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerLastDestinationsDeviceImpl.getInstance());
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

