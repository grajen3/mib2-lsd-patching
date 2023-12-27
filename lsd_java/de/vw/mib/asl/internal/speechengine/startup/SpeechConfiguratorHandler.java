/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorActivator;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorCallback;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechASLLogger;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.threads.AsyncServiceFactory;

public class SpeechConfiguratorHandler
extends SpeechComponentStarter
implements SpeechConfiguratorParameters {
    private final SpeechConfiguratorCallback speechEngineStarter;
    private DialogSystemConfigRegistry dialogSystemConfig = null;
    private SpeechConfiguratorActivator speechConfigurationActivator;
    private AbstractClassifiedLogger logger;
    private final Services services;
    private final String taskId;
    private final FrameworkServices frameworkServices;

    SpeechConfiguratorHandler(AbstractClassifiedLogger abstractClassifiedLogger, FrameworkServices frameworkServices, SpeechConfiguratorCallback speechConfiguratorCallback, Services services, String string) {
        super(abstractClassifiedLogger);
        this.frameworkServices = frameworkServices;
        this.services = services;
        this.taskId = string;
        this.logger = new SpeechASLLogger(8, "[SpeechConfiguration] ", frameworkServices.getSpeechLogger());
        this.speechEngineStarter = speechConfiguratorCallback;
        this.speechConfigurationActivator = (SpeechConfiguratorActivator)super.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.config.SpeechConfigurationStarter");
        this.speechConfigurationActivator.prewarm(abstractClassifiedLogger);
    }

    @Override
    public DialogSystemConfigRegistry getDialogSystemConfig() {
        return this.dialogSystemConfig;
    }

    void updateDialogSystemConfig(DialogSystemConfigRegistry dialogSystemConfigRegistry) {
        this.dialogSystemConfig = dialogSystemConfigRegistry;
        this.servicesChanged();
    }

    private void servicesChanged() {
        if (this.dialogSystemConfig != null) {
            this.speechConfigurationActivator.activate(this.speechEngineStarter, this);
        }
    }

    @Override
    public AbstractClassifiedLogger getClassifiedLogger() {
        return this.logger;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.services.getGenericEvents();
    }

    @Override
    public String getGenericEventsTaskId() {
        return this.taskId;
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactory() {
        return this.services.getASLAsyncServiceFactory();
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        return ASLSystemFactory.getSystemApi().getFactoryResetService();
    }

    @Override
    public ConfigurationManager getMIBConfigurationManager() {
        return this.frameworkServices.getConfigurationManager();
    }

    @Override
    public AdaptionApi getAdaptionApi() {
        return ASLDiagnosisFactory.getDiagnosisApi().getAdaptionApi();
    }
}

