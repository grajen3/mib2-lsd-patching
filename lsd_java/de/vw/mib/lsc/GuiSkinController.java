/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsc;

public interface GuiSkinController {
    default public void respondOnLanguageChangeNav(String string, boolean bl) {
    }

    default public void respondOnLanguageChangeSpeechOutput(String string, boolean bl) {
    }

    default public void respondOnLanguageChangeSpeechInput(String string, boolean bl) {
    }

    default public void setVeryFirstLsc() {
    }

    default public void setInitialLsc(String string, int n, int n2) {
    }

    default public void setLanguageByInstrumentCluster(String string) {
    }

    default public void setLanguageByLanguageMaster(String string) {
    }

    default public void setLanguageByHmi(String string) {
    }

    default public void setSkinByHmi(int n) {
    }

    default public void setSkinModeByHmi(int n) {
    }

    default public void swdlHasHappened() {
    }

    default public void navIsReady() {
    }

    default public void speechInputsystemIsReady() {
    }

    default public void speechOutputsystemIsReady() {
    }
}

