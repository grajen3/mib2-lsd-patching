/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.viewmanager;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.viewmanager.ViewManagerProbeConfiguration;
import de.vw.mib.debug.service.probes.viewmanager.ViewManagerCodec;
import de.vw.mib.debug.service.probes.viewmanager.ViewManagerProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class ViewManagerProbeFactory
implements DebugProbeFactory {
    @Override
    public String getName() {
        return "VIEWMANAGER";
    }

    @Override
    public short getMessageType() {
        return 275;
    }

    @Override
    public short getConfigurationMessageType() {
        return 60;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new ViewManagerProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return null;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new ViewManagerCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new ViewManagerProbe(probeSystemServices);
    }
}

