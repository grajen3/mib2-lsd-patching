/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.config;

import de.vw.mib.asl.internal.speechengine.Settings;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.config.SetTtsLanguage;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerIgnoringErrors;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class TtsConfigImpl
implements TTSConfig,
TtsLanguageChangeHandler {
    private static final int TRACE_CLASSIFIER;
    private final TtsController tts;
    private final Logger logger;
    private LanguageVoiceInfo[] languageVoiceInfo;
    private TaskInvokerIgnoringErrors invoker;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler;

    public TtsConfigImpl(TtsController ttsController, Logger logger) {
        this.tts = ttsController;
        this.logger = logger;
        this.languageVoiceInfo = new LanguageVoiceInfo[0];
        this.invoker = new TaskInvokerIgnoringErrors(1024, this.logger, "TTSConfigInvoker ");
        this.invoker.invoke();
        this.tts.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler = TtsConfigImpl.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsLanguageChangeHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsLanguageChangeHandler, this);
    }

    @Override
    public void setLanguage(String string, int n, int n2, int n3, DialogSystemConfigCallback dialogSystemConfigCallback) {
        SetTtsLanguage setTtsLanguage = new SetTtsLanguage(this.logger, this.tts, string, n, n2, Settings.getTtsPromptMode(), n3, dialogSystemConfigCallback);
        this.invoker.add(setTtsLanguage);
    }

    @Override
    public LanguageVoiceInfo[] getAvailableLanguages() {
        return this.languageVoiceInfo;
    }

    @Override
    public int getTtsInstanceId() {
        return this.tts.getInstanceId();
    }

    @Override
    public void doReset() {
        this.logger.info(1024, "FactoryReset is not handled yet for TTS. ");
    }

    @Override
    public void responseSetLanguage(short s, int n) {
    }

    @Override
    public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray) {
        if (languageVoiceInfoArray != null && languageVoiceInfoArray.length != 0) {
            this.languageVoiceInfo = languageVoiceInfoArray;
            this.tts.onVoiceInfoReady();
        } else {
            LogMessage logMessage = this.logger.warn(1024);
            logMessage.append("DSITTSListener#updateAvailableLanguages reports 'null'. No languages supported. ");
            logMessage.log();
        }
    }

    @Override
    public void doShutdown() {
        this.tts.onDeviceShutdown();
    }

    @Override
    public void doRestart() {
        this.tts.onDeviceRestart();
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

