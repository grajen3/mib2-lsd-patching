/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.startup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.ocu.OCUServiceProvider;
import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.events.commands.RecognitionConsumer;
import de.vw.mib.asl.internal.speechgeneral.events.commands.RequestVisibilityAction;
import de.vw.mib.asl.internal.speechgeneral.events.framework.EventDispatcher;
import de.vw.mib.asl.internal.speechgeneral.list.ListHandler;
import de.vw.mib.asl.internal.speechgeneral.mainmenu.SpeechContextDispatcher;
import de.vw.mib.asl.internal.speechgeneral.mainmenu.SpeechContextGeneral;
import de.vw.mib.asl.internal.speechgeneral.ocu.SpeechVoiceServiceListener;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogActivatorManager;
import de.vw.mib.asl.internal.speechgeneral.teleprompter.GuiLanguageListener;
import de.vw.mib.asl.internal.speechgeneral.teleprompter.TeleprompterStateHandler;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechGeneralActivator {
    private final SpeechGeneralLogger logger;
    private SystemEventDispatcher systemEventDispatcher;
    private RecognitionConsumer cmdSpeechControl;
    private SpeechContextDispatcher speechContextDispatcher;
    private ConfigurationManager configManager;
    private ResultControllerRouter resultControllerRouter;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext;

    SpeechGeneralActivator(SpeechGeneralLogger speechGeneralLogger) {
        this.logger = speechGeneralLogger;
    }

    public void activate(BundleContext bundleContext, SpeechEngineMaster speechEngineMaster, ConfigurationManager configurationManager, SystemEventDispatcher systemEventDispatcher, ASLSystemAPI aSLSystemAPI, EventDispatcher eventDispatcher, ASLPropertyManager aSLPropertyManager, GenericEvents genericEvents, AsyncServiceFactory asyncServiceFactory, CioDictionary cioDictionary, CioDispatcher cioDispatcher, Services services) {
        this.systemEventDispatcher = systemEventDispatcher;
        this.configManager = configurationManager;
        DialogManager dialogManager = speechEngineMaster.getDialogManager(1);
        ApplicationStateRouter applicationStateRouter = speechEngineMaster.getApplicationStateRouter();
        ResultHandler resultHandler = speechEngineMaster.getResultHandler(1);
        this.resultControllerRouter = resultHandler.getResultControllerRegistry();
        this.cmdSpeechControl = new RecognitionConsumer(this.systemEventDispatcher, 368783360);
        SpeechContextGeneral speechContextGeneral = new SpeechContextGeneral(this.cmdSpeechControl);
        bundleContext.registerService((class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext == null ? (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext = SpeechGeneralActivator.class$("de.vw.mib.asl.api.speechengine.contexts.SpeechContext")) : class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext).getName(), (Object)speechContextGeneral, null);
        this.speechContextDispatcher = new SpeechContextDispatcher(bundleContext, eventDispatcher);
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext == null ? (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext = SpeechGeneralActivator.class$("de.vw.mib.asl.api.speechengine.contexts.SpeechContext")) : class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext).getName(), (ServiceTrackerCustomizer)this.speechContextDispatcher);
        serviceTracker.open();
        new TeleprompterStateHandler(speechEngineMaster.getTeleprompterManager(), aSLPropertyManager, eventDispatcher);
        new GuiLanguageListener(this.configManager, aSLPropertyManager, asyncServiceFactory).start();
        new ListHandler(dialogManager, eventDispatcher);
        new RequestVisibilityAction(cioDictionary, cioDispatcher, eventDispatcher);
        this.registerRecognizedEventConsumer();
        try {
            DialogActivatorManager dialogActivatorManager = new DialogActivatorManager(dialogManager, this.configManager, applicationStateRouter, this.systemEventDispatcher, speechEngineMaster.getDialogStateRouter(), aSLSystemAPI, genericEvents, asyncServiceFactory, services);
            dialogActivatorManager.start();
        }
        catch (Exception exception) {
            LogMessage logMessage = this.logger.error();
            logMessage.append("Speech PTT Handling could not be initialized! ");
            logMessage.attachThrowable(exception);
            logMessage.log();
        }
        new SpeechVoiceServiceListener(aSLPropertyManager, OCUServiceProvider.getServiceProvider().getVoiceServiceProvider(OCUServiceProvider.VOICE_SERVICE_VERSION_1_0)).startTracking();
    }

    private void registerRecognizedEventConsumer() {
        this.resultControllerRouter.register(this.cmdSpeechControl, 30683200);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 352006144), 13905984);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 435892224), 47460416);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 435892224), 64237632);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 435892224), 81014848);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 452669440), 97792064);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 452669440), 114569280);
        if (this.configManager.isFeatureFlagSet(484)) {
            this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 469446656), 131346496);
        } else {
            this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 620441600), 131346496);
        }
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 486223872), 148123712);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 503001088), 164900928);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 519778304), 181678144);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 536555520), 198455360);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 553332736), 215232576);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 570109952), 232009792);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 586887168), 248787008);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 603664384), 265564224);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 620441600), 282341440);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 637218816), 299118656);
        this.resultControllerRouter.register(new RecognitionConsumer(this.systemEventDispatcher, 788213760), 433336384);
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

