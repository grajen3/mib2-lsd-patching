/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SwdlDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2SwdlDiagServiceReplyProxy
implements MMX2SwdlDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SwdlDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2SwdlDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("26548633-0750-4d14-a851-46e73b79a1c8", -1, "ab446ad8-f728-5ed0-a70c-e5dcfab87f63", "asi.diagnosis.mmx2app.MMX2SwdlDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestModuleVersionNumbers(long l) {
        MMX2SwdlDiagServiceReplyProxy$1 mMX2SwdlDiagServiceReplyProxy$1 = new MMX2SwdlDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2SwdlDiagServiceReplyProxy$1);
    }
}

