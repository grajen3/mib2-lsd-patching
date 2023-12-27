/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy$4;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncGenericReplyProxy
implements ASIHMISyncGenericReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.generic.ASIHMISyncGeneric");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncGenericReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8194babf-6beb-418f-bd90-f74b3c21802b", -1, "a72d3c71-2310-5bc0-8a73-f82f260b9d4e", "asi.hmisync.generic.ASIHMISyncGeneric");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void sendDataFromUnit(GenericPacket genericPacket) {
        ASIHMISyncGenericReplyProxy$1 aSIHMISyncGenericReplyProxy$1 = new ASIHMISyncGenericReplyProxy$1(this, genericPacket);
        this.proxy.remoteCallMethod((short)3, aSIHMISyncGenericReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncGenericReplyProxy$2 aSIHMISyncGenericReplyProxy$2 = new ASIHMISyncGenericReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncGenericReplyProxy$2);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncGenericReplyProxy$3 aSIHMISyncGenericReplyProxy$3 = new ASIHMISyncGenericReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncGenericReplyProxy$3);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncGenericReplyProxy$4 aSIHMISyncGenericReplyProxy$4 = new ASIHMISyncGenericReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncGenericReplyProxy$4);
    }
}

