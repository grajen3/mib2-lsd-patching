/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.queues;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.queues.QueuesProbeConfiguration;
import de.vw.mib.debug.service.probes.queues.QueuesCodec;
import de.vw.mib.debug.service.probes.queues.QueuesProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class QueuesProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$event$internal$diag$EventDispatcherDiag;

    @Override
    public String getName() {
        return "QUEUES";
    }

    @Override
    public short getMessageType() {
        return 276;
    }

    @Override
    public short getConfigurationMessageType() {
        return 56;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new QueuesProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$event$internal$diag$EventDispatcherDiag == null ? (class$de$vw$mib$event$internal$diag$EventDispatcherDiag = QueuesProbeFactory.class$("de.vw.mib.event.internal.diag.EventDispatcherDiag")) : class$de$vw$mib$event$internal$diag$EventDispatcherDiag).getName()};
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new QueuesCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new QueuesProbe(probeSystemServices);
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

