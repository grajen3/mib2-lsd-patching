/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.config.SpeechConfigurator;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.api.speechengine.speakonly.SpeakOnlyService;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataManager;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogBackstackFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerFactory;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;
import de.vw.mib.asl.internal.speechengine.result.start.ResultHandlerServices;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerFactory;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public class SpeechEngineHandler
implements SpeechEngineMaster,
Loggable {
    private final AbstractClassifiedLogger logger;
    private final Services aslServices;
    private boolean sdFeatureCollectionReady = false;
    private SpeechMessengerServices messengerServices;
    private ResultHandlerServices resultHandlerServices;
    private DialogManagerFactory dialogManagerFactory;
    private SlotUpdater slotUpdater;
    private TeleprompterManager teleprompterManager;
    private VoiceDestinationEntry vdeCapabilities;
    private TeleprompterDataManagerFactory teleprompterDataManagerFactory;
    private SpeechConfiguratorFactory speechConfigurationFactory;
    private DialogBackstackFactory dialogBackstackFactory;
    private AudioAccessor audioAccessor;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;

    SpeechEngineHandler(AbstractClassifiedLogger abstractClassifiedLogger, Services services) {
        this.logger = abstractClassifiedLogger;
        this.aslServices = services;
    }

    @Override
    public DialogManager getDialogManager(int n) {
        return this.dialogManagerFactory.getDialogManager(n);
    }

    void updateRouterResult(SpeechMessengerServices speechMessengerServices) {
        this.messengerServices = speechMessengerServices;
        this.servicesChanged();
    }

    void updateResultHandler(ResultHandlerServices resultHandlerServices) {
        this.resultHandlerServices = resultHandlerServices;
        this.servicesChanged();
    }

    void updateDialogManagerFactory(DialogManagerFactory dialogManagerFactory) {
        this.dialogManagerFactory = dialogManagerFactory;
        this.servicesChanged();
    }

    void updateSlotUpdater(SlotUpdater slotUpdater) {
        this.slotUpdater = slotUpdater;
        this.servicesChanged();
    }

    void updateTeleprompterManager(TeleprompterManager teleprompterManager) {
        this.teleprompterManager = teleprompterManager;
        this.servicesChanged();
    }

    void updateVoiceDestinationEntry(VoiceDestinationEntry voiceDestinationEntry) {
        this.vdeCapabilities = voiceDestinationEntry;
        this.servicesChanged();
    }

    void updateAudioAccessor(AudioAccessor audioAccessor) {
        this.audioAccessor = audioAccessor;
        this.servicesChanged();
    }

    void updateTeleprompterDataManagerFactory(TeleprompterDataManagerFactory teleprompterDataManagerFactory) {
        this.teleprompterDataManagerFactory = teleprompterDataManagerFactory;
        this.servicesChanged();
    }

    void updateSpeechConfiguratorFactory(SpeechConfiguratorFactory speechConfiguratorFactory) {
        this.speechConfigurationFactory = speechConfiguratorFactory;
        this.servicesChanged();
    }

    public void updateDialogBackstackFactory(DialogBackstackFactory dialogBackstackFactory) {
        this.dialogBackstackFactory = dialogBackstackFactory;
        this.servicesChanged();
    }

    private void servicesChanged() {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.trace();
            logMessage.append(this);
            logMessage.log();
        }
        if (this.sdFeatureCollectionReady && this.dialogManagerFactory != null && this.messengerServices != null && this.resultHandlerServices != null && this.slotUpdater != null && this.teleprompterManager != null && this.vdeCapabilities != null && this.audioAccessor != null && this.teleprompterDataManagerFactory != null && this.speechConfigurationFactory != null && this.dialogBackstackFactory != null) {
            this.logger.info().append("SpeechEngine(Master) Up And Running").log();
            this.aslServices.getBundleContext().registerService(new String[]{(class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = SpeechEngineHandler.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechEngineHandler.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName()}, (Object)this, null);
        }
    }

    void sdFeatureCollectionReady() {
        this.sdFeatureCollectionReady = true;
        this.servicesChanged();
    }

    @Override
    public DialogStateRouter getDialogStateRouter() {
        return this.messengerServices.getDialogStateRouter();
    }

    @Override
    public IndicatorStateRouter getIndicatorStateRouter() {
        return this.messengerServices.getIndicatorStateRouter();
    }

    @Override
    public BackstackStateRouter getBackstackStateRouter() {
        return this.messengerServices.getBackstackStateRouter();
    }

    @Override
    public ResultHandler getResultHandler(int n) {
        return this.resultHandlerServices.getResultHandler(n);
    }

    @Override
    public SlotUpdater getSlotUpdater(int n) {
        return this.slotUpdater;
    }

    @Override
    public SlotStateRouter getSlotStateRouter() {
        return this.messengerServices.getSlotStateRouter();
    }

    @Override
    public TeleprompterManager getTeleprompterManager() {
        return this.teleprompterManager;
    }

    @Override
    public ApplicationStateRouter getApplicationStateRouter() {
        return this.messengerServices.getApplicationStateRouter();
    }

    @Override
    public VoiceDestinationEntry getVdeService(int n) {
        return this.vdeCapabilities;
    }

    @Override
    public AudioAccessor getAudioAccessor(int n) {
        return this.audioAccessor;
    }

    @Override
    public TeleprompterDataManager getTeleprompterDataManager(int n) {
        return this.teleprompterDataManagerFactory.getTeleprompterDataManager(n);
    }

    @Override
    public SpeechConfigurator getSpeechConfigurator(int n) {
        return this.speechConfigurationFactory.createSpeechConfiguration(n);
    }

    @Override
    public DialogBackstack getDialogBackstack(int n) {
        return this.dialogBackstackFactory.geDialogBackstack(n);
    }

    @Override
    public void toString(LogMessage logMessage) {
        String string = "x";
        String string2 = "-";
        logMessage.append("Service status: ");
        logMessage.append("|SdFeatureCollection:");
        if (this.sdFeatureCollectionReady) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|messengerServices:");
        if (this.messengerServices != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|resultHandlerServices:");
        if (this.resultHandlerServices != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|dialogManagerFactory:");
        if (this.dialogManagerFactory != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|slotUpdater:");
        if (this.slotUpdater != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|teleprompterManager:");
        if (this.teleprompterManager != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|vdeCapabilities:");
        if (this.vdeCapabilities != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|audioAccessor:");
        if (this.audioAccessor != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|teleprompterDataManagerFactory:");
        if (this.teleprompterDataManagerFactory != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
        logMessage.append("|speechConfigurationFactory:");
        if (this.speechConfigurationFactory != null) {
            logMessage.append("x");
        } else {
            logMessage.append("-");
        }
    }

    @Override
    public SpeakOnlyService getSpeakOnlyService(int n) {
        return null;
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

