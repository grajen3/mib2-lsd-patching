/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy$1;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy$2;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy$3;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy$4;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class NCFSProviderReplyProxy
implements NCFSProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.ncfs.NCFSProvider");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public NCFSProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7114efbf-e1b7-4c0f-a8ef-4e4718806d54", -1, "45c3e4f9-004e-561f-92cf-4451d9da24ab", "asi.navigation.ncfs.NCFSProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateVZOTileIndexes(int[] nArray, sBoundingBox sBoundingBox2, int n) {
        NCFSProviderReplyProxy$1 nCFSProviderReplyProxy$1 = new NCFSProviderReplyProxy$1(this, nArray, sBoundingBox2, n);
        this.proxy.remoteCallMethod((short)5, nCFSProviderReplyProxy$1);
    }

    @Override
    public void updateVZORestrictions(sTileInfo[] sTileInfoArray, sEdge[] sEdgeArray, sRestriction[] sRestrictionArray, int n) {
        NCFSProviderReplyProxy$2 nCFSProviderReplyProxy$2 = new NCFSProviderReplyProxy$2(this, sTileInfoArray, sEdgeArray, sRestrictionArray, n);
        this.proxy.remoteCallMethod((short)16, nCFSProviderReplyProxy$2);
    }

    @Override
    public void updateLGITileIndexes(int[] nArray, sBoundingBox sBoundingBox2, int n) {
        NCFSProviderReplyProxy$3 nCFSProviderReplyProxy$3 = new NCFSProviderReplyProxy$3(this, nArray, sBoundingBox2, n);
        this.proxy.remoteCallMethod((short)3, nCFSProviderReplyProxy$3);
    }

    @Override
    public void updateLGIEvents(sTileInfo[] sTileInfoArray, sLGIEvent[] sLGIEventArray, int n) {
        NCFSProviderReplyProxy$4 nCFSProviderReplyProxy$4 = new NCFSProviderReplyProxy$4(this, sTileInfoArray, sLGIEventArray, n);
        this.proxy.remoteCallMethod((short)15, nCFSProviderReplyProxy$4);
    }
}

