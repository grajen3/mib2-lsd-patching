/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.diagnosis;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosis;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.diagnosis.GrammarDiagnosis;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.tts.TTSPrompt;

public class DialogSystemDiagnosisImpl
implements DialogSystemDiagnosis,
DialogSystemDiagnosisListener {
    private static final int TRACE_CLASS;
    private static final String TRACE_PREFIX;
    private GrammarDiagnosis grammarMonitor;
    private final Logger speechLogger;
    private List diagnosisListenerList = new ArrayList(0);

    public DialogSystemDiagnosisImpl(Logger logger) {
        this.speechLogger = logger;
        this.grammarMonitor = null;
    }

    private void logTrace(String string) {
        if (this.speechLogger.isTraceEnabled(32)) {
            LogMessage logMessage = this.speechLogger.trace(32);
            logMessage.append("[SpeechDiagnosis] ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public DialogSystemDiagnosisListener getDiagnosisListener() {
        return this;
    }

    public void setGrammarMonitor(GrammarDiagnosis grammarDiagnosis) {
        this.grammarMonitor = grammarDiagnosis;
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            this.grammarMonitor.onDiagnosisListenerRegistered((DialogSystemDiagnosisListener)iterator.next());
        }
    }

    @Override
    public void addListener(DialogSystemDiagnosisListener dialogSystemDiagnosisListener) {
        this.logTrace("addListener");
        this.diagnosisListenerList.add(dialogSystemDiagnosisListener);
        if (this.grammarMonitor != null) {
            this.grammarMonitor.onDiagnosisListenerRegistered(dialogSystemDiagnosisListener);
        }
    }

    @Override
    public void removeListener(DialogSystemDiagnosisListener dialogSystemDiagnosisListener) {
        this.logTrace("removeListener");
        this.diagnosisListenerList.remove(dialogSystemDiagnosisListener);
    }

    @Override
    public void loadGrammar(Grammar[] grammarArray) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).loadGrammar(grammarArray);
        }
    }

    @Override
    public void unloadGrammar(GrammarInfo[] grammarInfoArray) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).unloadGrammar(grammarInfoArray);
        }
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).responseWaitForResults(n, nBestList);
        }
    }

    @Override
    public void changedSlotState(int n, int n2) {
        Object object;
        if (this.speechLogger.isTraceEnabled(32)) {
            object = this.speechLogger.trace(32);
            object.append("[SpeechDiagnosis] ");
            object.append("changedSlotState( ");
            object.append(" slotId=").append(n);
            object.append(" , slotState=").append(n2);
            object.append(" )");
            object.log();
        }
        object = this.diagnosisListenerList.iterator();
        while (object.hasNext()) {
            ((DialogSystemDiagnosisListener)object.next()).changedSlotState(n, n2);
        }
    }

    @Override
    public void requestPlayTone(short s, int n) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).requestPlayTone(s, n);
        }
    }

    @Override
    public void speakPrompt(short s, TTSPrompt tTSPrompt) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).speakPrompt(s, tTSPrompt);
        }
    }

    @Override
    public void warn(String string) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).warn(string);
        }
    }

    @Override
    public void error(String string) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).error(string);
        }
    }

    @Override
    public void info(String string) {
        Iterator iterator = this.diagnosisListenerList.iterator();
        while (iterator.hasNext()) {
            ((DialogSystemDiagnosisListener)iterator.next()).info(string);
        }
    }
}

