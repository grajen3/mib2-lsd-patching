/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.statemachine;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.statemachine.StatemachineProbeConfiguration;
import de.vw.mib.debug.service.probes.statemachine.StatemachineCodec;
import de.vw.mib.debug.service.probes.statemachine.StatemachineProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class StatemachineProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$sm$StatemachineDiagnose;

    @Override
    public String getName() {
        return "STATEMACHINE";
    }

    @Override
    public short getMessageType() {
        return 265;
    }

    @Override
    public short getConfigurationMessageType() {
        return 58;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new StatemachineProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$sm$StatemachineDiagnose == null ? (class$de$vw$mib$sm$StatemachineDiagnose = StatemachineProbeFactory.class$("de.vw.mib.sm.StatemachineDiagnose")) : class$de$vw$mib$sm$StatemachineDiagnose).getName()};
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new StatemachineCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new StatemachineProbe(probeSystemServices);
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

