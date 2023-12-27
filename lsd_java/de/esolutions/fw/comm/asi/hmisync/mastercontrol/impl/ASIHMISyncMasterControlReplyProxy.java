/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncMasterControlReplyProxy
implements ASIHMISyncMasterControlReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncMasterControlReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("02954bb2-63fb-44a0-b50d-cb235060c4b6", -1, "e4f36342-c71e-54be-b822-4a56b5d0a9a1", "asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void factoryReset() {
        ASIHMISyncMasterControlReplyProxy$1 aSIHMISyncMasterControlReplyProxy$1 = new ASIHMISyncMasterControlReplyProxy$1(this);
        this.proxy.remoteCallMethod((short)4, aSIHMISyncMasterControlReplyProxy$1);
    }

    @Override
    public void enterAppContext(int n, String string) {
        ASIHMISyncMasterControlReplyProxy$2 aSIHMISyncMasterControlReplyProxy$2 = new ASIHMISyncMasterControlReplyProxy$2(this, n, string);
        this.proxy.remoteCallMethod((short)3, aSIHMISyncMasterControlReplyProxy$2);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$3 aSIHMISyncMasterControlReplyProxy$3 = new ASIHMISyncMasterControlReplyProxy$3(this, string, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncMasterControlReplyProxy$3);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$4 aSIHMISyncMasterControlReplyProxy$4 = new ASIHMISyncMasterControlReplyProxy$4(this, sArray, bl);
        this.proxy.remoteCallMethod((short)14, aSIHMISyncMasterControlReplyProxy$4);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$5 aSIHMISyncMasterControlReplyProxy$5 = new ASIHMISyncMasterControlReplyProxy$5(this, sArray, bl);
        this.proxy.remoteCallMethod((short)13, aSIHMISyncMasterControlReplyProxy$5);
    }

    @Override
    public void updateHUVersion(String string, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$6 aSIHMISyncMasterControlReplyProxy$6 = new ASIHMISyncMasterControlReplyProxy$6(this, string, bl);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncMasterControlReplyProxy$6);
    }

    @Override
    public void updateVIN(String string, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$7 aSIHMISyncMasterControlReplyProxy$7 = new ASIHMISyncMasterControlReplyProxy$7(this, string, bl);
        this.proxy.remoteCallMethod((short)12, aSIHMISyncMasterControlReplyProxy$7);
    }

    @Override
    public void updateLockState(int n, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$8 aSIHMISyncMasterControlReplyProxy$8 = new ASIHMISyncMasterControlReplyProxy$8(this, n, bl);
        this.proxy.remoteCallMethod((short)11, aSIHMISyncMasterControlReplyProxy$8);
    }

    @Override
    public void updateBlockState(int n, boolean bl) {
        ASIHMISyncMasterControlReplyProxy$9 aSIHMISyncMasterControlReplyProxy$9 = new ASIHMISyncMasterControlReplyProxy$9(this, n, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncMasterControlReplyProxy$9);
    }
}

