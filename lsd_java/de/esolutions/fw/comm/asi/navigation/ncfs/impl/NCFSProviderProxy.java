/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProvider;
import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderC;
import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderProxy$1;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderProxy$2;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyService;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class NCFSProviderProxy
implements NCFSProvider,
NCFSProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.ncfs.NCFSProvider");
    private Proxy proxy;

    public NCFSProviderProxy(int n, NCFSProviderReply nCFSProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("93230d7c-f001-4f4e-b59b-75d947a01065", n, "6e1126d6-ac37-5862-92a7-b77a9a12ac7d", "asi.navigation.ncfs.NCFSProvider");
        NCFSProviderReplyService nCFSProviderReplyService = new NCFSProviderReplyService(nCFSProviderReply);
        this.proxy = new Proxy(serviceInstanceID, nCFSProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestVZORestrictions(sBoundingBox sBoundingBox2) {
        NCFSProviderProxy$1 nCFSProviderProxy$1 = new NCFSProviderProxy$1(this, sBoundingBox2);
        this.proxy.remoteCallMethod((short)1, nCFSProviderProxy$1);
    }

    @Override
    public void requestLGI(sBoundingBox sBoundingBox2) {
        NCFSProviderProxy$2 nCFSProviderProxy$2 = new NCFSProviderProxy$2(this, sBoundingBox2);
        this.proxy.remoteCallMethod((short)0, nCFSProviderProxy$2);
    }
}

