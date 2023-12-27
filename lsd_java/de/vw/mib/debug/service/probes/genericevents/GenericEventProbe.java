/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.genericevents;

import de.vw.mib.debug.service.probes.genericevents.GenericEventTracerHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.genericevents.diag.GenericEventTracer;

public final class GenericEventProbe
extends AbstractDebugProbe {
    private GenericEventTracer genericEventTracer;
    static /* synthetic */ Class class$de$vw$mib$genericevents$diag$GenericEventTracer;

    public GenericEventProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.genericEventTracer = new GenericEventTracerHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$genericevents$diag$GenericEventTracer == null ? (class$de$vw$mib$genericevents$diag$GenericEventTracer = GenericEventProbe.class$("de.vw.mib.genericevents.diag.GenericEventTracer")) : class$de$vw$mib$genericevents$diag$GenericEventTracer).getName(), this.genericEventTracer);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$genericevents$diag$GenericEventTracer == null ? (class$de$vw$mib$genericevents$diag$GenericEventTracer = GenericEventProbe.class$("de.vw.mib.genericevents.diag.GenericEventTracer")) : class$de$vw$mib$genericevents$diag$GenericEventTracer).getName(), this.genericEventTracer);
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

