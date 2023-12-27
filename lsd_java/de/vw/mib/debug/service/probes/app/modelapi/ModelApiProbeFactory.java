/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.modelapi;

import de.vw.mib.debug.common.probes.app.lifecycle.LifecycleProbeConfiguration;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debug.service.probes.app.modelapi.ModelApiCodec;
import de.vw.mib.debug.service.probes.app.modelapi.ModelApiProbe;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class ModelApiProbeFactory
implements DebugProbeFactory {
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$AppFrameworkDiagService;

    @Override
    public String getName() {
        return "MODEL_API";
    }

    @Override
    public short getMessageType() {
        return 284;
    }

    @Override
    public short getConfigurationMessageType() {
        return 65;
    }

    @Override
    public String[] getMandatoryServiceNames() {
        return new String[]{(class$de$vw$mib$app$framework$diag$AppFrameworkDiagService == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagService = ModelApiProbeFactory.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagService")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagService).getName()};
    }

    @Override
    public DebugProbeConfiguration createProbeConfiguration() {
        return new LifecycleProbeConfiguration();
    }

    @Override
    public AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new ModelApiCodec(probeSystemServices);
    }

    @Override
    public DebugProbe createProbe(ProbeSystemServices probeSystemServices) {
        return new ModelApiProbe(probeSystemServices);
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

