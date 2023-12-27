/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogBackstackFactoryImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerActivator;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerActivatorCallback;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerFactoryImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogmanager.SpeakOnlyServiceFactoryImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterDataManagerFactoryImpl;

public class DialogManagerStartup
implements DialogManagerActivator {
    private DialogManagerImpl dialogManager;
    private DialogManagerActivatorCallback dialogManagerActivatorCallback;
    private DialogManagerParameters dialogManagerParameters;

    @Override
    public void activateProxy(DialogManagerParameters dialogManagerParameters) {
        this.dialogManagerParameters = dialogManagerParameters;
        this.dialogManager = new DialogManagerImpl(dialogManagerParameters);
        this.dialogManagerActivatorCallback = dialogManagerParameters.getSpeechEngineStarter();
        SpeakOnlyServiceFactoryImpl speakOnlyServiceFactoryImpl = new SpeakOnlyServiceFactoryImpl(this.dialogManager);
        this.dialogManagerActivatorCallback.onSpeakOnlyServiceFactoryReady(speakOnlyServiceFactoryImpl);
        this.dialogManagerActivatorCallback.onDialogManagerProxyReady(this.dialogManager);
    }

    @Override
    public void activateManager(SpeechDialogSystem speechDialogSystem) {
        this.dialogManager.initializeSpeech(speechDialogSystem);
        DialogManagerFactoryImpl dialogManagerFactoryImpl = new DialogManagerFactoryImpl(this.dialogManager);
        TeleprompterDataManagerFactoryImpl teleprompterDataManagerFactoryImpl = new TeleprompterDataManagerFactoryImpl(this.dialogManager, this.dialogManagerParameters.getSpeechLogger());
        DialogManagerDiagnosisImpl dialogManagerDiagnosisImpl = new DialogManagerDiagnosisImpl(this.dialogManager, this.dialogManager.getBackStack());
        DialogBackstackFactoryImpl dialogBackstackFactoryImpl = new DialogBackstackFactoryImpl(this.dialogManager);
        this.dialogManagerActivatorCallback.onDialogManagerReady(dialogManagerFactoryImpl);
        this.dialogManagerActivatorCallback.onTeleprompterDataManagerFactoryReady(teleprompterDataManagerFactoryImpl);
        this.dialogManagerActivatorCallback.onDialogManagerDiagnosisReady(dialogManagerDiagnosisImpl);
        this.dialogManagerActivatorCallback.onDialogBackstackFactoryReady(dialogBackstackFactoryImpl);
    }
}

