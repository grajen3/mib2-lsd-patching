/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisDataProvider;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosis;
import de.vw.mib.asl.internal.speechengine.diagnosis.SpeechEngineDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosis;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class SpeechEngineDiagnosisHandler {
    private final AbstractClassifiedLogger logger;
    private final FrameworkServices frameworkServices;
    private DialogManagerDiagnosis dialogManagerDiagnosis;
    private DialogSystemDiagnosis dialogSystemDiagnosis;
    private SpeechMessengerServices speechMessengerServices;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider;

    public SpeechEngineDiagnosisHandler(AbstractClassifiedLogger abstractClassifiedLogger, FrameworkServices frameworkServices) {
        this.logger = abstractClassifiedLogger;
        this.frameworkServices = frameworkServices;
    }

    public void updateDialogManagerDiagnosis(DialogManagerDiagnosis dialogManagerDiagnosis) {
        this.dialogManagerDiagnosis = dialogManagerDiagnosis;
        this.servicesChanged();
    }

    public void updateDialogSystemDiagnosis(DialogSystemDiagnosis dialogSystemDiagnosis) {
        this.dialogSystemDiagnosis = dialogSystemDiagnosis;
        this.servicesChanged();
    }

    public void updateSpeechMessengerServices(SpeechMessengerServices speechMessengerServices) {
        this.speechMessengerServices = speechMessengerServices;
        this.servicesChanged();
    }

    private void servicesChanged() {
        if (this.dialogManagerDiagnosis == null || this.dialogSystemDiagnosis == null || this.speechMessengerServices == null) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("SpeechEngineDiagnosis ready.").log();
        }
        SpeechEngineDiagnosis speechEngineDiagnosis = new SpeechEngineDiagnosis(this.logger, this.dialogSystemDiagnosis, this.dialogManagerDiagnosis, this.speechMessengerServices);
        SpeechDiagnosisDataProvider speechDiagnosisDataProvider = (SpeechDiagnosisDataProvider)this.frameworkServices.getAsyncServiceFactory().create(speechEngineDiagnosis);
        this.frameworkServices.getBundleContext().registerService((class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider == null ? (class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider = SpeechEngineDiagnosisHandler.class$("de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisDataProvider")) : class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider).getName(), (Object)speechDiagnosisDataProvider, null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

