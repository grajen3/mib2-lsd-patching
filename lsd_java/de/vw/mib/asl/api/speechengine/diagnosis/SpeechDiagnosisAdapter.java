/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.diagnosis;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.tts.TTSPrompt;

public class SpeechDiagnosisAdapter
implements SpeechDiagnosisListener {
    @Override
    public void loadGrammar(Grammar[] grammarArray) {
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
    }

    @Override
    public void requestPlayTone(short s, int n) {
    }

    @Override
    public void speakPrompt(short s, TTSPrompt tTSPrompt) {
    }

    @Override
    public void warn(String string) {
    }

    @Override
    public void error(String string) {
    }

    @Override
    public void info(String string) {
    }

    @Override
    public void changedDialogManagerState(int n) {
    }

    @Override
    public void changedSlotState(int n, int n2) {
    }

    @Override
    public void changedBackStack(String string) {
    }

    @Override
    public void changedDialogState(int n) {
    }
}

