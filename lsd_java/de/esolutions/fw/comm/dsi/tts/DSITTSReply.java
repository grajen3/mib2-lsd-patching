/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts;

import org.dsi.ifc.tts.LanguageVoiceInfo;

public interface DSITTSReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

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

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

