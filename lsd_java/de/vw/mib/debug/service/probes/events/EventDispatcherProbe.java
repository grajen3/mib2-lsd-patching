/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.events;

import de.vw.mib.debug.service.probes.events.EventTracerHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class EventDispatcherProbe
extends AbstractDebugProbe {
    private EventTracerHelper eventTracerHelper;
    static /* synthetic */ Class class$de$vw$mib$event$internal$diag$EventTracer;

    public EventDispatcherProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.eventTracerHelper = new EventTracerHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$event$internal$diag$EventTracer == null ? (class$de$vw$mib$event$internal$diag$EventTracer = EventDispatcherProbe.class$("de.vw.mib.event.internal.diag.EventTracer")) : class$de$vw$mib$event$internal$diag$EventTracer).getName(), this.eventTracerHelper);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$event$internal$diag$EventTracer == null ? (class$de$vw$mib$event$internal$diag$EventTracer = EventDispatcherProbe.class$("de.vw.mib.event.internal.diag.EventTracer")) : class$de$vw$mib$event$internal$diag$EventTracer).getName(), this.eventTracerHelper);
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

