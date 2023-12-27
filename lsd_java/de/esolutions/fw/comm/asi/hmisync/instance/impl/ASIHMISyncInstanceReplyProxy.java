/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.instance.impl.ASIHMISyncInstanceReplyProxy$4;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncInstanceReplyProxy
implements ASIHMISyncInstanceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.instance.ASIHMISyncInstance");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncInstanceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("33835c21-9cd6-4b66-a078-9209b43a1b61", -1, "15181a2f-42ba-55da-a0d1-172a25018685", "asi.hmisync.instance.ASIHMISyncInstance");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseInstanceId(String string, String string2, int n, int n2) {
        ASIHMISyncInstanceReplyProxy$1 aSIHMISyncInstanceReplyProxy$1 = new ASIHMISyncInstanceReplyProxy$1(this, string, string2, n, n2);
        this.proxy.remoteCallMethod((short)4, aSIHMISyncInstanceReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncInstanceReplyProxy$2 aSIHMISyncInstanceReplyProxy$2 = new ASIHMISyncInstanceReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncInstanceReplyProxy$2);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncInstanceReplyProxy$3 aSIHMISyncInstanceReplyProxy$3 = new ASIHMISyncInstanceReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncInstanceReplyProxy$3);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncInstanceReplyProxy$4 aSIHMISyncInstanceReplyProxy$4 = new ASIHMISyncInstanceReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncInstanceReplyProxy$4);
    }
}

