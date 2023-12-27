/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationReply;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$1;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$2;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$3;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$4;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$5;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$6;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy$7;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class IOocApplicationReplyProxy
implements IOocApplicationReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.ooc.app.IOocApplication");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public IOocApplicationReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("41a9d241-c39d-4427-aafb-b8d8cb9db3a5", -1, "60a20cee-c632-5bc3-8a99-ef22ee11b8a8", "asi.ooc.app.IOocApplication");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updatePowerState(long l) {
        IOocApplicationReplyProxy$1 iOocApplicationReplyProxy$1 = new IOocApplicationReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)5, iOocApplicationReplyProxy$1);
    }

    @Override
    public void updateShutdownRequest(int n) {
        IOocApplicationReplyProxy$2 iOocApplicationReplyProxy$2 = new IOocApplicationReplyProxy$2(this, n);
        this.proxy.remoteCallMethod((short)6, iOocApplicationReplyProxy$2);
    }

    @Override
    public void updateClampSignal(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        IOocApplicationReplyProxy$3 iOocApplicationReplyProxy$3 = new IOocApplicationReplyProxy$3(this, bl, bl2, bl3, bl4);
        this.proxy.remoteCallMethod((short)4, iOocApplicationReplyProxy$3);
    }

    @Override
    public void updateVoltageLevel(int n) {
        IOocApplicationReplyProxy$4 iOocApplicationReplyProxy$4 = new IOocApplicationReplyProxy$4(this, n);
        this.proxy.remoteCallMethod((short)7, iOocApplicationReplyProxy$4);
    }

    @Override
    public void updateRunMode(int n) {
        IOocApplicationReplyProxy$5 iOocApplicationReplyProxy$5 = new IOocApplicationReplyProxy$5(this, n);
        this.proxy.remoteCallMethod((short)10, iOocApplicationReplyProxy$5);
    }

    @Override
    public void updateCarLockSignal(boolean bl) {
        IOocApplicationReplyProxy$6 iOocApplicationReplyProxy$6 = new IOocApplicationReplyProxy$6(this, bl);
        this.proxy.remoteCallMethod((short)12, iOocApplicationReplyProxy$6);
    }

    @Override
    public void updatePowerOnPinStatus(boolean bl) {
        IOocApplicationReplyProxy$7 iOocApplicationReplyProxy$7 = new IOocApplicationReplyProxy$7(this, bl);
        this.proxy.remoteCallMethod((short)13, iOocApplicationReplyProxy$7);
    }
}

