/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceReply;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.License;
import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ExtOnlineCoreServiceReplyProxy
implements ExtOnlineCoreServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.online.coreservice.ExtOnlineCoreService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ExtOnlineCoreServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5bb8eff1-90a0-11e2-9e96-0800200c9a66", -1, "e8f13a10-b3e8-5e7b-94a2-7726966f3488", "asi.online.coreservice.ExtOnlineCoreService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void initResponse(int n) {
        ExtOnlineCoreServiceReplyProxy$1 extOnlineCoreServiceReplyProxy$1 = new ExtOnlineCoreServiceReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)5, extOnlineCoreServiceReplyProxy$1);
    }

    @Override
    public void enableApplication() {
        ExtOnlineCoreServiceReplyProxy$2 extOnlineCoreServiceReplyProxy$2 = new ExtOnlineCoreServiceReplyProxy$2(this);
        this.proxy.remoteCallMethod((short)2, extOnlineCoreServiceReplyProxy$2);
    }

    @Override
    public void disableApplication() {
        ExtOnlineCoreServiceReplyProxy$3 extOnlineCoreServiceReplyProxy$3 = new ExtOnlineCoreServiceReplyProxy$3(this);
        this.proxy.remoteCallMethod((short)1, extOnlineCoreServiceReplyProxy$3);
    }

    @Override
    public void onlineResponse(int n, KeyValPair[] keyValPairArray) {
        ExtOnlineCoreServiceReplyProxy$4 extOnlineCoreServiceReplyProxy$4 = new ExtOnlineCoreServiceReplyProxy$4(this, n, keyValPairArray);
        this.proxy.remoteCallMethod((short)7, extOnlineCoreServiceReplyProxy$4);
    }

    @Override
    public void dataResponse(int n, byte[] byArray) {
        ExtOnlineCoreServiceReplyProxy$5 extOnlineCoreServiceReplyProxy$5 = new ExtOnlineCoreServiceReplyProxy$5(this, n, byArray);
        this.proxy.remoteCallMethod((short)8, extOnlineCoreServiceReplyProxy$5);
    }

    @Override
    public void finalResponse(int n, Result result) {
        ExtOnlineCoreServiceReplyProxy$6 extOnlineCoreServiceReplyProxy$6 = new ExtOnlineCoreServiceReplyProxy$6(this, n, result);
        this.proxy.remoteCallMethod((short)3, extOnlineCoreServiceReplyProxy$6);
    }

    @Override
    public void keyStoreChanged() {
        ExtOnlineCoreServiceReplyProxy$7 extOnlineCoreServiceReplyProxy$7 = new ExtOnlineCoreServiceReplyProxy$7(this);
        this.proxy.remoteCallMethod((short)13, extOnlineCoreServiceReplyProxy$7);
    }

    @Override
    public void updateCredentials(int n, int n2, String string, String string2, String string3) {
        ExtOnlineCoreServiceReplyProxy$8 extOnlineCoreServiceReplyProxy$8 = new ExtOnlineCoreServiceReplyProxy$8(this, n, n2, string, string2, string3);
        this.proxy.remoteCallMethod((short)17, extOnlineCoreServiceReplyProxy$8);
    }

    @Override
    public void updateLicense(int n, License[] licenseArray) {
        ExtOnlineCoreServiceReplyProxy$9 extOnlineCoreServiceReplyProxy$9 = new ExtOnlineCoreServiceReplyProxy$9(this, n, licenseArray);
        this.proxy.remoteCallMethod((short)18, extOnlineCoreServiceReplyProxy$9);
    }
}

