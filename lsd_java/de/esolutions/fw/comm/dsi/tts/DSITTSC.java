/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts;

import org.dsi.ifc.tts.TTSPrompt;

public interface DSITTSC {
    default public void speakPrompt(short s, TTSPrompt tTSPrompt) {
    }

    default public void setLanguage(short s, String string, int n, int n2, int n3) {
    }

    default public void init(short s) {
    }

    default public void requestAudioTrigger(short s, int n) {
    }

    default public void requestPlayTone(short s, int n) {
    }

    default public void requestSkipSpeaking(short s, int n, int n2) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

