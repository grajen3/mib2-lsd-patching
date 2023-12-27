/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.speech;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisAdapter;
import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisDataProvider;
import de.vw.mib.debug.service.probes.speech.SpeechDiagnosisHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

final class SpeechProbe
extends AbstractDebugProbe {
    private SpeechDiagnosisDataProvider speechDiagnosisDataProvider;
    private SpeechDiagnosisAdapter speechDiagnosisListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider;

    SpeechProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean deactivateProbe() {
        this.speechDiagnosisDataProvider.removeListener(this.speechDiagnosisListener);
        return true;
    }

    @Override
    protected boolean initProbe() {
        this.speechDiagnosisDataProvider = (SpeechDiagnosisDataProvider)this.probeSystemServices.getService((class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider == null ? (class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider = SpeechProbe.class$("de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisDataProvider")) : class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider).getName());
        this.speechDiagnosisListener = new SpeechDiagnosisHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.speechDiagnosisDataProvider.addListener(this.speechDiagnosisListener);
        return true;
    }

    @Override
    protected boolean configureProbe() {
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
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

