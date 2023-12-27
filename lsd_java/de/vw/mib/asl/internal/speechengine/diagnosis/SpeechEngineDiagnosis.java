/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.diagnosis;

import de.vw.mib.asl.api.speech.diagnosis.SpeechDiagnosisListener;
import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisDataProvider;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogManagerDiagnosisListenerImpl;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogStateListenerImpl;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosis;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListenerImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;

public class SpeechEngineDiagnosis
implements SpeechDiagnosisDataProvider {
    private final DialogSystemDiagnosis dialogSystemDiagnosis;
    private final DialogManagerDiagnosis dialogManagerDiagnosis;
    private final SpeechMessengerServices speechMessengerServices;
    private ObjectObjectMap dmListeners;
    private ObjectObjectMap dsListeners;
    private ObjectObjectMap dialogStateListeners;
    private boolean initialized = false;
    private final AbstractClassifiedLogger logger;

    public SpeechEngineDiagnosis(AbstractClassifiedLogger abstractClassifiedLogger, DialogSystemDiagnosis dialogSystemDiagnosis, DialogManagerDiagnosis dialogManagerDiagnosis, SpeechMessengerServices speechMessengerServices) {
        this.logger = abstractClassifiedLogger;
        this.dialogSystemDiagnosis = dialogSystemDiagnosis;
        this.dialogManagerDiagnosis = dialogManagerDiagnosis;
        this.speechMessengerServices = speechMessengerServices;
    }

    @Override
    public void addListener(de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener speechDiagnosisListener) {
        if (!this.initialized) {
            this.dmListeners = new ObjectObjectOptHashMap();
            this.dsListeners = new ObjectObjectOptHashMap();
            this.dialogStateListeners = new ObjectObjectOptHashMap();
            this.initialized = true;
        }
        DialogSystemDiagnosisListenerImpl dialogSystemDiagnosisListenerImpl = new DialogSystemDiagnosisListenerImpl(speechDiagnosisListener);
        this.dialogSystemDiagnosis.addListener(dialogSystemDiagnosisListenerImpl);
        this.dsListeners.put(speechDiagnosisListener, dialogSystemDiagnosisListenerImpl);
        DialogManagerDiagnosisListenerImpl dialogManagerDiagnosisListenerImpl = new DialogManagerDiagnosisListenerImpl(speechDiagnosisListener);
        this.dialogManagerDiagnosis.registerDialogManagerDiagnosisListener(dialogManagerDiagnosisListenerImpl);
        this.dmListeners.put(speechDiagnosisListener, dialogManagerDiagnosisListenerImpl);
        DialogStateListenerImpl dialogStateListenerImpl = new DialogStateListenerImpl(speechDiagnosisListener);
        this.speechMessengerServices.getDialogStateRouter().register(dialogStateListenerImpl);
        this.dialogStateListeners.put(speechDiagnosisListener, dialogStateListenerImpl);
    }

    @Override
    public void removeListener(de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener speechDiagnosisListener) {
        DialogStateConsumer dialogStateConsumer;
        DialogManagerDiagnosisListener dialogManagerDiagnosisListener;
        if (!this.initialized) {
            return;
        }
        DialogSystemDiagnosisListener dialogSystemDiagnosisListener = (DialogSystemDiagnosisListener)this.dsListeners.get(speechDiagnosisListener);
        if (dialogSystemDiagnosisListener != null) {
            this.dialogSystemDiagnosis.removeListener(dialogSystemDiagnosisListener);
        }
        if ((dialogManagerDiagnosisListener = (DialogManagerDiagnosisListener)this.dmListeners.get(speechDiagnosisListener)) != null) {
            this.dialogManagerDiagnosis.unregisterDialogManagerDiagnosisListener(dialogManagerDiagnosisListener);
        }
        if ((dialogStateConsumer = (DialogStateConsumer)this.dialogStateListeners.get(speechDiagnosisListener)) != null) {
            this.speechMessengerServices.getDialogStateRouter().unregister(dialogStateConsumer);
        }
    }

    @Override
    public void addListener(SpeechDiagnosisListener speechDiagnosisListener) {
        this.logger.error().append("Used unsupported legacy speech diagnosis").log();
        try {
            this.addListener((de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener)((Object)speechDiagnosisListener));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void removeListener(SpeechDiagnosisListener speechDiagnosisListener) {
        this.logger.error().append("Used unsupported legacy speech diagnosis").log();
        try {
            this.removeListener((de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener)((Object)speechDiagnosisListener));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

