/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config;

import de.vw.mib.asl.api.speechengine.config.SpeechConfigurator;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.config.voice.VoiceService;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettingsService;
import de.vw.mib.asl.internal.speechengine.config.engine.SpeechEngineSettingsManager;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLSCManager;
import de.vw.mib.asl.internal.speechengine.config.reset.SpeechResetHandler;
import de.vw.mib.asl.internal.speechengine.config.settings.SpeechSettingsManager;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorActivator;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorCallback;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.asl.speech.persistence.SpeechPersistenceService;
import de.vw.mib.asl.speech.persistence.SpeechPersistenceServiceImpl;
import de.vw.mib.log4mib.LogMessage;

public class SpeechConfigurationStarter
implements SpeechConfiguratorActivator,
SpeechConfiguratorFactory,
SpeechConfigurator {
    private SpeechSettingsManager speechSettingsManager;
    private SpeechLSCManager speechLSCTarget;
    private SpeechEngineSettingsService speechEngineSettings;
    private SpeechPersistenceServiceImpl speechPersistenceService;

    @Override
    public void prewarm(AbstractClassifiedLogger abstractClassifiedLogger) {
        if (abstractClassifiedLogger.isTraceEnabled()) {
            LogMessage logMessage = abstractClassifiedLogger.trace();
            logMessage.append("SpeechConfigurationStarter#prewarm() called. Persistence loaded. ");
            logMessage.log();
        }
        this.speechPersistenceService = SpeechPersistenceServiceImpl.getInstance();
        this.speechPersistenceService.loadSpeechSettingsPersistable();
    }

    @Override
    public void activate(SpeechConfiguratorCallback speechConfiguratorCallback, SpeechConfiguratorParameters speechConfiguratorParameters) {
        this.activateInternal(speechConfiguratorCallback, speechConfiguratorParameters, this.speechPersistenceService);
    }

    public void activateInternal(SpeechConfiguratorCallback speechConfiguratorCallback, SpeechConfiguratorParameters speechConfiguratorParameters, SpeechPersistenceService speechPersistenceService) {
        this.speechEngineSettings = new SpeechEngineSettingsManager();
        this.speechLSCTarget = new SpeechLSCManager(speechConfiguratorParameters, speechPersistenceService);
        this.speechSettingsManager = new SpeechSettingsManager(speechConfiguratorParameters, speechPersistenceService);
        new SpeechResetHandler(speechConfiguratorParameters.getClassifiedLogger(), this.speechSettingsManager, this.speechLSCTarget, speechConfiguratorParameters.getFactoryResetService(), speechConfiguratorParameters.getDialogSystemConfig());
        speechConfiguratorCallback.onSpeechConfigurationReady(this);
    }

    @Override
    public VoiceService getVoiceService() {
        return this.speechLSCTarget;
    }

    @Override
    public SpeechSettingsService getSpeechSettingsManager() {
        return this.speechSettingsManager;
    }

    @Override
    public SpeechConfigurator createSpeechConfiguration(int n) {
        return this;
    }

    @Override
    public SpeechEngineSettingsService getSpeechEngineSettingsService(int n) {
        return this.speechEngineSettings;
    }
}

