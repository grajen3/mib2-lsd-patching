/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecClient;
import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.FecClientProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class FecClientProxy
implements FecClient {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecClient");
    private Proxy proxy;

    public FecClientProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ff733e4d-6e39-49b8-b354-ee9c22f6cfc9", n, "41fc1271-3ffd-552d-a498-7d1f105d825a", "asi.fec.FecClient");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateFECs(SFecState[] sFecStateArray) {
        FecClientProxy$1 fecClientProxy$1 = new FecClientProxy$1(this, sFecStateArray);
        this.proxy.remoteCallMethod((short)1, fecClientProxy$1);
    }
}

