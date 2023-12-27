/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy$1;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy$2;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy$3;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class EsoPosProviderFullReplyProxy
implements EsoPosProviderFullReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.esoposproviderfull.EsoPosProviderFull");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public EsoPosProviderFullReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4325a74a-4251-11e3-9bb9-000c29e68a4a", -1, "995a4140-c7f3-5205-8335-d13059867b08", "asi.navigation.esoposproviderfull.EsoPosProviderFull");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateState(boolean bl, sConfig sConfig2, int n) {
        EsoPosProviderFullReplyProxy$1 esoPosProviderFullReplyProxy$1 = new EsoPosProviderFullReplyProxy$1(this, bl, sConfig2, n);
        this.proxy.remoteCallMethod((short)21, esoPosProviderFullReplyProxy$1);
    }

    @Override
    public void updatePosition(String[] stringArray, sMapPosition sMapPosition2, sPosition[] sPositionArray) {
        EsoPosProviderFullReplyProxy$2 esoPosProviderFullReplyProxy$2 = new EsoPosProviderFullReplyProxy$2(this, stringArray, sMapPosition2, sPositionArray);
        this.proxy.remoteCallMethod((short)25, esoPosProviderFullReplyProxy$2);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        EsoPosProviderFullReplyProxy$3 esoPosProviderFullReplyProxy$3 = new EsoPosProviderFullReplyProxy$3(this, string, bl);
        this.proxy.remoteCallMethod((short)19, esoPosProviderFullReplyProxy$3);
    }
}

