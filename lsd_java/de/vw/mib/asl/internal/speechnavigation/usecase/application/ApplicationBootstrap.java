/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.application;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.ModelEventConsumerErrorHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.RecognizedEventConsumerErrorHandler;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationController;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationHelpController;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandlerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.genericevents.AbstractTarget;

public class ApplicationBootstrap
extends BootstraperBase {
    private final TeleprompterManager teleprompterManager;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final DialogManager dialogManager;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext;

    public ApplicationBootstrap(AbstractTarget abstractTarget, ResultHandler resultHandler, CioDictionary cioDictionary, CioDispatcher cioDispatcher, TeleprompterManager teleprompterManager, DialogManager dialogManager) {
        super(abstractTarget, resultHandler);
        this.teleprompterManager = teleprompterManager;
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
        this.dialogManager = dialogManager;
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        try {
            ApplicationErrorHandlerBase applicationErrorHandlerBase = new ApplicationController(this.cioDictionary, this.cioDispatcher, this.teleprompterManager, this.dialogManager);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().registerService(new String[]{(class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext == null ? (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext = ApplicationBootstrap.class$("de.vw.mib.asl.api.speechengine.contexts.SpeechContext")) : class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext).getName()}, (Object)applicationErrorHandlerBase, null);
            resultControllerRouter.register((RecognizedEventConsumer)((Object)applicationErrorHandlerBase), 1138832192);
            resultControllerRouter.register((ModelEventConsumer)((Object)applicationErrorHandlerBase), 1910584128, 0);
            resultControllerRouter.register((ModelEventConsumer)((Object)applicationErrorHandlerBase), -1612631232, 0);
            resultControllerRouter.register((ModelEventConsumer)((Object)applicationErrorHandlerBase), -1948175552, 0);
            resultControllerRouter.register((ModelEventConsumer)((Object)applicationErrorHandlerBase), -186567872, 0);
            resultControllerRouter.register((ModelEventConsumer)((Object)applicationErrorHandlerBase), -2018496, 0);
            applicationErrorHandlerBase = new ApplicationHelpController();
            resultControllerRouter.register((RecognizedEventConsumer)((Object)applicationErrorHandlerBase), 1893806912);
            resultControllerRouter.register(new ModelEventConsumerErrorHandler(), -1);
            resultControllerRouter.register(new RecognizedEventConsumerErrorHandler(), -1);
            this.registerObservers();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".initialize(), error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private void registerObservers() {
        this.target.addObservers(new int[]{1088500544, 1105277760, 1910584128, -1612631232, -186567872, -2018496, -1948175552});
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

