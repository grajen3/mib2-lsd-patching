/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.logging;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class LoggerSettingsCodec
extends AbstractProbeCodec {
    public LoggerSettingsCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected byte getCodecVersion() {
        return -1;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 55;
    }

    @Override
    protected short getMessageType() {
        return 264;
    }
}

