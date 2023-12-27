/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericReplyProxy$3;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarGenericReplyProxy
implements ASIHMISyncCarGenericReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.ASIHMISyncCarGeneric");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarGenericReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4bec9bb4-6e17-4b7b-80ff-a9b336700c76", -1, "0455eeb3-67d3-5538-a0cf-8ec326f2a00e", "asi.hmisync.car.ASIHMISyncCarGeneric");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarGenericReplyProxy$1 aSIHMISyncCarGenericReplyProxy$1 = new ASIHMISyncCarGenericReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)6, aSIHMISyncCarGenericReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarGenericReplyProxy$2 aSIHMISyncCarGenericReplyProxy$2 = new ASIHMISyncCarGenericReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarGenericReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarGenericReplyProxy$3 aSIHMISyncCarGenericReplyProxy$3 = new ASIHMISyncCarGenericReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncCarGenericReplyProxy$3);
    }
}

