/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogBackstackFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy;
import de.vw.mib.asl.internal.speechengine.dialogmanager.SpeakOnlyServiceFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosis;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerFactory;

public interface DialogManagerActivatorCallback {
    default public void onDialogManagerProxyReady(DialogManagerProxy dialogManagerProxy) {
    }

    default public void onSpeakOnlyServiceFactoryReady(SpeakOnlyServiceFactory speakOnlyServiceFactory) {
    }

    default public void onDialogManagerReady(DialogManagerFactory dialogManagerFactory) {
    }

    default public void onDialogManagerDiagnosisReady(DialogManagerDiagnosis dialogManagerDiagnosis) {
    }

    default public void onTeleprompterDataManagerFactoryReady(TeleprompterDataManagerFactory teleprompterDataManagerFactory) {
    }

    default public void onDialogBackstackFactoryReady(DialogBackstackFactory dialogBackstackFactory) {
    }
}

