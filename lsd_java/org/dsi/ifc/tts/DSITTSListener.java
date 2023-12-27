/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface DSITTSListener
extends DSIListener {
    default public void updateLanguage(String string, int n, int n2, int n3) {
    }

    default public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
    }

    default public void updateMarkerPassed(int n, int n2) {
    }

    default public void responseSetLanguage(short s, int n) {
    }

    default public void responseInit(short s, int n) {
    }

    default public void responseAudioTrigger(short s, int n) {
    }

    default public void updateAudioRequest(int n, int n2) {
    }

    default public void responsePlayTone(short s, int n) {
    }

    default public void responseSpeakPrompt(short s, int n) {
    }

    default public void responseSkipSpeaking(short s, int n) {
    }
}

