/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderCallback;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorCallback;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogBackstackFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerActivatorCallback;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy;
import de.vw.mib.asl.internal.speechengine.dialogmanager.SpeakOnlyServiceFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemCallback;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerCallback;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerCallback;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerServices;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterCallback;
import de.vw.mib.asl.internal.speechengine.startup.AudioProviderHandler;
import de.vw.mib.asl.internal.speechengine.startup.DialogManagerHandler;
import de.vw.mib.asl.internal.speechengine.startup.DialogSystemHandler;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.PromptEngineHandler;
import de.vw.mib.asl.internal.speechengine.startup.ResultStartupHandler;
import de.vw.mib.asl.internal.speechengine.startup.SlotUpdaterHandler;
import de.vw.mib.asl.internal.speechengine.startup.SpeechASLLogger;
import de.vw.mib.asl.internal.speechengine.startup.SpeechConfiguratorHandler;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineDiagnosisHandler;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineHandler;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineRemoteFacadeHandler;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStarter;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup$1;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup$2;
import de.vw.mib.asl.internal.speechengine.startup.SpeechMessengerHandler;
import de.vw.mib.asl.internal.speechengine.startup.SpeechServiceManager;
import de.vw.mib.asl.internal.speechengine.startup.TeleprompterManagerHandler;
import de.vw.mib.asl.internal.speechengine.startup.clients.LegacyDomainAvailableHandler;
import de.vw.mib.asl.internal.speechengine.startup.clients.SpeakOnlyHKMuteHandler;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerFactory;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterManagerCallback;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class SpeechEngineStartup
implements SpeechEngineStarter,
ServiceTrackerCustomizer,
DialogManagerActivatorCallback,
DialogSystemCallback,
SpeechMessengerCallback,
AudioProviderCallback,
ResultHandlerCallback,
SpeechConfiguratorCallback,
SlotUpdaterCallback,
TeleprompterManagerCallback {
    private final AbstractClassifiedLogger startupLogger;
    private final Services aslServices;
    private final BundleContext bundleContext;
    private final FrameworkServices frameworkServices;
    private final TeleprompterManagerHandler teleprompterHandler;
    private final DialogManagerHandler dialogManagerHandler;
    private final SpeechEngineHandler speechEngineHandler;
    private final DialogSystemHandler dialogSystemHandler;
    private final PromptEngineHandler promptEngineHandler;
    private final SpeechConfiguratorHandler speechConfigurationHandler;
    private final SpeechEngineDiagnosisHandler speechEngineDiagnosisHandler;
    private static SpeechEngineStartup singleInstance = null;
    private final String taskId;
    private SlotUpdaterHandler slotUpdaterHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$features$FeatureFactory;
    static /* synthetic */ Class class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy;

    public static SpeechEngineStartup getInstance(String string) {
        if (singleInstance == null) {
            singleInstance = new SpeechEngineStartup(string);
        }
        return singleInstance;
    }

    private SpeechEngineStartup(String string) {
        this.taskId = string;
        this.aslServices = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.bundleContext = this.aslServices.getBundleContext();
        this.frameworkServices = new SpeechServiceManager(this.bundleContext, this.aslServices);
        this.startupLogger = new SpeechASLLogger(8, "[SpeechEngineStartup] ", this.frameworkServices.getSpeechLogger());
        this.startupLogger.info().append("Received POWER_ON of SpeechEngineStartup").log();
        this.teleprompterHandler = new TeleprompterManagerHandler(this.startupLogger, this, this.frameworkServices, this.aslServices);
        this.dialogManagerHandler = new DialogManagerHandler(this.startupLogger, this, this.frameworkServices);
        this.speechEngineHandler = new SpeechEngineHandler(this.startupLogger, this.aslServices);
        this.dialogSystemHandler = new DialogSystemHandler(this.taskId, this.startupLogger, this, this.aslServices, this.frameworkServices.getSpeechLogger());
        this.promptEngineHandler = new PromptEngineHandler(this.startupLogger, this.aslServices);
        this.slotUpdaterHandler = new SlotUpdaterHandler(this.startupLogger, this, this.frameworkServices, this.aslServices);
        this.speechConfigurationHandler = new SpeechConfiguratorHandler(this.startupLogger, this.frameworkServices, this, this.aslServices, this.taskId);
        this.speechEngineDiagnosisHandler = new SpeechEngineDiagnosisHandler(this.startupLogger, this.frameworkServices);
        this.openOsgiServiceTrackers();
        this.createCoreComponents();
    }

    private void openOsgiServiceTrackers() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$features$FeatureFactory == null ? (class$de$vw$mib$asl$api$speechengine$features$FeatureFactory = SpeechEngineStartup.class$("de.vw.mib.asl.api.speechengine.features.FeatureFactory")) : class$de$vw$mib$asl$api$speechengine$features$FeatureFactory).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
        ServiceTracker serviceTracker2 = new ServiceTracker(this.bundleContext, (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager == null ? (class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager = SpeechEngineStartup.class$("de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager")) : class$de$vw$mib$sdfeaturecollectionmanager$SdFeatureCollectionManager).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker2.open();
    }

    private void createCoreComponents() {
        new SpeechMessengerHandler(this.startupLogger, this, this.frameworkServices, this.aslServices);
        new ResultStartupHandler(this.startupLogger, this, this.frameworkServices);
        new AudioProviderHandler(this.startupLogger, this, this.aslServices, this.frameworkServices.getSpeechLogger(), this.taskId, this.frameworkServices.getTimerManager());
        new SpeechEngineRemoteFacadeHandler(this.startupLogger, this.frameworkServices);
        new LegacyDomainAvailableHandler(this.bundleContext, this.aslServices.getASLPropertyManager());
        new SpeakOnlyHKMuteHandler(this.bundleContext, this.startupLogger);
    }

    public FrameworkServices getFrameworkServices() {
        return this.frameworkServices;
    }

    @Override
    public void onSpeakOnlyServiceFactoryReady(SpeakOnlyServiceFactory speakOnlyServiceFactory) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("SpeakOnlyServiceFactory ready");
            logMessage.log();
        }
        this.promptEngineHandler.speakOnlyServiceFactoryReady(speakOnlyServiceFactory);
    }

    @Override
    public void onDialogManagerProxyReady(DialogManagerProxy dialogManagerProxy) {
        Object object;
        if (this.startupLogger.isTraceEnabled()) {
            object = this.startupLogger.trace();
            object.append("DialogManagerProxy ready");
            object.log();
        }
        object = this.frameworkServices.getAsyncServiceFactory();
        DialogManagerProxy dialogManagerProxy2 = (DialogManagerProxy)object.create(dialogManagerProxy, new Class[]{class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy == null ? (class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy = SpeechEngineStartup.class$("de.vw.mib.asl.api.speechengine.speechproxy.SpeechProxy")) : class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy});
        this.aslServices.getBundleContext().registerService((class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy == null ? (class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy = SpeechEngineStartup.class$("de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy")) : class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy).getName(), (Object)dialogManagerProxy2, null);
        this.promptEngineHandler.dialogManagerProxyReady();
        this.dialogManagerHandler.dialogManagerProxyReady();
    }

    @Override
    public void onDialogManagerReady(DialogManagerFactory dialogManagerFactory) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("DialogManager ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateDialogManagerFactory(dialogManagerFactory);
    }

    @Override
    public void onDialogManagerDiagnosisReady(DialogManagerDiagnosis dialogManagerDiagnosis) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("DialogManagerDiagnosis ready");
            logMessage.log();
        }
        this.speechEngineDiagnosisHandler.updateDialogManagerDiagnosis(dialogManagerDiagnosis);
    }

    @Override
    public void onDialogDystemDiagnosisReady(DialogSystemDiagnosis dialogSystemDiagnosis) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("DialogSystemDiagnosis ready");
            logMessage.log();
        }
        this.speechEngineDiagnosisHandler.updateDialogSystemDiagnosis(dialogSystemDiagnosis);
    }

    @Override
    public void onPromptSystemReady(PromptSystem promptSystem) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("PromptSystem ready");
            logMessage.log();
        }
        this.dialogManagerHandler.updatePromptSystem(promptSystem);
        this.dialogSystemHandler.updatePromptSystemReady();
    }

    @Override
    public void onSpeechDialogSystemReady(SpeechDialogSystem speechDialogSystem) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("SpeechDialogSystem ready");
            logMessage.log();
        }
        this.dialogManagerHandler.updateSpeechDialogSystem(speechDialogSystem);
        this.slotUpdaterHandler.updateCommandLoader(speechDialogSystem.getCommandLoader());
        this.dialogSystemHandler.updateDialogSystemReady();
    }

    @Override
    public void onDialogSystemConfigReady(DialogSystemConfigRegistry dialogSystemConfigRegistry) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("DialogSystemConfig ready");
            logMessage.log();
        }
        this.speechConfigurationHandler.updateDialogSystemConfig(dialogSystemConfigRegistry);
        this.dialogSystemHandler.updateDialogSystemConfig(dialogSystemConfigRegistry);
    }

    @Override
    public void onRouterReady(SpeechMessengerServices speechMessengerServices) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("Routers ready");
            logMessage.log();
        }
        this.dialogSystemHandler.updateRouterResult(speechMessengerServices);
        this.dialogManagerHandler.updateRouterResult(speechMessengerServices);
        this.speechEngineHandler.updateRouterResult(speechMessengerServices);
        this.speechEngineDiagnosisHandler.updateSpeechMessengerServices(speechMessengerServices);
    }

    @Override
    public void onSdFeatureCollectionManagerReady() {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("SdFeatureCollectionManager ready");
            logMessage.log();
        }
        this.speechEngineHandler.sdFeatureCollectionReady();
        this.promptEngineHandler.sdFeatureCollectionReady();
    }

    @Override
    public void onFeatureFactoryReady(FeatureFactory featureFactory) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("FeatureFactory ready");
            logMessage.log();
        }
        this.dialogManagerHandler.updateFeatureFactory(featureFactory);
    }

    @Override
    public void onTeleprompterManagerReady(TeleprompterManager teleprompterManager) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("TeleprompterManager ready");
            logMessage.log();
        }
        this.dialogManagerHandler.updateTeleprompterManager(teleprompterManager);
        this.speechEngineHandler.updateTeleprompterManager(teleprompterManager);
    }

    @Override
    public void onTeleprompterDataManagerFactoryReady(TeleprompterDataManagerFactory teleprompterDataManagerFactory) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("TeleprompterDataManagerFactory ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateTeleprompterDataManagerFactory(teleprompterDataManagerFactory);
    }

    @Override
    public void onDialogBackstackFactoryReady(DialogBackstackFactory dialogBackstackFactory) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("DialogBackstackFactory ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateDialogBackstackFactory(dialogBackstackFactory);
    }

    @Override
    public void onVoiceDestinationEntryReady(VoiceDestinationEntry voiceDestinationEntry) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("VoiceDestinationEntry ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateVoiceDestinationEntry(voiceDestinationEntry);
    }

    @Override
    public void onAudioAccessorReady(AudioAccessor audioAccessor) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("AudioClamper ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateAudioAccessor(audioAccessor);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof FeatureFactory) {
            FeatureFactory featureFactory = (FeatureFactory)object;
            this.aslServices.getASLThreadSwitch().enqueue(new SpeechEngineStartup$1(this, featureFactory));
        } else if (object instanceof SdFeatureCollectionManager) {
            this.aslServices.getASLThreadSwitch().enqueue(new SpeechEngineStartup$2(this));
        } else {
            this.startupLogger.warn().append("Unhandled ServiceReference was added.").log();
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    public void powerOnTTS(String string) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("Received POWER_ON of TTS");
            logMessage.log();
        }
        this.dialogSystemHandler.activateTts(string);
    }

    public void powerOffTTS() {
        LogMessage logMessage = this.startupLogger.info();
        logMessage.append("Received POWER_OFF of TTS. Domain restart active.");
        logMessage.log();
        this.dialogSystemHandler.shutdownTts();
    }

    public void powerOnASR(String string) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("Received POWER_ON of ASR");
            logMessage.log();
        }
        this.dialogSystemHandler.activateAsr(string);
    }

    public void powerOffASR() {
        LogMessage logMessage = this.startupLogger.info();
        logMessage.append("Received POWER_OFF of ASR. Domain restart active.");
        logMessage.log();
        this.dialogSystemHandler.shutdownAsr();
    }

    @Override
    public void onSlotUpdaterReady(SlotUpdater slotUpdater) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("SlotUpdater ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateSlotUpdater(slotUpdater);
    }

    @Override
    public void onResultHandlerReady(ResultHandlerServices resultHandlerServices) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("ResultHandlerServices ready");
            logMessage.log();
        }
        this.dialogManagerHandler.updateResultPublisher(resultHandlerServices.getRecognizedResultPublisher());
        this.speechEngineHandler.updateResultHandler(resultHandlerServices);
    }

    @Override
    public void onAudioProviderReady(AudioConnectionProvider audioConnectionProvider) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("AudioProvider ready");
            logMessage.log();
        }
        this.dialogSystemHandler.updateAudioProvider(audioConnectionProvider);
    }

    @Override
    public void onSpeechConfigurationReady(SpeechConfiguratorFactory speechConfiguratorFactory) {
        if (this.startupLogger.isTraceEnabled()) {
            LogMessage logMessage = this.startupLogger.trace();
            logMessage.append("SpeechConfigurationFactory ready");
            logMessage.log();
        }
        this.speechEngineHandler.updateSpeechConfiguratorFactory(speechConfiguratorFactory);
        this.dialogManagerHandler.updateSpeechConfiguratorFactory(speechConfiguratorFactory);
        this.teleprompterHandler.update(speechConfiguratorFactory);
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

