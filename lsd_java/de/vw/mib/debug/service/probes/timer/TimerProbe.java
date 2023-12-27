/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.timer;

import de.vw.mib.debug.service.probes.timer.TimerCodec;
import de.vw.mib.debug.service.probes.timer.TimerDiagHelper;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class TimerProbe
extends AbstractDebugProbe {
    private TimerDiagHelper timerDiagHelper;
    static /* synthetic */ Class class$de$vw$mib$timer$diag$TimerDiag;

    public TimerProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    protected AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new TimerCodec(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.timerDiagHelper = new TimerDiagHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$timer$diag$TimerDiag == null ? (class$de$vw$mib$timer$diag$TimerDiag = TimerProbe.class$("de.vw.mib.timer.diag.TimerDiag")) : class$de$vw$mib$timer$diag$TimerDiag).getName(), this.timerDiagHelper);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$timer$diag$TimerDiag == null ? (class$de$vw$mib$timer$diag$TimerDiag = TimerProbe.class$("de.vw.mib.timer.diag.TimerDiag")) : class$de$vw$mib$timer$diag$TimerDiag).getName(), this.timerDiagHelper);
        return true;
    }

    public String getName() {
        return "TIMER";
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

