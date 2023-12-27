/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIController;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIMainNavigateAddressController;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIMainNavigateContactController;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIMainNavigateGarbage;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIMainNavigatePOIController;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUIService;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class SUIBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public SUIBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        ResultListHandler resultListHandler = this.resultHandler.getResultListHandler();
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        SUICheckerService sUICheckerService = new SUICheckerService(services);
        try {
            RecognizedEventConsumer recognizedEventConsumer = new SUIMainNavigateAddressController(sUICheckerService);
            resultControllerRouter.register(recognizedEventConsumer, -1176423616);
            recognizedEventConsumer = new SUIMainNavigateGarbage(sUICheckerService);
            resultControllerRouter.register(recognizedEventConsumer, -1109314752);
            recognizedEventConsumer = new SUIMainNavigateContactController(sUICheckerService);
            resultControllerRouter.register(recognizedEventConsumer, -1142869184);
            recognizedEventConsumer = new SUIMainNavigatePOIController(sUICheckerService);
            resultControllerRouter.register(recognizedEventConsumer, -1159646400);
            recognizedEventConsumer = new SUIController(new SUIService(), resultListHandler);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1879447808);
            resultControllerRouter.register(recognizedEventConsumer, -1126091968);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1879447808});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = SUIBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerSingleUserInterfaceDeviceImpl.getInstance());
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

