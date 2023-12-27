/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.hsm;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.hsm.HsmProbeConfiguration;
import de.vw.mib.debug.service.probes.hsm.HsmCodec;
import de.vw.mib.debug.service.probes.hsm.HsmProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class HsmProbeFactory
implements DebugProbeFactory {
    @Override
    public String getName() {
        return "HSMPROBE";
    }

    @Override
    public short getMessageType() {
        return 279;
    }

    @Override
    public short getConfigurationMessageType() {
        return 61;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new HsmProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return null;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new HsmCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new HsmProbe(probeSystemServices);
    }
}

