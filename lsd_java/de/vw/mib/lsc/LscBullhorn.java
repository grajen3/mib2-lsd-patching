/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsc;

public interface LscBullhorn {
    default public void turnOnNavForLanguage(String string) {
    }

    default public void doLanguageChangePhone(String string) {
    }

    default public void doLanguageChangeHandbook(String string) {
    }

    default public void turnOnSpeechInputSystemForLanguage(String string) {
    }

    default public void turnOnSpeechOutputSystemForLanguage(String string) {
    }

    default public void turnOffSpeechInputSystem() {
    }

    default public void turnOffSpeechOutputSystem() {
    }

    default public void turnOffNav() {
    }

    default public void startOfLsc() {
    }

    default public void endOfLsc() {
    }

    default public void allComponentsChangedTheLanguage() {
    }

    default public void notifyInstrumentCluster(String string) {
    }

    default public void propagateNewLanguage(String string) {
    }

    default public void lscFailedUltimately() {
    }
}

