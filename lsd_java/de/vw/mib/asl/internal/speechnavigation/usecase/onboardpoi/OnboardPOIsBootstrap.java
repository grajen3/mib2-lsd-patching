/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi;

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
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIAddressDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIXController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIXMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIListController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOICategoryAdditionalData;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOIDataService;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.ASLSpeechNavigationControllerOnboardPOIsDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class OnboardPOIsBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public OnboardPOIsBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        ResultListHandler resultListHandler = this.resultHandler.getResultListHandler();
        ResultItemHandler resultItemHandler = this.resultHandler.getResultItemHandler();
        try {
            Object object = new OnboardPOIEnterPOIMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, -1595854016);
            object = new OnboardPOIEnterPOIXMainController();
            resultControllerRouter.register((RecognizedEventConsumer)object, -1562299584);
            object = new OnboardPOIEnterPOIController();
            resultControllerRouter.register((ModelEventConsumer)object, 1795561728);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1579076800);
            resultControllerRouter.register((RecognizedEventConsumer)object, -1545522368);
            object = new OnboardPOIEnterPOIXController((AdditionalDataService)new OnboardPOICategoryAdditionalData(), resultListHandler, resultItemHandler);
            resultControllerRouter.register((ModelEventConsumer)object, 1812338944);
            resultControllerRouter.register((ModelEventConsumer)object, 1896225024);
            object = new OnboardPOIDataService();
            ModelEventConsumer modelEventConsumer = new OnboardPOIListController((OnboardPOIDataService)object, (ResultItemRowNumberHandler)resultListHandler);
            resultControllerRouter.register(modelEventConsumer, 1829116160);
            resultControllerRouter.register(modelEventConsumer, -220122304);
            modelEventConsumer = new OnboardPOIAddressDetailController((OnboardPOIDataService)object);
            resultControllerRouter.register(modelEventConsumer, 1845893376);
            resultControllerRouter.register(modelEventConsumer, -203345088);
            object = new OnboardPOIHelpController();
            resultControllerRouter.register((RecognizedEventConsumer)object, 1826698048);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1795561728, 1812338944, 1896225024, 1829116160, -220122304, 1845893376, -203345088});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = OnboardPOIsBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerOnboardPOIsDeviceImpl.getInstance());
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

