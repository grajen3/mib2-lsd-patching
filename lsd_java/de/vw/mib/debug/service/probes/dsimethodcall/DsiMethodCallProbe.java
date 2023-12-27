/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.dsimethodcall;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAPI;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.debug.service.probes.dsimethodcall.DsiMethodCallCodec;
import de.vw.mib.debug.service.probes.dsimethodcall.DsiProxyHelper;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class DsiMethodCallProbe
extends AbstractDebugProbe {
    private DsiProxyHelper helper;
    private DSIProxy dsiProxy;

    public DsiMethodCallProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    protected AbstractProbeCodec createCodec(ProbeSystemServices probeSystemServices) {
        return new DsiMethodCallCodec(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        DSIProxy dSIProxy;
        this.helper = new DsiProxyHelper(this.probeSystemServices);
        DSIProxyAPI dSIProxyAPI = DSIProxyFactory.getDSIProxyAPI();
        if (dSIProxyAPI != null && (dSIProxy = dSIProxyAPI.getDSIProxy()) != null) {
            this.dsiProxy = dSIProxy;
            return true;
        }
        return false;
    }

    @Override
    protected boolean deactivateProbe() {
        this.dsiProxy.removeDebugInterceptor(this.helper);
        return true;
    }

    @Override
    protected boolean activateProbe() {
        if (this.dsiProxy == null) {
            return false;
        }
        this.dsiProxy.addDebugInterceptor(this.helper);
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
}

