/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.cio;

import de.vw.mib.debug.common.probes.app.cio.CioProbeConfiguration;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.service.probes.app.cio.CioCodec;
import de.vw.mib.debug.service.probes.app.cio.CioProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class CioProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$cio$framework$diag$CioDiagService;

    @Override
    public String getName() {
        return "CIO";
    }

    @Override
    public short getMessageType() {
        return 282;
    }

    @Override
    public short getConfigurationMessageType() {
        return 63;
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$cio$framework$diag$CioDiagService == null ? (class$de$vw$mib$cio$framework$diag$CioDiagService = CioProbeFactory.class$("de.vw.mib.cio.framework.diag.CioDiagService")) : class$de$vw$mib$cio$framework$diag$CioDiagService).getName()};
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new CioProbeConfiguration();
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new CioCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new CioProbe(probeSystemServices);
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

