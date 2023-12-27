/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.GuidanceHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceCheckStopoverController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceDestinationDetailsController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StopGuidanceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.DistanceToDestinationController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.EstimatedTimeOfArrivalController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.RemainingTravelTimeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.routeinfo.RouteInformationController;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.ASLSpeechNavigationControllerDestinationDetailsDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class GuidanceBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public GuidanceBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        try {
            RecognizedEventConsumer recognizedEventConsumer = new StartGuidanceController();
            resultControllerRouter.register(recognizedEventConsumer, 1239495488);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1239495488);
            recognizedEventConsumer = new StartGuidanceCheckStopoverController();
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -1998507200);
            recognizedEventConsumer = new StartGuidanceDestinationDetailsController();
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -2115947712);
            recognizedEventConsumer = new StopGuidanceController();
            resultControllerRouter.register(recognizedEventConsumer, 1994470208);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1994470208);
            recognizedEventConsumer = new GuidanceHelpController();
            resultControllerRouter.register(recognizedEventConsumer, 1860252480);
            recognizedEventConsumer = new RouteInformationController();
            resultControllerRouter.register(recognizedEventConsumer, 1927361344);
            recognizedEventConsumer = new RemainingTravelTimeController();
            resultControllerRouter.register(recognizedEventConsumer, 1977692992);
            recognizedEventConsumer = new EstimatedTimeOfArrivalController();
            resultControllerRouter.register(recognizedEventConsumer, 1944138560);
            recognizedEventConsumer = new DistanceToDestinationController();
            resultControllerRouter.register(recognizedEventConsumer, 1960915776);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1994470208, 1239495488, -1998507200, -2115947712, -1964952768});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = GuidanceBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerDestinationDetailsDeviceImpl.getInstance());
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

