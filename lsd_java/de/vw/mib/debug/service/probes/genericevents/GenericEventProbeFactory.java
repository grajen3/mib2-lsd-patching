/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.genericevents;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.genericevents.GenericEventProbeConfiguration;
import de.vw.mib.debug.service.probes.genericevents.GenericEventCodec;
import de.vw.mib.debug.service.probes.genericevents.GenericEventProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class GenericEventProbeFactory
implements DebugProbeFactory {
    @Override
    public String getName() {
        return "GENERICEVENT";
    }

    @Override
    public short getMessageType() {
        return 258;
    }

    @Override
    public short getConfigurationMessageType() {
        return 54;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new GenericEventProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return null;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new GenericEventCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new GenericEventProbe(probeSystemServices);
    }
}

