/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactAddressDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactSelectAddressController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactXController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactXMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactsController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactsMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service.ContactAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service.ContactAddressDataService;
import de.vw.mib.genericevents.AbstractTarget;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts.ASLSpeechNavigationControllerContactsDeviceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ContactsBootstrap
extends BootstraperBase {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;

    public ContactsBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler) {
        super(abstractTarget, resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        ResultListHandler resultListHandler = this.resultHandler.getResultListHandler();
        try {
            RecognizedEventConsumer recognizedEventConsumer = new NavigateContactsMainController();
            resultControllerRouter.register(recognizedEventConsumer, -1679740096);
            recognizedEventConsumer = new NavigateContactXMainController();
            resultControllerRouter.register(recognizedEventConsumer, -1662962880);
            recognizedEventConsumer = new NavigateContactsController();
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1728452864);
            resultControllerRouter.register(recognizedEventConsumer, -1629408448);
            resultControllerRouter.register(recognizedEventConsumer, -1646185664);
            recognizedEventConsumer = new NavigateContactXController(new ContactAdditionalDataService(), resultListHandler);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1745230080);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1913002240);
            recognizedEventConsumer = new NavigateContactSelectAddressController(new ContactAddressDataService(), (ResultItemRowNumberHandler)resultListHandler);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1778784512);
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), -169790656);
            recognizedEventConsumer = new NavigateContactAddressDetailController();
            resultControllerRouter.register((ModelEventConsumer)((Object)recognizedEventConsumer), 1762007296);
            recognizedEventConsumer = new NavigateContactHelpController();
            resultControllerRouter.register(recognizedEventConsumer, 1809920832);
            this.registerObservers();
            this.registerDevices();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1728452864, 1745230080, 1913002240, 1762007296, 1778784512, -169790656});
    }

    private void registerDevices() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = ContactsBootstrap.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName());
        ASLDeviceRegistry aSLDeviceRegistry = (ASLDeviceRegistry)bundleContext.getService(serviceReference);
        aSLDeviceRegistry.registerASLDevice(ASLSpeechNavigationControllerContactsDeviceImpl.getInstance());
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

