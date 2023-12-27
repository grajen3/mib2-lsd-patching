/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.events;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.events.EventDispatcherProbeConfiguration;
import de.vw.mib.debug.service.probes.events.EventCodec;
import de.vw.mib.debug.service.probes.events.EventDispatcherProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class EventDispatcherProbeFactory
implements DebugProbeFactory {
    @Override
    public String getName() {
        return "EVENTDISPATCHER";
    }

    @Override
    public short getMessageType() {
        return 263;
    }

    @Override
    public short getConfigurationMessageType() {
        return 53;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new EventDispatcherProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return null;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new EventCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new EventDispatcherProbe(probeSystemServices);
    }
}

