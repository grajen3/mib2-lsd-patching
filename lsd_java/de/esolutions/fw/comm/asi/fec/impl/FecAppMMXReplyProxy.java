/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecAppMMXReply;
import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy$1;
import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy$2;
import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy$3;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class FecAppMMXReplyProxy
implements FecAppMMXReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecAppMMX");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public FecAppMMXReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3a7a576a-0b38-45fc-9ad4-1eab302e4f5b", -1, "25185772-f55e-575f-a737-9ae88d532512", "asi.fec.FecAppMMX");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void reportError(int n) {
        FecAppMMXReplyProxy$1 fecAppMMXReplyProxy$1 = new FecAppMMXReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)3, fecAppMMXReplyProxy$1);
    }

    @Override
    public void updateFECs(SFecState[] sFecStateArray) {
        FecAppMMXReplyProxy$2 fecAppMMXReplyProxy$2 = new FecAppMMXReplyProxy$2(this, sFecStateArray);
        this.proxy.remoteCallMethod((short)8, fecAppMMXReplyProxy$2);
    }

    @Override
    public void checkPkgSignature(String string, boolean bl) {
        FecAppMMXReplyProxy$3 fecAppMMXReplyProxy$3 = new FecAppMMXReplyProxy$3(this, string, bl);
        this.proxy.remoteCallMethod((short)1, fecAppMMXReplyProxy$3);
    }
}

