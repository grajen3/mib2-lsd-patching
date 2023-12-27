/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface TtsLanguageChangeHandler {
    default public void responseSetLanguage(short s, int n) {
    }

    default public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray) {
    }
}

