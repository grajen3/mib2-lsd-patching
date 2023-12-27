/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.dsimethodcall;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.dsimethodcall.DsiMethodCallProbeConfiguration;
import de.vw.mib.debug.service.probes.dsimethodcall.DsiMethodCallCodec;
import de.vw.mib.debug.service.probes.dsimethodcall.DsiMethodCallProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class DsiMethodCallProbeFactory
implements DebugProbeFactory {
    @Override
    public String getName() {
        return "DSIEVENTS";
    }

    @Override
    public short getMessageType() {
        return 272;
    }

    @Override
    public short getConfigurationMessageType() {
        return 52;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new DsiMethodCallProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return null;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new DsiMethodCallCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new DsiMethodCallProbe(probeSystemServices);
    }
}

