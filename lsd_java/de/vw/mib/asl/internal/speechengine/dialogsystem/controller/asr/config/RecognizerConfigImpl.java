/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.config.SetRecognizerLanguage;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerIgnoringErrors;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class RecognizerConfigImpl
implements RecognizerConfig,
AsrLanguageChangeHandler {
    private final Logger logger;
    private final AsrController asr;
    private final ApplicationStateTracker appStateTracker;
    private String[] availableLanguages;
    private static final String EMPTY_LANGUAGE;
    private static final int TRACE_CLASSIFIER;
    private TaskInvokerIgnoringErrors invoker;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler;

    public RecognizerConfigImpl(AsrController asrController, Logger logger) {
        this.logger = logger;
        this.asr = asrController;
        this.appStateTracker = this.asr.getApplicationStateTracker();
        this.availableLanguages = new String[0];
        this.invoker = new TaskInvokerIgnoringErrors(512, this.logger, "RecognizerConfigInvoker ");
        this.invoker.invoke();
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler = RecognizerConfigImpl.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrLanguageChangeHandler, this);
    }

    @Override
    public void setLanguage(String string, int n, int n2, DialogSystemConfigCallback dialogSystemConfigCallback) {
        SetRecognizerLanguage setRecognizerLanguage = new SetRecognizerLanguage(this.logger, this.asr, string, n, this.asr.getActivityManager(), n2, dialogSystemConfigCallback);
        if ("".equals(string)) {
            this.appStateTracker.onLanguageSupported(false);
            this.invoker.add(setRecognizerLanguage);
        } else {
            setRecognizerLanguage.addListener(this.appStateTracker);
            this.invoker.add(setRecognizerLanguage);
            this.appStateTracker.onLanguageSupported(true);
        }
    }

    @Override
    public String[] getAvailableLanguages() {
        return this.availableLanguages;
    }

    @Override
    public void doReset() {
        this.asr.getSpeechRec().requestRestoreFactorySettings();
    }

    @Override
    public void responseSetLanguage(int n) {
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray) {
        if (stringArray != null && stringArray.length != 0) {
            this.availableLanguages = stringArray;
            this.asr.onAvailableLanguagesReady();
        } else {
            LogMessage logMessage = this.logger.warn(512);
            logMessage.append("DSISpeechRecListener#updateAvailableLanguages reports 'null'. No languages supported. ");
            logMessage.log();
        }
    }

    @Override
    public void doShutdown() {
        this.asr.onDeviceShutdown();
    }

    @Override
    public void doRestart() {
        this.asr.onDeviceRestart();
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

