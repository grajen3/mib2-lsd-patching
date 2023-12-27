/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechLACHandler$LACCallback;
import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechTTSLACHandler$1;
import de.vw.mib.asl.internal.speechengine.config.lsc.VoiceServiceInternal;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class SpeechTTSLACHandler
extends SpeechLACHandler {
    private final TTSConfig ttsConfig;
    boolean isVoiceChangeActive = false;
    private boolean initialLanguageChangeReceived = false;

    public SpeechTTSLACHandler(VoiceServiceInternal voiceServiceInternal, SpeechConfiguratorParameters speechConfiguratorParameters, int n, int n2, String string, TTSConfig tTSConfig) {
        super(voiceServiceInternal, speechConfiguratorParameters, n, n2, string);
        this.ttsConfig = tTSConfig;
    }

    void doVoiceChange(int n) {
        this.isVoiceChangeActive = true;
        int n2 = -1;
        int n3 = this.convertVoiceType(n);
        int n4 = this.paras.getMIBConfigurationManager().getCurrentSkinId();
        this.ttsConfig.setLanguage(this.currentLanguage, n4, n3, -1, new SpeechTTSLACHandler$1(this));
    }

    boolean isVoiceChangeActive() {
        return this.isVoiceChangeActive;
    }

    @Override
    protected Object getDialogSystemConfig() {
        return this.ttsConfig;
    }

    IntSet getAvailableVoices(String string) {
        LanguageVoiceInfo[] languageVoiceInfoArray = this.ttsConfig.getAvailableLanguages();
        if (languageVoiceInfoArray == null) {
            this.getErrorLogMessage().append("ttsConfig.getAvailableLanguages() returned null").log();
            return new IntOptHashSet();
        }
        if (this.logger.isTraceEnabled()) {
            this.getTraceLogMessage().append("getCurrentAvailableVoices for language").append(string).log();
        }
        for (int i2 = 0; i2 < languageVoiceInfoArray.length; ++i2) {
            LanguageVoiceInfo languageVoiceInfo = languageVoiceInfoArray[i2];
            if (!languageVoiceInfo.getLanguage().equals(string)) continue;
            int[] nArray = languageVoiceInfo.getVoiceIDs();
            IntOptHashSet intOptHashSet = new IntOptHashSet();
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                int n = this.convertVoiceId(nArray[i3]);
                intOptHashSet.add(n);
            }
            return intOptHashSet;
        }
        return new IntOptHashSet();
    }

    @Override
    boolean isLanguageAvailable(String string) {
        LanguageVoiceInfo[] languageVoiceInfoArray = this.ttsConfig.getAvailableLanguages();
        for (int i2 = 0; i2 < languageVoiceInfoArray.length; ++i2) {
            LanguageVoiceInfo languageVoiceInfo = languageVoiceInfoArray[i2];
            if (!languageVoiceInfo.getLanguage().equals(string)) continue;
            return true;
        }
        return false;
    }

    @Override
    protected void switchLanguage(String string, int n, int n2, SpeechLACHandler$LACCallback speechLACHandler$LACCallback) {
        if (this.logger.isTraceEnabled()) {
            this.getTraceLogMessage().append("switchLanguage ").append(string).log();
        }
        this.initialLanguageChangeReceived = true;
        this.voiceServiceInternal.updateAvailableVoices(string);
        this.voiceServiceInternal.doSilentMatchFromAvailableToCurrentVoice();
        int n3 = this.voiceServiceInternal.getVoice();
        int n4 = this.convertVoiceType(n3);
        this.ttsConfig.setLanguage(string, n, n4, n2, speechLACHandler$LACCallback);
    }

    @Override
    protected void switchOff(int n, int n2, SpeechLACHandler$LACCallback speechLACHandler$LACCallback) {
        int n3 = this.voiceServiceInternal.getVoice();
        int n4 = this.convertVoiceType(n3);
        this.ttsConfig.setLanguage("", n, n4, n2, speechLACHandler$LACCallback);
    }

    boolean initialLanguageChangeReceived() {
        return this.initialLanguageChangeReceived;
    }
}

