/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyProxy$6;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncCarZeroEmissionReplyProxy
implements ASIHMISyncCarZeroEmissionReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncCarZeroEmissionReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("83464154-9032-473d-b4c8-2dac866dcb2a", -1, "49028b78-c4f4-5526-896b-c466f65870bd", "asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncCarZeroEmissionReplyProxy$1 aSIHMISyncCarZeroEmissionReplyProxy$1 = new ASIHMISyncCarZeroEmissionReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)6, aSIHMISyncCarZeroEmissionReplyProxy$1);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarZeroEmissionReplyProxy$2 aSIHMISyncCarZeroEmissionReplyProxy$2 = new ASIHMISyncCarZeroEmissionReplyProxy$2(this, sArray, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncCarZeroEmissionReplyProxy$2);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncCarZeroEmissionReplyProxy$3 aSIHMISyncCarZeroEmissionReplyProxy$3 = new ASIHMISyncCarZeroEmissionReplyProxy$3(this, sArray, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncCarZeroEmissionReplyProxy$3);
    }

    @Override
    public void updateZEVisibilityState(int n, boolean bl) {
        ASIHMISyncCarZeroEmissionReplyProxy$4 aSIHMISyncCarZeroEmissionReplyProxy$4 = new ASIHMISyncCarZeroEmissionReplyProxy$4(this, n, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncCarZeroEmissionReplyProxy$4);
    }

    @Override
    public void updateZeroEmissionValues(ZeroEmissionEntry[] zeroEmissionEntryArray, boolean bl) {
        ASIHMISyncCarZeroEmissionReplyProxy$5 aSIHMISyncCarZeroEmissionReplyProxy$5 = new ASIHMISyncCarZeroEmissionReplyProxy$5(this, zeroEmissionEntryArray, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncCarZeroEmissionReplyProxy$5);
    }

    @Override
    public void updateCurrentZeroEmissionValue(ZeroEmissionEntry zeroEmissionEntry, boolean bl) {
        ASIHMISyncCarZeroEmissionReplyProxy$6 aSIHMISyncCarZeroEmissionReplyProxy$6 = new ASIHMISyncCarZeroEmissionReplyProxy$6(this, zeroEmissionEntry, bl);
        this.proxy.remoteCallMethod((short)7, aSIHMISyncCarZeroEmissionReplyProxy$6);
    }
}

