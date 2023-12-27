/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.probes;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public interface DebugProbeFactory {
    default public String getName() {
    }

    default public short getMessageType() {
    }

    default public short getConfigurationMessageType() {
    }

    default public String[] getMandatoryServiceNames() {
    }

    default public DebugProbeConfiguration createProbeConfiguration() {
    }

    default public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
    }

    default public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
    }
}

