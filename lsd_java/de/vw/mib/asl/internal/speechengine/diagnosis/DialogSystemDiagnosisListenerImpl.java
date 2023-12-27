/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.diagnosis;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.tts.TTSPrompt;

public class DialogSystemDiagnosisListenerImpl
implements DialogSystemDiagnosisListener {
    private final SpeechDiagnosisListener listener;

    public DialogSystemDiagnosisListenerImpl(SpeechDiagnosisListener speechDiagnosisListener) {
        this.listener = speechDiagnosisListener;
    }

    @Override
    public void loadGrammar(Grammar[] grammarArray) {
        this.listener.loadGrammar(grammarArray);
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
        this.listener.unloadGrammar(grammarInfoArray);
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        this.listener.responseWaitForResults(n, nBestList);
    }

    @Override
    public void changedSlotState(int n, int n2) {
        this.listener.changedSlotState(n, n2);
    }

    @Override
    public void requestPlayTone(short s, int n) {
        this.listener.requestPlayTone(s, n);
    }

    @Override
    public void speakPrompt(short s, TTSPrompt tTSPrompt) {
        this.listener.speakPrompt(s, tTSPrompt);
    }

    @Override
    public void warn(String string) {
        this.listener.warn(string);
    }

    @Override
    public void error(String string) {
        this.listener.error(string);
    }

    @Override
    public void info(String string) {
        this.listener.info(string);
    }
}

