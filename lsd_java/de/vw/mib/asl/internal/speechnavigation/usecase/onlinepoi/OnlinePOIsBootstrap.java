/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi;

import de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedService;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.OnlinePOISearchServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller.OnlinePOIDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller.OnlinePOIDialogController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller.OnlinePOIHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller.OnlinePOIListController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.controller.OnlinePOIMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIHandler;
import de.vw.mib.genericevents.AbstractTarget;

public class OnlinePOIsBootstrap
extends BootstraperBase
implements ASLComponentAPICallback {
    private final SpeechEngine speechEngine;
    private OnlinePOIHandler handler;
    static /* synthetic */ Class class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService;

    public OnlinePOIsBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler, SpeechEngine speechEngine) {
        super(abstractTarget, resultHandler);
        this.speechEngine = speechEngine;
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        try {
            this.handler = new OnlinePOIHandler();
            this.speechEngine.getDialogStateRouter().register(this.handler);
            new OnlinePOISearchServiceAdapter(this.handler);
            this.handler.setOnlineServices(ASLOnlineFactory.getOnlineCoreServices());
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService == null ? (class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService = OnlinePOIsBootstrap.class$("de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedService")) : class$de$vw$mib$asl$api$connectivity$services$networking$InternetConnectionUserBlockedService, this);
            OnlinePOIHelpController onlinePOIHelpController = new OnlinePOIHelpController();
            resultControllerRouter.register(onlinePOIHelpController, 1843475264);
            OnlinePOIMainController onlinePOIMainController = new OnlinePOIMainController(this.handler);
            resultControllerRouter.register(onlinePOIMainController, -1327418560);
            resultControllerRouter.register(onlinePOIMainController, -1293864128);
            resultControllerRouter.register(onlinePOIMainController, 155076864, 0);
            OnlinePOIDialogController onlinePOIDialogController = new OnlinePOIDialogController();
            resultControllerRouter.register(onlinePOIDialogController, 1963333888);
            resultControllerRouter.register(onlinePOIDialogController, 1980111104);
            resultControllerRouter.register(onlinePOIDialogController, -1310641344);
            resultControllerRouter.register(onlinePOIDialogController, -1310641344);
            OnlinePOIListController onlinePOIListController = new OnlinePOIListController(this.handler, this.resultHandler.getResultItemRowNumberHandler());
            resultControllerRouter.register(onlinePOIListController, 1996888320);
            resultControllerRouter.register(onlinePOIListController, -1243532480);
            resultControllerRouter.register(onlinePOIListController, -1193200832);
            resultControllerRouter.register(onlinePOIListController, -1226755264);
            OnlinePOIDetailController onlinePOIDetailController = new OnlinePOIDetailController(this.handler);
            resultControllerRouter.register(onlinePOIDetailController, 2013665536);
            resultControllerRouter.register(onlinePOIDetailController, 2030442752);
            resultControllerRouter.register(onlinePOIDetailController, -1209978048);
            this.registerObservers();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{155076864, 1963333888, -1310641344, 1980111104, 1996888320, -1243532480, -1193200832, -1226755264, 2013665536, 2030442752, -1209978048});
    }

    @Override
    public void registered(Class clazz, Object object) {
        if (object instanceof InternetConnectionUserBlockedService) {
            this.handler.setInternetConnectionUserBlockedService((InternetConnectionUserBlockedService)object);
        }
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

