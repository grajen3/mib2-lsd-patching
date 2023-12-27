/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.timer;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.timer.TimerProbeConfiguration;
import de.vw.mib.debug.service.probes.timer.TimerCodec;
import de.vw.mib.debug.service.probes.timer.TimerProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class TimerProbeFactory
implements DebugProbeFactory {
    @Override
    public String getName() {
        return "TIMER";
    }

    @Override
    public short getMessageType() {
        return 277;
    }

    @Override
    public short getConfigurationMessageType() {
        return 59;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new TimerProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return null;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new TimerCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new TimerProbe(probeSystemServices);
    }
}

