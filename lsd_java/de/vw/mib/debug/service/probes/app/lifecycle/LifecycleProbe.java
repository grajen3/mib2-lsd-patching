/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.app.lifecycle;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.AppFrameworkDiagListener;
import de.vw.mib.debug.service.probes.app.lifecycle.LifecycleCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class LifecycleProbe
extends AbstractDebugProbe
implements AppFrameworkDiagListener {
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener;

    public LifecycleProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        return true;
    }

    @Override
    protected boolean configureProbe() {
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.probeSystemServices.registerService((class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener = LifecycleProbe.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagListener")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener).getName(), this);
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.probeSystemServices.unregisterService((class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener = LifecycleProbe.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagListener")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener).getName(), this);
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
    }

    @Override
    public void onEnterView(AppDiag appDiag, String string, String[] stringArray, String string2) {
        LifecycleCodec lifecycleCodec = (LifecycleCodec)this.probeSystemServices.borrowCodec();
        lifecycleCodec.encodeEnterView(appDiag, string, stringArray, string2);
        this.probeSystemServices.releaseCodec(lifecycleCodec);
    }

    @Override
    public void onLeaveView(AppDiag appDiag, String string, String[] stringArray, String string2) {
        LifecycleCodec lifecycleCodec = (LifecycleCodec)this.probeSystemServices.borrowCodec();
        lifecycleCodec.encodeLeaveView(appDiag, string, stringArray, string2);
        this.probeSystemServices.releaseCodec(lifecycleCodec);
    }

    @Override
    public void onLifecycleChanged(AppDiag appDiag, int n) {
        LifecycleCodec lifecycleCodec = (LifecycleCodec)this.probeSystemServices.borrowCodec();
        lifecycleCodec.encodeLifecycleChanged(appDiag, n);
        this.probeSystemServices.releaseCodec(lifecycleCodec);
    }

    @Override
    public void onVisibilityChanged(AppDiag appDiag, String string, String[] stringArray, boolean bl) {
        LifecycleCodec lifecycleCodec = (LifecycleCodec)this.probeSystemServices.borrowCodec();
        lifecycleCodec.encodeVisibilityChanged(appDiag, string, stringArray, bl);
        this.probeSystemServices.releaseCodec(lifecycleCodec);
    }

    @Override
    public void onRequestVisibility(AppDiag appDiag, String string) {
    }

    @Override
    public void onRequestVisibilityDenied(AppDiag appDiag, String string) {
    }

    @Override
    public void onAppCreated(AppDiag appDiag) {
        LifecycleCodec lifecycleCodec = (LifecycleCodec)this.probeSystemServices.borrowCodec();
        lifecycleCodec.encodeAppCreated(appDiag);
        this.probeSystemServices.releaseCodec(lifecycleCodec);
    }

    @Override
    public void onAppDisposed(AppDiag appDiag) {
        LifecycleCodec lifecycleCodec = (LifecycleCodec)this.probeSystemServices.borrowCodec();
        lifecycleCodec.encodeAppDisposed(appDiag);
        this.probeSystemServices.releaseCodec(lifecycleCodec);
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

