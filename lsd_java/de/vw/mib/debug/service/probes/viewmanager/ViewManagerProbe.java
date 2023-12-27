/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.viewmanager;

import de.vw.mib.debug.service.probes.viewmanager.DiagViewListHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class ViewManagerProbe
extends AbstractDebugProbe {
    private DiagViewListHelper diagViewListHelper;
    static /* synthetic */ Class class$de$vw$mib$viewmanager$internal$DiagViewListListener;

    public ViewManagerProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.diagViewListHelper = new DiagViewListHelper(this.probeSystemServices);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$viewmanager$internal$DiagViewListListener == null ? (class$de$vw$mib$viewmanager$internal$DiagViewListListener = ViewManagerProbe.class$("de.vw.mib.viewmanager.internal.DiagViewListListener")) : class$de$vw$mib$viewmanager$internal$DiagViewListListener).getName(), this.diagViewListHelper);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$viewmanager$internal$DiagViewListListener == null ? (class$de$vw$mib$viewmanager$internal$DiagViewListListener = ViewManagerProbe.class$("de.vw.mib.viewmanager.internal.DiagViewListListener")) : class$de$vw$mib$viewmanager$internal$DiagViewListListener).getName(), this.diagViewListHelper);
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

