/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.hsm;

import de.vw.mib.debug.service.probes.hsm.HsmStateTracerHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class HsmProbe
extends AbstractDebugProbe {
    private HsmStateTracerHelper hsmStateTracerHelper;
    static /* synthetic */ Class class$de$vw$mib$genericevents$diag$HsmStateTracer;

    public HsmProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.hsmStateTracerHelper = new HsmStateTracerHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$genericevents$diag$HsmStateTracer == null ? (class$de$vw$mib$genericevents$diag$HsmStateTracer = HsmProbe.class$("de.vw.mib.genericevents.diag.HsmStateTracer")) : class$de$vw$mib$genericevents$diag$HsmStateTracer).getName(), this.hsmStateTracerHelper);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$genericevents$diag$HsmStateTracer == null ? (class$de$vw$mib$genericevents$diag$HsmStateTracer = HsmProbe.class$("de.vw.mib.genericevents.diag.HsmStateTracer")) : class$de$vw$mib$genericevents$diag$HsmStateTracer).getName(), this.hsmStateTracerHelper);
        return true;
    }

    @Override
    protected boolean configureProbe() {
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
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

