/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.featureflags;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.common.probes.featureflags.FeatureFlagProbeConfiguration;
import de.vw.mib.debug.service.probes.featureflags.FeatureFlagCodec;
import de.vw.mib.debug.service.probes.featureflags.FeatureFlagProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class FeatureFlagProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerDiag;

    @Override
    public String getName() {
        return "FEATUREFLAG";
    }

    @Override
    public short getMessageType() {
        return 280;
    }

    @Override
    public short getConfigurationMessageType() {
        return 62;
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new FeatureFlagProbeConfiguration();
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$configuration$ConfigurationManagerDiag == null ? (class$de$vw$mib$configuration$ConfigurationManagerDiag = FeatureFlagProbeFactory.class$("de.vw.mib.configuration.ConfigurationManagerDiag")) : class$de$vw$mib$configuration$ConfigurationManagerDiag).getName()};
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new FeatureFlagCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new FeatureFlagProbe(probeSystemServices);
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

