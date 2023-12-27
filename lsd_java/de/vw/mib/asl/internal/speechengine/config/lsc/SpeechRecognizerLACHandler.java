/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler$LACCallback;
import de.vw.mib.asl.internal.speechengine.config.lsc.VoiceServiceInternal;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;

public class SpeechRecognizerLACHandler
extends SpeechLACHandler {
    private final RecognizerConfig recognizerConfig;

    public SpeechRecognizerLACHandler(VoiceServiceInternal voiceServiceInternal, SpeechConfiguratorParameters speechConfiguratorParameters, int n, int n2, String string, RecognizerConfig recognizerConfig) {
        super(voiceServiceInternal, speechConfiguratorParameters, n, n2, string);
        this.recognizerConfig = recognizerConfig;
    }

    @Override
    protected Object getDialogSystemConfig() {
        return this.recognizerConfig;
    }

    @Override
    boolean isLanguageAvailable(String string) {
        String[] stringArray = this.recognizerConfig.getAvailableLanguages();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2 = stringArray[i2];
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    @Override
    protected void switchLanguage(String string, int n, int n2, SpeechLACHandler$LACCallback speechLACHandler$LACCallback) {
        this.recognizerConfig.setLanguage(string, n, n2, speechLACHandler$LACCallback);
    }

    @Override
    protected void switchOff(int n, int n2, SpeechLACHandler$LACCallback speechLACHandler$LACCallback) {
        this.recognizerConfig.setLanguage("", n, n2, speechLACHandler$LACCallback);
    }
}

