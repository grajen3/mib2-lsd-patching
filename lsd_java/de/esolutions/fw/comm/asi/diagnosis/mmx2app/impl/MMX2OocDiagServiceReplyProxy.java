/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2OocDiagServiceReplyProxy
implements MMX2OocDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OocDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2OocDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("04ffae27-a8b4-4847-ae17-d9c692c6e219", -1, "70c9dba5-1723-5b89-8b9c-0e21ad580cf1", "asi.diagnosis.mmx2app.MMX2OocDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestTemperatureMMX(long l) {
        MMX2OocDiagServiceReplyProxy$1 mMX2OocDiagServiceReplyProxy$1 = new MMX2OocDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2OocDiagServiceReplyProxy$1);
    }

    @Override
    public void requestDeleteMemory(long l, int n) {
        MMX2OocDiagServiceReplyProxy$2 mMX2OocDiagServiceReplyProxy$2 = new MMX2OocDiagServiceReplyProxy$2(this, l, n);
        this.proxy.remoteCallMethod((short)4, mMX2OocDiagServiceReplyProxy$2);
    }
}

