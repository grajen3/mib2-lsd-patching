/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.logging;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.logmanager.LogManagerProbeConfiguration;
import de.vw.mib.debug.service.probes.logging.LogManagerProbe;
import de.vw.mib.debug.service.probes.logging.LoggerSettingsCodec;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class LogManagerProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManagerDiag;

    @Override
    public String getName() {
        return "LOGMANAGER";
    }

    @Override
    public short getMessageType() {
        return 264;
    }

    @Override
    public short getConfigurationMessageType() {
        return 55;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new LogManagerProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$log4mib$LogManagerDiag == null ? (class$de$vw$mib$log4mib$LogManagerDiag = LogManagerProbeFactory.class$("de.vw.mib.log4mib.LogManagerDiag")) : class$de$vw$mib$log4mib$LogManagerDiag).getName()};
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new LoggerSettingsCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new LogManagerProbe(probeSystemServices);
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

