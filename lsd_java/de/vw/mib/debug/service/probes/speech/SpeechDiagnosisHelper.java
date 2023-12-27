/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.speech;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisAdapter;
import de.vw.mib.debug.service.probes.speech.SpeechCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.tts.TTSPrompt;

public final class SpeechDiagnosisHelper
extends SpeechDiagnosisAdapter {
    private final ProbeSystemServices probeSystemServices;

    SpeechDiagnosisHelper(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void loadGrammar(Grammar[] grammarArray) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeLoadGrammar(grammarArray);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeUnloadGrammar(grammarInfoArray);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeResponseWaitForResults(n, nBestList);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void requestPlayTone(short s, int n) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeRequestPlayTone(s, n);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void speakPrompt(short s, TTSPrompt tTSPrompt) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeSpeakPrompt(s, tTSPrompt);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void warn(String string) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeWarn(string);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void error(String string) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeError(string);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void info(String string) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeInfo(string);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void changedDialogManagerState(int n) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeChangedDialogManagerState(n);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void changedSlotState(int n, int n2) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeChangedSlotState(n, n2);
        this.probeSystemServices.releaseCodec(speechCodec);
    }

    @Override
    public void changedBackStack(String string) {
        SpeechCodec speechCodec = (SpeechCodec)this.probeSystemServices.borrowCodec();
        speechCodec.encodeChangedBackStack(string);
        this.probeSystemServices.releaseCodec(speechCodec);
    }
}

