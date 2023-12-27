/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.speech;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.speech.SpeechProbeConfiguration;
import de.vw.mib.debug.service.probes.speech.SpeechCodec;
import de.vw.mib.debug.service.probes.speech.SpeechProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class SpeechProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider;

    @Override
    public String getName() {
        return "SPEECH";
    }

    @Override
    public short getMessageType() {
        return 274;
    }

    @Override
    public short getConfigurationMessageType() {
        return 57;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new SpeechProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider == null ? (class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider = SpeechProbeFactory.class$("de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisDataProvider")) : class$de$vw$mib$asl$api$speechengine$diagnosis$SpeechDiagnosisDataProvider).getName()};
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new SpeechCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new SpeechProbe(probeSystemServices);
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

