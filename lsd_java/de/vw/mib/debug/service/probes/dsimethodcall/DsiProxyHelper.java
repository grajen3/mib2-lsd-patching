/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.dsimethodcall;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyDebugInterceptorAdapter;
import de.vw.mib.debug.service.probes.dsimethodcall.DsiMethodCallCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class DsiProxyHelper
extends DSIProxyDebugInterceptorAdapter {
    private ProbeSystemServices probeSystemServices;

    public DsiProxyHelper(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void invokeListenerMethodAdapter(String string, int n, Object[] objectArray) {
        DsiMethodCallCodec dsiMethodCallCodec = (DsiMethodCallCodec)this.probeSystemServices.borrowCodec();
        dsiMethodCallCodec.encodeListenerMethodAdapterInvoke(string, n, objectArray);
        this.probeSystemServices.releaseCodec(dsiMethodCallCodec);
    }

    @Override
    public void invokeNotificationListener(int n, int n2, int n3, Object[] objectArray) {
        DsiMethodCallCodec dsiMethodCallCodec = (DsiMethodCallCodec)this.probeSystemServices.borrowCodec();
        dsiMethodCallCodec.encodeNotificationListenerInvoke(n, n2, n3, objectArray);
        this.probeSystemServices.releaseCodec(dsiMethodCallCodec);
    }

    @Override
    public void invokeResponseListener(int n, int n2, int n3, Object[] objectArray) {
        DsiMethodCallCodec dsiMethodCallCodec = (DsiMethodCallCodec)this.probeSystemServices.borrowCodec();
        dsiMethodCallCodec.encodeResponseListenerInvoke(n, n2, n3, objectArray);
        this.probeSystemServices.releaseCodec(dsiMethodCallCodec);
    }

    @Override
    public void invokeService(int n, int n2, int n3, int n4, Object[] objectArray) {
        DsiMethodCallCodec dsiMethodCallCodec = (DsiMethodCallCodec)this.probeSystemServices.borrowCodec();
        dsiMethodCallCodec.encodeServiceInvoke(n, n2, n3, n4, objectArray);
        this.probeSystemServices.releaseCodec(dsiMethodCallCodec);
    }
}

