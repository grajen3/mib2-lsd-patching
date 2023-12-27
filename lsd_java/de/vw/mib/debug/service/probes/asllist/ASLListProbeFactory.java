/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.asllist;

import de.vw.mib.debug.common.probes.asllist.ASLListProbeConfiguration;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.service.probes.asllist.ASLListCodec;
import de.vw.mib.debug.service.probes.asllist.ASLListProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class ASLListProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$list$DynamicListManager;

    @Override
    public String getName() {
        return "ASLLIST";
    }

    @Override
    public short getMessageType() {
        return 261;
    }

    @Override
    public short getConfigurationMessageType() {
        return 50;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new ASLListProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$list$DynamicListManager == null ? (class$de$vw$mib$list$DynamicListManager = ASLListProbeFactory.class$("de.vw.mib.list.DynamicListManager")) : class$de$vw$mib$list$DynamicListManager).getName()};
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new ASLListCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new ASLListProbe(probeSystemServices);
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

