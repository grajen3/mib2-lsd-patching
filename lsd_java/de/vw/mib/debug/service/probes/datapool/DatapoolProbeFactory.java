/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.datapool;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.datapool.DatapoolProbeConfiguration;
import de.vw.mib.debug.service.probes.datapool.DatapoolCodec;
import de.vw.mib.debug.service.probes.datapool.DatapoolProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class DatapoolProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$datapool$ModelDatapool;

    @Override
    public String getName() {
        return "DATAPOOL";
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new DatapoolProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$datapool$ModelDatapool == null ? (class$de$vw$mib$datapool$ModelDatapool = DatapoolProbeFactory.class$("de.vw.mib.datapool.ModelDatapool")) : class$de$vw$mib$datapool$ModelDatapool).getName()};
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new DatapoolProbe(probeSystemServices);
    }

    @Override
    public short getMessageType() {
        return 262;
    }

    @Override
    public short getConfigurationMessageType() {
        return 51;
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new DatapoolCodec(probeSystemServices);
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

