/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.esam;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.EsamDiagListener;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class EsamProbe
extends AbstractDebugProbe
implements EsamDiagListener {
    public EsamProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        return false;
    }

    @Override
    protected boolean configureProbe() {
        return false;
    }

    @Override
    protected boolean activateProbe() {
        return false;
    }

    @Override
    protected boolean deactivateProbe() {
        return false;
    }

    @Override
    protected boolean cleanUpProbe() {
        return false;
    }

    @Override
    public void onEsamVisibilityRelease(AppDiag appDiag, String string, String string2) {
    }

    @Override
    public void onEsamVisibilityRequest(AppDiag appDiag, String string, String string2) {
    }

    @Override
    public void onEsamVisibilityDenied(AppDiag appDiag, String string, String string2, String string3) {
    }

    @Override
    public void onEsamVisibilityDenied(AppDiag appDiag, String string, String string2, String string3, String string4) {
    }

    @Override
    public void onEsamVisibilityGranted(AppDiag appDiag, String string, String string2) {
    }

    @Override
    public void onEsamVisibilityRevoked(AppDiag appDiag, String string, String string2, String string3, String string4) {
    }

    @Override
    public void onRequestHideAllEsamMembers(AppDiag appDiag, String string, String string2) {
    }
}

