/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.diagnosis;

import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.tts.TTSPrompt;

public interface SpeechDiagnosisListener {
    default public void loadGrammar(Grammar[] grammarArray) {
    }

    default public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
    }

    default public void responseWaitForResults(int n, NBestList nBestList) {
    }

    default public void changedSlotState(int n, int n2) {
    }

    default public void requestPlayTone(short s, int n) {
    }

    default public void speakPrompt(short s, TTSPrompt tTSPrompt) {
    }

    default public void warn(String string) {
    }

    default public void error(String string) {
    }

    default public void info(String string) {
    }

    default public void changedDialogManagerState(int n) {
    }

    default public void changedBackStack(String string) {
    }

    default public void changedDialogState(int n) {
    }
}

