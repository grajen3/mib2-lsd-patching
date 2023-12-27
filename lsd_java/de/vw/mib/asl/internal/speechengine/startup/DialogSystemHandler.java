/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemActivator;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;
import de.vw.mib.asl.internal.speechengine.startup.DialogSystemHandler$1;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.speechengine.startup.SpeechEngineStartup;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;

public class DialogSystemHandler
extends SpeechComponentStarter
implements DialogSystemParameter,
DSIServiceStateListener {
    private final ConfigurationManagerDiag configManager;
    private final AdaptionApi adaptionApi;
    private final DialogSystemActivator dialogSystemActivator;
    private final SpeechEngineStartup speechEngineStarter;
    private final Services aslServices;
    private final Logger speechLogger;
    private boolean ttsSpeechAslPowerOn = false;
    private boolean ttsSpeechStarted = false;
    private boolean ttsNaviStarted = false;
    private boolean asrAslPowerOn = false;
    private boolean asrStarted = false;
    private boolean isPromptSystemReady = false;
    private boolean isDialogSystemReady = false;
    private boolean speechCoded = false;
    private String ttsTaskId;
    private String asrTaskId;
    private DialogSystemPublisher dialogSystemPublisher;
    private ApplicationStateRouter applicationStateRouter;
    private AudioConnectionProvider audioConnectionProvider;
    private boolean ttsNaviAslPowerOn;
    private DialogSystemConfigRegistry dialogSystemConfig;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTS;

    DialogSystemHandler(String string, AbstractClassifiedLogger abstractClassifiedLogger, SpeechEngineStartup speechEngineStartup, Services services, Logger logger) {
        super(abstractClassifiedLogger);
        this.speechLogger = logger;
        this.speechEngineStarter = speechEngineStartup;
        this.aslServices = services;
        this.configManager = this.aslServices.getConfigurationManagerDiag();
        this.adaptionApi = ASLDiagnosisFactory.getDiagnosisApi().getAdaptionApi();
        this.dialogSystemActivator = (DialogSystemActivator)this.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.dialogsystem.startup.DialogSystemActivatorImpl");
    }

    public void updateRouterResult(SpeechMessengerServices speechMessengerServices) {
        this.dialogSystemPublisher = speechMessengerServices.getDialogSystemPublisher();
        this.applicationStateRouter = speechMessengerServices.getApplicationStateRouter();
        this.servicesChanged();
    }

    public void updateAudioProvider(AudioConnectionProvider audioConnectionProvider) {
        this.audioConnectionProvider = audioConnectionProvider;
    }

    @Override
    public DialogSystemCallback getSpeechEngineStarter() {
        return this.speechEngineStarter;
    }

    @Override
    public DialogSystemPublisher getDialogSystemPublisher() {
        return this.dialogSystemPublisher;
    }

    @Override
    public ApplicationStateRouter getApplicationStateRouter() {
        return this.applicationStateRouter;
    }

    private void servicesChanged() {
        if (this.dialogSystemPublisher == null || this.audioConnectionProvider == null || this.applicationStateRouter == null || !this.speechCoded) {
            return;
        }
        if (this.ttsSpeechAslPowerOn && !this.ttsSpeechStarted) {
            this.dialogSystemActivator.activateTts(this, this.ttsTaskId, 0);
            this.ttsSpeechStarted = true;
        }
        if (this.ttsNaviAslPowerOn && !this.ttsNaviStarted) {
            this.dialogSystemActivator.activateTts(this, this.ttsTaskId, 1);
            this.ttsNaviStarted = true;
        }
        if (this.asrAslPowerOn && !this.asrStarted) {
            this.dialogSystemActivator.activateAsr(this, this.asrTaskId);
            this.asrStarted = true;
        }
    }

    public void activateTts(String string) {
        if (!this.ttsSpeechAslPowerOn) {
            this.ttsSpeechAslPowerOn = true;
            this.ttsTaskId = string;
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$tts$DSITTS == null ? (class$org$dsi$ifc$tts$DSITTS = DialogSystemHandler.class$("org.dsi.ifc.tts.DSITTS")) : class$org$dsi$ifc$tts$DSITTS, 1, this);
            this.servicesChanged();
        } else {
            if (!this.isTtsReady("restartTts")) {
                return;
            }
            this.getStartupLogger().warn().append("Received restartTts -> Restarting TTS components").log();
            Iterator iterator = this.dialogSystemConfig.getTTSConfigs().iterator();
            while (iterator.hasNext()) {
                TTSConfig tTSConfig = (TTSConfig)iterator.next();
                tTSConfig.doRestart();
            }
        }
    }

    void shutdownTts() {
        if (!this.isTtsReady("shutdownTts")) {
            return;
        }
        this.getStartupLogger().warn().append("Received shutdownTts -> Shutting down TTS components").log();
        Iterator iterator = this.dialogSystemConfig.getTTSConfigs().iterator();
        while (iterator.hasNext()) {
            TTSConfig tTSConfig = (TTSConfig)iterator.next();
            tTSConfig.doShutdown();
        }
    }

    private boolean isTtsReady(String string) {
        if (!this.isPromptSystemReady) {
            this.getStartupLogger().warn().append("Received ").append(string).append(" before PromptSystem was started up. -> Can not be handled.").log();
            return false;
        }
        if (this.dialogSystemConfig == null) {
            this.getStartupLogger().warn().append("Received ").append(string).append(" before dialogSystemConfig was started up. -> Can not be handled.").log();
            return false;
        }
        return true;
    }

    public void activateAsr(String string) {
        if (!this.asrAslPowerOn) {
            this.asrAslPowerOn = true;
            this.asrTaskId = string;
            this.requestSdsCoding();
            this.servicesChanged();
        } else {
            if (!this.isAsrReady("restartAsr")) {
                return;
            }
            this.getStartupLogger().warn().append("Received restartAsr -> Restarting ASR components").log();
            Iterator iterator = this.dialogSystemConfig.getRecognizerConfigs().iterator();
            while (iterator.hasNext()) {
                RecognizerConfig recognizerConfig = (RecognizerConfig)iterator.next();
                recognizerConfig.doRestart();
            }
        }
    }

    void shutdownAsr() {
        if (!this.isAsrReady("shutdownAsr")) {
            return;
        }
        this.getStartupLogger().warn().append("Received shutdownAsr -> Shutting down ASR components").log();
        Iterator iterator = this.dialogSystemConfig.getRecognizerConfigs().iterator();
        while (iterator.hasNext()) {
            RecognizerConfig recognizerConfig = (RecognizerConfig)iterator.next();
            recognizerConfig.doShutdown();
        }
    }

    private boolean isAsrReady(String string) {
        if (!this.isDialogSystemReady) {
            this.getStartupLogger().warn().append("Received ").append(string).append(" before DialogSystem was started up. -> Can not be handled.").log();
            return false;
        }
        if (this.dialogSystemConfig == null) {
            this.getStartupLogger().warn().append("Received ").append(string).append(" before dialogSystemConfig was started up. -> Can not be handled.").log();
            return false;
        }
        return true;
    }

    @Override
    public Logger getLogger() {
        return this.speechLogger;
    }

    @Override
    public Services getAslServices() {
        return this.aslServices;
    }

    @Override
    public AudioConnectionProvider getAudioConnectionProvider() {
        return this.audioConnectionProvider;
    }

    @Override
    public void registered(String string, int n) {
        if (n == 1) {
            this.ttsNaviAslPowerOn = true;
            this.servicesChanged();
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    private void requestSdsCoding() {
        this.adaptionApi.requestCoding(new DialogSystemHandler$1(this));
    }

    protected void onResponseRequestCoding(Access access) {
        boolean bl;
        this.getStartupLogger().info().append("Evaluating response for SpeechRec's coding-data. ").log();
        boolean bl2 = bl = access.contains(104) && access.contains(38);
        if (!bl) {
            this.getStartupLogger().fatal().append("SpeechRec disabled by coding-data. Not starting SpeechRec! ").log();
            return;
        }
        if (bl) {
            boolean bl3;
            boolean bl4 = access.getBoolean(104);
            boolean bl5 = access.getBoolean(38);
            if (bl4 && bl5) {
                bl3 = true;
            } else {
                StringBuffer stringBuffer = new StringBuffer("SpeechCodingData causes deactivation! \nSDSActive = ");
                stringBuffer.append(bl4);
                stringBuffer.append("; microphone1Connected = ");
                stringBuffer.append(bl5);
                this.getStartupLogger().info().append(stringBuffer.toString()).log();
                bl3 = false;
            }
            this.configManager.setFeatureFlagValue("ASL.Configuration.isSdsCoding", bl3);
            if (bl3) {
                this.getStartupLogger().info().append("SpeechRec enabled by coding-data. ").log();
                this.speechCoded = true;
                this.servicesChanged();
            } else {
                this.getStartupLogger().info().append("SpeechRec disabled by coding-data. Not starting SpeechRec! ").log();
            }
        }
    }

    void updatePromptSystemReady() {
        this.isPromptSystemReady = true;
    }

    void updateDialogSystemReady() {
        this.isDialogSystemReady = true;
    }

    void updateDialogSystemConfig(DialogSystemConfigRegistry dialogSystemConfigRegistry) {
        this.dialogSystemConfig = dialogSystemConfigRegistry;
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

