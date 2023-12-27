/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerActivator;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerActivatorCallback;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;
import de.vw.mib.asl.internal.speechengine.result.RecognizedResultPublisher;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.internal.generated.SpeechConfiguration;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public class DialogManagerHandler
extends SpeechComponentStarter
implements DialogManagerParameters {
    private final DialogManagerActivatorCallback speechEngineStartup;
    private final DialogManagerActivator dialogManagerActivator;
    private final FrameworkServices frameworkServices;
    private FeatureFactory featureFactory;
    private RecognizedResultPublisher recognizedResultPublisher;
    private HmiEventPublisher hmiEventPublisher;
    private BackstackStatePublisher backstackStatePublisher;
    private PromptSystem promptSystem;
    private SpeechDialogSystem speechDialogSystem;
    private boolean proxyReady;
    private TeleprompterManager teleprompterManager;
    private SpeechConfiguratorFactory speechConfiguratorFactory;

    DialogManagerHandler(AbstractClassifiedLogger abstractClassifiedLogger, DialogManagerActivatorCallback dialogManagerActivatorCallback, FrameworkServices frameworkServices) {
        super(abstractClassifiedLogger);
        this.speechEngineStartup = dialogManagerActivatorCallback;
        this.frameworkServices = frameworkServices;
        this.dialogManagerActivator = this.getDialogManagerActivator();
        this.servicesChangedForProxy();
    }

    public FrameworkServices getFrameworkServices() {
        return this.frameworkServices;
    }

    @Override
    public DialogManagerActivatorCallback getSpeechEngineStarter() {
        return this.speechEngineStartup;
    }

    @Override
    public PromptSystem getPromptSystem() {
        return this.promptSystem;
    }

    void updatePromptSystem(PromptSystem promptSystem) {
        this.promptSystem = promptSystem;
        this.servicesChangedForProxy();
    }

    void updateSpeechConfiguratorFactory(SpeechConfiguratorFactory speechConfiguratorFactory) {
        this.speechConfiguratorFactory = speechConfiguratorFactory;
        this.servicesChangedForProxy();
    }

    void dialogManagerProxyReady() {
        this.proxyReady = true;
        this.servicesChangedForDM();
    }

    public void updateTeleprompterManager(TeleprompterManager teleprompterManager) {
        this.teleprompterManager = teleprompterManager;
        this.servicesChangedForProxy();
    }

    public void updateSpeechDialogSystem(SpeechDialogSystem speechDialogSystem) {
        this.speechDialogSystem = speechDialogSystem;
        this.servicesChangedForDM();
    }

    @Override
    public HmiEventPublisher getHmiEventPublisher() {
        return this.hmiEventPublisher;
    }

    @Override
    public BackstackStatePublisher getBackstackStatePublisher() {
        return this.backstackStatePublisher;
    }

    public void updateRouterResult(SpeechMessengerServices speechMessengerServices) {
        this.hmiEventPublisher = speechMessengerServices.getHmiEventPublisher();
        this.backstackStatePublisher = speechMessengerServices.getBackstackStatePublisher();
        this.servicesChangedForProxy();
    }

    public void updateResultPublisher(RecognizedResultPublisher recognizedResultPublisher) {
        this.recognizedResultPublisher = recognizedResultPublisher;
        this.servicesChangedForProxy();
    }

    @Override
    public RecognizedResultPublisher getRecognizedResultPublisher() {
        return this.recognizedResultPublisher;
    }

    @Override
    public FeatureFactory getFeatureFactory() {
        return this.featureFactory;
    }

    void updateFeatureFactory(FeatureFactory featureFactory) {
        this.featureFactory = featureFactory;
        this.servicesChangedForProxy();
    }

    private void servicesChangedForProxy() {
        if (this.areAllDependeciesAvailable()) {
            this.dialogManagerActivator.activateProxy(this);
        }
    }

    private boolean areAllDependeciesAvailable() {
        return this.getHmiEventPublisher() != null && this.getRecognizedResultPublisher() != null && this.getFeatureFactory() != null && this.getPromptSystem() != null && this.teleprompterManager != null && this.speechConfiguratorFactory != null;
    }

    private DialogManagerActivator getDialogManagerActivator() {
        return (DialogManagerActivator)this.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerStartup");
    }

    private void servicesChangedForDM() {
        if (this.speechDialogSystem != null && this.proxyReady) {
            this.dialogManagerActivator.activateManager(this.speechDialogSystem);
        }
    }

    @Override
    public TeleprompterManager getTeleprompterManager() {
        return this.teleprompterManager;
    }

    @Override
    public SpeechConfiguration getSpeechConfiguration() {
        return this.frameworkServices.getSpeechConfiguration();
    }

    @Override
    public Logger getSpeechLogger() {
        return this.frameworkServices.getSpeechLogger();
    }

    @Override
    public TimerManager getTimerManager() {
        return this.frameworkServices.getTimerManager();
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        return this.frameworkServices.getThreadSwitchingTarget();
    }

    @Override
    public SpeechConfiguratorFactory getSpeechConfiguratorFactory() {
        return this.speechConfiguratorFactory;
    }
}

